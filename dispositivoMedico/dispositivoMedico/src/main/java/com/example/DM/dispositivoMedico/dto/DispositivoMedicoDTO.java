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

	@NotEmpty(message="No vacant")
	private String nomeDispositivo;
	
	private String unitaDiMisurazione;
	private String misurazione;
	private Date timestamp;
	private Date dataOperazione;
	private String matricola;
	private String nomePaziente;
		
	@JsonProperty(value="owner")
	private String ownerDispositivo;
}
