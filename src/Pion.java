/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Pion extends Piece {

    public Pion(char couleur, int x, int y){
        super((byte)1, couleur, 'P', x,y);
    }


    @Override
    public boolean positionPossible(Position position) {
        return true;
    }
}
