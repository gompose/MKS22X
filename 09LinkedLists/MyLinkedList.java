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
	    end = end.next;
	    size++;
	}
    }
    public void add (int value, int index) {
	if (index >= size) {
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
	    current.next.prev = new LNode(value, current.next, )
		
    
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
	    next = null;
	    prev = null;
	}
	public LNode (LNode nextNode) {
	    value = 0;
	    next = nextNode;
	}
	public LNode () {
	    value = 0;
	    next = null;
	}
    }
}
