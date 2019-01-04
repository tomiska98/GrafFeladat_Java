package graf_feladat;

class El {

    private int csucs1;
    private int csucs2;
    private int suly;

    public El(int csucs1, int csucs2, int suly) {
        this.csucs1 = csucs1;
        this.csucs2 = csucs2;
        this.suly = suly;
    }

    public int getCsucs1() {
        return csucs1;
    }

    public int getCsucs2() {
        return csucs2;
    }

    public int getSuly() {
        return suly;
    }

    @Override
    public String toString() {
        return String.format("(%d - %d - %d)", csucs1, csucs2, suly);
    }
}
