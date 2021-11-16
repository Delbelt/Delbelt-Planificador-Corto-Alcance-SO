package datos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Listo {
		
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
	public String toString()
	{
		String string = "IdListo=" + getIdListo();
		if (!getListaProcesos().isEmpty()) {
			string += ", LstProcesos=[";
			for (Proceso proceso : getListaProcesos()) {
				string += "\n\t" + proceso;
			}
			string += "]";
		} else {
			string += ", LstProcesos=[" + null + "]";
		}
		return string;
	}

//////////////////////////////////////////////////////////// METODOS		
	
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
	
	public boolean ordenarPrioridad() 
	{
		boolean bandera = false;
		
		List<Proceso> lista = new ArrayList<Proceso>();
		int i = 0;
		int contadorAlta = 0;
		int contadorMedia = 0;
		
		while (i < getListaProcesos().size())
		{
			if (getListaProcesos().get(i).getPrioridad().equals(Prioridad.Alta))
			{				
				if (lista.isEmpty())
				{
					lista.add(getListaProcesos().get(i));
				} 				
				else 
				{
					lista.add(contadorAlta, getListaProcesos().get(i));					
				}
					contadorAlta++;
			}
			
			if (getListaProcesos().get(i).getPrioridad().equals(Prioridad.Media))
			{
				if (lista.isEmpty()) 
				{
					lista.add(getListaProcesos().get(i));
				}				
				else
				{
					lista.add(contadorAlta + contadorMedia, getListaProcesos().get(i));
				}
					contadorMedia++;
			}
			if (getListaProcesos().get(i).getPrioridad().equals(Prioridad.Baja))
			{
				lista.add(getListaProcesos().get(i));
			}			

			i++;
		}
		
		// Termino y guardo lista ordenada por prioridad
		getListaProcesos().removeAll(listaProcesos);
		setListaProcesos(lista);
		return bandera;
	}
	
	public boolean ordenarTiempoTotal()
	{
		Collections.sort(getListaProcesos());
		return true;
	}
	
	public boolean ordenarTiempoRestante()
	{
		Proceso objeto = new Proceso();
		
		int i = 0;
		int inicioCPU = 0;
		int finCPU = 0;
		
		while (i < getListaProcesos().size()) 
		{
			inicioCPU = 0;
			finCPU = 0;
			
			objeto = getListaProcesos().get(i);
			
			if (objeto.getDuracion().getInicioCPU() > 0)
			{
				inicioCPU = objeto.getDuracion().getInicioCPU();
			}
			
			if (objeto.getDuracion().getFinCPU() > 0)
			{
				finCPU = objeto.getDuracion().getFinCPU();
			}
			
			objeto.getDuracion().setTiempoTotal(inicioCPU + finCPU);
			i++;
		}		

		Collections.sort(getListaProcesos());
		return true;
	}
	
	public boolean tasaRespuesta()
	{
		int prioridad = 0;
		boolean bandera = false;
		
		if (!getListaProcesos().isEmpty())
		{
			
			bandera = true;
			
			for (Proceso proceso : getListaProcesos())
			{
				proceso.tiempoEspera();
				// se suma +1 a tiempo de espera
				prioridad = proceso.tasaRespuesta();
				// se cambia prioridad segun:
				if (prioridad >= 0 && prioridad <= 3)
				{
					proceso.setPrioridad(Prioridad.Baja);
				}
				
				if (prioridad >= 4 && prioridad <= 6)
				{
					proceso.setPrioridad(Prioridad.Media);
				}
				
				if (prioridad >= 7)
				{
					proceso.setPrioridad(Prioridad.Alta);
				}
			}				
		}
			return bandera;
	}
	
	public boolean ordenarTiempoTotalPrioridad()
	{	
		List<Proceso> listaAlta = new ArrayList<Proceso>();
		List<Proceso> listaMedia = new ArrayList<Proceso>();
		List<Proceso> listaBaja = new ArrayList<Proceso>();
		
		for (Proceso lista : listaProcesos)
		{	
			if(lista.getPrioridad().equals(Prioridad.Alta))
			{
				listaAlta.add(lista);
			}
			
			if(lista.getPrioridad().equals(Prioridad.Media))
			{
				listaMedia.add(lista);
			}
			
			if(lista.getPrioridad().equals(Prioridad.Baja))
			{
				listaBaja.add(lista);
			}			
		}
		
		Collections.sort(listaAlta);
		Collections.sort(listaMedia);
		Collections.sort(listaBaja);
		
		listaProcesos.removeAll(listaProcesos);
		
		listaProcesos.addAll(listaAlta);
		listaProcesos.addAll(listaMedia);
		listaProcesos.addAll(listaBaja);
		
		return true;
	}
	
}
