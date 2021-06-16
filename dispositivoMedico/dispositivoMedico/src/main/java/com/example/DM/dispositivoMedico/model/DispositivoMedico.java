package com.example.DM.dispositivoMedico.model;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	private Date timestamp;
		
	@Column(name = "data_operazione")
	private Date dataOperazione;
	
	private String matricola;
	
	//lista pazienti essendo una relazione dico anche che voglio il caricamento 
	// lazy ovvero non caricarmeli subito tutti. invece con eager li caricava tutti
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL,mappedBy = "listaDispositivo")
	//@JoinColumn(name="nome_paziente")
	List<Paziente> listaPazienti;
	
	@Column(name = "owner_dispositivo")
	private String ownerDispositivo;
	
	
}
