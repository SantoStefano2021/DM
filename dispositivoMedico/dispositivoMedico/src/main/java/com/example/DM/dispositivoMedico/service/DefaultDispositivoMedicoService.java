package com.example.DM.dispositivoMedico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DM.dispositivoMedico.component.DispositivoMedicoComponent;
import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;

@Service
@Transactional
public class DefaultDispositivoMedicoService implements DispositivoMedicoSevice {
	
	@Autowired
	private DispositivoMedicoComponent dmC;

	@Override
	public void insertMisuraDispositivoMedico(DispositivoMedicoDTO dm) {
		dmC.saveDispositivoMedico(dm);
	}

	@Override
	public List<DispositivoMedicoDTO> findAll() {
		return dmC.findAllDevice();
	}
	
	@Override
	public List<DispositivoMedicoDTO> findByMatricola(String m){
		return dmC.findByMatricola(m);
	}

}
