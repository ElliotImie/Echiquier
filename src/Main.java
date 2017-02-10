import java.util.List;

/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Main {

    public static void main(String[] args) {

        Echiquier echiquier = Echiquier.getEchiquier();

        echiquier.initialiserEchiquier();

        echiquier.afficher();


        Position posRoi = new Position(2,1);
        Piece pieceATest = Echiquier.getPiece(posRoi);
        System.out.println(pieceATest);

        Echiquier.supprimerPiece(pieceATest);

        Piece pieceATest2 = Echiquier.getPiece(posRoi);
        System.out.println(pieceATest2);

        Position posDame = new Position(4,0);

        Piece dameBlanche = Echiquier.getPiece(posDame);
        //Echiquier.supprimerPiece(Echiquier.getPiece(posDame));
        System.out.println(dameBlanche.positionPossible(new Position(6,3)));

        Echiquier.supprimerPiece(Echiquier.getPiece(Position.position("E8")));

        System.out.println(Position.position("D2").getPosX());
        System.out.println(Position.position("D2").getPosY());


    /*
*     System.out.println(Echiquier.getListPiece().get(0).getPosition().getPosX());

        System.out.println(Echiquier.getListPiece().get(0).getPosition().getPosY());

    */
       echiquier.afficher();
       Echiquier.supprimerPiece(Echiquier.getPiece(Position.position("F1")));
        System.out.println(Echiquier.getPiece(Position.position("A1")));
        System.out.println(Echiquier.getPiece(Position.position("A1")).positionPossible(Position.position("F1")));


        /*
        List<Piece> list = echiquier.getListPiece();

        for(Piece p : list){
            if(p.getClass().getCanonicalName() == "Roi"){
                System.out.println(p.getValeure());
            }
        }



        echiquier.modifValeure("Roi", (byte)10);


        for(Piece p : list){
            if(p.getClass().getCanonicalName() == "Roi"){
                System.out.println(p.getValeure());
            }
        }

        echiquier.sauvegarderParametre();
        echiquier.lireParametre();

        echiquier.modifValeure("Dame", (byte)5);
        echiquier.lireParametre();
        echiquier.sauvegarderParametre();
        echiquier.lireParametre();

        */



    }
}
