import UserDefinedException.UserDefinedException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

class Product {
    int proId;
    String proName;
    int stock;
    int price;
    NavigableMap<Integer,Integer> discount=new TreeMap<Integer, Integer>();

    Product(){}
    Product(int id, String name, int sto, int pri,NavigableMap<Integer,Integer> disc ){
        this.proId = id;
        this.proName = name;
        this.stock = sto;
        this.price = pri;
        this.discount = disc;
    }

    void changeQuantity(int stock){
        this.stock = stock;
        System.out.println("stock changed successfully");
    }

    void displayAllProducts(ArrayList<Product> productList){
        try{
            if (productList.isEmpty()){throw new UserDefinedException("\n Sorry !!No Products to Display\n\n");}
            for(Product n : productList){
                System.out.println("\nProduct Id: "+n.proId);
                System.out.println("Product name: "+n.proName);
                System.out.println("Product Stock: "+n.stock);
                System.out.println("Product Price: "+n.price);
                System.out.println("\n ----------------> \n");
            }

        }catch(UserDefinedException ud){
            System.out.println(ud.getMessage());
        }
    }

    void addProducts(ArrayList<Product> productList){

        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter Product id : ");
            int proId = sc.nextInt();
            System.out.println("Enter Product name : ");
            String proName = sc.next();
            System.out.println("Enter Product Stock: ");
            int proSto = sc.nextInt();
            if (proSto<0){ throw new UserDefinedException("\n Sorry !! You cannot enter a product with negative stock. Kindly create another entry\n\n"); }
            System.out.println("Enter Product price: ");
            int proPri = sc.nextInt();
            NavigableMap<Integer,Integer> discount=new TreeMap<Integer, Integer>();
            discount.put(10, 10);
            discount.put(50, 20);
            discount.put(100, 30);
           Product products = new Product(proId, proName, proSto, proPri,discount);
           productList.add(products);

        }catch(UserDefinedException ud){
            System.out.println(ud.getMessage());
        }
    }

    static void deleteProduct(int id,ArrayList<Product> productList){
        int pos = 0;
        int trigger=-1;
        boolean val =false;
        try{
            for(Product n : productList) {
                if (n.proId == id){
                    trigger=pos;
//                names.remove(pos);
                    val=true;
                    System.out.println("Successfully deleted the Product Detail");
                }pos++;

            }
            if(trigger>=0){
                productList.remove(trigger);
            }

            if (!val){ throw new UserDefinedException("\n Sorry !!Product id not found enter an another id\n\n"); }
        }catch(UserDefinedException ud){
            System.out.println(ud.getMessage());
        }

    }

}



class Final{

    private static final String PRODUCT_CSV_FILE_PATH = "./products.csv";
    private static final String WHOLESALERS_CSV_FILE_PATH = "./wholesalers.csv";
    private static final String RETAILERS_CSV_FILE_PATH = "./retailers.csv";
    private static final int LENGTH_OF_PRODUCTS=3;

//    public  static void readcsv(String file_path, String category) throws IOException {
//        try (
//                Reader reader = Files.newBufferedReader(Paths.get(file_path));
//                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
//        ) {
//
//            switch (category) {
//                case "PRODUCT":
//                    Product[] products =new Product[1];
//                    int i=0;
//                    for (CSVRecord csvRecord : csvParser) {
//                        int proId = Integer.parseInt(csvRecord.get(0));
//                        String proName = csvRecord.get(1);
//                        int stock = Integer.parseInt(csvRecord.get(2));
//                        int price = Integer.parseInt(csvRecord.get(3));
//                        products[i] = new Product(proId,proName,stock,price);
//
//                        System.out.println(proId);
//                    }
//                    break;
//
//
//            }
//
//
//        }
//    }


    public static void main(String args[]) throws IOException {
//        readcsv(PRODUCT_CSV_FILE_PATH,"PRODUCT");
//        readcsv(WHOLESALERS_CSV_FILE_PATH,"WHOLESALER");
//        readcsv(RETAILERS_CSV_FILE_PATH,"RETAILER");


        String[] file_paths = { "./products.csv", "./wholesalers.csv", "./retailer.csv"};

        ArrayList<Product> productsList = new ArrayList<Product>();
        ArrayList<Wholesaler> wholesalersList = new ArrayList<Wholesaler>();
        ArrayList<Retailer> retailerList = new ArrayList<Retailer>();

        ArrayList<Product> wholesalersProductList = new ArrayList<Product>();
        ArrayList<Product> retailersProductList = new ArrayList<Product>();



        Product products = new Product();
        Wholesaler wholesaler = new Wholesaler();
        Retailer retailer = new Retailer();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(file_paths[0]));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ){int i = 0;
            for (CSVRecord csvRecord : csvParser) {
                int proId = Integer.parseInt(csvRecord.get(0));
                String proName = csvRecord.get(1);
                int stock = Integer.parseInt(csvRecord.get(2));
                int price = Integer.parseInt(csvRecord.get(3));

                NavigableMap<Integer,Integer> discount=new TreeMap<Integer, Integer>();
                discount.put(0,0);
                discount.put(10, 10);
                discount.put(50, 20);
                discount.put(100, 30);
                products = new Product(proId, proName, stock, price, discount);
                productsList.add(products);
                i++;
            }}

        try (
                Reader reader = Files.newBufferedReader(Paths.get(file_paths[1]));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ){
            int i = 0;
            for (CSVRecord csvRecord : csvParser) {
                int id = Integer.parseInt(csvRecord.get(0));
                String name = csvRecord.get(1);

                wholesaler = new Wholesaler(id, name, wholesalersProductList);
                wholesalersList.add(wholesaler);
                i++;
            }
        }
        try (
                Reader reader = Files.newBufferedReader(Paths.get(file_paths[2]));
                CSVParser  csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        )

        {
            int i = 0;
            for (CSVRecord csvRecord : csvParser) {
                int id = Integer.parseInt(csvRecord.get(0));
                String name = csvRecord.get(1);
                retailer = new Retailer(id, name, retailersProductList );
                retailerList.add(retailer);
                i++;
            }
        }



        Scanner sc = new Scanner(System.in);
        while(true)
        {
            int i =0;
            System.out.println( "\n\n\nWelcome to HUB ... " );
            System.out.println( "1. Products" );
            System.out.println( "2. Wholesaler" );
            System.out.println( "3. Retailer" );
            System.out.println( "Select 4 for EXIT" );
            System.out.print( "\nSelect a module: " );

//            System.out.print( "Select the appropriate options you want to perform: " );

            int op = sc.nextInt( );
            switch( op )
            {
                case 1:
                    System.out.println( "\n\nWelcome to Product ... " );
                    System.out.println( "1. Display all Products" );
                    System.out.println( "2. Add Product" );
                    System.out.println( "3. Delete Product" );
                    System.out.println("4.Exit");
                    System.out.print( "Select the appropriate options you want to perform: " );
                    op = sc.nextInt( );

                    switch( op ) {
                        case 1:
                             products.displayAllProducts(productsList);
                             break;
                        case 2:
                            products.addProducts(productsList);
                            break;
                        case 3:
                            System.out.println("\n Enter product id you want to delete: ");
                            int proId = sc.nextInt();
                            products.deleteProduct(proId,productsList);
                            break;
                        case 4:
                            continue;
//                            System.exit(0);

                    }

                    break;
                case 2:
                    System.out.println( "\n\nWelcome to Wholesaler ... " );
                    System.out.println( "1. Display all Wholesaler" );
                    System.out.println( "2. Add Product to wholesaler" );
                    System.out.println( "3. deallocate Product" );
                    System.out.println("4.Exit");
                    System.out.print( "Select the appropriate options you want to perform: " );
                    op = sc.nextInt( );

                    switch( op ) {
                        case 1:
                             wholesaler.displayAllWholesaler(wholesalersList);
                             break;
                        case 2:
                            System.out.println("\n Enter wholesaler id: ");
                            int whoId = sc.nextInt();

                            System.out.println("\n Enter product id to add: ");
                            int proId = sc.nextInt();

                            System.out.println("\n Enter product quantity you want to add: ");
                            int proqua = sc.nextInt();

                            System.out.println("\n Enter product price you want to set: ");
                            int propri = sc.nextInt();

                            wholesaler.addProductsToWholesaler(whoId,proId,proqua,propri,productsList,wholesalersList);
                            break;
                        case 3:
                            System.out.println("\n Enter wholesaler id : ");
                            whoId = sc.nextInt();

                            System.out.println("\n Enter product id you want to deallocate: ");
                            proId = sc.nextInt();

                            wholesaler.deallocateProduct(whoId,proId,productsList,wholesalersList);
                            break;
                        case 4:
                            continue;
                    }
                    break;
                case 3:
                    System.out.println( "\n\nWelcome to Retailer ... " );
                    System.out.println( "1. Display all Retailer" );
                    System.out.println( "2. Add Product to Retailer" );
                    System.out.println( "3. deallocate Product" );
                    System.out.println("4.Exit");
                    System.out.print( "Select the appropriate options you want to perform: " );
                    op = sc.nextInt( );

                    switch( op ) {
                        case 1:
                             retailer.displayAllRetailer(retailerList);
                             break;
                        case 2:
                            System.out.println("\n Enter retailer id: ");
                            int retId = sc.nextInt();

                            System.out.println("\n Enter wholesaller id: ");
                            int whoId = sc.nextInt();

                            System.out.println("\n Enter product id to add: ");
                            int proId = sc.nextInt();

                            System.out.println("\n Enter product quantity you want to add: ");
                            int proqua = sc.nextInt();

                            System.out.println("\n Enter product price you want to set: ");
                            int propri = sc.nextInt();

                            retailer.addProductsToRetailer(retId,whoId,proId,proqua,propri,wholesalersList,retailerList);
                            break;
                        case 3:
//                            System.out.println("\n Enter retailer id : ");
//                            whoId = sc.nextInt();
//
//                            System.out.println("\n Enter product id you want to deallocate: ");
//                            proId = sc.nextInt();

//                            retailer.deallocateProduct(whoId,proId,wholesalersList,retailerList);
                            break;
                        case 4:
                            continue;
                    }
                    break;
                case 4:
                    System.exit( 0 );
            }
        }
    }



}
