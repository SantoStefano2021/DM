package com.example.DM.dispositivoMedico.service;

import java.util.List;

import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;

public interface DispositivoMedicoSevice {

		 void insertMisuraDispositivoMedico( DispositivoMedicoDTO dm );
		 
		 List<DispositivoMedicoDTO> findAll();
		 
		 List<DispositivoMedicoDTO> findByMatricola(String m);
}
