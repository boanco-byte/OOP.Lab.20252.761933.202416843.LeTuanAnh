package hust.soict.dsai.aims.screen;


import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestCartScreen {
    public static void main(String[] args) {
        Cart cart = new Cart();
        
        DigitalVideoDisc dvd = new DigitalVideoDisc("DVD1's Title", "Category 1", "Director 1", 120, 18.06f);
        CompactDisc cd = new CompactDisc(0, "CD2's Title", "Category 2", 19.64f, 0, "Unknown", "Various Artists");
        Book book = new Book(3, "Book3's Title", "Category 3", 8.46f);
        Book book2 = new Book(4, "Book4's Title", "Category 4", 12.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("DVD2's Title", "Category 5", "Director 2", 95, 20.00f);

        cart.addMedia(dvd);
        cart.addMedia(cd);
        cart.addMedia(book);
        cart.addMedia(book2);
        cart.addMedia(dvd2);
        new CartScreen(cart);
    }
}