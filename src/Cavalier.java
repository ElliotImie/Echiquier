/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Cavalier extends Piece {

    public Cavalier(char couleur, int x, int y ){
        super(Echiquier.getValeureCavalier(), couleur, Echiquier.getSymboleCavalier(), x,y);
    }

    @Override
    public void setValeure(byte valeure) {
        Echiquier.setValeureCavalier(valeure);
        this.valeure = Echiquier.getValeureCavalier();
    }

    @Override
    public boolean positionPossible(Position position) {
        return true;
    }
}
