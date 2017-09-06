package org.woehlke.btw17.kandidaten.frontend.content;

import java.io.Serializable;

public class PageContent implements Serializable {

    private String pageTitle;

    private String pageSubTitle;

    private String pageSymbol;

    private String googleMapsApiKey;

    private String googleAnalyticsKey;

    private String pagerUrl;

    private String twitterCardSite;

    private String twitterCardCreator;

    private Boolean showDebugInfos;

    public PageContent(String pageTitle, String pageSubTitle, String pageSymbol, String googleMapsApiKey, String googleAnalyticsKey,String pagerUrl,String twitterCardSite,String twitterCardCreator,Boolean showDebugInfos) {
        this.pageTitle = pageTitle;
        this.pageSubTitle = pageSubTitle;
        this.pageSymbol = pageSymbol;
        this.googleMapsApiKey = googleMapsApiKey;
        this.googleAnalyticsKey = googleAnalyticsKey;
        this.pagerUrl = pagerUrl;
        this.twitterCardSite = twitterCardSite;
        this.twitterCardCreator = twitterCardCreator;
        this.showDebugInfos = showDebugInfos;
    }

    public String getPageTitleWithSymbol(){
        return pageSymbol + " " +  pageTitle;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageSubTitle() {
        return pageSubTitle;
    }

    public void setPageSubTitle(String pageSubTitle) {
        this.pageSubTitle = pageSubTitle;
    }

    public String getPageSymbol() {
        return pageSymbol;
    }

    public void setPageSymbol(String pageSymbol) {
        this.pageSymbol = pageSymbol;
    }

    public String getGoogleMapsApiKey() {
        return googleMapsApiKey;
    }

    public void setGoogleMapsApiKey(String googleMapsApiKey) {
        this.googleMapsApiKey = googleMapsApiKey;
    }

    public String getGoogleAnalyticsKey() {
        return googleAnalyticsKey;
    }

    public void setGoogleAnalyticsKey(String googleAnalyticsKey) {
        this.googleAnalyticsKey = googleAnalyticsKey;
    }

    public String getPagerUrl() {
        return pagerUrl;
    }

    public void setPagerUrl(String pagerUrl) {
        this.pagerUrl = pagerUrl;
    }

    public String getTwitterCardSite() {
        return "@"+twitterCardSite;
    }

    public void setTwitterCardSite(String twitterCardSite) {
        this.twitterCardSite = twitterCardSite;
    }

    public String getTwitterCardCreator() {
        return "@"+twitterCardCreator;
    }

    public void setTwitterCardCreator(String twitterCardCreator) {
        this.twitterCardCreator = twitterCardCreator;
    }

    public Boolean getShowDebugInfos() {
        return showDebugInfos;
    }

    public void setShowDebugInfos(Boolean showDebugInfos) {
        this.showDebugInfos = showDebugInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageContent)) return false;

        PageContent that = (PageContent) o;

        if (pageTitle != null ? !pageTitle.equals(that.pageTitle) : that.pageTitle != null) return false;
        if (pageSubTitle != null ? !pageSubTitle.equals(that.pageSubTitle) : that.pageSubTitle != null) return false;
        if (pageSymbol != null ? !pageSymbol.equals(that.pageSymbol) : that.pageSymbol != null) return false;
        if (googleMapsApiKey != null ? !googleMapsApiKey.equals(that.googleMapsApiKey) : that.googleMapsApiKey != null)
            return false;
        if (googleAnalyticsKey != null ? !googleAnalyticsKey.equals(that.googleAnalyticsKey) : that.googleAnalyticsKey != null)
            return false;
        if (pagerUrl != null ? !pagerUrl.equals(that.pagerUrl) : that.pagerUrl != null) return false;
        if (twitterCardSite != null ? !twitterCardSite.equals(that.twitterCardSite) : that.twitterCardSite != null)
            return false;
        if (twitterCardCreator != null ? !twitterCardCreator.equals(that.twitterCardCreator) : that.twitterCardCreator != null)
            return false;
        return showDebugInfos != null ? showDebugInfos.equals(that.showDebugInfos) : that.showDebugInfos == null;
    }

    @Override
    public int hashCode() {
        int result = pageTitle != null ? pageTitle.hashCode() : 0;
        result = 31 * result + (pageSubTitle != null ? pageSubTitle.hashCode() : 0);
        result = 31 * result + (pageSymbol != null ? pageSymbol.hashCode() : 0);
        result = 31 * result + (googleMapsApiKey != null ? googleMapsApiKey.hashCode() : 0);
        result = 31 * result + (googleAnalyticsKey != null ? googleAnalyticsKey.hashCode() : 0);
        result = 31 * result + (pagerUrl != null ? pagerUrl.hashCode() : 0);
        result = 31 * result + (twitterCardSite != null ? twitterCardSite.hashCode() : 0);
        result = 31 * result + (twitterCardCreator != null ? twitterCardCreator.hashCode() : 0);
        result = 31 * result + (showDebugInfos != null ? showDebugInfos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageContent{" +
                "pageTitle='" + pageTitle + '\'' +
                ", pageSubTitle='" + pageSubTitle + '\'' +
                ", pageSymbol='" + pageSymbol + '\'' +
                ", googleMapsApiKey='" + googleMapsApiKey + '\'' +
                ", googleAnalyticsKey='" + googleAnalyticsKey + '\'' +
                ", pagerUrl='" + pagerUrl + '\'' +
                ", twitterCardSite='" + twitterCardSite + '\'' +
                ", twitterCardCreator='" + twitterCardCreator + '\'' +
                ", showDebugInfos=" + showDebugInfos +
                '}';
    }
}


