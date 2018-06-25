public class Torreta_v {

    private String armado = "espera";
    private String posicion = "ventral";
    private String estado = "espera";
    private String orden = "1";
    private String state = "1";
    private double nivel_de_resistencia=20;

    public Torreta_v(){

    }

    public Torreta_v(String armado, String posicion, String estado,String orden, String state, int nivel_de_resistencia){
        this.armado=armado;
        this.posicion=posicion;
        this.estado=estado;
        this.orden=orden;
        this.state=state;
        this.nivel_de_resistencia=nivel_de_resistencia;
    }

    public void setState(String state){
        this.state=state;
    }

    public String getOrden() {

        return this.orden;

    }

    public void setOrden(String orden) {

        this.orden = orden;

        if((!orden.equalsIgnoreCase("1")) && (!orden.equalsIgnoreCase("2")) && (!orden.equalsIgnoreCase("3")) && (!orden.equalsIgnoreCase("F"))){
            this.orden=state;
        }

        if((orden.equalsIgnoreCase("1")) || (orden.equalsIgnoreCase("2"))) {
            this.posicion = "ventral";
            this.armado = "armada";
        }

        if(orden.equalsIgnoreCase("3")){
            this.posicion = "cabeza";
            this.armado = "desarmada";
        }

        if(armado.equalsIgnoreCase("armada")) {
            if(orden.equalsIgnoreCase("F")) {
                this.estado = "ataque";
            }
            if(!orden.equalsIgnoreCase("F")){
                this.estado = "espera";
            }
        }
        if(!armado.equalsIgnoreCase("armada")) {
            this.estado = "espera";
        }

    }

    public String getArmado() {

        return this.armado;

    }

    public String getPosicion() {

        return this.posicion;

    }

    public String getEstado(){
        return this.estado;
    }

    public double getNivel_de_resistencia() {
        return nivel_de_resistencia;
    }

    public double setNivel_de_resistencia(double resta){
        this.nivel_de_resistencia=nivel_de_resistencia-resta;
        return this.nivel_de_resistencia;
    }
}
