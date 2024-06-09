package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;


@Controller
public class MateriaController {

	@Autowired
	Materia materia = new Materia();
	
	@Autowired
	Docente docente = new Docente();
	
	@Autowired
	Carrera carrera = new Carrera();
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		
		ModelAndView modelView = new ModelAndView("formMateria");
		
		modelView.addObject("nuevaMateria", materia);
		modelView.addObject("carreras", ListadoCarreras.listarCarreras());
		modelView.addObject("docentes", ListadoDocentes.listarDocentes());
		
		return modelView;
	}
	
	@PostMapping("/guardarMateria")
	public ModelAndView setFormMateria(@ModelAttribute("nuevaMateria") Materia m) {
		
		docente = ListadoDocentes.buscarDocente(m.getDocente().getLegajo());
		carrera = ListadoCarreras.buscarCarrera(m.getCarrera().getCodigo());
		
		m.setCarrera(carrera);
		m.setDocente(docente);
		
		ListadoMaterias.agregarMateria(m);
		
		return mostrarLista();
	}
	
	@GetMapping("/eliminarMateria/{codigo}")
	public ModelAndView eliminarMateria(@PathVariable (name="codigo") String cod) {
		
		ListadoMaterias.eliminarMateria(cod);
		
		return mostrarLista();
	}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView formModificarMateria(@PathVariable("codigo") String cod) {
		materia = ListadoMaterias.buscarMateria(cod);
		
		ModelAndView modelView = new ModelAndView("modificarMateria");
		
		modelView.addObject("materiaModificada", materia);
		modelView.addObject("carreras", ListadoCarreras.listarCarreras());
		modelView.addObject("docentes", ListadoDocentes.listarDocentes());
		
		return modelView;
	}
	
	@PostMapping("/modificarMateria")
	public ModelAndView modificarMateria(@ModelAttribute("materiaModificada") Materia m) {
		
		docente = ListadoDocentes.buscarDocente(m.getDocente().getLegajo());
		carrera = ListadoCarreras.buscarCarrera(m.getCarrera().getCodigo());
		
		m.setCarrera(carrera);
		m.setDocente(docente);
		
		ListadoMaterias.modificarMateria(m);
		
		return mostrarLista();
	}
	
	@GetMapping("/listaDeMaterias")
	public ModelAndView mostrarLista() {
		
		ModelAndView modelView = new ModelAndView("listaDeMaterias");
		modelView.addObject("listadoMaterias", ListadoMaterias.listarMaterias());
	
		return modelView;
	}
	
}
