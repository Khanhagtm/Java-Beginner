package Problems;
import java.io.*;
import java.util.*;

public class SumOfTwoBigNumber{
	public void caculatorSum() throws IOException {
		File object = new File("../java-beginner/src/Problems/Bai1a.inp");
		File output = new File("../java-beginner/src/Problems/Bai1.out");
		
        if (output.createNewFile()) {
            System.out.println("File created: " + output.getAbsolutePath());
        } else {
            System.out.println("File already exists.");
        }
		Scanner reader = new Scanner(object);
		String num1 = reader.nextLine();
		String num2 = reader.nextLine();
		reader.close();
		System.out.println("Number 1: " + num1);
		System.out.println("Number 2: " + num2);
		num1 = stringReverse(num1);
		num2 = stringReverse(num2);
	
		if(num1.length() > num2.length()) {
			System.out.println("Result: " + sumResult(num1,num2));
		} else {
			System.out.println("Result: " + sumResult(num2,num1));
		}
		try (FileWriter writer = new FileWriter(output)) {
            if (num1.length() > num2.length()) {
                writer.write(sumResult(num1, num2));
            } else {
                writer.write(sumResult(num2, num1));
            }
            System.out.println("Result written to the file.");
        }
		
	}
	
	public String stringReverse(String originalString) {
	    char[] charArray = originalString.toCharArray();
	    
	    int length = charArray.length;
	   
	    for (int i = 0; i < length / 2; i++) {
	        char temp = charArray[i];
	        charArray[i] = charArray[length - 1 - i];
	        charArray[length - 1 - i] = temp;
	    }
	    
	    return new String(charArray);
	}
	
	public String sumResult(String num1,String num2) {
		char[] number1 = num1.toCharArray();
		char[] number2 = num2.toCharArray();
		String reresult = "";
		int len = num1.length();
		int temp = 0;
		for(int i = 0 ;i < len ;i++) {
			 int digit1 = (i < num1.length()) ? Character.getNumericValue(number1[i]) : 0;
		     int digit2 = (i < num2.length()) ? Character.getNumericValue(number2[i]) : 0;
			temp = digit1 + digit2 + temp;
			if(temp >= 10) {
				int tmp = (temp - 10);
				reresult = reresult.concat(String.valueOf(tmp));
				temp = 1;
			} else {
				reresult = reresult.concat(String.valueOf(temp));
				temp = 0;
			}
		}
		if(temp == 1) reresult = reresult.concat("1");
		return stringReverse(reresult);
	}

}

