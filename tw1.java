import java.util.*;

//import javax.security.sasl.SaslException;
class product {
   private int id;
   private String Name;
   private double price;
   private int qunatity;

   public product(int id, String Name, double price, int qunatity) {
      this.id = id;
      this.Name = Name;
      this.price = price;
      this.qunatity = qunatity;
   }

   public int getId() {
      return id;
   }

   public String getName() {
      return Name;
   }

   public double getprice() {
      return price;
   }

   public int getqunatity() {
      return qunatity;
   }

   public void setprice(double price) {
      this.price = price;
   }

   public void setqunatity(int qunatity) {
      this.qunatity = qunatity;
   }

   public String toString() {
      return "Id:" + id + ",name:" + Name + ",price:RS " + price + ",Qunatity :" + qunatity;
   }

}

class tw1 {
   public static ArrayList<product>invent=new ArrayList<>(){

    
     
    public static void main(String[] args) {
     Scanner sc =new Scanner(System.in);
     while (true) {
        System.out.println("1. Add product");
        System.out.println("2. view the all product");
        System.out.println("3. search the all product");
        System.out.println("4. update the product");
        System.out.println("5. remove the product");
        System.out.println("6. exit");
        System.out.println("choice an option");
        int choice=sc.nextInt();
        sc.nextLine();
       
     }
        
     }
        
   }
}
