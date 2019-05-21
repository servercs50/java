public class GenericItem {
    public int ID;
    public String name;
    public float price;
    public GenericItem analog;
    public Category category = Category.General;
    public void printAll() {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f , Category:%s \n",ID,name,price,category);
    }
}
