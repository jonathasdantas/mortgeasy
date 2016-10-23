package com.mortgeasy.rest;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.mortgeasy.common.EJBServiceLocator;
import com.mortgeasy.entity.SampleEntity;
import com.mortgeasy.interceptor.TratamentoExcecao;
import com.mortgeasy.interfaces.remote.ISampleEntitySrvRemote;

@Path("sampleEntity")
@TratamentoExcecao
@PermitAll
public class SampleEntitySrvRest {

	private ISampleEntitySrvRemote sampleEntityService = EJBServiceLocator.locateEJBStateless(ISampleEntitySrvRemote.class);
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("id") Integer id) {
		SampleEntity tag = sampleEntityService.recuperarPorId(id);
		if (tag != null) {
			sampleEntityService.excluirPorId(id);
			return Response.ok(tag).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperarEntidades() {
		return Response.ok(sampleEntityService.recuperarEntidades()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperarPorId(@PathParam("id") Integer id) {
		return Response.ok(sampleEntityService.recuperarPorId(id)).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(SampleEntity parametro) {
		SampleEntity tag = sampleEntityService.inserir(parametro);
		return Response.ok(tag).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response alterar(SampleEntity parametro, @PathParam("id") Integer idProcesso) {
		return Response.ok(sampleEntityService.alterar(parametro)).build();
	}

}
