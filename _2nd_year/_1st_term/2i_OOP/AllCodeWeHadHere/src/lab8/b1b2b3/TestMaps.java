package lab8.b1b2b3;

import java.util.HashMap;
import java.util.Map;

public class TestMaps {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);
        System.out.println("map here: " + map);

        System.out.println("\nTest count():");
        System.out.println(Maps.count(map));

        System.out.println("\nTest empty():");
        Maps.empty(map);
        System.out.println(map);

        System.out.println("\nGenerate map again.");
        map.put(1,2);
        map.put(2,3);
        map.put(3,4);

        System.out.println("\nTest contains 2 or not:");
        System.out.println(Maps.contains(map, 2));

        System.out.println("\nTest containsKeyValue():");
        System.out.println(Maps.containsKeyValue(map, 3, 5));

        System.out.println("\nTest keySet():");
        System.out.println(Maps.keySet(map));

        System.out.println("\nTest values():");
        System.out.println(Maps.values(map));

        System.out.println("\nTest getColor():");
        System.out.println(Maps.getColor(2));
    }
}
