
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Frame extends JFrame {
	
	public static void main(String [] args) {
		Frame juego = new Frame();
		juego.inicializarEnditades();
		juego.inicializarBola();
		juego.ciclo();
	}
	int cantidadBolas=10;

	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	private Canon canon;
	private Techo techo;
	private Bola bola;
	private ManejadorTeclado manejadorTeclado;
	private Lienzo lienzo;
	Sprite suelo;
	Sprite fondo;
	int cambio=2;
	
	public Frame(){
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
		
		manejadorTeclado = new ManejadorTeclado(this);
		addKeyListener(manejadorTeclado);
		requestFocus();
		
		suelo = SpriteStore.get().getSprite("sprites/suelo.png");
		fondo = SpriteStore.get().getSprite("sprites/fondo.png");
	}
	
	public void ciclo() {
		while (true) {
			techo.mover();
			Graphics2D g = (Graphics2D) lienzo.getStrategy().getDrawGraphics();
			g.setColor(Color.white);
			g.fillRect(0,0,ANCHO,ALTO);
			fondo.draw(g, 0, 0);
			techo.dibujar(g);
			suelo.draw(g, 0, 510);
			techo.ciclo(g);
			bola.mover();
			bola.dibujar(g);
			canon.dibujar(g);
			g.dispose();
			lienzo.getStrategy().show();
			try { Thread.sleep(10); } catch (Exception e) {}
		}
	}
	
	public void inicializarEnditades() {
		canon = new Canon();
		techo = new Techo("sprites/techo.png",this,canon,cantidadBolas);
	}
	public void inicializarBola(){
		bola = canon.crearBola();
		techo.darBola(bola);
	}
	
	public void presionarTeclaIzq() {
		canon.rotarIzquierda();
	}
	 
	/**
	 * Ha sido presionada la tecla derecha
	 */
	public void presionarTeclaDer() {
		canon.rotarDerecha();
	}
	 
	/**
	 * Ha sido presionada la tecla espaciadora
	 */
	public void presionarTeclaup() {
		PuntoEntero punto = canon.getpunta();
		bola.setDeltaX((punto.getX()/10));
		bola.setDeltaY((punto.getY()/10));
		techo.agregarBola(bola);
		}
	
}
