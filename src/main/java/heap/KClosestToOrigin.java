package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestToOrigin {

    public class Point {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;
    }

    public int[][] kClosest(int[][] points, int k) {
        if (k == points.length) return points;
        int[][] result = new int[k][2];
        PriorityQueue<Point> heap =
                new PriorityQueue<>(Comparator.comparingInt(a -> ((a.x * a.x) + (a.y * a.y))));
        Arrays.stream(points).forEach(a -> heap.add(new Point(a[0], a[1])));
        for (int i = 0; i < k; i++) {
            Point p = heap.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }
        return result;
    }
}
