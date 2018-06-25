import java.util.ArrayList;

public class Organizador {
    String imprime_menu;
    int ejecutar;
    int imprimir_informe;
    int longitud_mundo;
    int ancho_mundo;
    int altura_mundo;
    int numero_de_pistas;
    int imprime_pistas;
    int imprime_enemigos;
    int repara_valkyrie;
    int destruye_pistas;
    int controlador_de_modo;
    String[][] dibuja_suelo;
    ArrayList<Pistas>crea_pistas;
    ArrayList<Enemigo>crea_enemigos;
    Controlador controler;

    public Organizador(){

        controler=new Controlador();
    }

    public Organizador (String imprime_menu, int ejecutar, int imprimir_informe, int longitud_mundo, int ancho_mundo, int altura_mundo, int numero_de_pistas, int imprime_pistas, Controlador controler, int imprime_enemigos, int repara_valkyrie, int destruye_pistas, int controlador_de_modo){
        this.imprime_menu=imprime_menu;
        this.ejecutar=ejecutar;
        this.imprimir_informe=imprimir_informe;
        this.longitud_mundo=longitud_mundo;
        this.ancho_mundo=ancho_mundo;
        this.altura_mundo=altura_mundo;
        this.numero_de_pistas=numero_de_pistas;
        this.imprime_pistas=imprime_pistas;
        this.repara_valkyrie=repara_valkyrie;
        crea_pistas=new ArrayList<Pistas>();
        crea_enemigos=new ArrayList<Enemigo>();
        this.controler=controler;
        this.imprime_enemigos=imprime_enemigos;
        this.destruye_pistas=destruye_pistas;
        this.controlador_de_modo=controlador_de_modo;
    }

    public void Programa() {
        longitud_mundo = controler.Establecer_Longitud();
        ancho_mundo = controler.Establecer_Ancho();
        altura_mundo = controler.Establecer_Altura();
        System.out.println("");
        System.out.println("");
        System.out.println("                    BIENVENIDO AL SIMULADOR DE VF-1");
        System.out.println("                   =================================");
        System.out.println("");
        System.out.println("");
        System.out.println("CARACTERÍSTICAS DEL MUNDO DE TU VF-1 : ");
        System.out.println("");
        System.out.println("-Largo              : " + longitud_mundo);
        System.out.println("-Ancho              : " + ancho_mundo);
        System.out.println("-Alto               : " + altura_mundo);
        crea_pistas = controler.Establecer_Pistas();
        numero_de_pistas=controler.Cantidad_de_Pistas();
        System.out.println("-Numero de pistas   : " + numero_de_pistas);
        imprime_pistas = controler.Imprimir_Pistas();
        crea_enemigos = controler.Crear_Enemigos();
        imprime_enemigos = controler.Mostrar_Enemigos();
        destruye_pistas = controler.Destructor_de_Pistas();
        imprime_pistas = controler.Imprimir_Pistas();
        dibuja_suelo = controler.Dibujar_Suelo();
        imprime_menu = controler.Menu();

        while (!imprime_menu.equalsIgnoreCase("T")) {
            ejecutar = controler.Resolver();
            imprimir_informe = controler.Informe();
            dibuja_suelo = controler.Dibujar_Suelo();
            controlador_de_modo = controler.Actualizar_Modo_de_Valkyrie();
            repara_valkyrie = controler.Reparar_Valkyrie();
            imprime_menu = controler.Menu();
        }
    }
}