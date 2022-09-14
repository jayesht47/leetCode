package stack;

import java.util.LinkedList;
import java.util.List;

public class JavaStackListImpl {

    private List<Integer> data;

    public JavaStackListImpl(int input) {
        data = new LinkedList<>();
        data.add(input);
    }

    public JavaStackListImpl() {
        data = new LinkedList<>();
    }

    public boolean push(int input) {
        return data.add(input);
    }

    public boolean pop() {
        if (data.isEmpty()) return false;
        else {
            data.remove(data.size() - 1);
            return true;
        }
    }

    @Override
    public String toString() {
        return "JavaStackListImpl{" +
                "data=" + data +
                '}';
    }

    public static void main(String[] args) {
        JavaStackListImpl j1 = new JavaStackListImpl(12);
        j1.push(11);
        j1.push(10);
        j1.push(9);
        System.out.println(j1);
        j1.pop();
        System.out.println(j1);
    }

}
