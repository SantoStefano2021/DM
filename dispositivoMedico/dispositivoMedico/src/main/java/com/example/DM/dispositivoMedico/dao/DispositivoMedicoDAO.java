package com.example.DM.dispositivoMedico.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DM.dispositivoMedico.model.DispositivoMedico;

@Repository
public interface DispositivoMedicoDAO extends JpaRepository<DispositivoMedico, String> {

	List<DispositivoMedico> findByMatricola(String matricola);






	

	//alt shit r
	
	
}
