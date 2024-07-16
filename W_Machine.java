public class W_Machine extends Home {
  private String en_class;
  private float storage;
  private int rpm;

  public W_Machine(String name,int age,String manufacturer,double price,String en_class,float storage,int rpm) {
    super(name,age,manufacturer,price);
    setEn_class(en_class);
    setStorage(storage);
    setRpm(rpm);
  }

  //setters
  public void setStorage(float storage) {
    this.storage=storage;
  }
  public void setEn_class(String en_class) {
    this.en_class = en_class;
  }

  public void setRpm(int rpm) {
    this.rpm=rpm;
  }

  //getters
  public float getStorage() {
    return storage;
  }
  public int getRpm() {
    return rpm;
  }
  public String getEn_class() {
    return en_class;
  }



  @Override
  public String toString() {
      return "\nDevice characteristics:\n"+"\nModel name: "+this.getName()+"\nProduction year: "+this.getYear()+"\nManufacturer name: "+this.getManufacturer()+"\nPrice: "+this.getPrice()+
              "\nEnergy Class: "+en_class+"\nStorage: "+storage+"\nRounds Per Minute: "+rpm ;
  }
}
