package org.kie.kogito.examples;

import org.jboss.logging.Logger;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;

public class MyRuleRuntimeEventListener implements RuleRuntimeEventListener {

    private static final Logger LOG = Logger.getLogger(MyAgendaEventListener.class);

    @Override
    public void objectInserted(ObjectInsertedEvent event) {
        LOG.infof("Inserted: %s", event.getObject());
    }

    @Override
    public void objectUpdated(ObjectUpdatedEvent event) {
        LOG.infof("Updated: %s", event.getObject());
    }

    @Override
    public void objectDeleted(ObjectDeletedEvent event) {
        LOG.infof("Deleted: %s", event.getOldObject());
    }

}
