package net.balmes.rrufo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.balmes.rrufo.entity.Course;
import net.balmes.rrufo.error.apiError;
import net.balmes.rrufo.repositorio.courseMaterialRepositorio;
import net.balmes.rrufo.repositorio.courseRepositorio;


@RestController
@RequestMapping("JPARelaciones")
public class courseController {
	
	@Autowired
	courseRepositorio cursosRep;
	courseMaterialRepositorio cursosMaterialRep;
	
	// Muestra los cursos por Id
	@GetMapping("cursos/{id}")
	public Course getCursosId(@PathVariable long id) {
		Course cursos = cursosRep.findById(id).get();
		System.out.println("Eager o Lazy");
		return cursos;
	}
	
	// Muestra todos los cursos
	@GetMapping("cursos")
	public Iterable<Course> getCursos() {
		return cursosRep.findAll();
	}
	
	// Elimina curso y material por Id OPCION 1
	@DeleteMapping("curso/delete/Curso-y-Material{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCursoyMaterialById(@PathVariable("id") long id) {
		cursosRep.deleteById(id);
		cursosMaterialRep.deleteById(id);
	}
		
	// Elimina curso por Id OPCION 2
	@DeleteMapping("curso/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") long id) {
	    cursosRep.deleteById(id);
	}
	        
	//Control del error
	@ExceptionHandler(Exception.class)
	public ResponseEntity<apiError> handlecourseNoEncontrado(Exception ex){
		
		apiError apierror = new apiError();
		apierror.setEstado(HttpStatus.NOT_FOUND);
		apierror.setFecha(LocalDateTime.now());
		apierror.setMensaje(ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apierror);
	}
}
