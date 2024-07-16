public class Player extends Sound_Image  {
  //variables
  private String type;
  private String  resolution;
  private String format;

  //constructor
  public Player(String name, int year, String manufacturer, double price, String type, String resolution, String format) {
    super(name,year,manufacturer,price);
    setType(type);
    setResolution(resolution);
    setFormat(format);
  }



  //setters
  public void setType(String type) {
    this.type=checkInput("BLUE RAY","DVD",type,"Player type");
  }

  public void setResolution(String resolution)
  {
    this.resolution=resolution;
  }

  public void setFormat(String format) {
    this.format=checkInput("BD-R", "BD-RD","DVD-RW","DVD+RW",format,"format type");
  }
  //getters
  public String getType() {
    return type;
  }

  public String getResolution() {
    return resolution;
  }

  public String getFormat() {
    return format;
  }


  //toString
  @Override
  public String toString() {
      return "\nDevice characteristics:\n"+"\nModel name: "+this.getName()+"\nProduction year: "+this.getYear()+"\nManufacturer name: "+this.getManufacturer()+"\nPrice: "+this.getPrice()+
              "\nType: "+type+"\nResolution: "+resolution+"\nFormat: "+format;
  }

}
