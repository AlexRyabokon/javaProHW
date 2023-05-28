import patterns.BuilderExample.entities.Car;
import patterns.StrategyExample.entities.Figure;
import patterns.StrategyExample.entities.Rectangle;
import patterns.BuilderExample.CarDirector;
import patterns.StrategyExample.RectangleStrategy;
import patterns.BuilderExample.SportsCarBuilder;
import patterns.FactoryExample.enums.FurnitureEnum;
import patterns.BuilderExample.interfaces.Builder;
import patterns.FactoryExample.interfaces.Furniture;
import patterns.FactoryExample.FurnitureFabric;

public class Main {
    public static void main(String[] args) {
        FurnitureFabric factory = new FurnitureFabric();

        Furniture chair = factory.createFurniture(FurnitureEnum.CHAIR);
        System.out.println(chair.createFurniture());

        Furniture table = factory.createFurniture(FurnitureEnum.TABLE);
        System.out.println(table.createFurniture());
        System.out.println(table);

        CarDirector director = new CarDirector();
        Builder sportsCarBuilder = new SportsCarBuilder();

        Car sportsCar = director.buildCar(sportsCarBuilder);
        System.out.println(sportsCar);

        Figure rectangle = new Rectangle(5, 10);
        rectangle.setStrategy(new RectangleStrategy());
        double rectangleArea = rectangle.computeArea();
        System.out.println(rectangleArea);

    }
}