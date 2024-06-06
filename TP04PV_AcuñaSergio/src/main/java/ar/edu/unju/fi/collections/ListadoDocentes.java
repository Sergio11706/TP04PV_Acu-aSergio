package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
	
	public static List<Docente> docentes = new ArrayList<Docente>();
	
	
	public static List<Docente> listarDocentes(){
		Predicate<Docente> activo = n -> n.getLegajo()!=-1;
		List<Docente> docentesActivos = docentes.stream().filter(activo).collect(Collectors.toList());
		
		return docentesActivos;
	}
	
	public static Docente buscarDocente(int legajo) {
		for(Docente i : docentes) {
			if(i.getLegajo()==legajo) return i;
		}
		return null;
	}
	
	public static void agregarDocente(Docente d) {
		docentes.add(d);
	}
	
	public static void modificarDocente(Docente d) {
		for (int i = 0; i < docentes.size(); i++) {
	        Docente docente = docentes.get(i);
	        if (docente.getLegajo() == d.getLegajo()) {
	            docentes.set(i, d);
	            break;
	        }
	    }
	}
	
	public static void eliminarDocente(int legajo) {
		for(Docente i : docentes) {
			if(i.getLegajo()==legajo) {
				i.setLegajo(-1);
				break;
			}
		}
	}
}
