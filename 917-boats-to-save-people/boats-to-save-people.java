class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int mini = 0;
        int boat = 0;

        Arrays.sort(people);
        int sum = 0;

        int i = 0;
        int j = n-1;

        while(i <= j){
            if(people[i] + people[j] <= limit){
              
                i++;
                j--;
                 
            }else{
                j--;
              
            }
              boat++;
        }
        return boat;
    }
}