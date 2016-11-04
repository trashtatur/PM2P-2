package InfixToUPN;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andi on 03.11.2016.
 */
public final class UPNTaschenrechner {

    public static void main(String[] args) {

    }
    public static Double process(String line) {
        Stack<Double> stack= new Stack<Double>();
        Scanner scanner=new Scanner(line);
        Pattern delim=Pattern.compile("\\s");
        scanner.useDelimiter(delim);

        Pattern numbers=Pattern.compile("\\d+");
        Pattern operators=Pattern.compile("\\+|–|\\*|/|\\(|\\)|,");

        while (scanner.hasNext()) {
            String actualToken=scanner.next();
            Matcher matchNum=numbers.matcher(actualToken);
            Matcher matchOp=operators.matcher(actualToken);
        }
    }
}
