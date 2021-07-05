package com.example.DM.dispositivoMedico.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.DM.dispositivoMedico.account.dto.DispositivoMedicoAccountDTO;
import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.model.DispositivoMedico;
import com.example.DM.dispositivoMedico.servizio.dto.DispositivoMedicoServizioDTO;


public interface DispositivoMedicoSevice {
	

		 void insertMisuraDispositivoMedico( DispositivoMedicoDTO dm );
		 
		 List<DispositivoMedicoDTO> findAll();
		 
		 List<DispositivoMedicoDTO> findByMatricola(String m);
		 
		 List<DispositivoMedicoDTO> findByNomePaziente(String nome);
		 
		 List<DispositivoMedicoServizioDTO> returnAllService();
		 
		 
		 
		// void handleContextRefresh(ContextRefreshedEvent event);
		 
		// public void getAllDinamicService(ContextRefreshedEvent event);
		 
		 
		boolean getUser(DispositivoMedicoAccountDTO dmaDTO);
		String setCookieTrue(HttpServletResponse response);
		String setCookieFalse(HttpServletResponse response);
		
		
		List<DispositivoMedicoDTO> getDispByPaziente(String nomePZ);
		List<DispositivoMedicoDTO> getDispByOwner (String nomeOw);
	//	boolean getCookie();
	//	boolean createCookie(boolean autentication);
		
		/**
		 * CHIAMATE ESTERNE
		 */
		public String logIn(HttpSession s);
		public String getSensors(HttpSession s);
		public String getDevice (HttpSession s);
		public String logOut(HttpSession s) ;
}
