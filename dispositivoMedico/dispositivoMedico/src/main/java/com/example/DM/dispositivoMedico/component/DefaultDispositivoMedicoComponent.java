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

import com.example.DM.dispositivoMedico.dto.DispositivoMedicoAccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.DM.dispositivoMedico.dao.DispositivoMedicoDAO;

import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.mapper.CommonMapper;
import com.example.DM.dispositivoMedico.model.DispositivoMedico;



@Component
public class DefaultDispositivoMedicoComponent  implements DispositivoMedicoComponent{
	
	
	@Autowired
	private DispositivoMedicoDAO dmDao;
	

	
	@Autowired
	private CommonMapper commonMapper;
	
	


	@Autowired
	private Validator validate;

	@Override
	public void saveDispositivoMedico(DispositivoMedicoDTO dm) {
		// TODO Auto-generated method stub
			
		DispositivoMedico oggettoDM  = commonMapper.map(dm);
		dmDao.save(oggettoDM);
		
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
	


	//
	//andrea










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




	
	

	
	
	
	

}
