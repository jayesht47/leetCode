import stack.TwoStack;


public class MainDriver {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        TwoStack twoStack = new TwoStack();

        System.out.println("current twoStack is :: " + twoStack);
        twoStack.push1(1);
        twoStack.push2(2);
        twoStack.push1(1);
        twoStack.push2(2);
        System.out.println("current twoStack is :: " + twoStack);

        System.out.println(twoStack.pop1());

        System.out.println("current twoStack is :: " + twoStack);

        System.out.println(twoStack.pop2());

        System.out.println("current twoStack is :: " + twoStack);
        System.out.println(twoStack.pop2());
        System.out.println("current twoStack is :: " + twoStack);
        System.out.println("Time taken in ms :: " + (System.currentTimeMillis() - startTime));


    }
}
