package com.mortgeasy.repository;

import java.util.List;

import javax.persistence.Query;

import com.mortgeasy.common.BaseDAO;
import com.mortgeasy.entity.SampleEntity;


public class SampleEntityDAO extends BaseDAO<SampleEntity> {

	public SampleEntityDAO() {
		super(SampleEntity.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<SampleEntity> recuperarTagsPorIdUsuario(Integer idUsuario) {
		String q = "SELECT DISTINCT t FROM Tag t JOIN t.processosTag pt WHERE pt.usuarioId = :idUsuario";
		Query query = getEntityManager().createQuery(q);
		query.setParameter("idUsuario", idUsuario);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<SampleEntity> recuperarTagsPorProcessoUsuario(String npuProcesso, Integer idUsuario) {
		String q = "SELECT DISTINCT t FROM Tag t JOIN t.processosTag pt WHERE pt.npuProcesso = :npuProcesso AND pt.usuarioId = :idUsuario";
		Query query = getEntityManager().createQuery(q);
		query.setParameter("npuProcesso", npuProcesso);
		query.setParameter("idUsuario", idUsuario);
		return query.getResultList();
	}
	
}