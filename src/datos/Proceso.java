package datos;

public class Proceso implements Cloneable, Comparable<Proceso> {
		
	private int idProceso;
	private String proceso;
	private int comienzaTiempo;
	private Prioridad prioridad;
	private Duracion duracion;
	
	public Proceso() {
		
		this.idProceso = 0;
		this.proceso = " ";
		this.comienzaTiempo = 0;
		this.prioridad = Prioridad.Baja;
		this.duracion = new Duracion();
	}
	
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
	
//////////////////////////////////////////////////////////// METODOS		
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
		return (duracion.getTiempoEspera() + getDuracion().getTiempoTotal()) / getDuracion().getTiempoTotal();
	}

	public Proceso clone()
	{
		Proceso objeto = null;
		try 
		{
			objeto = (Proceso)super.clone();			
		} 
		
		catch (Exception e)
		{
			System.out.println(" no se puede duplicar objeto");
		}
		
		objeto.duracion = (Duracion)objeto.duracion.clone();
		
		return objeto;
	}
	
	public int compareTo(Proceso producto)
	{
		int resultado = 0;
		
		if (this.getDuracion().getTiempoTotal()  < producto.getDuracion().getTiempoTotal())
		{
			resultado = -1;
		} 
		
		else if (this.getDuracion().getTiempoTotal() > producto.getDuracion().getTiempoTotal())
		{
			resultado = 1;
		} 
		
		else
		{
			resultado = 0;
		}
		
		return resultado;
	}
	
}
