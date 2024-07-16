abstract public class SaleOrder extends Device {

    //variables
    public int CustomerPhone;
    public String CustomerName;


    //constructor
    public SaleOrder(String name, double price, int productCode, int CustomerPhone, String CustomerName) {
        super(name,price, productCode);
        this.CustomerPhone = CustomerPhone;
        this.CustomerName = CustomerName;
    }

    public abstract int nextCode();
}
