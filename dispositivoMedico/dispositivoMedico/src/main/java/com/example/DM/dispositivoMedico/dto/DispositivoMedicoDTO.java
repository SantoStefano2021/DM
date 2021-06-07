package com.example.DM.dispositivoMedico.dto;

import java.util.Date;

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
public class DispositivoMedicoDTO {

	private String nomeDispositivo;
	private String unitaDiMisurazione;
	private String misurazione;
	private Date timestamp;
	private Date dataOperazione;
	private String matricola;
	private String nomePaziente;
	private String ownerDispositivo;
}
