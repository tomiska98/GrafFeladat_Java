package graf_feladat;

public class Main {

    public static void main(String[] args) {
        Grafok G = new Grafok();

        MelysegiBejaras M = new MelysegiBejaras(G.getIranyitottG(), 2);
        SzelessegiBejaras Sz = new SzelessegiBejaras(G.getIranyitottG(), 2);

        Dijsktra D = new Dijsktra();
        D.legrovidebbUt(G.getIranyitatlanG(), 0);
    }

}
