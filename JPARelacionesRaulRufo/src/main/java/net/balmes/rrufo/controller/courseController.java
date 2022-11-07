package net.balmes.rrufo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.balmes.rrufo.entity.course;
import net.balmes.rrufo.repositorio.courseRepositorio;

@RestController
@RequestMapping("JPARelaciones")
public class courseController {
	
	@Autowired
	courseRepositorio cursosRep;
	
	// Muestra los cursos por Id
	@GetMapping("curse/{id}")
	public course getCursosId(@PathVariable long id) {
		course cursos = cursosRep.findById(id).get();
		
		return cursos;
	}
	
	// Muestra todos los cursos
	@GetMapping("curse")
	public Iterable<course> getCursos() {
		
		return cursosRep.findAll();
	}
}
