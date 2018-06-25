public class Nariz {

    private String posicion = "extendida";
    private String tipo = "F-14 Tomcat";
    private String orden = "1";
    private String state = "1";
    private double nivel_de_resistencia=20;

    public Nariz(){

    }

    public Nariz(String posicion, String tipo, String orden, String state, int nivel_de_resistencia){
        this.orden=orden;
        this.tipo=tipo;
        this.posicion=posicion;
        this.state=state;
        this.nivel_de_resistencia=nivel_de_resistencia;
    }

    public void setState(String state){
        this.state=state;
    }

    public void setOrden(String orden) {

        this.orden = orden;

        if((!orden.equalsIgnoreCase("1")) && (!orden.equalsIgnoreCase("2")) && (!orden.equalsIgnoreCase("3"))){
            this.orden=state;
        }

        if ((orden.equalsIgnoreCase("1")) || (orden.equalsIgnoreCase("2"))) {
            this.posicion = "extendida";
        }

        if (orden.equalsIgnoreCase("3")) {
            this.posicion = "en el pecho";
        }

    }

    public String getOrden() {

        return this.orden;

    }

    public String getPosicion() {

        return this.posicion;

    }

    public String getTipo() {

        return this.tipo;
    }

    public double getNivel_de_resistencia() {
        return this.nivel_de_resistencia;
    }

    public double setNivel_de_resistencia(double resta){
        this.nivel_de_resistencia = nivel_de_resistencia-resta;
        return this.nivel_de_resistencia;
    }
}