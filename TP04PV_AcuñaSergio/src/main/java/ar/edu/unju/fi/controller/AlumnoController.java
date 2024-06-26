package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumnos;
import ar.edu.unju.fi.model.Alumno;

@Controller
public class AlumnoController {
	
	@Autowired
	Alumno alumno = new Alumno();
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		ModelAndView modelView = new ModelAndView("formAlumno");
		modelView.addObject("nuevoAlumno", alumno);
	
		return modelView;
	}
	
	@PostMapping("/guardarAlumno")
	public ModelAndView setFormAlumno(@ModelAttribute("nuevoAlumno") Alumno a) {
		
		ListadoAlumnos.agregarAlumno(a);
		
		return mostrarLista();
	}
	
	@GetMapping("/eliminarAlumno/{dni}")
	public ModelAndView eliminarAlumno(@PathVariable (name="dni") String dni) {
		
		ListadoAlumnos.eliminarAlumno(dni);
		
		return mostrarLista();
	}
	
	@GetMapping("/modificarAlumno/{dni}")
	public ModelAndView formModificarAlumnoa(@PathVariable("dni") String dni) {
		alumno = ListadoAlumnos.buscarAlumno(dni);
		
		ModelAndView modelView = new ModelAndView("modificarAlumno");
		modelView.addObject("alumnoModificado", alumno);
	
		return modelView;
	}
	
	@PostMapping("/modificarAlumno")
	public ModelAndView modificarAlumno(@ModelAttribute("alumnoModificado") Alumno a) {
		
		ListadoAlumnos.modificarAlumno(a);
		
		return mostrarLista();
	}
	
	@GetMapping("/listaDeAlumnos")
	public ModelAndView mostrarLista() {
		ModelAndView modelView = new ModelAndView("listaDeAlumnos");
		modelView.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());
	
		return modelView;
	}
}
