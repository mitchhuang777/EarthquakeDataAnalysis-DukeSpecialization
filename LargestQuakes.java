import java.util.*;

public class LargestQuakes {
    public static void main(String[] args) {
        LargestQuakes lq = new LargestQuakes();
        lq.findLargestQuakes();

    }


    // findLargestQuakes
    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        // String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());

        ArrayList<QuakeEntry> largest = getLargest(list, 50);
        for (QuakeEntry qe : largest) {
            System.out.println(qe);
        }
        System.out.println("number found: "+largest.size());
    }

    // indexOfLargest
    public int indexOfLargest(ArrayList<QuakeEntry> data) {
        int maxIndex = 0;
        for (int i = 0; i < data.size(); i++) {
            QuakeEntry quake = data.get(i);
            if (quake.getMagnitude() > data.get(maxIndex).getMagnitude()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        for (int i = 0; i < howMany; i++) {
            int maxIndex = 0;
            for (int j = 0; j < copy.size(); j++) {
                QuakeEntry quake = copy.get(j);
                if (quake.getMagnitude() > copy.get(maxIndex).getMagnitude()) {
                    maxIndex = j;
                }
            }
            ret.add(copy.get(maxIndex));
            copy.remove(maxIndex);
        }

        return ret;
    }
}
