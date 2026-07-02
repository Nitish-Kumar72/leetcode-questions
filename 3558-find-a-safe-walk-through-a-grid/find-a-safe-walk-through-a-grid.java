class Solution {
    static int dr[] = {-1 , 1 , 0 , 0};
    static int dc[] = {0 , 0 , -1 , 1};
    static int rlen;
    static int clen;


    static class pair{
        int row;
        int col;
        int health;

        public pair(int row , int col , int health){
            this.row = row;
            this.col = col;
            this.health = health;

        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        rlen = grid.size();
        clen = grid.get(0).size();

        Queue<pair> q = new LinkedList<>();
        int maxh[][] = new int[rlen][clen];
        

        int shealth = health - grid.get(0).get(0);
        if (shealth <= 0) return false;

        q.offer(new pair(0 , 0 ,shealth));
        maxh[0][0] = shealth;
        

        while(!q.isEmpty()){
            pair curr = q.poll();

            int R = curr.row;
            int C = curr.col;
            int currhealth = curr.health;

            if(R == rlen -1 && C == clen-1 && currhealth >=1){
                return true;
            }

            for(int k = 0; k < 4; k++){
                int nr = R + dr[k];
                int nc =  C + dc[k];

                if(nr >= 0 && nc >= 0 && nr < rlen && nc < clen){
                    int newhealth = currhealth - grid.get(nr).get(nc);
                    
                    if (newhealth > 0 && newhealth > maxh[nr][nc]) {

                        maxh[nr][nc] = newhealth;
                        q.offer(new pair(nr, nc, newhealth));
                    }
                }         
            }
        }

        return false;
        
    }
}