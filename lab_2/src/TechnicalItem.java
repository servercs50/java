public class TechnicalItem extends GenericItem {
    public short warrantyTime;
    @Override
    public void printAll() {
        super.printAll();
        System.out.printf("warrantyTime: %s \n", warrantyTime);
    }
}
