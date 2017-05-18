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
	int currentLesser = lesserThan.getSize();
	int currentGreater = GreaterThan.getSize();
	if (currentLesser - currentGreater >= 2) {
	    greaterThan.add(lesserThan.remove());
	    recalculate();
	}
	if (currentGreater - currentLesser >= 2){
	    lesserThan.add(greaterThan.remove());
	    recalculate();
	}
	if (currentGreater - currentLesser == 1){
	    currentMedian = currentGreater.peak();
	}
	if (currentLesser - currentGreater == 1){
	    currentMedian = currentLesser.peak();
	}
	if (currentLesser == currentGreater) {
	    currentMedian = ((double) greaterThan.peak() + (double) lesserThan.peak()) / 2
	}
    }
    public double getMedian () {
	return currentMedian;
    }
}
