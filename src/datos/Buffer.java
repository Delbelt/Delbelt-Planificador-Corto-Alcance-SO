package datos;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
	
	//FALTAN METODOS
	
	private int idBuffer;
	private List<Proceso> listaProcesos = new ArrayList<Proceso>();
	
	public Buffer(int idBuffer) {
		super();
		this.idBuffer = idBuffer;
	}
	
	public int getIdBuffer() {
		return idBuffer;
	}
	
	public void setIdBuffer(int idBuffer) {
		this.idBuffer = idBuffer;
	}
	
	public List<Proceso> getListaProcesos() {
		return listaProcesos;
	}
	
	public void setListaProcesos(List<Proceso> listaProcesos) {
		this.listaProcesos = listaProcesos;
	}
	
	@Override
	public String toString() {
		return "Buffer [idBuffer=" + idBuffer + ", listaProcesos=" + listaProcesos + "]";
	}
	
	public boolean bloquearProceso(Proceso proceso)
	{
		return listaProcesos.add(proceso);
	}
	
	public Proceso traerProceso(int idProceso)
	{		
		Proceso objeto = null;
		int i=0;
		
		while(i<listaProcesos.size() && objeto == null)
		{
			if(listaProcesos.get(i).getIdProceso() == idProceso)
			{
				objeto = listaProcesos.get(i);
			}
			
			i++;
		}
		
		return objeto;		
	}
	
	public boolean ejecutarEntradaSalida(int idProceso)
	{
		Proceso objeto = traerProceso(idProceso); //Validar que exista el Proceso
		
		int tiempo = objeto.getDuracion().getEyS();
		
		if(tiempo >= 0)
		{
			objeto.getDuracion().setEyS(tiempo - 1);
		}
		
		return(tiempo >= 0);		
	}
	
	public Proceso eliminarBloqueado(int idProceso)
	{
		Proceso objeto = traerProceso(idProceso); //Validar que exista el proceso
		
		listaProcesos.remove(objeto);
		
		return objeto;
	}
	
}
