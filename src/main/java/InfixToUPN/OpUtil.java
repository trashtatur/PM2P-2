package InfixToUPN;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by andi on 01.11.16.
 */
public final class OpUtil {


    private static ArrayList<String> precedencelist = new ArrayList<String>(Arrays.asList( "(", "/", "*", "-","+", ")"));




    public static boolean lowerPrecedence(String op1, String op2) {
        int  indexOp1=precedencelist.indexOf(op1);
        int  indexOp2=precedencelist.indexOf(op2);
        return indexOp1>indexOp2;
    }

    public static boolean higherPrecedence(String op1, String op2) {
        int  indexOp1=precedencelist.indexOf(op1);
        int  indexOp2=precedencelist.indexOf(op2);
        return indexOp1<indexOp2;

    }

}
