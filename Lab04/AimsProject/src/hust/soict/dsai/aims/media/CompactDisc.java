package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

	public String getArtist() {
		return artist;
	}

	public List<Track> getTracks() {
		return tracks;
	}
	
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("Da ton tai track");
			return;
		}
		
		tracks.add(track);
		System.out.println("Da them track");
	}
	
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Da xoa track");
			return;
		}
		
		System.out.println("Khong ton tai track");
	}
	
	@Override
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
	}
	
	@Override
	public int getLength() {
		int totalLength = 0;
		
		for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
	}

	@Override
	public String toString() {
		return "CD - ID: " + this.getId() + ", Title: " + this.getTitle() + ", Category: " + this.getCategory() + ", Cost: " + this.getCost() + ", Director: " + this.getDirector() + ", Artist: " + this.getArtist() + ", Tracks: " + tracks.size();
	}
}
