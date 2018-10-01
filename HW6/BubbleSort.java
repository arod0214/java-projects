
public class BubbleSort implements SortInterface {

	@Override
	public void sort(Integer[] arrayToSort) {
	    int len = arrayToSort.length - 1;
		while (len > 0){
			int lastSwap = 0;
			for (int i = 0; i < len; i++){
				if(arrayToSort[i] > arrayToSort[i+1]){
					swap(arrayToSort, i, i+1);
					lastSwap = i;
				}
			}
			len = lastSwap;
		}

	}

	private void swap(Integer[] a, Integer integer, Integer integer2) {
		int temp = a[integer];
		a[integer] = a[integer2];
		a[integer2] = temp;
		
	}
}


