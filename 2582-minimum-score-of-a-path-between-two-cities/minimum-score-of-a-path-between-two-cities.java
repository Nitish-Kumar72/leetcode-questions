class Solution {

    class Pair {
        int node;
        int wt;

        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public int minScore(int n, int[][] roads) {

        ArrayList<Pair>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : roads) {

            int u = road[0];
            int v = road[1];
            int w = road[2];

            graph[u].add(new Pair(v, w));
            graph[v].add(new Pair(u, w));
        }

        Queue<Pair> q = new LinkedList<>();

        boolean[] vis = new boolean[n + 1];

        q.offer(new Pair(1, 0));

        vis[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            Pair cur = q.poll();

            int u = cur.node;

            for (Pair next : graph[u]) {

                ans = Math.min(ans, next.wt);

                if (!vis[next.node]) {

                    vis[next.node] = true;

                    q.offer(new Pair(next.node, next.wt));
                }
            }
        }

        return ans;
    }
}