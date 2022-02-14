package app.stack;

import java.util.Stack;

// This class use stack to evaluate an expression (1*(1+2)+(7-3)/4)
public class ExpressionEval {

    public static double eval(String exp) {
        String[] tokens = exp.split(" ");
        Stack<Double> vals = new Stack<>();
        Stack<String> ops = new Stack<>();

        for(String token: tokens) {
        
            if( token.equals("(")) {}
            else if ( token.equals("+")) {ops.push(token);}
            else if ( token.equals("-")) {ops.push(token);}
            else if ( token.equals("*")) {ops.push(token);}
            else if ( token.equals("/")) {ops.push(token);}
            else if ( token.equals(")")) {
                double val = vals.pop();
                String op = ops.pop();
                if (op.equals("+")) {
                    val = vals.pop() + val;
                } else if (op.equals("-")) {
                    val = vals.pop() - val;
                } else if (op.equals("*")) {
                    val = vals.pop() * val;
                } else if (op.equals("/")) {
                    val = vals.pop() / val;
                }
                vals.push(val);
            } else {
                vals.push(Double.parseDouble(token));
            }
        }

        return vals.pop();
    }

    public static void main (String[] args) {
        String exp1 = "( ( 2 * 3 ) + 4 )";
        System.out.println(ExpressionEval.eval(exp1));
    }
}
