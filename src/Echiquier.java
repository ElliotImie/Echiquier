import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
public class Echiquier {

    private static Echiquier echiquier;

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
                matrice[i][j] = "  ";
            }
        }

        for(int i =0 ; i<8 ; i++){ //Ordonnée
            for(int j=0; j<8 ; j++){ // Abscisse
                for(Piece p : listPiece){
                    if(p.position.getPosX() == j && p.position.getPosY() == i){
                        matrice[i][j] = Character.toString(p.getSymbole()) + p.getCouleur();
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

        String bordure ="--------------------------------------------";

        System.out.println("   |  A |  B |  C |  D |  E |  F |  G |  H |");
        System.out.println(bordure);

        for(int i = 0; i<abscisseMax;i++){
            System.out.print(" "+i+" |");
            for(int j = 0 ; j<ordonneeMax ;j++){
                System.out.print(" "+matrice[i][j]+" |");
            }
            System.out.println("\n"+bordure);
        }

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

}




