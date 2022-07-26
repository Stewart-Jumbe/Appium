package stewartjumbe.Appium;

import java.util.Arrays;

public class ArrayExerciseMethods {
	
	//Attribute
	int [] reversedArray;
	
	
	//Constructor
	
	public ArrayExerciseMethods() {
		
	}
	
	//Methods
	
	//Method to find max and min value of an int array
	public String findMinMaxValue(int [] numberArray) {
		
		//setting index 0 and 1 to equal numberArray index 0
		int[] tempArray = {numberArray[0],numberArray[0]}; //index 0 for largest num, index 1 for smallest num
		
		
		for(int i=0;i<numberArray.length;i++) {
			
			if(i>0) {
			if(numberArray[i]>numberArray[i-1]) {
				tempArray[0] = numberArray[i];
			}else if(numberArray[i]<numberArray[i-1]) {
				tempArray[1]=numberArray[i];
			}
		}
			
		}
		
		return "Largest value in array is "+tempArray[0] +" The smallest value in the array is: "+ tempArray[1];
	}
	
	public String findMinMaxValue2(int [] numberArray) {
		
		//setting index 0 and 1 to equal numberArray index 0
		int[] bigSmall = {numberArray[0],numberArray[0]};
		
		
		for(int i=0 ; i<bigSmall.length;i++) {
			for(int j=0; j<numberArray.length;j++) {
				
				if( bigSmall[i]>=numberArray[j]) 
				{bigSmall[0]=numberArray[j];}
				
				else if(bigSmall[i]<=numberArray[j]) 
				{bigSmall[1]=numberArray[j];}
				
				else {bigSmall[0]=numberArray[j];
			}
			
		}
			}
		return "The largest number is: "+bigSmall[1] +" and the smallest is: "+bigSmall[0];
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
