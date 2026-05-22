package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	}

	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("Da ton tai tac gia");
			return;
		}
		
		authors.add(authorName);
		System.out.println("Da them tac gia");
	}
	
	public void removeAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			System.out.println("Khong ton tai tac gia");
			return;
		}
		
		authors.remove(authorName);
		System.out.println("Da xoa tac gia");
	}

	@Override
	public String toString() {
		return "Book - ID: " + this.getId() + ", Title: " + this.getTitle() + ", Category: " + this.getCategory() + ", Cost: " + this.getCost() + ", Authors: " + String.join(", ", authors);
	}

}
