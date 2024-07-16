import java.util.*;

public class mainApp  {
	static String name;
	static int year;
	static String manufacturer;
	static double price;
	public static TV television;
	public static Player player;
	public static Camera camera;
	public static Console console;
	public static Fridge fridge;
	public static W_Machine washingMachine;
	static ArrayList<Device> AvailableProducts = new ArrayList<>();
	static List<Order> Orders = new ArrayList<>();
	static List<Sale> Sales = new ArrayList<>();

	public static void createList(){

		TV tv1 = new TV("Panasonic G78",2007,"Samsung",99.99,"LED",32,"720p","DVI");
		TV tv2 = new TV(" LG 43UM7100",2019,"LG",289.99,"LCD",38,"1080p","HDMI");
		Player player1 = new Player("Sony Blue Ray G5 ",2019,"Sony",169.99,"BLUE RAY","1080p","BD-R");
		Player player2 = new Player("Sony DVD Player H3 ",2019,"Sony",289.99, "DVD","720p","DVD+RW");
		Console ps4pro = new Console("Playstation 4 Pro",2016,"Sony",299.99,"PS4","AMD JAGUAR","AMD RADEON POLARIS","7.1 Sony Sound Card",500.0f);
		Console xbox = new Console("Xbox One",2016,"Microsoft",149.99,"Xbox","AMD JAGUAR","AMD RADEON POLARIS","7.1 Microsoft Sound Card",1000.0f);
		Camera camera1 = new Camera("DSLR D5300",2017,"Nikon",699.99,"DSLR",24,40,60,4);
		Camera camera2 = new Camera("Digital Camera Cybershot DSC-HX60B",2013,"Sony",399.99,"compact",23,20,30,2);
		Fridge fridge1 = new Fridge("CM 3352 W",2020,"CANDY",499.99,"two door","A", 262,98);
		Fridge fridge2 =new Fridge("GBP 31 DSLZN",2017,"LG",799.99,"wardrobe","A+", 305,112);
		W_Machine washingMachine1 =  new W_Machine("F4J5TN3W",2016,"LG",399.99,"A+++",8,1200);
		W_Machine washingMachine2 = new W_Machine("FWSF61053W",2015,"WHIRLPOOL",289.99,"A++",6,1000);

		tv1.setPieces(3);
		tv2.setPieces(2);
		player1.setPieces(1);
		player2.setPieces(2);
		ps4pro.setPieces(3);
		xbox.setPieces(2);
		camera1.setPieces(2);
		camera2.setPieces(3);
		fridge1.setPieces(3);
		fridge2.setPieces(2);
		washingMachine1.setPieces(2);
		washingMachine2.setPieces(1);

		AvailableProducts.add(tv1);
		AvailableProducts.add(tv2);
		AvailableProducts.add(player1);
		AvailableProducts.add(player2);
		AvailableProducts.add(ps4pro);
		AvailableProducts.add(xbox);
		AvailableProducts.add(camera1);
		AvailableProducts.add(camera2);
		AvailableProducts.add(fridge1);
		AvailableProducts.add(fridge2);
		AvailableProducts.add(washingMachine1);
		AvailableProducts.add(washingMachine2);

	}

	public static void printList() {
		for(Device product : AvailableProducts) {
			System.out.println(product);
		}
	}


	public static void enterBasicDetails() {
		Scanner in= new Scanner(System.in);

		System.out.print("\nEnter the name of the model: ");
		name = in.nextLine();
		System.out.print("\nEnter the production year: ");
		year=in.nextInt();
		System.out.print("\nEnter the manufacturer name: ");
		in.nextLine();
		manufacturer = in.nextLine();
		System.out.print("\nEnter the price of the product: ");
		price=Double.parseDouble(in.nextLine());
	}


	public static void SellOrOrder(Device device,float discount_rate) {
		int customerPhone;
		String customerName;
		String saleDate;
		String answer;
		String orderDate;
		String arriveDate;


		Scanner in= new Scanner(System.in);
		if(AvailableProducts.contains(device)){
			int index = AvailableProducts.indexOf(device);
			int pieces = AvailableProducts.get(index).getPieces();

			if(pieces>0){
				index = AvailableProducts.indexOf(device);

				System.out.print("\nThe product is available for sale. Do you want to buy it? Yes/No: ");
				answer = Device.checkInput("Yes","No",in.nextLine(),"preferred answer Yes or No");
				if(answer.equalsIgnoreCase("Yes")){
					//you can sell
					System.out.print("\nEnter the customer phone: ");
					customerPhone = in.nextInt();
					System.out.print("\nEnter the customer name: ");
					in.nextLine();
					customerName = in.nextLine();
					System.out.print("\nEnter the sale date: ");
					saleDate = in.nextLine();
					System.out.println("\nPrice before discount: "+ device.getPrice());
					device.price=device.getPrice()-device.getPrice()*discount_rate;
					device.price = Math.round(device.price * 100.0) / 100.0;
					System.out.println("Price after discount:"+ device.getPrice());

					Sale toBeSold = new Sale(device.getName(),device.getPrice(),customerPhone,customerName,saleDate);
					Sales.add(toBeSold);

					//reduce model pieces by one
					Device dev = AvailableProducts.get(index);
					dev.setPieces(dev.getPieces()-1);
					System.out.println("Congratulations, the product has been sold!");
				}
			}

		}else{
			//you can order
			System.out.print("\nThe product is not available for sale. Do you want to order it? Yes/No: ");
			answer = Device.checkInput("Yes","No",in.nextLine(),"preferred answer Yes or No");
			if(answer.equalsIgnoreCase("Yes")){
				System.out.print("\nEnter the customer phone: ");
				customerPhone = in.nextInt();
				System.out.print("\nEnter the customer name: ");
				in.nextLine();
				customerName = in.nextLine();
				System.out.print("\nEnter the order date: ");
				orderDate = in.nextLine();
				System.out.print("\nEnter the arrive date: ");
				arriveDate = in.nextLine();
				Order toBeOrdered= new Order(device.getName(),device.getPrice(),customerPhone,customerName,orderDate,arriveDate);
				Orders.add(toBeOrdered);
				System.out.println("Congratulations, the product has been ordered!");
			}
		}
	}


	//main
	public static void main(String[] args) {
		String type, opt,opt1,opt2,opt3;
		Scanner in= new Scanner(System.in);

		createList();
		CreateFileApp.createFile();
		AvailableProducts = ReadFileApp.readFile("products.txt");

		System.out.println("Welcome to the App!");
		do{
			System.out.println("------------------------------------------");
			System.out.println("1.Review of available devices");
			System.out.println("2.Review of Orders");
			System.out.println("3.Review of Sales");
			System.out.println("4.Exit the program");
			System.out.println("------------------------------------------");
			System.out.println("Please choose one of the valid options above: ");
			opt=Device.checkInput("1","2","3","4",in.nextLine(), "correct desired number ");

			switch (opt) {
				case "1":
					System.out.println("Main Menu");
					System.out.println("------------------------------------------");
					System.out.println("1.Screen And Sound");
					System.out.println("2.Gaming");
					System.out.println("3.Home");
					System.out.println("------------------------------------------");
					System.out.print("Please choose one of the valid options above: ");
					opt1 = Device.checkInput("1", "2", "3", in.nextLine(), "correct desired number ");
					if (opt1.equals("1")) {
						//Screen and Sound category
						System.out.println("You have chosen the Screen and Sound category.");
						System.out.println("Press 1 for  TV, 2 for Blue ray/DVD players or 3 for Cameras: ");
						opt2 = Device.checkInput("1", "2", "3", in.nextLine(), "correct desired number ");

						if (opt2.equals("1")) {
							//TV
							System.out.println("You have chosen the television category");
							System.out.println("Now you should give information about the specific model...");
							System.out.print("\nEnter the model type: ");
							type = Device.checkInput("LCD", "LED", "Plasma", in.nextLine(), "TV type");
							System.out.print("\nEnter inches: ");
							int inches = in.nextInt();
							System.out.print("\nEnter the display resolution: ");
							in.nextLine();
							String display = in.nextLine();
							System.out.print("\nEnter the ports the model has: ");
							String ports = Device.checkInput("HDMI", "DVI", "Composite", in.nextLine(), "TV port");
							enterBasicDetails();
							television = new TV(name, year, manufacturer, price, type, inches, display, ports);
							System.out.println(television);
							SellOrOrder(television, television.discount_rate);


						} else if (opt2.equals("2")) {
							//PLayers
							System.out.println("You have chosen the Blue ray/DVD players category");
							System.out.println("Now you should give information about the specific model...");
							System.out.println("Give more information about the specific model...");
							System.out.print("\nEnter the model type:");
							type = Device.checkInput("BLUE RAY", "DVD", in.nextLine(), "Player type");
							System.out.print("\nEnter the display resolution:");
							String resolution = in.nextLine();
							System.out.print("\nEnter the format :");
							String format = Device.checkInput("BD-R", "BD-RD", "DVD-RW", "DVD+RW", in.nextLine(), "format type");
							enterBasicDetails();
							player = new Player(name, year, manufacturer, price, type, resolution, format);
							System.out.println(player);
							SellOrOrder(player, player.discount_rate);
						} else {
							//Cameras
							System.out.println("You have chosen the Cameras category");
							System.out.println("Now you should give information about the specific model...");
							System.out.print("\nEnter the model type: ");
							type = Device.checkInput("compact", "DSLR", "Action   camera", in.nextLine(), "camera type");
							System.out.print("\nEnter the Megapixels: ");
							int mgp = in.nextInt();
							System.out.print("\nEnter the Optical Zoom: ");
							int opt_zoom = in.nextInt();
							System.out.print("\nEnter the Digital Zoom: ");
							int dig_zoom = in.nextInt();
							System.out.print("\nEnter the Screen Size: ");
							int scr_size = in.nextInt();
							in.nextLine();
							enterBasicDetails();
							camera = new Camera(name, year, manufacturer, price, type, mgp, opt_zoom, dig_zoom, scr_size);
							System.out.println(camera);
							SellOrOrder(camera, camera.discount_rate);
						}
					} else if (opt1.equals("2")) {
						//Gaming category
						System.out.println("You have chosen the Gaming category.");
						System.out.println("Now you should give information about the specific model...");
						System.out.print("\nEnter the console type: ");
						type = Device.checkInput("PS4", "PS3", "Xbox", in.nextLine(), "console type");
						System.out.print("\nEnter Processor : ");
						String cpu = in.nextLine();
						System.out.print("\nEnter Graphics : ");
						String gpu = in.nextLine();
						System.out.print("\nEnter Sound : ");
						String sound = in.nextLine();
						System.out.print("\nEnter Storage: ");
						float storage = in.nextFloat();
						in.nextLine();
						enterBasicDetails();
						console = new Console(name, year, manufacturer, price, type, cpu, gpu, sound, storage);
						System.out.println(console);
						SellOrOrder(console, console.discount_rate);

					} else {
						//Home category
						String en_class;

						System.out.println("You have chosen the Home category.");
						System.out.println("Press 1 for Fridges and 2 for Washing machines:");
						opt3 = Device.checkInput("1", "2", in.nextLine(), "correct desired number ");
						if (opt3.equals("1")) {
							float refr_storage;
							float fr_storage;

							System.out.println("You have chosen the Fridges category");
							System.out.println("Give more information about the specific model...");
							System.out.print("\nEnter the Fridges type: ");
							type = Device.checkInput("one door", "two door", "wardrobe", in.nextLine(), "Fridge type");
							System.out.print("\nEnter the energy class: ");
							en_class = in.nextLine();
							System.out.print("\nEnter the Retainer storage: ");
							refr_storage = in.nextFloat();
							System.out.print("\nEnter the Freezer storage: ");
							fr_storage = in.nextFloat();
							in.nextLine();
							enterBasicDetails();
							fridge = new Fridge(name, year, manufacturer, price, type, en_class, refr_storage, fr_storage);
							System.out.println(fridge);
							SellOrOrder(fridge, fridge.discount_rate);
						} else {
							float storage;
							int rpm;

							System.out.println("You have chosen the Washing machine category");
							System.out.println("Give more information about the specific model...");
							System.out.print("\nEnter the energy class: ");
							en_class = in.nextLine();
							System.out.print("\nEnter the washing machine storage: ");
							storage = in.nextFloat();
							System.out.print("\nEnter the Washing machine rpm: ");
							rpm = in.nextInt();
							in.nextLine();
							enterBasicDetails();
							washingMachine = new W_Machine(name, year, manufacturer, price, en_class, storage, rpm);
							System.out.println(washingMachine);
							SellOrOrder(washingMachine, washingMachine.discount_rate);
						}


					}
					break;
				case "2" :
					//orders
					int i = 0;
					System.out.println("You have chosen to review the Orders of products.");
					if (Orders.size() > 0) {
						System.out.println("Here are the ordered products:");
						for (Order order : Orders) {
							System.out.println("------------------------------------------");
							System.out.println("Order " + i + ":");
							System.out.println("------------------------------------------");
							System.out.println(order.toString());
							System.out.println("------------------------------------------");
							i++;
						}
						System.out.println("Choose a product between 0 and " + (Orders.size() - 1) + ":");
						int orderNumber = in.nextInt();
						while (orderNumber >= Orders.size() || orderNumber < 0) {
							System.out.println("Wrong number.Enter the correct number again:");
							orderNumber = in.nextInt();
						}
						in.nextLine();
						System.out.println(Orders.get(orderNumber));
						System.out.print("Would you like to buy this product?(Yes/no) : ");
						String option = Device.checkInput("Yes", "No", in.nextLine(), "Yes or No");
						if (option.equalsIgnoreCase("Yes")) {
							Sale newSale = new Sale(Orders.get(orderNumber).getName(), Orders.get(orderNumber).getPrice(), Orders.get(orderNumber).CustomerPhone, Orders.get(orderNumber).CustomerName, Orders.get(orderNumber).arriveDate);
							Sales.add(newSale);
							Orders.get(orderNumber).setStatus("ARRIVED");
							System.out.println("Sale Successful!");
						}
					} else {
						System.out.println("There are no orders at the moment..");
					}
					break;

				case "3":
					//sales
					System.out.println("You have chosen to review the Sales of products.");
					if (Sales.size() > 0) {
						System.out.println("Here are the sold products:");
						for (Sale sale : Sales) {
							System.out.println("------------------------------------------");
							System.out.println(sale);
							System.out.println("------------------------------------------");

						}
					} else {
						System.out.println("There are no sold products at the moment..");
					}
					break;


			}

		} while(!opt.equals("4"));
		System.out.println("*You exited the App*");
	}
}
