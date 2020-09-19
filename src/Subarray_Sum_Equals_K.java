import java.util.HashMap;
import java.util.Map;

public class Subarray_Sum_Equals_K {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum=0, count=0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(map.containsKey(sum-k))
                count += map.get(sum-k);
            if(map.containsKey(sum))
                map.put(sum, map.get(sum)+1);
            else
                map.put(sum, 1);
        }
        return count;
    }
}
