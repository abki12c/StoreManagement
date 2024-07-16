public class Fridge extends Home {
  private String type;
  private String en_class;
  private float refr_storage;
  private float fr_storage;

  //constructor
  public Fridge(String name,int age,String manufacturer,double price,String type,String en_class,float refr_storage,float fr_storage) {
    super(name,age,manufacturer,price);
    setType(type);
    setEn_class(en_class);
    setRefr_storage(refr_storage);
    setFr_storage(fr_storage);
  }


  //setters
  public void setType(String type) {
    this.type=checkInput("one door", "two door", "wardrobe",type,"Fridge type");
  }

  public void setRefr_storage(float refr_storage) {
    this.refr_storage=refr_storage;
  }

  public void setFr_storage(float fr_storage) {
    this.fr_storage=fr_storage;
  }


//getters
  public String getType() {
    return type;
  }

  public float getRefr_storage() {
    return refr_storage;
  }

  public float getFr_storage() {
    return fr_storage;
  }

  //toString
  @Override
  public String toString() {
    return "\nDevice characteristics:\n"+"\nModel name: "+this.getName()+"\nProduction year: "+this.getYear()+"\nManufacturer name: "+this.getManufacturer()+"\nPrice: "+this.getPrice()+
            "Type: "+type+"\nEnergy Class: "+en_class+"\nRetainer Storage: "+refr_storage+"\nFreezer Storage: "+fr_storage;
  }
}
