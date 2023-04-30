package containerFruits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {

    public static <T> List<T> toList(T[] array){
        List<T> listT = new ArrayList<>();
        Collections.addAll(listT, array);
        return listT;
    }

}

