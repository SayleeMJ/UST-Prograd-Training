import java.util.Hashtable;
import java.util.Map;

public class HashTableExample {
    public static void main(String args[]){
        Hashtable<Integer,String> map=new Hashtable<Integer,String>();

        map.put(100,"Saylee");
        map.put(102,"Sunita");
        map.put(104,"Bhushan");
        map.put(103,"Mohan");
        map.put(101,"Sanat");
        map.put(105,"Nirmiti");

        for(Map.Entry m:map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

        System.out.println("\nAfter remove: "+ map.remove(102));
        System.out.println(map);

        System.out.println(map.getOrDefault(101, "Not Found"));
        System.out.println(map.getOrDefault(106, "Not Found"));

        System.out.println("\nInitial Map: "+map);

        map.putIfAbsent(104,"Simran");
        System.out.println("Updated Map: "+map);
        map.putIfAbsent(102,"Sanat");
        System.out.println("Updated Map: "+map);
    }
}

