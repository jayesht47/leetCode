package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 */
public class StudentsCantEat {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentsQueue = new LinkedList<>();
        Queue<Integer> sandwichQueue = new LinkedList<>();
        for (int student : students) {
            studentsQueue.add(student);
        }
        for (int sandwich : sandwiches) {

            sandwichQueue.add(sandwich);
        }
        while (studentsQueue.contains(sandwichQueue.peek())) {
            if (studentsQueue.peek() == sandwichQueue.peek()) {
                studentsQueue.remove();
                sandwichQueue.remove();
            } else studentsQueue.add(studentsQueue.remove());
        }
        return studentsQueue.size();
    }

}
