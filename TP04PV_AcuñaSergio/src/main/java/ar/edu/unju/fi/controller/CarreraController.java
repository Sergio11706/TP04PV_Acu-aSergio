package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarreras;
import ar.edu.unju.fi.model.Carrera;

@Controller
public class CarreraController {
	
	@Autowired
	Carrera carrera = new Carrera();
	
	@GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera", carrera);
	
		return modelView;
	}
	
	@PostMapping("/guardarCarrera")
	public ModelAndView setFormCarrera(@ModelAttribute("nuevaCarrera") Carrera c) {
		
		ListadoCarreras.agregarCarrera(c);
		
		return mostrarLista();
	}
	
	@GetMapping("/eliminarCarrera/{codigo}")
	public ModelAndView eliminarCarrera(@PathVariable (name="codigo") String cod) {
		
		ListadoCarreras.eliminarCarrera(cod);
		
		return mostrarLista();
	}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView formModificarCarrera(@PathVariable("codigo") String cod) {
		carrera = ListadoCarreras.buscarCarrera(cod);
		
		ModelAndView modelView = new ModelAndView("modificarCarrera");
		modelView.addObject("carreraModificada", carrera);
	
		return modelView;
	}
	
	@PostMapping("/modificarCarrera")
	public ModelAndView modificarCarrera(@ModelAttribute("carreraModificada") Carrera c) {
		
		ListadoCarreras.modificarCarrera(c);
		
		return mostrarLista();
	}
	
	@GetMapping("/listaDeCarreras")
	public ModelAndView mostrarLista() {
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras", ListadoCarreras.listarCarreras());
	
		return modelView;
	}
}
