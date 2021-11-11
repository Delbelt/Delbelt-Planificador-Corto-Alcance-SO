package datos;

public class Proceso {
	
	//FALTAN METODOS
	
	private int idProceso;
	private String proceso;
	private int comienzaTiempo;
	private Prioridad prioridad;
	private Duracion duracion;
	
	public Proceso(int idProceso, String proceso, int comienzaTiempo, Prioridad prioridad, Duracion duracion) {
		
		super();
		this.idProceso = idProceso;
		this.proceso = proceso;
		this.comienzaTiempo = comienzaTiempo;
		this.prioridad = prioridad;
		this.duracion = duracion;
	}

	public int getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public int getComienzaTiempo() {
		return comienzaTiempo;
	}

	public void setComienzaTiempo(int comienzaTiempo) {
		this.comienzaTiempo = comienzaTiempo;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public Duracion getDuracion() {
		return duracion;
	}

	public void setDuracion(Duracion duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Proceso [idProceso=" + idProceso + ", proceso=" + proceso + ", comienzaTiempo=" + comienzaTiempo
				+ ", prioridad=" + prioridad + ", duracion=" + duracion + "]";
	}
	
	public int tiempoTotal()
	{		
		return getDuracion().getInicioCPU() + getDuracion().getFinCPU() + getDuracion().getEyS();
	}
	
	public void tiempoEspera()
	{
		getDuracion().setTiempoEspera();		
	}
	
	public int tasaRespuesta()
	{
		int prioridad=0;
		
		prioridad=(getDuracion().getTiempoEspera() + getDuracion().getTiempoTotal()) / getDuracion().getTiempoTotal();
		
		return prioridad;
	}
}
