import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManejadorTeclado extends KeyAdapter{

	private boolean DEBUG = false;
	/** Referencia al juego, para poder invocar los métodos del juego */
	private Frame frame;
	 
	public ManejadorTeclado(Frame frame) {
		this.frame = frame;
	}
	 
	public void keyPressed(KeyEvent e) {
		if (DEBUG)
			System.out.println("En ManejadorTeclado: tecla presionada");
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			frame.presionarTeclaIzq();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			frame.presionarTeclaDer();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			frame.presionarTeclaup();
		}
		
	}
	 
}
 
