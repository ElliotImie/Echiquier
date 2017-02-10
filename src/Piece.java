/**
 * Created by louveau.cdi04 on 27/01/2017.
 */

import Exception.PosException;

public abstract class Piece{


    protected byte valeure;
    protected char couleur;
    protected char symbole;
    protected Position position;

    public Piece( char couleur, Position position){
        this.couleur =couleur;
        this.position = position;
    }

    //region ---------- DEPLACEMENT ( deplacement possible, positionPossible, deplacement )

    public boolean deplacementPossible(Position position) {

        // Si la position choisi sort de l'échiquier, deplacementPossible = false;
        if (position.getPosX() < 0 || position.getPosX() > 8 || position.getPosY() < 0 || position.getPosY() > 8) {
            return false;
        }

        Piece pieceSurPos = Echiquier.getPiece(position);
        System.out.println(pieceSurPos);
        boolean posOccupe = true;

        // Si la case est vide, deplacement possible return true;
        if (pieceSurPos == null) {
            posOccupe = false;
            return true;
        }

        // Si il y a une piece sur la position choisi, vérifie que cette piece n'est pas de la meme couleur que le joueur.
        if (posOccupe) {
            if (pieceSurPos.getCouleur() == this.getCouleur()) {
                return false;
            } else return true;
        }
        return false;
    }

    public abstract boolean positionPossible(Position position);

    public void deplacement(Position position) throws PosException {
        if(this.positionPossible(position)){
            this.position.setPosX(position.getPosX());
            this.position.setPosY(position.getPosY());
        }
        else if(!this.positionPossible(position)){
            throw new PosException("Position invalide"); // A revoir
        }

    }

    //endregion

    //region ---------- GETTERS SETTERS

    public byte getValeure() {
        return this.valeure;
    }

    public char getCouleur() {
        return this.couleur;
    }

    public char getSymbole(){ return this.symbole; }

    public Position getPosition() {
        return this.position;
    }

    // -------------------

    public abstract void setValeure(byte valeure);

    public void setCouleur(char couleur) {

        this.couleur = couleur;
    }

    public void setSymbole(char symbole) {
        this.symbole = symbole;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    //endregion

    @Override
    public String toString() {
        return "Piece: "+this.getSymbole()+"\nCouleur: " +this.getCouleur()+
                "\nPosition: {x="+this.getPosition().getPosX()+", y="+this.getPosition().getPosY()+"}\n";
    }
}
