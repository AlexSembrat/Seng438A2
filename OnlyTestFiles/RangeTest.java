package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

import org.junit.Test;

public class RangeTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
    private Range twoPosExampleRange;
    private Range twoNegExampleRange;
    private Range exampleRange;
    private Range zeroRange;
    private Range nonIntCenter;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	twoPosExampleRange = new Range(3, 5);
    	twoNegExampleRange = new Range(-5, -3);
    	exampleRange = new Range(-1, 1);
    	zeroRange = new Range(1, 1);
    	nonIntCenter = new Range(1,2);
    }

    //
    //Testing getUpperBound() function
    //
    
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void twoPosUpperBound() {
    	assertEquals("The upper bound of (3, 5) should be 5", 5, twoPosExampleRange.getUpperBound(), 
    			.00000001d);
    }
    @Test
    public void twoNegUpperBound() {
    	assertEquals("The upper bound of (-5, -3) should be -3", -3, twoNegExampleRange.getUpperBound(), 
    			.00000001d);
    }
    @Test
    public void testUpperBound() {
    	assertEquals("The upper bound of (-1, 1) should be 1", 1, exampleRange.getUpperBound(), 
    			.00000001d);
    }
    @Test
    public void zeroUpperBound() {
    	assertEquals("The upper bound of (1, 1) should be 1", 1, zeroRange.getUpperBound(), 
    			.00000001d);
    }
    
    //
    //Testing getLowerBound() function
    //
    
    @Test
    public void twoPosLowerBound() {
    	assertEquals("The lower bound of (3, 5) should be 3", 3, twoPosExampleRange.getLowerBound(),
    			.00000001d);
    }
    @Test
    public void twoNegLowerBound() {
    	assertEquals("The lower bound of (-5, -3) should be -5", -5, twoNegExampleRange.getLowerBound(),
    			.00000001d);
    }
    @Test
    public void testLowerBound() {
    	assertEquals("The lower bound of (-1, 1) should be -1", -1, exampleRange.getLowerBound(),
    			.00000001d);
    }
    @Test
    public void zeroLowerBound() {
    	assertEquals("The lower bound of (1, 1) should be 1", 1, zeroRange.getLowerBound(),
    			.00000001d);
    }

    //
    //Testing getLength() function
    //
    
    @Test
    public void testValidLength() {
    	assertEquals("The length of the example range should be 2", 2, exampleRange.getLength(),
    			.00000001d);
    }
    @Test
    public void testZeroLength() {
    	assertEquals("The length of the (1, 1) should be 0", 0, zeroRange.getLength(),
    			.00000001d);
    }
    
    //
    //Testing getCentralValue() function
    //
    
    @Test
    public void testIntegerCentral() {
    	assertEquals("The central value of -1 and 1 should be 0",
    	        0, exampleRange.getCentralValue(), .000000001d);
    }
    @Test
    public void testNonIntegerCentral() {
    	assertEquals("The central value of 1 and 2 should be 1.5",
    	        1.5, nonIntCenter.getCentralValue(), .000000001d);
    }
    @Test
    public void testZeroCentral() {
    	assertEquals("The central value of 1 and 1 should be 1",
    	        1, zeroRange.getCentralValue(), .000000001d);
    }
    
    //
    //testing contains() function
    //
    
    @Test
    public void testContainsValid() {
    	assertEquals("This function should return true because 4 is in range (3, 5)", true, 
    			twoPosExampleRange.contains(4));
    }
    @Test
    public void testContainsInvalid() {
    	assertEquals("This function should return false because 1 is not in range(3, 5)", false,
    			twoPosExampleRange.contains(1));
    }
    @Test
    public void testContainsBoundry() {
    	assertEquals("This function should return true because 3 is contained in (3,5)",
    			true, twoPosExampleRange.contains(3));
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
