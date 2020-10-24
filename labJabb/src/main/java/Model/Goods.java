package Model;

public class Goods {
    private int Category;
    private float Price;
    private String Manufactor;
    public Goods(String Manufactor, int Category, float Price){
        this.Manufactor= Manufactor;
        this.Category = Category;
        this.Price = Price;
    }

 public String getManufactor(){
        return Manufactor;
 }

    public  int getCategory(){
        return Category;
    }

    public  float getPrice(){
        return Price;
    }


}
