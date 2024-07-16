import java.io.*;


public class CreateFileApp {



  public static void createFile() {
      FileWriter writer =null;
      try {
        writer = new FileWriter(new File("products.txt"));
        writer.write("ITEM_LIST" + "\n" + "{");
        for (Device product : mainApp.AvailableProducts) {
          if (product instanceof TV) {
            writer.write("\n" + "ITEM" + "\n" + "\t" + "{" + "\n" + "\t" + "\t" + "Code : " + product.getCode() + "\n" + "\t" + "\t" + "ITEM_TYPE : TV" + "\n" + "\t" + "\t" + "MODEL: " + product.getName() + "\n" + "\t" + "\t" + "MANUFACTURER : " + product.getManufacturer() + "\n" + "\t" + "\t" + "YEAR : " + product.getYear() +
                    "\n" + "\t" + "\t" + "PRICE : " + product.getPrice() + "\n" + "\t" + "\t" + "TYPE : " + ((TV) product).getType() + "\n" + "\t" + "\t" + "INCHES : " + ((TV) product).getInches() + "\n" + "\t" + "\t" + "DISPLAY : " + ((TV) product).getDisplay() + "\n" + "\t" + "\t" + "PORTS : " + ((TV) product).getPorts() + "\n" + "\t" + "\t" + "PIECES : " + product.getPieces() + "\n" + "\t" + "}");
          } else if (product instanceof Console) {
            writer.write("\n" + "ITEM" + "\n" + "\t" + "{" + "\n" + "\t" + "\t" + "Code : " + product.getCode() + "\n" + "\t" + "\t" + "ITEM_TYPE : CONSOLE" + "\n" + "\t" + "\t" + "MODEL: " + product.getName() + "\n" + "\t" + "\t" + "MANUFACTURER : " + product.getManufacturer() + "\n" + "\t" + "\t" + "YEAR : " + product.getYear() +
                    "\n" + "\t" + "\t" + "PRICE : " + product.getPrice() + "\n" + "\t" + "\t" + "TYPE : " + ((Console) product).gettype() + "\n" + "\t" + "\t" + "CPU : " + ((Console) product).getcpu() + "\n" + "\t" + "\t" + "GPU : " + ((Console) product).getgpu() +
                    "\n" + "\t" + "\t" + "STORAGE : " + ((Console) product).getstorage() + "\n" + "\t" + "\t" + "SOUND : " + ((Console) product).getsound() + "\n" + "\t" + "\t" + "PIECES :" + product.getPieces() + "\n" + "\t" + "}");
          } else if (product instanceof Player) {
            writer.write("\n" + "ITEM" + "\n" + "\t" + "{" + "\n" + "\t" + "\t" + "Code : " + product.getCode() + "\n" + "\t" + "\t" + "ITEM_TYPE : PLAYER" + "\n" + "\t" + "\t" + "MODEL: " + product.getName() + "\n" + "\t" + "\t" + "MANUFACTURER : " + product.getManufacturer() + "\n" + "\t" + "\t" + "YEAR : " + product.getYear() +
                    "\n" + "\t" + "\t" + "PRICE : " + product.getPrice() + "\n" + "\t" + "\t" + "TYPE : " + ((Player) product).getType() + "\n" + "\t" + "\t" + "RESOLUTION : " + ((Player) product).getResolution() + "\n" + "\t" + "\t" + "FORMAT : " + ((Player) product).getFormat() + "\n" + "\t" + "\t" + "PIECES : " + product.getPieces() + "\n" + "\t" + "}");

          } else if (product instanceof Fridge) {
            writer.write("\n" + "ITEM" + "\n" + "\t" + "{" + "\n" + "\t" + "\t" + "Code : " + product.getCode() + "\n" + "\t" + "\t" + "ITEM_TYPE : FRIDGE" + "\n" + "\t" + "\t" + "MODEL: " + product.getName() + "\n" + "\t" + "\t" + "MANUFACTURER : " + product.getManufacturer() + "\n" + "\t" + "\t" + "YEAR : " + product.getYear() +
                    "\n" + "\t" + "\t" + "PRICE : " + product.getPrice() + "\n" + "\t" + "\t" + "TYPE : " + ((Fridge) product).getType() + "\n" + "\t" + "\t" + "ENERGY_CLASS : " + ((Fridge) product).getEn_class() + "\n" + "\t" + "\t" +
                    "REFRIGERATOR STORAGE : " + ((Fridge) product).getRefr_storage() + "\n" + "\t" + "\t" + "FRIDGE STORAGE : " + ((Fridge) product).getFr_storage() + "\n" + "\t" + "\t" + "PIECES : " + product.getPieces() + "\n" + "\t" + "}");
          } else if (product instanceof W_Machine) {
            writer.write("\n" + "ITEM" + "\n" + "\t" + "{" + "\n" + "\t" + "\t" + "Code : " + product.getCode() + "\n" + "\t" + "\t" + "ITEM_TYPE : WASHING MACHINE" + "\n" + "\t" + "\t" + "MODEL: " + product.getName() + "\n" + "\t" + "\t" + "MANUFACTURER : " + product.getManufacturer() + "\n" + "\t" + "\t" + "YEAR : " + product.getYear() +
                    "\n" + "\t" + "\t" + "PRICE : " + product.getPrice() + "\n" + "\t" + "\t" + "ENERGY_CLASS : " + ((W_Machine) product).getEn_class() + "\n" + "\t" + "\t" + "STORAGE : " + ((W_Machine) product).getStorage() + "\n" + "\t" + "\t" + "RPM : " + ((W_Machine) product).getRpm() + "\n" + "\t" + "\t" + "PIECES : " + product.getPieces() + "\n" + "\t" + "}");
          } else {
            //Cameras
            writer.write("\n" + "ITEM" + "\n" + "\t" + "{" + "\n" + "\t" + "\t" + "Code : " + product.getCode() + "\n" + "\t" + "\t" + "ITEM_TYPE : CAMERA" + "\n" + "\t" + "\t" + "MODEL: " + product.getName() + "\n" + "\t" + "\t" + "MANUFACTURER : " + product.getManufacturer() + "\n" + "\t" + "\t" + "YEAR : " + product.getYear() +
                    "\n" + "\t" + "\t" + "PRICE : " + product.getPrice() + "\n" + "\t" + "\t" + "TYPE: " + ((Camera) product).gettype() + "\n" + "\t" + "\t" + "MEGAPIXELS : " + ((Camera) product).getmgp() + "\n" + "\t" + "\t" + "OPTICAL ZOOM: " + ((Camera) product).getopt_zoom() + "\n" + "\t" + "\t" + "DIGITAL ZOOM: " + ((Camera) product).getdig_zoom() +
                    "\n" + "\t" + "\t" + "SCREEN SIZE: " + ((Camera) product).getscr_size() + "\n" + "\t" + "\t" + "PIECES : " + product.getPieces() + "\n" + "\t" + "}");
          }
        }

        writer.write("\n" + "}");
        writer.close();

      } catch(IOException e){
        System.err.println("Error writing file.Try again.");
      }


    }//CreateFile



  public static void PrintFile(String filename) {
    System.out.println("-----------Printing File-------------");
    try{
      BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
      String line=reader.readLine();
      while(line!=null) {
        System.out.println(line);
        line=reader.readLine();
      }
      reader.close();

    } catch(IOException e) {
      System.err.println("Error Reader file");
    }
  }


}
