/**
 * Created by louveau.cdi04 on 27/01/2017.
 */

import Exception.PosException;

public abstract class Piece{
    public static char couleur1 = 'b';
    public static char couleur2 = 'n';
    public static byte valeureRoi = 20;
    public static byte valeureDame = 13;
    public static byte valeureCavalier = 3;
    public static byte valeureFou = 3;
    public static byte valeureTour = 3;
    public static byte valeurePion = 1;
    public static char symboleRoi = 'R';
    public static char symboleDame = 'D';
    public static char symboleCavalier = 'C';
    public static char symboleFou = 'F';
    public static char symboleTour = 'T';
    public static char symbolePion = 'P';

    protected byte valeure;
    protected char couleur;
    protected char symbole;
    protected Position position;

    public Piece(byte valeure, char couleur, char symbole, int x, int y){
        this.valeure= valeure;
        this.couleur =couleur;
        this.symbole = symbole;

        position = new Position(x,y);
    }

    public abstract boolean positionPossible(Position position);

    public void deplacement(Position position) throws PosException {
        if(this.positionPossible(position)){
            this.position.setPosX(position.getPosX());
            this.position.setPosY(position.getPosY());
        }
        else if(!this.positionPossible(position)){
            throw new PosException("Position invalide");
        }

    }

    public byte getValeure() {
        return valeure;
    }

    public char getCouleur() {
        return couleur;
    }

    public char getSymbole() {
        return symbole;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Piece: "+this.getSymbole()+"\nCouleur: " +this.getCouleur()+
                "\nPosition: {x="+this.getPosition().getPosX()+", y="+this.getPosition().getPosY()+"}\n";
    }
}
