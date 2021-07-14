
import javax.swing.text.NumberFormatter;
import java.util.Scanner;

public class NumericFormatTranslator extends NumberFormatter {

    public static void main(String[] args){

        NumericFormatTranslator n = new NumericFormatTranslator();
        n.numericFormatTranslator();
    }

    public int numericFormatTranslator() {
        int result = 0;
        String stringFild = "";  // input string

        Scanner in = new Scanner(System.in);

        boolean flag = false;

        while (flag == false) {

            stringFild = in.nextLine();
            if (isNumber(stringFild) == true) {

                int stringFildLength = stringFild.length();

                // Data verification: "+", "-" and without sign.
                // Sample: “123345” -> 123345, “-123345” -> -123345, “+1” -> 1

                if (stringFild.startsWith("+")) {
                    StringBuilder str = new StringBuilder(stringFild);
                    str.delete(0, 1);
                    stringFild = str.toString();
                    stringFildLength = stringFild.length();
                    flag = true;
                }
                if (stringFild.startsWith("-")) {
                    stringFildLength = stringFild.length() - 1;
                     flag = true;
                }
               flag = true;

                // Data verification: range of values of the input string length should be
                // from 2 to Math.pow(2, 32) - 1

                 if ((long) stringFildLength < 2 |
                            (long) stringFildLength > Math.pow(2, 32) - 1) {
                    System.out.println("Put positive or negative number from 2 numeric symbols");
                    flag = false;
                 }
            }
            flag = flag;
        }
        result = Integer.parseInt(stringFild);
        System.out.println(result);
        return result;
    }

    // Data verification: input string should't be empty and
    // should contain integer value numeric only

    public static boolean isNumber(String strNum) {
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            System.out.println("Put integer value numeric only. Positive or negative.");
            return false;
        }
        return true;
    }
}

