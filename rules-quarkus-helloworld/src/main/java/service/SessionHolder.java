package service;

import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieSession;
import org.kie.kogito.rules.KieRuntimeBuilder;
import org.kie.kogito.rules.RuleEventListenerConfig;

import io.quarkus.runtime.StartupEvent;
import listener.MyAgendaEventListener;
import listener.MyRuleConfig;
import listener.MyRuleRuntimeEventListener;

@ApplicationScoped
public class SessionHolder {
    @Inject
    KieRuntimeBuilder runtimeBuilder;

    private KieSession kieSession;

    void onStart(@Observes StartupEvent event) {
        var agendaListeners = new HashSet<AgendaEventListener>();
        var agendaListener = new MyAgendaEventListener();
        agendaListeners.add(agendaListener);
        var ruleEventListener = new HashSet<RuleEventListenerConfig>();
        var ruleRuntimeEventListeners = new HashSet<RuleRuntimeEventListener>();
        ruleRuntimeEventListeners.add(new MyRuleRuntimeEventListener());
        var ruleConfig = new MyRuleConfig(ruleEventListener, agendaListeners, ruleRuntimeEventListeners);
        setKieSession(runtimeBuilder.newKieSession("statefulSession", ruleConfig));
    }

    /**
     * @return the kieSession
     */
    public KieSession getKieSession() {
        return kieSession;
    }

    /**
     * @param kieSession the kieSession to set
     */
    private void setKieSession(KieSession kieSession) {
        this.kieSession = kieSession;
    }
}
