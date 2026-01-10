package graphs;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Explanation:
        // We use Kahn’s Algorithm (BFS Topological Sort).
        // Build graph and indegree array, then process nodes with indegree 0.
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.offer(next);
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int[][] prerequisites = {{1,0},{2,1},{3,2}};
        System.out.println("Can finish courses: " + cs.canFinish(4, prerequisites)); // Expected: true
    }
}

