package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Alumno;

public class ListadoAlumnos {

	public static List<Alumno> alumnos = new ArrayList<Alumno>();

	public static List<Alumno> listarAlumnos(){
		
		Predicate<Alumno> activo = n -> n.getDni()!="-1";
		List<Alumno> alumnosActivos = alumnos.stream().filter(activo).collect(Collectors.toList());
		
		return alumnosActivos;
	}

	public static Alumno buscarAlumno(String dni) {
		for(Alumno i : alumnos) {
			if(i.getDni().equals(dni)) return i;
		}
		return null;
	}

	public static void agregarAlumno(Alumno a) {		
		alumnos.add(a);
	}
	
	public static void modificarAlumno(Alumno a) {		
		for (int i = 0; i < alumnos.size(); i++) {
	        Alumno alumno = alumnos.get(i);
	        if (alumno.getDni().equals(a.getDni())) {
	            alumnos.set(i, a);
	            break;
	        }
	    }
	}
	
	public static void eliminarAlumno(String dni) {
		for(Alumno i : alumnos) {
			if(i.getDni().equals(dni)) {
				i.setDni("-1");
				break;
			}
		}
	}
	
}
