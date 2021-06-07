package com.example.DM.dispositivoMedico.component;

import java.util.List;

import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;

public interface DispositivoMedicoComponent {

	void saveDispositivoMedico(DispositivoMedicoDTO dm);
	
	List<DispositivoMedicoDTO> findAllDevice();
}
