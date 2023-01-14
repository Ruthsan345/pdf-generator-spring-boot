import UserDefinedException.UserDefinedException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Retailer extends Wholesaler {
    int retail_id;
    String retail_name;
    ArrayList<Product> retail_products =new ArrayList<Product>();;


    Retailer(){}

    Retailer( int id, String name,ArrayList<Product> retailersList){
        this.retail_id = id;
        this.retail_name = name;
        this.retail_products = new ArrayList<Product>();

    }

    void displayAllRetailer(ArrayList<Retailer> retailersList){

        try{
            if (retailersList.isEmpty()){throw new UserDefinedException("\n Sorry !!No Retailer to Display\n\n");}
            for(Retailer n : retailersList){
                System.out.println("\n\n<---------------------------------------------------->");

                System.out.println("\nRetailer id : "+n.retail_id);
                System.out.println("Retailer name : "+n.retail_name);
                System.out.println("Products Assigned are: \n");
                try{
                    if (n.retail_products.isEmpty()){throw new UserDefinedException("\n Sorry !!No Products for this Retailer to display\n\n");}
                    for(Product pro : n.retail_products){
                        System.out.println("\nRetailer Product id : "+pro.proId);
                        System.out.println("Retailer Product Name : "+pro.proName);
                        System.out.println("Retailer Product Stock : "+pro.stock);
                        System.out.println("Retailer Product Price : "+pro.price);
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


    void addProductsToRetailer(int retId,int whoid,int proid, int quantity, int price, ArrayList<Wholesaler> wholesalerList,ArrayList<Retailer> retailersList ){

        try{
            if (retailersList.isEmpty()){throw new UserDefinedException("\n Sorry !!No wholesalers to Display\n\n");}
            for(Retailer n : retailersList){
                if(n.retail_id == retId){
                    for(Wholesaler whole : wholesalerList){
                        if(whole.wholesale_id==whoid){
                            for(Product pro:whole.wholesale_products) {
                                System.out.println(pro.discount.get(57)+"-->>>>"+pro.discount.floorKey(57));
//                                System.out.println(pro.discount.get(57)+"-->>>>");
                                if (pro.proId == proid) {
                                    if (pro.stock < quantity) {
                                        throw new UserDefinedException("\n Stocks are low. kindly try a small number\n\n");
                                    }
                                    NavigableMap<Integer,Integer> discount=new TreeMap<Integer, Integer>();




                                    int billAmount =  pro.price*quantity;
                                    float discountPercentage = pro.discount.get(pro.discount.floorKey(quantity))/100f;

                                    float totalAfterOffer= billAmount - billAmount*discountPercentage;
                                    float gstAmount = totalAfterOffer*(18/100f);
                                    float grandBillAmount= totalAfterOffer+gstAmount;


                                    System.out.println("\n\n\n\t\t\t<------Bill Amount----->");
                                    System.out.println("\n\t\tProduct :: "+ pro.proName + "\n\t\tQuantity :: "+quantity);
                                    System.out.print("\n\t\tBill amount :: "+billAmount+"\n\t\tOffer percentage :: "+pro.discount.get(pro.discount.floorKey(quantity)));
                                    System.out.print("\n\t\tGST Percentage :: 18%\n\t\tGST Amount :: "+gstAmount);

                                    System.out.print("\n\t\tGrand bill amount :: "+grandBillAmount);
                                    PDFGenerator pdfWriter = new PDFGenerator();
                                    pdfWriter.generateBill(false,n.retail_id, n.retail_name, pro,quantity, billAmount, pro.discount.get(pro.discount.floorKey(quantity)),gstAmount, grandBillAmount);

                                    System.out.println("\n\n\t\tSucessfully Purchased");




                                    Product pros = new Product(pro.proId, pro.proName, quantity, price,discount);
                                    n.retail_products.add(pros);
                                    pro.stock = pro.stock - quantity;
                                }
                            }

                        }

                    }

                }
            }
            System.out.println("\n <--------------------------------------------------> \n");

        }catch(UserDefinedException ud){
            System.out.println(ud.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    void deallocateProduct(int whoid,int proid, ArrayList<Product> productList, ArrayList<Wholesaler> wholesalerList){
//
//        try{
//            int flag=-1;
//
//            if (wholesalerList.isEmpty()){throw new UserDefinedException("\n Sorry !!No re to Display\n\n");}
//
//
//            Scanner sc = new Scanner(System.in);
//            System.out.println( " Deallocate product" );
//            System.out.println( "1. Deallocate Entire Product" );
////            System.out.println( "2. Deallocate particular quantity" );
//
//            int option = sc.nextInt( );
//            switch( option ) {
//                case 1:
//                    for(Wholesaler n : wholesalerList){
//                        if(n.wholesale_id == whoid){
//                            for(Product pro : productList){
//                                if(pro.proId== proid){
//                                    flag++;
//
//                                    for(Product prod: n.wholesale_products){
//                                        pro.stock=pro.stock+ prod.stock;
//                                    }
//                                    System.out.println("Sucessfully deallocated from retailer and added stocks back to product");
//                                }
//                            }
//                            n.wholesale_products.remove(flag);
//
//                        }
//                    }
//
//
//                    break;
//            }
//
//            System.out.println("\n <--------------------------------------------------> \n");
//
//        }catch(UserDefinedException ud){
//            System.out.println(ud.getMessage());
//        }
//    }

//    @Override
//    void dispQuantity() {
//        super.dispQuantity();
//        System.out.println("The Stock of the product with wholesaler is "+wholesale_stock);
//    }

//    void buyQuantity(int quantity){
////        super.buyQuantity(quantity);
//        this.wholesale_stock = wholesale_stock-quantity;
////        return wholesale_stock;
//    }

}