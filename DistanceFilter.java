public class DistanceFilter implements Filter {
    private Location fromWhere;
    private double maxDistance;

    public DistanceFilter(Location loc, double max) {
        fromWhere = loc;
        maxDistance = max;
    }

    public boolean satisfies(QuakeEntry qe) {
        return qe.getLocation().distanceTo(fromWhere) < maxDistance;
    }

    public String getName() {
        return "Distance";
    }
}