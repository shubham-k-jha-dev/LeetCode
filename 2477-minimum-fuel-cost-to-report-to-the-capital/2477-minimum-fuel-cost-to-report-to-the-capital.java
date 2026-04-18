class Solution {
    private long fuel = 0;
    private int seats;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        this.seats = seats;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        dfs(0, -1, graph);
        return fuel;
    }

    private long dfs(int node, int parent, List<List<Integer>> graph) {
        long representatives = 1;
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                representatives += dfs(neighbor, node, graph);
            }
        }

        if (node != 0) {
            fuel += (representatives + seats - 1) / seats;
        }

        return representatives;
    }
}