package datos;

public class Duracion implements Cloneable {
	
	private int inicioCPU;
	private int EyS;
	private int finCPU;
	private int tiempoTotal;
	private int tiempoEspera;
	
	public Duracion() {
		this.inicioCPU = 0;
		this.EyS = 0;
		this.finCPU = 0;
		this.tiempoTotal = 0;
		this.tiempoEspera = 0;
	}
	
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
	
	public Object clone() { // ENE-2019¡¡¡
		Duracion obj = null;
		try {
			obj = (Duracion)super.clone();
		} catch (Exception e) {
			System.out.println(" no se puede duplicar objeto");
		}
		return obj;
	}
}
