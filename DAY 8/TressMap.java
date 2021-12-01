import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String > map = new TreeMap<>();

        map.put(100,"Saylee");
        map.put(101,"Sanat");
        map.put(102,"Sunita");
        map.put(103,"Bhushan");
        map.put(105,"Mohan");
        map.put(104,"Nirmiti");
        map.putIfAbsent(106, "Charndraknta");
        System.out.println(map);
        System.out.println("\nAfter invoking get method: " + map.get(101) + "\n");

        Set set =map.entrySet();
        for (Object o : set) {
            Map.Entry<Integer, String> entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        System.out.println("\nAfter invoking remove: " + map.remove(101,"Sanat"));
        for (Map.Entry<Integer, String> m : map.entrySet()){
            System.out.println(m.getKey() + "->" + m.getValue());
        }

        System.out.println("\nDescendingMap: "+map.descendingMap());
        
        System.out.println("\nHeadMap: "+map.headMap(102,true));
      
        System.out.println("\nTailMap: "+map.tailMap(102,true));
        
        System.out.println("\nSubMap: "+map.subMap(100, false, 102, true));

        System.out.println("\nIs value present: " + map.containsValue(101));
        System.out.println("\nIs value present: " + map.containsValue("Saylee"));
    }
}

