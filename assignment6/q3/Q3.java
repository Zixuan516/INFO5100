package assignment6.q3;

public class Q3 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] sArray = new int[26];
        for (int i = 0; 0 < t.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
            sArray[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i ++){
            if(sArray[i] != 0){
                return false;
            }
        }
        return true;
    }
}
