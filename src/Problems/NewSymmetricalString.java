package Problems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NewSymmetricalString {
    public void checkNewSymmetricalString() throws IOException {
        File obj = new File("../java-beginner/src/Problems/Bai2.inp");
        File output = new File("../java-beginner/src/Problems/bai2_3.out");
        if (!obj.exists()) {
            obj.createNewFile();
        }
        if (!output.exists()) {
            System.out.println("File has not existed");
            output.createNewFile();
        }
        FileWriter writer = new FileWriter(output);
        Scanner input = new Scanner(obj);
        String line = "";
        String result = "";
        while (input.hasNextLine()) {
            line = input.nextLine();
            if (!line.isEmpty()) {
                line = line.replaceAll("\\s", "").toUpperCase();
                if (checkSymmetrical(line)) {
                    result = line + ";OK";
                } else {
                    String modifiedString = checkModifiedString(line);
                    if (modifiedString == "") {
                        result = line + ";NOK";
                    } else {
                        result = line + ";" + modifiedString + ";" + modifiedString.length();
                    }
                }
            }
            writer.write(result + "\n");
        }
        System.out.println("The result was written in file: " + output.getAbsolutePath());
        input.close();
        writer.close();
    }

    public static boolean checkSymmetrical(String input) {
        int length = input.length();
        char[] inputs = input.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            if (inputs[i] != inputs[length - i - 1]) return false;
        }
        return true;
    }

    public static String checkModifiedString(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String subString = input.substring(i, j);
                String deletedString = input.substring(0, i) + input.substring(j, input.length());
                int length = subString.length();
                if (checkSymmetrical(deletedString) && length <= input.length() / 2 && length >= 1) {
                    return deletedString;
                }
            }
        }
        return "";
    }
}
