package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestStoreScreen {
    public static void main(String[] args) {
        // 1. Khởi tạo cửa hàng
        Store store = new Store();
        
        // DVD: DigitalVideoDisc(String title, String category, String director, int length, float cost)
        // DVD: DigitalVideoDisc(String title, String category, String director, int length, float cost)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Interstellar", "Science Fiction", 18.99f); // Dùng constructor 3 tham số (title, category, cost)
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 22.50f);

        // Book: Book(int id, String title, String category, float cost)
        Book book1 = new Book(4, "Sherlock Holmes: A Study in Scarlet", "Detective", 15.00f);
        Book book2 = new Book(6, "The Lord of the Rings", "Fantasy", 29.99f);

        // CD: CompactDisc(int id, String title, String category, float cost, int length, String director, String artist)
        CompactDisc cd = new CompactDisc(7, "Random Access Memories", "Electronic", 16.95f, 74, "Daft Punk", "Daft Punk");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(cd);
        store.addMedia(dvd4);
        store.addMedia(book2);

        new StoreScreen(store);
    }
}