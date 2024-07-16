public class Console extends Device  {
  private String type;
  private String cpu;
  private String gpu;
  private String sound;
  private float storage;
  protected final float discount_rate = 0.1f;


  //constructor
  public Console(String name, int age, String manufacturer, double price, String type, String cpu, String gpu, String sound, float storage) {
    super(name,age,manufacturer,price);
    settype(type);
    setcpu(cpu);
    setgpu(gpu);
    setsound(sound);
    setstorage(storage);
  }


  //setters
  public void settype(String type) {
    this.type=checkInput("PS4","PS3","Xbox",type,"console type");
  }

  public void setcpu(String cpu) {
    this.cpu=cpu;
  }

  public void setgpu(String gpu) {
    this.gpu=gpu;
  }

  public void setsound(String sound) {
    this.sound=sound;
  }

  public void setstorage(float storage) {
    this.storage=storage;
  }


  //getters
  public String gettype() {
    return type;
  }

  public String getcpu() {
    return cpu;
  }

  public String getgpu() {
    return gpu;
  }

  public String getsound() {
    return sound;
  }

  public float getstorage() {
    return storage;
  }

  //toString
  @Override
  public String toString() {
    return "\nDevice characteristics:\n"+"\nModel name: "+this.getName()+"\nProduction year: "+this.getYear()+"\nManufacturer name: "+this.getManufacturer()+"\nPrice: "+this.getPrice()+
            "\nType: "+type+"\nProcessor: "+cpu+"\nGraphics:"+gpu+"\nSound: "+sound+"\nStorage: "+storage;
  }
}
