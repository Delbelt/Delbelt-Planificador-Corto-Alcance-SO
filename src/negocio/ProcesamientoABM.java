package negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import datos.Buffer;
import datos.Duracion;
import datos.Hilo;
import datos.Listo;
import datos.Prioridad;
import datos.Proceso;
import datos.Tabla;

public class ProcesamientoABM {
		
	private List<Proceso> listaProcesos = new ArrayList<Proceso>();
	private int cantidadFilas;
	private int cantidaColumnas;
	private Tabla[][] tabla;
	private Hilo hilo;
	private Buffer buffers;
	private Listo listo;
	
	public ProcesamientoABM(int cantidadFilas, int cantidadColumnas) 
	{
		super();
		this.cantidadFilas = cantidadFilas;
		this.cantidaColumnas = cantidadColumnas;
		this.tabla = new Tabla[cantidadFilas][cantidadColumnas];
		this.hilo = new Hilo(1);
		this.buffers = new Buffer(1);
		this.listo = new Listo(1);
	}

	public List<Proceso> getListaProcesos() {
		return listaProcesos;
	}

	public void setListaProcesos(List<Proceso> listaProcesos) {
		this.listaProcesos = listaProcesos;
	}

	public int getCantidadFilas() {
		return cantidadFilas;
	}

	public void setCantidadFilas(int cantidadFilas) {
		this.cantidadFilas = cantidadFilas;
	}

	public int getCantidaColumnas() {
		return cantidaColumnas;
	}

	public void setCantidaColumnas(int cantidaColumnas) {
		this.cantidaColumnas = cantidaColumnas;
	}

	public Tabla[][] getTabla() {
		return tabla;
	}

	public void setTabla(Tabla[][] tabla) {
		this.tabla = tabla;
	}

	public Hilo getHilo() {
		return hilo;
	}

	public void setHilo(Hilo hilo) {
		this.hilo = hilo;
	}

	public Buffer getBuffers() {
		return buffers;
	}

	public void setBuffers(Buffer buffers) {
		this.buffers = buffers;
	}

	public Listo getListo() {
		return listo;
	}

	public void setListo(Listo listo) {
		this.listo = listo;
	}
	
	@Override
	public String toString()
	{
		String string;
		string = "--------";
		for (int i = 0; i <= getCantidaColumnas(); i++) {
			string += "----";
		}
		string += "\n| proceso: |";
		for (int i = 1; i <= getCantidaColumnas(); i++) {
			if (i < 10) {
				string += " "+i+" |";
			}
			if (i >= 10 && i < 100) {
				string += i + " |";
			}else{
				if (i >= 10)string += i + "|";
			}
		}
		for (int i = 0; i < getListaProcesos().size(); i++) {

			string += "\n| " + getListaProcesos().get(i).getProceso() + "\t   |";
			for (int j = 0; j < getCantidaColumnas(); j++) {
				string += " " + getTabla()[i][j] + " |";
			}
		}
		string += "\n--------";
		for (int i = 0; i <= getCantidaColumnas(); i++) {
			string += "----";
		}
		return string;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProcesamientoABM other = (ProcesamientoABM) obj;
		if (cantidaColumnas != other.cantidaColumnas)
			return false;
		if (cantidadFilas != other.cantidadFilas)
			return false;
		if (listaProcesos == null) {
			if (other.listaProcesos != null)
				return false;
		} else if (!listaProcesos.equals(other.listaProcesos))
			return false;
		if (!Arrays.deepEquals(tabla, other.tabla))
			return false;
		return true;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidaColumnas;
		result = prime * result + cantidadFilas;
		result = prime * result + ((listaProcesos == null) ? 0 : listaProcesos.hashCode());
		result = prime * result + Arrays.deepHashCode(tabla);
		return result;
	}
	
	public int hashCode(Tabla[][] table)
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(table);
		return result;
	}
	
//////////////////////////////////////////////////////////// METODOS
	
	public String mostrarPlanificador(Tabla[][] auxTabla)
	{
		String string;
		string = "--------";
		for (int i = 0; i <= getCantidaColumnas(); i++) {
			string += "----";
		}
		string += "\n| proceso: |";
		for (int i = 1; i <= getCantidaColumnas(); i++) {
			if (i < 10) {
				string += " "+i+" |";
			}
			if (i >= 10 && i < 100) {
				string += i + " |";
			}else{
				if (i >= 10)string += i + "|";
			}
		}
		for (int i = 0; i < getListaProcesos().size(); i++) {
			string += "\n| " + getListaProcesos().get(i).getProceso() + "\t   |";
			for (int j = 0; j < getCantidaColumnas(); j++) {
				string += " " + auxTabla[i][j] + " |";
			}
		}
		string += "\n--------";
		for (int i = 0; i <= getCantidaColumnas(); i++) {
			string += "----";
		}
		return string;
	}
	
	public String mostrarProcesos()
	{
		String string = "";
		for (Proceso proceso : getListaProcesos()) 
		{
			string += proceso + "\n";
		}
		
		return string;
	}
	
	public boolean agregarProceso(String nombreProceso, int comienzaTiempo, int inicioCPU, int EyS, int finCPU, Prioridad prioridad) 
	{
		int id = 1;
		
		if (listaProcesos.size() > 0)
		{
			id = listaProcesos.get(getListaProcesos().size() - 1).getIdProceso() + 1;
		}	
		
		return listaProcesos.add(new Proceso(id, nombreProceso, comienzaTiempo, prioridad, new Duracion(inicioCPU, EyS, finCPU)));
	}
	
	
	public Proceso traerProceso(int idProceso)
	{//NO cambiar
		Proceso objeto = null;
		
		if (!listaProcesos.isEmpty() && listaProcesos.size() > idProceso) 
		{
			objeto = getListaProcesos().get(idProceso);
		}
		
		return objeto;
	}
	
	
	public boolean listarProcesoFIFO(Proceso proceso)
	{
		return listo.getListaProcesos().add(proceso);
	}
	
	
	public boolean listarProcesoLIFO(Proceso proceso)
	{
		listo.getListaProcesos().add(0, proceso); //Metodo Void
		return true;
	}
	
	
	public Proceso deslistarProcesoFIFO()
	{		
		Proceso objeto = null;

		if (!getListo().getListaProcesos().isEmpty()) 
		{
			objeto = getListo().getListaProcesos().get(0);
			getListo().getListaProcesos().remove(0);
		}
		
		return objeto;
	}

	
	public boolean ejecutarProceso(Proceso proceso)
	{
		return hilo.ejecutarProceso(proceso);
	}
	

	public Proceso terminarProceso()
	{
		Proceso objeto = new Proceso();
		
		if (hilo.getEjecutando())
		{
			objeto = getHilo().eliminarProceso();
		}
			return objeto;
	}
	
	
	public boolean bloquearProceso(Proceso proceso)
	{
		return buffers.bloquearProceso(proceso);
	}
	
	
	public Proceso desbloquearProceso(int idProceso)
	{
		Proceso objeto = new Proceso();
		
		if (!buffers.getListaProcesos().isEmpty())
		{
			objeto = buffers.eliminarBloqueado(idProceso);
		}
		
		return objeto;
	}
	
	
	public Tabla[][] newTable()
	{
		Tabla[][] tabla = new Tabla[getCantidadFilas()][getCantidaColumnas()];

		for (int i = 0; i < getCantidadFilas(); i++)
		{
			for (int j = 0; j < getCantidaColumnas(); j++)
			{
				tabla[i][j] = new Tabla(i + 1, j + 1);
			}
		}
		
		return tabla;
	}
	
	
	public List<Proceso> clone(List<Proceso> listaProcesos)
	{	
		List<Proceso> lista = new ArrayList<Proceso>();

		for (Proceso proceso : listaProcesos)
		{
			Proceso objeto = proceso.clone();
			lista.add(objeto);
		}
		
		return lista;
	}
	
	
	public boolean listarProcesoEntrada(List<Proceso> procesos, int columna)
	{
		boolean bandera=false;
		
		for (int fila = 0; fila < procesos.size(); fila++)
		{
			if (procesos.get(fila).getComienzaTiempo() == (columna + 1))
			{
				// Estado de proceso a: Listo
				listarProcesoFIFO(procesos.get(fila));
				bandera=true;
			}
		}
		
		return bandera;
	}
	
	
	public boolean ordenarId()
	{
		Proceso objeto = new Proceso();
		int indice;
		boolean ordenado=false;

		// Ordeno lista por InsertionSort por id
		for(int i=1; i < listaProcesos.size(); i++)
		{
			objeto=listaProcesos.get(i);
			indice=i-1;
			ordenado = false;
			
			while(!ordenado && indice>=0)
			{
				if(objeto.getIdProceso() < getListaProcesos().get(indice).getIdProceso())
				{	
					getListaProcesos().set(indice+1, getListaProcesos().get(indice));
					indice=indice-1;
				}				
				else
				{
					ordenado=true;
				}
			}
			
			getListaProcesos().set(indice+1, objeto);
		}
		
		return ordenado;
	}
	
	
	public boolean listarProcesoBloqueado()
	{
		boolean bandera=false;
		int i = 0;
		int reiniciar = getBuffers().getListaProcesos().size();
		int cantidadProcesos = buffers.getListaProcesos().size();
		// Se Ordena: Si
		getBuffers().ordenarId();
		while (reiniciar > 0)
		{// Se saca procesos de Estado Bloqueado a:
			i = 0;
			while (i < cantidadProcesos)
			{
				if (getBuffers().interrupcionEyS(i))
				{
					// Estado de proceso a: Listo
					listarProcesoFIFO(desbloquearProceso(getBuffers().getListaProcesos().get(i).getIdProceso()));
					// Se saco un Proceso, entonces:
					cantidadProcesos--;
					i = getBuffers().getListaProcesos().size();
					bandera=true;
				}
				i++;
			}
			reiniciar--;
		}
		
		return bandera;
	}
	
	
	public boolean procesarProceso()
	{
		boolean bandera=false;
		// Se saca procesos de Estado Listo a:
		if (!getHilo().getEjecutando())
		{
			if (!getListo().getListaProcesos().isEmpty())
			{				
				bandera=ejecutarProceso(deslistarProcesoFIFO()); // Estado de proceso a: Ejecutando
			}
		}
		
		return bandera;
	}
	
	
	public boolean activador(Tabla[][] tabla, int columna)
	{
		boolean ejecutandoProceso=false;
		boolean bloquearProceso=true;
		boolean nuevoProceso=false;
		
		if (getHilo().getEjecutando())
		{
			ejecutandoProceso = getHilo().ejecutarInstrucción();
			// Se carga a la tabla estado E caso 1
			if (ejecutandoProceso && getHilo().getProceso().getDuracion().getInicioCPU() >= 0)
			{
				tabla[getHilo().getProceso().getIdProceso() - 1][columna].setEstado("E");
			}
			// Se carga a la tabla estado E caso 2
			if (ejecutandoProceso && getHilo().getProceso().getDuracion().getFinCPU() >= 0)
			{
				tabla[getHilo().getProceso().getIdProceso() - 1][columna].setEstado("E");
			}
			// Módulo Proceso Terminado:
			if (ejecutandoProceso && getHilo().getProceso().getDuracion().getInicioCPU() == -1 && getHilo().getProceso().getDuracion().getFinCPU() == -1)
			{
				// Estado de proceso a: Terminado
				tabla[getHilo().getProceso().getIdProceso() - 1][columna].setEstado("T");
				terminarProceso();
				bloquearProceso = false; // Se interrumpe trabajo del módulo Proceso Bloqueado 
				nuevoProceso=true;
			}
			// Módulo Proceso Bloqueado:
			if (bloquearProceso)
			{// NOTA: no tira error de hilo vacío cuidado con esta parte que puede ser causa errores por la id que traigo que es distinto que el index :) Revisar a futuro porque me daba error
				if (ejecutandoProceso && hilo.getProceso().getDuracion().getInicioCPU() == -1 &&
					hilo.getProceso().getDuracion().getFinCPU() == 
					traerProceso(hilo.getProceso().getIdProceso() - 1).getDuracion().getFinCPU())
				{
					// Estado de proceso a: Bloqueado
					bloquearProceso(terminarProceso());
					nuevoProceso=true;
				}
			}
		}
		return nuevoProceso;
	}
	
	
	public boolean ejecutarEyS(Tabla[][] tabla, int columna)
	{
		boolean run=false;
		
		if (!getBuffers().getListaProcesos().isEmpty())
		{
			for (Proceso proceso : getBuffers().getListaProcesos())
			{
				if (proceso.getDuracion().getEyS() > 0)
				{	// Se carga a la tabla estado B
					getBuffers().ejecutarEntradaSalida(proceso.getIdProceso());
					tabla[proceso.getIdProceso() - 1][columna].setEstado("B");
					run=true;
				}
			}
		}
		
		return run;
	}
	
	
	public boolean turnarProcesoFIFO()
	{
		boolean end=false;
		
		if (getHilo().getEjecutando())
		{
			Proceso objeto=getHilo().getProceso();
			
			int cpuInicio=objeto.getDuracion().getInicioCPU();
			int cpuFinal=objeto.getDuracion().getFinCPU();
			
			// Se saca proceso de Estado Ejecutando y lo paso según:
			if (cpuInicio > 0)
			{
				end=listarProcesoFIFO(terminarProceso()); //recibe true
			}
			if (!end)
			{
				if (cpuInicio < 0 && cpuFinal==traerProceso(hilo.getProceso().getIdProceso() - 1).getDuracion().getFinCPU())
				{
					end=bloquearProceso(terminarProceso()); //recibe true
				}
			}
			
			if (!end)
			{
				if (cpuInicio<0 && cpuFinal>=1)
				{
					end=listarProcesoFIFO(terminarProceso()); //recibe true
				}
			}
		}
		
		return end;
	}
	
	
	public boolean turnarProcesoLIFO()
	{
		boolean end=false;
		if (hilo.getEjecutando())
		{
			Proceso objeto=getHilo().getProceso();
			
			int cpuInicio=objeto.getDuracion().getInicioCPU();
			int cpuFinal=objeto.getDuracion().getFinCPU();
			// Se saca proceso de Estado Ejecutando y lo paso según:
			if (cpuInicio > 0)
			{
				end=listarProcesoLIFO(terminarProceso()); //recibe true
			}
			
			if (!end)
			{
				if (cpuInicio<0 && cpuFinal == traerProceso(getHilo().getProceso().getIdProceso() - 1).getDuracion().getFinCPU())
				{
					end=bloquearProceso(terminarProceso()); //recibe true
				}
			}
			
			if (!end)
			{
				if (cpuInicio<0 && cpuFinal>=1)
				{
					end=listarProcesoLIFO(terminarProceso()); //recibe true
				}
			}
		}
		
		return end;
	}

////////////////////////////////////////////////////////////NO APROPIATIVOS	
	
	public Tabla[][] planificarFIFO()
	{	
		List<Proceso> procesos = clone(getListaProcesos());
		Tabla[][] tabla = newTable();
		
		hilo.setEjecutando(false);

		int contador = procesos.size();

		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!procesos.isEmpty()) 
		{
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++)
			{
				// Se Realiza Turnos Rotativos: No				
				// Se pasa proceso a: Listo
				if (contador >= 0)
				{
					if (listarProcesoEntrada(procesos,columna))
					{
						contador--; // Se promueve Proceso: No						
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: No

				// Se saca un proceso de Listo a: Ejecutando
				procesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(tabla,columna))
				{
					procesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(tabla,columna);
					// Se reinicia quantum: No					
				}
				// Se resta Quantum: No
				
				// Se realiza E/S: Paralelo
				ejecutarEyS(tabla,columna);
			}// Fin del tiempo de la tabla 
		}
		
		return tabla;
	}
	
	
	public Tabla[][] planificarPrioridad()
	{
		// Preparo Datos
		List<Proceso> lista = clone(getListaProcesos());
		Tabla[][] tabla = newTable();
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contadores
		int contador = lista.size();
		
		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!lista.isEmpty())
		{
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++)
			{
				// Se Realiza Turnos Rotativos: No
				
				// Se pasa proceso a: Listo
				if (contador >= 0)
				{
					if (listarProcesoEntrada(lista,columna)) 
					{
						contador--;
						// Se promueve Proceso: No					
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: Si
				getListo().ordenarPrioridad(); /***Ordeno por Prioridad***/
				// Se saca un proceso de Listo a: Ejecutando
				procesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(tabla,columna))
				{
					procesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(tabla,columna);
					// Se reinicia quantum: No					
				}
				// Se resta Quantum: No				
				// Se realiza E/S: Paralelo
				ejecutarEyS(tabla,columna);
			}// Fin del tiempo de la tabla 
		}
		
		return tabla;
	}
	
	
	public Tabla[][] planificarSPN()
	{
		// Preparo Datos
		List<Proceso> lista = clone(getListaProcesos());
		Tabla[][] tabla = newTable();
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contadores
		int contador = lista.size();

		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!lista.isEmpty())
		{
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++)
			{
				// Se Realiza Turnos Rotativos: No
				
				// Se pasa proceso a: Listo
				if (contador >= 0) 
				{
					if (listarProcesoEntrada(lista,columna))
					{
						contador--; // Se promueve Proceso: No											
					}
				}
				
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: Si
				getListo().ordenarTiempoTotal(); /***Ordeno por Tiempo Total***/
				// Se saca un proceso de Listo a: Ejecutando
				procesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(tabla,columna))
				{
					procesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(tabla,columna);
					// Se reinicia quantum: No					
				}
				// Se resta Quantum: No				
				// Se realiza E/S: Paralelo
				ejecutarEyS(tabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return tabla;
	}
	
//////////////////////////////////////////////////////////// APROPIATIVOS
	
	
	public Tabla[][] planificarRoundRobin(int quantum)
	{
		// Preparo Datos
		List<Proceso> lista = clone(getListaProcesos());
		Tabla[][] tabla = newTable();
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contadores
		int contador = lista.size();
		int timeOut = quantum;
		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!lista.isEmpty())
		{
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++)
			{
				// Se Realiza Turnos Rotativos: Si
				if(timeOut==0)if(turnarProcesoFIFO())timeOut=quantum;
				// Se pasa proceso a: Listo
				if (contador >= 0)
				{
					if (listarProcesoEntrada(lista,columna))
					{
						contador--; // Se promueve Proceso: No						
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: NO

				// Se saca un proceso de Listo a: Ejecutando
				procesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(tabla,columna)) {
					procesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(tabla,columna);
					// Se reinicia quantum: Si
					timeOut=quantum;
				}
				// Se resta Quantum: Si
				timeOut--;
				// Se realiza E/S: Paralelo
				ejecutarEyS(tabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return tabla;
	}

	
	public Tabla[][] planificarPrioridadesApropiativos()
	{
		// Preparo Datos
		List<Proceso> lista = clone(getListaProcesos());
		Tabla[][] tabla = newTable();
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contadores
		int contador = lista.size();
		int timeOut = 1;
		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!lista.isEmpty())
		{
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++)
			{
				// Se Realiza Turnos Rotativos: Si
				if(timeOut==0)if(turnarProcesoLIFO())timeOut=1;
				// Se pasa proceso a: Listo
				if (contador >= 0)
				{
					if (listarProcesoEntrada(lista,columna))
					{
						contador--;// Se promueve Proceso: No						
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: Si
				getListo().ordenarPrioridad(); /***Ordeno por Prioridad***/
				// Se saca un proceso de Listo a: Ejecutando
				procesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(tabla,columna))
				{
					procesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(tabla,columna);
					// Se reinicia quantum: Si
					timeOut=1;
				}
				// Se resta Quantum: Si
				timeOut--;
				// Se realiza E/S: Paralelo
				ejecutarEyS(tabla,columna);
			}// Fin del tiempo de la tabla 
		}
		return tabla;
	}
	
	
	public Tabla[][] planificarSRT()
	{
		// Preparo Datos
		List<Proceso> lista = clone(getListaProcesos());
		Tabla[][] tabla = newTable();
		// Preparo el hilo 
		getHilo().setEjecutando(false);
		// Contadores
		int contador = lista.size();
		int timeOut = 1;
		// Si existen Procesos cargado entonces resuelvo algoritmo 
		if (!lista.isEmpty())
		{
			// Por toda la tabla agrego los estados 
			for (int columna = 0; columna < getCantidaColumnas(); columna++)
			{
				// Se Realiza Turnos Rotativos: Si
				if(timeOut==0)if(turnarProcesoLIFO())timeOut=1;
				// Se pasa proceso a: Listo
				if (contador >= 0)
				{
					if (listarProcesoEntrada(lista,columna))
					{
						contador--;
						// Se promueve Proceso: No						
					}
				}
				// Se pasa proceso Bloqueado a: Listo
				listarProcesoBloqueado();
				// Se Ordena: Si
				getListo().ordenarTiempoRestante(); /***Ordeno por Tiempo Restante***/
				// Se saca un proceso de Listo a: Ejecutando
				procesarProceso();
				// Se Revisa CPU y Ejecuto Proceso
				if (activador(tabla,columna))
				{
					procesarProceso(); // Caso de que se bloquea o termina Proceso anterior. Se saca un proceso de Listo a: Ejecutando
					activador(tabla,columna);
					// Se reinicia quantum: Si
					timeOut=1;
				}
				// Se resta Quantum: Si
				timeOut--;
				// Se realiza E/S: Paralelo
				ejecutarEyS(tabla,columna);
			}// Fin del tiempo de la tabla 
		}
		
		return tabla;
	}
	
}
