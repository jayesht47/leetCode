package stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DFSDriver {

    public static void main(String[] args) {

        //Setting up nodes

        Node n3 = new Node(20, null);
        Node n2 = new Node(21, Arrays.asList(n3));
        Node n5 = new Node(23, null);
        Node n6 = new Node(27, null);
        Node n4 = new Node(24, Arrays.asList(n5, n6));
        Node n1 = new Node(26, Arrays.asList(n2, n4));

        RecurDFSImpl recurDFS = new RecurDFSImpl();

        boolean res = recurDFS.DFS(new Node(27, null), new HashSet<>(), n1);

        System.out.println(res);

    }

}
