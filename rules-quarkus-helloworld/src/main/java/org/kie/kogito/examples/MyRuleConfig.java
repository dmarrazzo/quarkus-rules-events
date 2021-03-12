package org.kie.kogito.examples;

import org.drools.core.config.AbstractRuleConfig;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.kogito.rules.RuleEventListenerConfig;

public class MyRuleConfig extends AbstractRuleConfig {

    public MyRuleConfig(Iterable<RuleEventListenerConfig> ruleEventListenerConfigs,
            Iterable<AgendaEventListener> agendaEventListeners,
            Iterable<RuleRuntimeEventListener> ruleRuntimeEventListeners) {
        super(ruleEventListenerConfigs, agendaEventListeners, ruleRuntimeEventListeners);
    }
    
}
