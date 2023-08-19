package com.vlsystem.OS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vlsystem.OS.entity.Servico;

public interface servicoRepository extends JpaRepository<Servico, Long>{

	@Query("select s From Servico s where s.valorPago <> null and s.valorPago > 0")
	List<Servico>buscarServicoPagamentoPendente();
	
	@Query("select s From Servico s where  s.status = 'cancelado'")
	List<Servico>buscarServicoCancelados();
}
