package iterators;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by Danila on 29.05.2017.
 */
public class CompositeIterator implements Iterator {
    Stack stack = new Stack();

    public CompositeIterator(Iterator iterator){
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if(stack.empty()) {
            return false;
        } else {
            Iterator it = (Iterator) stack.peek();
            if (!it.hasNext()) {
                stack.pop();
                return hasNext();
            }
            else return true;
        }
    }

    @Override
    public Object next() {
        if(hasNext()){
            Iterator it = (Iterator) stack.peek();
            MenuComponent component = (MenuComponent) it.next();
            if(component instanceof MenuArrayList){
                stack.push(component.createIterator());
            }
            return component;
        }
        else return null;
    }
}
