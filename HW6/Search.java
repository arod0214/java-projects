
public class Search implements SearchInterface {

	// Binary Search
	@Override
	public int search(Integer[] listOfNumbers, Integer target) {
		int first = 0;
		int last = listOfNumbers.length - 1;
		while(first <= last){
			int mid = (first + last)/2;
			if(listOfNumbers[mid] == target){
				return mid;
			}
			else if(listOfNumbers[mid] < target){
				first = mid+1;
			}
			else {
				last = mid - 1;
			}
		}
		return -1;
	}

}
