import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Rectangle;

public class Techo extends Entidad {

	int repeticion = 0;

	int velocidad = 1;

	Bola bola;
	Bola bola1;
	Canon canon;
	Frame frame;
	Rectangle r3;
	Rectangle rSuelo;

	public final static int ALTURA = 50;

	private double deltaY;

	int posicionY = -580;

	private Sprite sprite;

	private ArrayList<Bola> coleccionBolas;

	public Techo(
			String ref,
			Frame frame,
			Canon canon,
			int cantidadBolas) {

		super(new PuntoEntero(10, 10), 800, 600);
		this.sprite = SpriteStore.get().getSprite(ref);
		this.frame = frame;
		this.canon = canon;
		coleccionBolas = new ArrayList<Bola>();
		bolasInicio(cantidadBolas);
		r3 = new Rectangle(0,this.posicionY,800,600);
		rSuelo = new Rectangle(0, 510,800,10);
	}

	public void bolasInicio(int cantidadBolas) {
		int x = 0;
		for (int i = 0; i < cantidadBolas; i++) {
			bola1 = canon.crearBola();
			bola1.posicion.setX(x);
			bola1.posicion.setY(posicionY + sprite.getHeight());
			bola1.setDeltaY(velocidad);
			coleccionBolas.add(bola1);
			x =x+ Bola.LADO;
			//System.out.println(coleccionBolas.size());
		}
	}

	public void ciclo(Graphics2D g) {
		for (int i = 0; i < coleccionBolas.size(); i++) {
			bola1 = coleccionBolas.get(i);
			bola1.dibujar(g);
		}
		// System.out.println(coleccionBolas.size());
	}

	public void agregarBola(Bola bola) {
		coleccionBolas.add(bola);
		//System.out.println(coleccionBolas.size());
	}
	
	public void darBola(Bola bola){
		this.bola=bola;
	}

	public void mover() {
		if (posicionY < -150) {
			if (repeticion % 25 == 0) {
				posicionY += velocidad;
				// mover bolas con el techo
				for (int i = 0; i < coleccionBolas.size(); i++) {
					coleccionBolas.get(i).mover();
				}
			}
		} else velocidad = 0;

		if(coleccionBolas.size()==0){
			velocidad=0;
			frame.setTitle("Bouncing Balls      You win :) ");
		}
		
		// colision con bolas
		r3 = new Rectangle(0,this.posicionY,this.ancho,this.alto);
		//System.out.println(r3);
		for (int i = 0; i < coleccionBolas.size(); i++) {
			Rectangle r1=coleccionBolas.get(i).getRectangle();
			for (int j = 0; j < coleccionBolas.size(); j++) {
				if(!coleccionBolas.get(i).equals(coleccionBolas.get(j)) ){	
					Rectangle r2=coleccionBolas.get(j).getRectangle();
					if(r1.intersects(r3)||r3.intersects(r1)||r1.intersects(r2)||r2.intersects(r1)){
						coleccionBolas.get(i).setDeltaY(velocidad);
						coleccionBolas.get(i).setDeltaX(0);
						if((r2.intersects(rSuelo) || 
						(bola.getRectangle().intersects(rSuelo)
						!=bola.getRectangle().intersects(rSuelo)))){
							frame.setTitle("Bouncing Balls      El juego termino :(");
							//velocidad=0;
							//System.out.println(" El juego termino :( ");
							frame.setTitle("Bouncing Balls     You Loser :( ");
							//System.exit(0);
						}	
						//int cont=0;
						if(bola.getRectangle().intersects(r1)||
						   bola.getRectangle().intersects(r3)){
						frame.inicializarBola();
						if(r1.intersects(r2)||r2.intersects(r1)){
							eliminarBolas(i);
						}
						}
					}
				}
				
			}                 
		}
	
		}
	
	public void eliminarBolas(int i){
		//System.out.println(coleccionBolas.get(i).getIdentifica());
			if(coleccionBolas.get(coleccionBolas.size()-1).getIdentifica()
			==coleccionBolas.get(i).getIdentifica()){
				//eliminarMasBolas(i);
				//cont++;
				//eliminarBola(j);
				//eliminarBola(coleccionBolas.size());
				eliminarBola(i);
				eliminarBola(coleccionBolas.size()-1);
				//i=coleccionBolas.size()-1;
			}
			
	}
	
	public void eliminarMasBolas(int i){
		for(int k=0;k<coleccionBolas.size();k++){
			if(coleccionBolas.get(i).getIdentifica()
			==coleccionBolas.get(k).getIdentifica()){
				eliminarMasBolas(k);
				eliminarBola(i);
			}
		}
	}
		
	public void eliminarBola(int i){
		coleccionBolas.remove(i);
	}



	public void dibujar(java.awt.Graphics g) {
		repeticion += 1;
		r3 = new Rectangle( 0,posicionY,800,600);
		sprite.draw(g, 0, posicionY);
	}

}
