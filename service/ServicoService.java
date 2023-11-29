package com.vlsystem.OS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlsystem.OS.entity.Servico;
import com.vlsystem.OS.repository.servicoRepository;

@Service
public class ServicoService {
	@Autowired
	private servicoRepository servicoRepository;

	public List<Servico> buscarServicoPagamentoPendente() {
		return servicoRepository.buscarServicoPagamentoPendente();
	}

	public List<Servico> buscarServicoCancelados() {
		return servicoRepository.buscarServicoCancelados();
	}

	public List<Servico> buscarTodos() {
		return servicoRepository.findAll();
	}

	public Servico inserir(Servico servico) {
		if(servico.getValorPago()==null || servico.getValorPago()==0 || servico.getDataPagamento()==null) {
			servico.setStatus(status:"pendente");
		}else {
			servico.setStatus(status:"realizado");
		}
			
		return servicoRepository.saveAndFlush(servico);
		// Servico servicoBanco = servicoRepository.save(servico);
		// return servicoBanco;

	}

	public Servico alterar(Servico servico) {
		if (servico.getValorPago() != null && servico.getValorPago() > 0 && servico.getDataPagamento() != null) {

		}
		return servicoRepository.saveAndFlush(servico);

	}

	public void excluir(Long id) {
		Servico servico = servicoRepository.findById(id).get();
		servicoRepository.delete(servico);

	}
}
