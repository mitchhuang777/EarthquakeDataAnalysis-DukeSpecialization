import java.util.*;
public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        int titleCompare = qe1.getInfo().compareTo(qe2.getInfo());
        if (titleCompare != 0) {
            return titleCompare;
        } else {
            return Double.compare(qe1.getDepth(), qe2.getDepth());
        }
    }
}