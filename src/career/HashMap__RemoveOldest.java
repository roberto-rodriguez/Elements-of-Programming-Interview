/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package career;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author 17864
 */
public class HashMap__RemoveOldest {

    public static void main(String[] args) {
        Cache cache = new Cache();
        cache.put("A", 1);
        cache.put("B", 1);
        cache.put("C", 1);
//        System.out.println(cache.get("A"));
           System.out.println(cache.read("A"));
        cache.put("D", 1);
        
//        cache.put("A", 1);
//     

        System.out.println(cache);
    }

}

class Cache extends LinkedHashMap<String, Integer>{

    private int size = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > size;
    }
    
    public Integer read(String key){
        Integer value = remove(key);
        
        if(value != null){ 
            put(key, value);
        }
        
        return value;
    }
}
