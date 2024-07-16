public class Order extends SaleOrder {
	//variables
	private String status;
	public static int codes = 0;
	public String orderDate;
	public String arriveDate;

	//constructor
	public Order(String name,double price,int phone, String customerName,String orderDate,String arriveDate) {
		super(name,price,phone,customerName);
		this.orderDate = orderDate;
		this.arriveDate =  arriveDate;
		this.setStatus("EXPECTED");
		this.code=nextCode();
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

	@Override
	public String toString() {
		return "Product Name: "+this.getName()+ "\n" + "Code: " + this.getCode()+ "\n" + "Price: "+this.getPrice()+"$"+ "\n" + " Order date: "+this.getOrderDate()+ "\n" + "Arrival Date: "+this.getArriveDate();
	}
}
