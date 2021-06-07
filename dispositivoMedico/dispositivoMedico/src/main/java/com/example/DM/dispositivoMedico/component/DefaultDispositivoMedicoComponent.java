package com.example.DM.dispositivoMedico.component;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.DM.dispositivoMedico.dao.DispositivoMedicoDAO;
import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.mapper.CommonMapper;
import com.example.DM.dispositivoMedico.model.DispositivoMedico;

@Component
public class DefaultDispositivoMedicoComponent implements DispositivoMedicoComponent {
	
	
	@Autowired
	private DispositivoMedicoDAO dmDao;
	
	@Autowired
	private CommonMapper commonMapper;

	@Override
	public void saveDispositivoMedico(DispositivoMedicoDTO dm) {
		// TODO Auto-generated method stub
			
		DispositivoMedico oggettoDM  = commonMapper.map(dm);
		dmDao.save(oggettoDM);
		
	}

	@Override
	public List<DispositivoMedicoDTO> findAllDevice() {
		return dmDao.findAll()
				.stream()
				.map(commonMapper::map)
				.collect(toList());
	}

}
