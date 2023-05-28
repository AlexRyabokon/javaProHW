package patterns.FactoryExample.entities;

import patterns.FactoryExample.interfaces.Furniture;

public class Table implements Furniture {

    @Override
    public String createFurniture() {
        return "Table was created!";
    }
}
