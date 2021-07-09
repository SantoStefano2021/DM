package com.example.DM.dispositivoMedico.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.model.DispositivoMedico;



public interface DispositivoMedicoSevice {
	

		 void insertMisuraDispositivoMedico( DispositivoMedicoDTO dm );
		 

		 List<DispositivoMedicoDTO> findByMatricola(String m);
		 

		/**
		 * CHIAMATE ESTERNE
		 */
		public String logIn(HttpSession s);
		public String getSensors(HttpSession s);
		public String getDevice (HttpSession s);
		public String logOut(HttpSession s) ;
}
