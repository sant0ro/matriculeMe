package com.unb.matriculeme.domain;

import com.unb.matriculeme.dao.Mencao;
import com.unb.matriculeme.helpers.PersistenceHelper;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//Comentario da classe: Mencao eh q nem horario: so pode enviar lista, pq ninguem vai setar um a um. alem disso, nao tem get
//R: nao com certezas

@Path("/mencao")
public class MencaoController {
    @Path("/setMencoes")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setMencoes(List<Mencao> mencoes) {
        for (int i = 0; i < mencoes.size(); i++) {
            PersistenceHelper.Persist(mencoes.get(i));
        }
        return ClientUtils.sendMessage(new AllRightMessage("Mentions set successfully."));
    }

}