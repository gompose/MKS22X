import java.util.*;

public class Quick{

    // public static int[] quickSort(int[]data]);
    public static int quickSelect(int[] data, int index) {
	PartitionPair holder = part(data, 0, data.length - 1);
	int actual = selectRecurse(data, index, holder);
	return actual;
    }
    private static int selectRecurse(int[] data, int index, PartitionPair holder) {
	if (holder.getLow() <= index && holder.getHigh() >= index) {
	    return data[holder.getLow() + holder.getHigh() / 2];
	} else {
	    if (holder.getLow() > index) {
		PartitionPair hold1 = part(data, holder.getMin(), holder.getLow());
		return selectRecurse(hold1.getArray(), index, hold1);
	    }else{			 
		PartitionPair hold2 = part(data, holder.getHigh(), holder.getMax());
		return selectRecurse(hold2.getArray(), index, hold2);
	    }
	}
    }

	       

    public static PartitionPair part (int[] data, int start, int end){
	int pivot = randomWithRange(start, end);
	// A random pivot within the starting range;
	int[] subArray = Arrays.copyOfRange(data, start, end);
	PartitionPair holder = scanPart3(subArray, pivot);
	paste(data, holder.getArray(), start);
	holder.setMin(start);
	holder.setMax(end);
	return holder;
	
    }
    
    private static int scanWhole(int[] data, int number) {
	int index = 0;
	int i = 0;
	while (index < data.length - 1) {
	    if (number < data[index]) {
		index++;
		i++;
	    }else{
		index++;
	    }
	}
	// Scans an array for all ints less than given number
	// returns how many as an int
	return i;
    }
    private static PartitionPair scanPart3(int[] data, int pivot) {
	int[] newArray = new int[data.length];
	int low = 0;
	int high = data.length - 1;
	int mid = data[pivot];
	int index = 0;
	while (index < data.length - 1) {
	    if (data[index] < mid) {
		newArray[low] = data[index];
		low++;
	    }
	    if (data[index] > mid) {
		newArray[high] = data[index];
		high--;
	    }
	    index++;
	}
	//By here, the array should have partitioned all greater than and
	//less than elements, leaving a gap in the middle.
	
	/*System.out.println("low: " + low);
	System.out.println("high: " + high);
	*/
	
	for (int index2 = low; index2 <= high; index2++) {
	    newArray[index2] = mid;
	}
	PartitionPair info = new PartitionPair(newArray, low, high);
	return info;
	// scanPart3 takes an array, and parts it around the pivot index
	// Returns a PartitionPair class, whose methods are:
	// getArray() , getLow() , getHigh();
    }
    private static void swap(int[] data, int index1, int index2) {
	int hold;
	hold = data[index1];
	data[index1] = data[index2];
	data[index2] = hold;
	// Swaps elements in a given array
    }
    private static int randomWithRange(int min, int max){
	int range = (max - min) + 1;
	return (int)(Math.random() * range) + min;
	//Returns a random number inbetween min and max (inclusive)
	//Source: http://stackoverflow.com/questions/7961788/math-random-explained
    }
    public static int[] paste(int[] mainArray, int[] subArray, int n){
	int index = 0;
	int i = n;
	while (index < subArray.length) {
	    mainArray[i] = subArray[index];
	    i++;
	    index++;
	}
	return mainArray;
	//Pastes subArray on top of mainArray, beginning at index n
	//and returns the new pasted array
    }
    public static void main(String[] args) {
	/*
	int[] test = {6,3,99,40, 9, 2, 5, 8, 3, 19, 20, 39, 91, 9, 9, 9, 9};
	System.out.println(Arrays.toString(scanPart3(test, 4)));
	*/
	int[] arry1 = {5, 5, 5, 5, 5, 5, 5, 5};
	int[] arry2 = {10, 10, 10};
	int[] arry3 = {0, 3, 2, 5, 7, 8, 3, 4, 6, 2, 8, 9, 3, 4};
	int[] arry4 = {0, 1, 2, 3, 4, 5, 6};
	//System.out.println(Arrays.toString(paste(arry1, arry2, 1)));

	System.out.println(quickSelect(arry4, 2));
	
    }
    
}
	
