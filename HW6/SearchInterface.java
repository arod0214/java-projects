/**
 * 
 * This is a generalized search interface. You will write a Search class that implements
 * one of these search algorithms:
 * 
 * <ol>
 * <li>LinearSearch</li>
 * <li>BinarySearch</li>
 * </ol>
 * 
 * @author Sameh A. Fakhouri
 *
 */
public interface SearchInterface {
		
	/**
	 * 
	 * This method is used for searching for a <b>target</b> value in an array 
	 * representing a <b>listOfNumbers</b>.
	 * 
	 * @param listOfNumbers	An array of <b>Integer</b> values.
	 * 
	 * @param target An <b>Integer</b> representing the target we are searching for.
	 * 
	 * @return If the <b>target</b> value is found, the method will return the index of the 
	 * <b>target</b> value in the <b>listOfNumbers</b>. Otherwise, the method will return
	 * <b>-1</b>.
	 * 
	 */
	public int search(Integer[] listOfNumbers, Integer target);
 
}
