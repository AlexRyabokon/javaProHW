package patterns.FactoryExample;

import patterns.FactoryExample.entities.Chair;
import patterns.FactoryExample.entities.Table;
import patterns.FactoryExample.enums.FurnitureEnum;
import patterns.FactoryExample.interfaces.Furniture;

public class FurnitureFabric {
    public Furniture createFurniture(FurnitureEnum furnitureEnum) {
        if (furnitureEnum.equals(FurnitureEnum.CHAIR)) {
            return new Chair();
        } else if (furnitureEnum.equals(FurnitureEnum.TABLE)) {
            return new Table();
        } else {
            throw new RuntimeException("Invalid furniture type.");
        }
    }
}
