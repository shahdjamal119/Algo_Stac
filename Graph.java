
import java.util.*;
class Graph {
    private final int numVertices;
    private final ArrayList<ArrayList<Integer>> adjList;
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; ++i)
            adjList.add(new ArrayList<Integer>());
    }
    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
    }
    public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack)
    {
        visited[v] = true;
        Integer i;
        for (Integer integer : adjList.get(v))
        {
            i = integer;
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        stack.push(v);
    }
    public List<Integer> topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }
}



