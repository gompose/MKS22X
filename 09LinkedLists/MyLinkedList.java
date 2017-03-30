public class MyLinkedList {



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
