package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo một vài dữ liệu mẫu cho Cửa hàng (Store)
        initSampleData();

        int choice;
        while (true) {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (choice) {
                case 1: // View store
                    handleViewStore();
                    break;
                case 2: // Update store
                    handleUpdateStore();
                    break;
                case 3: // See current cart
                    handleViewCart();
                    break;
                case 0: // Exit
                    System.out.println("Cảm ơn bạn đã sử dụng ứng dụng AIMS. Tạm biệt!");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại (0-3).");
            }
        }
    }

    // --- CÁC PHƯƠNG THỨC HIỂN THỊ MENU (THEO ĐỀ BÀI) ---
    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    private static void handleViewStore() {
        while (true) {
            store.print();
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // See a media's details
                    System.out.print("Enter the title: ");
                    String title = scanner.nextLine();
                    Media m = store.searchByTitle(title);
                    if (m == null) {
                        System.out.println("Media not found in store.");
                        break;
                    }
                    System.out.println(m);
                    mediaDetailsMenu();
                    int mdChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (mdChoice) {
                        case 1: // Add to cart
                            cart.addMedia(m);
                            break;
                        case 2: // Play
                            if (m instanceof Playable) {
                                ((Playable) m).play();
                            } else {
                                System.out.println("This media cannot be played.");
                            }
                            break;
                        case 0:
                        default:
                            break;
                    }
                    break;
                case 2: // Add a media to cart
                    System.out.print("Enter the title to add to cart: ");
                    String t = scanner.nextLine();
                    Media found = store.searchByTitle(t);
                    if (found != null) cart.addMedia(found);
                    else System.out.println("Not found in store.");
                    break;
                case 3: // Play a media
                    System.out.print("Enter the title to play: ");
                    String pt = scanner.nextLine();
                    Media pm = store.searchByTitle(pt);
                    if (pm != null && pm instanceof Playable) {
                        ((Playable) pm).play();
                    } else {
                        System.out.println("Media not found or not playable.");
                    }
                    break;
                case 4: // See current cart
                    handleViewCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleUpdateStore() {
        while (true) {
            updateStoreMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: // Add a media to store
                    System.out.print("Choose type (1=Book,2=DVD,3=CD): ");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Cost: ");
                    float cost = scanner.nextFloat();
                    scanner.nextLine();
                    if (type == 1) {
                        Book bk = new Book(0, title, category, cost);
                        store.addMedia(bk);
                    } else if (type == 2) {
                        DigitalVideoDisc dvd = new DigitalVideoDisc(category, title, cost);
                        store.addMedia(dvd);
                    } else if (type == 3) {
                        CompactDisc cd = new CompactDisc(0, title, category, cost, 0, "", "");
                        store.addMedia(cd);
                    } else {
                        System.out.println("Invalid type.");
                    }
                    break;
                case 2: // Remove a media from store
                    System.out.print("Enter title to remove: ");
                    String rem = scanner.nextLine();
                    Media rm = store.searchByTitle(rem);
                    if (rm != null) store.removeMedia(rm);
                    else System.out.println("Not found in store.");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleViewCart() {
        while (true) {
            cart.Print();
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: // Filter medias in cart
                    System.out.print("Filter by (1=id,2=title): ");
                    int f = scanner.nextInt();
                    scanner.nextLine();
                    if (f == 1) {
                        System.out.print("Enter id: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        cart.searchById(id);
                    } else if (f == 2) {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        cart.searchByTitle(title);
                    } else System.out.println("Invalid filter.");
                    break;
                case 2: // Sort medias in cart
                    System.out.print("Sort by (1=title,2=cost): ");
                    int s = scanner.nextInt();
                    scanner.nextLine();
                    if (s == 1) {
                        cart.sortByTitleCost();
                    } else if (s == 2) {
                        cart.sortByCostTitle();
                    } else System.out.println("Invalid sort.");
                    break;
                case 3: // Remove media from cart
                    System.out.print("Enter title to remove from cart: ");
                    String rem = scanner.nextLine();
                    // create a Book placeholder to rely on equals by title
                    Book placeholder = new Book(0, rem, "", 0f);
                    cart.removeMedia(placeholder);
                    break;
                case 4: // Play a media
                    System.out.print("Enter title to play: ");
                    String playTitle = scanner.nextLine();
                    boolean played = false;
                    for (Media m : cart.getItemsOrdered()) {
                        if (m.getTitle().equalsIgnoreCase(playTitle) && m instanceof Playable) {
                            ((Playable) m).play();
                            played = true;
                            break;
                        }
                    }
                    if (!played) System.out.println("Not found or not playable in cart.");
                    break;
                case 5: // Place order
                    cart.placeOrder();
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void updateStoreMenu() {
		System.out.println("\nOptions: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media to store");
		System.out.println("2. Remove a media from store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: 0-1-2: ");
	}

	 // Initialize some sample data in the store
    private static void initSampleData() {
		Media[] mediaList = new Media[5];

        Book b1 = new Book(1, "The Alchemist", "Fiction", 10.0f);
        b1.addAuthor("Paulo Coelho");
        mediaList[0] = b1;

        Book b2 = new Book(2, "Clean Code", "Programming", 35.0f);
        b2.addAuthor("Robert C. Martin");
        mediaList[1] = b2;

        DigitalVideoDisc d1 = new DigitalVideoDisc("Drama", "The Shawshank Redemption", 19.99f);
        mediaList[2] = d1;

        DigitalVideoDisc d2 = new DigitalVideoDisc("Action", "The Dark Knight", 17.5f);
        mediaList[3] = d2;

        CompactDisc c1 = new CompactDisc(3, "Hybrid Theory", "Music", 12.5f, 0, "Linkin Park", "Linkin Park");
        mediaList[4] = c1;

        for (Media media : mediaList) {
            store.addMedia(media);
        }
    }
}