import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReadFileApp {
	public static ArrayList<Device> readFile(String filename) {

		BufferedReader reader ;
		String line, token, value;
		StringTokenizer lineToken;
		ArrayList<Device> devices = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(new File(filename)));
			line = reader.readLine();
			if (line.trim().startsWith("ITEM_LIST")) {
				line = reader.readLine();
				if (line.trim().equals("{")) {
					line = reader.readLine();
					while (line!=null && line.trim().equals("ITEM")) {
						line = reader.readLine();
						if (line.trim().equals("{")) {
							line = reader.readLine();
							Device device = new Device();
							String itemType, type, energyClass,rpm,display,ports,resolution,format,cpu,gpu,sound ;
							itemType=type=energyClass=rpm=display=ports=resolution=format=cpu=gpu=sound = "";
							int pieces,megapixels,optZoom,inches,digitalZoom,screenSize;
							pieces=megapixels=optZoom=inches=digitalZoom=screenSize=0;
							float storage,refrigeratorStorage,fridgeStorage;
							storage=refrigeratorStorage=fridgeStorage=0;

							while (!line.trim().equals("}")) {

								lineToken = new StringTokenizer(line,":");
								token = lineToken.nextToken().trim();
								value = lineToken.nextToken().trim();
								switch (token) {
									case "CODE" -> device.setCode(Integer.parseInt(value));
									case "ITEM_TYPE" -> itemType = value;
									case "MODEL" -> device.setName(value);
									case "MANUFACTURER" -> device.setManufacturer(value);
									case "YEAR" -> device.setYear(Integer.parseInt(value));
									case "PRICE" -> device.setPrice(Double.parseDouble(value));
									case "TYPE" -> type = value;
									case "ENERGY_CLASS" -> energyClass = value;
									case "STORAGE" -> storage = Float.parseFloat(value);
									case "RPM" -> rpm = value;
									case "PIECES" -> pieces = Integer.parseInt(value);
									case "MEGAPIXELS" -> megapixels = Integer.parseInt(value);
									case "OPTICAL ZOOM" -> optZoom = Integer.parseInt(value);
									case "DIGITAL ZOOM" -> digitalZoom = Integer.parseInt(value);
									case "INCHES" -> inches = Integer.parseInt(value);
									case "DISPLAY" -> display = value;
									case "PORTS" -> ports = value;
									case "RESOLUTION" -> resolution = value;
									case "FORMAT" -> format = value;
									case "CPU" -> cpu = value;
									case "GPU" -> gpu = value;
									case "SOUND" -> sound = value;
									case "REFRIGERATOR STORAGE" -> refrigeratorStorage = Float.parseFloat(value);
									case "FRIDGE STORAGE" -> fridgeStorage = Float.parseFloat(value);
								}

								line = reader.readLine();
							}


							switch (itemType){
								case "WASHING MACHINE":
									W_Machine washingMachine = new W_Machine(device.getName(),device.getYear(),device.getManufacturer(),device.getPrice(),energyClass,storage,Integer.parseInt(rpm));
									washingMachine.setPieces(pieces);
									devices.add(washingMachine);
									break;
								case "CAMERA":
									Camera camera = new Camera(device.getName(),device.getYear(),device.getManufacturer(),device.getPrice(),type,megapixels,optZoom,digitalZoom,screenSize);
									camera.setPieces(pieces);
									devices.add(camera);
									break;
								case "TV":
									TV tv = new TV(device.getName(),device.getYear(),device.getManufacturer(),device.getPrice(),type,inches,display,ports);
									tv.setPieces(pieces);
									devices.add(tv);
									break;
								case "PLAYER":
									Player player = new Player(device.getName(),device.getYear(),device.getManufacturer(),device.getPrice(),type,resolution,format);
									player.setPieces(pieces);
									devices.add(player);
									break;
								case "CONSOLE":
									Console console = new Console(device.getName(),device.getYear(),device.getManufacturer(),device.getPrice(),type,cpu,gpu,sound,storage);
									console.setPieces(pieces);
									devices.add(console);
									break;
								case "FRIDGE":
									Fridge fridge = new Fridge(device.getName(),device.getYear(),device.getManufacturer(),device.getPrice(),type,energyClass,refrigeratorStorage,fridgeStorage);
									fridge.setPieces(pieces);
									devices.add(fridge);
									break;
							}
						}
						line = reader.readLine();
					}
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error reading line ...");
		}
		return devices;
	}
}