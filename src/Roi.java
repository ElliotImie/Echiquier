/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Roi extends Piece {

    public Roi(char couleur, int x, int y ){
        super(Echiquier.getValeureRoi(), couleur, Echiquier.getSymboleRoi(), x,y);
    }

    @Override
    public boolean positionPossible(Position position) {

        boolean estPossible = false;
//Vérifie que la position indiqué se trouve bien dans les limites de l'échiquier et vérifie qu'elle se trouve dans le rayon d'action du roi.
        if(position.getPosX() > 0 && position.getPosX() <8 && position.getPosY()>0 && position.getPosY() <8){
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
