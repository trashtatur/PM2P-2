package UPN;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andi on 01.11.16.
 */
public final class InfixToUPN {

    public static void main(String[] args) {

        Scanner scaninput=new Scanner(System.in);
        while (true) {
            System.out.println(">> INPUT");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(">> OUTPUT");
            System.out.println(String.join(" ", InfixToUPN.process(input)));
            System.out.println();
        }


    }

    public static Queue<String> process(String line) {

        //1. Lege eine Queue und einen Stack an.
        Stack<String> stack=new Stack();
        Queue<String> queue=new LinkedBlockingQueue<String>();

        Scanner scanner=new Scanner(line);
        Pattern delim=Pattern.compile("\\s");
        scanner.useDelimiter(delim);

        Pattern numbers=Pattern.compile("\\s*(\\d+)\\s*");
        Matcher matchNum=numbers.matcher(scanner.next());

        Pattern operators=Pattern.compile("\\s*(\\+|-|\\*|/|\\(|\\)|,)\\s*");
        Matcher matchOp=operators.matcher(scanner.next());

        //2. Lies die Zeichenkette von links nach rechts
        while (scanner.hasNext()) {
            //3. Wird eine Zahl gelesen wird, dann schreibe diese in die Queue
            if (matchNum.matches()) {
                queue.add(matchNum.group(1));
            }
            //4. Wird ein Operator (Variable op) gelesen, dann
            else if (matchOp.matches()) {
                String op=matchOp.group(0);
                /* 4 a) a. wenn der Stack leer ist oder das oberster Element des Stacks die öffnende
                Klammer ist ('(') oder das oberste Element des Stacks geringere Präzedenz als op
                hat, dann lege op auf den Stack. Präzedenzregel:
                '(' vor '/' vor '*' vor '-' vor '+'vor ')' (siehe OpUtil Klasse)
                */
                if (stack.empty()||
                    stack.peek().equals("(") ||
                    OpUtil.lowerPrecedence(stack.peek(),op)) {

                        stack.push(op);

                }
                /* 4 b) sonst: nehme solange Operatoren vom Stack und schreibe diese in die Queue, wie
                        die Operatoren auf dem Stack höhere Präzedenz als op haben. Öffnende
                        Klammern '(' werden vom Stack genommen und nicht in die Queue geschrieben.
                */
                else {
                    while (OpUtil.higherPrecedence(stack.peek(),op)) {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                        }
                        else {
                            queue.add(stack.pop());
                        }
                    }
                    //Danach wird op auf den Stack gelegt. Ausnahme: Schließende Klammern werden
                    //nicht auf den Stack gelegt.
                    if (!op.equals(")")) {
                        stack.push(op);
                    }
                }
            }
        }
        /*
        5. Wenn die Eingabe abgearbeitet ist, dann nehme alle noch verbliebenen Operatoren vom
           Stack und schreibe diese in die Queue. Öffnende Klammern '(' werden vom Stack
           genommen und nicht in die Queue geschrieben.
        */
        while (!stack.isEmpty()) {
            if (stack.peek().equals("(")) {
                stack.pop();
            }
            else {
                queue.add(stack.pop());
            }
        }
        System.out.println(queue);
    return queue;
    }

}
