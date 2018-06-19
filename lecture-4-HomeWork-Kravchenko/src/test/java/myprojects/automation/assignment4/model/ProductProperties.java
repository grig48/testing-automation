package myprojects.automation.assignment4.model;


public class ProductProperties {

    //  Generates product properties
  private static String productName = ProductData.generate().getName();
  private static String productQuantity = String.valueOf(ProductData.generate().getQty()) ;
  private static String productPrice = ProductData.generate().getPrice();

    public static String getProductName() {
        return productName;
    }

    public static String getProductPrice() {
        return productPrice;
    }

    public static String getProductQuantity() {
        return productQuantity;
    }
}
