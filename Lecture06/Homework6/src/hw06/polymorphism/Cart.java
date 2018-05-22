package hw06.polymorphism;

public class Cart {
	final static int MAX_ITEM = 100;//max item limit
	private Item items[];//array of Item
	private String buyerName;
	private int itemNum;

	
	/**
	 * Constructor
	 * @param buyerName name of the buyer
	 */
	Cart(String buyerName) {
		this.buyerName = buyerName;
		items = new Item[MAX_ITEM];	//create array size of MAX_ITEM
		itemNum = 0;
	}

	/**
	 * Get item has the index from 0..itemNum - 1
	 * @param idx 	index of items
	 * @return Item of placed index
	 */
	public Item getItem(int idx) {
		if (idx < itemNum) {
			return items[idx];
		} else {
			return null;
		}
	}

	/**
	 * Get total item in cart
	 * @return total number
	 */
	public int getTotal() {
		return itemNum;
	}


	/**
	 * Add item into cart
	 * @param i item
	 * @return true if successful
	 */
	public boolean addItem(Item i) {
		if (itemNum < MAX_ITEM) {
			items[itemNum] = i;
			itemNum++;
			return true;
		} else  {
			return false;
		}
	}

	/**
	 * Print the list of item and price to screen
	 * STUDENT MUST IMPLEMENT THIS METHOD
	 */
	public void printReceipt() {
		int total=0;
		System.out.println("Receipt:");
		System.out.println("Buyer: "+buyerName);
		System.out.println("-----------------------------------------------");
		for(int i=0;i<getTotal();i++) {
			System.out.println(String.format("%d. %-30s %,d W"
					,i+1,getItem(i).getInfo(),getItem(i).getSalePrice()));
			total+=getItem(i).getSalePrice();
		}
		System.out.println("-----------------------------------------------");
		System.out.println(String.format("Total: %,33d W", total));
	}
}