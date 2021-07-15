package com.example.DM.dispositivoMedico.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DM.dispositivoMedico.service.DispositivoMedicoSevice;


@CrossOrigin(origins = "http://localhost:4200")
// la risposta va direttamente nel body
@RestController
@RequestMapping("/private")
public class DispositivoMedicoController extends Session {

	/**
	 * iniezione
	 */
	@Autowired
	DispositivoMedicoSevice dmS;


	@GetMapping("/findAll")
	public List<DispositivoMedicoDTO> findAll() {

		return dmS.findAll();


	}


	// chi fa l'iniezione (Container, apllication context )
	//bean





	/**
	 *
	 * @param dmDTO
	 */
	@PostMapping("/insert")
	public void insertDispositivoMedico(@RequestBody  @Valid() DispositivoMedicoDTO dmDTO  ) {
		dmS.insertMisuraDispositivoMedico(dmDTO);
	}



	@GetMapping("/logIn")
	public String logIn(HttpSession s) {
		return dmS.logIn(s);
	}
	
	@PostMapping("/logOut")
	public String logOut (HttpSession s) {
		return dmS.logOut(s);
	
	}

	@GetMapping("/getSensors")
	public String getSensors(HttpSession s) {
		
		return dmS.getSensors(s);

		
	}
	
	@GetMapping("/getDevice")
	public String getDevice (HttpSession s) {
		return dmS.getDevice(s);
	
	}







	/**
	 * 
	 * @param m
	 * @return
	 */
	@GetMapping("/findDispositivoByMatricola") // validate
	public List<DispositivoMedicoDTO> findByMatricola(@RequestParam String m) {

		return dmS.findByMatricola(m);

	}





}
