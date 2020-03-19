import java.sql.SQLOutput;

public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        Circle circle = new Circle(3);
        Square square = new Square(5);
        Ellipse ellipse = new Ellipse(4,2);
        Rectangle rectangle = new Rectangle(10,5);
        Triangle triangle = new Triangle(6,3);

        aggregator.addShape(circle);
        aggregator.addShape(square);
        aggregator.addShape(ellipse);
        aggregator.addShape(rectangle);
        aggregator.addShape(triangle);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
    }
}
