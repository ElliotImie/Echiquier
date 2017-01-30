/**
 * Created by louveau.cdi04 on 30/01/2017.
 */

public class Tour extends Piece {

    public Tour(char couleur, int x, int y ){
        super((byte)3, couleur, 'T', x,y);
    }

    @Override
    public boolean positionPossible(Position position) {
        return true;
    }
}
