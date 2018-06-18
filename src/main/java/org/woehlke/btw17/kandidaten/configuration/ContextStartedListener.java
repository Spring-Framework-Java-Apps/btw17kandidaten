package org.woehlke.btw17.kandidaten.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextStartedListener implements ApplicationListener<ContextStartedEvent> {

    private static final Logger log = LoggerFactory.getLogger(StartupListener.class);

    @Override
    public void onApplicationEvent(final ContextStartedEvent event) {
        log.info("--------------------------------------------------");
        log.info("ContextStartedEvent: ");
        ApplicationContext ctx = event.getApplicationContext();
        log.info("getApplicationName: "+ctx.getApplicationName());
        log.info("getDisplayName:     "+ctx.getDisplayName());
        log.info("getId:              "+ctx.getId());
        long startupTimestamp = ctx.getStartupDate();
        log.info("startupTimestamp:   "+startupTimestamp);
        log.info("--------------------------------------------------");
    }
}
