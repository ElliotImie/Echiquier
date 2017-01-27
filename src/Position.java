/**
 * Created by louveau.cdi04 on 27/01/2017.
 */
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


    /*@Override
    public boolean equals(Object o) {
        return super.equals(o);
    }*/
}
