package PiratesSort;

import PiratesSort.DataNode;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Danila on 13.02.2017.
 */
public class PiratesList implements List<DataNode> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<DataNode> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(DataNode dataNode) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends DataNode> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends DataNode> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public DataNode get(int index) {
        return null;
    }

    @Override
    public DataNode set(int index, DataNode element) {
        return null;
    }

    @Override
    public void add(int index, DataNode element) {

    }

    @Override
    public DataNode remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<DataNode> listIterator() {
        return null;
    }

    @Override
    public ListIterator<DataNode> listIterator(int index) {
        return null;
    }

    @Override
    public List<DataNode> subList(int fromIndex, int toIndex) {
        return null;
    }
}
