import java.util.HashMap;
import java.util.Map;

public class Mapdemo {
    public static void main(String args[])
    {
        HashMap<Integer, String> map = new HashMap<>();

        HashMap<Integer, String> map1 = new HashMap<Integer, String>();

        // Add Elements using put method
        map.put(1, "Saylee");
        map.put(2, "Bhushan");
        map.put(3, "Sunita");

        map1.put(4, "Mohan");
        map1.put(2, "Sanat");
        map1.put(3, "Nirmiti");

        System.out.println("Mappings of HashMap map are : " + map);
        System.out.println("Mapping of HashMap map1 are : " + map1);

        System.out.println("Iterating Hashmap...");
        for(Map.Entry m : map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
        System.out.println("\n");
        for(Map.Entry m : map1.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

        map.putIfAbsent(4, "Simran");
        System.out.println("After invoking putIfAbsent() method ");
        for(Map.Entry m:map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
//        HashMap<Integer,String> map=new HashMap<Integer,String>();
        map.put(5,"Shamali");
        map1.putAll(map);
        System.out.println("After invoking putAll() method ");
        for(Map.Entry m:map1.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
}

