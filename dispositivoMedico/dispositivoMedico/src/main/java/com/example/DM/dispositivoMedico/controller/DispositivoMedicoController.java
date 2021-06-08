package com.example.DM.dispositivoMedico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.service.DispositivoMedicoSevice;

@RestController
@RequestMapping("/private")
public class DispositivoMedicoController {

	@Autowired
	DispositivoMedicoSevice dmS;

	@PostMapping("/insert")
	public void insertDispositivoMedico(@RequestBody DispositivoMedicoDTO dmDTO) {
		dmS.insertMisuraDispositivoMedico(dmDTO);
	}

	@GetMapping("/findAll")
	public List<DispositivoMedicoDTO> findAll() {
		return dmS.findAll();
	}
	
	/*modifiche andrea
	 * 
	*/
	
	@GetMapping("/findByMatricola")
	public List<DispositivoMedicoDTO> findByMatricola(@RequestParam String m){
		
		return dmS.findByMatricola(m);
		
	}
	
	

}
