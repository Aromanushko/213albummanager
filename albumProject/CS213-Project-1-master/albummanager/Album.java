package albummanager;
/** 
 * @author Robert Reid, Anthony Romanushko
 * Album object class
 */
public class Album {
	private String title;
	private String artist;
	private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
	private Date releaseDate;
	private boolean isAvailable;
	
	/**
	 * Constructor of Album class
	 * @param title - title of Album 
	 * @param artist - artist of Album 
	 * @param genre - enum genre of Album
	 * @param releaseDate - releaseDate of Album
	 * 
	 */
	public Album (String title, String artist,
			Genre genre, Date releaseDate) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.isAvailable = true;
	
	}
	
	/**
	 * Overloaded constructor for use in searching for albums
	 * @param title title of album
	 * @param artist artist of album
	 */
	public Album(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	/**
	 * Method to compare to albums, albums are equal if the title and artist are the same
	 * @param obj object of any type
	 * @return true if the object is an album that is equal to the target album
	 */
	@Override
	public boolean equals(Object obj) {
		Album balbum; //Create the b album to be compared
		if(obj instanceof Album) {
			//If the object to be compared is an Album then assign it to b album and continue
			balbum = (Album)obj;
		}else {
			return false;
		}
		
		//Compare b album title and artist to this album's title and artist
		if(balbum.getTitle().equals(this.title) && balbum.getArtist().equals(this.artist)) {
			//return true if they are the same
			return true;
		}else {
			//return false if either title or artist differ from this album's
			return false;
		}
	}
	
	/**
	 * Returns string representation of album 
	 */
	@Override
	public String toString() {
		String isavailable;
		if(this.isAvailable == true) {
			isavailable = "is available";
		}else {
			isavailable = "is not available";
		}
		
		return this.title + "::" + this.artist + "::" + this.genre.toString()
				+ "::" + this.releaseDate.toString() + "::" + isavailable;
	}
	
	/**
	 * Sets availability of album
	 * @param avail boolean variable corresponding the availability of the album to be set
	 */
	public void setAvailability(boolean avail) {
		this.isAvailable = avail;
	}
	
	/**
	 * helper method for returning the albums release date
	 * @return the albums release date
	 */
	public Date getDate() {
		return this.releaseDate;
	}
	/**
	 * helper method for returning the albums title
	 * @return the albums title
	 */
	public String getTitle() { 
		return this.title; 
		}
	
	/**
	 * helper method for returning the albums artist
	 * @return the albums artist
	 */
	public String getArtist() { 
		return this.artist; 
		}
	
	/**
	 * helper method for returning the albums genre
	 * @return the albums genre
	 */
	public Genre getGenre()	{ 
		return this.genre; 
		}

	/**
	 * helper method for returning the albums availability
	 * @return the albums availability 
	 */
	public boolean getAvailability()	{ 
		return this.isAvailable; 
		}
}