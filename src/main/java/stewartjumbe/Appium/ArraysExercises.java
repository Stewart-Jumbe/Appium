package stewartjumbe.Appium;

public class ArraysExercises {
	
	//Constructor
	
	public ArraysExercises() {

}
	
	
	//Answer to Q11
//Write a Java program to reverse an array of integer values.
	// int [] originalArray = {10,9,8,6,5}
	
	public void reverseArray(int [] originalArray) {
		
		//Creating reversed array and making it the same size as original Array
		
		int[] reversedArray = new int[originalArray.length];
		
		//Iterating through original array and assigning reverse index position in revesed Array
		for(int i=0;i<originalArray.length;i++) {
			
			originalArray[i]=reversedArray[(reversedArray.length -1)-i];
		}
		
		
	}

}
