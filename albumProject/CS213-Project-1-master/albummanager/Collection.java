package albummanager;
/**
 * 
 * @author Robert Reid, Anthony Romanushko
 * Collection class is an array of album objects
 */
public class Collection {
	private Album[] albums = new Album[4];
	private int numAlbums = 0; //Number of albums currently in collection
	
	/**
	 * searches the collection albums for the target album
	 * @param album to find
	 * @return integer index of album if found, -1 if album is not found
	 */
	private int find(Album album) {
		int index = -1;
		for(int i = 0; i < albums.length; i++) {
			if(albums[i] != null)
			{
				if(album.equals(albums[i])) {
					index = i;
			}
		}
		}
		return index;
	}
	
	/**
	 * Grows the size of albums by 4 
	 */
	private void grow() {
		Album[] t = new Album[albums.length + 4];
		for(int i = 0; i < albums.length; i ++) {
			t[i] = albums[i];
		}
		albums = t;
	}
	
	/**
	 * Adds an album to the collection if it does not exist already
	 * @param album to add to collection
	 * @return true if album is successfully added, false if album already exists in collection
	 */
	public boolean add(Album album) {
		if(find(album) != -1 && numAlbums != 0) 
		{
			return false;
		}
		//Since no index was null we need to grow and repeat the input process
		if(numAlbums == albums.length ) grow();
		albums[numAlbums] = album;
		numAlbums++;
		return true;
	}
	
	/**
	 * Removed an album from the collection if it exists
	 * @param album to remove from collection
	 * @return true if album is successfully removed, false if the album does not exist in collection
	 */
	public boolean remove(Album album) {
		//This for loop checks if the album already exists in the collection
			int index = find(album);
			if(index != -1){
				//Album exists in collection so we move the indexes down
				for(int r = index; r < albums.length - 1; r++) {
					albums[r] = albums[r+1];
				}
				numAlbums--;
				return true;
			}else {
				return false;
			}
	}
	
	/**
	 * Sets album being lent out to not available if it exists in the collection
	 * @param album to lend out
	 * @return false if album does not exist in collection, true if album is successfully set to not available
	 */
	public boolean lendingOut(Album album) {
		//This for loop checks if the album already exists in the collection
				int index = find(album);
				if(index != -1) {
					if(albums[index].getAvailability()) {
						albums[index].setAvailability(false);
						return true;
					}else {
						return false;
					}
				}else {
					return false;
				}
	}
	
	/**
	 * Sets album being returned to available if it exists in the collection
	 * @param album that is being returned
	 * @return false if the album does not exist in the collection, true if album is successfully set to available
	 */
	public boolean returnAlbum(Album album) {
		//This for loop checks if the album already exists in the collection
			int index = find(album);
			if(index != -1) {
				if(!albums[index].getAvailability())
				{
				//sets availability to true if album is found
				albums[index].setAvailability(true);
				return true;
				}
				else
				{
					return false;
				}
			}
			else 
			{
			return false;	
			}
		
	}
	
	/**
	 * Displays the list of albums in the collection without specifying the order
	 */
	public void print() {
		boolean empty = true;
		Album[] talbums = new Album[albums.length];
		for(int y = 0; y < albums.length; y++) {
			talbums[y] = albums[y];
			if(albums[y] != null) empty = false;
		}
		if(empty) {
			System.out.println("This Collection is Empty!");
		}else {
			System.out.println("*List of Albums in the Collection.");
			for(Album x : albums)
			{
				if(x != null) System.out.println(x.toString());
			}
			System.out.println("*End of List.");
		}
	}
	
	/**
	 * Displays the list of albums in the collection ordered by release date
	 */
	public void printByReleaseDate() {
		//Going to use selection sort
		boolean empty = true;
		Album[] talbums = new Album[albums.length];
		for(int y = 0; y < albums.length; y++) {
			talbums[y] = albums[y];
			if(albums[y] != null) empty = false;
		}	
		if(empty) {
			System.out.println("This Collection is Empty!");
		}else {
			int n = talbums.length;
	        for (int i = 0; i < n-1; i++)
	        {// Find the minimum element in unsorted array
	            int min_idx = i;
	            for (int j = i+1; j < n; j++) {
	            	if(talbums[j] != null) {
	            		if (talbums[j].getDate().compareTo(talbums[min_idx].getDate()) < 0)
	                    min_idx = j;
	            	}
	            }
	            Album temp = talbums[min_idx];
	            talbums[min_idx] = talbums[i];
	            talbums[i] = temp;
	        }
	        System.out.println("*Albums by Release Date.");
	        for(int x = 0; x < talbums.length; x++) {
	        	if(talbums[x] != null) System.out.println(talbums[x].toString());
	        }
	        System.out.println("*End of List.");
		}   
	}

	/**
	 * Displays the list of albums in the collection ordered by genre
	 */
	public void printByGenre() {
		boolean empty = true;
		Album[] talbums = new Album[albums.length];
		for(int y = 0; y < albums.length; y++) {
			talbums[y] = albums[y];
			if(albums[y] != null) empty = false;
		}
		if(empty)
		{
			System.out.println("This Collection is Empty!");
		}else {
			System.out.println("*Album Collection by Genre.");
			for(Genre genre : Genre.values())
			{
				for(Album x : albums)
				{
					if(x != null)
						{
						if(x.getGenre().equals(genre))
							{
						 		System.out.println(x.toString());
							}
						}
				}
			}
			System.out.println("*End of List.");
		}
	}
}
