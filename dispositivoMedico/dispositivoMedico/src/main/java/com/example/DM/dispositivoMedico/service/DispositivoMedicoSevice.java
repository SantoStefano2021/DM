package com.example.DM.dispositivoMedico.service;

import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;

import java.util.List;

import javax.servlet.http.HttpSession;


public interface DispositivoMedicoSevice {
	

		 void insertMisuraDispositivoMedico( DispositivoMedicoDTO dm );

		 List<DispositivoMedicoDTO> findAll() ;

		 

		 List<DispositivoMedicoDTO> findByMatricola(String m);
		 

		/**
		 * CHIAMATE ESTERNE
		 */
		public String logIn(HttpSession s);
		public String getSensors(HttpSession s);
		public String getDevice (HttpSession s);
		public String logOut(HttpSession s) ;
}
