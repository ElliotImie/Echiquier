/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Cavalier extends Piece {

    public Cavalier(char couleur, int x, int y ){
        super(valeureCavalier, couleur, symboleCavalier, x,y);
    }

    @Override
    public boolean positionPossible(Position position) {
        return true;
    }
}
