package stewartjumbe.Appium;

import java.util.Arrays;

public class ArrayExerciseMethods {
	
	//Attribute
	int [] reversedArray;
	
	
	//Constructor
	
	public ArrayExerciseMethods() {
		
	}
	
	public String reverseArray (int [] numberArray) {
		
		//Sample input
		// number array : [10,20,30,40,50,60,70,80,90,100]
		//revered array: [100,90,80,70,60,50,40,30,20,10 ]

		
		int [] reversedArray = new int [numberArray.length]; // reversed Array will be same size a number array
		
		int lastPos= numberArray.length-1; //last index position
		
		//Iterating through array and place value at opposite index position#
		//inserting values into a new array which has the values in a reversed order
		
		for (int i=0;i<numberArray.length;i++) {
		reversedArray[i]=numberArray[(lastPos)-i];	
		}
		
		
		
		
		return Arrays.toString(reversedArray);
	}

	
	public String getReversedArray(int [] originalArray) {
		
		return "\nOriginal Array was"+Arrays.toString(originalArray)+ "\nThe revesed version is: "+  reverseArray(originalArray);
	}
	
	
	
	

}
