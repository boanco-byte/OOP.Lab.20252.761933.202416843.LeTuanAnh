
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
	
	public static void main(String[] args) {
		
	}
}
