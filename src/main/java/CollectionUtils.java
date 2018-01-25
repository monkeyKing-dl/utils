import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by daili on 2018/1/25.
 */
public class CollectionUtils {
    public static <K,V> Map<K,V> transferListToMap(String keyName, List<V> list)  {
        Field keyFiled = null;
        Class v = list.get(0).getClass();
        Field[] fields = v.getDeclaredFields();
        for(Field tempField : fields){
            if(tempField.getName().equals(keyName)){
                keyFiled = tempField;
                break;
            }
        }

        if(keyFiled !=null){
            Map<K,V> resultMap = new HashMap<K, V>();
            for(V tempV : list){
                try {
                    resultMap.put((K) keyFiled.get(tempV),tempV);
                } catch (IllegalAccessException e) {
                    return  null;
                }
            }
            return resultMap;
        }
        return null;
    }
}
