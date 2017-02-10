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


    public static Scanner scan = new Scanner(System.in);

    private static List<Piece> listPiece;
    private List<String> listJoueur;


    // region ----------- CONSTRUCTEUR Singleton
    private static Echiquier echiquier;
    // Création de la liste de pièce + initialisation de toutes les valeures par défaut.
    private Echiquier(){
        listPiece = new ArrayList<Piece>();
        listJoueur = new ArrayList<String>();
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

    //endregion

    //region ----------- Getter setter

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

    //region ----------- Méthodes PIECES ( Ajout, retrait, get )

    public void ajouterPiece(Piece piece){
        listPiece.add(piece);
    }
    // Définir une autre methode ajouterPiece(Piece piece, Position position) dans le cas du pion qui fait réintégrer une piece

    public static void supprimerPiece(Piece piece) {
        int nbPiece = listPiece.size();
        for(int i =0 ; i<nbPiece ; i++){
            if(listPiece.get(i).getPosition().equals(piece.getPosition())){
                listPiece.remove(i);
                System.out.println("Piece supprimé !");
                break;
            }
        }
    }

    public static Piece getPiece(Position position){

        for(Piece p : listPiece){
            if(p.getPosition().equals(position)){
                return p;
            }
        }
        return null;
    }


    //endregion

    //region ----------- Méthode PARAMETRAGES JEU + Sauvegarde paramétrages( ajouterJoueur, getPoints, modif couleurCouleur, modifValeur, modifSymbole

    public void ajouterJoueur(int idc, String joueur){
        listJoueur.add(idc,joueur);
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

    public void modifCouleur(char couleurAvant, char couleurApres, int equipe){

        for(Piece p : listPiece){
            if(p.getCouleur() == couleurAvant){
                p.setCouleur(couleurApres);
            }
        }
        // Modifie les valeure de Echiquier.couleur1/2 pour pouvoir sauvegarder
        switch (equipe){
            case 1 : Echiquier.setCouleur1(couleurApres);
                break;
            case 2 : Echiquier.setCouleur2(couleurApres);
                break;
            default:
                System.out.println("Modification de couleur impossible");
        }
    }

    public void modifValeure(String nomPiece, byte valeure){
        for(Piece p : listPiece){
            if(p.getClass().getCanonicalName() == nomPiece){
                p.setValeure(valeure);
            }
        }
    }

    public void modifSymbole(String nomPiece, char symbole){

        // A D2FINIR ( Penser a redéfinir setSymbole en même temps;
    }

    public void sauvegarderParametre(){


        List<Character> tabCouleur = new ArrayList<>();

        tabCouleur.add(0,getCouleur1());
        tabCouleur.add(1,getCouleur2());

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
            objectOutputStream.writeObject(tabCouleur);
            objectOutputStream.flush();
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
        List<Character> listCouleur = new ArrayList<>();
        List<Byte> listValeure = new ArrayList<>();

        try{
            objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("parametrePerso.txt"))));
            listSymbole = (List<Character>)objectInputStream.readObject();
            listCouleur = (List<Character>)objectInputStream.readObject();
            listValeure = (List<Byte>)objectInputStream.readObject();
            System.out.println("Restaure bien effectué");
            objectInputStream.close();
        }catch (IOException | ClassNotFoundException e ) { e.printStackTrace();}


        /* ----- Affiche / Vérification
        for(char c : listCouleur){
            System.out.println(c);
        }

        for(char c : listSymbole) {
            System.out.println(c);
        }

        for(byte b : listValeure){
            System.out.println(b);
        }*/
    }

    //endregion

    //region ----------- Méthode INITIALISATION / AFFICHAGES + Sauvegarde echiquier

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

    public void initialiserEchiquier(){

        for(int i=0;i<8;i++){
            ajouterPiece(new Pion(getCouleur1(), new Position(i,1)));
            ajouterPiece(new Pion(getCouleur2(),new Position(i,6)));
            switch (i){
                case 0:
                case 7: ajouterPiece(new Tour(getCouleur1(),new Position(i,0))); ajouterPiece(new Tour(getCouleur2(),new Position(i,7))); break;
                case 2:
                case 5: ajouterPiece(new Fou(getCouleur1(), new Position(i,0) ));ajouterPiece(new Fou(getCouleur2(), new Position(i,7))); break;
                case 1:
                case 6: ajouterPiece(new Cavalier(getCouleur1(), new Position(i,0))); ajouterPiece(new Cavalier(getCouleur2(), new Position(i,7))); break;
                case 3: ajouterPiece(new Roi(getCouleur1(),new Position(i,0))); ajouterPiece(new Dame(getCouleur2(), new Position(i,7))); break;
                case 4: ajouterPiece(new Dame(getCouleur1(),new Position(i,0))); ajouterPiece(new Roi(getCouleur2(),new Position(i,7))); break;
            }
        }
    }

    public void afficher(){

        String[][] matrice = construireMatrice();

        int ordonneeMax = matrice.length;
        int abscisseMax = matrice[0].length;
        int idc = 8;

        String bordure = "---+---+---+---+---+---+---+---+---+";

        System.out.println(bordure);
        for(int i = 0; i<ordonneeMax;i++){
            System.out.print(" "+idc+" |");
            for(int j = 0 ; j<abscisseMax ;j++){
                System.out.print(" "+matrice[i][j]+" |");
            }
            System.out.println("\n"+bordure);
            idc--;
        }
        System.out.println("   | A | B | C | D | E | F | G | H |");
        System.out.println(bordure);
        System.out.println("\n");
    }

    public void sauvegarde() {

        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("echiquier.txt"))));
            objectOutputStream.writeObject(listPiece);
            objectOutputStream.flush();
            System.out.println("La sauvegarde a bien été effectuée");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (Exception e) {
            }

        }
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


    // endregion

  /*  public Position saisiPosition(){

        Position positionSaisi = null;
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

                if(x > -1 && x<8 && y > -1 && y <8 ){
                    positionSaisi = new Position(x,y);
                    check = true;
                }
            }
        }while(!check);

        return positionSaisi;
    }*/
















}


