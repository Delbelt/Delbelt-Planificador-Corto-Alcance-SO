package datos;

public class Hilo {
	
	private int idHilo;
	private boolean ejecutando;
	private Proceso proceso;
	
	public Hilo(int idHilo) {
		
		super();
		this.idHilo = idHilo;
		this.ejecutando = false;
		this.proceso = null;
	}

	public int getIdHilo() {
		return idHilo;
	}

	public void setIdHilo(int idHilo) {
		this.idHilo = idHilo;
	}

	public boolean getEjecutando() {
		return ejecutando;
	}

	public void setEjecutando(boolean ejecutando) {
		this.ejecutando = ejecutando;
	}

	public Proceso getProceso() {
		return proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}

	@Override
	public String toString() {
		return "Hilo [idHilo=" + idHilo + ", ejecutando=" + ejecutando + ", proceso=" + proceso + "]";
	}
	
	public boolean ejecutarProceso(Proceso proceso) {
		
		boolean validacion = getEjecutando();
		
		if (! getEjecutando()) 
		{
			setProceso(proceso);
			setEjecutando(true);			
		}
		
		return (validacion != getEjecutando());
	}
	
	public boolean ejecutarInstrucción() {
		
		boolean ejecutado = false;
		
		int tiempo = getProceso().getDuracion().getInicioCPU();
		
		if (tiempo >= 0)
		{			
			getProceso().getDuracion().setInicioCPU(tiempo - 1);
			ejecutado = true;
		}
		
		else 		
		{
			tiempo = getProceso().getDuracion().getFinCPU();
			
			if (tiempo >= 0)
			{
				getProceso().getDuracion().setFinCPU(tiempo - 1);
				ejecutado = true;
			}
		}
		
		return ejecutado;
	}
	
	public Proceso eliminarProceso(){
		
		Proceso objeto = null;
		
		if (getEjecutando())
		{			
			objeto = getProceso();
			setProceso(null);
			setEjecutando(false);
		}
		
		return objeto;
	}
	
}
