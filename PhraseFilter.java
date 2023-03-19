public class PhraseFilter implements Filter {
    private String where;
    private String phrase;

    public PhraseFilter(String where, String phrase) {
        this.where = where;
        this.phrase = phrase;
    }

    public boolean satisfies(QuakeEntry qe) {
        if (where.equals("start")) {
            return qe.getInfo().startsWith(phrase);
        } else if (where.equals("end")) {
            return qe.getInfo().endsWith(phrase);
        } else if (where.equals("any")) {
            return qe.getInfo().contains(phrase);
        }
        return false;
    }

    public String getName() {
        return "Phrase";
    }
}