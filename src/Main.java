/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Main {

    public static void main(String[] args) {

        Echiquier echiquier = Echiquier.getEchiquier();

        Roi roiBlanc = new Roi('b', 3,0);
        Dame dameBlanc = new Dame('b', 4,0);
        Cavalier cavalier1Blanc = new Cavalier('b', 5,0);
        Cavalier cavalier2Blanc = new Cavalier('b', 2,0);

        echiquier.ajouterPiece(roiBlanc);
        echiquier.ajouterPiece(dameBlanc);
        echiquier.ajouterPiece(cavalier1Blanc);
        echiquier.ajouterPiece(cavalier2Blanc);

        echiquier.afficher();
    }
}
