package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Materia;

public class ListadoMaterias {
	
	public static List<Materia> materias = new ArrayList<Materia>();

	public static List<Materia> listarMaterias(){
		
		Predicate<Materia> activo = n -> n.getCodigo()!="-1";
		List<Materia> materiasActivas = materias.stream().filter(activo).collect(Collectors.toList());
		
		return materiasActivas;
	}

	public static Materia buscarMateria(String cod) {
		for(Materia i : materias) {
			if(i.getCodigo().equals(cod)) return i;
		}
		return null;
	}

	public static void agregarMateria(Materia m) {		
		materias.add(m);
	}
	
	public static void modificarMateria(Materia m) {		
		for (int i = 0; i < materias.size(); i++) {
	        Materia materia = materias.get(i);
	        if (materia.getCodigo().equals(m.getCodigo())) {
	            materias.set(i, m);
	            break;
	        }
	    }
	}
	
	public static void eliminarMateria(String cod) {
		for(Materia i : materias) {
			if(i.getCodigo().equals(cod)) {
				i.setCodigo("-1");
				break;
			}
		}
	}
	
}
