package org.woehlke.btw17.kandidaten.frontend.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Validated
public class FreitextSucheFormular implements Serializable {

    @NotEmpty
    @NotNull
    @SafeHtml
    private String searchTerm;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FreitextSucheFormular)) return false;

        FreitextSucheFormular that = (FreitextSucheFormular) o;

        return searchTerm != null ? searchTerm.equals(that.searchTerm) : that.searchTerm == null;
    }

    @Override
    public int hashCode() {
        return searchTerm != null ? searchTerm.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SearchFreitext{" +
                "searchTerm='" + searchTerm + '\'' +
                '}';
    }
}
