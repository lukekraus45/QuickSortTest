import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/*
 * 
 * 
 * 
 * 
 * 
 * Luke Kraus
 * CS 0445
 * 3-5-15
 * John Rameriez
 * Tues. Thurs 9:30-10:45
 * Recitation - Thurs. 11:00-11:50
 * 
 *  
 *  The purpose of this program is to test  the different cases of quick sort and then find the run time of them. The program takes various medians and 
 *  sorted/unsorted data and times the runtime. The user can enter the size of the array and then random data is generated. The data is then sorted and the
 *  runtime is printed out.  
 * 
 * 
 * */
public class Assig4a {
	
	static int arraySize = 0;
	static int arraySizeMinusOne = 0;

	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException{
	
	//initializes the scanner and variables	
	Scanner inscan = new Scanner(System.in);	
	long start,finish,delta;
	double average1, average2;
	
	//reads in the value for the size of the arrays that the user wants tested
	System.out.println("Please Enter the Size of the Arrays to Be Tested");
	boolean correctFormat = true;
	while(correctFormat){
	try{
	arraySize = Integer.parseInt(inscan.nextLine());
	correctFormat = false;
	}catch(NumberFormatException e1){
	System.out.println("Please enter a valid int!");	
	correctFormat = true;
	}
	}
	//creates the array
	Integer testArray[] = new Integer[arraySize];
	arraySizeMinusOne = arraySize -1;
	
	//reads in the value for the number of trials that user wants to run
	int numberOfTrials = 0;
	System.out.println("Please enter the number of trials that you would like to test:");
	correctFormat = true;
	while(correctFormat){
		try{
			numberOfTrials = Integer.parseInt(inscan.nextLine());
			correctFormat = false;
		}catch(NumberFormatException e2){
			System.out.println("Please enter a valid int");
		}
	}
	
	//Reads in the name of the file that the data will be written to and creates it
	System.out.println("Please enter the name of the file that you would like to print the results to: (Please enter .txt after)");
	String fname = inscan.nextLine();
	PrintWriter writer = new PrintWriter(fname, "UTF-8");

	//random order
	randomizeArray(testArray);
	Integer temp[] = new Integer[arraySize];
	for(int i= 0; i < arraySize; i++){
		temp[i] =testArray[i];
		
	}

//Simple QuickSort
	
	/*int counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetRandom(testArray,temp);
		
		start = System.nanoTime(); 
		Quick.quickSort(testArray, arraySize-1);	
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
	
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	
    if(arraySize <= 20){
    	System.out.println("Now Entering Trace Output Mode!");
    	System.out.println();
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Simple QuickSort");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Random");
        	System.out.println("Before Sort");
        	resetRandom(testArray,temp);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 	
        	Quick.quickSort(testArray, 0, arraySize-1);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
	
	writer.println("Algorithim: Simple QuickSort");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Random");
	writer.println("Number of Trials: " + numberOfTrials);
	writer.println("Average Time: " + average2 + " second");
	writer.println();
*/

//Median of Three (5)
	int counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetRandom(testArray,temp);
		
		start = System.nanoTime(); 
		TextQuickMerge.quickSort(testArray, 0, arraySizeMinusOne);
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
    if(arraySize <= 20){
    	
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Median of Three (5)");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Random");
        	System.out.println("Before Sort");
        	resetRandom(testArray,temp);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 
        	TextQuickMerge.quickSort(testArray, 0, arraySizeMinusOne);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
	
	
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Median of Three (5)");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Random");
	writer.println("Number of Trials: "+ numberOfTrials);
	writer.println("Average Time: "+ average2+ " seconds");
	writer.println();

//Median of Three (10)
	counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetRandom(testArray,temp);
		
		start = System.nanoTime(); 
		TexQuickMerge10.quickSort(testArray, 0 , arraySizeMinusOne);
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
	 if(arraySize <= 20){
	    	
	    	int counter3 =0;
	    	while(counter3 < numberOfTrials){
	    		System.out.println("Algorithim: Median of Three (10)");
	        	System.out.println("Array Size: " + arraySize);
	        	System.out.println("Order: Random");
	        	System.out.println("Before Sort");
	        	resetRandom(testArray,temp);
	        	for(int i = 0; i < arraySize; i++){
	        		System.out.println(testArray[i]);
	        	}
	        	start = System.nanoTime(); 
	        	TexQuickMerge10.quickSort(testArray, 0, arraySizeMinusOne);
	        	finish = System.nanoTime();
	    	    delta = finish - start;
	        	System.out.println("After Sort");
	        	for(int i = 0; i < arraySize; i++){
	        		System.out.println(testArray[i]);
	        	}
	        	System.out.println("Time of Sort: " + delta + " nanoseconds");
	        	System.out.println();
	        	counter3++;
	    	}
	    
	    }
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Median of Three (10)");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Random");
	writer.println("Number of Trials: "+ numberOfTrials);
	writer.println("Average Time: "+ average2+ " seconds");
	writer.println();

//Median of Three (20)
	counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetRandom(testArray,temp);
		
		start = System.nanoTime(); 
		TextQuickMerge20.quickSort(testArray, 0, arraySizeMinusOne);
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
	if(arraySize <= 20){
    	
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Median of Three (20)");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Random");
        	System.out.println("Before Sort");
        	resetRandom(testArray,temp);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 
        	TextQuickMerge20.quickSort(testArray, 0, arraySizeMinusOne);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Median of Three (20)");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Random");
	writer.println("Number of Trials: "+ numberOfTrials);
	writer.println("Average Time:"+ average2+ " seconds");
	writer.println();

//Random Pivot(5)
	counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetRandom(testArray,temp);
		
		start = System.nanoTime(); 
		RandomPivotQuick.quickSort(testArray, 0, arraySizeMinusOne);
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
	if(arraySize <= 20){
    	
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Random Pivot");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Random");
        	System.out.println("Before Sort");
        	resetRandom(testArray,temp);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 
        	RandomPivotQuick.quickSort(testArray, 0, arraySizeMinusOne);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Random Pivot (5)");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Random");
	writer.println("Number of Trials: "+ numberOfTrials);
	writer.println("Average Time: "+ average2+ " seconds");
	writer.println();

//sorted order
	
	
	/*//Simple QuickSort
	counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetRegular(testArray);
		
		start = System.nanoTime(); 
		Quick.quickSort(testArray, arraySizeMinusOne);	
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
	if(arraySize <= 20){
    	
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Simple QuickSort");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Sorted");
        	System.out.println("Before Sort");
        	resetRegular(testArray);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 
        	Quick.quickSort(testArray, 0, arraySizeMinusOne);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Simple QuickSort");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Sorted");
	writer.println("Number of Trials: " + numberOfTrials);
	writer.println("Average Time: "+ average2+ " seconds");
	writer.println();
*/

//Median of Three (5)
	counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetRegular(testArray);
		
		start = System.nanoTime(); 
		TextQuickMerge.quickSort(testArray, 0, arraySizeMinusOne);
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
if(arraySize <= 20){
    	
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Median of Three (5)");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Sorted");
        	System.out.println("Before Sort");
        	resetRegular(testArray);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 
        	TextQuickMerge.quickSort(testArray, 0, arraySizeMinusOne);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Median of Three (5)");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Sorted");
	writer.println("Number of Trials: "+ numberOfTrials);
	writer.println("Average Time: "+ average2+ " seconds");
	writer.println();

//Median of Three (10)
	counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetRegular(testArray);
		
		start = System.nanoTime(); 
		TexQuickMerge10.quickSort(testArray, 0, arraySizeMinusOne);
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
if(arraySize <= 20){
    	
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Median of Three (10)");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Sorted");
        	System.out.println("Before Sort");
        	resetRegular(testArray);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 
        	TexQuickMerge10.quickSort(testArray, 0, arraySizeMinusOne);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Median of Three (10)");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Sorted");
	writer.println("Number of Trials: "+ numberOfTrials);
	writer.println("Average Time: "+ average2+ " seconds");
	writer.println();

//Median of Three (20)
	counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetRegular(testArray);
		
		start = System.nanoTime(); 
		TextQuickMerge20.quickSort(testArray, 0, arraySizeMinusOne);
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
if(arraySize <= 20){
    	
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Median of Three (20)");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Sorted");
        	System.out.println("Before Sort");
        	resetRegular(testArray);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 
        	TextQuickMerge20.quickSort(testArray, 0, arraySizeMinusOne);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Median of Three (20)");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Sorted");
	writer.println("Number of Trials: "+ numberOfTrials);
	writer.println("Average Time: "+ average2+ " seconds");
	writer.println();

//Random Pivot(5)
	counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetRegular(testArray);
		
		start = System.nanoTime(); 
		RandomPivotQuick.quickSort(testArray, 0, arraySizeMinusOne);
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
if(arraySize <= 20){
    	
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Random Pivot");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Sorted");
        	System.out.println("Before Sort");
        	resetRegular(testArray);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 
        	RandomPivotQuick.quickSort(testArray, 0, arraySizeMinusOne);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Random Pivot (5)");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Sorted");
	writer.println("Number of Trials: "+ numberOfTrials);
	writer.println("Average Time: "+ average2+ " seconds");
	writer.println();

//reverse order

	
/*
    
//Simple QuickSort
	counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetReverse(testArray);
		
		start = System.nanoTime(); 
		Quick.quickSort(testArray, arraySizeMinusOne);	
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
if(arraySize <= 20){
    	
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Simple QuickSort");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Reverse");
        	System.out.println("Before Sort");
        	resetReverse(testArray);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 
        	Quick.quickSort(testArray, 0, arraySizeMinusOne);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Simple QuickSort");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Reverse");
	writer.println("Number of Trials: " + numberOfTrials);
	writer.println("Average Time: " + average2 + " seconds");
	writer.println();
*/

	
	    
//Median of Three (5)
	counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetReverse(testArray);
		
		start = System.nanoTime(); 
		TextQuickMerge.quickSort(testArray, 0, arraySizeMinusOne);
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
if(arraySize <= 20){
    	
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Median of Three (5)");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Reverse");
        	System.out.println("Before Sort");
        	resetReverse(testArray);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 
        	TextQuickMerge.quickSort(testArray, 0, arraySizeMinusOne);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Median of Three (5)");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Reverse");
	writer.println("Number of Trials: "+ numberOfTrials);
	writer.println("Average Time: " + average2 + " seconds");
	writer.println();

	
	
		    
//Median of Three (10)
	counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetReverse(testArray);
		
		start = System.nanoTime(); 
		TexQuickMerge10.quickSort(testArray,0, arraySizeMinusOne);
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
if(arraySize <= 20){
    	
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Median of Three (10)");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Reverse");
        	System.out.println("Before Sort");
        	resetReverse(testArray);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 
        	TexQuickMerge10.quickSort(testArray, 0, arraySizeMinusOne);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Median of Three (10)");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Reverse");
	writer.println("Number of Trials: "+ numberOfTrials);
	writer.println("Average Time: "+ average2 + " seconds");
	writer.println();
	
	//sets the data into the array
	

//Median of Three (20)
	counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetReverse(testArray);
		
		start = System.nanoTime(); 
		TextQuickMerge20.quickSort(testArray, 0, arraySizeMinusOne);
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
if(arraySize <= 20){
    	
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Median of Three (20)");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Reverse");
        	System.out.println("Before Sort");
        	resetReverse(testArray);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 
        	TextQuickMerge20.quickSort(testArray, 0, arraySizeMinusOne);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Median of Three (20)");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Reverse");
	writer.println("Number of Trials: "+ numberOfTrials);
	writer.println("Average Time:"+ average2 + " seconds");
	writer.println();
	
	
	
		    
//Random Pivot(5)
	counter2 = 0;
	average1 = 0;
	while(counter2 < numberOfTrials){
		
		//sets the data into the array
		resetReverse(testArray);
		
		start = System.nanoTime(); 
		RandomPivotQuick.quickSort(testArray, 0, arraySizeMinusOne);
		finish = System.nanoTime();
	    delta = finish - start;
	    average1 = delta + average1;
	    //writer.println("DETLA " + delta);
	    //writer.println("AVG "+ average1);
	    counter2++;
	}
if(arraySize <= 20){
    	
    	int counter3 =0;
    	while(counter3 < numberOfTrials){
    		System.out.println("Algorithim: Random Pivot");
        	System.out.println("Array Size: " + arraySize);
        	System.out.println("Order: Reverse");
        	System.out.println("Before Sort");
        	resetReverse(testArray);
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	start = System.nanoTime(); 
        	RandomPivotQuick.quickSort(testArray, 0, arraySizeMinusOne);
        	finish = System.nanoTime();
    	    delta = finish - start;
        	System.out.println("After Sort");
        	for(int i = 0; i < arraySize; i++){
        		System.out.println(testArray[i]);
        	}
        	System.out.println("Time of Sort: " + delta + " nanoseconds");
        	System.out.println();
        	counter3++;
    	}
    
    }
    average2 = average1/numberOfTrials;
    average2 = average2/1000000000;
	writer.println("Algorithim: Random Pivot (5)");
	writer.println("Array Size: " + arraySize);
	writer.println("Order: Reverse");
	writer.println("Number of Trials: "+ numberOfTrials);
	writer.println("Average Time: "+ average2 + " seconds");
	writer.println();
	
	
	//closes and saves the file
	writer.close();
	
	
	
	}
	
public static void resetReverse(Integer[] f){
	
	int counter = 0;
	while(counter < arraySize-1){
		for(int i = arraySize; i > 0; i--){
			f[counter] = i;
			//System.out.println("Reset Order" + f[counter]);
			counter++;
		}
	}
	
}

public static void resetRegular(Integer[] f){
	
	
	for(int i = 0; i < arraySize; i++){
		f[i] = i+1;
		//System.out.println("Regular Order " + f[i]);
	}
}

public static void randomizeArray(Integer[] f){
	for(int i = 0; i < arraySize; i++){
		f[i] = i+1;
	    		
	}
	ArrayList random = new ArrayList();
	for(int i = 0; i<arraySize; i++){
		random.add(f[i]);
	}
	Collections.shuffle(random);
	for(int i = 0; i < arraySize; i++){
		f[i] = (Integer) random.get(i);
		//System.out.println("Random "  + f[i]);
	}

    //System.out.println("Done");
}

public static void resetRandom(Integer[] f, Integer[] g){
	
	for(int i = 0; i < arraySize; i++){
		f[i] = g[i];
		//System.out.println(f[i]);
	}
	//System.out.println("Done");
}
}
