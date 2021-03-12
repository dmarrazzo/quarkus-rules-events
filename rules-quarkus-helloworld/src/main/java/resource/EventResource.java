package resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kie.api.runtime.KieSession;

import service.SessionHolder;

@Path("/event")
public class EventResource {

    @Inject
    SessionHolder sessionHolder;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String event() {
        return "hello";
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void sendEvent(String text) {
        KieSession ksession = sessionHolder.getKieSession();        
        ksession.insert(text);
        ksession.fireAllRules();
        System.out.println(ksession.getFactCount());
    }
}
