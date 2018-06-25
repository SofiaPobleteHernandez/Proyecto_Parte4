import java.util.Scanner;
import java.util.ArrayList;

public class Controlador {
	private String opcion;
	private int longitud_espacio;
	private int altura_espacio;
	private int ancho_espacio;
	private Valkyrie valkyrie;
	private int numero_de_pistas;
	ArrayList<Pistas> pistas;
	ArrayList<Enemigo> enemigos;
	Pistas[]rep_pistas;
	Enemigo[]rep_enemigos;
	String[][]suelo;

	public Controlador(){
		valkyrie=new Valkyrie();
		pistas=new ArrayList<Pistas>();
		enemigos=new ArrayList<Enemigo>();
	}

	public Controlador(String opcion, int longitud_espacio, int altura_espacio, int ancho_espacio, Valkyrie valkyrie, int numero_de_pistas){
		this.opcion=opcion;
		this.longitud_espacio=longitud_espacio;
		this.altura_espacio=altura_espacio;
		this.ancho_espacio=ancho_espacio;
		this.valkyrie=valkyrie;
		this.numero_de_pistas=numero_de_pistas;
	}

	Scanner leer_opcion = new Scanner(System.in);
	Scanner leer_cx = new Scanner(System.in);
	Scanner leer_cy = new Scanner(System.in);
	Scanner leer_cz = new Scanner(System.in);
	Scanner leer_pelea = new Scanner(System.in);

	int veces=0;

	public int Establecer_Longitud(){
		longitud_espacio = 2 *((int)(Math.random() * 4700)+300);
		return this.longitud_espacio;
	}

	public int Establecer_Altura(){
		altura_espacio = 2 *((int)(Math.random() * 4700)+300);
		return this.altura_espacio;
	}

	public int Establecer_Ancho() {
		ancho_espacio = 2*((int)(Math.random() * 4700) + 300);
		suelo = new String[ancho_espacio+1][longitud_espacio+1];
		return this.ancho_espacio;
	}




	public ArrayList Establecer_Pistas(){

		if(ancho_espacio>longitud_espacio){
		numero_de_pistas = (int) (Math.random() * (ancho_espacio/longitud_espacio))+10;
		}

		if(ancho_espacio<longitud_espacio){
			numero_de_pistas = (int) (Math.random() * (longitud_espacio/ancho_espacio))+10;
		}

		if(ancho_espacio == longitud_espacio){
			numero_de_pistas = (int) (Math.random() * ancho_espacio) +1;
		}

		int x=0;
		int largo=0;
		int y=0;
		int ancho=0;
		int eleccion=0;
		rep_pistas=new Pistas[numero_de_pistas];


		if((longitud_espacio > ancho_espacio) || (longitud_espacio == ancho_espacio)) {
			System.out.println("A");
			for(int z=0; z<numero_de_pistas; z++) {

				rep_pistas[z]= new Pistas();
				if (z == 0) {
					x = (int) (Math.random() * ((longitud_espacio * (z + 1) / numero_de_pistas) - 1)) + 1;
					rep_pistas[z].setPosicion_x_pista(x);
					largo = (int) (Math.random() * ((longitud_espacio / numero_de_pistas) - 1)) + 1;
					rep_pistas[z].setLongitud_pista(largo);
					y = (int) (Math.random() * (ancho_espacio));
					ancho = (int) (Math.random() * ((ancho_espacio-y)-1))+1;
					rep_pistas[z].setAncho_pista(ancho);
					rep_pistas[z].setPosicion_y_pista(y);
				}
				if (z > 0) {
					x = (int) (Math.random() * ((longitud_espacio * (z + 1) / numero_de_pistas) - (rep_pistas[z - 1].getPosicion_x_pista() + rep_pistas[z - 1].getLongitud_pista()))) + (rep_pistas[z - 1].getPosicion_x_pista() + rep_pistas[z - 1].getLongitud_pista());
					while (x > longitud_espacio) {
						x = (int) (Math.random() * ((longitud_espacio * (z + 1) / numero_de_pistas) - rep_pistas[z - 1].getPosicion_x_pista())) + rep_pistas[z - 1].getPosicion_x_pista();
					}
					rep_pistas[z].setPosicion_x_pista(x);
					largo = (int) (Math.random() * ((longitud_espacio - x) / (numero_de_pistas-z)));
					while ((x + largo) > longitud_espacio) {
						largo = (int) (Math.random() * ((longitud_espacio - x) / (numero_de_pistas-z)));
					}
					rep_pistas[z].setLongitud_pista(largo);
					y = (int) (Math.random() * (ancho_espacio));
					ancho = (int) (Math.random() * ((ancho_espacio-y)-1))+1;
					rep_pistas[z].setAncho_pista(ancho);
					rep_pistas[z].setPosicion_y_pista(y);
				}
			}
		}

		if(longitud_espacio<ancho_espacio) {
			System.out.println("B");
			for(int z=0; z<numero_de_pistas; z++) {

				rep_pistas[z] = new Pistas();
				if (z == 0) {
					y = (int) (Math.random() * ((ancho_espacio * (z + 1) / numero_de_pistas) - 1)) + 1;
					rep_pistas[z].setPosicion_y_pista(y);
					ancho = (int) (Math.random() * ((ancho_espacio / numero_de_pistas) - 1)) + 1;
					rep_pistas[z].setAncho_pista(ancho);
					x = (int) (Math.random() * (longitud_espacio));
					largo = (int) (Math.random() * ((longitud_espacio-x)-1))+1;
					rep_pistas[z].setLongitud_pista(largo);
					rep_pistas[z].setPosicion_x_pista(x);
				}
				if (z > 0) {
					y = (int) (Math.random() * ((ancho_espacio * (z + 1) / numero_de_pistas)  - (rep_pistas[z - 1].getPosicion_y_pista() + rep_pistas[z - 1].getAncho_pista()))) + (rep_pistas[z - 1].getPosicion_y_pista() + rep_pistas[z - 1].getAncho_pista());
					while (x > ancho_espacio) {
						y = (int) (Math.random() * ((ancho_espacio * (z + 1) / numero_de_pistas)  - (rep_pistas[z - 1].getPosicion_y_pista()))) + rep_pistas[z - 1].getPosicion_y_pista();
					}
					rep_pistas[z].setPosicion_y_pista(y);
					ancho = (int) (Math.random() * ((ancho_espacio - y) / (numero_de_pistas-z)));
					while ((y + ancho) > ancho_espacio) {
						ancho = (int) (Math.random() * ((ancho_espacio - y) /(numero_de_pistas-z)));
					}
					rep_pistas[z].setAncho_pista(ancho);
					x = (int) (Math.random() * (longitud_espacio));
					largo = (int) (Math.random() * ((longitud_espacio-x)-1))+1;
					rep_pistas[z].setLongitud_pista(largo);
					rep_pistas[z].setPosicion_x_pista(x);
				}
			}
		}


		for(Pistas carril:rep_pistas){
			pistas.add(carril);
		}

		return this.pistas;
	}

	public int Cantidad_de_Pistas(){

		for(int i=0; i<pistas.size(); i++){
			if((pistas.get(i).getAncho_pista()==0) || (pistas.get(i).getLongitud_pista()==0)){
				pistas.remove(i);
			}
		}

		numero_de_pistas = pistas.size();
		return this.numero_de_pistas;
	}

	public int Imprimir_Pistas(){
		System.out.println("");
		System.out.println("PISTAS DISPONIBLES : ");
		for (int i=0; i<numero_de_pistas; i++){
			System.out.println("");
			System.out.println("-Pista " + (i+1) + " : ");
			System.out.println("-Comienza en las coordenadas : (" + pistas.get(i).getPosicion_x_pista() + "," + pistas.get(i).getPosicion_y_pista() + ")");
			System.out.println("-Tiene una longitud de       : " + pistas.get(i).getLongitud_pista());
			System.out.println("-Tiene un ancho de           : " + pistas.get(i).getAncho_pista());
			System.out.println("-----------------------------------------------------------------");
		}
		return 0;
	}

	public ArrayList Crear_Enemigos(){
		int numero_de_enemigos=0;
		int coincidencia;
		int area;
		float proporcion_de_enemigos;
		int coordenada_x=0;
		int coordenada_y=0;
		int coordenada_z=0;



		area = longitud_espacio*ancho_espacio;
		proporcion_de_enemigos = area/altura_espacio;

		numero_de_enemigos = (int)(proporcion_de_enemigos);

		System.out.println(numero_de_enemigos);

		rep_enemigos = new Enemigo[numero_de_enemigos];

		for(int e=0; e<numero_de_enemigos; e++){

		    rep_enemigos[e] = new Enemigo();

			coordenada_x = (int)(Math.random() * longitud_espacio);
			coordenada_y = (int)(Math.random() * ancho_espacio);
			coordenada_z = (int)(Math.random() * altura_espacio);


			rep_enemigos[e].setNumero_de_enemigo(e+1);
            rep_enemigos[e].setCoordenada_x(coordenada_x);
			rep_enemigos[e].setCoordenada_y(coordenada_y);
			rep_enemigos[e].setCoordenada_z(coordenada_z);

			enemigos.add(rep_enemigos[e]);
		}
		return this.enemigos;
	}

	public int Mostrar_Enemigos(){

		System.out.println("LISTADO DE ENEMIGOS : ");
		System.out.println("");
		for(int i=0; i<enemigos.size(); i++){
			System.out.println("-Enemigo N°" + enemigos.get(i).getNumero_de_enemigo() + " : (" + enemigos.get(i).getCoordenada_x() + " , " + enemigos.get(i).getCoordenada_y() + " , " + enemigos.get(i).getCoordenada_z() + ").");
		}
		System.out.println("");
		System.out.println("Enemigos restantes : " + enemigos.size());
        System.out.println("");
		return 0;
	}

	public String[][] Dibujar_Suelo(){


        int altura_valkyrie = valkyrie.getPosicion_z();
        int x_valkyrie = valkyrie.getPosicion_x();
        int y_valkyrie = valkyrie.getPosicion_y();

        for(int i=0; i<(ancho_espacio+1); i++){
        	for(int j=0; j<(longitud_espacio+1); j++){

        		if((i==y_valkyrie) && (j==x_valkyrie)){
        			suelo[i][j]="  X  ";
				}
				else {
					suelo[i][j] = "     ";
				}
			}
		}

        for(Enemigo enemigo: enemigos){
        	if(enemigo.getCoordenada_z() == altura_valkyrie){
        		suelo[enemigo.getCoordenada_y()][enemigo.getCoordenada_x()] = "  E  ";
			}
		}



        if(((x_valkyrie-4)>-1) && ((x_valkyrie+4)<(longitud_espacio+1))){
        	if(((y_valkyrie-4)>-1) && ((y_valkyrie+4)<(ancho_espacio+1))) {


				System.out.print("     |");
				for (int x = (x_valkyrie - 4); x < (x_valkyrie + 5); x++) {
					if(x>999) {
						System.out.print(" " + x + "|");
					}
					if((x>99) && (x<1000)) {
						System.out.print(" " + x + " |");
					}
					if((x>9) && (x<100)) {
						System.out.print("  " + x + " |");
					}
					if(x<10) {
						System.out.print("  " + x + "  |");
					}
				}

				System.out.println("");

				for (int y = (y_valkyrie + 4); y > (y_valkyrie - 5); y--) {
					if(y>999){
						System.out.print(" " + y + "|");
					}
					if((y>99) && (y<1000)){
						System.out.print(" " + y + " |");
					}
					if((y>9) && (y<100)){
						System.out.print("  " + y + " |");
					}
					if(y<10){
						System.out.print("  " + y + "  |");
					}

					for (int x = (x_valkyrie - 4); x < (x_valkyrie + 5); x++) {
						System.out.print(suelo[y][x] + "|");
					}
					System.out.println("");
				}
			}

			if((y_valkyrie-4)<0)  {


				System.out.print("     |");
				for (int x = (x_valkyrie - 4); x < (x_valkyrie + 5); x++) {
					if(x>999) {
						System.out.print(" " + x + "|");
					}
					if((x>99) && (x<1000)) {
						System.out.print(" " + x + " |");
					}
					if((x>9) && (x<100)) {
						System.out.print("  " + x + " |");
					}
					if(x<10) {
						System.out.print("  " + x + "  |");
					}
				}

				System.out.println("");

				for (int y = 9; y > -1; y--) {

					System.out.print("  " + y + "  |");

					for (int x = (x_valkyrie - 4); x < (x_valkyrie + 5); x++) {
						System.out.print(suelo[y][x] + "|");
					}
					System.out.println("");
				}
			}

			if ((y_valkyrie+4)>ancho_espacio) {


				System.out.print("     |");
				for (int x = (x_valkyrie - 4); x < (x_valkyrie + 5); x++) {
					if(x>999) {
						System.out.print(" " + x + "|");
					}
					if((x>99) && (x<1000)) {
						System.out.print(" " + x + " |");
					}
					if((x>9) && (x<100)) {
						System.out.print("  " + x + " |");
					}
					if(x<10) {
						System.out.print("  " + x + "  |");
					}
				}

				System.out.println("");

				for (int y = ancho_espacio; y > (ancho_espacio - 10); y--) {
					if(y==10000){
						System.out.print(y + "|");
					}
					if((y>999) && (y<10000)){
						System.out.print(" " + y + "|");
					}
					if((y>99) && (y<1000)){
						System.out.print(" " + y + " |");
					}
					if((y>9) && (y<100)){
						System.out.print("  " + y + " |");
					}
					if(y<10){
						System.out.print("  " + y + "  |");
					}

					for (int x = (x_valkyrie - 4); x < (x_valkyrie + 5); x++) {
						System.out.print(suelo[y][x] + "|");
					}
					System.out.println("");
				}
			}
		}

		if((x_valkyrie-4)<0) {
			if(((y_valkyrie-4)>-1) && ((y_valkyrie+4)<(ancho_espacio+1))) {

				System.out.print("     |");
				for (int x = 0; x < 10; x++) {

					System.out.print("  " + x + "  |");

				}

				System.out.println("");

				for (int y = (y_valkyrie + 4); y > (y_valkyrie - 5); y--) {
					if(y>999){
						System.out.print(" " + y + "|");
					}
					if((y>99) && (y<1000)){
						System.out.print(" " + y + " |");
					}
					if((y>9) && (y<100)){
						System.out.print("  " + y + " |");
					}
					if(y<10){
						System.out.print("  " + y + "  |");
					}

					for (int x = 0; x < 10; x++) {
						System.out.print(suelo[y][x] + "|");
					}
					System.out.println("");
				}
			}

			if((y_valkyrie-4)<0)  {


				System.out.print("     |");
				for (int x = 0; x < 10; x++) {

					System.out.print("  " + x + "  |");

				}

				System.out.println("");

				for (int y = 9; y > -1; y--) {

					System.out.print("  " + y + "  |");

					for (int x = 0; x < 10; x++) {
						System.out.print(suelo[y][x] + "|");
					}
					System.out.println("");
				}
			}

			if ((y_valkyrie+4)>ancho_espacio) {


				System.out.print("     |");
				for (int x = 0; x < 10; x++) {

					System.out.print("  " + x + "  |");

				}

				System.out.println("");

				for (int y = ancho_espacio; y > (ancho_espacio - 10); y--) {
					if(y==10000){
						System.out.print(y + "|");
					}
					if((y>999) && (y<10000)){
						System.out.print(" " + y + "|");
					}
					if((y>99) && (y<1000)){
						System.out.print(" " + y + " |");
					}
					if((y>9) && (y<100)){
						System.out.print("  " + y + " |");
					}
					if(y<10){
						System.out.print("  " + y + "  |");
					}

					for (int x = 0; x < 10; x++) {
						System.out.print(suelo[y][x] + "|");
					}
					System.out.println("");
				}
			}
		}

		if((x_valkyrie+4)>(longitud_espacio)){
			if(((y_valkyrie-4)>-1) && ((y_valkyrie+4)<(ancho_espacio+1))) {


				System.out.print("     |");
				for (int x = (longitud_espacio-9); x < longitud_espacio; x++) {
					if(x==10000){
						System.out.print(x + "|");
					}
					if((x>999) && (x<10000)) {
						System.out.print(" " + x + "|");
					}
					if((x>99) && (x<1000)) {
						System.out.print(" " + x + " |");
					}
					if((x>9) && (x<100)) {
						System.out.print("  " + x + " |");
					}
					if(x<10) {
						System.out.print("  " + x + "  |");
					}
				}

				System.out.println("");

				for (int y = (y_valkyrie + 4); y > (y_valkyrie - 5); y--) {
					if(y>999){
						System.out.print(" " + y + "|");
					}
					if((y>99) && (y<1000)){
						System.out.print(" " + y + " |");
					}
					if((y>9) && (y<100)){
						System.out.print("  " + y + " |");
					}
					if(y<10){
						System.out.print("  " + y + "  |");
					}

					for (int x = (longitud_espacio-9); x < longitud_espacio; x++) {
						System.out.print(suelo[y][x] + "|");
					}
					System.out.println("");
				}
			}

			if((y_valkyrie-4)<0)  {


				System.out.print("     |");
				for (int x = (longitud_espacio-9); x < longitud_espacio; x++) {
					if(x==10000){
						System.out.print(x + "|");
					}
					if((x>999) && (x<10000)) {
						System.out.print(" " + x + "|");
					}
					if((x>99) && (x<1000)) {
						System.out.print(" " + x + " |");
					}
					if((x>9) && (x<100)) {
						System.out.print("  " + x + " |");
					}
					if(x<10) {
						System.out.print("  " + x + "  |");
					}
				}

				System.out.println("");

				for (int y = 9; y > -1; y--) {

					System.out.print("  " + y + "  |");

					for (int x = (longitud_espacio-9); x < longitud_espacio; x++) {
						System.out.print(suelo[y][x] + "|");
					}
					System.out.println("");
				}
			}

			if ((y_valkyrie+4)>ancho_espacio) {


				System.out.print("     |");
				for (int x = (x_valkyrie - 4); x < (x_valkyrie + 5); x++) {
					if(x==10000){
						System.out.print(x + "|");
					}
					if((x>999) && (x<10000)) {
						System.out.print(" " + x + "|");
					}
					if((x>99) && (x<1000)) {
						System.out.print(" " + x + " |");
					}
					if((x>9) && (x<100)) {
						System.out.print("  " + x + " |");
					}
					if(x<10) {
						System.out.print("  " + x + "  |");
					}
				}

				System.out.println("");

				for (int y = ancho_espacio; y > (ancho_espacio - 10); y--) {
					if(y==10000){
						System.out.print(y + "|");
					}
					if((y>999) && (y<10000)){
						System.out.print(" " + y + "|");
					}
					if((y>99) && (y<1000)){
						System.out.print(" " + y + " |");
					}
					if((y>9) && (y<100)){
						System.out.print("  " + y + " |");
					}
					if(y<10){
						System.out.print("  " + y + "  |");
					}

					for (int x = (longitud_espacio-9); x < longitud_espacio; x++) {
						System.out.print(suelo[y][x] + "|");
					}
					System.out.println("");
				}
			}
		}


		return suelo;
	}

	public int Destructor_de_Pistas(){

		for(Enemigo enemigo : enemigos){
			for(Pistas pista : pistas){
				if((enemigo.getCoordenada_x()>(pista.getPosicion_x_pista()-3)) && (enemigo.getCoordenada_x()<(pista.getPosicion_x_pista()+pista.getLongitud_pista()+3))){
					if((enemigo.getCoordenada_y()>(pista.getPosicion_y_pista()-3)) && (enemigo.getCoordenada_y()<(pista.getPosicion_y_pista()+pista.getAncho_pista()+3))){

						pistas.remove(pista);

					}
				}
			}
		}

		return 0;
	}

	public String Menu(){
		System.out.println("");
		System.out.println("");
		System.out.println("======================================================");
		System.out.println("======================================================");
		System.out.println("Teclas y Su Uso: ");
		System.out.println("-E : Empieza el Juego.");
		System.out.println("-T : Termina el Juego.");
		System.out.println("-H : Aumenta la Altitud de vuelo del VF-1.");
		System.out.println("-L : Disminuye la Altitud de vuelo del VF-1.");
		System.out.println("-Q : Aumenta la Veocidad del VF-1");
		System.out.println("-S : Disminuye la Velocidad del VF-1");
		System.out.println("-R : El VF-1 retrocede en las coordenadas x.");
		System.out.println("-G : El VF-1 avanza en las coordenadas x.");
		System.out.println("-D : El VF-1 retrocede en las coordenadas y");
		System.out.println("-I : El VF-1 avanza en las coordenadas y");
		System.out.println("-F : Comienza una pelea .");
		System.out.println("-1 : Transforma el VF-1 en Modo Fighter.");
		System.out.println("-2 : Transforma el VF-1 en Modo Gerwalk.");
		System.out.println("-3 : Transforma el VF-1 en Modo Battloid");
		System.out.println("");
		System.out.println("-------------------------------------------------------");
		System.out.println("");
		opcion=leer_opcion.next();
		return opcion;
	}

	public int Resolver() {

		if ((opcion.equalsIgnoreCase("E")) && (veces == 0)) {
			System.out.println("¡A jugar! ¡Ya puedes dirigir al VF-1!");
		}

		if (opcion.equalsIgnoreCase("H")) {
			if (!valkyrie.getEstado().equalsIgnoreCase("3")) {
				if ((valkyrie.getPosicion_z() + valkyrie.getVelocidad() < altura_espacio) || (valkyrie.getPosicion_z() + valkyrie.getVelocidad() == altura_espacio)) {

					if (valkyrie.getEstado().equalsIgnoreCase("2")) {
						valkyrie.setPosicion_z(valkyrie.getPosicion_z() + valkyrie.getVelocidad());
						valkyrie.setOrden(opcion);
					}

					if (valkyrie.getEstado().equalsIgnoreCase("1")) {

						if(valkyrie.getPosicion_z()==0) {
							int posicion = 0;
							int tamano = 0;

							for (int i = 0; i < numero_de_pistas; i++) {
								if ((pistas.get(i).getPosicion_x_pista() < valkyrie.getPosicion_x()) || (pistas.get(i).getPosicion_x_pista() == valkyrie.getPosicion_x())) {
									if (((pistas.get(i).getPosicion_x_pista() + pistas.get(i).getLongitud_pista()) > valkyrie.getPosicion_x()) || ((pistas.get(i).getPosicion_x_pista() + pistas.get(i).getLongitud_pista()) == valkyrie.getPosicion_x())) {

										if((pistas.get(i).getPosicion_y_pista() < valkyrie.getPosicion_y()) || (pistas.get(i).getPosicion_y_pista() == valkyrie.getPosicion_y())) {
											if(((pistas.get(i).getPosicion_y_pista() + pistas.get(i).getAncho_pista()) > valkyrie.getPosicion_y()) || ((pistas.get(i).getPosicion_y_pista() + pistas.get(i).getAncho_pista()) == valkyrie.getPosicion_y())) {
												tamano = pistas.get(i).getLongitud_pista();
												posicion = pistas.get(i).getPosicion_x_pista();
											}
										}
									}
								}
							}

							if ((tamano > 99) && (valkyrie.getVelocidad() > 349)) {
								valkyrie.setPosicion_z(valkyrie.getVelocidad());
								valkyrie.setOrden(opcion);
							}
						}

						if(valkyrie.getPosicion_z()>0){
							valkyrie.setPosicion_z(valkyrie.getVelocidad()+valkyrie.getPosicion_z());
							valkyrie.setOrden(opcion);
						}
					}
				}

				if (valkyrie.getPosicion_z() + valkyrie.getVelocidad() > altura_espacio) {
					valkyrie.setPosicion_z(altura_espacio);
					valkyrie.setOrden(opcion);
				}
			}
		}

		if (opcion.equalsIgnoreCase("L")) {
			if (!valkyrie.getEstado().equalsIgnoreCase("3")) {
				if (valkyrie.getPosicion_z() - valkyrie.getVelocidad() > -1) {
					valkyrie.setPosicion_z(valkyrie.getPosicion_z() - valkyrie.getVelocidad());
					valkyrie.setOrden(opcion);
				}
				if (valkyrie.getPosicion_z() - valkyrie.getVelocidad() < 0) {
					valkyrie.setPosicion_z(0);
					valkyrie.setOrden(opcion);
				}
			}
		}

		if (opcion.equalsIgnoreCase("Q")) {
			int incremento=0;
			if (valkyrie.getVelocidad() < 750) {
				incremento=(int)(Math.random()*100)+1;
				while(valkyrie.getVelocidad()+incremento>750){
					incremento=(int)(Math.random()*100)+1;
				}
				valkyrie.setVelocidad(valkyrie.getVelocidad() + incremento);
				valkyrie.setOrden(opcion);
			}
		}

		if (opcion.equalsIgnoreCase("S")) {
			int disminucion=0;
			disminucion=(int)(Math.random()*100)+1;
			while(valkyrie.getVelocidad()-disminucion<0){
				disminucion=(int)(Math.random()*100)+1;
			}
			valkyrie.setVelocidad(valkyrie.getVelocidad()-disminucion);
			valkyrie.setOrden(opcion);
		}

		if (opcion.equalsIgnoreCase("R")) {
			if (valkyrie.getPosicion_x() - valkyrie.getVelocidad() > -1) {
				valkyrie.setPosicion_x(valkyrie.getPosicion_x() - valkyrie.getVelocidad());
				valkyrie.setOrden(opcion);
			}
			if (valkyrie.getPosicion_x() - valkyrie.getVelocidad() < 0) {
				valkyrie.setPosicion_x(0);
				valkyrie.setOrden(opcion);
			}
		}

		if (opcion.equalsIgnoreCase("G")) {
			if (valkyrie.getPosicion_x() + valkyrie.getVelocidad() < longitud_espacio + 1) {
				valkyrie.setPosicion_x(valkyrie.getPosicion_x() + valkyrie.getVelocidad());
				valkyrie.setOrden(opcion);
			}
			if (valkyrie.getPosicion_x() + valkyrie.getVelocidad() > longitud_espacio) {
				valkyrie.setPosicion_x(longitud_espacio);
				valkyrie.setOrden(opcion);
			}
		}

		if(opcion.equalsIgnoreCase("D")){
			if (valkyrie.getPosicion_y() - valkyrie.getVelocidad() > -1) {
				valkyrie.setPosicion_y(valkyrie.getPosicion_y() - valkyrie.getVelocidad());
				valkyrie.setOrden(opcion);
			}
			if (valkyrie.getPosicion_y() - valkyrie.getVelocidad() < 0) {
				valkyrie.setPosicion_y(0);
				valkyrie.setOrden(opcion);
			}
		}

		if(opcion.equalsIgnoreCase("I")){
			if (valkyrie.getPosicion_y() + valkyrie.getVelocidad() < ancho_espacio + 1) {
				valkyrie.setPosicion_y(valkyrie.getPosicion_y() + valkyrie.getVelocidad());
				valkyrie.setOrden(opcion);
			}
			if (valkyrie.getPosicion_y() + valkyrie.getVelocidad() > ancho_espacio) {
				valkyrie.setPosicion_y(ancho_espacio);
				valkyrie.setOrden(opcion);
			}
		}

		if (opcion.equalsIgnoreCase("3")) {

			if (valkyrie.getEstado().equalsIgnoreCase("1")) {
				if (valkyrie.getPosicion_z() < 201) {

					int aciertos_der=0;
					int aciertos_iz=0;

					for (int i = 0; i < valkyrie.get_Piezas().size(); i++) {
						if (valkyrie.get_Piezas().get(i).equals("Pierna_iz")){
							aciertos_iz=1;
						}

						if(valkyrie.get_Piezas().get(i).equals("Pierna_der")){
							aciertos_der=1;
						}
					}

					if((aciertos_der==1) && (aciertos_iz==0)){
						valkyrie.setEstado("3");
						valkyrie.setOrden("3");
					}

				}
			}

			if (valkyrie.getEstado().equalsIgnoreCase("2")) {
				if (valkyrie.getPosicion_z() < 201) {

					int aciertos_der=0;
					int aciertos_iz=0;

					for (int i = 0; i < valkyrie.get_Piezas().size(); i++) {
						if (valkyrie.get_Piezas().get(i).equals("Pierna_iz")){
							aciertos_iz=1;
						}

						if(valkyrie.get_Piezas().get(i).equals("Pierna_der")){
							aciertos_der=1;
						}
					}

					if((aciertos_der==1) && (aciertos_iz==0)){
						valkyrie.setEstado("3");
						valkyrie.setOrden("3");
					}
				}
			}
		}

		if (opcion.equalsIgnoreCase("2")) {

			int aciertos_iz=0;
			int aciertos_der=0;


			for (int i = 0; i < valkyrie.get_Piezas().size(); i++) {
				if (valkyrie.get_Piezas().get(i).equals("Ala_iz")){
					aciertos_iz=1;
				}

				if(valkyrie.get_Piezas().get(i).equals("Ala_der")){
					aciertos_der=1;
				}
			}

			if((aciertos_iz==1) && (aciertos_der==1)){
				aciertos_der=0;
				aciertos_iz=0;

				for (int i = 0; i < valkyrie.get_Piezas().size(); i++) {
					if (valkyrie.get_Piezas().get(i).equals("Pierna_iz")){
						aciertos_iz=1;
					}

					if(valkyrie.get_Piezas().get(i).equals("Pierna_der")){
						aciertos_der=1;
					}
				}

				if((aciertos_der==1) && (aciertos_iz==0)){
					valkyrie.setEstado("2");
					valkyrie.setOrden("2");
				}
			}
		}

		if (opcion.equalsIgnoreCase("1")) {
			if (valkyrie.getEstado().equalsIgnoreCase("2")) {

				if(valkyrie.getPosicion_z()==0) {

					int longitud = 0;

					for (int i = 0; i < numero_de_pistas; i++) {
						if ((pistas.get(i).getPosicion_x_pista() < valkyrie.getPosicion_x()) || (pistas.get(i).getPosicion_x_pista() == valkyrie.getPosicion_x())) {
							if (((pistas.get(i).getPosicion_x_pista() + pistas.get(i).getLongitud_pista()) > valkyrie.getPosicion_x()) || ((pistas.get(i).getPosicion_x_pista() + pistas.get(i).getLongitud_pista()) == valkyrie.getPosicion_x())) {

								if((pistas.get(i).getPosicion_y_pista() < valkyrie.getPosicion_y()) || (pistas.get(i).getPosicion_y_pista() == valkyrie.getPosicion_y())) {
									if(((pistas.get(i).getPosicion_y_pista() + pistas.get(i).getAncho_pista()) > valkyrie.getPosicion_y()) || ((pistas.get(i).getPosicion_y_pista() + pistas.get(i).getAncho_pista()) == valkyrie.getPosicion_y())) {
										longitud = pistas.get(i).getLongitud_pista();
									}
								}
							}
						}
					}

					if ((valkyrie.getPosicion_y() > 0) && (longitud > 99)) {
						valkyrie.setEstado("1");
						valkyrie.setOrden(opcion);
					}
				}

				if(valkyrie.getPosicion_z()>0){
					valkyrie.setEstado("1");
					valkyrie.setOrden(opcion);
				}
			}

			if (valkyrie.getEstado().equalsIgnoreCase("3")) {

				int aciertos_iz=0;
				int aciertos_der=0;


				for (int i = 0; i < valkyrie.get_Piezas().size(); i++) {
					if (valkyrie.get_Piezas().get(i).equals("Ala_iz")){
						aciertos_iz=1;
					}

					if(valkyrie.get_Piezas().get(i).equals("Ala_der")){
						aciertos_der=1;
					}
				}

				if((aciertos_iz==1) && (aciertos_der==1)){
					aciertos_der=0;
					aciertos_iz=0;

					for (int i = 0; i < valkyrie.get_Piezas().size(); i++) {
						if (valkyrie.get_Piezas().get(i).equals("Pierna_iz")){
							aciertos_iz=1;
						}

						if(valkyrie.get_Piezas().get(i).equals("Pierna_der")){
							aciertos_der=1;
						}
					}

					if((aciertos_der==1) && (aciertos_iz==0)){
						valkyrie.setEstado("2");
						valkyrie.setOrden("2");
					}
				}
			}
		}

		if(opcion.equalsIgnoreCase("F")){

			int cx_enemigo;
			int cy_enemigo;
			int cz_enemigo;
			int existencia_enemigo=0;
			int disparo=0;
			double tiro=0;
			double tiro_2=0;
			int num_enemigo=0;
			int destino_disparo=0;
			int arma_der=0;
			int arma_izq=0;
			int brazo_der=0;
			int brazo_izq=0;
			String opcion_pelea = "F";

			System.out.println("\t Ingrese coordenada x del enemigo : ");
			cx_enemigo = leer_cx.nextInt();

			System.out.println("\t Ingrese coordenada y del enemigo : ");
			cy_enemigo = leer_cy.nextInt();

			System.out.println("\t Ingrese coordenada z del enemigo : ");
			cz_enemigo = leer_cz.nextInt();

			for (Enemigo enemigo : enemigos) {
				if ((cx_enemigo == enemigo.coordenada_x) && (cy_enemigo == enemigo.coordenada_y) && (cz_enemigo == enemigo.coordenada_z)) {
					existencia_enemigo = 1;
					num_enemigo++;
					break;
				}
			}

			if (existencia_enemigo == 0) {
				System.out.println("El enemigo de las coordenadas indicadas no existe.");
				opcion_pelea="O";
			}
			if (existencia_enemigo == 1) {
				while ((opcion_pelea.equalsIgnoreCase("F")) && (valkyrie.getVida_valkyrie()>0) && (enemigos.get(num_enemigo).getNivel_de_resistencia() > 0)) {

					System.out.println("OPCIONES DE PELEA : ");
					System.out.println("-F : Continuar pelea.");
					System.out.println("-5 : Abandonar pelea.");

					opcion_pelea = leer_pelea.next();

					if(opcion_pelea.equalsIgnoreCase("5")){
						break;
					}

					for(int i=0; i<valkyrie.get_Piezas().size(); i++){
						if(valkyrie.get_Piezas().get(i).equals("Arma_iz")){
							arma_izq=1;
						}
						if(valkyrie.get_Piezas().get(i).equals("Arma_der")){
							arma_der=1;
						}
						if(valkyrie.get_Piezas().get(i).equals("Brazo_iz")){
							brazo_izq=1;
						}
						if(valkyrie.get_Piezas().get(i).equals("Brazo_der")){
							brazo_der=1;
						}
					}

					if ((cy_enemigo == valkyrie.getPosicion_y()) && (cz_enemigo == valkyrie.getPosicion_z()) && (cx_enemigo != valkyrie.getPosicion_x())) {
						if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) < 5) {

							disparo = (int) (Math.random() * 3) + 1;
							tiro = (int) (Math.random() * 9) + 1;
							tiro_2 = (int) (Math.random() * 9) + 1;

							if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == 1) {
								tiro = tiro + ((Math.random() * (tiro * 0.2)) + (tiro * 0.1));
								tiro_2 = tiro_2 + ((Math.random() * (tiro_2 * 0.2)) + (tiro_2 * 0.1));
							}
							if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == 2) {
								tiro = tiro + (Math.random() * (tiro * 0.1));
								tiro_2 = tiro_2 + (Math.random() * (tiro_2 * 0.1));
							}
							if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == 3) {
								tiro = tiro - (Math.random() * (tiro * 0.2));
								tiro_2 = tiro_2 - (Math.random() * (tiro_2 * 0.2));
							}
							if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == 4) {
								tiro = tiro - ((Math.random() * (tiro * 0.2)) + (tiro * 0.3));
								tiro_2 = tiro_2 - ((Math.random() * (tiro_2 * 0.2)) + (tiro_2 * 0.3));
							}
						}
						if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) > 4) {
							System.out.println("No puedes iniciar una pelea con el enemigo de las coordenadas especificadas.");
							opcion_pelea = "O";
						}
					}

					if ((cx_enemigo == valkyrie.getPosicion_x()) && (cz_enemigo == valkyrie.getPosicion_z()) && (cy_enemigo != valkyrie.getPosicion_y())) {
						if (Math.abs(cy_enemigo - valkyrie.getPosicion_y()) < 5) {


							disparo = (int) (Math.random() * 3) + 1;
							tiro = (int) (Math.random() * 9) + 1;
							tiro_2 = (int) (Math.random() * 9) + 1;

							if (Math.abs(cy_enemigo - valkyrie.getPosicion_y()) == 1) {
								tiro = tiro + ((Math.random() * (tiro * 0.2)) + (tiro * 0.1));
								tiro_2 = tiro_2 + ((Math.random() * (tiro_2 * 0.2)) + (tiro_2 * 0.1));
							}
							if (Math.abs(cy_enemigo - valkyrie.getPosicion_y()) == 2) {
								tiro = tiro + (Math.random() * (tiro * 0.1));
								tiro_2 = tiro_2 + (Math.random() * (tiro_2 * 0.1));
							}
							if (Math.abs(cy_enemigo - valkyrie.getPosicion_y()) == 3) {
								tiro = tiro - (Math.random() * (tiro * 0.2));
								tiro_2 = tiro_2 - (Math.random() * (tiro_2 * 0.2));
							}
							if (Math.abs(cy_enemigo - valkyrie.getPosicion_y()) == 4) {
								tiro = tiro - ((Math.random() * (tiro * 0.2)) + (tiro * 0.3));
								tiro_2 = tiro_2 - ((Math.random() * (tiro_2 * 0.2)) + (tiro_2 * 0.3));
							}
						}
						if (Math.abs(cy_enemigo - valkyrie.getPosicion_y()) > 4) {
							System.out.println("No puedes iniciar una pelea con el enemigo de las coordenadas especificadas");
							opcion_pelea = "O";
						}
					}

					if ((cx_enemigo == valkyrie.getPosicion_x()) && (cy_enemigo == valkyrie.getPosicion_y()) && (cz_enemigo != valkyrie.getPosicion_z())) {
						if (Math.abs(cz_enemigo - valkyrie.getPosicion_z()) < 5) {


							disparo = (int) (Math.random() * 3) + 1;
							tiro = (int) (Math.random() * 9) + 1;
							tiro_2 = (int) (Math.random() * 9) + 1;

							if (Math.abs(cz_enemigo - valkyrie.getPosicion_z()) == 1) {
								tiro = tiro + ((Math.random() * (tiro * 0.2)) + (tiro * 0.1));
								tiro_2 = tiro_2 + ((Math.random() * (tiro_2 * 0.2)) + (tiro_2 * 0.1));
							}
							if (Math.abs(cz_enemigo - valkyrie.getPosicion_z()) == 2) {
								tiro = tiro + (Math.random() * (tiro * 0.1));
								tiro_2 = tiro_2 + (Math.random() * (tiro_2 * 0.1));
							}
							if (Math.abs(cz_enemigo - valkyrie.getPosicion_z()) == 3) {
								tiro = tiro - (Math.random() * (tiro * 0.2));
								tiro_2 = tiro_2 - (Math.random() * (tiro_2 * 0.2));
							}
							if (Math.abs(cz_enemigo - valkyrie.getPosicion_z()) == 4) {
								tiro = tiro - ((Math.random() * (tiro * 0.2)) + (tiro * 0.3));
								tiro_2 = tiro_2 - ((Math.random() * (tiro_2 * 0.2)) + (tiro_2 * 0.3));
							}

						}
						if (Math.abs(cz_enemigo - valkyrie.getPosicion_z()) > 4) {
							System.out.println("No puedes iniciar una pelea con el enemigo de las coordenadas especificadas.");
							opcion_pelea = "O";
						}
					}

					if ((cx_enemigo != valkyrie.getPosicion_x()) && (cy_enemigo != valkyrie.getPosicion_y()) && (cz_enemigo == valkyrie.getPosicion_z())) {
						if ((Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == Math.abs(cy_enemigo - valkyrie.getPosicion_y())) && (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) < 5)) {

							disparo = (int) (Math.random() * 3) + 1;
							tiro = (int) (Math.random() * 9) + 1;
							tiro_2 = (int) (Math.random() * 9) + 1;

							if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == 1) {
								tiro = tiro + ((Math.random() * (tiro * 0.2)) + (tiro * 0.1));
								tiro_2 = tiro_2 + ((Math.random() * (tiro_2 * 0.2)) + (tiro_2 * 0.1));
							}
							if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == 2) {
								tiro = tiro + (Math.random() * (tiro * 0.1));
								tiro_2 = tiro_2 + (Math.random() * (tiro_2 * 0.1));
							}
							if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == 3) {
								tiro = tiro - (Math.random() * (tiro * 0.2));
								tiro_2 = tiro_2 - (Math.random() * (tiro_2 * 0.2));
							}
							if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == 4) {
								tiro = tiro - ((Math.random() * (tiro * 0.2)) + (tiro * 0.3));
								tiro_2 = tiro_2 - ((Math.random() * (tiro_2 * 0.2)) + (tiro_2 * 0.3));
							}

						}
						else {
							System.out.println("No puedes iniciar una pelea con el enemigo de las coordenadas especificadas.");
							opcion_pelea = "O";
						}
					}

					if ((cx_enemigo != valkyrie.getPosicion_x()) && (cz_enemigo != valkyrie.getPosicion_z()) && (cy_enemigo == valkyrie.getPosicion_y())) {
						if ((Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == Math.abs(cz_enemigo - valkyrie.getPosicion_z())) && (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) < 5)) {

							disparo = (int) (Math.random() * 3) + 1;
							tiro = (int) (Math.random() * 9) + 1;
							tiro_2 = (int) (Math.random() * 9) + 1;

							if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == 1) {
								tiro = tiro + ((Math.random() * (tiro * 0.2)) + (tiro * 0.1));
								tiro_2 = tiro_2 + ((Math.random() * (tiro_2 * 0.2)) + (tiro_2 * 0.1));
							}
							if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == 2) {
								tiro = tiro + (Math.random() * (tiro * 0.1));
								tiro_2 = tiro_2 + (Math.random() * (tiro_2 * 0.1));
							}
							if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == 3) {
								tiro = tiro - (Math.random() * (tiro * 0.2));
								tiro_2 = tiro_2 - (Math.random() * (tiro_2 * 0.2));
							}
							if (Math.abs(cx_enemigo - valkyrie.getPosicion_x()) == 4) {
								tiro = tiro - ((Math.random() * (tiro * 0.2)) + (tiro * 0.3));
								tiro_2 = tiro_2 - ((Math.random() * (tiro_2 * 0.2)) + (tiro_2 * 0.3));
							}

						}
						else {
							System.out.println("No puedes iniciar una pelea con el enemigo de las coordenadas especificadas.");
							opcion_pelea = "O";
						}
					}

					if ((cy_enemigo != valkyrie.getPosicion_y()) && (cz_enemigo != valkyrie.getPosicion_z()) && (cx_enemigo == valkyrie.getPosicion_x())) {
						if ((Math.abs(cy_enemigo - valkyrie.getPosicion_y()) == Math.abs(cz_enemigo - valkyrie.getPosicion_z())) && (Math.abs(cy_enemigo - valkyrie.getPosicion_y()) < 5)) {

							disparo = (int) (Math.random() * 3) + 1;
							tiro = (int) (Math.random() * 9) + 1;
							tiro_2 = (int) (Math.random() * 9) + 1;

							if (Math.abs(cy_enemigo - valkyrie.getPosicion_y()) == 1) {
								tiro = tiro + ((Math.random() * (tiro * 0.2)) + (tiro * 0.1));
								tiro_2 = tiro_2 + ((Math.random() * (tiro_2 * 0.2)) + (tiro_2 * 0.1));
							}
							if (Math.abs(cy_enemigo - valkyrie.getPosicion_y()) == 2) {
								tiro = tiro + (Math.random() * (tiro * 0.1));
								tiro_2 = tiro_2 + (Math.random() * (tiro_2 * 0.1));
							}
							if (Math.abs(cy_enemigo - valkyrie.getPosicion_y()) == 3) {
								tiro = tiro - (Math.random() * (tiro * 0.2));
								tiro_2 = tiro_2 - (Math.random() * (tiro_2 * 0.2));
							}
							if (Math.abs(cy_enemigo - valkyrie.getPosicion_y()) == 4) {
								tiro = tiro - ((Math.random() * (tiro * 0.2)) + (tiro * 0.3));
								tiro_2 = tiro_2 - ((Math.random() * (tiro_2 * 0.2)) + (tiro_2 * 0.3));
							}
						}
						else {
							System.out.println("No puedes iniciar una pelea con el enemigo de las coordenadas especificadas.");
							opcion_pelea = "O";
						}
					}

					if ((disparo == 1) || (disparo == 2)) {
						if ((brazo_der == 1 && arma_der == 1) || (brazo_izq == 1 && arma_izq == 1)) {
							enemigos.get(num_enemigo).setNivel_de_resistencia(tiro);
							System.out.println("El enemigo N°" + enemigos.get(num_enemigo).getNumero_de_enemigo() + " pierde " + tiro + " puntos de vida");
						}
					}
					if (disparo == 3) {
						destino_disparo = (int) (Math.random() * valkyrie.get_Piezas().size());
						valkyrie.Recibir_Disparo(valkyrie.piezas_valkyrie.get(destino_disparo), tiro_2);
						System.out.println("La pieza " + valkyrie.piezas_valkyrie.get(destino_disparo) + " de Valkyrie ha perdido " + tiro_2 + " puntos de vida");
					}
					if (disparo == 4) {
						enemigos.get(num_enemigo).setNivel_de_resistencia(tiro);
						System.out.println("El enemigo N°" +  enemigos.get(num_enemigo).getNumero_de_enemigo() + " pierde " + tiro + " puntos de vida");

						if ((brazo_der == 1 && arma_der == 1) || (brazo_izq == 1 && arma_izq == 1)) {
							destino_disparo = (int) (Math.random() * valkyrie.get_Piezas().size());
							valkyrie.Recibir_Disparo(valkyrie.piezas_valkyrie.get(destino_disparo), tiro_2);
							System.out.println("La pieza " + valkyrie.piezas_valkyrie.get(destino_disparo) + " de Valkyrie ha perdido " + tiro_2 + " puntos de vida");
						}
					}


					valkyrie.setOrden(opcion);
				}
			}

			if((valkyrie.getVida_valkyrie()==0) || valkyrie.getVida_valkyrie()<0){
				opcion="T";
				System.out.println("            ¡¡¡¡¡GAME OVER!!!!!");
				System.out.close();
			}

			if(opcion_pelea.equalsIgnoreCase("5")){
				valkyrie.setPosicion_x(0);
				valkyrie.setPosicion_y(0);
				valkyrie.setPosicion_z(0);
			}

			if((enemigos.get(num_enemigo).getNivel_de_resistencia()==0) || (enemigos.get(num_enemigo).getNivel_de_resistencia() <0)){
				enemigos.remove(num_enemigo);
			}

			System.out.println("PIEZAS DISPONIBLES DE VALKYRIE : ");
			for(int i=0; i<valkyrie.get_Piezas().size(); i++){

				System.out.println("-" + valkyrie.get_Piezas().get(i));
			}
		}

		veces++;
		return veces;
	}

	public int Informe(){
		System.out.println("");
		System.out.println("REPORTE : ");
		System.out.println("");
		System.out.println("El VF-1 se encuentra en las siguientes condiciones : ");
		if(valkyrie.getEstado().equalsIgnoreCase("1")){
			System.out.println("-Modo   : Fighter.");
			if(valkyrie.getPosicion_z()==0){
				System.out.println("-Transporte  : Se desliza.");
			}
			if(valkyrie.getPosicion_z()>0){
				System.out.println("-Transporte  : Vuela.");
			}
		}
		if(valkyrie.getEstado().equalsIgnoreCase("2")){
			System.out.println("-Modo   : Gerwalk.");
			if(valkyrie.getPosicion_z()==0){
				System.out.println("-Transporte  : Camina.");
			}
			if(valkyrie.getPosicion_z()>0){
				System.out.println("-Transporte  : Vuela.");
			}
		}
		if(valkyrie.getEstado().equalsIgnoreCase("3")){
			System.out.println("-Modo   : Battloid.");
			System.out.println("-Transporte  : Camina.");
		}
		System.out.println("-Coordenadas  : (" + valkyrie.getPosicion_x() + " , " + valkyrie.getPosicion_y() + " ,  " + valkyrie.getPosicion_z() +") metros.");
		System.out.println("-Velocidad    : " + valkyrie.getVelocidad() + " m/s.");

		for (int i = 0; i < numero_de_pistas; i++) {
			if ((pistas.get(i).getPosicion_x_pista() < valkyrie.getPosicion_x()) || (pistas.get(i).getPosicion_x_pista() == valkyrie.getPosicion_x())) {
				if (((pistas.get(i).getPosicion_x_pista() + pistas.get(i).getLongitud_pista()) > valkyrie.getPosicion_x()) || ((pistas.get(i).getPosicion_x_pista() + pistas.get(i).getLongitud_pista()) == valkyrie.getPosicion_x())) {

					if((pistas.get(i).getPosicion_y_pista() < valkyrie.getPosicion_y()) || (pistas.get(i).getPosicion_y_pista() == valkyrie.getPosicion_y())) {
						if(((pistas.get(i).getPosicion_y_pista() + pistas.get(i).getAncho_pista()) > valkyrie.getPosicion_y()) || ((pistas.get(i).getPosicion_y_pista() + pistas.get(i).getAncho_pista()) == valkyrie.getPosicion_y())) {
							System.out.println("-El VF-1 está sobre una pista de longitud " + pistas.get(i).getLongitud_pista() + " y ancho " + pistas.get(i).getAncho_pista());
						}
					}
				}
			}
		}

		valkyrie.Imprimir_Estado_de_Piezas();

		System.out.println("-Enemigos Restantes  : " + enemigos.size());
		System.out.println("\t -Enemigos más cercanos : ");
		for(Enemigo enemigo: enemigos){
			if((enemigo.getCoordenada_x() == valkyrie.getPosicion_x()) && (enemigo.getCoordenada_y() == valkyrie.getPosicion_y())){
				if((Math.abs(enemigo.coordenada_z-valkyrie.getPosicion_z())<5) && (Math.abs(enemigo.coordenada_z-valkyrie.getPosicion_z())>0)){
					System.out.println("*El enemigo N°" + enemigo.getNumero_de_enemigo() + " está a " + (enemigo.coordenada_z-valkyrie.getPosicion_z()) + " metros de altura de Valkyrie.");
				}
			}

			if ((enemigo.getCoordenada_x() != valkyrie.getPosicion_x()) && (enemigo.getCoordenada_z() != valkyrie.getPosicion_z()) && (enemigo.getCoordenada_y() == valkyrie.getPosicion_y())) {
				if ((Math.abs(enemigo.getCoordenada_x() - valkyrie.getPosicion_x()) == Math.abs(enemigo.getCoordenada_z() - valkyrie.getPosicion_z())) && (Math.abs(enemigo.getCoordenada_x() - valkyrie.getPosicion_x()) < 5)) {
					System.out.println("*El enemigo N°" + enemigo.getNumero_de_enemigo() + " está en las coordenadas : (" + enemigo.getCoordenada_x() + " , " + enemigo.getCoordenada_y() + " , " + enemigo.getCoordenada_z() + ")");
				}
			}

			if ((enemigo.getCoordenada_y() != valkyrie.getPosicion_y()) && (enemigo.getCoordenada_z() != valkyrie.getPosicion_z()) && (enemigo.getCoordenada_x()== valkyrie.getPosicion_x())) {
				if ((Math.abs(enemigo.getCoordenada_y() - valkyrie.getPosicion_y()) == Math.abs(enemigo.getCoordenada_z() - valkyrie.getPosicion_z())) && (Math.abs(enemigo.getCoordenada_y() - valkyrie.getPosicion_y()) < 5)) {
					System.out.println("*El enemigo N°" + enemigo.getNumero_de_enemigo() + " está en las coordenadas : (" + enemigo.getCoordenada_x() + " , " + enemigo.getCoordenada_y() + " , " + enemigo.getCoordenada_z() + ")");
				}
			}
		}

		return 0;
	}

	public int Reparar_Valkyrie(){

		if(valkyrie.getPosicion_z()==0){

			for (int i = 0; i < numero_de_pistas; i++) {
				if ((pistas.get(i).getPosicion_x_pista() < valkyrie.getPosicion_x()) || (pistas.get(i).getPosicion_x_pista() == valkyrie.getPosicion_x())) {
					if (((pistas.get(i).getPosicion_x_pista() + pistas.get(i).getLongitud_pista()) > valkyrie.getPosicion_x()) || ((pistas.get(i).getPosicion_x_pista() + pistas.get(i).getLongitud_pista()) == valkyrie.getPosicion_x())) {

						if((pistas.get(i).getPosicion_y_pista() < valkyrie.getPosicion_y()) || (pistas.get(i).getPosicion_y_pista() == valkyrie.getPosicion_y())) {
							if(((pistas.get(i).getPosicion_y_pista() + pistas.get(i).getAncho_pista()) > valkyrie.getPosicion_y()) || ((pistas.get(i).getPosicion_y_pista() + pistas.get(i).getAncho_pista()) == valkyrie.getPosicion_y())) {

								valkyrie.Restaurar_Nivel_de_Resistencia();
								System.out.println("Todas las piezas de Valkyrie han sido reparadas.");

							}
						}
					}
				}
			}
		}


		return 0;
	}

	public int Actualizar_Modo_de_Valkyrie(){

		int aciertos_iz=0;
		int aciertos_der=0;

		if((valkyrie.getEstado().equalsIgnoreCase("1")) || (valkyrie.getEstado().equalsIgnoreCase("2"))) {
			for (int i = 0; i < valkyrie.get_Piezas().size(); i++) {
				if (valkyrie.get_Piezas().get(i).equals("Ala_iz")){
					aciertos_iz=1;
				}

				if(valkyrie.get_Piezas().get(i).equals("Ala_der")){
					aciertos_der=1;
				}
			}

			if((aciertos_iz==1) && (aciertos_der==1)){
				assert true;
			}

			else {
				if (valkyrie.getPosicion_z() > 200) {
					opcion = "T";
					System.out.println("    ¡¡¡¡¡GAME OVER!!!!!");
					System.out.close();
				}
				if (valkyrie.getPosicion_z() < 201) {

					aciertos_der=0;
					aciertos_iz=0;

					for (int i = 0; i < valkyrie.get_Piezas().size(); i++) {
						if (valkyrie.get_Piezas().get(i).equals("Pierna_iz")){
							aciertos_iz=1;
						}

						if(valkyrie.get_Piezas().get(i).equals("Pierna_der")){
							aciertos_der=1;
						}
					}

					if((aciertos_der==1) && (aciertos_iz==1)) {
						opcion = "3";
						valkyrie.setOrden(opcion);
						valkyrie.setEstado("3");
					}
					else{
						opcion = "T";
						System.out.println("    ¡¡¡¡¡GAME OVER!!!!!");
						System.out.close();
					}
				}
			}
		}

		if((valkyrie.getEstado().equalsIgnoreCase("2")) || valkyrie.getEstado().equalsIgnoreCase("3")){
			aciertos_der=0;
			aciertos_iz=0;

			for (int i = 0; i < valkyrie.get_Piezas().size(); i++) {
				if (valkyrie.get_Piezas().get(i).equals("Pierna_iz")){
					aciertos_iz=1;
				}

				if(valkyrie.get_Piezas().get(i).equals("Pierna_der")){
					aciertos_der=1;
				}
			}

			if((aciertos_der==1) && (aciertos_iz==1)){
				assert true;
			}
			else{
				aciertos_der=0;
				aciertos_iz=0;

				for (int i = 0; i < valkyrie.get_Piezas().size(); i++) {
					if (valkyrie.get_Piezas().get(i).equals("Ala_iz")){
						aciertos_iz=1;
					}

					if(valkyrie.get_Piezas().get(i).equals("Ala_der")){
						aciertos_der=1;
					}
				}

				if((aciertos_der==1) && (aciertos_iz==1)){
					opcion="1";
					valkyrie.setOrden(opcion);
					valkyrie.setEstado("1");
				}
				else{
					opcion="T";
					System.out.println("    ¡¡¡¡¡GAME OVER!!!!!");
					System.out.close();
				}
			}
		}

		return 0;
	}
}