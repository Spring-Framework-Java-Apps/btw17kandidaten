package org.woehlke.btw17.kandidaten.frontend.content;

import org.woehlke.btw17.kandidaten.configuration.MySerializable;

public class ReportOverview implements MySerializable {

    private Integer countMdb;

    private Integer countKandidat;

    private Integer countMdbWithoutAbgeordnetenwatch;

    private Integer countMdbWithoutBundestagProfile;

    private Integer countMdbWithoutFotoUrl;

    private Integer countMdbWithoutFacebook;

    private Integer countMdbWithoutTwitter;

    private Integer countMdbWithoutWebseite;

    private Integer countMdbWithoutWikipediaArticle;

    private Integer countKandidatWithoutAbgeordnetenwatch;

    private Integer countKandidatWithoutFacebook;

    private Integer countKandidatWithoutWebseite;

    private Integer countKandidatWithoutFotoUrl;

    private Integer countKandidatWithoutLobbypediaUrl;

    private Integer countKandidatWithoutSoundcloud;

    private Integer countKandidatWithoutYoutube;

    private Integer countKandidatWithoutTwitter;


    public Integer getCountMdbWithoutAbgeordnetenwatch() {
        return countMdbWithoutAbgeordnetenwatch;
    }

    public Integer getCountMdb() {
        return countMdb;
    }

    public void setCountMdb(Integer countMdb) {
        this.countMdb = countMdb;
    }

    public Integer getCountKandidat() {
        return countKandidat;
    }

    public void setCountKandidat(Integer countKandidat) {
        this.countKandidat = countKandidat;
    }

    public void setCountMdbWithoutAbgeordnetenwatch(Integer countMdbWithoutAbgeordnetenwatch) {
        this.countMdbWithoutAbgeordnetenwatch = countMdbWithoutAbgeordnetenwatch;
    }

    public Integer getCountMdbWithoutBundestagProfile() {
        return countMdbWithoutBundestagProfile;
    }

    public void setCountMdbWithoutBundestagProfile(Integer countMdbWithoutBundestagProfile) {
        this.countMdbWithoutBundestagProfile = countMdbWithoutBundestagProfile;
    }

    public Integer getCountMdbWithoutFotoUrl() {
        return countMdbWithoutFotoUrl;
    }

    public void setCountMdbWithoutFotoUrl(Integer countMdbWithoutFotoUrl) {
        this.countMdbWithoutFotoUrl = countMdbWithoutFotoUrl;
    }

    public Integer getCountMdbWithoutFacebook() {
        return countMdbWithoutFacebook;
    }

    public void setCountMdbWithoutFacebook(Integer countMdbWithoutFacebook) {
        this.countMdbWithoutFacebook = countMdbWithoutFacebook;
    }

    public Integer getCountMdbWithoutTwitter() {
        return countMdbWithoutTwitter;
    }

    public void setCountMdbWithoutTwitter(Integer countMdbWithoutTwitter) {
        this.countMdbWithoutTwitter = countMdbWithoutTwitter;
    }

    public Integer getCountMdbWithoutWebseite() {
        return countMdbWithoutWebseite;
    }

    public void setCountMdbWithoutWebseite(Integer countMdbWithoutWebseite) {
        this.countMdbWithoutWebseite = countMdbWithoutWebseite;
    }

    public Integer getCountMdbWithoutWikipediaArticle() {
        return countMdbWithoutWikipediaArticle;
    }

    public void setCountMdbWithoutWikipediaArticle(Integer countMdbWithoutWikipediaArticle) {
        this.countMdbWithoutWikipediaArticle = countMdbWithoutWikipediaArticle;
    }

    public Integer getCountKandidatWithoutAbgeordnetenwatch() {
        return countKandidatWithoutAbgeordnetenwatch;
    }

    public void setCountKandidatWithoutAbgeordnetenwatch(Integer countKandidatWithoutAbgeordnetenwatch) {
        this.countKandidatWithoutAbgeordnetenwatch = countKandidatWithoutAbgeordnetenwatch;
    }

    public Integer getCountKandidatWithoutFacebook() {
        return countKandidatWithoutFacebook;
    }

    public void setCountKandidatWithoutFacebook(Integer countKandidatWithoutFacebook) {
        this.countKandidatWithoutFacebook = countKandidatWithoutFacebook;
    }

    public Integer getCountKandidatWithoutWebseite() {
        return countKandidatWithoutWebseite;
    }

    public void setCountKandidatWithoutWebseite(Integer countKandidatWithoutWebseite) {
        this.countKandidatWithoutWebseite = countKandidatWithoutWebseite;
    }

    public Integer getCountKandidatWithoutFotoUrl() {
        return countKandidatWithoutFotoUrl;
    }

    public void setCountKandidatWithoutFotoUrl(Integer countKandidatWithoutFotoUrl) {
        this.countKandidatWithoutFotoUrl = countKandidatWithoutFotoUrl;
    }

    public Integer getCountKandidatWithoutLobbypediaUrl() {
        return countKandidatWithoutLobbypediaUrl;
    }

    public void setCountKandidatWithoutLobbypediaUrl(Integer countKandidatWithoutLobbypediaUrl) {
        this.countKandidatWithoutLobbypediaUrl = countKandidatWithoutLobbypediaUrl;
    }

    public Integer getCountKandidatWithoutSoundcloud() {
        return countKandidatWithoutSoundcloud;
    }

    public void setCountKandidatWithoutSoundcloud(Integer countKandidatWithoutSoundcloud) {
        this.countKandidatWithoutSoundcloud = countKandidatWithoutSoundcloud;
    }

    public Integer getCountKandidatWithoutYoutube() {
        return countKandidatWithoutYoutube;
    }

    public void setCountKandidatWithoutYoutube(Integer countKandidatWithoutYoutube) {
        this.countKandidatWithoutYoutube = countKandidatWithoutYoutube;
    }

    public Integer getCountKandidatWithoutTwitter() {
        return countKandidatWithoutTwitter;
    }

    public void setCountKandidatWithoutTwitter(Integer countKandidatWithoutTwitter) {
        this.countKandidatWithoutTwitter = countKandidatWithoutTwitter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReportOverview)) return false;

        ReportOverview that = (ReportOverview) o;

        if (countMdb != null ? !countMdb.equals(that.countMdb) : that.countMdb != null) return false;
        if (countKandidat != null ? !countKandidat.equals(that.countKandidat) : that.countKandidat != null)
            return false;
        if (countMdbWithoutAbgeordnetenwatch != null ? !countMdbWithoutAbgeordnetenwatch.equals(that.countMdbWithoutAbgeordnetenwatch) : that.countMdbWithoutAbgeordnetenwatch != null)
            return false;
        if (countMdbWithoutBundestagProfile != null ? !countMdbWithoutBundestagProfile.equals(that.countMdbWithoutBundestagProfile) : that.countMdbWithoutBundestagProfile != null)
            return false;
        if (countMdbWithoutFotoUrl != null ? !countMdbWithoutFotoUrl.equals(that.countMdbWithoutFotoUrl) : that.countMdbWithoutFotoUrl != null)
            return false;
        if (countMdbWithoutFacebook != null ? !countMdbWithoutFacebook.equals(that.countMdbWithoutFacebook) : that.countMdbWithoutFacebook != null)
            return false;
        if (countMdbWithoutTwitter != null ? !countMdbWithoutTwitter.equals(that.countMdbWithoutTwitter) : that.countMdbWithoutTwitter != null)
            return false;
        if (countMdbWithoutWebseite != null ? !countMdbWithoutWebseite.equals(that.countMdbWithoutWebseite) : that.countMdbWithoutWebseite != null)
            return false;
        if (countMdbWithoutWikipediaArticle != null ? !countMdbWithoutWikipediaArticle.equals(that.countMdbWithoutWikipediaArticle) : that.countMdbWithoutWikipediaArticle != null)
            return false;
        if (countKandidatWithoutAbgeordnetenwatch != null ? !countKandidatWithoutAbgeordnetenwatch.equals(that.countKandidatWithoutAbgeordnetenwatch) : that.countKandidatWithoutAbgeordnetenwatch != null)
            return false;
        if (countKandidatWithoutFacebook != null ? !countKandidatWithoutFacebook.equals(that.countKandidatWithoutFacebook) : that.countKandidatWithoutFacebook != null)
            return false;
        if (countKandidatWithoutWebseite != null ? !countKandidatWithoutWebseite.equals(that.countKandidatWithoutWebseite) : that.countKandidatWithoutWebseite != null)
            return false;
        if (countKandidatWithoutFotoUrl != null ? !countKandidatWithoutFotoUrl.equals(that.countKandidatWithoutFotoUrl) : that.countKandidatWithoutFotoUrl != null)
            return false;
        if (countKandidatWithoutLobbypediaUrl != null ? !countKandidatWithoutLobbypediaUrl.equals(that.countKandidatWithoutLobbypediaUrl) : that.countKandidatWithoutLobbypediaUrl != null)
            return false;
        if (countKandidatWithoutSoundcloud != null ? !countKandidatWithoutSoundcloud.equals(that.countKandidatWithoutSoundcloud) : that.countKandidatWithoutSoundcloud != null)
            return false;
        if (countKandidatWithoutYoutube != null ? !countKandidatWithoutYoutube.equals(that.countKandidatWithoutYoutube) : that.countKandidatWithoutYoutube != null)
            return false;
        return countKandidatWithoutTwitter != null ? countKandidatWithoutTwitter.equals(that.countKandidatWithoutTwitter) : that.countKandidatWithoutTwitter == null;
    }

    @Override
    public int hashCode() {
        int result = countMdb != null ? countMdb.hashCode() : 0;
        result = 31 * result + (countKandidat != null ? countKandidat.hashCode() : 0);
        result = 31 * result + (countMdbWithoutAbgeordnetenwatch != null ? countMdbWithoutAbgeordnetenwatch.hashCode() : 0);
        result = 31 * result + (countMdbWithoutBundestagProfile != null ? countMdbWithoutBundestagProfile.hashCode() : 0);
        result = 31 * result + (countMdbWithoutFotoUrl != null ? countMdbWithoutFotoUrl.hashCode() : 0);
        result = 31 * result + (countMdbWithoutFacebook != null ? countMdbWithoutFacebook.hashCode() : 0);
        result = 31 * result + (countMdbWithoutTwitter != null ? countMdbWithoutTwitter.hashCode() : 0);
        result = 31 * result + (countMdbWithoutWebseite != null ? countMdbWithoutWebseite.hashCode() : 0);
        result = 31 * result + (countMdbWithoutWikipediaArticle != null ? countMdbWithoutWikipediaArticle.hashCode() : 0);
        result = 31 * result + (countKandidatWithoutAbgeordnetenwatch != null ? countKandidatWithoutAbgeordnetenwatch.hashCode() : 0);
        result = 31 * result + (countKandidatWithoutFacebook != null ? countKandidatWithoutFacebook.hashCode() : 0);
        result = 31 * result + (countKandidatWithoutWebseite != null ? countKandidatWithoutWebseite.hashCode() : 0);
        result = 31 * result + (countKandidatWithoutFotoUrl != null ? countKandidatWithoutFotoUrl.hashCode() : 0);
        result = 31 * result + (countKandidatWithoutLobbypediaUrl != null ? countKandidatWithoutLobbypediaUrl.hashCode() : 0);
        result = 31 * result + (countKandidatWithoutSoundcloud != null ? countKandidatWithoutSoundcloud.hashCode() : 0);
        result = 31 * result + (countKandidatWithoutYoutube != null ? countKandidatWithoutYoutube.hashCode() : 0);
        result = 31 * result + (countKandidatWithoutTwitter != null ? countKandidatWithoutTwitter.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReportOverview{" +
                "countMdb=" + countMdb +
                ", countKandidat=" + countKandidat +
                ", countMdbWithoutAbgeordnetenwatch=" + countMdbWithoutAbgeordnetenwatch +
                ", countMdbWithoutBundestagProfile=" + countMdbWithoutBundestagProfile +
                ", countMdbWithoutFotoUrl=" + countMdbWithoutFotoUrl +
                ", countMdbWithoutFacebook=" + countMdbWithoutFacebook +
                ", countMdbWithoutTwitter=" + countMdbWithoutTwitter +
                ", countMdbWithoutWebseite=" + countMdbWithoutWebseite +
                ", countMdbWithoutWikipediaArticle=" + countMdbWithoutWikipediaArticle +
                ", countKandidatWithoutAbgeordnetenwatch=" + countKandidatWithoutAbgeordnetenwatch +
                ", countKandidatWithoutFacebook=" + countKandidatWithoutFacebook +
                ", countKandidatWithoutWebseite=" + countKandidatWithoutWebseite +
                ", countKandidatWithoutFotoUrl=" + countKandidatWithoutFotoUrl +
                ", countKandidatWithoutLobbypediaUrl=" + countKandidatWithoutLobbypediaUrl +
                ", countKandidatWithoutSoundcloud=" + countKandidatWithoutSoundcloud +
                ", countKandidatWithoutYoutube=" + countKandidatWithoutYoutube +
                ", countKandidatWithoutTwitter=" + countKandidatWithoutTwitter +
                '}';
    }
}
