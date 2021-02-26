package fish.payara.temp;

import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("actor")
@Produces({"application/json"})
public class ActorResource {

    public ActorDaoService actorDaoService = new ActorDaoService();

    @GET
    public List<Actor> listActors() throws SQLException {
//        Integer page = Integer.valueOf(httpServletRequest.getParameter("page"));
//        Integer totalActorsPerPage = 10;
//
//        List<Actor> actors = new ArrayList<>();
//        try(Connection connection = dataSource.getConnection()) {
//            try(PreparedStatement preparedStatement = connection.prepareStatement("Select * from actor offset ? limit ?")) {
//                preparedStatement.setObject(1, page * totalActorsPerPage);
//                preparedStatement.setObject(2, totalActorsPerPage);
//                preparedStatement.execute();
//
//                try(ResultSet resultSet = preparedStatement.getResultSet()) {
//                    while (resultSet.next()){
//                        actors.add(new Actor(resultSet.getInt("actor_id"), resultSet.getString("first_name"), resultSet.getString("last_name")));
//                    }
//                }
//            }
//        }
//        return actors;
        return actorDaoService.findAll();
    }

    @GET
    @Path("{id}")
    public Actor getActorById(@PathParam("id") int id) {
        return actorDaoService.findOne(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Actor postActor(Actor actor)
    {
        return actorDaoService.save(actor);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Actor deleteActor(@PathParam("id") int id){
       return actorDaoService.deleteById(id);
    }
}
