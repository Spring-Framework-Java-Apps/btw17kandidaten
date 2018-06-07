package org.woehlke.btw17.kandidaten.oodm.graph.model.btw17;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.BundeslandEnum;

import javax.validation.constraints.NotNull;


@Setter
@Getter
@NodeEntity
public class Btw17Wahlkreis implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "wahlkreis_nummer"/*, nullable=false, unique = true*/)
    private Long wahlkreisNummer;

    @Property(name = "wahlkreis_name"/*, nullable=false*/)
    private String wahlkreisName;

    @Property(name = "bundesland_nummer"/*, nullable=false*/)
    private Long bundeslandNummer;

    @Property(name = "bundesland_name"/*, nullable=false*/)
    private String bundeslandName;

    @NotNull
    //@Enumerated(EnumType.STRING)
    @Property(name = "bundesland_kurz"/*, nullable=false*/)
    private BundeslandEnum bundeslandEnumKurz;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return wahlkreisName+" ( "+wahlkreisNummer+" ) in "+bundeslandName;
    }

    @Override
    public String getUniqueId() {
        return this.wahlkreisNummer + ":"+wahlkreisName+":"+ bundeslandEnumKurz;
    }

}
