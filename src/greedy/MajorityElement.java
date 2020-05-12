package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(final List<Integer> A) {
        int maj = (int)Math.floor(A.size()/2);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            Integer key = A.get(i);
            Integer val = map.getOrDefault(key, 0);
            if (val  >= maj) {
                return key;
            }
            map.put(key, val+1);
        }

        return 0;
    }

    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length/2];
        int leader=nums[0],leader_count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==leader) leader_count++;
            else{
                leader_count--;
                if(leader_count==0){
                    if(i<nums.length-1){
                        leader=nums[i+1];
                        leader_count=1;
                        i++;
                    }
                }
            }
        }
        return leader;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2, 2};
        System.out.println(new MajorityElement().majorityElement(nums));
    }

}
