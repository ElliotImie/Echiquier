/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Dame extends Piece {

    public Dame(char couleur, int x, int y ){
        super((byte)9, couleur, 'D', x,y);
    }

    @Override
    public boolean positionPossible(Position position) {

        boolean estPossible = false;

        //Vérifie que la position indiqué se trouve bien dans les limites de l'échiquier
        if(position.getPosX() > 0 && position.getPosX() < 8 && position.getPosY()> 0 && position.getPosY() < 8){

            //Si x ou y sont égaux, la dame se dirige en ligne droit --> OK
            if(this.position.getPosX() == position.getPosX() || this.position.getPosY() == position.getPosY()){
                estPossible = true;
            }

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
