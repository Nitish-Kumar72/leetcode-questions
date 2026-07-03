class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
         List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        int maxEdge = 0;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            maxEdge = Math.max(maxEdge, e[2]);
        }

        List<Integer> topo = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);

            for (int[] e : graph[u]) {
                if (--indegree[e[0]] == 0) {
                    q.offer(e[0]);
                }
            }
        }

        int low = 0;
        int high = maxEdge;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(mid, graph, topo, online, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int minEdge,
                          List<int[]>[] graph,
                          List<Integer> topo,
                          boolean[] online,
                          long k,
                          int n) {

        long INF = Long.MAX_VALUE / 4;

        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == INF)
                continue;

            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (int[] e : graph[u]) {

                int v = e[0];
                int cost = e[1];

                if (cost < minEdge)
                    continue;

                if (v != n - 1 && !online[v])
                    continue;

                if (dist[v] > dist[u] + cost) {
                    dist[v] = dist[u] + cost;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}