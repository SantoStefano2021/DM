package com.example.DM.dispositivoMedico.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DispositivoMedicoDTO implements Serializable{


	private String nomeDispositivo;


	private String unitaDiMisurazione;
	private String misurazione;
	private Date timestamp;
	private Date dataOperazione;
	private String matricola;
	private String nomePaziente;

	private String nomeCalciatore;
	//Comunicate con un sitema esterno, il dto che vi passo ha la property oner mentre io la chiamo ownerDispositivo
	// quindi quando incontro wner per me è ownerDispositivo
	@JsonProperty(value="owner")
	private String ownerDispositivo;
}
