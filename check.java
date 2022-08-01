package miniproject;
                    
         




import java.util.*;

public class check{
	int[] arr = new int[15];
	int count=0;

public check(){
	
	String str = "Trail@123";


	// Creating array of string length
	char[] ch = new char[str.length()];

	// Copy character by character into array
	for (int i = 0; i < str.length(); i++) {
		ch[i] = str.charAt(i);
	}


	// Printing content of array
	for (char c : ch) {
		
		



     if('a' <= c && c <= 'z'){
    	 arr[count]=1;
    	 count++;
    	 break;
    	 
    	 
     }
     else if(('A' <= c && c <= 'Z')) {
    	 arr[count]=2;
    	 count++;
    	 
    	 break;
     }
     else if('0' <= c && c <= '9') {
    	 arr[count]=3;
    	 count++;
    	 break;
     }
     else if((33 <=c && c <= 47) || (58 <=c && c <=64) || (91 <=c && c <=96) ||  (123 <=c && c <=127)) {
    	 arr[count]=4;
    	 count++;
    	 
     }
}
	
	

for(int k:arr) {
	System.out.print(arr[k]);
}


		
	
		
		
		
		
	
}








	public static void main(String args[])
	{
		new check();
		
		}
         }
      