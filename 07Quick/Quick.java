public class Quick{

    public static int part (int[] data, int start, int end){
	
    }
    private static int scan(int[] data, int number) {
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
    
	
	
}
