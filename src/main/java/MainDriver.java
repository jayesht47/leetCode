import stack.InfixToPostfix;
import stack.TwoStack;


public class MainDriver {

    public static void main(String[] args) {

        InfixToPostfix infixToPostfix = new InfixToPostfix();

        String res  = infixToPostfix.converToPostFix("A * (B + C) + D");

        System.out.println(res);

    }
}
