package com.example.DM.dispositivoMedico.component;

import java.util.List;


import javax.servlet.http.HttpSession;


import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;



public interface DispositivoMedicoComponent {

	void saveDispositivoMedico(DispositivoMedicoDTO dm);
	

	List<DispositivoMedicoDTO> findByMatricolaComponent(String matricola);
	


	

	
	/**
	 * SERVIZI ESTERNI
	 */
	
	public String getDevice (HttpSession s);
	public String getSensors(HttpSession s);
	public String logIn(HttpSession s) ;
	public String logOut(HttpSession s) ;
	
	
}
