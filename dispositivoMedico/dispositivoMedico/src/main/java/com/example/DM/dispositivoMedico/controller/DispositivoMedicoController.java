package com.example.DM.dispositivoMedico.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DM.dispositivoMedico.account.dto.DispositivoMedicoAccountDTO;
import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.service.DispositivoMedicoSevice;
import com.example.DM.dispositivoMedico.servizio.dto.DispositivoMedicoServizioDTO;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/private")
public class DispositivoMedicoController extends Session  {

	@Autowired
	DispositivoMedicoSevice dmS;
	
	//modificeh andrea
	
	//@Autowired
	//DefaultDispositivoMedicoServizio ddmS;
	
	//@Autowired
	//DefaultDispositivoMedicoServizio ddmS;
	
	
	//DispositivoMedicoCookie dmCK;
	

	
	
	
	
	
	
	/**
	 * 
	 * @param dmDTO
	 */
	@PostMapping("/insert")
	public void insertDispositivoMedico(@RequestBody DispositivoMedicoDTO dmDTO) {
		dmS.insertMisuraDispositivoMedico(dmDTO);
	}

	/**
	 * 
	 * @return dm dto
	 */
	@GetMapping("/findAll")
	public List<DispositivoMedicoDTO> findAll() {
		return dmS.findAll();
	}
	
	/*modifiche andrea
	 * 
	*/
	
	
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	@GetMapping("/findDispositivoByMatricola")//validate
	public List<DispositivoMedicoDTO> findByMatricola(@RequestParam String m){
		
		return dmS.findByMatricola(m);
		
	}
	
	
	/**
	 * 
	 * @param nome
	 * @return
	 */
	@GetMapping("/findDispositivoByNomePaziente")//request para=name
	//java settare cookie 
	//prima di ogni andpoint 
	//java client cookie mapping client
	public List<DispositivoMedicoDTO> findByNomePaziente(@RequestParam (name = "nome", defaultValue = "nulla") String nome, @CookieValue(value = "autentication", defaultValue = "false") boolean autentication){
		if(autentication) {
			return dmS.findByNomePaziente(nome);
		}
		else {
			return null;
		}
		/**
		 * response redirect pagina di errore
		 * nel cookie spring security    nome classe alt shift r
		 * nn logica del cookie su ogni end point
		 */
		//return null;
	}
	
	//modifiche andrea
	
	
	/**
	 * 
	 * @return
	 */
	@GetMapping ("/getAllService")
	public List<DispositivoMedicoServizioDTO> getAllService(){
		return dmS.returnAllService();
		
	}
	
	/**
	@PostMapping ("/getUser")
	public boolean getUser(@RequestBody DispositivoMedicoAccountDTO dmaDTO){
		
		//andrea
		//dmS.createCookie(dmS.getUser(dmaDTO));
		
		
		return dmS.getUser(dmaDTO);
	}
	
	*
	*/
	
	@PostMapping ("/getUser")
	public boolean getUser(@RequestBody DispositivoMedicoAccountDTO dmaDTO, HttpServletResponse response){
		
		//andrea
		if(dmS.getUser(dmaDTO)) {
			dmS.setCookieTrue(response);
		}else {
			dmS.setCookieFalse(response); /*Per provare i controlli se il cookie  false nel metodo findbyname paziente*/
		}
		
		
		
		return dmS.getUser(dmaDTO);
	}
	
	
	@GetMapping ("/getDispByPaziente")
	public List<DispositivoMedicoDTO> getDispByPaziente(String nomePZ){
		
		return dmS.getDispByPaziente(nomePZ);
	}
	
	
	
	
	//@GetMapping("/checkCookie")
	//public boolean getCookie() {
		//return dmS.getCookie(); 
	
	//}
	
	//@GetMapping ("/getAllDinamicService")
	//public void handleContextRefresh(ContextRefreshedEvent event) {
		//dmS.handleContextRefresh(event);
//	}
	
	//@GetMapping ("/getAllDinamicService")
		//public void getAllDinamicService(ContextRefreshedEvent event) {
			//dmS.getAllDinamicService(event);
		//}
	//@PostMapping("/context")
	//public void getAllDinamicService( ContextRefreshedEvent event) {
		//dmS.getAllDinamicService(event);
	//}
	
	
	
	/**************************************************************************************/
	
	/**
	 * end point con query che  effettuano join tra tabelle
	 */
	
	
//	@GetMapping ("/findPazientiThatUseMatricolaDisp")
//	public List<Pazienti>
//	

}
