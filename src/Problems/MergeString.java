package Problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MergeString {
	public void checkMergeString() throws IOException {
	    File inputFile = new File("../java-beginner/src/Problems/Bai2.inp");
	    File outputFile = new File("../java-beginner/src/Problems/bai2_4.out");

	    if (!inputFile.exists()) {
	        System.out.println("Input file does not exist.");
	        return;
	    }

	    if (!outputFile.exists()) {
	        System.out.println("Output file does not exist.");
	        outputFile.createNewFile();
	    }

	    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	         BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

	        String[] strings = new String[1000];
	        int count = 0;

	        String line;
	        while ((line = reader.readLine()) != null) {
	            String normalizedString = line.replaceAll("\\s", "").toUpperCase();
	            if (!checkSymmetrical(normalizedString)) {
	                strings[count++] = normalizedString;
	            }
	        }

	        if (count >= 2) {
	            String firstString = null;
	            String secondString = null;
	            int maxPalindromeLength = 0;

	            for (int i = 0; i < count - 1; i++) {
	                for (int j = i + 1; j < count; j++) {
	                    String mergedString = mergeStrings(strings[i], strings[j]);
	                    String mergedReversedString = mergeReversedStrings(strings[i], strings[j]);
	                    if (mergedString.length() > maxPalindromeLength && checkSymmetrical(mergedString)) {
	                        firstString = strings[i];
	                        secondString = strings[j];
	                        maxPalindromeLength = mergedString.length();
	                    }
	                    if (mergedReversedString.length() > maxPalindromeLength && checkSymmetrical(mergedReversedString)) {
	                        firstString = strings[i];
	                        secondString = strings[j];
	                        maxPalindromeLength = mergedReversedString.length();
	                    }
	                }
	            }

	            if (firstString != null && secondString != null) {
	                writer.write(firstString + "\n");
	                writer.write(secondString + "\n");
	                writer.write(maxPalindromeLength > 0 ? mergeStrings(firstString, secondString) : "No suitable pair found to create a palindrome.");

	                System.out.println("Processing completed. Check bai2_4.out for results.");
	            } else {
	                System.out.println("No suitable pair found to create a palindrome.");
	            }
	        } else {
	            System.out.println("Not enough non-palindromic strings found.");
	        }
	    }
	}

	public static String mergeReversedStrings(String str1, String str2) {
	    StringBuilder mergedStringBuilder = new StringBuilder(str1);

	    for (int i = str2.length() - 1; i >= 0; i--) {
	        mergedStringBuilder.append(str2.charAt(i));
	    }

	    return mergedStringBuilder.toString();
	}

	public static String mergeStrings(String str1, String str2) {
	    StringBuilder mergedStringBuilder = new StringBuilder(str1);

	    for (int i = 0; i < str2.length(); i++) {
	        mergedStringBuilder.append(str2.charAt(i));
	    }

	    return mergedStringBuilder.toString();
	}

	public static boolean checkSymmetrical(String input) {
	    int length = input.length();
	    for (int i = 0; i < length / 2; i++) {
	        if (input.charAt(i) != input.charAt(length - i - 1)) {
	            return false;
	        }
	    }
	    return true;
	}
}