public class Sale extends SaleOrder {
	private static int codes = 0;
	private String saleDate;
	private int saleCode;

	//constructor
	public Sale(String name,double price,int productCode,int customerPhone, String customerName,String saleDate) {
		super(name,price,productCode,customerPhone,customerName);
		this.saleDate = saleDate;
		this.saleCode=nextCode();

	}

	public int nextCode(){
		Sale.codes+=1;
		return Sale.codes;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public int getSaleCode() {
		return saleCode;
	}

	@Override
	public String toString() {
		return "Product Name: "+this.getName()+ "\n" + "Sale code: "+this.getSaleCode()+ "\n"  + "Product code: " + super.getCode() + "\n" + "Price: "+this.getPrice()+"$"+ "\n" + "Date sold: "+this.getSaleDate();
	}


}
