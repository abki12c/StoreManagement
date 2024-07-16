import java.util.Random;
import java.util.Scanner;

public class Device {

  protected String name;
  private  int year;
  private  String manufacturer;
  protected double price;
  protected int code;
  protected int pieces;
  private int id;

  //constructor
  public  Device(String name,int age,String manufacturer,double price) {
    this.name = name;
    this.year = age;
    this.manufacturer = manufacturer;
    this.price = price;
    this.id = this.year - (int)Math.round(this.price) + this.name.length() + this.manufacturer.length();
    Random rand = new Random();
    this.code=rand.nextInt(1000000);
  }

  public  Device(String name,double price) {
    this.name = name;
    this.price = price;
  }

  public  Device(){}

  //getters
  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public int getYear() {
    return year;
  }

  public int getCode() {
    return this.code;
  }

  public int getPieces() {
    return pieces;
  }

  //setters

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setPieces(int pieces) {
    this.pieces = pieces;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer=manufacturer;
  }

  public void setYear(int age) {
    this.year = age;
  }

  @Override
  public boolean equals(Object obj) {
    Device device = (Device) obj;
    return device.getName().equals(this.getName()) && device.getPrice() == this.getPrice() && device.getYear() == this.getYear() && device.getManufacturer().equals(this.getManufacturer()) && this.id == device.id ;
  }

  @Override
  public int  hashCode() {
    return this.id;
  }

  static String checkInput(String option1, String option2, String option3, String option4, String check, String InputType){
    Scanner in = new Scanner(System.in);
    while(!check.equalsIgnoreCase(option1) && !check.equalsIgnoreCase(option2) && !check.equalsIgnoreCase(option3) && !check.equalsIgnoreCase(option4)){
      System.out.println("Wrong input.Enter again the "+ InputType+":");
      check = in.nextLine();
    }
    return check;
  }

  static String checkInput(String option1, String option2, String option3, String check, String InputType){
    Scanner in = new Scanner(System.in);
    while(!check.equalsIgnoreCase(option1) && !check.equalsIgnoreCase(option2) && !check.equalsIgnoreCase(option3)){
      System.out.println("Wrong input.Enter again the "+ InputType+":");
      check = in.nextLine();
    }
    return check;
  }


  static String checkInput(String option1, String option2,String check, String InputType){
    Scanner in = new Scanner(System.in);
    while(!check.equalsIgnoreCase(option1) && !check.equalsIgnoreCase(option2)){
      System.out.println("Wrong input.Enter again the "+ InputType+":");
      check = in.nextLine();
    }
    return check;
  }

}
