package com.uisrael.muestras.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uisrael.muestras.model.Medico;
import com.uisrael.muestras.repository.IMedicoRepository;
import com.uisrael.muestras.service.IMedicoService;

@Service
@Component
public class MedicoServiceImpl implements IMedicoService {

	@Autowired
	private IMedicoRepository repo;

	@Override
	public void insertarMedico(Medico nuevoMedico) {
		repo.save(nuevoMedico);
	}

	@Override
	public void actualizarMedico(Medico actualizaMedico) {
		repo.save(actualizaMedico);

	}

	@Override
	public List<Medico> listarMedico() {
		return repo.findAll();
	}

	@Override
	public Medico buscarMedico(int id) {
		return repo.findById(id).get();
	}

	@Override
	public void eliminarMedico(int id) {
		repo.deleteById(id);
	}

}
