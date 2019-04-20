import java.awt.Color;

public class Canon {
 
	/** Base del canyon */
	private PuntoEntero base;
	/** Punta del canyon */
	private PuntoEntero punta;
	/** Longitud del canyon */
	public static final int LONGITUD = 60;
	/** Distancia del fondo de la pantalla */
	public static final int BORDE = 60;
	/** angulo: 0 es vertical */
	private double angulo = 0d;
	/** cuanto cambia el angulo cada que se presiona tecla derecha o izquierda */
	private double deltaAngulo = 10d * Math.PI / 180d;
	
	private boolean DEBUG = false;
	 
	public Canon() {
		base = new PuntoEntero(Frame.ANCHO / 2, Frame.ALTO - BORDE);
		punta = new PuntoEntero(base.getX(), base.getY() - LONGITUD);
	}
	
	public Bola crearBola(){
		int x = (int)(Math.random() * 3);
		String url = "sprites/bola"+x+".png";
		Bola bola = new Bola(url, new PuntoEntero(375, 510),x);
		return bola;	
	}
	 

	public void rotarDerecha() {
		if(punta.getX()==341)punta.setX(344);	
		if(punta.getX()<459)
		angulo += deltaAngulo;
		//System.out.println(punta.getX());
	}
	
	public void rotarIzquierda() {
		if(punta.getX()==459)punta.setX(456);
		if(punta.getX()>341)
		angulo -= deltaAngulo;
		//System.out.println(punta.getX());
	} 
	
	public void dibujar(java.awt.Graphics g){
		g.setColor(Color.white);
		int x = (int) (Math.sin(angulo) * (double)LONGITUD);
		int y = (int) (Math.cos(angulo) * (double)LONGITUD);
		punta.setX(base.getX() + x);
		punta.setY(base.getY() - y);
		if(DEBUG)
		System.out.println("" + base + " " + punta + " ");
		g.drawLine(base.getX(), base.getY(), punta.getX(), punta.getY());
	}
	
	public PuntoEntero getpunta() {
		int dx = punta.getX() - base.getX();
		int dy = punta.getY() - base.getY();
		PuntoEntero punto = new PuntoEntero(dx, dy);
		return punto;
	}
	 
}
 
