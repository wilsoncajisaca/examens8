package com.uisrael.muestras.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Medico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedico;
	private String nombreMedico;
	private String apellidoMedico;
	private String cedulaMedico;
	private String telefonoMedico;
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "fkDepartamento")
	private Departamento departamento;

	@OneToMany(mappedBy = "medico")
	@JsonIgnore
	private List<Solicitud> solicitudes = new ArrayList<>();

}
