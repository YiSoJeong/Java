package hw06.polymorphism;

abstract class Item implements ForSale{
	private String itemID;
	private int importprice;
	
	public Item() {
		super();
	}
	
	public Item(String itemID, int importprice) {
		super();
		this.itemID = itemID;
		this.importprice = importprice;
	}
	
	public String getItemID() {
		return itemID;
	}
	
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	
	public int getImportprice() {
		return importprice;
	}
	
	public void setImportprice(int importprice) {
		this.importprice = importprice;
	}
	
	abstract String getInfo();
}
