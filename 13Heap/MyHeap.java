public class MyHeap {
    private int inverter = 1;
    private String[] heapArray = new String[10];
    private int endindex = 1;
    public MyHeap () {	
    }
    public MyHeap (boolean max) {
	if (!max) {
	    inverter = -1;
	}
    }

}
