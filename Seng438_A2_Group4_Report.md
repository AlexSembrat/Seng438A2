**SENG 438 - Software Testing, Reliability, and Quality**


**Lab. Report \#2 – Requirements-Based Test Generation**


| Group \#:         |  4  |
| ----------------- | --- |
| Student Names:    |     |
| Alexander Sembrat |     |
| Andrew Howe       |     |
| Hajin Kim         |     |
| Jenna Vlaar       |     |

1. [Introduction](#1-introduction) 
2. [Detailed Description of unit test strategy](#2-detailed-description-of-unit-test-strategy)
3. [Test cases developed](#3-test-cases-developed)
4. [The Benefits/Drawbacks of Mocking](#4-Benefits/Drawbacks-of-Mocking)
5. [How the team work was divided and managed](#4-how-the-team-work-was-divided-and-managed)
6. [Difficulties encountered, challenges overcome, and lessons learned](#5-difficulties-encountered-challenges-overcome-and-lessons-learned)
7. [Comments/feedback on the lab itself](#6-commentsfeedback-on-the-lab-itself)


# 1 Introduction


In this lab we were assigned the task of unit testing a java program. Specifically we had to use JUnit unit testing to test 10 methods that are contained in 2 different classes (Range.class and DataUtilities.class). Requirement and boundary testing were the main approaches when creating these test cases. This lab helped to familiarize us with using Eclipse, adding jars to build paths, and using Junit and Mockery.


# 2 Detailed description of unit test strategy


Before we can develop test cases we had to review the provided documentation on how the methods are supposed to function, then we chose 5 methods from the Range class to test, and also tested all 5 methods in the DataUtilities test. We partitioned tests based on boundary cases as well as general use and expectations from the methods. We had a black-box testing approach meaning that we did not know the inner workings of each method, simply the expected functionality of each software under test. The partitions for each method are defined below:


Partitions Designed:
1. calculateColumnTotal(Values2D data, int column)

	A: Null Data
	
	B: Positive Data
	
	C: Negative Data
	
	D: Large/Small Numbers
	
	E: Decimals	
	
	F: Column Length
	
	G: Empty Data
2. calculateRowTotal(Values2D data, int column)

	A: Null Data
	
	B: Positive Data
	
	C: Negative Data
	
	D: Large Numbers
	
	E: Decimals	
	
	F: Row Length
	
	G: Empty Data
3. createNumberArray2D(double[][] data)

	A: Variety of Positives/Negatives
	
	B: Large Number
	
	C: Negative Number
	
	D: All Zeroes
	
	E: One Value
	
	F: Empty Array
	
	G: Null Data
4. getCumulativePercentages(KeyedValues data)

	A: Two Values
	
	B: Empty Data
	
	C: All Zero Data
	
	D: Null Data
5. createNumberArray(double[] data)

	A: Multiple values of both positive and negative
	
	B: Single Negative
	
	C: Zero
	
	D: Single Integer
	
	E: Empty Array
	
	F: Array Length
6. getCentralValue()

	A: Correct Functionality
	
	B: Positive Value
	
	C: Negative Value
	
	D: Decimal Value
	
7. getUpperBound()

	A: Positive
	
	B: Negative
8. getLowerBound()

	A: Positive
	
	B: Negative
	
	C: Zero input
9. getLength()

	A: Valid input
	
	B: Zero length
10. contains()

	A: Invalid Input
	
	B: Valid Input

# 3 Test cases developed


The following test cases were developed for the Range Class:
| Method | Partition | Test Case | Pass/Fail | 
| --------- | ------- | ---------------- | ------------ | 
| getUpperBound() | 7A, 7B | centralValueShouldBeZero() | P |
| getUpperBound() | 7A | twoPosUpperBound() | F |
| getUpperBound() | 7B | twoNegUpperBound() | F |
| getUpperBound() | 7A, 7B | testUpperBound() | F |
| getUpperBound() | 7A | zeroUpperBound() | P |
| getLowerBound() | 8A | twoPosLowerBound() | P |
| getLowerBound() | 8B | twoNegLowerBound() | P |
| getLowerBound() | 8A, 8B | testLowerBound() | P |
| getLowerBound() | 8A | zeroLowerBound() | P |
| getLength() | 9A | testValidLength() | P |
| getLength() | 9A, 9B | testZeroLength() | P |
| getCentralValue() | 6A, 6B, 6C | testIntegerCentral() | P |
| getCentralValue() | 6D, 6B, 6A | testNonIntegerCentral() | P |
| getCentralValue() | 6A, 6B | testZeroCentral() | P |
| contains() | 10A | testContainsValid() | P |
| contains() | 10B | testContainsInvalid() | P |
| contains() | 10A | testContainsBoundry() | P |


The following test cases were developed for the DataUtilities class:
| Method | Partition | Test Name | Pass/Fail | 
| --------- | ------- | ---------------- | ------------ | 
| calculateColumnTotal() | 1F,1G | calculateColumnTotalEmpty() | P |
| calculateColumnTotal() | 1D,1B,1F | calculateColumnTotalPos() | P |
| calculateColumnTotal() | 1D,1C,1F | calculateColumnTotalNeg() | P |
| calculateColumnTotal() | 1B,1C,1D,1E,1F | calculateColumnTotalPosNeg() | F |
| calculateColumnTotal() | 1A | calculateColumnTotalIllegalArg() | F |
| calculateRowTotal() | 2F,2G | calculateRowTotalEmpty() | P |
| calculateRowTotal() | 2D,2B,2F | calculateRowTotalPos() | F |
| calculateRowTotal() | 2D,2C,2F,2E | calculateRowTotalNeg() | F |
| calculateRowTotal() | 2B,2C,2D,2E,2F | calculateRowTotalPosNeg() | F |
| calculateRowTotal() | 2A | calculateRowTotalIllegalArg() | F |
| createNumberArray2D() | 3A,3C | test2DArrayConversion() | F |
| createNumberArray2D() | 3B | test2DLargeNumberConversion() | F |
| createNumberArray2D() | 3C | testNegative2DArrayConversion() | F |
| createNumberArray2D() | 3D | testZero2DArrayConversion() | F |
| createNumberArray2D() | 3E | testOneValue2DArrayConversion() | F |
| createNumberArray2D() | 3F | testEmpty2DArray() | P |
| createNumberArray2D() | 3G | test2DArrayMethodThrowsParameterException() | F |
| getCumulativePercentages() | 4A | testTwoCumulativePercentages() | F |
| getCumulativePercentages() | 4B | testEmptyValueCumulativePercentages() | P |
| getCumulativePercentages() | 4C | testAllZeroValues() | F |
| getCumulativePercentages() | 4D | testCumulativePercentagesThrowsParameterException() | F |
| createNumberArray() | 5A | testArray() | F |
| createNumberArray() | 5B | testNegativeArray() | F |
| createNumberArray() | 5C | testZeroArray() | F |
| createNumberArray() | 5D | testSingleIntArray() | F |
| createNumberArray() | 5E | testEmptyArray() | P |
| createNumberArray() | 5F | testArrayLength() | P |


# 4 Benefits/Drawbacks of Mocking


Mocking provides a way to mimic behavior of a certain class without using that specific class. This is very beneficial if you are attempting to test a method which calls other methods or class objects which may produce unexpected behavior. In this regard, you can ensure that you are testing a specific functionality, and not picking up bugs from a different part of the program. There are some drawbacks of utilizing mocking in testing. Mocking simply mimics the behavior of a class and is therefore limited in its functionality and produced results. Thus, creating a mock of a class with all of the required functionality to complete a test may involve the same level of involvement as writing the class itself. So, mocking requires a lot of effort while potentially losing a lot of functionality. 


# 5 How the team work/effort was divided and managed


We divided the methods to test up equally between group members. Some tests were harder to write than others so some members were assigned more tests to write than others. After we each wrote our tests we came together to review each other's tests to find any errors or any missed tests.


In the event any team member was having any issues they reached out to other members to ask for assistance.


# 6 Difficulties encountered, challenges overcome, and lessons learned


One of the issues we ran into was not initially including all of the required JAR files to do the Mocking for the DataUtilities class. Mockery could not be found so we had to go back and add the other JAR files to the build path. Using the mocking objects was also a new experience so they had a small learning curve to overcome, but the documentation provided in the lab document was sufficient enough to figure it out after playing around for a little. Another issue was using the 0 index with a mocking object, sometimes it would cause errors with the tests we are unsure why but using 1 or greater solved the issue.


While we had used JUnit briefly in previous classes this was a good lab that allowed us to learn more about it and gain a valuable skill that we will be able to utilize for future projects in any class. Mockery was another great thing to learn as being able to mimic objects for testing is very useful,and something new to all of us.


# 7 Comments/feedback on the lab itself


Overall, this lab was quite good and well organized. It would have been helpful to mention all the Jar Files needed to be added to the build path, not just the JFreeChart one as shown in the document, also some more in depth content on mocking would be useful and we had never seen it before.
