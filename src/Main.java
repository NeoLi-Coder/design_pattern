import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        
        // 使用 compute 实现对 key 的操作
        String key = "example";
        map.compute(key, (k, v) -> (v == null) ? 0 : v + 1);
        
        System.out.println(map); // 输出: {example=0}
        
        // 再次调用，对已存在的 key 进行操作
        map.compute(key, (k, v) -> (v == null) ? 0 : v + 1);
        
        System.out.println(map); // 输出: {example=1}
    }
}
