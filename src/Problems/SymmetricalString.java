package Problems;
import java.io.*;
import java.util.*;

public class SymmetricalString {
	public void checkSymmetricalString()throws IOException {
		File obj = new File("../java-beginner/src/Problems/Bai2.inp");
		File output = new File("../java-beginner/src/Problems/bai2_1.out");
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
				if(checkSymmetrial(line)) {
					result = line + ";TRUE";
				} else {
					result = line + ";FALSE";
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
}
