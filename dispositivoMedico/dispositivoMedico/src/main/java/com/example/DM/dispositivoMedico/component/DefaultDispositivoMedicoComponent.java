package com.example.DM.dispositivoMedico.component;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.example.DM.dispositivoMedico.dto.gruppoUno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.DM.dispositivoMedico.account.dto.DispositivoMedicoAccountDTO;
import com.example.DM.dispositivoMedico.cookie.DispositivoMedicoCookie;
import com.example.DM.dispositivoMedico.dao.DispositivoMedicoDAO;
import com.example.DM.dispositivoMedico.dao.DispositivoMedicoDAO2;
import com.example.DM.dispositivoMedico.dao.DispositivoMedicoDaoImpl;
import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.mapper.CommonMapper;
import com.example.DM.dispositivoMedico.model.DispositivoMedico;
import com.example.DM.dispositivoMedico.paziente.model.Paziente;
import com.example.DM.dispositivoMedico.servizio.DispositivoMedicoServizio;
import com.example.DM.dispositivoMedico.servizio.dto.DispositivoMedicoServizioDTO;


@Component
public class DefaultDispositivoMedicoComponent  implements DispositivoMedicoComponent{
	
	
	@Autowired
	private DispositivoMedicoDAO dmDao;
	
	@Autowired
	private DispositivoMedicoDAO2 dmDao2;
	
	@Autowired
	private CommonMapper commonMapper;
	
	
	@Autowired
	private DispositivoMedicoCookie ddmCK;
	
	@Autowired
	private DispositivoMedicoDaoImpl dmdaoImpl;

	@Autowired
	private Validator validate;

	@Override
	public void saveDispositivoMedico(DispositivoMedicoDTO dm) {
		// TODO Auto-generated method stub
			
		DispositivoMedico oggettoDM  = commonMapper.map(dm);
		dmDao.save(oggettoDM);
		
	}

	@Override
	public List<DispositivoMedicoDTO> findAllDevice() {
		
		List<DispositivoMedico> lst = dmDao.findAll(); // disp meici
		//relazione e poi è lazy altrimenti non si poteva fare
		
		List<Paziente> listaPazienti = lst.stream()
				.map(DispositivoMedico::getListaPazienti)
				.flatMap(x->x.stream())
				.collect(toList());
		
		System.out.println("dimensione lista pazienti component : ");
		System.out.println(listaPazienti.size());
		 
		
		return dmDao.findAll()
				.stream()
				.map(commonMapper::map)
				.collect(toList());
	}
	//
	
	
	/**
	 * 
	 * @param matricola
	 * @return 
	 */
	@Override
	public List<DispositivoMedicoDTO> findByMatricolaComponent(String matricola){
		return dmDao.findByMatricola(matricola)
						
				.stream()
			//	.filter(d -> d.getMatricola().equalsIgnoreCase(matricola))
				.map(commonMapper::map)
				.collect(toList());
	
	}
	

	@Override
	public List<DispositivoMedicoDTO> findByNomePaziente(String nome) {
	/**
	 * return dmDao.findByNomePaziente(nome)
					.stream()
					.map(commonMapper::map)
					.collect(toList());
	 */
		
		return  dmDao.findByListaPazienti(nome) // ordinamento da fare per nome iger, lazy , tabella pazienti bach lazy 1 a n nn a an n a 1 
				.stream()
				/*   parametro         espression */
				.filter(t -> "Saturimetro".equalsIgnoreCase(t.getNomeDispositivo()))
				.map(commonMapper::map)
				.collect(toList());
		
		
		
				
	}
	
	//
	//andrea

	@Override
	public List<DispositivoMedicoServizioDTO> returnAllService() {
		
		return createListAllService()
				.stream()
				.map(commonMapper::map)
				.collect(toList());
	}

	@Override
	public List<DispositivoMedicoServizio> createListAllService() {
		
		DispositivoMedicoServizio uno = new DispositivoMedicoServizio();
		uno.setNome("/insert");
		uno.setDescrizione("Inserisce un dispositivo medico DTO");
		uno.setRitorno("Nulla");
		uno.setArgomenti("Dispositivo medico DTO");
		
		DispositivoMedicoServizio due = new DispositivoMedicoServizio();
		due.setNome("/findAll");
		due.setDescrizione("Restituisce una lista di tutte le tuple ");
		due.setRitorno("List dispositivo medico DTO");
		due.setArgomenti("Nulla");
		
		List<DispositivoMedicoServizio> listaServizi = asList(uno,due);
		
		
		return listaServizi;
	}

	@Override
	public List<DispositivoMedicoServizio> returnDinamicListAllService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getUser(DispositivoMedicoAccountDTO dmaDTO) {	
		return dmDao2.findByUsernameAndPassword(dmaDTO.getUsername(), dmaDTO.getPassword()).isPresent();
				
				
	}

	@Override
	public String setCookieTrue(HttpServletResponse response) {
		
		return ddmCK.setCookieTrue(response);
	}

	@Override
	public String setCookieFalse(HttpServletResponse response) {
		return ddmCK.setCookieFalse(response);
		
	}

	@Override
	public List<DispositivoMedicoDTO> getDispByPaziente(String nomePZ) {
		// TODO Auto-generated method stub
		return dmdaoImpl.getDispByPaziente(nomePZ)
				.stream()
				.map(commonMapper::map)
				.collect(toList());
	}

	@Override
	public List<DispositivoMedicoDTO> getDispByOwner(String nomeOw) {
		return dmdaoImpl.getDispByOwner(nomeOw)
				.stream()
				.map(commonMapper::map)
				.collect(toList());
	}


	/**
	 * Fatto:
	 * Effettuo il log in dal mio end point chiamando , l'end point log in  esterno all'ip 2.228...
	 * salvo il cookie, creato dal log in, nella mia sessione locale
	 * chiamo dal mio end point get sensor, il get sensors dell'end point esterno passandogli il cookie, lo faccio  settandolo nell'header
	 * Quando invece chiamo direttamente get sensor senza aver effettuato il log in chiamo il log in interno che chiama il log in esterno 
	 * 
	 */
	@Override
	public String getDevice(HttpSession s) {
		final String uri = "http://2.228.6.66:4581/getDevices";

		RestTemplate restTemplateGetSensors = new RestTemplate();

		HttpHeaders requestHeaders = new HttpHeaders();
		// requestHeaders.add("Cookie", name+"=" + value);
		//System.out.println("aaaaaa  "+x_session_id);

		//requestHeaders.add("Cookie", );
		
		if(s.getAttribute("Cookie")==null) {
			System.out.println("ssssss vv cc "+s.getAttribute("Cookie"));
			logIn(s);
			return"niente non c è il cookie, faccio log in automaticamente io ho gia i parametri settat";
		}else {
			requestHeaders.add("Cookie", s.getAttribute("Cookie").toString());
			System.out.println("Session = get sensors "+s.getAttribute("Cookie").toString());
			
			
			
			HttpEntity<Object> requestEntity = new HttpEntity<Object>(null, requestHeaders);

			ResponseEntity<String> responserestGetSensors = restTemplateGetSensors.exchange(uri, HttpMethod.GET, requestEntity,
					String.class);
			// Users users = (Users) response.getBody();

			System.out.println(responserestGetSensors.toString());
			
			return responserestGetSensors.toString();
		}
	}

	@Override
	public String getSensors(HttpSession s) {
final String uriGetDevice = "http://2.228.6.66:4581/getSensors";
		
		RestTemplate rt = new RestTemplate();
		HttpHeaders reqHeaders = new HttpHeaders();
		/**
		 * prendo dalla sessione l'attributo cookie salvato nell'header (set cookie)
		 */
		if (s.getAttribute("Cookie") == null) {
			//logIn(s);
			return "niente non c è il cookie fai il log in da postman ";
		}else {
			
			reqHeaders.add("Cookie", s.getAttribute("Cookie").toString());
			HttpEntity<Object> rqEntity = new HttpEntity<Object>(null,reqHeaders);
			
			ResponseEntity<String> responseEntity = rt.exchange(uriGetDevice, HttpMethod.GET,rqEntity,String.class);
			
			return responseEntity.toString();
		}
	}

	@Override
	public String logIn(HttpSession s) {
		// http://2.228.6.66:4581/login
				DispositivoMedicoAccountDTO accout = new DispositivoMedicoAccountDTO();
				accout.setUsername("wtech_admin");
				accout.setPassword("WTech_2021X");
				
				final String uriLogIn = "http://2.228.6.66:4581/login";
				RestTemplate restTemplateLogIn = new RestTemplate();
				
				HttpEntity<DispositivoMedicoAccountDTO> account = new HttpEntity<>(accout);

				HttpEntity<String> response = restTemplateLogIn.exchange(uriLogIn, HttpMethod.POST, account, String.class);

				/**
				 * Prendo il cookie nell'head creato dalla chiamata log-in 
				 * e lo salvo nella mia sessione
				 */
				String set_cookie = response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
				// response.getHeaders().get
				// annotazione cookie value
				
				s.setAttribute("Cookie", set_cookie);
				
				System.out.println(set_cookie);
				System.out.println("session log in= "+s.getAttribute("Cookie").toString());
				// salvare il cookie

				System.out.println(response);
				
				return response.toString();
	}

	@Override
	public String logOut(HttpSession s) {
		RestTemplate restTemplate = new RestTemplate();
		final String uri = "http://2.228.6.66:4581/logout";
		s.removeAttribute("Cookie");
		//restTemplate.postForObject(uri, s, String.class);
	
		//HttpEntity<String> entita = new HttpEntity<>(entita);
	//	restTemplate.exchange(uri,HttpMethod.POST, String.class);
		
 		//HttpEntity<String> response = restTemplate.exchange(uri, String.class, HttpMethod.POST);

	
		
		
		return restTemplate.postForObject(uri,null, String.class);
	}



	public void validation(DispositivoMedicoDTO dispositivoMedicoDTO){
		 Set<ConstraintViolation<DispositivoMedicoDTO>> pippo = validate.validate(dispositivoMedicoDTO, gruppoUno.class);
	}

	
	

	
	
	
	

}
