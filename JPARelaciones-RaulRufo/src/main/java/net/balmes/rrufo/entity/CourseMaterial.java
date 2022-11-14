package net.balmes.rrufo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CourseMaterial")
public class CourseMaterial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 
	private String url;
	/*
	@OneToOne
	private Course Course;
	*/
	/*
	@ManyToOne
	private Course course;
	*/
	/*
	@ManyToOne(cascade = )
	@JsonIgnore
	private Course course;
	*/
	/*
	@ManyToOne(fetch = )
	@JsonIgnore
	private Course course;
	*/
	
	@ManyToOne(optional = )
	@JsonIgnore
	private Course course;
	
	/*
	@ManyToOne(targetEntity = )
	@JsonIgnore
	private Course course;
	*/
}

