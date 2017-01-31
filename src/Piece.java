/**
 * Created by louveau.cdi04 on 27/01/2017.
 */

import Exception.PosException;

public abstract class Piece{


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

    public void setValeure(byte valeure) {
        this.valeure = valeure;
    }

    public void setCouleur(char couleur) {
        this.couleur = couleur;
    }

    public void setSymbole(char symbole) {
        this.symbole = symbole;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Piece: "+this.getSymbole()+"\nCouleur: " +this.getCouleur()+
                "\nPosition: {x="+this.getPosition().getPosX()+", y="+this.getPosition().getPosY()+"}\n";
    }
}
