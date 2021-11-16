package testHibrido;

import datos.Prioridad;
import negocio.ProcesamientoABM;
import negocio.TablaProcesosABM;

public class TestIndominus {

	public static void main(String[] args) {		
		
		ProcesamientoABM pABM = new ProcesamientoABM(20, 38);
		
		pABM.agregarProceso("P1", 1, 4, 6, 6, Prioridad.Media);
		pABM.agregarProceso("P2", 2, 3, 5, 1, Prioridad.Baja);
		pABM.agregarProceso("P3", 3, 4, 3, 4, Prioridad.Alta);
		pABM.agregarProceso("P4", 4, 4, 2, 3, Prioridad.Media);

		System.out.println("----------- Planificador Indominus -----------");
		System.out.println(pABM.mostrarPlanificador(pABM.planificarIndominus()));
		System.out.println(pABM.mostrarProcesos() + "\n-> hay 1 procesador" + "\n-> E/S Se realiza en paralelo\n");
		
		System.out.println("----------- Resultados Indominus -----------");
		TablaProcesosABM tABM = new TablaProcesosABM(pABM);
		System.out.println(tABM.mostrarResultados(pABM.planificarIndominus()));
	}
	
}
