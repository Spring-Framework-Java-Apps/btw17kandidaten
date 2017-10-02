package org.woehlke.btw17.kandidaten.configuration;

import javax.persistence.Embeddable;

@Embeddable
public enum EditStatus {

    UNTOUCHED,
    WORK_IN_PROGRESS,
    FINISHED
}
