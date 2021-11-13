package testApropiativo;

import datos.Prioridad;
import negocio.ProcesamientoABM;
import negocio.TablaProcesosABM;

public class TestApropiativo {

	public static void main(String[] args) {
		
		ProcesamientoABM pABM = new ProcesamientoABM(20, 38);

		pABM.agregarProceso("P1", 1, 3, 2, 4, Prioridad.Media);
		pABM.agregarProceso("P2", 2, 2, 3, 2, Prioridad.Baja);
		pABM.agregarProceso("P3", 4, 4, 2, 1, Prioridad.Alta);
		pABM.agregarProceso("P4", 6, 1, 1, 1, Prioridad.Media);

		System.out.println("----------- Planificador Prioridad Apropiativo -----------");
		System.out.println(pABM.mostrarPlanificador(pABM.planificarPrioridadesApropiativos()));
		System.out.println(pABM.mostrarProcesos() + "\n-> hay 1 procesador" + "\n-> E/S Se realiza en paralelo\n");
		
		System.out.println("----------- Resultados Prioridad Apropiativo -----------");
		TablaProcesosABM tABM = new TablaProcesosABM(pABM);
		System.out.println(tABM.mostrarResultados(pABM.planificarPrioridadesApropiativos()));
	}

}
