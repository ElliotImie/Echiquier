import java.util.List;

/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Main {

    public static void main(String[] args) {

        Echiquier echiquier = Echiquier.getEchiquier();

        echiquier.initialiserEchiquier();

        echiquier.afficher();


    }
}
