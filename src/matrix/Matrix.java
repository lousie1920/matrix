package matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents a matrix (from algebra).
 * 
 * @immutable
 */

public class Matrix {
	
	/**
	 * @invar | 1 <= nbRows
	 * @invar | 1 <= nbColumns
	 * @invar | elements != null
	 * @invar | elements.length == nbRows * nbColumns
	 */
	
	private int nbRows;
	private int nbColumns;
	/** 
	 * @representationObject
	 */
	private double[] elements;
	
	//  inspectors
	
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
	
	public double[][] getElementsAsRowArrays() { 
		double[][] result = new double[nbRows][nbColumns];
		for (int rowIndex = 0; rowIndex < nbRows; rowIndex++)
			for(int columnIndex = 0; columnIndex < nbColumns; columnIndex++)
				result[rowIndex][columnIndex]= elements[rowIndex*nbColumns + columnIndex];
		return result;

	}
	
	/**
	 * 
	 * @post | result == getElementsAsRowArrays().length
	 */
	
	public int getNbRows() { 
		return nbRows;
	}
	
	/**
	 * @post | result == getElementsAsRowArrays()[0].length
	 */
	
	public int getNbColumns() { 
		return nbColumns;
	}
	
	/**
	 * @post | result != null
	 * @post | result.length == getNbRows() * getNbColumns()
	 * @post | IntStream.range(0, getNbRows()).allMatch(rowIndex -> IntStream.range(0, getNbColumns()).allMatch(columnIndex -> 
	 *			| result[rowIndex * getNbColumns() + columnIndex] == getElementsAsRowArrays()[rowIndex][columnIndex]))	
	 *
	 * @creates | result 
	 */
	
	
	// geen representation object teruggeven aan klant! clonen

	public double[] getElementsRowMajor() { 
		return elements.clone();
	}
	
	/**
	 * @post | result != null
	 * @post | result.length == getNbRows() * getNbColumns()
	 * @post | IntStream.range(0, getNbRows()).allMatch(rowIndex -> IntStream.range(0, getNbColumns()).allMatch(columnIndex -> 
	 *			| result[columnIndex * getNbRows() + rowIndex] == getElementsAsRowArrays()[rowIndex][columnIndex]))	
	 *
	 * @creates | result 
	 */
	
	public double[] getElementsColumnMajor() { 
		double[] result = new double[nbRows*nbColumns];
		for (int rowIndex = 0; rowIndex < nbRows; rowIndex++)
			for(int columnIndex = 0; columnIndex < nbColumns; columnIndex++)
				result[rowIndex*columnIndex *nbRows + rowIndex]= elements[rowIndex*nbColumns + columnIndex];
		return result;
	}
	
	
	
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
	 */
	
	// geen objecten aanvaarden van de klant -> clonen
	
	public Matrix(int nbRows, int nbColumns, double[] elementsRowMajor) { 
		
		if(nbRows <1)
			throw new IllegalArgumentException("nbRows less than 1");
		if(nbColumns <1)
			throw new IllegalArgumentException("nbColumns less than 1");
		if(elementsRowMajor == null)
			throw new IllegalArgumentException("elementsRowMajor is null");
		if(elementsRowMajor.length != nbRows *nbColumns)
			throw new IllegalArgumentException("elementsRowMajor has wrong length");
		
		this.nbRows = nbRows;
		this.nbColumns = nbColumns;
		this.elements = elementsRowMajor.clone();
	}
		
	
	/**
	 * 
	 * @post | result != null
	 * @post | result.getNbRows() == getNbRows()
	 * @post | result.getNbColumns() == getNbColumns()
	 * @post | IntStream.range(0,getNbRows() *getNbColumns() ).allMatch(i -> 
	 * 			|  result.getElementsRowMajor()[i] == getElementsRowMajor()[i] * scaleFactor)
	 * 
	 */
	
	public Matrix scaled(double scaleFactor) { 
		
		double[] resultElements = new double[elements.length];
		for( int i = 0; i < resultElements.length; i++)
			resultElements[i] = elements[i] * scaleFactor;
		return new Matrix(nbRows, nbColumns, resultElements);
	}
	
	/**
	 * @pre | other != null
	 * @pre | other.getNbRows() == getNbRows()
	 * @pre | other.getNbColumns() == getNbColumns()
	 * 
	 * @post | result != null
	 * @post | result.getNbRows() == getNbRows()
	 * @post | result.getNbColumns() == getNbColumns()
	 * @post | IntStream.range(0,getNbRows() *getNbColumns() ).allMatch(i -> 
	 * 			|  result.getElementsRowMajor()[i] == getElementsRowMajor()[i] + other.getElementsRowMajor()[i])
	 * 
	 */
	
	public Matrix plus(Matrix other) {
		
		double[] resultElements = new double[elements.length];
		for( int i = 0; i < resultElements.length; i++)
			resultElements[i] = elements[i] * other.elements[i];
		return new Matrix(nbRows, nbColumns, resultElements);
	}
	

}
