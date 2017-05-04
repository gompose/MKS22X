public class MyHeap {
    private int inverter = 1;
    private String[] heapArray;
    private int endIndex = 1;
    private int place;

    public MyHeap () {	
	heapArray = new String[10];
    }
    public MyHeap (boolean max) {
	// if Max == true; heapArray becomes a maxHeapArray;
	// if Max != true; heapArray becomes a minHeapArray;
	if (!max) {
	    inverter = -1;
	}
	heapArray = new String[10];
    }
    private void expand() {
	String[] holder = heapArray;
	String[] newHeapArray = new String[heapArray.length * 2];
	for (int x = 0; x < holder.length; x++) {
	    newHeapArray[x] = holder[x];
	}
	heapArray = newHeapArray;
    }

    public void add (String s) {
	int holder = endIndex;
	if (endIndex > heapArray.length - 1) {
	    heapArray[endIndex] = s;	    
	} else {
	    expand();
	    heapArray[endIndex] = s;
	}
	// Stopped here
	while (
	endIndex++;

    }
	private void pushUp(){};
	private void pushDown(){};
     
	    
}
