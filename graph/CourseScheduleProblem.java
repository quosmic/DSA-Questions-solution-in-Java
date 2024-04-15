class Solution {
    public static boolean isCycle(ArrayList<Integer> graph[]){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycle_Util(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle_Util(ArrayList<Integer> graph[], int curr, boolean vis[], boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;

        for(int node : graph[curr]){
            if(stack[node]){
                return true;
            }
            if (!vis[node] && isCycle_Util(graph, node, vis, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
            int arr[] = {};
        if(isCycle(graph)){
            return false;
        }
        return true;
    }
}