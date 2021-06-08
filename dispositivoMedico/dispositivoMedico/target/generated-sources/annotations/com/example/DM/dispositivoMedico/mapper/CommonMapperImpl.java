package com.example.DM.dispositivoMedico.mapper;

import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.model.DispositivoMedico;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-08T14:37:24+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0-262 (OpenLogic-OpenJDK)"
)
@Component
public class CommonMapperImpl implements CommonMapper {

    @Override
    public DispositivoMedico map(DispositivoMedicoDTO dispDTO) {
        if ( dispDTO == null ) {
            return null;
        }

        DispositivoMedico dispositivoMedico = new DispositivoMedico();

        dispositivoMedico.setNomeDispositivo( dispDTO.getNomeDispositivo() );
        dispositivoMedico.setUnitaDiMisurazione( dispDTO.getUnitaDiMisurazione() );
        dispositivoMedico.setMisurazione( dispDTO.getMisurazione() );
        dispositivoMedico.setTimestamp( dispDTO.getTimestamp() );
        dispositivoMedico.setDataOperazione( dispDTO.getDataOperazione() );
        dispositivoMedico.setMatricola( dispDTO.getMatricola() );
        dispositivoMedico.setNomePaziente( dispDTO.getNomePaziente() );
        dispositivoMedico.setOwnerDispositivo( dispDTO.getOwnerDispositivo() );

        return dispositivoMedico;
    }

    @Override
    public DispositivoMedicoDTO map(DispositivoMedico disp) {
        if ( disp == null ) {
            return null;
        }

        DispositivoMedicoDTO dispositivoMedicoDTO = new DispositivoMedicoDTO();

        dispositivoMedicoDTO.setNomeDispositivo( disp.getNomeDispositivo() );
        dispositivoMedicoDTO.setUnitaDiMisurazione( disp.getUnitaDiMisurazione() );
        dispositivoMedicoDTO.setMisurazione( disp.getMisurazione() );
        dispositivoMedicoDTO.setTimestamp( disp.getTimestamp() );
        dispositivoMedicoDTO.setDataOperazione( disp.getDataOperazione() );
        dispositivoMedicoDTO.setMatricola( disp.getMatricola() );
        dispositivoMedicoDTO.setNomePaziente( disp.getNomePaziente() );
        dispositivoMedicoDTO.setOwnerDispositivo( disp.getOwnerDispositivo() );

        return dispositivoMedicoDTO;
    }
}
