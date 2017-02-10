/**
 * Created by louveau.cdi04 on 30/01/2017.
 */

public class Tour extends Piece {

    public Tour(char couleur, Position position) {
        super(couleur, position);
        this.valeure = Echiquier.getValeureTour();
        this.symbole = Echiquier.getSymboleTour();
    }

    @Override
    public void setValeure(byte valeure) {
        Echiquier.setValeureTour(valeure);
        this.valeure = Echiquier.getValeureTour();
    }

    @Override
    public boolean positionPossible(Position position) {

        boolean estPossible = false;

        if (deplacementPossible(position)) {
            //Si x ou y sont égaux, la dame se dirige en ligne droit --> OK
            if (this.position.getPosX() == position.getPosX() || this.position.getPosY() == position.getPosY()) {
                estPossible = true;
            }
        }
        return estPossible;
    }
}