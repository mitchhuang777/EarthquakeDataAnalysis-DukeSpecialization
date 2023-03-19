import java.util.*;
// import edu.duke.*;

public class EarthQuakeClient2 {
    public static void main(String[] args) {
        EarthQuakeClient2 eqc = new EarthQuakeClient2();
        // eqc.quakesWithFilter();
        // eqc.testMatchAllFilter();
        eqc.testMatchAllFilter2();
    }

    
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }
    

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        
        
        /* Filter earthquakes using two criteria, those with magnitude between 4.0 and 5.0 and depth between -35000.0 and -12000.0 */
        
        Filter f1 = new MagnitudeFilter(3.5, 4.5);
        ArrayList<QuakeEntry> list1 = filter(list, f1);
        Filter f2 = new DepthFilter(-55000.0, -20000.0);
        ArrayList<QuakeEntry> list2 = filter(list1, f2);
        for (QuakeEntry qe : list2) {
            System.out.println(qe);
        }
        
        
        /*
        Filter f3 = new DistanceFilter(new Location(39.7392, -104.9903), 1000*1000);
        ArrayList<QuakeEntry> list3 = filter(list, f3);
        Filter f4 = new PhraseFilter("end", "a");
        ArrayList<QuakeEntry> list4 = filter(list3, f4);
        for (QuakeEntry qe : list4) {
            System.out.println(qe);
        }
         */
        
        System.out.println("Found " + list2.size() + " quakes that match that criteria");
        
        
    }

    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

    public void testMatchAllFilter() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(1.0, 4.0));
        maf.addFilter(new DepthFilter(-180000.0, -30000.0));
        maf.addFilter(new PhraseFilter("any", "o"));
        ArrayList<QuakeEntry> list1 = filter(list, maf);
        for (QuakeEntry qe : list1) {
            System.out.println(qe);
        }
        System.out.println("Found "+list1.size()+" quakes that match all filters");
        /* print out all the filter names */
        System.out.println(maf.getName());
    }

    public void testMatchAllFilter2() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(0, 5.0));
        maf.addFilter(new DistanceFilter(new Location(55.7308, 9.1153), 3000*1000));
        maf.addFilter(new PhraseFilter("any", "e"));
        
        ArrayList<QuakeEntry> list1 = filter(list, maf);
        for (QuakeEntry qe : list1) {
            System.out.println(qe);
        }
        System.out.println("Found "+list1.size()+" quakes that match all filters");
        /* print out all the filter names */
        System.out.println(maf.getName());
    }


    

}
