package service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.kie.api.runtime.KieSession;
import org.kie.kogito.rules.KieRuntimeBuilder;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class SessionHolder {
    @Inject
    KieRuntimeBuilder runtimeBuilder;

    private KieSession kieSession;

    void onStart(@Observes StartupEvent event) {
        setKieSession(runtimeBuilder.newKieSession("statefulSession"));
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
