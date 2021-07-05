package com.example.DM.dispositivoMedico.component;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.DM.dispositivoMedico.account.dto.DispositivoMedicoAccountDTO;
import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.model.DispositivoMedico;
import com.example.DM.dispositivoMedico.paziente.model.Paziente;
import com.example.DM.dispositivoMedico.servizio.DispositivoMedicoServizio;
import com.example.DM.dispositivoMedico.servizio.dto.DispositivoMedicoServizioDTO;

public interface DispositivoMedicoComponent {

	void saveDispositivoMedico(DispositivoMedicoDTO dm);
	
	List<DispositivoMedicoDTO> findAllDevice();
	
	List<DispositivoMedicoDTO> findByMatricolaComponent(String matricola);
	
	List<DispositivoMedicoDTO> findByNomePaziente(String nome);
	//Andrea
	
	List<DispositivoMedicoServizioDTO> returnAllService();
	
	List<DispositivoMedicoServizio> createListAllService();
	
	List<DispositivoMedicoServizio> returnDinamicListAllService();
	
	//void handleContextRefresh(ContextRefreshedEvent event);
	
	boolean getUser(DispositivoMedicoAccountDTO dmaDTO);
	
	String setCookieTrue(HttpServletResponse response);
	String setCookieFalse(HttpServletResponse response);
	//boolean createCookie(boolean autentication);	
	
	List<DispositivoMedicoDTO> getDispByPaziente(String nomePZ);
	List<DispositivoMedicoDTO> getDispByOwner (String nomeOw);
	
	/**
	 * SERVIZI ESTERNI
	 */
	
	public String getDevice (HttpSession s);
	public String getSensors(HttpSession s);
	public String logIn(HttpSession s) ;
	public String logOut(HttpSession s) ;
	
	
}
