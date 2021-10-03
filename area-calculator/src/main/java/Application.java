import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

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
        Line line = new Line(7);
        House house1 = new House(150);
        House house2 = new House(300);

        aggregator.addShape(circle);
        aggregator.addShape(square);
        aggregator.addShape(ellipse);
        aggregator.addShape(rectangle);
        aggregator.addShape(triangle);
        aggregator.addShape(line);

        aggregator.addArea(circle);
        aggregator.addArea(square);
        aggregator.addArea(ellipse);
        aggregator.addArea(rectangle);
        aggregator.addArea(triangle);
        aggregator.addArea(house1);
        aggregator.addArea(house2);

        aggregator.drawAll();

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());

        List<House> houses = new ArrayList<>();
        houses.add(house1);
        houses.add(house2);

        City city = new City(houses);

        AreaStringOutputter cityStringOutputter = new AreaStringOutputter(city);
        AreaXMLOutputter cityXmlOutputter = new AreaXMLOutputter(city);

        System.out.println(cityStringOutputter.output());
        System.out.println(cityXmlOutputter.output());
    }
}
