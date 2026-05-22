package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList <Media>();

    public void addMedia(Media media) {
        if(itemsInStore.contains(media)) {
            System.out.println("Da ton tai media");
            return;
        }
        itemsInStore.add(media);
    }

    public void removeMedia(Media media) {
        if(itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Da xoa media");
            return;
        }
        System.out.println("Khong ton tai media");
    }
    
    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Available Items in Store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************");
    }
}