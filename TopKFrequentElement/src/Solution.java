
import java.util.*;
class MyPair {
    int val;
    int num;
    public MyPair(int val, int num) {
        this.val = val;
        this.num = num;
    }
}

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        PriorityQueue<MyPair> maxheap = new PriorityQueue<>(new Comparator<MyPair>() {
            @Override
            public int compare(MyPair o1, MyPair o2) {
                return o2.num - o1.num;
            }
        });
        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            MyPair myPair = new MyPair(entry.getKey(), entry.getValue());
            maxheap.offer(myPair);
        }
        List<Integer> result = new ArrayList<>();
        while (result.size() < k) {
            result.add(maxheap.poll().val);
        }
        return result;
    }
}

class Solution2 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        PriorityQueue<MyPair> minheap = new PriorityQueue<>(new Comparator<MyPair>() {
            public int compare(MyPair o1, MyPair o2) {
                return o1.num - o2.num;
            }
        });
        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            MyPair myPair = new MyPair(entry.getKey(), entry.getValue());
            minheap.offer(myPair);
            if(minheap.size() > k) {
                minheap.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while (minheap.size() > 0) {
            result.add(minheap.poll().val);
        }
        return result;
    }
}

class Solution3 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int n : map.keySet()) {
            int count = map.get(n);
            if(bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(n);
        }
        List<Integer> result = new ArrayList<>();
        int len = bucket.length;
        for(int i = len - 1; i > 0 && k > 0; i--) {
            if(bucket[i] != null) {
                result.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }
        return result;
    }
}
