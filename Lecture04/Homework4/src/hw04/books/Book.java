package hw04.books;

public class Book {
	private String title;
	private String[] author;
	private int page;
	private int year;
	
	public Book() {
	}
	
	public Book(String title, String[] author, int page, int year) {		
		this.title = title;
		this.author = author;
		this.page = page;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getAuthor() {
		return author;
	}

	public void setAuthor(String[] author) {
		this.author = author;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		int count = 0;
		String[] s = getAuthor();
		for(int i=0;i<getAuthor().length;i++) {
			if(s[i]!=null)
				count++;
		}

		if(count==1) {
			return getTitle() + " - " + s[0] +" - " + getPage() +"Pages - " + getYear();
		}
		else if(count==2) {
			return getTitle() + " - " + s[0] +  ", " + s[1] +" - " + getPage() +"Pages - " + getYear();
		}
		else if(count==3) {
			return getTitle() + " - " + s[0] +  ", " + s[1] + ", " + s[2] +" - " + getPage() +"Pages - " + getYear();
		}
		else
			return null;
	}
	
}