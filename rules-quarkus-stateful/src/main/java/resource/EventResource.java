package resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kie.api.runtime.KieSession;

import io.vertx.core.eventbus.EventBus;
import service.SessionHolder;

@Path("/event")
public class EventResource {

    @Inject
    SessionHolder sessionHolder;

    @Inject
    EventBus bus;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String event() {
        KieSession ksession = sessionHolder.getKieSession();

        StringBuffer sb = new StringBuffer();
        ksession.getObjects().forEach(o -> {
            sb.append(o + " ");
        });
        return sb.toString();
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void sendEvent(String text) {
        KieSession ksession = sessionHolder.getKieSession();
        ksession.insert(text);
        int fired = ksession.fireAllRules();
        if (fired > 0)
            bus.send("rules-fired", null);
    }
}
