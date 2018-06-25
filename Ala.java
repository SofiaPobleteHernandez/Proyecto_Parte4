public class Ala {

    private String plegado_de_las_alas = "extendidas";
    private String angulo_de_los_alerones = "base";
    private String orden_de_menu = "1";
    private String state_valkyria = "1";
    private double nivel_de_resistencia=20;

    public Ala(){

    }

    public Ala(String plegado_de_las_alas, String angulo_de_los_alerones, String orden_de_menu, String state_valkyria, int nivel_de_resistencia){
        this.plegado_de_las_alas=plegado_de_las_alas;
        this.angulo_de_los_alerones=angulo_de_los_alerones;
        this.orden_de_menu=orden_de_menu;
        this.state_valkyria=state_valkyria;
        this.nivel_de_resistencia=nivel_de_resistencia;
    }

    public String getorden_de_menu() {

        return orden_de_menu;

    }

    public void setstate_valkyria(String state_valkyria){
        this.state_valkyria=state_valkyria;
    }

    public void setorden_de_menu(String orden_de_menu) {

        this.orden_de_menu = orden_de_menu;

        if((!orden_de_menu.equalsIgnoreCase("1")) && (!orden_de_menu.equalsIgnoreCase("2")) && (!orden_de_menu.equalsIgnoreCase("3")) && (!orden_de_menu.equalsIgnoreCase("H")) && (!orden_de_menu.equalsIgnoreCase("L"))){
            this.orden_de_menu=state_valkyria;
        }

        if((orden_de_menu.equalsIgnoreCase("1")) || (orden_de_menu.equalsIgnoreCase("2"))) {
            this.plegado_de_las_alas = "extendidas";
            this.angulo_de_los_alerones = "base";
        }

        if(orden_de_menu.equalsIgnoreCase("3")){
            this.plegado_de_las_alas = "plegadas en la espalda";
            this.angulo_de_los_alerones = "base";
        }

        if(orden_de_menu.equalsIgnoreCase("H")){
            this.angulo_de_los_alerones="abajo";
        }

        if(orden_de_menu.equalsIgnoreCase("L")){
            this.angulo_de_los_alerones="arriba";
        }
    }

    public double setNivel_de_resistencia(double resta){
        this.nivel_de_resistencia=nivel_de_resistencia-resta;
        return this.nivel_de_resistencia;
    }

    public String getplegado_de_las_alas() {

        return this.plegado_de_las_alas;

    }

    public String getangulo_de_los_alerones() {

        return this.angulo_de_los_alerones;

    }

    public double getNivel_de_resistencia(){
        return this.nivel_de_resistencia;
    }
}