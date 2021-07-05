package com.example.DM.dispositivoMedico.mapper;

import org.mapstruct.Mapper;

import com.example.DM.dispositivoMedico.account.DispositivoMedicoAccount;
import com.example.DM.dispositivoMedico.account.dto.DispositivoMedicoAccountDTO;
import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.model.DispositivoMedico;
import com.example.DM.dispositivoMedico.servizio.DispositivoMedicoServizio;
import com.example.DM.dispositivoMedico.servizio.dto.DispositivoMedicoServizioDTO;
import org.mapstruct.Mapping;

//mapstract libreria esterna
//è una classe di mapper--spring è un bean che mi devi gestire registrare la classe all'interno del contesto
@Mapper(componentModel = "spring")
public interface CommonMapper {

	//oggetto target 		source
	DispositivoMedico map(DispositivoMedicoDTO dispDTO);


//@Mapping(source = " disp.calciatore.nome" , target = "nomeCalciatore")

	DispositivoMedicoDTO map(DispositivoMedico disp);
	
	DispositivoMedicoServizioDTO map(DispositivoMedicoServizio dmS);
	
	DispositivoMedicoAccountDTO map(DispositivoMedicoAccount dispAcc);
}
