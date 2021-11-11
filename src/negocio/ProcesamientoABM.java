package negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import datos.Buffer;
import datos.Hilo;
import datos.Listo;
import datos.Proceso;
import datos.Tabla;

public class ProcesamientoABM {
	
	//FALTAN METODOS
	
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
	public String toString() {
		return "ProcesamientoABM [listaProcesos=" + listaProcesos + ", cantidadFilas=" + cantidadFilas
				+ ", cantidaColumnas=" + cantidaColumnas + ", tabla=" + Arrays.toString(tabla) + ", hilo=" + hilo
				+ ", buffers=" + buffers + ", listo=" + listo + "]";
	}	
}
