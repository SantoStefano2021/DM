package com.example.DM.dispositivoMedico.model;

import static javax.persistence.GenerationType.AUTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class DispositivoMedico {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id_dispositivo;
	
	@Column(name = "nome_dispositivo")
	private String nomeDispositivo;
	
	@Column(name = "unita_di_misurazione")
	private String unitaDiMisurazione;
	
	private String misurazione;
	
	private Date timestamp;
		
	@Column(name = "data_operazione")
	private Date dataOperazione;
	
	private String matricola;
	
	@Column(name = "nome_paziente")
	private String nomePaziente;
	
	@Column(name = "owner_dispositivo")
	private String ownerDispositivo;
}
