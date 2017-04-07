import java.lang.*;

public class MyLinkedList {
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
    public void add (int value) {
	if (size = 0) {
	    start = new LNode(value);
	    size++;
	} else {
	    end.next = new LNode(value);
	    end.next.prev = end;
	    end.next.next = null;
	    end = end.next;
	    size++;
	}
    }
    public void add (int value, int index) {
	LNode holder;
	if (index > size || index < 0) {
	    throw new IllegalArgumentException("Illegal Index: " + index);
	}
        if (index == size) {
	    add(value);
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
	}
    }

    public String toString() {
	int index = 0;
	LNode current = start;
	String newString = "[";
	while (current.next != null) {
	    newString = newString + "(" + current.prev.value + ")";
	    newString = newString + current.value;
	    newString = newString + 

	    
	       
    
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
        public LNode (int _value, LNode _node, int position) {
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
    }
}
