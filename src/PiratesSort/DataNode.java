package PiratesSort;

import java.io.Serializable;

/**
 * Created by Danila on 31.01.2017.
 */
public class DataNode implements Comparable<DataNode>, Cloneable, Serializable {
    private String name;

    private int value;

    public DataNode(String n, int v){
        name = n;
        value = v;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (DataNode)super.clone();
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(DataNode o) {
        return value - o.getValue();
    }

    @Override
    public String toString() {
        return name + " " + value;
    }
}
