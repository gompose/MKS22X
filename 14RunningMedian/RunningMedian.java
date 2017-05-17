public class RunningMedian{
    private double currentMedian;
    private MyHeap lesserThan;
    private MyHeap greaterThan;
    public RunningMedian(){
	lesserThan = new MyHeap(true);
	greaterThan = new MyHeap(false);
	currentMedian = 0.0;
    }
    public void add (int n) {
	if (n >=  currentMedian) {
	    greaterThan.add(n);
	} else {
	    lesserThan.add(n);
	}
	recalculate();
    }
    private void recalculate () {
	/*if (lesserThan.getSize() > greaterThan.getSize()) {

	} else {
	    if (lesserThan.getSize() < greaterThan.getSize()) {
		
	    } else {
		currentMedian = ((double)lesserThan.peek() + (double)greaterThan.peek()) / 2;
	    }
	
	}
	*/
	if (lesserThan.getSize() - greaterThan.getSize() >= 2 || greaterThan.getSize() - lesserThan.getSize() <= 2) {
	    // rebalance the two heaps
	    /*	} else {
	    if (lesserThan.getSize() == greaterThan.getSize()) {
	    }
	    if (lesserThan.getSize() - greaterThan.getSize()) = 1) {
	    }
	if (greaterThan.getSize() - lesserThan.getSize()) = 1) {
	    }
}
	    */
    }
    public double getMedian () {
	return currentMedian;
    }
}