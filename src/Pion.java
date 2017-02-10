/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Pion extends Piece {

    public Pion(char couleur, Position position){
        super(couleur, position);
        this.valeure = Echiquier.getValeurePion();
        this.symbole = Echiquier.getSymbolePion();    }

    @Override
    public void setValeure(byte valeure) {
        Echiquier.setValeurePion(valeure);
        this.valeure = Echiquier.getValeurePion();
    }

    @Override
    public boolean positionPossible(Position position) {

        boolean estPossible = false;

        if (deplacementPossible(position)){

            //Si x égaux --> meme colonne,
            if(this.getCouleur() == Echiquier.getCouleur1()){
                // Si couleur = couleur1 --> Pieces du haut , si position = +1 ( vers le bas ) --> est possible OK
                if(this.position.getPosX() == position.getPosX() && position.getPosY() == this.position.getPosY()+1){
                    estPossible = true;
                }
            }

            else{
                if(this.position.getPosX() == position.getPosX() && position.getPosY() == this.position.getPosY()-1){
                    estPossible = true;
                }
            }

            // Gérer le cas des déplacement diagonale
        }
        return estPossible;
    }
}
