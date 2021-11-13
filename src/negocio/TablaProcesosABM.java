package negocio;

import java.util.List;

import datos.Proceso;
import datos.Tabla;

public class TablaProcesosABM {
	
	private List<Proceso> listaProcesos;
	private int cantidaColumnas;
		
	public TablaProcesosABM(ProcesamientoABM admP1) {
		
		super();
		this.listaProcesos = admP1.getListaProcesos();
		this.cantidaColumnas = admP1.getCantidaColumnas();
	}

	public List<Proceso> getListaProcesos() {
		return listaProcesos;
	}
	
	public void setListaProcesos(List<Proceso> listaProcesos) {
		this.listaProcesos = listaProcesos;
	}
	
	public int getCantidaColumnas() {
		return cantidaColumnas;
	}
	
	public void setCantidaColumnas(int cantidaColumnas) {
		this.cantidaColumnas = cantidaColumnas;
	}
	
	public String toString(Tabla[][] tabla) {
		String string = "";
		float T = 0;
		float W = 0;
		float P = 0;

		String texto[] = { "Proceso", "Tiempo llegada", "Tiempo Total", "Tiempo Finalización", "Tiempo de Repuesta(T)",
				"Tiempo Desperdiciado(W)", "Tiempo de Penalización(P)  " };
		for (int i = 0; i <= 72; i++) {
			string += "--";
		}
		string += "\n" + "|";
		for (int i = 0; i < 7; i++) {

			string += " " + texto[i] + " |";
		}
		// string += "\n" + "|";
		for (int i = 0; i < listaProcesos.size(); i++) {
			string += "\n| " + traerProceso(i + 1).getProceso() + "\t  |";
			string += " " + tiempoLLegada(i + 1) + "\t\t   |";
			string += " " + tiempoTotal(i + 1) + "\t\t  |";
			string += " " + tiempoFinalizacion(i + 1, tabla) + "\t\t\t|";
			// Promedios
			T += tiempoRespuesta(i + 1, tabla);
			string += " " + tiempoRespuesta(i + 1, tabla) + "\t\t\t|";
			W += tiempoDesperdiciado(i + 1, tabla);
			string += " " + tiempoDesperdiciado(i + 1, tabla) + "\t\t\t  |";
			P += tiempoPenalización(i + 1, tabla);
			string += " " + tiempoPenalización(i + 1, tabla) + "         \t\t|";
		}

		string += "\n";
		for (int i = 0; i <= 72; i++) {
			string += "--";
		}
		string += "\n";
		string += "|\tPromedio: \t\t\t\t\t\t" + "T=" + promedio(T) + "  \t\t" + "W=" + promedio(W)
				+ "  \t\t  " + "P=" + promedio(P) + "\t";

		string += "\n";
		for (int i = 0; i <= 72; i++) {
			string += "--";
		}
		return string;
	}

////////////////////////////////////////////////////////////METODOS	
	
	public Proceso traerProceso(int idProceso)
	{		
		return listaProcesos.get(idProceso - 1);
	}

	public String mostrarResultados(Tabla[][] tabla)
	{		
		return toString(tabla);
	}
	
	public int tiempoLLegada(int idProceso)
	{
		return traerProceso(idProceso).getComienzaTiempo();
	}

	public int tiempoTotal(int idProceso)
	{		
		return traerProceso(idProceso).tiempoTotal();
	}

	public int tiempoFinalizacion(int idProceso, Tabla[][] tabla)
	{		
		int tiempo = 0;
		
		for (int i = 0; i < getCantidaColumnas(); i++) 
		{
			if (tabla[idProceso - 1][i].equals("T"))
			{
				tiempo = i + 1;
			}
		}
		
		return tiempo;
	}

	public int tiempoRespuesta(int idProceso, Tabla[][] tabla)
	{
		return tiempoFinalizacion(idProceso, tabla) - tiempoLLegada(idProceso);
	}

	public int tiempoDesperdiciado(int idProceso, Tabla[][] tabla)
	{
		return tiempoRespuesta(idProceso, tabla) - tiempoTotal(idProceso);
	}

	public float tiempoPenalización(int idProceso, Tabla[][] tabla)
	{
		return (float) tiempoRespuesta(idProceso, tabla) / tiempoTotal(idProceso);
	}

	public float promedio(float cantidad)
	{
		return cantidad / getListaProcesos().size();
	}
}
