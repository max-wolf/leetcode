
import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = e; end = e; }
}

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int sz = intervals.size();

        int low = newInterval.start;
        int high = newInterval.end;

        ListIterator<Interval> iter = intervals.listIterator();

        while(iter.hasNext() ) {
            Interval it =  iter.next();

            if(high<it.start) {
                iter.previous();
                iter.add( new Interval(low, high) );
                return intervals;
            }


            if(low>it.end) {
                continue;
            } else {
                low = Math.min(low, it.start);
                high = Math.max(high, it.end);
                iter.remove();
            }
        }

        intervals.add(new Interval(low, high) );
        return intervals;
    }
}
