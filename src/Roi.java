import javafx.geometry.Pos;

/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Roi extends Piece {

    public Roi(char couleur, Position position){
        super(couleur, position);
        this.valeure = Echiquier.getValeureRoi();
        this.symbole = Echiquier.getSymboleRoi();    }

    @Override
    public void setValeure(byte valeure) {
        Echiquier.setValeureRoi(valeure);
        this.valeure = Echiquier.getValeureRoi();
    }

    @Override
    public boolean positionPossible(Position position) {

        boolean estPossible = false;

        if (deplacementPossible(position)) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (position.getPosX() == this.position.getPosX() + i && position.getPosY() == this.position.getPosY() + j) {
                        estPossible = true;
                        break;
                    }
                }
            }
        }
        return estPossible;
    }


}
