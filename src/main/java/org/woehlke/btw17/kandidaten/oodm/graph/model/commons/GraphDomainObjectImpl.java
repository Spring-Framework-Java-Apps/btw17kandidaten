package org.woehlke.btw17.kandidaten.oodm.graph.model.commons;


import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.EditStatus;


public abstract class GraphDomainObjectImpl implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Index
    @Property(name="name")
    private String name;

    @Property(name="logo_url")
    private String logoUrl;

    @Property(name="symbol_bild")
    private String symbolBild;

    @Property(name="beschreibungs_text")
    private String beschreibungsText;

    @Property(name = "edit_status")
    private EditStatus editStatus = EditStatus.UNTOUCHED;

    protected GraphDomainObjectImpl() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getSymbolBild() {
        return symbolBild;
    }

    public void setSymbolBild(String symbolBild) {
        this.symbolBild = symbolBild;
    }

    public String getBeschreibungsText() {
        return beschreibungsText;
    }

    public void setBeschreibungsText(String beschreibungsText) {
        this.beschreibungsText = beschreibungsText;
    }

    public EditStatus getEditStatus() {
        return editStatus;
    }

    public void setEditStatus(EditStatus editStatus) {
        this.editStatus = editStatus;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUniqueId() {
        return getName()+"("+getId()+")";
    }
}
