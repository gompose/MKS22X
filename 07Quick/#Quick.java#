import java.util.*;

public class Quick{

    public static int part (int[] data, int start, int end){
	int[] parted = scanPart3(Arrays.copyToRange(data, start, end), randomWithRange(start, end));
	paste(data, parted, start);
	return 1;
	
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
    private static int[] scanPart3(int[] data, int pivot) {
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
	return newArray;
	// scanPart3 takes an array, and parts it around the pivot index
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
	int index = n;
	while (index < subArray.length){
	    mainArray[index] = subArray[index];
	    index++;
	}
	return mainArray;
	//Pastes subArray on top of mainArray, beginning at index n
    }
    public static void main(String[] args) {
	int[] test = {6,3,99,40, 9, 2, 5, 8, 3, 19, 20, 39, 91, 9, 9, 9, 9};
	System.out.println(Arrays.toString(scanPart3(test, 4)));
    }
    
}
	
    
