package com.example.DM.dispositivoMedico.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DM.dispositivoMedico.account.dto.DispositivoMedicoAccountDTO;
import com.example.DM.dispositivoMedico.component.DispositivoMedicoComponent;
import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.servizio.dto.DispositivoMedicoServizioDTO;

@Service
@Transactional
public class DefaultDispositivoMedicoService implements DispositivoMedicoSevice {
	
	@Autowired
	private DispositivoMedicoComponent dmC;
	
	
	// cookie andrea
	//@Override
	//public boolean getCookie() {
		// TODO Auto-generated method stub
		//return false;
	//}

//	@Override
//	public boolean createCookie(boolean autentication) {
//		dmC.createCookie(autentication);
	//	return dmC.createCookie(autentication);
	//}
	
	

	@Override
	public void insertMisuraDispositivoMedico(DispositivoMedicoDTO dm) {
		dmC.saveDispositivoMedico(dm);
	}

	@Override
	public List<DispositivoMedicoDTO> findAll() {
		return dmC.findAllDevice();
	}
	
	@Override
	public List<DispositivoMedicoDTO> findByMatricola(String m){
		return dmC.findByMatricolaComponent(m);
	}
	

	@Override
	public List<DispositivoMedicoDTO> findByNomePaziente(String nome) {
		// TODO Auto-generated method stub
		return dmC.findByNomePaziente(nome);
	}

	//andrea
	
	@Override
	public List<DispositivoMedicoServizioDTO> returnAllService() {
		
		return dmC.returnAllService();
	}

	@Override
	public boolean getUser(DispositivoMedicoAccountDTO dmaDTO) {
		return dmC.getUser(dmaDTO);
	}

	@Override
	public String setCookieTrue(HttpServletResponse response) {
		
		return dmC.setCookieTrue(response);
	}

	@Override
	public String setCookieFalse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		return dmC.setCookieFalse(response);
	}

	@Override
	public List<DispositivoMedicoDTO> getDispByPaziente(String nomePZ) {
		
		return dmC.getDispByPaziente(nomePZ);
	}

	
	
	

	
	

	

}
