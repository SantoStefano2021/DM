package com.example.DM.dispositivoMedico.mapper;

import com.example.DM.dispositivoMedico.account.DispositivoMedicoAccount;
import com.example.DM.dispositivoMedico.account.dto.DispositivoMedicoAccountDTO;
import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.model.DispositivoMedico;
import com.example.DM.dispositivoMedico.servizio.DispositivoMedicoServizio;
import com.example.DM.dispositivoMedico.servizio.dto.DispositivoMedicoServizioDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-16T17:35:19+0200",
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
        dispositivoMedicoDTO.setOwnerDispositivo( disp.getOwnerDispositivo() );

        return dispositivoMedicoDTO;
    }

    @Override
    public DispositivoMedicoServizioDTO map(DispositivoMedicoServizio dmS) {
        if ( dmS == null ) {
            return null;
        }

        DispositivoMedicoServizioDTO dispositivoMedicoServizioDTO = new DispositivoMedicoServizioDTO();

        dispositivoMedicoServizioDTO.setNome( dmS.getNome() );
        dispositivoMedicoServizioDTO.setDescrizione( dmS.getDescrizione() );
        dispositivoMedicoServizioDTO.setRitorno( dmS.getRitorno() );
        dispositivoMedicoServizioDTO.setArgomenti( dmS.getArgomenti() );

        return dispositivoMedicoServizioDTO;
    }

    @Override
    public DispositivoMedicoAccountDTO map(DispositivoMedicoAccount dispAcc) {
        if ( dispAcc == null ) {
            return null;
        }

        DispositivoMedicoAccountDTO dispositivoMedicoAccountDTO = new DispositivoMedicoAccountDTO();

        dispositivoMedicoAccountDTO.setUsername( dispAcc.getUsername() );
        dispositivoMedicoAccountDTO.setPassword( dispAcc.getPassword() );

        return dispositivoMedicoAccountDTO;
    }
}
