package lab8.b1b2b3;

import java.util.*;

public class Maps {
    public static int count(Map<Integer, Integer> map){
        return map.size();
    }

    public static void empty(Map<Integer, Integer> map){
        map.clear();
    }

    public static boolean contains(Map<Integer, Integer> map, int key){
        return map.containsKey(key);
    }

    public static boolean containsKeyValue(Map<Integer, Integer> map, int key, int value){
        return map.get(key) == value;
    }

    public static Set<Integer> keySet(Map<Integer, Integer> map){
        return map.keySet();
    }

    public static Collection<Integer> values(Map<Integer, Integer> map){
        return map.values();
    }

    public static String getColor(int value){
        if (value < 0 || value > 2){
            return null;
        }
        Map<Integer, String> result = new HashMap<>();
        result.put(0, "black");
        result.put(1, "white");
        result.put(2, "red");
        return result.get(value);
    }
}
