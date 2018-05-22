package hw04.books;

public class BookShelf {
	private int booksnumber;
	private Book[] book;
	int cnt = 0;
	
	public BookShelf() {}

	public BookShelf(int booksnumber) {
		this.booksnumber = booksnumber; 
		this.book = new Book[booksnumber];
	}

	public int getBooksnumber() {
		return booksnumber;
	}

	public void setBooksnumber(int booksnumber) {
		this.booksnumber = booksnumber;
	}

	public void addBook(Book a) {
		book[cnt] = a;
		cnt++;
	}

	public Book[] searchByTitle(String a) {
		int count = 0;
		
		//count volid books
		for(int i=0;i<cnt;i++) {
			if(book[i].getTitle().contains(a)) {
				count++;
			}
		}
		
		//save valid books
		Book[] result = new Book[count];
		int idx = 0;
		for(int i=0;i<cnt;i++) {
			if(book[i].getTitle().contains(a)) {
				result[idx] = book[i];
				idx++;
			}
		}
		return result;
	}
	
	public Book[] searchByAuthor(String a) {
		int count = 0;
		
		//count valid books
		for(int i=0;i<cnt;i++) {
			String[] s = book[i].getAuthor();
			
			for(int j=0;j<book[i].getAuthor().length;j++) {
				if(s[j]!=null) {
					if(s[j].contains(a))
						count++;
				}
			}
		}

		
		//save valid books
		Book[] result = new Book[count];
		int idx = 0;
		
		for(int i=0;i<cnt;i++) {
			for(int j=0; j<book[i].getAuthor().length; j++) {
				String[] s = book[i].getAuthor();
				
				if(s[j].contains(a)) {
					result[idx] = book[i];
					idx++;
					}
				}
			}
		
		return result;
	}
	
	public Book[] searchByBoth(String a) {
		int count = 0;
		for(int i=0;i<cnt;i++) {
			if(book[i].getTitle().contains(a)) {
				count++;
			}
			else {
				for(int j=0;j<book[i].getAuthor().length;j++) {
					String[] s = book[i].getAuthor();
					if(s[j]!=null) {
						if(s[j].contains(a))
							count++;
					}
				}
			}
		}
		
		Book[] result = new Book[count];
		int idx = 0;
		for(int i=0;i<cnt;i++) {
			if(book[i].getTitle().contains(a)) {
				result[idx] = book[i];
				idx++;
			}
			else {
				for(int j=0; j<book[i].getAuthor().length; j++) {
					String[] s = book[i].getAuthor();
					if(s[j].contains(a)) {
						result[idx] = book[i];
						idx++;
						}
					}
			}
		}
		return result;
		
	}
}
