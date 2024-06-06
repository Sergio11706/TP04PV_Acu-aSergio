package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.model.Materia;


@Controller
public class MateriaController {

	@Autowired
	Materia materia = new Materia();
	
	@GetMapping("/formularioMateria")
	public ModelAndView getFormMateria() {
		ModelAndView modelView = new ModelAndView("formMateria");
		modelView.addObject("nuevaMateria", materia);
	
		return modelView;
	}
	
	@PostMapping("/guardarMateria")
	public ModelAndView setFormMateria(@ModelAttribute("nuevaMateria") Materia m) {
		
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
		Materia materia1 = ListadoMaterias.buscarMateria(cod);
		
		ModelAndView modelView = new ModelAndView("modificarMateria");
		modelView.addObject("materiaModificada", materia1);
	
		return modelView;
	}
	
	@PostMapping("/modificarMateria")
	public ModelAndView modificarMateria(@ModelAttribute("materiaModificada") Materia m) {
		
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
