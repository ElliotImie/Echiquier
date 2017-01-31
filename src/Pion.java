/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Pion extends Piece {

    public Pion(char couleur, int x, int y){
        super(Echiquier.getValeurePion(), couleur, Echiquier.getSymbolePion(), x,y);
    }

    @Override
    public boolean positionPossible(Position position) {

        boolean estPossible = false;

        //Vérifie que la position indiqué se trouve bien dans les limites de l'échiquier
        if(position.getPosX() > 0 && position.getPosX() < 8 && position.getPosY()> 0 && position.getPosY() < 8){

            //Si x égaux --> meme colonne,
            if(this.getCouleur() == 'b'){
                // Si couleur = b, ( Pieces du haut ), si position = +1 ( vers le bas ) --> est possible OK
                if(this.position.getPosX() == position.getPosX() && position.getPosY() == this.position.getPosY()+1){
                    estPossible = true;
                }
            }

            else{
                if(this.position.getPosX() == position.getPosX() && position.getPosY() == this.position.getPosY()-1){
                    estPossible = true;
                }
            }
        }
        return estPossible;
    }
}
