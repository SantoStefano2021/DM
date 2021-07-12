package com.example.DM.dispositivoMedico.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DM.dispositivoMedico.component.DispositivoMedicoComponent;


@Service
@Transactional
public class DefaultDispositivoMedicoService implements DispositivoMedicoSevice {
	
	@Autowired
	private DispositivoMedicoComponent dmC;


	@Override
	public List<DispositivoMedicoDTO> findAll() {
		return dmC.findAllDevice();
	}

	@Override
	public void insertMisuraDispositivoMedico(DispositivoMedicoDTO dm) {
		dmC.saveDispositivoMedico(dm);
	}




	@Override
	public List<DispositivoMedicoDTO> findByMatricola(String m){
		return dmC.findByMatricolaComponent(m);
	}
	



	//andrea
	




	@Override
	public String logIn(HttpSession s) {
		// TODO Auto-generated method stub
		return dmC.logIn(s);
	}

	@Override
	public String getSensors(HttpSession s) {
		// TODO Auto-generated method stub
		return dmC.getSensors(s);
	}

	@Override
	public String getDevice(HttpSession s) {
		// TODO Auto-generated method stub
		return dmC.getDevice(s);
	}

	@Override
	public String logOut(HttpSession s) {
		// TODO Auto-generated method stub
		return dmC.logOut(s);
	}

	
	
	

	
	

	

}
