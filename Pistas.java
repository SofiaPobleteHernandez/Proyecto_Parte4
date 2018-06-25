import java.lang.reflect.Array;

public class Pistas {
    int posicion_x_pista;
    int longitud_pista;
    int ancho_pista;
    int posicion_y_pista;

    public Pistas(){

    }

    public Pistas(int posicion_x_pista, int longitud_pista, int ancho_pista, int posicion_y_pista){
        this.posicion_x_pista=posicion_x_pista;
        this.longitud_pista=longitud_pista;
        this.ancho_pista=ancho_pista;
        this.posicion_y_pista=posicion_y_pista;
    }

    public int getLongitud_pista() {
        return longitud_pista;
    }

    public int getPosicion_x_pista() {
        return posicion_x_pista;
    }

    public int getAncho_pista(){
        return ancho_pista;
    }

    public int getPosicion_y_pista() {
        return posicion_y_pista;
    }

    public int setLongitud_pista(int longitud_pista){
        this.longitud_pista=longitud_pista;
        return this.longitud_pista;
    }

    public int setPosicion_x_pista(int posicion_x_pista){
        this.posicion_x_pista=posicion_x_pista;
        return this.posicion_x_pista;
    }

    public int setAncho_pista(int ancho_pista){
        this.ancho_pista=ancho_pista;
        return this.ancho_pista;
    }

    public int setPosicion_y_pista(int posicion_y_pista){
        this.posicion_y_pista=posicion_y_pista;
        return this.posicion_y_pista;
    }

}
