package com.example.DM.dispositivoMedico.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.DM.dispositivoMedico.model.DispositivoMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.validation.annotation.Validated;
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
// la risposta va direttamente nel body
@RestController
@RequestMapping("/private")
public class DispositivoMedicoController extends Session {

	@Autowired
	DispositivoMedicoSevice dmS;




	// chi fa l'iniezione (Container, apllication context )
	//bean



	// Authentication authentication ;

	// modificeh andrea

	// @Autowired
	// DefaultDispositivoMedicoServizio ddmS;

	// @Autowired
	// DefaultDispositivoMedicoServizio ddmS;

	// DispositivoMedicoCookie dmCK;

	/**
	 * 
	 * @param dmDTO
	 */
	@PostMapping("/insert")
	public void insertDispositivoMedico(@RequestBody  @Valid() DispositivoMedicoDTO dmDTO  ) {
		dmS.insertMisuraDispositivoMedico(dmDTO);
	}

	public String readCookie(@CookieValue(value = "autentication", defaultValue = "false") String autentication) {
		// return "Ehi this is my value autentication : " + autentication ;
		return autentication;
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
	 * @return dm dto
	 * @throws IOException
	 */
	@GetMapping("/findAll")
	public List<DispositivoMedicoDTO> findAll() {

		//dmS.getDevice(null)
		
		return dmS.findAll();
	}




//	 @GetMapping("/findAll")
//		public List<DispositivoMedicoDTO> findAll(HttpServletResponse response) {
//			
//			
//			{
//				//http://2.228.6.66:4581/login
////				
//				
//			    final String uri = "http://2.228.6.66:4581/getSensors";
//			    
//			    
//			    //cookie
//

//			    
//			    
//			    
//			    RestTemplate restTemplate = new RestTemplate();
//			    //restTemplate.get
//			    //restTemplate.get
//			   String result = restTemplate.getForObject(uri, String.class);
//			   // String result = restTemplate.getForObject(uri,response,);
//			   // String result = restTemplate.patchForObject(uri,response, String.class);
//	
//			    System.out.println(result);
//			}
//			return dmS.findAll();
//		}

	/*
	 * modifiche andrea
	 * 
	 */

	/**
	 * 
	 * @param m
	 * @return
	 */
	@GetMapping("/findDispositivoByMatricola") // validate
	public List<DispositivoMedicoDTO> findByMatricola(@RequestParam String m) {

		return dmS.findByMatricola(m);

	}

	// to do
	// salvare il cookie sul db in modo tale da controllare lo stato e soprattutto
	// efettuare un controllo lato client se esiste il cookie
	/**
	 * 
	 * @param nome
	 * @return
	 */
	@GetMapping("/findDispositivoByNomePaziente") // request para=name
	// java settare cookie
	// prima di ogni andpoint
	// java client cookie mapping client
	public List<DispositivoMedicoDTO> findByNomePaziente(
			@RequestParam(name = "nome", defaultValue = "nulla") String nome,
			@CookieValue(value = "autentication", defaultValue = "false") boolean autentication) {

		// prendo l'autenticazione nel contesto e la controllo

		// authentication.setAuthenticated(true);

		// authentication = SecurityContextHolder.getContext().getAuthentication();

		// SecurityContextHolder.setContext(null)
//	    if (authentication.isAuthenticated()) {
//	    	return dmS.findByNomePaziente(nome);
//	    }else {
//	    	return null;
//	    }
//	    

		if (autentication) {
			return dmS.findByNomePaziente(nome);
		} else {
			return null;
		}
		/**
		 * response redirect pagina di errore nel cookie spring security nome classe alt
		 * shift r nn logica del cookie su ogni end point
		 */
		// return null;
	}

	// modifiche andrea

	/**
	 * 
	 * @return
	 */
	@GetMapping("/getAllService")
	public List<DispositivoMedicoServizioDTO> getAllService() {
		return dmS.returnAllService();

	}

	/**
	 * @PostMapping ("/getUser") public boolean getUser(@RequestBody
	 *              DispositivoMedicoAccountDTO dmaDTO){
	 * 
	 *              //andrea //dmS.createCookie(dmS.getUser(dmaDTO));
	 * 
	 * 
	 *              return dmS.getUser(dmaDTO); }
	 *
	 * 
	 */

	@PostMapping("/getUser")
	public boolean getUser(@RequestBody DispositivoMedicoAccountDTO dmaDTO, HttpServletResponse response) {
		// salvare il cookie sul db
		// andrea
		// authentication.setAuthenticated(false);
//		 authentication =  SecurityContextHolder.getContext().getAuthentication();
//		 if (authentication == null || AnonymousAuthenticationToken.class.
//	      isAssignableFrom(authentication.getClass())) {
//	 	authentication.setAuthenticated(false);
//	        return false;
//	    }

		if (dmS.getUser(dmaDTO)) {
			// autenticazione che viene salvata nel contesto sicuro
			// authentication.setAuthenticated(true);

			dmS.setCookieTrue(response);
		} else {
			dmS.setCookieFalse(
					response); /* Per provare i controlli se il cookie false nel metodo findbyname paziente */
			// authentication.setAuthenticated(false);
		}

		return dmS.getUser(dmaDTO);
	}

	@GetMapping("/getDispByPaziente")
	public List<DispositivoMedicoDTO> getDispByPaziente(String nomePZ) {

		return dmS.getDispByPaziente(nomePZ);
	}


	@GetMapping ("/getDispByOwner")
	public   List<DispositivoMedicoDTO> getDispByOwner ( @RequestParam(name= "nomeOw") String nomeOw){
		return  dmS.getDispByOwner(nomeOw);
	}

	// @GetMapping("/checkCookie")
	// public boolean getCookie() {
	// return dmS.getCookie();

	// }

	// @GetMapping ("/getAllDinamicService")
	// public void handleContextRefresh(ContextRefreshedEvent event) {
	// dmS.handleContextRefresh(event);
//	}

	// @GetMapping ("/getAllDinamicService")
	// public void getAllDinamicService(ContextRefreshedEvent event) {
	// dmS.getAllDinamicService(event);
	// }
	// @PostMapping("/context")
	// public void getAllDinamicService( ContextRefreshedEvent event) {
	// dmS.getAllDinamicService(event);
	// }

	/**************************************************************************************/

	/**
	 * end point con query che effettuano join tra tabelle
	 */

//	@GetMapping ("/findPazientiThatUseMatricolaDisp")
//	public List<Pazienti>
//	

}
