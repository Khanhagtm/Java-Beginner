package Problems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LongestSubString {
	public void checkSubStringLongest()throws IOException {
		File obj = new File("../java-beginner/src/Problems/Bai2.inp");
		File output = new File("../java-beginner/src/Problems/bai2_2.out");
		if(!obj.exists()){
	        obj.createNewFile();
	    }
		if(!output.exists()){
			System.out.println("File has not exitted");
	        output.createNewFile();
	    }
		FileWriter writer = new FileWriter(output);
		Scanner input = new Scanner(obj);
		String line = "";
		String result = "";
		while(input.hasNextLine()) {
			line = input.nextLine();
			if(!line.isEmpty()) {
				line = line.replaceAll("\\s", "").toUpperCase();
				String subString = checkSubString(line);
				if(!subString.isEmpty()) {
					result = line + ";" + subString + ";" + subString.length();
				} else {
					result = line + ";NULL;0";
				}
				writer.write(result + "\n");
			}
		}
		System.out.println("The result was written in file: " + output.getAbsolutePath());
		input.close();
		writer.close();
	}
	
	public static boolean checkSymmetrial(String input) {
		int length = input.length();
		char[] inputs = input.toCharArray();
		for(int i = 0 ;i < length/2 ;i++) {
			if(inputs[i] != inputs[length - i - 1]) return false;
		}
		return true;
	}
	
	public static String checkSubString(String input) {
		String longestSubString = "";
		int maxlength = 0;
		for(int i = 0 ;i < input.length()  ;i++) {
			for(int j = i+1 ;j <= input.length() ;j++) {
				String subString = input.substring(i, j);
				int length = subString.length();
				if(checkSymmetrial(subString) && length > maxlength && length > 1 && length < input.length()) {
					maxlength = subString.length();
					longestSubString = subString;
				}
			}
		}
		return longestSubString;
	}
}