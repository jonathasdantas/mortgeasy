package com.mortgeasy.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.mortgeasy.entity.SampleEntity;
import com.mortgeasy.interfaces.remote.ISampleEntitySrvRemote;
import com.mortgeasy.repository.SampleEntityDAO;

@Stateless
public class SamplesEntitySrv implements ISampleEntitySrvRemote {

	@Inject
	private SampleEntityDAO tagDAO;


	public SampleEntity recuperarPorId(Integer id) {
		return tagDAO.recuperarEntidadePorId(id);
	}
	
	public SampleEntity inserir(SampleEntity tag) {
		return tagDAO.inserir(tag);
	}

	public SampleEntity alterar(SampleEntity tag) {
		return tagDAO.alterar(tag);
	}

	public void excluirPorId(Integer id) {
		tagDAO.excluirPorId(id);
	}

	public List<SampleEntity> recuperarEntidades() {
		return tagDAO.recuperarEntidades();
	}

	public List<SampleEntity> recuperarTagsPorIdUsuario(Integer idUsuario) {
		return tagDAO.recuperarTagsPorIdUsuario(idUsuario);
	}

	public List<SampleEntity> recuperarTagsPorProcessoUsuario(String npuProcesso, Integer idUsuario) {
		return tagDAO.recuperarTagsPorProcessoUsuario(npuProcesso, idUsuario);
	}
	
}
