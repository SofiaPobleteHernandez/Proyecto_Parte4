import java.util.ArrayList;
public class Valkyrie {

	private int posicion_x = 0;
	private int posicion_y = 0;
	private int posicion_z = 0;
	private int velocidad = 0;
	private String Estado = "1";
	private String orden;
	private Nariz fuselaje;
	private Motor pierna_iz;
	private Motor pierna_der;
	private Brazo brazo_iz;
	private Brazo brazo_der;
	private Torreta_v cabeza;
	private Ala ala_iz;
	private Ala ala_der;
	private Cannon arma_iz;
	private Cannon arma_der;
	ArrayList<String> piezas_valkyrie;
	private double vida_valkyrie;

	public Valkyrie() {
		fuselaje = new Nariz();
		pierna_iz = new Motor();
		pierna_der = new Motor();
		brazo_iz = new Brazo();
		brazo_der = new Brazo();
		cabeza = new Torreta_v();
		ala_iz = new Ala();
		ala_der = new Ala();
		arma_iz = new Cannon();
		arma_der = new Cannon();
        piezas_valkyrie = new ArrayList<String>();
	}

	public Valkyrie(int posicion_x, int posicion_y, int posicion_z,int velocidad, String Estado, String orden) {
		this.posicion_x = posicion_x;
		this.posicion_y = posicion_y;
		this.posicion_z=posicion_z;
		this.velocidad = velocidad;
		this.Estado = Estado;
		this.orden = orden;
	}

	public String setEstado(String Estado) {
		this.Estado = Estado;
		return this.Estado;
	}

	public int setPosicion_x(int posicion_x) {
		this.posicion_x = posicion_x;
		return this.posicion_x;
	}

	public int setPosicion_y(int posicion_y) {
		this.posicion_y = posicion_y;
		return this.posicion_y;
	}

	public int setPosicion_z(int posicion_z){
		this.posicion_z = posicion_z;
		return this.posicion_z;
	}

	public int setVelocidad(int velocidad) {
		this.velocidad = velocidad;
		return this.velocidad;
	}

	public double getVida_valkyrie(){
	    this.vida_valkyrie = fuselaje.getNivel_de_resistencia();
	    return this.vida_valkyrie;
    }

	public void setOrden(String orden){
		this.orden=orden;
		fuselaje.setState(Estado);
		pierna_iz.setState(Estado);
		pierna_der.setState(Estado);
		brazo_iz.setState(Estado);
		brazo_der.setState(Estado);
		cabeza.setState(Estado);
		ala_iz.setstate_valkyria(Estado);
		ala_der.setstate_valkyria(Estado);
		arma_iz.setState(Estado);
		arma_der.setState(Estado);

		fuselaje.setOrden(orden);
		pierna_iz.setOrden(orden);
		pierna_der.setOrden(orden);
		brazo_iz.setOrden(orden);
		brazo_der.setOrden(orden);
		cabeza.setOrden(orden);
		ala_iz.setorden_de_menu(orden);
		ala_der.setorden_de_menu(orden);
		arma_iz.setOrden(orden);
		arma_der.setOrden(orden);

		if(Estado.equalsIgnoreCase("3")){
			if((orden.equalsIgnoreCase("G")) && (velocidad>0)){

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==0)) {
					pierna_der.setPosicion_pierna(1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(1);
					System.out.println("-Ha movido la pierna izquierda");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==1)){
					pierna_der.setPosicion_pierna(1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==-1)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna izquierda");
				}

				if((pierna_der.getPosicion_pierna()==-1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}
			}

			if((orden.equalsIgnoreCase("R")) && (velocidad>0)){

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==0)) {
					pierna_der.setPosicion_pierna(-1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==1)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna izquierda");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna())==-1){
					pierna_der.setPosicion_pierna(-1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==-1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(-1);
					System.out.println("-Ha movido la pierna izquierda");
				}

			}

			if((orden.equalsIgnoreCase("I")) && (velocidad>0)){

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==0)) {
					pierna_der.setPosicion_pierna(1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(1);
					System.out.println("-Ha movido la pierna izquierda");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==1)){
					pierna_der.setPosicion_pierna(1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==-1)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna izquierda");
				}

				if((pierna_der.getPosicion_pierna()==-1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}
			}

			if((orden.equalsIgnoreCase("D")) && (velocidad>0)){

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==0)) {
					pierna_der.setPosicion_pierna(-1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==1)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna izquierda");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna())==-1){
					pierna_der.setPosicion_pierna(-1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==-1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(-1);
					System.out.println("-Ha movido la pierna izquierda");
				}

			}
		}


		if((Estado.equalsIgnoreCase("2")) && (posicion_z==0)){
			if((orden.equalsIgnoreCase("G")) && (velocidad>0)){

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==0)) {
					pierna_der.setPosicion_pierna(1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(1);
					System.out.println("-Ha movido la pierna izquierda");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==1)){
					pierna_der.setPosicion_pierna(1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==-1)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna izquierda");
				}

				if((pierna_der.getPosicion_pierna()==-1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}
			}

			if((orden.equalsIgnoreCase("R")) && (velocidad>0)){

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==0)) {
					pierna_der.setPosicion_pierna(-1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==1)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna izquierda");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna())==-1){
					pierna_der.setPosicion_pierna(-1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==-1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(-1);
					System.out.println("-Ha movido la pierna izquierda");
				}

			}

			if((orden.equalsIgnoreCase("I")) && (velocidad>0)){

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==0)) {
					pierna_der.setPosicion_pierna(1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(1);
					System.out.println("-Ha movido la pierna izquierda");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==1)){
					pierna_der.setPosicion_pierna(1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==-1)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna izquierda");
				}

				if((pierna_der.getPosicion_pierna()==-1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}
			}

			if((orden.equalsIgnoreCase("D")) && (velocidad>0)){

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==0)) {
					pierna_der.setPosicion_pierna(-1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna()==1)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna izquierda");
				}

				if((pierna_der.getPosicion_pierna()==0) && (pierna_iz.getPosicion_pierna())==-1){
					pierna_der.setPosicion_pierna(-1);
					pierna_iz.setPosicion_pierna(0);
					System.out.println("-Ha movido la pierna derecha");
				}

				if((pierna_der.getPosicion_pierna()==-1) && (pierna_iz.getPosicion_pierna()==0)){
					pierna_der.setPosicion_pierna(0);
					pierna_iz.setPosicion_pierna(-1);
					System.out.println("-Ha movido la pierna izquierda");
				}

			}
		}
	}


	 public int getPosicion_x(){
		return this.posicion_x;
	 }

	 public int getPosicion_y(){
		return this.posicion_y;
	 }

	public int getPosicion_z() {
		return this.posicion_z;
	}

	public int getVelocidad(){
		return this.velocidad;
	 }

	 public String getEstado(){
		return this.Estado;
	 }


	 public void Imprimir_Estado_de_Piezas(){
		System.out.println("-El fuselaje es el de un avión          : " + fuselaje.getTipo());
		System.out.println("-Las alas se encuentran                 : " + ala_iz.getplegado_de_las_alas());
		System.out.println("-La posicion de las alas es             : " + ala_iz.getangulo_de_los_alerones());
		System.out.println("-La longitud de los brazos es           : " + brazo_iz.getLongitud());
		System.out.println("-El plegado de los brazos es            : " + brazo_iz.getPlegado());
		System.out.println("-El estado de los brazos es de          : " + brazo_iz.getEstado());
		System.out.println("-Tiene un arma del siguiente tipo       : " + arma_iz.getEstado());
		System.out.println("-El modo en que están los motores es    : " + pierna_der.getEstado());
		System.out.println("-El plegado de los motores es           : " + pierna_der.getPlegado());
		System.out.println("-Los motores están                      : " + pierna_der.getApertura());
		System.out.println("-Los motores tienen una longitud        : " + pierna_der.getLongitud());
		System.out.println("-La posicion de la nariz es             : " + fuselaje.getPosicion());
		System.out.println("-La posicion de la torreta es           : " + cabeza.getPosicion());
		System.out.println("-La torreta se encuentra                : " + cabeza.getArmado());
		System.out.println("-La torreta está en modo de             : " + cabeza.getEstado());

		if(cabeza.getEstado().equalsIgnoreCase("ataque")){
			System.out.println("¡Has Disparado!");
		}
	 }

	 public ArrayList get_Piezas(){

	    if(piezas_valkyrie.size()>0){
	        piezas_valkyrie.clear();
        }

        if(fuselaje.getNivel_de_resistencia()>0) {
            piezas_valkyrie.add("Fuselaje");
        }

        if(ala_iz.getNivel_de_resistencia()>0) {
            piezas_valkyrie.add("Ala_iz");
        }

        if(ala_der.getNivel_de_resistencia()>0) {
            piezas_valkyrie.add("Ala_der");
        }

        if(cabeza.getNivel_de_resistencia()>0) {
            piezas_valkyrie.add("Cabeza");
        }

        if(brazo_iz.getNivel_de_resistencia()>0) {
            piezas_valkyrie.add("Brazo_iz");
        }

        if(brazo_der.getNivel_de_resistencia()>0) {
            piezas_valkyrie.add("Brazo_der");
        }

        if(arma_iz.getNivel_de_resistencia()>0) {
            piezas_valkyrie.add("Arma_iz");
        }

        if(arma_der.getNivel_de_resistencia()>0) {
            piezas_valkyrie.add("Arma_der");
        }

        if (pierna_iz.getNivel_de_resistencia() > 0) {
            piezas_valkyrie.add("Pierna_iz");
        }

	    if(pierna_der.getNivel_de_resistencia()>0) {
            piezas_valkyrie.add("Pierna_der");
        }
        return piezas_valkyrie;
	 }

	public int Recibir_Disparo(String pieza, double tiro){

        if(pieza.equalsIgnoreCase("Fuselaje")){
            fuselaje.setNivel_de_resistencia(tiro);
        }

        if(pieza.equalsIgnoreCase("Ala_iz")){
            ala_iz.setNivel_de_resistencia(tiro);
        }

        if(pieza.equalsIgnoreCase("Ala_der")){
            ala_der.setNivel_de_resistencia(tiro);
        }

        if(pieza.equalsIgnoreCase("Cabeza")){
            cabeza.setNivel_de_resistencia(tiro);
        }

        if(pieza.equalsIgnoreCase("Brazo_iz")){
            cabeza.setNivel_de_resistencia(tiro);
        }

        if(pieza.equalsIgnoreCase("Brazo_der")){
            brazo_der.setNivel_de_resistencia(tiro);
        }

        if(pieza.equalsIgnoreCase("Arma_iz")){
            arma_iz.setNivel_de_resistencia(tiro);
        }

        if(pieza.equalsIgnoreCase("Arma_der")){
            arma_der.setNivel_de_resistencia(tiro);
        }

        if(pieza.equalsIgnoreCase("Pierna_iz")){
            pierna_iz.setNivel_de_resistencia(tiro);
        }

        if(pieza.equalsIgnoreCase("Pierna_der")){
            pierna_der.setNivel_de_resistencia(tiro);
        }

	    return 0;
    }

    int Restaurar_Nivel_de_Resistencia(){

		fuselaje.setNivel_de_resistencia(-(20-fuselaje.getNivel_de_resistencia()));
		ala_iz.setNivel_de_resistencia(-(20-ala_iz.getNivel_de_resistencia()));
		ala_der.setNivel_de_resistencia(-(20-ala_der.getNivel_de_resistencia()));
		cabeza.setNivel_de_resistencia(-(20-cabeza.getNivel_de_resistencia()));
		brazo_iz.setNivel_de_resistencia(-(20-brazo_iz.getNivel_de_resistencia()));
		brazo_der.setNivel_de_resistencia(-(20-brazo_der.getNivel_de_resistencia()));
		arma_iz.setNivel_de_resistencia(-(20-arma_iz.getNivel_de_resistencia()));
		arma_der.setNivel_de_resistencia(-(20-arma_der.getNivel_de_resistencia()));
		pierna_iz.setNivel_de_resistencia(-(20-pierna_iz.getNivel_de_resistencia()));
		pierna_der.setNivel_de_resistencia(-(20-pierna_der.getNivel_de_resistencia()));

		return 0;
	}

}