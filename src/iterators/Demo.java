package iterators;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Danila on 28.05.2017.
 */


public class Demo {


    public static void main(String[] args) {
        String[] names={"borsh", "pizza", "humus", "hamburger", "sushi"};
        MenuArray ma = new MenuArray(names);
        MenuArrayList mal = new MenuArrayList(new ArrayList<String>(Arrays.asList(names)));

        /*while(ma.hasNext()){
            System.out.println(ma.next());
        }

        System.out.println();

        /*while(mal.hasNext()){
            System.out.println(mal.next());
        }*/

       /*  for(Item i : ma){
            System.out.println(i);
        }

        System.out.println();

        for(Item i : mal){
            System.out.println(i);
        } */

        ArrayList<MenuComponent> mc = new ArrayList<>();
        mc.add(new Item("tea"));
        mc.add(new Item("coffee"));
        mc.add(mal);
        CompositeIterator ci = new CompositeIterator(mc.iterator());
        while(ci.hasNext()){
            System.out.println(ci.next());
        }




    }
}
