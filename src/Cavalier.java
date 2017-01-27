/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Cavalier extends Piece {

    public Cavalier(char couleur, int x, int y ){
        super((byte)3, couleur, 'C', x,y);
    }

    @Override
    public boolean positionPossible(Position position) {
        return true;
    }
}
