// Sam Pirkl

import java.util.*;
import java.io.*;

public class List<T> {

    protected ArrayList<T> list;
    public List() {
        list = new ArrayList<T>();
    }

    public void add(T item) {
        list.add(item);
    }
}