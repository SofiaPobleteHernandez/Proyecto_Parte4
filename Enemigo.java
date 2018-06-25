public class Enemigo {
    int numero_de_enemigo;
    int coordenada_x;
    int coordenada_y;
    int coordenada_z;
    double nivel_de_resistencia=30;
    Cannon cannon_1;
    Cannon cannon_2;

    public Enemigo(){

    }

    public Enemigo(int numero_de_enemigo, int coordenada_x, int coordenada_y, int coordenada_z){
        this.numero_de_enemigo=numero_de_enemigo;
        this.coordenada_x=coordenada_x;
        this.coordenada_y=coordenada_y;
        this.coordenada_z=coordenada_z;
        this.nivel_de_resistencia=30;
    }

    public int getNumero_de_enemigo() {
        return this.numero_de_enemigo;
    }

    public int getCoordenada_x() {
        return this.coordenada_x;
    }

    public int getCoordenada_y() {
        return this.coordenada_y;
    }

    public int getCoordenada_z() {
        return this.coordenada_z;
    }

    public double getNivel_de_resistencia() {
        return this.nivel_de_resistencia;
    }

    public int setNumero_de_enemigo(int numero_de_enemigo){
        this.numero_de_enemigo = numero_de_enemigo;
        return this.numero_de_enemigo;
    }

    public int setCoordenada_x(int coordenada_x){
        this.coordenada_x = coordenada_x;
        return this.coordenada_x;
    }

    public int setCoordenada_y(int coordenada_y){
        this.coordenada_y = coordenada_y;
        return this.coordenada_y;
    }

    public int setCoordenada_z(int coordenada_z){
        this.coordenada_z = coordenada_z;
        return this.coordenada_z;
    }

    public double setNivel_de_resistencia(double valor_a_restar){
        this.nivel_de_resistencia = nivel_de_resistencia - valor_a_restar;
        return this.nivel_de_resistencia;
    }
}
