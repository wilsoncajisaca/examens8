package com.uisrael.muestras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.muestras.model.Paciente;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {

}
