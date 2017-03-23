public class PartitionPair{
    private int[] array;
    private int low;
    private int high;
    private int min;
    private int max;
    public PartitionPair(int[] arry, int lo, int hi){
	array = arry;
	low = lo;
	high = hi;
    }
    public int[] getArray() {
	return array;
    }
    public int getLow(){
	return low;
    }
    public int getHigh(){
	return high;
    }
    public void setMin(int _min){
	min = _min;
    }
    public int getMin(){
        return min;
    }
    public void setMax(int _max){
	max = _max;
    }
    public int getMax(){
	return max;
    }
}
