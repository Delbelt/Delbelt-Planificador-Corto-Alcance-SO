package datos;

public class Tabla {
	
	private int fila;
	private int columna;
	private String estado;
	
	public Tabla(int fila, int columna) {
		
		super();
		this.fila = fila;
		this.columna = columna;
		this.estado = "";
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Tabla [fila=" + fila + ", columna=" + columna + ", estado=" + estado + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return ((Tabla)obj).getEstado().equals(this.getEstado());
	}
	
	public boolean equals(String estado) { //CHEQUEAR CON TablaProcesosABM
		if (getEstado().equals(estado))
			return true;
		return false;
	}
	
	
}
