package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Materia {
	
	private String codigo;
	private String nombre;
	private String curso;
	private String codCarrera;
	private String modalidad;
	private int legajoDocente;
	
	public Materia() {
		// TODO Auto-generated constructor stub
	}
	
	public Materia(String codigo, String nombre, String curso, String carrera, String modalidad, int docente) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.codCarrera = carrera;
		this.modalidad = modalidad;
		this.legajoDocente = docente;
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

	public String getCodCarrera() {
		return codCarrera;
	}

	public void setCodCarrera(String carrera) {
		this.codCarrera = carrera;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public int getLegajoDocente() {
		return legajoDocente;
	}

	public void setLegajoDocente(int docente) {
		this.legajoDocente = docente;
	}

	
	
}
