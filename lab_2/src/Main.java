public class Main {
    public static void main(String[] args) {
        GenericItem a1 = new GenericItem();
        a1.ID = 1;
        a1.price = 3000.00f;
        a1.name = "n1";
        GenericItem a2 = new GenericItem();
        a2.ID = 2;
        a2.price = 3000.00f;
        a2.name = "n1";
        GenericItem a3 = new GenericItem();
        a3.ID = 3;
        a3.price = 3000.00f;
        a3.name = "n1";
        a1.printAll();
        a2.printAll();
        a3.printAll();

        a1.analog = a3;
        System.out.println(a1.analog.ID);

        FoodItem f1 = new FoodItem();
        TechnicalItem t1 = new TechnicalItem();
        GenericItem[] g1 = {f1, t1};
        for(GenericItem item : g1) {
            item.printAll();
        }
    }
}