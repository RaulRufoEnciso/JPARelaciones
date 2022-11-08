package net.balmes.rrufo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.balmes.rrufo.entity.courseMaterial;
import net.balmes.rrufo.repositorio.courseMaterialRepositorio;

import net.balmes.rrufo.error.apiError;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
@RequestMapping("JPARelaciones")
public class courseMaterialController {
	
	@Autowired
	courseMaterialRepositorio cursosMaterialRep;
	
	// Muestra los cursos por Id
	@GetMapping("cursosMaterial/{id}")
	public courseMaterial getCursosMaterialId(@PathVariable long id) {
		courseMaterial cursosMaterial = cursosMaterialRep.findById(id).get();
		
		return cursosMaterial;
	}
	
	// Muestra todos los cursos
	@GetMapping("cursosMaterial")
	public Iterable<courseMaterial> getCursosMaterial() {
		
		return cursosMaterialRep.findAll();
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
