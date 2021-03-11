package resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kie.api.runtime.KieSession;
import org.kie.kogito.rules.KieRuntimeBuilder;

@Path("/event")
public class EventResource {

    @Inject
    KieRuntimeBuilder runtimeBuilder;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String event() {
        return "hello";
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void sendEvent(String text) {
        KieSession ksession = runtimeBuilder.newKieSession();

        ksession.insert(text);
        ksession.fireAllRules();
    }
}
