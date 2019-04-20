import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Graphics2D;

/**
 * Juego de BouncingBalls.  Version 0.01
 * @author htrefftz
 *
 */

public class Juego extends JFrame {
    /** Ancho de la ventana */
	public static final int ANCHO = 800;
	/** Alto de la ventana */
	public static final int ALTO = 600;
	/** Techo del cual se cuelgan las bolas */
	private Techo techo;
	/** Canyon con el cual se disparan las bolas */
	private Canyon canyon;
	/** La bola que se va a mover */
	private Bola bolaAMoverse;
	/** Clase para manejar los eventos del teclado */
	private ManejadorTeclado manejadorTeclado;
	/** Lienzo sobre el cual se pintan las entidades del juego */
	private Lienzo lienzo;
	
	/**
	 * Constructor del juego
	 */
	public Juego() {
		super("Bouncing Balls");
		setPreferredSize(new Dimension(ANCHO, ALTO));
		setLayout(null);
		
		lienzo = new Lienzo();
		lienzo.setBounds(0, 0, ANCHO, ALTO);
		add(lienzo);
		
		pack();
		setResizable(false);
		setVisible(true);
		
		lienzo.crearEstrategia();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		manejadorTeclado = new ManejadorTeclado(null);
		addKeyListener(manejadorTeclado);
		requestFocus();
	}
	
	/**
	 * Poner las entidades en sus posiciones iniciales
	 */
	public void inicializarEnditades() {
		canyon = new Canyon();
		//bolaRoja = new Bola("Sprites/bolaRoja.png", new PuntoEntero(100, 100));
		/*techo = new Techo(
				"Sprites/techo.png",
				this,
				canyon,
				10
		);*/
		bolaAMoverse = canyon.generarBola();
	}

	/**
	 * Ha sido presionada la tecla izquierda
	 */
	public void presionarTeclaIzq() {
		canyon.rotarIzquierda();
	}
	 
	/**
	 * Ha sido presionada la tecla derecha
	 */
	public void presionarTeclaDer() {
		canyon.rotarDerecha();
	}
	 
	/**
	 * Ha sido presionada la tecla espaciadora
	 */
	public void presionarTeclaEsp() {
		PuntoEntero pe = canyon.getDxYDY();
		bolaAMoverse.setDeltaX(pe.getX()/10);
		bolaAMoverse.setDeltaY(pe.getY()/10);
	}
	 	
	public void ciclo() {
		while (true) {
			Graphics2D g = (Graphics2D) lienzo.getStrategy().getDrawGraphics();
			g.setColor(Color.white);
			g.fillRect(0,0,ANCHO,ALTO);
			canyon.dibujar(g);
			bolaAMoverse.mover();
			bolaAMoverse.dibujar(g);
			techo.dibujar(g);
			g.dispose();
			lienzo.getStrategy().show();
		}
	}
	
	/**
	 * Programa princial
	 * @param args
	 */
	/*public static void main(String [] args) {
		Juego juego = new Juego();
		juego.inicializarEnditades();
		juego.ciclo();
	}*/
	 
}
 
