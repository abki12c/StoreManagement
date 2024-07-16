public class Order extends SaleOrder {
	//variables
	private String status;
	public static int codes = 0;
	private String orderDate;
	private String arriveDate;
	private int orderCode;

	//constructor
	public Order(String name,double price, int productCode,int phone, String customerName,String orderDate,String arriveDate) {
		super(name,price,productCode,phone,customerName);
		this.orderDate = orderDate;
		this.arriveDate =  arriveDate;
		this.setStatus("EXPECTED");
		this.orderCode=nextCode();
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public int nextCode(){
		Order.codes+=1;
		return Order.codes;
	}


	public String getArriveDate() {
		return arriveDate;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getStatus() {
		return this.status;
	}
	public int getOrderCode() {
		return orderCode;
	}

	@Override
	public String toString() {
		return "Product Name: "+this.getName()+ "\n" + "Order code: " + this.getOrderCode()+ "\n" + "Product code: " + super.getCode() +"\n" + "Price: "+this.getPrice()+"$"+ "\n" + "Order date: "+this.getOrderDate()+ "\n" + "Arrival Date: "+this.getArriveDate() + "\n" + "Status: " + this.getStatus() ;
	}
}
