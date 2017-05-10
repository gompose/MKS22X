import java.util.*;

public class MyHeap {
    private int inverter;
    private String[] heapArray;
    public int endIndex;
    private int place;

    public MyHeap () {	
	heapArray = new String[10];
	inverter = -1;
	endIndex = 1;
    }
    public MyHeap (boolean max) {
	// if Max == true; heapArray becomes a maxHeapArray;
	// if Max == false; heapArray becomes a minHeapArray;
	if (!max) {
	    inverter = 1;
	} else {
	    inverter = -1;
	}
	endIndex = 1;
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
	if (endIndex < heapArray.length - 1) {
	    heapArray[endIndex] = s;	    
	} else {
	    expand();
	    heapArray[endIndex] = s;
	}
	heapArray[endIndex] = s;
	pushUp();
    }

	
    private boolean hasParent(int index) {
	return index / 2 != 0;
    }
    
    //private int selectMostChild(int index) {
	//heapArray[index * 2].compareTo(heapArray[(index * 2) + 1]) > inverter;
    //}
    public String remove(){
	endIndex--;
	swap (1, endIndex);
	pushDown(1);
    }
    public String peek() {
	return heapArray[1];
    }	 
    private void pushUp(){
	int currentIndex = endIndex;
	while (hasParent(currentIndex)) {
	    if (heapArray[currentIndex].compareTo(heapArray[currentIndex / 2]) * inverter >= 0) {
		swap(currentIndex, currentIndex/2);
		currentIndex = currentIndex / 2;
	    } else {
		currentIndex = 0;
	    }
	}
	endIndex++;
    }
    private void pushDown(int current){
	int index1 = current * 2;
	int index2 = current * 2 + 1;
	int hasChildren = 0;
	if (index1 < endIndex) {
	    hasChildren++;
	}
	if (index2 < endIndex) {
	    hasChildren++;
	}
	if (hasChildren == 2) {
	    //Left off here!
	    
	} else {
	    if (hasChildren == 1){

	    }
	}
    }
	    
	
	//while (hasChildren(currentIndex)) {
    }
    private void swap (int index1, int index2){
	String holder = heapArray[index1];
	heapArray[index1] = heapArray[index2];
	heapArray[index2] = holder;
    }
    public String toString() {
	return Arrays.toString(heapArray);
    }
    public static void main(String[] args) {
	MyHeap heap1 = new MyHeap(true);
	heap1.add("Hello");
	heap1.add("Does this Work");
	heap1.add("A");
	heap1.add("Y");
	heap1.add("T");
	heap1.add("Z");
	heap1.add("Z");
	System.out.println(heap1);
	System.out.println(heap1.endIndex);
	
    }
	    
}
