import java.util.HashMap;
import java.util.Map;

public class Dictionary
{
    private Map<String, String> entry = new HashMap<String, String>();
    
    public void newEntry(String key, String value){
      this.entry.put(key, value);
    }
    
    public String look(String key){
      for(String n: entry.keySet()){
        if(key == n){
          return entry.get(n);
        }
      }
      return "Cant find entry for " + key;
    }
 
}