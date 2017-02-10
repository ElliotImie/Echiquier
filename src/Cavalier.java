/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Cavalier extends Piece {

    public Cavalier(char couleur, Position position ){
        super(couleur, position);
        this.valeure = Echiquier.getValeureCavalier();
        this.symbole = Echiquier.getSymboleCavalier();
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
