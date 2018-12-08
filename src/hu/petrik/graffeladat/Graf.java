package hu.petrik.graffeladat;

import java.util.ArrayList;

/**
 * Irányítatlan, egyszeres gráf.
 */
public class Graf {
    private int csucsokSzama;
    private ArrayList<El> elek = new ArrayList<>();
    private ArrayList<Csucs> csucsok = new ArrayList<>();
    
    /**
     * Létehoz egy úgy, N pontú gráfot, élek nélkül.
     * 
     * @param csucsok A gráf csúcsainak száma
     */
    public Graf(int csucsok) {
        this.csucsokSzama = csucsok;
        
        // Minden csúcsnak hozzunk létre egy új objektumot
        for (int i = 0; i < csucsok; i++) {
            this.csucsok.add(new Csucs(i));
        }
    }

    /**
     * Hozzáad egy új élt a gráfhoz
     * 
     * @param cs1 Az él egyik pontja
     * @param cs2 Az él másik pontja
     */
    public void hozzaad(int cs1, int cs2) {
        if (cs1 < 0 || cs1 >= csucsokSzama ||
            cs2 < 0 || cs2 >= csucsokSzama) {
            throw new IndexOutOfBoundsException("Hibas csucs index");
        }
        
        // cs1 mindig legyen kisebb, mint cs2
        // Ha nem, akkor cseréljük meg
        if (cs2 < cs1) {
            int tmp = cs1;
            cs1 = cs2;
            cs2 = tmp;
        }
        
        // Ha már szerepel az él, akkor nem kell felvenni
        for (El el: elek) {
            if (el.getCsucs1() == cs1 && el.getCsucs2() == cs2) {
                return;
            }
        }
        
        elek.add(new El(cs1, cs2));
    }

    @Override
    public String toString() {
        String str = "Csucsok:\n";
        for (Csucs cs: csucsok) {
            str += cs + "\n";
        }
        str += "Elek:\n";
        for (El el: elek) {
            str += el + "\n";
        }
        return str;
    }
}
