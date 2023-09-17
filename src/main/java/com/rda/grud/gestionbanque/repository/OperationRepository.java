package com.rda.grud.gestionbanque.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rda.grud.gestionbanque.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Integer> {
	@Query("select o from Operation o where o.compte.codeCpt=:x")
	public Page<Operation> listeOperation(@Param("x") String codeCpte, Pageable pageable);
}
