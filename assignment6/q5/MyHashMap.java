package assignment6.q5;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;

public class MyHashMap {

    private ArrayList<Integer> key;
    private ArrayList<Integer> value;

    public MyHashMap() {
        this.key = new ArrayList<Integer>();
        this.value = new ArrayList<Integer>();
    }

    public void put(Integer key, Integer value){
        if(this.key.contains(key)){
            this.value.set(this.key.indexOf(key),value);
        }else{
            this.key.add(key);
            this.value.add(value);
        }
    }
    public Integer get(Integer key){
        if(this.key.contains(key)){
            return this.value.get(this.key.indexOf(key));
        }else{
            return -1;
        }
    }

    public void remove(Integer key){
        if(this.key.contains(key)){
            this.value.remove(this.key.indexOf(key));
            this.key.remove(key);
        }
    }

    public ArrayList getKey() {
        return key;
    }

    public void setKey(ArrayList key) {
        this.key = key;
    }

    public ArrayList getValue() {
        return value;
    }

    public void setValue(ArrayList value) {
        this.value = value;
    }

    public static void main(String[] args){
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);            // returns 1
        int a = hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        int b = hashMap.get(2);            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        int c = hashMap.get(2);            // returns -1 (not found)
    }
}
