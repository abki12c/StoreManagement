public class Home extends Device {
    private String en_class;
    protected final float discount_rate = 0.2f;

    //constructor
    public Home(String name,int age,String manufacturer,double price) {
      super(name,age,manufacturer,price);
    }

    public void setEn_class(String en_class) {
      this.en_class = en_class;
    }
    public String getEn_class() {
        return en_class;
    }

}
