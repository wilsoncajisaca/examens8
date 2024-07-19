package com.uisrael.muestras.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Departamento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepartamento;
	private String nombreDepartamento;
	private String areaDepartamento;
	private boolean estado;

	@OneToMany(mappedBy = "departamento")
	@JsonIgnore
	private List<Medico> listaMedico = new ArrayList<>();
}
