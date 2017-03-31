public class MyLinkedList {
    private LNode start;
    private int size;
    
    public MyLinkedList() {
	start = new LNode(0);
	size = 0;
    }
    public boolean add (int value) {
	int index = 0;
	LNode reader = start;
	while (index < size) {
	    reader = reader.next;
	    index++;
	}
	reader.next = new LNode(value);
    }
	

    private class LNode {
	private int value;
	private Node next;
    
	public LNode (int _value, Node nextNode) {
	    value = _value;
	    next = nextNode;
	}
	public LNode (int _value) {
	    value = _value;
	    next = null;
	}
	public LNode (Node nextNode) {
	    value = 0;
	    next = nextNode;
	}
	public LNode () {
	    value = 0;
	    next = null;
	}
    }
}
