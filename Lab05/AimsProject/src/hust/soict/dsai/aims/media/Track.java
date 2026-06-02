package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private int length;
	private String title;
	
	public Track() {
		super();
	}

	public Track(int length, String title) {
		super();
		this.title = title;
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public String getTitle() {
		return title;
	}
	
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Track)) {
            return false;
        }
        Track other = (Track) obj;

        if (this.getTitle() == null) {
            return other.getTitle() == null;
        }
        
        return this.getTitle().equals(other.getTitle()) && this.getLength() == other.getLength();
    }

	@Override
	public String toString() {
		return "Track - Title: " + this.getTitle() + ", Length: " + this.getLength();
	}
}
