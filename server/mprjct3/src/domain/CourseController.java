package domain;

import dao.Course;
import helpers.ClientUtils;
import helpers.PersistenceHelper;
import messages.AllRightMessage;
import messages.BaseMessage;
import messages.NotFoundMessage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cursos")
public class CourseController {

    // Recommended change "nome" to "name"
    @Path("/alterCurso/nome={nome}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterCurso(@PathParam("nome") String nome, Course course) throws Exception {
        List courses = PersistenceHelper.queryCustom("Course", "nome", nome, true);

        if (courses.size() > 0) {
            PersistenceHelper.update((Course) courses.get(0), course);
        }

        return ClientUtils.sendMessage(courses.size() > 0 ? new BaseMessage(200, "Course changed successfully.") :
                new NotFoundMessage("This course wasn't found on our system."));
    }

    @Path("/setCourse")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sayPlainTextHello(Course course) throws Exception {
        PersistenceHelper.persist(course);
        return ClientUtils.sendMessage(new AllRightMessage("The course was inserted on the system successfully."));
    }

    // Recommended change "nome" to "name"
    @Path("/getCourse/nome={nome}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertFeetToInch(@PathParam("nome") String nome) {
        List courses = PersistenceHelper.queryCustom("Course", "nome", nome, true);
        return courses.size() > 0 ? ClientUtils.sendResponse(courses) :
                ClientUtils.sendMessage(new NotFoundMessage("The Course wasn't found on the system."));
    }

    // Recommended change "codigo" to "code"
    @Path("/getCourse/nome={nome}&codigo={codigo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response example(@PathParam("nome") String nome, @PathParam("codigo") int codigo) {
        List courses = PersistenceHelper.queryCustom("Course", "nome", nome, "codigo", String.valueOf(codigo));
        return courses.size() > 0 ? ClientUtils.sendResponse(courses) :
                ClientUtils.sendMessage(new NotFoundMessage("The Course wasn't found on the system."));
    }
}