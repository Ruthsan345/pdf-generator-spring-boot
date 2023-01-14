//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVRecord;
//
//import java.io.IOException;
//import java.io.Reader;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Scanner;
//
//class product_old {
//    int proId;
//    String proName;
//    int stock;
//    int price;
//    Product(){}
//    Product(int id, String name, int sto, int pri){
//        this.proId = id;
//        this.proName = name;
//        this.stock = sto;
//        this.price = pri;
//    }
//
//    void displayAllProducts(){
//        System.out.println("\nProduct Id: "+proId);
//        System.out.println("Product name: "+proName);
//        System.out.println("Product Stock: "+stock);
//        System.out.println("Product Price: "+price);
//        System.out.println("\n ----------------> \n");
//
//    }
//
//}
//
//
//
//class Final{
//
//    private static final String PRODUCT_CSV_FILE_PATH = "./products.csv";
//    private static final String WHOLESALERS_CSV_FILE_PATH = "./wholesalers.csv";
//    private static final String RETAILERS_CSV_FILE_PATH = "./retailers.csv";
//    private static final int LENGTH_OF_PRODUCTS=3;
//
////    public  static void readcsv(String file_path, String category) throws IOException {
////        try (
////                Reader reader = Files.newBufferedReader(Paths.get(file_path));
////                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
////        ) {
////
////            switch (category) {
////                case "PRODUCT":
////                    Product[] products =new Product[1];
////                    int i=0;
////                    for (CSVRecord csvRecord : csvParser) {
////                        int proId = Integer.parseInt(csvRecord.get(0));
////                        String proName = csvRecord.get(1);
////                        int stock = Integer.parseInt(csvRecord.get(2));
////                        int price = Integer.parseInt(csvRecord.get(3));
////                        products[i] = new Product(proId,proName,stock,price);
////
////                        System.out.println(proId);
////                    }
////                    break;
////
////
////            }
////
////
////        }
////    }
//
//
//    public static void main(String args[]) throws IOException {
////        readcsv(PRODUCT_CSV_FILE_PATH,"PRODUCT");
////        readcsv(WHOLESALERS_CSV_FILE_PATH,"WHOLESALER");
////        readcsv(RETAILERS_CSV_FILE_PATH,"RETAILER");
//
//        String[] file_paths = { "./products.csv", "./wholesalers.csv", "./retailer.csv"};
//
//        Product[] products = new Product[LENGTH_OF_PRODUCTS];
//        Wholesaler[] wholesaler = new Wholesaler[LENGTH_OF_PRODUCTS];
//        Retailer[] retailer = new Retailer[LENGTH_OF_PRODUCTS];
//        try (
//            Reader reader = Files.newBufferedReader(Paths.get(file_paths[0]));
//            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
//        ){int i = 0;
//            for (CSVRecord csvRecord : csvParser) {
//                int proId = Integer.parseInt(csvRecord.get(0));
//                String proName = csvRecord.get(1);
//                int stock = Integer.parseInt(csvRecord.get(2));
//                int price = Integer.parseInt(csvRecord.get(3));
//                products[i] = new Product(proId, proName, stock, price);
//                i++;
//            }}
//
//        try (
//                Reader reader = Files.newBufferedReader(Paths.get(file_paths[1]));
//                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
//        ){
//            int i = 0;
//            for (CSVRecord csvRecord : csvParser) {
//                int id = Integer.parseInt(csvRecord.get(0));
//                String name = csvRecord.get(1);
//                int prodid = Integer.parseInt(csvRecord.get(2));
//                String proName = csvRecord.get(3);
//                int wholesale_price = Integer.parseInt(csvRecord.get(5));
//                int wholesale_quantity = Integer.parseInt(csvRecord.get(4));
//                wholesaler[i] = new Wholesaler(id, name, prodid, proName, wholesale_quantity, wholesale_price);
//                i++;
//            }
//        }
//        try (
//        Reader reader = Files.newBufferedReader(Paths.get(file_paths[2]));
//        CSVParser  csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
//        )
//
//        {
//            int i = 0;
//            for (CSVRecord csvRecord : csvParser) {
//                int id = Integer.parseInt(csvRecord.get(0));
//                String name = csvRecord.get(1);
//                int prodid = Integer.parseInt(csvRecord.get(2));
//                String proName = csvRecord.get(3);
//                int retail_price = Integer.parseInt(csvRecord.get(5));
//                int retail_quantity = Integer.parseInt(csvRecord.get(4));
//                retailer[i] = new Retailer(id, name, prodid, proName, retail_quantity, retail_price);
//                i++;
//            }
//        }
//
//
//
//            Scanner sc = new Scanner(System.in);
//        while(true)
//        {
//            int i =0;
//            System.out.println( "Welcome to HUB ... " );
//            System.out.println( "Select 1 for View all the Products" );
//            System.out.println( "Select 2 for view all the wholesalers " );
//            System.out.println( "Select 3 for view all the retailers" );
//            System.out.println( "Select 4 for Take stock for the wholesalers" );
//            System.out.println( "Select 5 for Take stock for the retailers" );
//            System.out.println( "Select 6 for Deduct stock for the wholesalers" );
////            System.out.println( "Select 7 for Deduct stock for the retailers" );
//            System.out.println( "Select 6 for EXIT" );
//            System.out.print( "Select the appropriate options you want to perform: " );
//
//            int op = sc.nextInt( );
//            switch( op )
//            {
//                case 1:
//                    for(i=0;i<LENGTH_OF_PRODUCTS;i++){
//                        products[i].displayAllProducts();
//                    }
//                    break;
//                case 2:
//                    for(i=0;i<LENGTH_OF_PRODUCTS;i++){
//                        wholesaler[i].displayAllWholesaler();
//                    }
//
//                    break;
//                case 3:
//                    for(i=0;i<LENGTH_OF_PRODUCTS;i++){
//                        retailer[i].displayAllRetailer();
//                    }
//                    break;
//                case 4:
//                    System.out.println( "\nEnter the Wholesaler ID: " );
//                    int wholesalerId = sc.nextInt( );
//                    System.out.println( "\nEnter the stock quantity: " );
//                    int quantity = sc.nextInt( );
//                    for(i=0;i<LENGTH_OF_PRODUCTS;i++){
//                        if (wholesalerId==wholesaler[i].wholesale_id) {
//                            wholesaler[i].wholesale_stock = wholesaler[i].wholesale_stock + quantity;
//                            if (products[i].proId == wholesaler[i].wholesale_proId) {
//                                products[i].stock= products[i].stock-quantity;
//                            }
//                        }
//
//                    }
//                    System.out.println( "\nProduct quantity updated in wholesaler from product------> \n " );
//
//                    break;
//                case 5:
//                    System.out.println( "\nEnter the retailer ID: " );
//                    int retailerId = sc.nextInt( );
//                    System.out.println( "\nEnter the stock quantity: " );
//                    int quant = sc.nextInt( );
//                    for(i=0;i<LENGTH_OF_PRODUCTS;i++){
//                        if (retailerId==retailer[i].retail_id) {
//                            retailer[i].retail_stock = retailer[i].retail_stock + quant;
//                            if (wholesaler[i].wholesale_proId == retailer[i].wholesale_proId) {
//                                wholesaler[i].wholesale_stock= wholesaler[i].wholesale_stock-quant;
//                            }
//                        }
//
//                    }
//
//                    System.out.println( "\nProduct quantity updated in Retailer from Wholesaler------> \n " );
//
//                    break;
//                case 6:
//                    System.exit( 0 );
//            }
//        }
//    }
//
//
//
//    }
