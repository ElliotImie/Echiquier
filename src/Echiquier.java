import javax.swing.text.AttributeSet;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by louveau.cdi04 on 27/01/2017.
 */


public class Echiquier {

    private static Echiquier echiquier;
    public static Scanner scan = new Scanner(System.in);


    protected List<Piece> listPiece;

    private Echiquier(){
        listPiece = new ArrayList<Piece>();
    }

    public static Echiquier getEchiquier(){
        if(echiquier == null){
            echiquier = new Echiquier();
        }
        return echiquier;
    }

    public void ajouterPiece(Piece piece){
        listPiece.add(piece);
    }

    public Piece getPiece(Position position){
        Piece piece = null;

        for(Piece p : listPiece){
            if(p.getPosition().equals(position)){
                piece = p;
            }
        }

        return piece;
    }

    public int getPoints(char couleur){

        int point = 0;

        for(Piece p : listPiece){
            if(p.getCouleur() == couleur){
                point += p.getValeure();
            }
        }
        return point;
    }

    public String[][] construireMatrice(){

        String[][] matrice = new String[8][8];
        //Initialisation de la matrice à vide :
        for(int i =0 ; i<8 ; i++){ //Ordonnée
            for(int j=0; j<8 ; j++){ // Abscisse
                matrice[i][j] = " ";
            }
        }

        for(int i =0 ; i<8 ; i++){ //Ordonnée
            for(int j=0; j<8 ; j++){ // Abscisse
                for(Piece p : listPiece){
                    if(p.position.getPosX() == j && p.position.getPosY() == i){
                        if(p.getCouleur() == Piece.couleur1) {
                            matrice[i][j] = Character.toString((p.getSymbole())).toUpperCase();
                        }
                        else{
                            matrice[i][j] = Character.toString(p.getSymbole()).toLowerCase();
                        }
                    }
                }
            }
        }

        return matrice;
    }
    public void afficher(){

        String[][] matrice = construireMatrice();
        int abscisseMax = matrice.length;
        int ordonneeMax = matrice[0].length;

        String bordure = "---+---+---+---+---+---+---+---+---+";

        System.out.println(bordure);
        int idc = 8;
        for(int i = 0; i<abscisseMax;i++){
            System.out.print(" "+idc+" |");
            for(int j = 0 ; j<ordonneeMax ;j++){
                System.out.print(" "+matrice[i][j]+" |");
            }
            System.out.println("\n"+bordure);
            idc--;
        }
        System.out.println("   | A | B | C | D | E | F | G | H |");

    }

    public void sauvegarde(){

        ObjectOutputStream objectOutputStream;

        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("echiquier.txt"))));
            objectOutputStream.writeObject(listPiece);
            objectOutputStream.flush();
            objectOutputStream.close() ;

        } catch (IOException e) { e.printStackTrace () ; }

        System.out.println("La sauvegarde a bien été effectuée");
    }

    public List<Piece> lireSauvegarde(){

        ObjectInputStream objectInputStream;
        List<Piece> echiquierRestaurer = new ArrayList<>();

        try{
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("formes.txt"))));

            echiquierRestaurer = (List<Piece>)objectInputStream.readObject();

            System.out.println("Restaure bien effectué");
            objectInputStream.close();
        }
        catch (IOException | ClassNotFoundException e)
        { e.printStackTrace () ; }

        return echiquierRestaurer;

    }

    public void initialiserEchiquier(){

        for(int i=0;i<8;i++){
            ajouterPiece(new Pion(Piece.couleur1,i,1));
            ajouterPiece(new Pion(Piece.couleur2,i,6));
            switch (i){
                case 0:
                case 7: ajouterPiece(new Tour(Piece.couleur1,i,0)); ajouterPiece(new Tour(Piece.couleur2,i,7)); break;
                case 2:
                case 5: ajouterPiece(new Fou(Piece.couleur1, i, 0));ajouterPiece(new Fou(Piece.couleur2, i, 7)); break;
                case 1:
                case 6: ajouterPiece(new Cavalier(Piece.couleur1, i, 0)); ajouterPiece(new Cavalier(Piece.couleur2, i, 7)); break;
                case 3: ajouterPiece(new Roi(Piece.couleur1,i,0)); ajouterPiece(new Dame(Piece.couleur2, i, 7)); break;
                case 4: ajouterPiece(new Dame(Piece.couleur1,i,0)); ajouterPiece(new Roi(Piece.couleur2,i,7)); break;
            }
        }
    }

    public List<Piece> getListPiece() {
        return listPiece;
    }

    public Position saisiPosition(){

        Position positionsaisi = null;

        String position ;

        boolean check = false;

        do{
            System.out.println("Saisir la position sous le forme : A2 ou a2");
            position = scan.nextLine();

            if(position.length() != 2){
                System.out.println("Valeure saisie incorrect.");
            }

            else if(position.length() == 2){
                int x = Position.convertiX(position.charAt(0));
                int y = -1;
                    try{
                        y = Integer.parseInt(String.valueOf(position.charAt(1)));
                    }catch (NumberFormatException nfe){
                        System.out.println("Valeure saisie pour la ligne incorrecte");
                    }
                y = Position.convertiY(y);

                if(x != -1 && y != -1 ){
                    positionsaisi = new Position(x,y);
                    check = true;
                }
            }
        }while(!check);

        return positionsaisi;

    }
}




