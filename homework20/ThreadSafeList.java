package homework20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafeList<T> {

    private final List<T> list = Collections.synchronizedList(new ArrayList<>());

    public void add(T value) {
        synchronized (list) {
            list.add(value);
        }
    }

    public void remove(T value) {
        synchronized (list) {
            list.remove(value);
        }
    }

    public T get(int index) {
        synchronized (list) {
            return list.get(index);
        }
    }
}
