package com.uisrael.muestras.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
public class Solicitud implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSolicitud;
	private String numeroSolicitud;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaSolicitud;
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "fkPaciente")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "fkMedico")
	private Medico medico;
	@ManyToOne
	@JoinColumn(name = "fkPrueba")
	private Prueba prueba;

}
