import java.awt.Graphics;
import java.awt.Image;
//import java.awt.geom.AffineTransform;

/**
 * Esta clase maneja los Sprites (imágenes) que se van a cargar en la aplicación
 * 
 * Basado en el juego "SpaceInvaders", en versión de Kevin Glass
 * (disponible en http://www.cokeandcode.com/info/tut2d.html)
 * 
 * @author htrefftz
 *
 */
public class Sprite {
	private Image imagen;
	
	/**
	 * Crear un nuevo sprite
	 * 
	 * @param image Imagen para crear el sprite
	 */
	public Sprite(Image imagen) {
		this.imagen = imagen;
	}
	
	/**
	 * Retornar el ancho del sprite
	 * 
	 * @return Ancho en pixels del psrite
	 */
	public int getWidth() {
		return imagen.getWidth(null);
	}

	/**
	 * Retornar el alto del sprite
	 * 
	 * @return Retornar la altura en pixels del sprite
	 */
	public int getHeight() {
		return imagen.getHeight(null);
	}
	
	/**
	 * Dibujar el sprite
	 * 
	 * @param g En qué contexto gráfico dibujarlo
	 * @param x Coordenada en X para dibujar el sprite
	 * @param y Coordenada en Y para dibujar el sprite
	 */
	public void draw(Graphics g,int x,int y) {
		g.drawImage(imagen,x,y,null);
	}

}
