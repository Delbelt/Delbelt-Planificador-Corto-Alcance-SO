package datos;

import java.util.ArrayList;
import java.util.List;

public class Listo {
	
	//FALTAN METODOS
	
	private int idListo;
	private List<Proceso> listaProcesos = new ArrayList<Proceso>();
	
	public Listo(int idListo) {
		
		super();
		this.idListo = idListo;
	}

	public int getIdListo() {
		return idListo;
	}

	public void setIdListo(int idListo) {
		this.idListo = idListo;
	}

	public List<Proceso> getListaProcesos() {
		return listaProcesos;
	}

	public void setListaProcesos(List<Proceso> listaProcesos) {
		this.listaProcesos = listaProcesos;
	}

	@Override
	public String toString() {
		return "Listo [idListo=" + idListo + ", listaProcesos=" + listaProcesos + "]";
	}
	
	public Proceso traerProceso(int idProceso)
	{
		Proceso objeto = null;
		int i=0;
		
		while(i < listaProcesos.size() && objeto == null)
		{
			if(listaProcesos.get(i).getIdProceso() == idProceso)
			{
				objeto = listaProcesos.get(i);
			}	
			
			i++;
		}
		
		return objeto;		
	}
	
	public boolean listarProceso(Proceso proceso)
	{	
		return listaProcesos.add(proceso);
	}
	
	public boolean deslistarProceso(int idProceso)
	{
		Proceso objeto = traerProceso(idProceso); //Validar que exista el Proceso
		
		return listaProcesos.remove(objeto);		
	}	
}
