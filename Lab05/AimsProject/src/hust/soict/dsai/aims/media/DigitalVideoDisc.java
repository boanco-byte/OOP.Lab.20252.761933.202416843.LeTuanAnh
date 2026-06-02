package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	

	private String director;
	private int length;
	private static int nbDigitalVideoDiscs = 0;
	
	public static void main(String[] args) {
		

	}
	
	public DigitalVideoDisc(String title) {
		super(title);
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
		super(title, category, cost);
		nbDigitalVideoDiscs++;
		setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
		super(title, category, cost, director);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }
    
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost, length, director);
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
	}
	
	public boolean isMatch(String title) {
	    String currentTitle = getTitle();
	    return currentTitle != null && title != null
	            && currentTitle.toLowerCase().contains(title.toLowerCase());
	}
	
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	@Override
	public String toString() {
		return "DVD - ID: " + this.getId() + ", Title: " + this.getTitle() + ", Category: " + this.getCategory() + ", Cost: " + this.getCost() + ", Director: " + this.getDirector() + ", Length: " + this.getLength();
	}

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
