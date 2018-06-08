package org.woehlke.btw17.kandidaten.oodm.graph.model.btw17;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.BundeslandEnum;

@NodeEntity
public class Btw17Wahlkreis extends GraphDomainObjectImpl implements GraphDomainObject {


    @Index(unique=true)
    @Property(name = "wahlkreis_nummer")
    private Long wahlkreisNummer;

    @Index
    @Property(name = "wahlkreis_name")
    private String wahlkreisName;

    @Index
    @Property(name = "bundesland_nummer")
    private Long bundeslandNummer;

    @Index
    @Property(name = "bundesland_name")
    private String bundeslandName;

    @Property(name = "bundesland_kurz")
    private BundeslandEnum bundeslandEnumKurz;

    @Override
    public String getName() {
        return wahlkreisName+" ( "+wahlkreisNummer+" ) in "+bundeslandName;
    }

    @Override
    public String getUniqueId() {
        return this.getName() + ":"+ getId();
    }

    public Btw17Wahlkreis() {
    }

    public Long getWahlkreisNummer() {
        return wahlkreisNummer;
    }

    public void setWahlkreisNummer(Long wahlkreisNummer) {
        this.wahlkreisNummer = wahlkreisNummer;
    }

    public String getWahlkreisName() {
        return wahlkreisName;
    }

    public void setWahlkreisName(String wahlkreisName) {
        this.wahlkreisName = wahlkreisName;
    }

    public Long getBundeslandNummer() {
        return bundeslandNummer;
    }

    public void setBundeslandNummer(Long bundeslandNummer) {
        this.bundeslandNummer = bundeslandNummer;
    }

    public String getBundeslandName() {
        return bundeslandName;
    }

    public void setBundeslandName(String bundeslandName) {
        this.bundeslandName = bundeslandName;
    }

    public BundeslandEnum getBundeslandEnumKurz() {
        return bundeslandEnumKurz;
    }

    public void setBundeslandEnumKurz(BundeslandEnum bundeslandEnumKurz) {
        this.bundeslandEnumKurz = bundeslandEnumKurz;
    }
}
