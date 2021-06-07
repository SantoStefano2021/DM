package com.example.DM.dispositivoMedico.mapper;

import org.mapstruct.Mapper;

import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.model.DispositivoMedico;

@Mapper(componentModel = "spring")
public interface CommonMapper {

	DispositivoMedico map(DispositivoMedicoDTO dispDTO);

	DispositivoMedicoDTO map(DispositivoMedico disp);
}
