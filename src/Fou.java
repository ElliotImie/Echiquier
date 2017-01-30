/**
 * Created by louveau.cdi04 on 30/01/2017.
 */

public class Fou extends Piece {

    public Fou(char couleur, int x, int y ){
        super((byte)3, couleur, 'F', x,y);
    }

    @Override
    public boolean positionPossible(Position position) {
        return true;
    }
}
