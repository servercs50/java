import java.util.Stack;

public class Calculator {
    public static String ExpressionToRPN(String Expr){
        StringBuilder current = new StringBuilder(" ");
        Stack<Character> stack = new Stack<>();

        int priority;

        for(int i =0; i<Expr.length();i++){
            priority = getP(Expr.charAt(i));

            if(priority == 0)
            {
                current.append(Expr.charAt(i));
            }
            if(priority == 1)
            {
                stack.push(Expr.charAt((i)));
            }
            if(priority > 1)
            {
                current.append(' ');
                while(!stack.empty())
                {
                    if(getP(stack.peek()) >= priority)
                    {
                        current.append(stack.pop());
                    }
                    else break;
                }
                stack.push(Expr.charAt(i));
            }
            if(priority == -1){
                current.append(' ');
                while (getP(stack.peek()) != 1)
                {
                    current.append(stack.pop());
                }
                stack.pop();
            }
        }
    while(!stack.empty()){
        current.append(stack.pop());
    }

        return current.toString();
    }
    public static double RPNtoAnswer(String rpn){
        StringBuilder operand = new StringBuilder(new String());
        Stack<Double> stack = new Stack<>();

        for(int i = 0; i<rpn.length();i++){
            if(rpn.charAt(i) == ' ') continue;

            if(getP(rpn.charAt(i)) == 0){
                while(rpn.charAt(i) != ' ' && getP(rpn.charAt(i)) == 0){
                    operand.append(rpn.charAt(i++));
            if(i == rpn.length())break;}
                stack.push(Double.parseDouble(String.valueOf(operand)));
                operand = new StringBuilder();
            }
            if(getP(rpn.charAt(i)) > 1){
                double num1 = stack.pop(), num2 = stack.pop();

                if(rpn.charAt(i) == '+') stack.push(num2+num1);
                if(rpn.charAt(i) == '-') stack.push(num2-num1);
                if(rpn.charAt(i) == '*') stack.push(num2*num1);
                if(rpn.charAt(i) == '/') stack.push(num2/num1);
                if(rpn.charAt(i) == '^') stack.push(Math.pow(num2,num1));


        }
        }
        return stack.pop();
    }
    private static int getP(char token){
        if(token == '*' || token == '/') return 3;
        else if(token == '+' || token == '-') return 2;
        else if(token == '(') return 1;
        else if(token == ')') return -1;
        else if(token == '^') return 4;
        else return 0;
    }
}
