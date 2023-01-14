public class Product_test {

    int proId;
    String proName;
    int stock;
    int price;
    Product_test(){}
    Product_test(int id, String name, int sto, int pri){
        proId = 5;
        proName = "ruth";
        stock = 20;
        price = 100;
    }

    void dispQuantity(){
        System.out.println("The Stock of the product "+proName+" is "+stock);
    }

    void buyQuantity(int quantity){
        this.stock = this.stock-quantity;
    }


}

//class Wholesaler extends Product_test {
//    int wholesale_price;
//    int wholesale_stock;
//
//    Wholesaler(){}
//
//    Wholesaler( int stoc, int pri){
//        this.wholesale_price = pri;
//        this.wholesale_stock =stoc;
//    }
//
//    @Override
//    void dispQuantity() {
//        super.dispQuantity();
//        System.out.println("The Stock of the product with wholesaler is "+wholesale_stock);
//    }
//
//    void buyQuantity(int quantity){
////        super.buyQuantity(quantity);
//        this.wholesale_stock = wholesale_stock-quantity;
////        return wholesale_stock;
//    }
//
//}
//
//class Retailer extends Wholesaler{
//    int retailprice;
//    int retailstock;
//
//    Retailer(int id , String name, int stock, int pri){
//        retailprice = pri;
//        retailstock = stock;
//    }
//
//    @Override
//    void dispQuantity() {
//        super.dispQuantity();
//        System.out.println("The Stock of the product with retailer is "+retailstock);
//    }
//
//}

//class Test{
//    public static void main(String args[]){
//        Product_test pro1 = new Product_test(111, "Apple", 500, 90000);
////        Product pro2 = new Product(112, "Sony", 300, 60000);
////        Product pro3 = new Product(113, "Moto", 100, 30000);
//        Wholesaler wh = new Wholesaler(10, 99000);
//
//        pro1.dispQuantity();
//
//        wh.dispQuantity();
//        wh.buyQuantity(5);
//        wh.dispQuantity();
//
//        Retailer rh = new Retailer(111, "Apple", 5, 5000);
//
//        rh.dispQuantity();
//
//    }}