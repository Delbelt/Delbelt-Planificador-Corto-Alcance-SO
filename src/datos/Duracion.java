package datos;

public class Duracion {
	
	private int inicioCPU;
	private int EyS;
	private int finCPU;
	private int tiempoTotal;
	private int tiempoEspera;
	
	public Duracion(int inicioCPU, int eyS, int finCPU) {
		
		super();
		this.inicioCPU = inicioCPU;
		EyS = eyS;
		this.finCPU = finCPU;
		this.tiempoTotal = inicioCPU + finCPU;
		this.tiempoEspera = 0;
	}

	public int getInicioCPU() {
		return inicioCPU;
	}

	public void setInicioCPU(int inicioCPU) {
		this.inicioCPU = inicioCPU;
	}

	public int getEyS() {
		return EyS;
	}

	public void setEyS(int eyS) {
		EyS = eyS;
	}

	public int getFinCPU() {
		return finCPU;
	}

	public void setFinCPU(int finCPU) {
		this.finCPU = finCPU;
	}

	public int getTiempoTotal() {
		return tiempoTotal;
	}

	public void setTiempoTotal(int tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}

	public int getTiempoEspera() {
		return tiempoEspera;
	}

	public void setTiempoEspera() {
		this.tiempoEspera = tiempoEspera + 1;
	}

	@Override
	public String toString() {
		return "Duracion [inicioCPU=" + inicioCPU + ", EyS=" + EyS + ", finCPU=" + finCPU + ", tiempoTotal="
				+ tiempoTotal + ", tiempoEspera=" + tiempoEspera + "]";
	}	
}
