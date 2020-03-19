public class Triangle implements Shape {
    private double base_size;
    private double height;

    public Triangle(double base_size, double height) {
        this.base_size = base_size;
        this.height = height;
    }

    public double getBase_size() {
        return base_size;
    }

    public void setBase_size(double base_size) {
        this.base_size = base_size;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return height * base_size / 2;
    }
}
