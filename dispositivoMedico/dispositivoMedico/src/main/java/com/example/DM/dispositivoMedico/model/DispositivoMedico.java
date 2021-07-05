package com.example.DM.dispositivoMedico.model;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

//import com.example.DM.dispositivoMedico.Calciatore;
import org.hibernate.annotations.BatchSize;

import com.example.DM.dispositivoMedico.paziente.model.Paziente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DispositivoMedico implements Serializable {

	@Id
	@GeneratedValue(strategy = AUTO)
	@Column(name = "id_dispositivo")
	private Long idDispositivo;
	
	@Column(name = "nome_dispositivo")
	private String nomeDispositivo;
	
	@Column(name = "unita_di_misurazione")
	private String unitaDiMisurazione;
	
	private String misurazione;

	//questa proprietà non deve essere mappata nel db
//	@Transient
//	private Calciatore calciatore;

	private Date timestamp;
		
	@Column(name = "data_operazione")
	private Date dataOperazione;
	
	private String matricola;
	
	//lista pazienti essendo una relazione dico anche che voglio il caricamento 
	// lazy ovvero non caricarmeli subito tutti. invece con eager li caricava tutti
	/**
	 * lazy significa che quando vai ad effettuare il caicamento dal db carica solo il paziente
	 * e non i dispositivi medici della relazione, quindi snellisco il caricamento, ma così quando
	 * avrò necessita dei dispositivi dorò caricare i dati ed effettuare una chiamata al db 
	 * 
	 * Eager carica tutto. tutte le relazioni che ho nelle classi
	 */
	@BatchSize(size = 1)
	@ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL,mappedBy = "listaDispositivo")
	//@JoinColumn(name="nome_paziente")
	List<Paziente> listaPazienti;
	
	@Column(name = "owner_dispositivo")
	private String ownerDispositivo;
	
	
}
