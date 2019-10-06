package assignment4.q5;

public class Q5 {
    public int[] permutation(String s) {
        int min = 0, max = s.length();
        int[] res = new int[s.length()+1];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I'){
                res[i] = min;
                min = min +1;
            }else{
                res[i] = max;
                max = max -1;
            }
        }
        res[s.length()] = min;
        return res;
    }
}
