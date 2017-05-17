import java.util.*;

public class MyHeap {
    private int inverter;
    private int[] heapArray;
    public int endIndex;

    public MyHeap () {	
	heapArray = new int[10];
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
	heapArray = new int[10];
    }
    public int getSize() {
	return endIndex - 1;
    }
    private void expand() {
	int[] holder = heapArray;
	int[] newHeapArray = new int[heapArray.length * 2];
	for (int x = 0; x < holder.length; x++) {
	    newHeapArray[x] = holder[x];
	}
	heapArray = newHeapArray;
    }

    public void add (int s) {
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
    public int remove(){
	int holder = heapArray[1];
	endIndex--;
	swap (1, endIndex);
	pushDown(1);
	heapArray[endIndex] = 0;
	return holder;
    }
    public int peek() {
	return heapArray[1];
    }	 
    private void pushUp(){
	int currentIndex = endIndex;
	while (hasParent(currentIndex)) {
	    if (heapArray[currentIndex] * inverter <= heapArray[currentIndex / 2] * inverter) {
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
	    if(heapArray[index1] * inverter <= heapArray[index2] * inverter) {
		if(heapArray[index1] * inverter <= heapArray[current] * inverter) {
		    swap(index1, current);
		    pushDown(index1);
		}		    			
	    } else {
		int holder = index1;
		index1 = index2;
		index2 = holder;
		if(heapArray[index1] * inverter <= heapArray[current] * inverter) {
		    swap(index1, current);
		    pushDown(index1);
		}
	    }
	}else {
	    if (hasChildren == 1){
		if(heapArray[index1] * inverter <= heapArray[current] * inverter){
		    swap(index1, current);
		    pushDown(index1);
		}
	    }
	}
    }
	    
    private void swap (int index1, int index2){
	int holder = heapArray[index1];
	heapArray[index1] = heapArray[index2];
	heapArray[index2] = holder;
    }
    public String toString() {
	return Arrays.toString(heapArray);
    }
    public static void main(String[] args) {
	MyHeap heap1 = new MyHeap(false);
	heap1.add(1);
	heap1.add(2);
	heap1.add(3);
	heap1.add(26);
	heap1.add(90);
	heap1.add(0);
	heap1.add(504);
	System.out.println(heap1);
	System.out.println(heap1.endIndex);
	System.out.println(heap1.remove());
	System.out.println(heap1.remove());
	System.out.println(heap1);
	
    }
	    
}
