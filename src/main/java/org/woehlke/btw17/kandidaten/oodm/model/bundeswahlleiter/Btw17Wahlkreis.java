package org.woehlke.btw17.kandidaten.oodm.model.bundeswahlleiter;

import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.listener.Btw17WahlkreisListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.DomainObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(
    name = "btw17_wahlkreis",
    uniqueConstraints = {
        @UniqueConstraint(name="uk_btw17_wahlkreis",columnNames = {"wahlkreis_nummer","wahlkreis_name"}),
        @UniqueConstraint(name="uk_btw17_wahlkreis_wahlkreis_nummer",columnNames = {"wahlkreis_nummer"})
    },
    indexes = {
        @Index(name = "idx_btw17_wahlkreisnamen_bundesland_nummer", columnList = "bundesland_nummer"),
        @Index(name = "idx_btw17_wahlkreisnamen_bundesland_name", columnList = "bundesland_name"),
        @Index(name = "idx_btw17_wahlkreisnamen_bundesland_kurz", columnList = "bundesland_kurz"),
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Btw17Wahlkreis.getAllIds",
        query = "select o.id from Btw17Wahlkreis as o order by o.id"
    ),
    @NamedQuery(
        name = "Btw17Wahlkreis.getMaxId",
        query = "select max(o.id) from Btw17Wahlkreis as o"
    ),
    @NamedQuery(
        name = "Btw17Wahlkreis.findByBundeslandNummer",
        query = "select distinct o.bundeslandEnumKurz from Btw17Wahlkreis as o where o.bundeslandNummer=:bundeslandNummer group by o.bundeslandEnumKurz"
    )
})
@EntityListeners(Btw17WahlkreisListener.class)
public class Btw17Wahlkreis implements DomainObject {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "wahlkreis_nummer", nullable=false, unique = true)
    private Long wahlkreisNummer;

    @Column(name = "wahlkreis_name", nullable=false)
    private String wahlkreisName;

    @Column(name = "bundesland_nummer", nullable=false)
    private Long bundeslandNummer;

    @Column(name = "bundesland_name", nullable=false)
    private String bundeslandName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "bundesland_kurz", nullable=false)
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

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Btw17Wahlkreis)) return false;

        Btw17Wahlkreis that = (Btw17Wahlkreis) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (wahlkreisNummer != null ? !wahlkreisNummer.equals(that.wahlkreisNummer) : that.wahlkreisNummer != null)
            return false;
        if (wahlkreisName != null ? !wahlkreisName.equals(that.wahlkreisName) : that.wahlkreisName != null)
            return false;
        if (bundeslandNummer != null ? !bundeslandNummer.equals(that.bundeslandNummer) : that.bundeslandNummer != null)
            return false;
        if (bundeslandName != null ? !bundeslandName.equals(that.bundeslandName) : that.bundeslandName != null)
            return false;
        return bundeslandEnumKurz == that.bundeslandEnumKurz;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (wahlkreisNummer != null ? wahlkreisNummer.hashCode() : 0);
        result = 31 * result + (wahlkreisName != null ? wahlkreisName.hashCode() : 0);
        result = 31 * result + (bundeslandNummer != null ? bundeslandNummer.hashCode() : 0);
        result = 31 * result + (bundeslandName != null ? bundeslandName.hashCode() : 0);
        result = 31 * result + (bundeslandEnumKurz != null ? bundeslandEnumKurz.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Btw17Wahlkreis{" +
                "id=" + id +
                ", wahlkreisNummer=" + wahlkreisNummer +
                ", wahlkreisName='" + wahlkreisName + '\'' +
                ", bundeslandNummer=" + bundeslandNummer +
                ", bundeslandName='" + bundeslandName + '\'' +
                ", bundeslandEnumKurz=" + bundeslandEnumKurz +
                '}';
    }
}
