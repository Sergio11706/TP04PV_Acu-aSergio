package ar.edu.unju.fi.model;

import ar.edu.unju.fi.constantes.Modalidad;

public class Materia {
	
	private String codigo;
	private String nombre;
	private String curso;
	private Carrera carrera;
	private Modalidad modalidad;
	private Docente docente;
	
	public Materia(String codigo, String nombre, String curso, Carrera carrera, Modalidad modalidad, Docente docente) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.carrera = carrera;
		this.modalidad = modalidad;
		this.docente = docente;
	}

	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	
	
}
