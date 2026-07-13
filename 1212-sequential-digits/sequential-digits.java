class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= 8; i++){
            q.offer(i);   
        }

        while(!q.isEmpty()){
            int curr = q.poll();


            if (curr >= low && curr <= high) {
                ans.add(curr);
            }

            int lastdigit = curr % 10;

            if(lastdigit <9){
                q.add(curr * 10 + (lastdigit + 1));
            }

        }
        return ans;
    }
}