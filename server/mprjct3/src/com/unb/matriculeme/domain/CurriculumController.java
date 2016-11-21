package com.unb.matriculeme.domain;

import com.google.gson.Gson;
import com.unb.matriculeme.dao.Curso;
import com.unb.matriculeme.dao.Curriculo;
import com.unb.matriculeme.helpers.ClientUtils;
import com.unb.matriculeme.helpers.PersistenceHelper;
import com.unb.matriculeme.dao.Disciplina;
import com.unb.matriculeme.messages.AllRightMessage;
import com.unb.matriculeme.messages.BaseMessage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/curriculos")
public class CurriculumController  {

    @Path("/getCurriculo/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCurriculum() throws Exception {
        List curriculum = PersistenceHelper.queryGetList("Curriculo");
        return ClientUtils.sendResponse(curriculum);
    }

    // Why not setAllCurriculos?
    @Path("/setAllCurr")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAllResumes(List<Curriculo> resumes) throws Exception {
        //@TODO: If the Identifier it's not passed, isn't possible do the reference.
        //@TODO: Create a way to check if the Identifier is present. Obviously. And if not, result a BaseMessage()

        for (Curriculo curriculum : resumes) {
            Curriculo curr = new Curriculo();

            curr.setSemestreDisciplina(curriculum.getSemestreDisciplina());

            List cursos = PersistenceHelper.queryCustom("Curso", "codigo", String.valueOf(curriculum.getCurso().getCodigo()), false);

            curr.setCurso((Curso) cursos.get(0));

            List disciplinas = PersistenceHelper.queryCustom("Disciplina", "codigo", String.valueOf(curriculum.getDisciplina().getCodigo()), false);

            curr.setDisciplina((Disciplina) disciplinas.get(0));

            PersistenceHelper.persist(curr);
        }

        return ClientUtils.sendMessage(new AllRightMessage("The entire set of curriculum was added on the system."));
    }
}
