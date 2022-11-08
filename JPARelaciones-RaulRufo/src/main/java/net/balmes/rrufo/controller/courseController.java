package net.balmes.rrufo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.balmes.rrufo.entity.course;
import net.balmes.rrufo.error.apiError;
import net.balmes.rrufo.repositorio.courseRepositorio;


@RestController
@RequestMapping("JPARelaciones")
public class courseController {
	
	@Autowired
	courseRepositorio cursosRep;
	
	// Muestra los cursos por Id
	@GetMapping("cursos/{id}")
	public course getCursosId(@PathVariable long id) {
		course cursos = cursosRep.findById(id).get();
		
		return cursos;
	}
	
	// Muestra todos los cursos
	@GetMapping("cursos")
	public Iterable<course> getCursos() {
		
		return cursosRep.findAll();
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
