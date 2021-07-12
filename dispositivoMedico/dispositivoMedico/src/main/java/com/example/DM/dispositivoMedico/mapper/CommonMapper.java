package com.example.DM.dispositivoMedico.mapper;

import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import org.mapstruct.Mapper;


import com.example.DM.dispositivoMedico.model.DispositivoMedico;

//mapstract libreria esterna
//è una classe di mapper--spring è un bean che mi devi gestire registrare la classe all'interno del contesto
@Mapper(componentModel = "spring")
public interface CommonMapper {

	//oggetto target 		source
	DispositivoMedico map(DispositivoMedicoDTO dispDTO);


//@Mapping(source = " disp.calciatore.nome" , target = "nomeCalciatore")

	DispositivoMedicoDTO map(DispositivoMedico disp);

}
