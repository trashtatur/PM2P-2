package UPN;

import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by andi on 01.11.16.
 */
public final class InfixToUPN {

    public static void main(String[] args) {

    }

    public static Queue<String> process(String line) {
        Scanner scanner=new Scanner(line);
        Pattern delim=Pattern.compile("\\s");
        scanner.useDelimiter(delim);
    }

}
