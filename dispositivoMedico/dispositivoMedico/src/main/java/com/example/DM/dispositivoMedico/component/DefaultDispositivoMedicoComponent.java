package com.example.DM.dispositivoMedico.component;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


	
	

	
	
	
	

}
