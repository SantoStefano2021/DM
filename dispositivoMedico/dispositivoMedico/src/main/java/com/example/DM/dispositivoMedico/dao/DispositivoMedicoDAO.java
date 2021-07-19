package com.example.DM.dispositivoMedico.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DM.dispositivoMedico.model.DispositivoMedico;

@Repository
public interface DispositivoMedicoDAO extends JpaRepository<DispositivoMedico, String> {

	List<DispositivoMedico> findByMatricola(String matricola);
//	List<DispositivoMedico> findByDispositivoMedico (String nomeDispositivo);
/**
 * Hibernate Query Language (HQL) è un linguaggio di query orientato agli oggetti,
 * simile a SQL, ma invece di operare su tabelle e colonne, HQL funziona con oggetti persistenti e le loro proprietà.
 */
/**
 *Esempio queyry
 * TypedQuery<Department> query
 *       = entityManager.createQuery(
 *           "SELECT e.department FROM Employee e", Department.class);
 *     List<Department> resultList = query.getResultList();
**/


	

	//alt shit r
	
	
}
