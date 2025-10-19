package rest$api.mediatype;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/media")
public class MediaTypeSelection {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getMediaType(@HeaderParam("Accept") String acceptHeader) {
        if (MediaType.APPLICATION_JSON.equals(acceptHeader)) {
            return Response.ok("{\"message\":\"Hello, JSON World!\"}", MediaType.APPLICATION_JSON).build();
        } else if (MediaType.APPLICATION_XML.equals(acceptHeader)) {
            return Response.ok("<message>Hello, XML World!</message>", MediaType.APPLICATION_XML).build();
        }
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Unsupported media type").build();
    }

    // Test case
    public static void main(String[] args) {
        MediaTypeSelection mediaTypeSelection = new MediaTypeSelection();
        Response response = mediaTypeSelection.getMediaType("application/json");
        System.out.println(response.getEntity());
    }
}
