package Problems;
import java.io.*;
import java.util.*;

public class FactorialOfNumber {
	public void FactorialCaculator() throws IOException {
		System.out.println("Nhap N(0 <= N <= 500): ");
		Scanner Input = new Scanner(System.in);
		int n = Input.nextInt();
		Input.close();
		int[] result = caculateFactorial(n);
		writeResultToFile(result);
	}
	
	public static int[] caculateFactorial(int n) {
		int[] result = new int[1200];
		result[0] = 1;
		for(int i = 1 ;i <= n ;i++) {
			result = multiply(result,i);
		}
		return result;
	}
	
	public static int[] multiply(int[] result,int number) {
		int balance = 0;
		int nextResult = 0;
		int i;
		for(i = 0 ;i < result.length ;i++) {
			nextResult = result[i] * number + balance;
			result[i] = nextResult % 10;
			balance = nextResult / 10;
		}
		while(balance != 0) {
			i++;
			result[i] = balance % 10;
			balance = balance / 10;
		}
		return result;
	}
	
	private static void writeResultToFile(int[] result) {
	    try (FileWriter writer = new FileWriter("../java-beginner/src/Problems/bai1b.out")) {
	        int lastDigitIndex = result.length - 1;
	        while (lastDigitIndex > 0 && result[lastDigitIndex] == 0) {
	            lastDigitIndex--;
	        }

	        for (int i = lastDigitIndex; i >= 0; i--) {
	            writer.write((char) ('0' + result[i]));
	        }
	        writer.close();
	        System.out.println("The result was written in file: bai1b.out");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
