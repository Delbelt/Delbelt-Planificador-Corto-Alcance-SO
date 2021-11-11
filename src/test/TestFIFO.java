package test;

import datos.Prioridad;
import negocio.ProcesamientoABM;
import negocio.TablaProcesosABM;

public class TestFIFO {

	public static void main(String[] args) {
		
		ProcesamientoABM admP1 = new ProcesamientoABM(20, 38);

		admP1.agregarProceso("P1", 1, 3, 2, 4, Prioridad.Media);
		admP1.agregarProceso("P2", 2, 2, 3, 2, Prioridad.Baja);
		admP1.agregarProceso("P3", 4, 4, 2, 1, Prioridad.Alta);
		admP1.agregarProceso("P4", 6, 1, 1, 1, Prioridad.Media);

		System.out.println("----------- Planificador FIFO -----------");
		System.out.println(admP1.mostrarPlanificador(admP1.planificarFIFO()));
		System.out.println(admP1.mostrarProcesos() + "\n-> hay 1 procesador" + "\n-> E/S Se realiza en paralelo\n");
		
		System.out.println("----------- Resultados FIFO -----------");
		TablaProcesosABM admTP = new TablaProcesosABM(admP1);
		System.out.println(admTP.mostrarResultados(admP1.planificarFIFO()));
	}

}
