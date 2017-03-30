import java.util.*;

class listComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}
public class HIndex {
    public static void main(String[] args) {
        HIndex hi = new HIndex();
        int[] cit = {3, 0, 6, 1, 5};
        System.out.println(hi.hIndex(cit));
    }

    public int hIndex(int[] citations) {
        int len = citations.length;
        int hindex = 0;
        /*ArrayList<Integer> list = new ArrayList<>();
        for(int i : citations) {
            list.add(i);
        }
        Collections.sort(list, new listComparator());
        System.out.println(list);
        for(int i = 0; i < len; i++) {
            if(list.get(i) >= i+1)  hindex = i+1;
        }*/
        Arrays.sort(citations);
        for(int i = len-1; i >= 0; i--) {
            if(citations[i] >= len-i) hindex = len-i;
        }
        return hindex;
    }
}
