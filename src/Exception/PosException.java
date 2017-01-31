package Exception;

/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class PosException extends Exception{

    public PosException(String message){
        super(message);
        System.out.println("Modifier la valeure de la position");
        // Veuillez saisir une autre position...
        // Piece.deplacement(..
    }

    public void conversionException(int y){
        System.out.println("Valeure ligne improbable");
     }

    public void conversionException(char x){
        System.out.println("Valeure colonne improbable");
    }
}

