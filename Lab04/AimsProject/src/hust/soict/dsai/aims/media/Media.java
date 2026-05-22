package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;

	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public Media(String title) {
		super();
		this.title = title;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Media)) {
            return false;
        }
        Media other = (Media) obj;

        if (this.getTitle() == null) {
            return other.getTitle() == null;
        }
        
        return this.getTitle().equals(other.getTitle());
    }

	@Override
	public String toString() {
		return "Media - ID: " + this.getId() + ", Title: " + this.getTitle() + ", Category: " + this.getCategory() + ", Cost: " + this.getCost();
	}

	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new Comparator<Media>() {
		@Override
		public int compare(Media m1, Media m2) {
			int titleComparison = m1.getTitle().compareTo(m2.getTitle());
			if (titleComparison != 0) {
				return titleComparison;
			}
			return Float.compare(m1.getCost(), m2.getCost());
		}
	};
	
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new Comparator<Media>() {
		@Override
		public int compare(Media m1, Media m2) {
			int costComparison = Float.compare(m1.getCost(), m2.getCost());
			if (costComparison != 0) {
				return costComparison;
			}
			return m1.getTitle().compareTo(m2.getTitle());
		}
	};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
}
