package iterators;

import java.util.Iterator;

/**
 * Created by Danila on 29.05.2017.
 */
public class MenuArray implements Iterator, Iterable<Item>{
    Item[] items;
    int pos=0;

    public MenuArray(String[] names) {
        this.items = new Item[names.length];
        for(int i=0; i<names.length;i++){
            items[i]=new Item(names[i]);
        }
    }

    @Override
    public boolean hasNext() {
        if(pos<(items.length))
            return true;
        return false;
    }

    @Override
    public Object next() {
        if(hasNext()) return items[pos++];
        return null;
    }

    @Override
    public Iterator<Item> iterator() {
        return this;
    }
}
