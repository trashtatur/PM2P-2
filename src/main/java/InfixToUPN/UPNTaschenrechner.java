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
        while (true) {
            System.out.println(">IN");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String processedinput = String.join(" ", InfixToUPN.process(input));
            System.out.println(">OUT");
            System.out.println(UPNTaschenrechner.process(processedinput));
            System.out.println();
        }
    }

    public static Double process(String line) {
        Stack<Double> stack= new Stack<Double>();
        Scanner scanner=new Scanner(line);
        Pattern delim=Pattern.compile("\\s");
        scanner.useDelimiter(delim);

        Pattern numbers=Pattern.compile("\\d+");
        Pattern operators=Pattern.compile("\\+|–|-|-|\\*|/");

        while (scanner.hasNext()) {
            String actualToken=scanner.next();
            Matcher matchNum=numbers.matcher(actualToken);
            Matcher matchOp=operators.matcher(actualToken);

            if (matchNum.matches()) {
                stack.push(Double.valueOf(actualToken));
            }
            else if (matchOp.matches()) {
                Double num2= stack.pop();
                Double num1= stack.pop();

                switch (actualToken) {
                    case "+": stack.push(num1+num2);
                                break;
                    case "-": stack.push(num1-num2);
                                break;
                    case "–": stack.push(num1-num2);
                                break;
                    case "*": stack.push(num1*num2);
                                break;
                    case "/": stack.push(num1/num2);
                                break;
                }

            }

        }
         return stack.peek();
    }
}
