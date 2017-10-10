package org.woehlke.btw17.kandidaten.frontend.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReportOverview implements Serializable {

    private Long countMdb;

    private Long countKandidat;

    private Long countMdbWithoutAbgeordnetenwatch;

    private Long countMdbWithoutBundestagProfile;

    private Long countMdbWithoutFotoUrl;

    private Long countMdbWithoutFacebook;

    private Long countMdbWithoutTwitter;

    private Long countMdbWithoutWebseite;

    private Long countMdbWithoutWikipediaArticle;

    private Long countKandidatWithoutAbgeordnetenwatch;

    private Long countKandidatWithoutFacebook;

    private Long countKandidatWithoutWebseite;

    private Long countKandidatWithoutFotoUrl;

    private Long countKandidatWithoutLobbypediaUrl;

    private Long countKandidatWithoutSoundcloud;

    private Long countKandidatWithoutYoutube;

    private Long countKandidatWithoutTwitter;

    public Long getCountMdb() {
        return countMdb;
    }

    public void setCountMdb(Long countMdb) {
        this.countMdb = countMdb;
    }

    public Long getCountKandidat() {
        return countKandidat;
    }

    public void setCountKandidat(Long countKandidat) {
        this.countKandidat = countKandidat;
    }

    public Long getCountMdbWithoutAbgeordnetenwatch() {
        return countMdbWithoutAbgeordnetenwatch;
    }

    public void setCountMdbWithoutAbgeordnetenwatch(Long countMdbWithoutAbgeordnetenwatch) {
        this.countMdbWithoutAbgeordnetenwatch = countMdbWithoutAbgeordnetenwatch;
    }

    public Long getCountMdbWithoutBundestagProfile() {
        return countMdbWithoutBundestagProfile;
    }

    public void setCountMdbWithoutBundestagProfile(Long countMdbWithoutBundestagProfile) {
        this.countMdbWithoutBundestagProfile = countMdbWithoutBundestagProfile;
    }

    public Long getCountMdbWithoutFotoUrl() {
        return countMdbWithoutFotoUrl;
    }

    public void setCountMdbWithoutFotoUrl(Long countMdbWithoutFotoUrl) {
        this.countMdbWithoutFotoUrl = countMdbWithoutFotoUrl;
    }

    public Long getCountMdbWithoutFacebook() {
        return countMdbWithoutFacebook;
    }

    public void setCountMdbWithoutFacebook(Long countMdbWithoutFacebook) {
        this.countMdbWithoutFacebook = countMdbWithoutFacebook;
    }

    public Long getCountMdbWithoutTwitter() {
        return countMdbWithoutTwitter;
    }

    public void setCountMdbWithoutTwitter(Long countMdbWithoutTwitter) {
        this.countMdbWithoutTwitter = countMdbWithoutTwitter;
    }

    public Long getCountMdbWithoutWebseite() {
        return countMdbWithoutWebseite;
    }

    public void setCountMdbWithoutWebseite(Long countMdbWithoutWebseite) {
        this.countMdbWithoutWebseite = countMdbWithoutWebseite;
    }

    public Long getCountMdbWithoutWikipediaArticle() {
        return countMdbWithoutWikipediaArticle;
    }

    public void setCountMdbWithoutWikipediaArticle(Long countMdbWithoutWikipediaArticle) {
        this.countMdbWithoutWikipediaArticle = countMdbWithoutWikipediaArticle;
    }

    public Long getCountKandidatWithoutAbgeordnetenwatch() {
        return countKandidatWithoutAbgeordnetenwatch;
    }

    public void setCountKandidatWithoutAbgeordnetenwatch(Long countKandidatWithoutAbgeordnetenwatch) {
        this.countKandidatWithoutAbgeordnetenwatch = countKandidatWithoutAbgeordnetenwatch;
    }

    public Long getCountKandidatWithoutFacebook() {
        return countKandidatWithoutFacebook;
    }

    public void setCountKandidatWithoutFacebook(Long countKandidatWithoutFacebook) {
        this.countKandidatWithoutFacebook = countKandidatWithoutFacebook;
    }

    public Long getCountKandidatWithoutWebseite() {
        return countKandidatWithoutWebseite;
    }

    public void setCountKandidatWithoutWebseite(Long countKandidatWithoutWebseite) {
        this.countKandidatWithoutWebseite = countKandidatWithoutWebseite;
    }

    public Long getCountKandidatWithoutFotoUrl() {
        return countKandidatWithoutFotoUrl;
    }

    public void setCountKandidatWithoutFotoUrl(Long countKandidatWithoutFotoUrl) {
        this.countKandidatWithoutFotoUrl = countKandidatWithoutFotoUrl;
    }

    public Long getCountKandidatWithoutLobbypediaUrl() {
        return countKandidatWithoutLobbypediaUrl;
    }

    public void setCountKandidatWithoutLobbypediaUrl(Long countKandidatWithoutLobbypediaUrl) {
        this.countKandidatWithoutLobbypediaUrl = countKandidatWithoutLobbypediaUrl;
    }

    public Long getCountKandidatWithoutSoundcloud() {
        return countKandidatWithoutSoundcloud;
    }

    public void setCountKandidatWithoutSoundcloud(Long countKandidatWithoutSoundcloud) {
        this.countKandidatWithoutSoundcloud = countKandidatWithoutSoundcloud;
    }

    public Long getCountKandidatWithoutYoutube() {
        return countKandidatWithoutYoutube;
    }

    public void setCountKandidatWithoutYoutube(Long countKandidatWithoutYoutube) {
        this.countKandidatWithoutYoutube = countKandidatWithoutYoutube;
    }

    public Long getCountKandidatWithoutTwitter() {
        return countKandidatWithoutTwitter;
    }

    public void setCountKandidatWithoutTwitter(Long countKandidatWithoutTwitter) {
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
        List<String> outputLines = new ArrayList<>();
        outputLines.add(" Mdb:                                                  "+this.getCountMdb());
        outputLines.add("  Mdb without Abgeordnetenwatch:                       "+this.getCountMdbWithoutAbgeordnetenwatch());
        outputLines.add("  Mdb without FotoUrl:                                 "+this.getCountMdbWithoutFotoUrl());
        outputLines.add("  Mdb without BundestagProfile:                        "+this.getCountMdbWithoutBundestagProfile());
        outputLines.add("  Mdb without WikipediaArticle:                        "+this.getCountMdbWithoutWikipediaArticle());
        outputLines.add("  Mdb without Twitter:                                 "+this.getCountMdbWithoutTwitter());
        outputLines.add("  Mdb without Facebook:                                "+this.getCountMdbWithoutFacebook());
        outputLines.add("  Mdb without Webseite:                                "+this.getCountMdbWithoutWebseite());
        outputLines.add(" Kandidat:                                             "+this.getCountKandidat());
        outputLines.add("  Kandidat without Abgeordnetenwatch:                  "+this.getCountKandidatWithoutAbgeordnetenwatch());
        outputLines.add("  Kandidat without FotoUrl:                            "+this.getCountKandidatWithoutFotoUrl());
        outputLines.add("  Kandidat without Twitter:                            "+this.getCountKandidatWithoutTwitter());
        outputLines.add("  Kandidat without Facebook:                           "+this.getCountKandidatWithoutFacebook());
        outputLines.add("  Kandidat without Webseite:                           "+this.getCountKandidatWithoutWebseite());
        outputLines.add("  Kandidat without LobbypediaUrl:                      "+this.getCountKandidatWithoutLobbypediaUrl());
        outputLines.add("  Kandidat without Soundcloud:                         "+this.getCountKandidatWithoutSoundcloud());
        outputLines.add("  Kandidat without Youtube:                            "+this.getCountKandidatWithoutYoutube());
        StringBuffer sb = new StringBuffer();
        for(String outputLine:outputLines){
            sb.append(outputLine);
            sb.append("\n");
        }
        return sb.toString();
    }
}
