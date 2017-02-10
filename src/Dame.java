import java.util.List;

/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Dame extends Piece {

    public Dame(char couleur, Position position) {
        super(couleur, position);
        this.valeure = Echiquier.getValeureDame();
        this.symbole = Echiquier.getSymboleDame();
    }

    @Override
    public void setValeure(byte valeure) {
        Echiquier.setValeureDame(valeure);
        this.valeure = Echiquier.getValeureDame();
    }


    @Override
    public boolean positionPossible(Position position) {

        if (deplacementPossible(position)) {

            //Si x ou y sont égaux, la dame se dirige en ligne droit --> OK
            if (this.position.getPosX() == position.getPosX() || this.position.getPosY() == position.getPosY()) {
                return true;
            }

            // Vérification de la diagonale :
            int distanceX = Math.abs(this.position.getPosX() - position.getPosX());
            int distanceY = Math.abs(this.position.getPosY() - position.getPosY());
            if (distanceX == distanceY) {
                return true;
            }
        }
        return false;
    }





}
