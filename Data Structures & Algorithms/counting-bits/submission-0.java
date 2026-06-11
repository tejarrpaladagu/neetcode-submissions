class Solution {
    public int[] countBits(int n) {
        int[] array = new int[n+1];
        array[0] = 0;
        

        int curr = 1;
        int offset = 1;

        while(curr <= n){
            if(curr == 2 * offset){
                offset = curr;
            }
            array[curr] = array[curr-offset] +1;
            curr++;

        }
        return array;


        
    }
}
