import java.util.Date;

public class FoodItem extends GenericItem {
    public Date dateOfInCome;
    public short expires;
    @Override
    public void printAll() {
        super.printAll();
        System.out.printf(" expires: %s \n", expires);
    }
}
