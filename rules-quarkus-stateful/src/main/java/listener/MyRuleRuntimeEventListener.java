package listener;

import org.jboss.logging.Logger;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;

public class MyRuleRuntimeEventListener implements RuleRuntimeEventListener {

    private static final Logger LOG = Logger.getLogger(MyAgendaEventListener.class);

    @Override
    public void objectInserted(ObjectInsertedEvent event) {
        LOG.debugf("Inserted: %s", event.getObject());
    }

    @Override
    public void objectUpdated(ObjectUpdatedEvent event) {
        LOG.debugf("Updated: %s", event.getObject());
    }

    @Override
    public void objectDeleted(ObjectDeletedEvent event) {
        LOG.debugf("Deleted: %s", event.getOldObject());
    }

}
