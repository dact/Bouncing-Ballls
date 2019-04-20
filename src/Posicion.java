
public class Posicion {
	
	private PuntoEntero posicion;
	private Bola bola;
	
	public Posicion() {
		posicion = null;
	}
	
	public Posicion(PuntoEntero posicion) {
		this.posicion = posicion;
		this.bola = null;
	}
	
	public void setBola(Bola bola) {
		this.bola = bola;
		this.bola.setPosicion(posicion);
	}
	
	public Bola getBola() {
		return bola;
	}

}
