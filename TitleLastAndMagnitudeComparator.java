import java.util.*;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        String title1 = qe1.getInfo();
        String title2 = qe2.getInfo();
        int lastSpace1 = title1.lastIndexOf(" ");
        int lastSpace2 = title2.lastIndexOf(" ");
        String lastWord1 = title1.substring(lastSpace1 + 1);
        String lastWord2 = title2.substring(lastSpace2 + 1);
        int lastWordCompare = lastWord1.compareTo(lastWord2);
        if (lastWordCompare != 0) {
            return lastWordCompare;
        } else {
            return Double.compare(qe1.getMagnitude(), qe2.getMagnitude());
        }
    }
}