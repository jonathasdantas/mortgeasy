package com.mortgeasy.interfaces.remote;

import java.util.List;

import javax.ejb.Remote;

import com.mortgeasy.common.IBaseSrvRemote;
import com.mortgeasy.entity.SampleEntity;

@Remote
public interface ISampleEntitySrvRemote extends IBaseSrvRemote<SampleEntity, Integer> {

	public List<SampleEntity> recuperarTagsPorIdUsuario(Integer idUsuario);
	public List<SampleEntity> recuperarTagsPorProcessoUsuario(String npuProcesso, Integer idUsuario);
	
}
