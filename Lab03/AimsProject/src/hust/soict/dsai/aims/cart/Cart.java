package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
		}
		else {
			itemOrdered[qtyOrdered] = disc;
			System.out.println("The disc has been added");
			qtyOrdered++;
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		int quan = dvdList.length;
		int cnt;
		
		for(cnt = 0; cnt < quan; cnt++) {
			if(qtyOrdered >= MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is almost full");
				break;
			}
			else {
				itemOrdered[qtyOrdered] = dvdList[cnt];
				System.out.println("The disc has been added");
				qtyOrdered++;
			}
		}
		
		for(; cnt < quan; cnt++) {
			System.out.println("Cannot add " + dvdList[cnt].getTitle());
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
	    addDigitalVideoDisc(dvd1);
	    addDigitalVideoDisc(dvd2);
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int pos = -1;
		
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemOrdered[i].equals(disc)) {
				pos = i;
				break;
			}
		}
		
		if(pos != -1) {
			for(int i = pos; i < qtyOrdered - 1; i++) {
				itemOrdered[i] = itemOrdered[i + 1];
			}
			
			itemOrdered[qtyOrdered - 1] = null;
			qtyOrdered--;
			
			System.out.println("The disc has been removed");
		}
		else {
			System.out.println("Disc not found in the cart");
		}
	}
	
	public double totalCost() {
		double total = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			total += itemOrdered[i].getCost();
		}
		
		return total;
	}

	public void Print() {
		System.out.println("*************** CART ***************");
		System.out.println("Ordered Items:");
		
		for(int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + ". " + itemOrdered[i].toString());
		}
		
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
	
	public void searchById(int id) {
	    boolean found = false;

	    for(int i = 0; i < qtyOrdered; i++) {
	        if(id == itemOrdered[i].getId()) {
	            System.out.println(itemOrdered[i]);
	            found = true;
	        }
	    }

	    if(!found) {
	        System.out.println("Not found.");
	    }
	}
	
	public void searchByTitle(String title) {
	    boolean found = false;

	    for(int i = 0; i < qtyOrdered; i++) {
	        if(itemOrdered[i].isMatch(title)) {
	            System.out.println(itemOrdered[i]);
	            found = true;
	        }
	    }

	    if(!found) {
	        System.out.println("Not found.");
	    }
	}
	
	public static void main(String[] args) {
		
	}
}
