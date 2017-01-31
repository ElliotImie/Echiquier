import javax.swing.text.AttributeSet;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;



/**
 * Created by louveau.cdi04 on 27/01/2017.
 */


public class Echiquier {

    private static char couleur1;
    private static char couleur2;

    private static byte valeureRoi;
    private static byte valeureDame;
    private static byte valeureCavalier;
    private static byte valeureFou;
    private static byte valeureTour;
    private static byte valeurePion;

    private static char symboleRoi;
    private static char symboleDame;
    private static char symboleCavalier;
    private static char symboleFou;
    private static char symboleTour;
    private static char symbolePion;

// --> Créer un fichier contenant tous les paramètres

    private static Echiquier echiquier;
    public static Scanner scan = new Scanner(System.in);


    private static List<Piece> listPiece;

    // Création de la liste de pièce + initialisation de toutes les valeures par défaut.
    private Echiquier(){
        listPiece = new ArrayList<Piece>();
        couleur1 = 'b';
        couleur2 ='n';
        valeureRoi = 20;
        valeureDame = 13;
        valeureCavalier = 3;
        valeureFou = 3;
        valeureTour = 3;
        valeurePion = 1;
        symboleRoi = 'R';
        symboleDame = 'D';
        symboleCavalier = 'C';
        symboleFou = 'F';
        symboleTour = 'T';
        symbolePion = 'P';
    }

    public static Echiquier getEchiquier(){
        if(echiquier == null){
            echiquier = new Echiquier();
        }
        return echiquier;
    }

    //region getter setter

    public static List<Piece> getListPiece() {
        return listPiece;
    }

    public static char getCouleur1() {
        return couleur1;
    }

    public static void setCouleur1(char couleur1) {
        Echiquier.couleur1 = couleur1;
    }

    public static char getCouleur2() {
        return couleur2;
    }

    public static void setCouleur2(char couleur2) {
        Echiquier.couleur2 = couleur2;
    }

    public static byte getValeureRoi() {
        return valeureRoi;
    }

    public static void setValeureRoi(byte valeureRoi) {
        Echiquier.valeureRoi = valeureRoi;
    }

    public static byte getValeureDame() {
        return valeureDame;
    }

    public static void setValeureDame(byte valeureDame) {
        Echiquier.valeureDame = valeureDame;
    }

    public static byte getValeureCavalier() {
        return valeureCavalier;
    }

    public static void setValeureCavalier(byte valeureCavalier) {
        Echiquier.valeureCavalier = valeureCavalier;
    }

    public static byte getValeureFou() {
        return valeureFou;
    }

    public static void setValeureFou(byte valeureFou) {
        Echiquier.valeureFou = valeureFou;
    }

    public static byte getValeureTour() {
        return valeureTour;
    }

    public static void setValeureTour(byte valeureTour) {
        Echiquier.valeureTour = valeureTour;
    }

    public static byte getValeurePion() {
        return valeurePion;
    }

    public static void setValeurePion(byte valeurePion) {
        Echiquier.valeurePion = valeurePion;
    }

    public static char getSymboleRoi() {
        return symboleRoi;
    }

    public static void setSymboleRoi(char symboleRoi) {
        Echiquier.symboleRoi = symboleRoi;
    }

    public static char getSymboleDame() {
        return symboleDame;
    }

    public static void setSymboleDame(char symboleDame) {
        Echiquier.symboleDame = symboleDame;
    }

    public static char getSymboleCavalier() {
        return symboleCavalier;
    }

    public static void setSymboleCavalier(char symboleCavalier) {
        Echiquier.symboleCavalier = symboleCavalier;
    }

    public static char getSymboleFou() {
        return symboleFou;
    }

    public static void setSymboleFou(char symboleFou) {
        Echiquier.symboleFou = symboleFou;
    }

    public static char getSymboleTour() {
        return symboleTour;
    }

    public static void setSymboleTour(char symboleTour) {
        Echiquier.symboleTour = symboleTour;
    }

    public static char getSymbolePion() {
        return symbolePion;
    }

    public static void setSymbolePion(char symbolePion) {
        Echiquier.symbolePion = symbolePion;
    }

    // endregion

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
                        if(p.getCouleur() == getCouleur1()) {
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
        System.out.println(bordure);
        System.out.println("\n");

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
            ajouterPiece(new Pion(getCouleur1(),i,1));
            ajouterPiece(new Pion(getCouleur2(),i,6));
            switch (i){
                case 0:
                case 7: ajouterPiece(new Tour(getCouleur1(),i,0)); ajouterPiece(new Tour(getCouleur2(),i,7)); break;
                case 2:
                case 5: ajouterPiece(new Fou(getCouleur1(), i, 0));ajouterPiece(new Fou(getCouleur2(), i, 7)); break;
                case 1:
                case 6: ajouterPiece(new Cavalier(getCouleur1(), i, 0)); ajouterPiece(new Cavalier(getCouleur2(), i, 7)); break;
                case 3: ajouterPiece(new Roi(getCouleur1(),i,0)); ajouterPiece(new Dame(getCouleur2(), i, 7)); break;
                case 4: ajouterPiece(new Dame(getCouleur1(),i,0)); ajouterPiece(new Roi(getCouleur2(),i,7)); break;
            }
        }
    }

    public void modifCouleur(char couleurAvant, char couleurApres){
        for(Piece p : listPiece){
            if(p.getCouleur() == couleurAvant){
                p.setCouleur(couleurApres);
            }
        }
    }

    public void modifValeure(String nomPiece, byte valeure){
        for(Piece p : listPiece){
            if(p.getClass().getCanonicalName() == nomPiece){
                p.setValeure(valeure);
            }
        }
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

    public void sauvegarderParametre(){

        List<Character> tabSymbole = new ArrayList<>();

        tabSymbole.add(0,getSymboleRoi());
        tabSymbole.add(1,getSymboleDame());
        tabSymbole.add(2,getSymboleCavalier());
        tabSymbole.add(3,getSymboleFou());
        tabSymbole.add(4,getSymboleTour());
        tabSymbole.add(5,getSymbolePion());

        List<Byte> tabValeure = new ArrayList<>();

        tabValeure.add(0,getValeureRoi());
        tabValeure.add(1,getValeureDame());
        tabValeure.add(2,getValeureCavalier());
        tabValeure.add(3,getValeureFou());
        tabValeure.add(4,getValeureTour());
        tabValeure.add(5,getValeurePion());

        ObjectOutputStream objectOutputStream;

        try{
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("parametrePerso.txt"))));
            objectOutputStream.writeObject(tabSymbole);
            objectOutputStream.flush();
            objectOutputStream.writeObject(tabValeure);
            objectOutputStream.flush();
            objectOutputStream.close();
        }catch (IOException e){e.printStackTrace();}

        System.out.println("Sauvegarde effectué");
    }

    public void lireParametre(){
        ObjectInputStream objectInputStream;

        List<Character> listSymbole = new ArrayList<>();
        List<Byte> listValeure = new ArrayList<>();

        try{
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("parametrePerso.txt"))));
            listSymbole = (List<Character>)objectInputStream.readObject();
            listValeure = (List<Byte>)objectInputStream.readObject();

            System.out.println("Restaure bien effectué");
            objectInputStream.close();
        }catch (IOException | ClassNotFoundException e ) { e.printStackTrace();}

        for(char c : listSymbole) {
            System.out.println(c);
        }

        for(byte b : listValeure){
            System.out.println(b);
        }
    }

}


