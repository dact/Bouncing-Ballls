import java.awt.Color;

public class Canyon {
 
	/** Base del canyon */
	private PuntoEntero base;
	/** Punta del canyon */
	private PuntoEntero punta;
	/** Longitud del canyon */
	public static final int LONGITUD = 60;
	/** Distancia del fondo de la pantalla */
	public static final int BORDE = 100;
	/** angulo: 0 es vertical */
	private double angulo = 0d;
	/** cuanto cambia el angulo cada que se presiona tecla derecha o izquierda */
	private double deltaAngulo = 10d * Math.PI / 180d;
	/** la bola que se va a disparar */
	private Bola bolaContinua;
	
	private boolean DEBUG = false;
	 
	public Canyon() {
		base = new PuntoEntero(Juego.ANCHO / 2, Juego.ALTO - BORDE);
		punta = new PuntoEntero(base.getX(), base.getY() - LONGITUD);
	}
	 

	public void rotarDerecha() {
		angulo += deltaAngulo;
	}
	
	public void rotarIzquierda() {
		angulo -= deltaAngulo;
	}
	
	public void dibujar(java.awt.Graphics g){
		g.setColor(Color.blue);
		int x = (int) (Math.sin(angulo) * (double)LONGITUD);
		int y = (int) (Math.cos(angulo) * (double)LONGITUD);
		punta.setX(base.getX() + x);
		punta.setY(base.getY() - y);
		if(DEBUG)
			System.out.println("" + base + " " + punta + " ");
		g.drawLine(base.getX(), base.getY(), punta.getX(), punta.getY());
	}
	
	public Bola generarBola() {
		PuntoEntero punto = 
			new PuntoEntero(base.getX(), base.getY()+25);
		bolaContinua = new Bola("sprites/bolaRoja.png", punto,0);
		return bolaContinua;
	}
	
	public PuntoEntero getDxYDY() {
		int dx = punta.getX() - base.getX();
		int dy = punta.getY() - base.getY();
		PuntoEntero pe = new PuntoEntero(dx, dy);
		return pe;
	}
	 
}
 
