package patterns.FactoryExample.entities;

import patterns.FactoryExample.interfaces.Furniture;

public class Chair implements Furniture {

    @Override
    public String createFurniture() {
        return "Chair was created!";
    }
}
