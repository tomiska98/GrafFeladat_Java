package graf_feladat;

import java.util.ArrayList;

public class Graf {

    private final int csucsokSzama;
    private final ArrayList<El> elek = new ArrayList<>();
    private final ArrayList<Csucs> csucsok = new ArrayList<>();

    public Graf(int csucsok) {
        this.csucsokSzama = csucsok;

        for (int i = 0; i < csucsok; i++) {
            this.csucsok.add(new Csucs(i));
        }
    }

    public void hozzaad(int cs1, int cs2, int suly) {
        if (cs1 < 0 || cs1 >= csucsokSzama
                || cs2 < 0 || cs2 >= csucsokSzama) {
            throw new IndexOutOfBoundsException("Hibás csucs index");
        }

        for (El el : elek) {
            if (el.getCsucs1() == cs1 && el.getCsucs2() == cs2) {
                return;
            }
        }
        elek.add(new El(cs1, cs2, suly));

    }

    public ArrayList<El> getElek() {
        return elek;
    }

    public ArrayList<Csucs> getCsucsok() {
        return csucsok;
    }

    @Override
    public String toString() {
        String str = "Csucsok:\n";
        for (Csucs cs : csucsok) {
            str += cs + "\n";
        }
        str += "Elek:\n";
        for (El el : elek) {
            str += el + "\n";
        }
        return str;
    }
}
