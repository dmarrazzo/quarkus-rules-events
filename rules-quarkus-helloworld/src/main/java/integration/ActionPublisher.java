package integration;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.logging.Logger;

import io.quarkus.vertx.ConsumeEvent;

@ApplicationScoped
public class ActionPublisher {
    private static final Logger LOG = Logger.getLogger(ActionPublisher.class);

    @ConsumeEvent(value = "rules-fired", blocking = true)
    public void action(Object object) {
        LOG.info("rules fired");
    }
}