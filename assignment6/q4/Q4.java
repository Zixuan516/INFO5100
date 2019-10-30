package assignment6.q4;

import java.util.*;

public class Q4 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map= new HashMap<Integer, Integer>();

        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }
}
