package com.unb.matriculeme.domain;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.unb.matriculeme.dao.Disciplina;
import com.unb.matriculeme.dao.Oferta;
import com.unb.matriculeme.dao.Semestre;
import com.unb.matriculeme.helpers.PersistenceHelper;

//TODO: Get da classe. Por qual parametro devera ser feito?
@Path("/oferta")
public class OfertaController {
	@Path("/setOferta")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setOferta(Oferta ofertaRecebida){
		
		Oferta oferta = new Oferta();
		oferta.setDisciplina((Disciplina)(PersistenceHelper.queryCustom("Disciplina", "codigo",String.valueOf(ofertaRecebida.getDisciplina().getCodigo()),false).get(0)));
		oferta.setSemestre((Semestre)(PersistenceHelper.queryCustom("Semestre", "codigo", ofertaRecebida.getSemestre().getCodigo() , true).get(1)));
		PersistenceHelper.Persist(oferta);
		return Response.status(200).build(); 
		
	} 
	
//	@Path("/getOferta")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getOferta ()
	
}
