import java.awt.Rectangle;
public class Bola extends Entidad {
	
	
	private double deltaX;
	 
	private double deltaY;
	
	int velocidad=1;
	
	int identifica;
	
	private Rectangle rectangulo;
	
	private Sprite sprite;
	
	public static final int LADO = 50;
	
	public Bola(String ref, PuntoEntero posicion,int identifica) {
		super(posicion, LADO, LADO);
		this.sprite = SpriteStore.get().getSprite(ref);
		rectangulo = new Rectangle( posicion.getX(),posicion.getY(),LADO,LADO);
		this.identifica=identifica;
	}
	
	public int getIdentifica(){
		return identifica;
	}
	
	public Rectangle getRectangle(){
	return rectangulo;
	}
	
	public void setDeltaX(double deltaX) {
		this.deltaX = deltaX;
	}

	public void setDeltaY(double deltaY) {
		this.deltaY = deltaY;
	}

	public void mover(){
		posicion.setX(posicion.getX() + (int)deltaX);
		posicion.setY(posicion.getY() + (int)deltaY);
		
		if(posicion.getX()<=0)setDeltaX(-deltaX); 
		if(posicion.getX()>=Frame.ANCHO-Bola.LADO)setDeltaX(-deltaX);
		rectangulo = new Rectangle( posicion.getX(),posicion.getY(),LADO,LADO);
		
	}
	
	public void dibujar(java.awt.Graphics g){
		sprite.draw(g, posicion.getX(), posicion.getY());
	}
	
}
 
