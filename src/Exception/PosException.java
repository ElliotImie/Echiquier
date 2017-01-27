package Exception;

/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class PosException extends Exception{

    public PosException(String message){
        super(message);
        System.out.println("Modifier la valeure de la position");
    }
}

