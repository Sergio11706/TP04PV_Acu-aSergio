package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Docente;

@Controller
public class DocenteController {
	
	@Autowired
	Docente docente = new Docente();
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject("nuevoDocente", docente);
	
		return modelView;
	}
	
	@PostMapping("/guardarDocente")
	public ModelAndView setFormDocente(@ModelAttribute("nuevoDocente") Docente d) {
		
		ListadoDocentes.agregarDocente(d);
		
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
		
		return modelView;
	}
	
	@GetMapping("/eliminarDocente/{legajo}")
	public ModelAndView eliminarDocente(@PathVariable (name="legajo") int legajo) {
		
		ListadoDocentes.eliminarDocente(legajo);
		
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
		
		return modelView;
	}
	
	@GetMapping("/modificarDocente/{legajo}")
    public ModelAndView formModificarDocente(@PathVariable("legajo") int legajo) {
        Docente docente1 = ListadoDocentes.buscarDocente(legajo);

        ModelAndView modelView = new ModelAndView("modificarDocente");
        modelView.addObject("docenteModificado", docente1);
        
        return modelView;
    }

    @PostMapping("/modificarDocente")
    public ModelAndView modificarDocente(@ModelAttribute("docenteModificado") Docente d) {

        ListadoDocentes.modificarDocente(d);
        
        return mostrarLista();
    }
	
	@GetMapping("/listaDeDocentes")
	public ModelAndView mostrarLista() {
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("listadoDocentes", ListadoDocentes.listarDocentes());
	
		return modelView;
	}
	
}
