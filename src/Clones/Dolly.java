package Clones;

/**
 * Created by Danila on 14.02.2017.
 * Object's clone() method probably just checks it using: this instanceof Cloneable.
 * The reason that the clone() method is defined in the Object class, is because some 'magic' is needed to actually make a clone.
 * First of all, a new object has to be created without the use of a constructor.
 * Secondly, the object has to be of the same type as the original object, even though the original may only know its exact type at runtime.
 * The designers probably felt it was easiest to put all this magic in the Object class, since it is a bit special to begin with.
 *
 * Also, note that clone() and Cloneable have been around since the very beginning, or nearly so.
 * A lot of decisions were made in the early days of Java where the designers didn't have the complete picture yet
 * and didn't know where Java's path would lead. or else they simply had to go with what was the most expedient
 * at the time in order to meet a release date.
 */
class Sheep{
    public int getNum() {
        return num;
    }

    protected int num;

    Sheep(int n){
        num=n;
    }
}

public class Dolly extends Sheep implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    Dolly(String s){
        super(5);
        name=s;
    }

    /*    public Object clone() throws CloneNotSupportedException { //if not clonable will throw exception
        return super.clone();
    }*/

    public Dolly clone() throws CloneNotSupportedException{
        return (Dolly) super.clone();
    }


    Dolly(Dolly other){ //copy constructor
        super(other.getNum());
        name=other.name;
    }

    @Override
    public int hashCode() {
        return this.getNum();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode()==obj.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Dolly d1 = new Dolly("Dolly1");
        Dolly d2 = d1.clone();//(Dolly)d1.clone();
        Dolly d3 = new Dolly(d1);

        System.out.println(d2 + "; equals:" + d1.equals(d2) + "; ==" + (d1==d2));
        System.out.println(d3 + "; equals:" + d1.equals(d3) + "; ==" + (d1==d3));

        System.out.println(d1.hashCode());
        System.out.println(d2.hashCode());
        System.out.println(d3.hashCode());
    }
}
