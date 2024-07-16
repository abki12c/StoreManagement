public class Sale extends SaleOrder {
	private static int codes = 0;
	public String saleDate;

	//constructor
	public Sale(String name,double price,int customerPhone, String customerName,String saleDate) {
		super(name,price,customerPhone,customerName);
		this.saleDate = saleDate;
		this.code=nextCode();

	}

	public int nextCode(){
		Sale.codes+=1;
		return Sale.codes;
	}

	public String getSaleDate() {
		return saleDate;
	}

	@Override
	public String toString() {
		return "Product Name: "+this.getName()+ "\n" + "Code: "+this.getCode()+ "\n" + "Price: "+this.getPrice()+"$"+ "\n" + "Date sold: "+this.getSaleDate();
	}


}
