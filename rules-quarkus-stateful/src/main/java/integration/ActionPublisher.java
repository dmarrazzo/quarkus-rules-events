package integration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.jboss.logging.Logger;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.QueryResults;

import io.quarkus.vertx.ConsumeEvent;
import service.SessionHolder;

@ApplicationScoped
public class ActionPublisher {
    private static final Logger LOG = Logger.getLogger(ActionPublisher.class);

    @Inject
    SessionHolder sessionHolder;

    @ConsumeEvent(value = "rules-fired", blocking = true)
    public void action(Object object) {
        LOG.info("rules fired");
        KieSession kieSession = sessionHolder.getKieSession();
        QueryResults results = kieSession.getQueryResults("all warnings");
        results.forEach(r -> {
            FactHandle factHandle = r.getFactHandle("warning");
            LOG.info(kieSession.getObject(factHandle));
            kieSession.delete(factHandle);
        });
    }
}