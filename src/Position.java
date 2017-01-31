/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
import Exception.PosException;

public class Position {

    private int posX;
    private int posY;

    public Position(int x, int y){
        this.posX = x;
        this.posY =y;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public boolean equals(Object position) {
        return (this.getPosX() == ((Position)position).getPosX() && this.getPosY() == ((Position)position).getPosY());
    }

// Converti des coordonnée xy COLONNEligne
    public static String positionToString(int x, int y) throws PosException {

        char colonne =' ';
        int ligne = -1;

        switch(x){
            case 0 : colonne = 'A';break;
            case 1 : colonne = 'B';break;
            case 2 : colonne = 'C';break;
            case 3 : colonne = 'D';break;
            case 4 : colonne = 'E';break;
            case 5 : colonne = 'F';break;
            case 6 : colonne = 'G';break;
            case 7 : colonne = 'H';break;
            default : throw new PosException("Erreur de colonne");
        }

        switch(y){
            case 0 : ligne = 0;break;
            case 1 : ligne = 1;break;
            case 2 : ligne = 2;break;
            case 3 : ligne = 3;break;
            case 4 : ligne = 4;break;
            case 5 : ligne = 5;break;
            case 6 : ligne = 6;break;
            case 7 : ligne = 7;break;
            default : throw new PosException("Erreur de ligne");
        }
        return colonne+Integer.toString(ligne);
    }

    // Converti COLONNE en int
    public static int convertiX(char colonne){

        int x = -1;

        switch (colonne){
            case 'a' :
            case 'A' : x = 0;break;
            case 'b' :
            case 'B' : x = 1;break;
            case 'c' :
            case 'C' : x = 2;break;
            case 'd' :
            case 'D' : x = 3;break;
            case 'e' :
            case 'E' : x = 4;break;
            case 'f' :
            case 'F' : x = 5;break;
            case 'g' :
            case 'G' : x = 6;break;
            case 'h' :
            case 'H' : x = 7;break;
            default : x = -1;break;
        }
        return x;
    }

    // Converti ligne en int
    public static int convertiY(int ligne){

        int y = -1;

        switch(ligne){
            case 0 : y = 0;break;
            case 1 : y = 1;break;
            case 2 : y = 2;break;
            case 3 : y = 3;break;
            case 4 : y = 4;break;
            case 5 : y = 5;break;
            case 6 : y = 6;break;
            case 7 : y = 7;break;
            default: y = -1;break;
        }
        return y;
    }
}


