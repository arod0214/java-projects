
public interface MyArrayInterface<T> {

	/**
	 * 
	 * Method to check if the array is empty.
	 * 
	 * @return	<code>true</code> if the array is empty, <code>false</code> otherwise
	 *  
	 */
	public boolean isEmpty();

	/**
	 * 
	 * Method to check if the array is full.
	 * 
	 * @return	<code>true</code> if the array is full, <code>false</code> otherwise
	 *  
	 */
	public boolean isFull();
	
	/**
	 * 
	 * Method the find the number of elements in the array.
	 * 
	 * @return	The number of elements currently stored in the array.
	 * 
	 */
	public int size();
	
	/**
	 * 
	 * Method to add the specified element to the array.
	 * 
	 * @param element	The element to be added to the array.
	 * 
	 * @throws ArrayIsFullException	This exception is thrown if the array
	 * is full and there is no room for the new element in the array.
	 * 
	 */
	public void addElement(T element) throws ArrayIsFullException;
	
	/**
	 * 
	 * Method to retrieve the element at the specified index from the array.
	 * 
	 * @param index	The index of the desired element from the array.
	 * 
	 * @return	The element located at the specified index.
	 * 
	 * @throws IndexOutOfBoundsException	This exception is thrown if the array
	 * does not contain an element at the specified index.
	 * 
	 */
	public T getElement(int index) throws IndexOutOfBoundsException;
	
	/**
	 * 
	 * Method to replace the existing element at the specified index with the
	 * specified element.
	 * 	
	 * @param element	The element that will replace the current element.
	 * 
	 * @param index		The index where the specified element will replace the
	 * existing element.
	 *  
	 * @throws IndexOutOfBoundsException	This exception is thrown if the specified
	 * index is not valid or there is no existing element at that index.
	 * 
	 */
	public void replaceElement(T element, int index) throws IndexOutOfBoundsException;
	
	/**
	 * 
	 * Method to insert the specified element before the existing element at the
	 * specified index. Please note that this operation could require shifting 
	 * some of the elements in the array to make room for the insertion of the 
	 * specified element.
	 * 
	 * @param element	The element that will be be inserted at the specified index.
	 * 
	 * @param index		The index within the array where the insertion will take place.
	 * 
	 * @throws IndexOutOfBoundsException	This exception is thrown if the specified index
	 * is not valid.
	 * 
	 * @throws ArrayIsFullException	This exception is thrown if the array
	 * is full and there is no room for the new element to be inserted in the array.
	 */
	public void insertElement(T element, int index) throws IndexOutOfBoundsException, ArrayIsFullException;
	
	/**
	 * 	
	 * Method to remove the element currently in the array at the specified index.
	 * 
	 * @param index	The index within the array of the element to be removed.
	 * 
	 * @return	The removed element that was located at the specified index.
	 * 
	 * @throws IndexOutOfBoundsException		This exception is thrown if the specified index
	 * is not valid.
	 * 
	 */
	public T removeElement(int index) throws IndexOutOfBoundsException;
	
	/**
	 * 
	 * Reset the array to being empty.
	 * 
	 */
	public void resetArray();
	
}
