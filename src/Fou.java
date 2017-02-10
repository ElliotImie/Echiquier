/**
 * Created by louveau.cdi04 on 30/01/2017.
 */

public class Fou extends Piece {

    public Fou(char couleur, Position position ){
        super(couleur, position);
        this.valeure = Echiquier.getValeureFou();
        this.symbole = Echiquier.getSymboleFou();    }

    @Override
    public void setValeure(byte valeure) {
        Echiquier.setValeureCavalier(valeure);
        this.valeure = Echiquier.getValeureCavalier();
    }


    @Override
    public boolean positionPossible(Position position) {

        boolean estPossible = false;

        if (deplacementPossible(position)){

            // Vérification de la diagonale :
            int distanceX = Math.abs(this.position.getPosX() - position.getPosX());
            int distanceY = Math.abs(this.position.getPosY() - position.getPosY());

            if(distanceX == distanceY){
                estPossible = true;
            }
        }
        return estPossible;
    }
}

