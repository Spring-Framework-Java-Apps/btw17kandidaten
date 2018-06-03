package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.CommonFields;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.GeoPosition;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.Strukturdaten;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.WahlergebnisseBtw17;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NodeEntity
public class Partei implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name="wahlkreis_id",unique = true, nullable = false)
    private Long wahlkreisId;

    @Column(name="wahlkreis_name")
    private String wahlkreisName;

    @Valid
    @Embedded
    private GeoPosition geoPosition = new GeoPosition();

    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    @Valid
    @Embedded
    private Strukturdaten strukturdaten = new Strukturdaten();

    @Valid
    @Embedded
    private WahlergebnisseBtw17 wahlergebnisseBtw17 = new WahlergebnisseBtw17();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "fk_bundesland", nullable = true, updatable = true)
    private Bundesland bundesland;

    @Transient
    @Override
    public String getName() {
        return wahlkreisName + " ( " +wahlkreisId+" )";
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    public Long getId() {
        return id;
    }
}
