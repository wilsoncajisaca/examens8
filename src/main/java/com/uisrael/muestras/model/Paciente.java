package com.uisrael.muestras.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Paciente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPaciente;
	private String nombrePaciente;
	private String apellidoPaciente;
	private String cedulaPaciente;
	private String historiaPaciente;
	private String direccionPaciente;
	private String telefonoMedico;
	private boolean estado;

	@OneToMany(mappedBy = "paciente")
	private List<Solicitud> solicitudes = new ArrayList<>();
}
