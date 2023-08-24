package core.solution.deepleads.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class DatabaseShutdownHook  implements ApplicationListener<ContextClosedEvent> {

    private final SessionFactory sessionFactory;

    public DatabaseShutdownHook(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }

    }
}
