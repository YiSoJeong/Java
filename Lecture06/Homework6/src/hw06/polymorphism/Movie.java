package hw06.polymorphism;

public class Movie extends Item{
	private String cdTitle;
	private int pubYear;
	
	public Movie() {
		super();
	}

	public Movie(String itemID, int importprice, String cdTitle, int pubYear) {
		super(itemID, importprice);
		this.cdTitle = cdTitle;
		this.pubYear = pubYear;
	}

	public String getCdTitle() {
		return cdTitle;
	}

	public void setCdTitle(String cdTitle) {
		this.cdTitle = cdTitle;
	}

	public int getPubYear() {
		return pubYear;
	}

	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}

	@Override
	public int getSalePrice() {
		if(2018-getPubYear() <= 1) {
			return (int) (2.0*getImportprice());
		}
		else
			return (int) (0.5*getImportprice());
	}

	@Override
	String getInfo() {
		return getCdTitle();
	}	
	
}
