package net.balmes.rrufo.error;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class apiError {
	
	private HttpStatus estado;
	@JsonFormat(shape = Shape.STRING, pattern ="dd/MM/yy hh:mm:ss")
	private LocalDateTime fecha;
	private String mensaje;
}
