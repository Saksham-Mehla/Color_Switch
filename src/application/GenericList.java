package application;

import java.util.ArrayList;
import java.util.Iterator;

class GenericList<T> implements Iterable<T>{
	private ArrayList<T> list;
	private int length;
	
	public GenericList(){
		this.list = new ArrayList<T>();
		this.length = 0;
	}
	
	public int getLen() {
		return length;
	}
	
	public void add(T o) {
		list.add(o);
	}
	
	public void remove(T o) {
		list.remove(o);
	}
	
	public T get(int index) {
		return list.get(index);
	}
	
	public Iterator<T> iterator(){
		return new ListIterator<T>(this);
	}
}

class ListIterator<T> implements Iterator<T>{
	private T current;
	private int index;
	private GenericList<T> list;
	public ListIterator(GenericList<T> list) {
		this.list = list;
		index = 0;
		current = list.get(0);
	}
	public boolean hasNext() {
		return current!=null;
	}
	
	public T next() {
		T data = current;
		index++;
		current = list.get(index);
		return data;
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
