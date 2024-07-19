package com.uisrael.muestras.service;

import java.util.List;

import com.uisrael.muestras.model.Medico;

public interface IMedicoService {
	public void insertarMedico(Medico nuevoMedico);
	public void actualizarMedico(Medico actualizaMedico);
	public List<Medico> listarMedico();
	public Medico buscarMedico(int id);
	public void eliminarMedico(int id);

}
