package hw06.polymorphism;

public class CD extends Item{
	private String cdTitle;
	private String cdArtist;
	private int pubYear;
	
	public CD() {
		super();
	}
	
	public CD(String itemID, int importprice,String cdTitle, String cdArtist, int pubYear) {
		super(itemID, importprice);
		this.cdTitle = cdTitle;
		this.cdArtist = cdArtist;
		this.pubYear = pubYear;
	}

	public String getCdTitle() {
		return cdTitle;
	}

	public void setCdTitle(String cdTitle) {
		this.cdTitle = cdTitle;
	}

	public String getCdArtist() {
		return cdArtist;
	}

	public void setCdArtist(String cdArtist) {
		this.cdArtist = cdArtist;
	}

	public int getPubYear() {
		return pubYear;
	}

	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}

	@Override
	String getInfo() {
		return getCdTitle() + " - " + getCdArtist();
	}
	
	@Override
	public int getSalePrice() {
		if(2018-getPubYear()<=1) {
			return (int) (1.5*getImportprice());
		}
		else if(1<2018-getPubYear() && 2018-getPubYear()<=2) {
			return (int) getImportprice();
		}
		else{
			return (int) (0.7*getImportprice());
		}
	}
	
}
