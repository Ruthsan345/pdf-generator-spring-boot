import java.util.ArrayList;
import java.util.Scanner;

import UserDefinedException.UserDefinedException;

public class Wholesaler extends Product {
    int wholesale_id;
    String wholesale_name;
    ArrayList<Product> wholesale_products =new ArrayList<Product>();;


    Wholesaler() {
    }

    Wholesaler(int id, String name, ArrayList<Product> wholesalerList) {
        this.wholesale_id = id;
        this.wholesale_name = name;
        this.wholesale_products = new ArrayList<Product>();
}


    void displayAllWholesaler(ArrayList<Wholesaler> wholesalerList) {

        try{
            if (wholesalerList.isEmpty()){throw new UserDefinedException("\n Sorry !!No wholesaler to Display\n\n");}
            for(Wholesaler n : wholesalerList){
                System.out.println("\n\n<---------------------------------------------------->");

                System.out.println("\nWholesaler id : "+n.wholesale_id);
                System.out.println("Wholesaler name : "+n.wholesale_name);
                System.out.println("Products Assigned are: \n");
                try{
                if (n.wholesale_products.isEmpty()){throw new UserDefinedException("\n Sorry !!No Products for this wholesalers to display\n\n");}
                for(Product pro : n.wholesale_products){
                    System.out.println("\nWholesaler Product id : "+pro.proId);
                    System.out.println("Wholesaler Product Name : "+pro.proName);
                    System.out.println("Wholesaler Product Stock : "+pro.stock);
                    System.out.println("Wholesaler Product Price : "+pro.price);
                }
                }catch(UserDefinedException ud){
                    System.out.println(ud.getMessage());
                }

                System.out.println("\n <--------------------------------------------------> \n");
            }
        }catch(UserDefinedException ud){
            System.out.println(ud.getMessage());
        }


    }

    void addProductsToWholesaler(int whoid,int proid, int quantity, int price, ArrayList<Product> productList, ArrayList<Wholesaler> wholesalerList){

        try{
            if (wholesalerList.isEmpty()){throw new UserDefinedException("\n Sorry !!No wholesalers to Display\n\n");}
            for(Wholesaler n : wholesalerList){

                if(n.wholesale_id == whoid){
                    for(Product pro : productList){
                        if(pro.proId== proid){
                            if (pro.stock< quantity){throw new UserDefinedException("\n Stocks are low. kindly try a small number\n\n");}
                            Product pros = new Product(pro.proId, pro.proName, quantity, price );
                            n.wholesale_products.add(pros);
                            pro.stock=pro.stock-quantity;
                            System.out.println("Sucessfully added stocks");
                        }
                    }

                }
            }
            System.out.println("\n <--------------------------------------------------> \n");

        }catch(UserDefinedException ud){
            System.out.println(ud.getMessage());
        }
    }

    void deallocateProduct(int whoid,int proid, ArrayList<Product> productList, ArrayList<Wholesaler> wholesalerList){

        try{
            int quantity;
            int flag=-1;

            if (wholesalerList.isEmpty()){throw new UserDefinedException("\n Sorry !!No wholesalers to Display\n\n");}
//            Scanner sc = new Scanner(System.in);
//            System.out.println( " Deallocate product" );
//            System.out.println( "1. Deallocate Entire Product" );
//            System.out.println( "2. Deallocate particular quantity" );
//            int option = sc.nextInt( );
//            switch( option ) {
//                case 1:
                    for(Wholesaler n : wholesalerList){
                        if(n.wholesale_id == whoid){
                            for(Product pro : productList){
                                if(pro.proId== proid){
                                    flag++;

                                    for(Product prod: n.wholesale_products){
                                        pro.stock=pro.stock+ prod.stock;
                                    }
                                    System.out.println("Sucessfully deallocated from wholesaller and added stocks back to product");
                                }
                            }
                            n.wholesale_products.remove(flag);

                        }
                    }
//                    break;
//            }
            System.out.println("\n <--------------------------------------------------> \n");
        }catch(UserDefinedException ud){
            System.out.println(ud.getMessage());
        }
    }

}