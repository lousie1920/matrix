package matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a matrix (from algebra).
 */

public class Matrix {
	
	// eerst inspectors
	
	/**
	 * 
	 * @basic
	 * 
	 * @post | result != null
	 * @post | 1 <= result.length
	 * @post | Arrays.stream(result).allMatch(row -> row != null && row.length == result[0].length && 1 <= row.length)
	 *  // voor alle elementen (row) van result geldt dat
	 * 
	 * @creates | result, ...result
	 */
	
	public double[][] getElementsAsRowArrays() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * 
	 * @post | result == getElementsAsRowArrays().length
	 */
	
	public int getNbRows() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @post | result == getElementsAsRowArrays()[0].length
	 */
	
	public int getNbColumns() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @post | result != null
	 * @post | result.length == getNbRows() * getNbColumns()
	 * @post | IntStream.range(0, getNbRows()).allMatch(rowIndex -> IntStream.range(0, getNbColumns()).allMatch(columnIndex -> 
	 *			| result[rowIndex * getNbColumns() + columnIndex] == getElementsAsRowArrays()[rowIndex][columnIndex]))	
	 *
	 * @creates | result 
	 */
	

	public double[] getElementsRowMajor() { throw new RuntimeException("Not yet implemented"); }
	
	/**
	 * @post | result != null
	 * @post | result.length == getNbRows() * getNbColumns()
	 * @post | IntStream.range(0, getNbRows()).allMatch(rowIndex -> IntStream.range(0, getNbColumns()).allMatch(columnIndex -> 
	 *			| result[columnIndex * getNbRows() + rowIndex] == getElementsAsRowArrays()[rowIndex][columnIndex]))	
	 *
	 * @creates | result 
	 */
	
	public double[] getElementsColumnMajor() { throw new RuntimeException("Not yet implemented"); }
	
	
	
	//constructor (hierbij hoeven we niet te zeggen dat this gemuteerd wordt
	/**
	 * 
	 * @throws IllegalArgumentException | nbRows < 1
	 * @throws IllegalArgumentException | nbColumns < 1
	 * @throws IllegalArgumentException | elementsRowMajor == null
	 * @throws IllegalArgumentException | elementsRowMajor.length != nbRows * nbColumns
	 * 
	 * @inspects | elementsRowMajor
	 * 
	 * @post | getNbRows() == nbRows
	 * @post | getNbColumns() == nbColumns
	 * @post | Arrays.equals(getElementsRowMajor(), elementsRowMajor)
	 * 
	 * 
	 */
	
	public matrix(int nbRows, int nbColumns, double[] elementsRowMajor) { throw new RuntimeException("Not yet implemented"); }
		

	
	
	public Matrix scaled(double scaleFactor) { throw new RuntimeException("Not yet implemented"); }
	

}
