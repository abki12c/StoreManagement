public class TV extends Sound_Image {
  private String type;
  private int inches;
  private String display;
  private String ports;


  public TV (String name,int year,String manufacturer,double price,String type,int inches,String display,String ports) {
    super(name,year,manufacturer,price);
    setType(type);
    setInches(inches);
    setDisplay(display);
    setPorts(ports);

  }

  public void setType(String type) {
    this.type= checkInput("LCD","LED","Plasma",type,"TV type");
  }

  public void setInches(int inches) {
    this.inches=inches;
  }

  public void setDisplay(String display) {
    this.display=display;
  }

  public void setPorts(String ports) {
    this.ports= checkInput("HDMI","DVI","Composite",ports,"TV port");
  }

  public String getType() {
    return type;
  }

  public int getInches() {
    return inches;
  }

  public String getDisplay() {
    return display;
  }

  public String getPorts() {
    return ports;
  }


  @Override
  public String toString() {
      return "\nDevice characteristics:\n"+"\nModel name: "+this.getName()+"\nProduction year: "+this.getYear()+"\nManufacturer name: "+this.getManufacturer()+"\nPrice: "+this.getPrice()+
              "\nType: "+type+"\nDiameter In Inches: "+inches+"\nDisplay: "+display+"\nOutput: "+ports;
  }
}
