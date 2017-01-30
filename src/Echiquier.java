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
                matrice[i][j] = " ";
            }
        }

        for(int i =0 ; i<8 ; i++){ //Ordonnée
            for(int j=0; j<8 ; j++){ // Abscisse
                for(Piece p : listPiece){
                    if(p.position.getPosX() == j && p.position.getPosY() == i){
                        if(p.getCouleur() == 'b') {
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

        String bordure ="------------------------------------";


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
        Roi roiBlanc = new Roi('b', 3,0);
        Roi roiNoir = new Roi('n', 4,7);
        Dame dameBlanche = new Dame('b', 4,0);
        Dame dameNoir = new Dame('n', 3,7);
        Cavalier cavalierBlanc = new Cavalier('b', 2,0);
        Cavalier cavalier2Blanc = new Cavalier('b', 5,0);


        for(int i=0 ; i<8;i++){
            ajouterPiece(new Pion('b', i,1));
            ajouterPiece(new Pion('n', i, 6));
        }

        ajouterPiece(new Cavalier('b', 2,0));
        ajouterPiece(new Cavalier('b',5,0));
        ajouterPiece(new Cavalier('n',2,6));
        ajouterPiece(new Cavalier('n',5,6));

        for(int i=0; i<8;i++){ // Lignes
            if(i==0 || i==7){
                for(int j=0;j<8;j++){ // Colonnes
                    char couleur;
                    if(i==0){
                        couleur ='b';
                    }
                    else couleur = 'n';
                    switch (j){ // ordonnée
                        case 0 :
                        case 7 : ajouterPiece(new Tour(couleur, j,i )); break;
                        case 1 :
                        case 6 :ajouterPiece(new Fou(couleur, j,i)); break;
                        case 2:
                        case 5: ajouterPiece(new Cavalier(couleur, j,i)); break;

                    }
                }
            }


        }



        ajouterPiece(roiBlanc);
        ajouterPiece(roiNoir);
        ajouterPiece(dameBlanche);
        ajouterPiece(dameNoir);
    }

}




