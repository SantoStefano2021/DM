package com.example.DM.dispositivoMedico.mapper;

import org.mapstruct.Mapper;

import com.example.DM.dispositivoMedico.account.DispositivoMedicoAccount;
import com.example.DM.dispositivoMedico.account.dto.DispositivoMedicoAccountDTO;
import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.model.DispositivoMedico;
import com.example.DM.dispositivoMedico.servizio.DispositivoMedicoServizio;
import com.example.DM.dispositivoMedico.servizio.dto.DispositivoMedicoServizioDTO;

@Mapper(componentModel = "spring")
public interface CommonMapper {

	DispositivoMedico map(DispositivoMedicoDTO dispDTO);

	DispositivoMedicoDTO map(DispositivoMedico disp);
	
	DispositivoMedicoServizioDTO map (DispositivoMedicoServizio dmS);
	
	DispositivoMedicoAccountDTO map (DispositivoMedicoAccount dispAcc);
}
