import java.util.ArrayList;
import java.util.List;

public class AreaAggregator {
    private List<HasArea> areas = new ArrayList<>();
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void addArea(HasArea area) {
        areas.add(area);
    }

    public double sum() {
        double sum = 0;
        for (HasArea area : areas) {
            sum += area.getArea();
        }
        return sum;
    }

    public void drawAll() {
        for (Drawable shape : shapes) {
            shape.draw();
        }
    }
}