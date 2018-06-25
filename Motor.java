public class Motor {

    private String plegado = "nulo";
    private String estado = "motor";
    private String apertura = "cerrado";
    private String longitud = "total";
    private String orden = "1";
    private int posicion_pierna=0;
    private String state = "1";
    private double nivel_de_resistencia=20;


    public Motor(){

    }

    public Motor(String plegado, String estado, String apertura, String longitud, String orden, int posicion_pierna, String state, int nivel_de_resistencia){
        this.plegado=plegado;
        this.estado=estado;
        this.apertura=apertura;
        this.longitud=longitud;
        this.orden=orden;
        this.posicion_pierna=posicion_pierna;
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

        if((!orden.equalsIgnoreCase("1")) && (!orden.equalsIgnoreCase("2")) && (!orden.equalsIgnoreCase("3"))){
            this.orden=state;
        }

        if(orden.equalsIgnoreCase("1")) {
            this.plegado = "nulo";
            this.longitud = "total";
            this.estado = "motor";
            this.apertura = "cerrado";
        }

        if(orden.equalsIgnoreCase("2")){
            this.longitud = "media";
            this.plegado = "medio";
            this.estado = "piernas 'chiken walker'";
            this.apertura = "abierto";
        }

        if(orden.equalsIgnoreCase("3")) {
            this.plegado = "total";
            this.longitud = "total";
            this.estado = "piernas humanoides";
            this.apertura = "abierto";
        }

    }

    public void setPosicion_pierna(int posicion){
        this.posicion_pierna=posicion;
    }

    public String getPlegado() {

        return this.plegado;

    }

    public String getEstado() {

        return this.estado;

    }

    public String getApertura() {

        return this.apertura;

    }

    public String getLongitud() {

        return this.longitud;

    }

    public int getPosicion_pierna(){
        return this.posicion_pierna;
    }

    public double getNivel_de_resistencia(){
        return this.nivel_de_resistencia;
    }

    public double setNivel_de_resistencia(double resta){
        this.nivel_de_resistencia=nivel_de_resistencia-resta;
        return this.nivel_de_resistencia;
    }
}