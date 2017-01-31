/**
 * Created by louveau.cdi04 on 30/01/2017.
 */

public class Fou extends Piece {

    public Fou(char couleur, int x, int y ){
        super(Echiquier.getValeureFou(), couleur, Echiquier.getSymboleFou(), x,y);
    }

    @Override
    public void setValeure(byte valeure) {
        Echiquier.setValeureCavalier(valeure);
        this.valeure = Echiquier.getValeureCavalier();
    }


    @Override
    public boolean positionPossible(Position position) {

        boolean estPossible = false;

        //Vérifie que la position indiqué se trouve bien dans les limites de l'échiquier
        if(position.getPosX() > 0 && position.getPosX() < 8 && position.getPosY()> 0 && position.getPosY() < 8){

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

