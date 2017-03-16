import java.util.*;

public class Quick{

    public static int part (int[] data, int start, int end){
	scanWhole(data, 3);
	
    }
	    private static int scanWhole(int[] data, int number) {
	int index = 0;
	int i = 0;
	while (index < data.length) {
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
    private static 
    private static int[] swap(int[] data, int index1, int index2) {
	int hold;
	hold = int[index1];
	data[index1] = data[index2];
	data[index2] = hold;
    }
    
	
    
	
	
}
