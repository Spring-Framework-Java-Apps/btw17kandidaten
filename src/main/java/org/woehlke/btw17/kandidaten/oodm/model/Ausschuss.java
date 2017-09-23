package org.woehlke.btw17.kandidaten.oodm.model;



import org.woehlke.btw17.kandidaten.oodm.model.listener.AusschussListener;
import org.woehlke.btw17.kandidaten.oodm.model.parts.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @see org.woehlke.btw17.kandidaten.frontend.controller.anonymoususer.data.AusschussController
 * @see org.woehlke.btw17.kandidaten.frontend.controller.redaktion.data.AusschussRedaktionController
 *
 * @see org.woehlke.btw17.kandidaten.oodm.model.Kandidat
 */
@Entity
@Table(
    name = "ausschuss",
    uniqueConstraints = {
        @UniqueConstraint(name="unique_ausschuss",columnNames = {"ausschuss"})
    }
)
@NamedQueries({
    @NamedQuery(
        name = "Ausschuss.getAll",
        query = "select o from Ausschuss as o order by ausschuss"
    ),
    @NamedQuery(
        name = "Ausschuss.getAllCount",
        query = "select count(o) from Ausschuss as o"
    )
})
@EntityListeners(AusschussListener.class)
public class Ausschuss implements DomainObject,CommonFieldsEmbedded,OnlineStrategieEmbedded {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name="ausschuss")
    private String ausschuss;

    //@NotNull
    @Valid
    @Embedded
    private CommonFields commonFields = new CommonFields();

    //@NotNull
    @Valid
    @Embedded
    private OnlineStrategie onlineStrategie = new OnlineStrategie();

    @Override
    public Long getId() {
        return id;
    }

    @Transient
    @Override
    public String getName() {
        return ausschuss;
    }

    @Transient
    @Override
    public String getUniqueId() {
        return id + ":"+this.getName();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAusschuss() {
        return ausschuss;
    }

    public void setAusschuss(String ausschuss) {
        this.ausschuss = ausschuss;
    }

    public OnlineStrategie getOnlineStrategie() {
        return onlineStrategie;
    }

    public void setOnlineStrategie(OnlineStrategie onlineStrategie) {
        if(onlineStrategie != null){
            this.onlineStrategie = onlineStrategie;
        }
    }

    public CommonFields getCommonFields() {
        return commonFields;
    }

    public void setCommonFields(CommonFields commonFields) {
        if(commonFields!=null){
            this.commonFields = commonFields;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ausschuss)) return false;

        Ausschuss ausschuss1 = (Ausschuss) o;

        if (id != null ? !id.equals(ausschuss1.id) : ausschuss1.id != null) return false;
        if (ausschuss != null ? !ausschuss.equals(ausschuss1.ausschuss) : ausschuss1.ausschuss != null) return false;
        if (commonFields != null ? !commonFields.equals(ausschuss1.commonFields) : ausschuss1.commonFields != null)
            return false;
        return onlineStrategie != null ? onlineStrategie.equals(ausschuss1.onlineStrategie) : ausschuss1.onlineStrategie == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ausschuss != null ? ausschuss.hashCode() : 0);
        result = 31 * result + (commonFields != null ? commonFields.hashCode() : 0);
        result = 31 * result + (onlineStrategie != null ? onlineStrategie.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ausschuss{" +
                "id=" + id +
                ", ausschuss='" + ausschuss + '\'' +
                ", commonFields=" + commonFields +
                ", onlineStrategie=" + onlineStrategie +
                '}';
    }
}
