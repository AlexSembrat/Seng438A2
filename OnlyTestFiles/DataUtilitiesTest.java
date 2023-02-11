package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;

public class DataUtilitiesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}
	
	
	//
	//calculateRowTotal(Values2D data, int row) Tests
	//
	
	/**
	 * This test will create an empty 2d values table. Then asks calculateRowTotal() to sum the Row (Should be 0)
	 */
	@Test
	public void calculateRowTotalEmpty() {
		
		Mockery mockingContext = new Mockery();
		
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(0));
	
				one(values).getRowCount();
				will(returnValue(0));
			
			}
		});
	
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("Total is 0", 0, result, .000000001d);
	
	}

	/**
	 * This test will create an 2d values table with 5 positive values. Then asks calculateRowTotal() to sum the Row (Should be 15)
	 */
	@Test
	public void calculateRowTotalPos() {
		
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(5));
			
				one(values).getValue(1, 0);
				will(returnValue(1));
			
				one(values).getValue(1, 1);
				will(returnValue(2));

				one(values).getValue(1, 2);
				will(returnValue(3));

				one(values).getValue(1, 3);
				will(returnValue(4));
				
				one(values).getValue(1, 4);
				will(returnValue(5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 1);
		assertEquals("Row total is 15", 15, result, .000000001d);
	}

	/**
	 * This test will create an 2d values table with 5 negative values. Then asks calculateRowTotal() to sum the Row (Should be -15)
	 */
	@Test
	public void calculateRowTotalNeg() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(5));
			
				one(values).getValue(1, 0);
				will(returnValue(-1));
			
				one(values).getValue(1, 1);
				will(returnValue(-2));

				one(values).getValue(1, 2);
				will(returnValue(-3));

				one(values).getValue(1, 3);
				will(returnValue(-4));
				
				one(values).getValue(1, 4);
				will(returnValue(-5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 1);
		assertEquals("Row total is -15", -15, result, .000000001d);
	}
	
	/**
	 * This test will create an 2d values table with a mix of pos and neg values. Then asks calculateRowTotal() to sum the Row (Should be 3)
	 */
	@Test
	public void calculateRowTotalPosNeg() {
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(5));
			
				one(values).getValue(1, 0);
				will(returnValue(1));
			
				one(values).getValue(1, 1);
				will(returnValue(-200));

				one(values).getValue(1, 2);
				will(returnValue(3));

				one(values).getValue(1, 3);
				will(returnValue(-4.5));
				
				one(values).getValue(1, 4);
				will(returnValue(5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 1);
		assertEquals("Row total is -195.5", -195.5, result, .000000001d);
	}

	/**
	 * Test inputting a Null Object which should throw an expection
	 */
	@Test
	public void calculateRowTotalIllegalArg() {
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("This should throw an exception");
		} catch (Exception e) {
			assertEquals("The exception thrown is InvalidParameterException", InvalidParameterException.class,
					e.getClass());
		}
	}

	
	//
	//calculateColumnTotal(Values2D data, int column) Tests
	// 

	
	/**
	 * This test will create an empty 2d values table. Then asks calculateColumnTotal() to sum the Column (Should be 0)
	 */
	@Test
	public void calculateColumnTotalEmpty() {
		
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(0));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("Column total is 0", 0, result, .000000001d);
	}


	/**
	 * This test will create an 2d values table with 4 positive values. Then asks calculateColumnTotal() to sum the Column (Should be 100)
	 */
	@Test
	public void calculateColumnTotalPos() {
		
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(4));

				one(values).getValue(0, 1);
				will(returnValue(10));

				one(values).getValue(1, 1);
				will(returnValue(20));

				one(values).getValue(2, 1);
				will(returnValue(30));
				
				one(values).getValue(3, 1);
				will(returnValue(40));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals("Column total is 100", 100, result, .000000001d);
	}
	
	/**
	 * This test will create an 2d values table with 4 negative values. Then asks calculateColumnTotal() to sum the Column (Should be -9)
	 */
	@Test
	public void calculateColumnTotalNeg() {
		
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(4));

				one(values).getValue(0, 1);
				will(returnValue(-0.5));

				one(values).getValue(1, 1);
				will(returnValue(-1));

				one(values).getValue(2, 1);
				will(returnValue(-2.5));
				
				one(values).getValue(3, 1);
				will(returnValue(-5));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals("Column total is -9", -9, result, .000000001d);
	}
	
	/**
	 * This test will create an 2d values table with 4 negative values. Then asks calculateColumnTotal() to sum the Column (Should be -9)
	 */
	@Test
	public void calculateColumnTotalPosNeg() {
		
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);

		mockingContext.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(4));

				one(values).getValue(0, 1);
				will(returnValue(100));

				one(values).getValue(1, 1);
				will(returnValue(-150));

				one(values).getValue(2, 1);
				will(returnValue(2.5));
				
				one(values).getValue(3, 1);
				will(returnValue(0));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals("Column total is -43.5", -43.5, result, .000000001d);
	}
	
	/**
	 * Test inputting a Null Object which should throw an expection
	 */
	@Test
	public void calculateColumnTotalIllegalArg() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("This should throw an exception");
		} catch (Exception e) {
			assertEquals("The exception thrown is InvalidParameterException", InvalidParameterException.class,
					e.getClass());
		}
	}
	
	//
	// createNumberArray(double[] data) Tests
	//
	
	@Test
	public void testArray() {
	    double[] data = {1.0, -2.00, 3.00001};
	    Number[] actual = DataUtilities.createNumberArray(data);
	    Number[] expected = new Number[] {1.0, 2.00, 3.00001};
	    assertArrayEquals(expected, actual);
	    }
	
  
	@Test
	public void testNegativeArray() {
		double[] data = {-100.0};
	    Number[] actual = DataUtilities.createNumberArray(data);
	    Number[] expected = new Number[] {-100.0};
	    assertArrayEquals(expected, actual);
	    }
	
	@Test
	public void testZeroArray() {
	    double[] data = {0};
	    Number[] actual = DataUtilities.createNumberArray(data);
	    Number[] expected = new Number[] {0};
	    assertArrayEquals(expected, actual);
	    }
	
	@Test
	public void testSingleIntArray() {
	    double[] data = {1};
	    Number[] actual = DataUtilities.createNumberArray(data);
	    Number[] expected = new Number[] {1.1};
	    assertArrayEquals(expected, actual);
	    }
	
	@Test
	public void testEmptyArray() {
		double[] data = {};
	    Number[] actual = DataUtilities.createNumberArray(data);
	    Number[] expected = new Number[] {};
	    assertArrayEquals(expected, actual);
	    }
	
	@Test
	public void testArrayLength() {
		double[] data = {1.0, 2.0, 3.0, 4.0};
	    Number[] actual = DataUtilities.createNumberArray(data);
	    Number[] expected = new Number[] {1.0, 2.0, 3.0, 4.0};
	    assertEquals(expected.length, actual.length);
	    }
	
	//
	//createNumberArray2D(double[][] data) tests
	//
	
	@Test
	 public void test2DArrayConversion() {
	    double[][] data = {{1.0, 2.0},{3.0, 4.000, 5.000001},{6.9, 9.0, 122.209}, {-0.3, 0}};
	    Number[][] actual = DataUtilities.createNumberArray2D(data);
	    Number[][] expected = new Number[][] {{1.0, 2.0},{3.0, 4.000, 5.000001},{6.9, 9.0, 122.209}, {-0.3, 0}};
	    
	    assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test2DArrayLargeNumberConversion() {
	   double[][] data = {{123456789123456789.0}};
	   Number[][] actual = DataUtilities.createNumberArray2D(data);
	   Number[][] expected = new Number[][] {{123456789123456789.0}};
	   
	   assertArrayEquals(expected, actual);
   }
 
   
	@Test
	 public void testNegative2DArrayConversion() {
	    double[][] data = {{-1.0}};
	    Number[][] actual = DataUtilities.createNumberArray2D(data);
	    Number[][] expected = new Number[][] {{-1.0}};
	    
	    assertArrayEquals(expected, actual);
	}
	
	@Test
	 public void testZero2DArrayConversion() {
	    double[][] data = {{0}};
	    Number[][] actual = DataUtilities.createNumberArray2D(data);
	    Number[][] expected = new Number[][] {{0}};
	    
	    assertArrayEquals(expected, actual);
	}
	
	@Test
	 public void testOneValue2DArrayConversion() {
	    double[][] data = {{2.2}};
	    Number[][] actual = DataUtilities.createNumberArray2D(data);
	    Number[][] expected = new Number[][] {{2.2}};
	    
	    assertArrayEquals(expected, actual);
	}
	
	@Test
	 public void testEmpty2DArray()
	{
		double[][] data = {};
	    Number[][] actual = DataUtilities.createNumberArray2D(data);
	    Number[][] expected = new Number[][] {};
	    assertArrayEquals(expected, actual);
		
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	 public void test2DArrayMethodThrowsParameterException() throws InvalidParameterException{
		thrown.expect(InvalidParameterException.class);
		DataUtilities.createNumberArray2D(null);
	}
	
	//
	//getCumulativePercentages(KeyedValues data) tests
	//
	
	@Test
	 public void testTwoCumulativePercentages()
	{
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue("0", 3);
		data.addValue("0", 4);
		
	    DefaultKeyedValues expected = new DefaultKeyedValues();
	    expected.addValue("0", 3/7.0);
	    expected.addValue("1", 7/7.0);
	
	    
	    KeyedValues actual = DataUtilities.getCumulativePercentages(data);
	    
	   assertEquals(expected.getValue("0"), actual.getValue("0"));
	   assertEquals(expected.getValue("1"), actual.getValue("1")); 
	}
	
	@Test
	 public void testEmptyValueCumulativePercentages() 
	{
		DefaultKeyedValues data = new DefaultKeyedValues();
		DataUtilities.getCumulativePercentages(data);
	}
	
	
	@Test
	 public void testAllZeroValues() {
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue("0", 0);
		data.addValue("1", 0);
		data.addValue("2", 0);
		
	    DefaultKeyedValues expected = new DefaultKeyedValues();
	    expected.addValue("0", 0);
	    expected.addValue("1", 0);
	    expected.addValue("2", 0);
	
	    
	    KeyedValues actual = DataUtilities.getCumulativePercentages(data);
	    
	   assertEquals(expected.getValue("0"), actual.getValue("0"));
	   assertEquals(expected.getValue("1"), actual.getValue("1")); 
	   assertEquals(expected.getValue("2"), actual.getValue("2")); 
	}
	
	@Rule
	public ExpectedException thrown2 = ExpectedException.none();
	
	@Test
	 public void testCumulativePercentThrowsParameterException() throws InvalidParameterException{
		thrown2.expect(InvalidParameterException.class);
		DataUtilities.getCumulativePercentages(null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
