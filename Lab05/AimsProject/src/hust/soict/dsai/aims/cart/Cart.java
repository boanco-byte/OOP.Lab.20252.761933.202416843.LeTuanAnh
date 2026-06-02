package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
import java.util.Collections;


public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public static final int MAX_NUMBERS_ORDERED = 20;

	public void addMedia(Media media) {
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("Da them vao gio hang");
		} else {
			System.out.println("Gio hang da day");
		}
	}

	public void addMedia(Media[] mediaList) {
		for(Media media : mediaList) {
			addMedia(media);
		}
	}

	public void addMedia(Media media1, Media media2) {
		addMedia(media1);
		addMedia(media2);
	}

	public void removeMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Da xoa khoi gio hang");
		} else {
			System.out.println("Khong tim thay san pham trong gio hang");
		}
	}

	public double totalCost() {
		double total = 0;
		for(Media media : itemsOrdered) {
			total += media.getCost();
		}
		
		return total;
	}

	public void Print() {
		System.out.println("*************** CART ***************");
		System.out.println("Ordered Items:");
		
		for(Media media : itemsOrdered) {
            System.out.printf("ID: %d. %s - %s - %.2f\n", media.getId(), media.getTitle(), media.getCategory(), media.getCost());
		}
		
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
	
	public void searchById(int id) {
	    boolean found = false;

	    for(Media media : itemsOrdered) {
			if(media.getId() == id) {
				System.out.println(media);
				found = true;
				break;
			}
		}

	    if(!found) {
	        System.out.println("Not found.");
	    }
	}
	
	public void searchByTitle(String title) {
	    boolean found = false;

	    for(Media media : itemsOrdered) {
	        if(media.getTitle().equals(title)) {
	            System.out.println(media);
	            found = true;
	        }
	    }

	    if(!found) {
	        System.out.println("Not found.");
	    }
	}

	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void sortByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		System.out.println("Sorted cart by title then cost.");
	}

	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
		System.out.println("Sorted cart by cost then title.");
	}

	public void placeOrder() {
		double total = totalCost();
		itemsOrdered.clear();
		System.out.printf("Order placed. Total cost: %.2f. Thank you!\n", total);
	}
	
	public static void main(String[] args) {
		
	}
}
