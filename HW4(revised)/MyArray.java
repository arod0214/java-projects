
public class MyArray<T> implements MyArrayInterface<T> {

	private Object[] array;
	private int count;
	
	
	public MyArray(int length) {
		this.array = new Object[length];
		this.count = 0;
	}
	
	
	@Override
	public boolean isEmpty() {
		if (this.count == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if (this.count == array.length) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return this.count;
	
	}

	@Override
	public void addElement(T element) throws ArrayIsFullException {

		/*
		try {
			this.array[this.count] = element;
		} catch (Exception e) {
			throw new ArrayIsFullException("The array is already full, unable to add the new element");
		}
		this.count++;
		*/
		
		if (this.isFull()) {
			throw new ArrayIsFullException("The array is already full, unable to add the new element");
		} else {
			this.array[this.count] = element;
			this.count++;
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public T getElement(int index) throws IndexOutOfBoundsException {
		
		if ((index < 0) || (index >= this.count)) {
			throw new IndexOutOfBoundsException("Invalid index = " + index);
		}
		
		return (T) this.array[index];
	}

	@Override
	public void replaceElement(T element, int index) throws IndexOutOfBoundsException {
		if ((index < 0) || (index >= this.count)) {
			throw new IndexOutOfBoundsException("Invalid index = " + index);
		} 
		else {
			this.array[index] = element;
		}
		
	}

	@Override
	public void insertElement(T element, int index) throws IndexOutOfBoundsException, ArrayIsFullException {
		if (this.isFull()) {
			throw new ArrayIsFullException("The array is already full, unable to add the new element");
		}if ((index < 0) || (index >= this.count)) {
			throw new IndexOutOfBoundsException("Invalid index = " + index);
		} 
		else {
			this.array[index] = element;
			this.count++;
		}
		
	}

	@Override
	public T removeElement(int index) throws IndexOutOfBoundsException {
		if ((index < 0) || (index >= this.count)) {
			throw new IndexOutOfBoundsException("Invalid index = " + index);
		} 
		else {
			this.array[index] = null;
			this.count--;
		}
		return null;
	}

	@Override
	public void resetArray() {
		this.count = 0;
		for ( int i = 0 ; i < this.array.length ; i++ ) {
			this.array[i] = null;
		}
	}

	@Override
	public boolean equals(Object obj) {
		boolean answer = false;

		if (obj instanceof MyArray) {
			@SuppressWarnings("unchecked")
			MyArray<T> t = (MyArray<T>) obj;
			
			if ((t.count == this.count)) {
				for (int i=0; i<this.array.length; i++){
					if(t.getElement(i) == this.getElement(i)){
						answer = true;
					}else{
						answer = false;
					}
				}
						
				
			} else {
				answer = false;
			}
		}
		
		return answer;
	
	}


	@Override
	public String toString() {
		String s = new String();
		for ( int i = 0 ; i < this.size() ; i++ ) {
			s = s + "MyArray Size = "+ this.size()+ "element at index "+ i + "\n";
		}
		return s;
	
	}

}
