package matrix.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import matrix.Matrix;

class MatrixTest {

	@Test
	void test() {
		Matrix myMatrix = new Matrix(3,2, new double[] {1,0,0,1,0,0} );
		assertEquals(3, myMatrix.getNbRows());
		assertEquals(2,myMatrix.getNbColumns());
		assertArrayEquals(new double[] {1,0,0,1,0,0}, myMatrix.getElementsRowMajor());
		assertArrayEquals(new double[] {1,0,0,0,1,0}, myMatrix.getElementsColumnMajor());
		
		double [][] myRows = {
				{1,0},
				{0,1},
				{0,0}
		};
		
		// dit doet een shallow vergelijking : niet ok
		// assertArrayEquals(myRows, myMatrix.getElementsAsRowArrays());
		
		//Volgende methode vergelijkt inhoud van elementen en niet identiteit
		assertTrue(Arrays.deepEquals(myRows, myMatrix.getElementsAsRowArrays()));
		
		assertArrayEquals( new double[] {0.5, 0, 0, 0.5, 0, 0}, myMatrix.scaled(0.5).getElementsRowMajor());
		assertArrayEquals( new double[] {1,0,2,1,0,2}, myMatrix.plus( new Matrix(3,2, new double[] {0,0,0,0,2,2})).getElementsRowMajor());
				
				
	}

}
