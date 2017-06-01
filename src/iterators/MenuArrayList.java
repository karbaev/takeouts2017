package iterators;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Danila on 29.05.2017.
 */
public class MenuArrayList extends MenuComponent implements Iterator, Iterable<Item> {
    ArrayList<Item> items;
    Iterator it;

    public MenuArrayList(ArrayList<String> names) {
        this.items = new ArrayList<Item>();
        for (String name : names) {
            this.items.add(new Item(name));
        }
        it=this.items.iterator();
    }
    @Override
    public boolean hasNext() {
        if (it.hasNext()) return true;
        return false;
    }

    @Override
    public Object next() {
        return it.next();
    }

    @Override
    public Iterator<Item> iterator() {
        return it;
    }

    Iterator createIterator(){
        return this;
    }

}
