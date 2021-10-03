public class House implements HasArea {
    private double area_total;

    public House(double area_total) {
        this.area_total = area_total;
    }

    public double getArea_total() {
        return area_total;
    }

    public void setArea_total(double area_total) {
        this.area_total = area_total;
    }

    @Override
    public double getArea() {
        return area_total;
    }
}
