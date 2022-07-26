package stewartjumbe.Appium;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
//   https://www.w3resource.com/java-exercises/array/index.php Q3
//    	String [] dashes = {"-","-", "-" ,"-" ,"-", "-", "-", "-", "-", "-"};
//    	printDashes(dashes);
  
    
//    	Write a Java program to reverse an array of integer values.
    	//int[] numArray = {10,9,8,7,6,5,4,3,2,1};
    	//reverseArray(numArray);

    	//Reversing using created class
    	 //initialising reversedArray2
//        int [] myArray = {20,30,40,50,60,70,210,250,999};
//        ArrayExerciseMethods reverse = new ArrayExerciseMethods();
//        System.out.print(" ");
//        System.out.println(reverse.getReversedArray(myArray));
    	
    	ArrayExerciseMethods methods = new ArrayExerciseMethods();
    	int[] numberArray = {99999,100,20,7,99,1256,0};
    	//System.out.print(methods.findMinMaxValue(numberArray));
    	System.out.print(methods.findMinMaxValue2(numberArray));
    	

    }
    
    public static void reverseArray(int [] numArray) {
    	
    	System.out.println("Original Array is: "+Arrays.toString(numArray));
    	
    int [] reversedArray = new int [numArray.length];
    	
    
    	for(int i=0; i<numArray.length;i++) {
    		
    		int endIndex = numArray.length -1 ;//9
    		System.out.println("endIndex - i is: "+ (endIndex-i));
    		
    		reversedArray[i]=numArray[endIndex - i];
    		
    	}	
    	
    	System.out.print("Reversed Array is: " +Arrays.toString(reversedArray));

    }
    
    public static void printDashes(String[] dashes) {
	for (int j= 0; j<dashes.length;j++) {
    		
	    	for (int i=0; i< dashes.length; i++) {
	    		System.out.print(dashes[i]);
	    	}
	    	System.out.println(" ");
    }
}
    
    
  
    
   
    
  
    
}
