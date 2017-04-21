import java.lang.*;
import java.util.*;

public class MyLinkedList implements Iterable<Integer>{
    // Implement iterable up here ^
    private LNode start, end;
    private int size;
    
    public MyLinkedList() {
	size = 0;
    }
    public MyLinkedList(LNode first) {
	start = first;
	end = first;
	size = 1;
    }

    
    public Iterator<Integer> iterator(){
	return new MLLIterator();
    }
    
    
    public int size () {
	return size;
    }
    public boolean add (int value) {
	if (size == 0) {
	    start = new LNode(value);
	    end = start;
	    size++;
	} else {
	    end.next = new LNode(value);
	    end.next.prev = end;
	    end.next.next = null;
	    end = end.next;
	    size++;
	}
	return true;
    }
    public void add (int value, int index) {
	LNode holder;
	if (index > size || index < 0) {
	    throw new IllegalArgumentException("Illegal Index: " + index);
	}
        if (index == size - 1) {
	    add(value);
	    end = end.next;
	    size++;
	} 
	if (index == 0) {
	    start.prev = new LNode(value);
	    start.prev.next = start;
	    start = start.prev;
	    size++;
	} else {
	    LNode current = start;
	    for(int x = 0; x < index; x++){
		current = current.next;
	    }
	    holder = current.next;
	    current.next = new LNode(value, current, holder);
	    holder.prev = current.next;
	    size++;
	}
    }
    private int getNthLNode(int index){
	int counter = index;
	LNode current = start;
	while (counter != 0) {
	    current = current.next;
	    counter--;
	}
	return current.value;
    }
    private void addAfter(LNode location, LNode toBeAdded) {
	LNode holder;
	if (size == 0){
	    add(toBeAdded.value);
	}else{
	    if(location == start){
		add(0, toBeAdded.value);
	    }else{
		if(location == end){
		    add(size - 1, tobeAdded.value);
		}else{
		    holder = location.next;
		    location.next = toBeAdded;
		    toBeAdded.prev = location;
		    holder.prev = toBeAdded;
		    toBeAdded.next = holder;
		    size++;
		}
	    }
	}
    }
    private void remove(LNode target) {
	LNode holder1, holder2;
	if (target == start) {
	    start = start.next;
	    start.prev = null;
	    size--;
	}else{
	    if (target == end) {
		end = end.prev;
		end.next = null;
		size--;
	    }else{
		holder1 = target.prev;
		holder2 = target.next;
		holder1.next = holder2;
		holder2.prev = holder1;
		size--;
	    }
	}
    }
	    		    
    public int get(int index){
	int counter = index;
	LNode current = start;
	while (counter != 0) {
	    current = current.next;
	    counter--;
	}
        return current.value;
    }
    public int set(int index, int value){
	int counter = index;
	LNode current = start;
	int holder = 0;
	while (counter != 0) {
	    current = current.next;
	    counter--;
	}
	holder = current.value;
	current.value = value;
	return holder;
    }
    public int indexOf(int value) {
	LNode current = start;
	int currentIndex = 0;
	int index;
	while (current != end){
	    if (current.value == value){
		index = currentIndex;
	    }
	    current = current.next;
	    currentIndex++;
	}
	return index;
    }
    public int remove (int index) {
	int counter = index;
	LNode current = start;
	int holder = 0;
	while (counter != 0){
	    current = current.next;
	    counter--;
	}
	holder = current.value;
	remove(current);
	return holder;
    }
	
	    
    
    public String toString() {
	int index = 0;
	LNode current = start;
	String newString = "[";
	String startInfo = "[";
	String endInfo = "[";
	if (start.prev == null) {
	    startInfo = startInfo + "(null)";
	} else {
	    startInfo = startInfo + "(" + start.prev.value + ")";
	}
	startInfo = startInfo + start.value;
	if (start.next == null) {
	    startInfo = startInfo + "(null),";
	} else {
	    startInfo = startInfo + "(" + start.next.value + "),";
	}
	startInfo += "]";
	if (end.prev == null) {
	    endInfo = endInfo + "(null)";
	} else {
	    endInfo = endInfo + "(" + end.prev.value + ")";
	}
	endInfo = endInfo + end.value;
	if (end.next == null) {
	    endInfo = endInfo + "(null),";
	} else {
	    endInfo = endInfo + "(" + end.next.value + "),";
	}
	endInfo += "]";
	while (current.next != null) {
	    if (current.prev == null) {
		newString = newString + "(null)";
	    } else {
		newString = newString + "(" + current.prev.value + ")";
	    }
	    newString = newString + current.value;
	    if (current.next == null) {
		newString = newString + "(null),";
	    } else {
		newString = newString + "(" + current.next.value + "),";
	    }
	    current = current.next;
	}
	 if (current.prev == null) {
		newString = newString + "(null)";
	    } else {
		newString = newString + "(" + current.prev.value + ")";
	    }
	    newString = newString + current.value;
	    if (current.next == null) {
		newString = newString + "(null),";
	    } else {
		newString = newString + "(" + current.next.value + "),";
	    }
	    current = current.next;
	newString += "]";
	newString = newString + "\n" + "Start Node: ";
	newString += startInfo;
	newString = newString + "\n" + "End Node: ";
	newString += endInfo;
	newString = newString + "\n" + "Size: " + size;
	
	return newString;
    }

	    
	       
    
    /*
    public boolean add (int value) {
	int index = 0;
	LNode reader = start;
	while (index < size) {
	    reader = reader.next;
	    index++;
	}
	reader.next = new LNode(value);
	}
    */

    
    private class MLLIterator implements Iterator<Integer> {
	private LNode current = start;
	public boolean hasNext() {
	    return current.next != null;
	}
	public Integer next() {
	    if (hasNext()) {
		Integer holder;
		holder = current.value;
		current = current.next;
		return holder;
	    } else {
		throw new NoSuchElementException();
	    }
	}
	
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    
    }
   

    private class LNode {
	private int value;
	private LNode next;
	private LNode prev;
    
	public LNode (int _value, LNode nextNode, LNode prevNode) {
	    value = _value;
	    next = nextNode;
	    prev = prevNode;
	}
	public LNode (int _value) {
	    value = _value;
	}
        /*public LNode (int _value, LNode _node, int position) {
	    value = _value;
	    if (position != -1 || position != 1) {
		throw new IllegalArgumentException("Invalid Index");
	    }
	    if (position == 1) {
		LNode.next = _node;
	    } else {
		LNode.prev = _node;
	    }
	}
	*/
    }
}
