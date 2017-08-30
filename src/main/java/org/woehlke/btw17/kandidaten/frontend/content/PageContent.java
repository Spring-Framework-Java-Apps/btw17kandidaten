package org.woehlke.btw17.kandidaten.frontend.content;

import java.io.Serializable;

public class PageContent implements Serializable {

    private String pageTitle;

    private String pageSubTitle;

    private String pageSymbol;

    private String googleMapsApiKey;

    private String googleAnalyticsKey;

    private String pagerUrl;

    public PageContent(String pageTitle, String pageSubTitle, String pageSymbol, String googleMapsApiKey, String googleAnalyticsKey,String pagerUrl) {
        this.pageTitle = pageTitle;
        this.pageSubTitle = pageSubTitle;
        this.pageSymbol = pageSymbol;
        this.googleMapsApiKey = googleMapsApiKey;
        this.googleAnalyticsKey = googleAnalyticsKey;
        this.pagerUrl = pagerUrl;
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
        return pagerUrl != null ? pagerUrl.equals(that.pagerUrl) : that.pagerUrl == null;
    }

    @Override
    public int hashCode() {
        int result = pageTitle != null ? pageTitle.hashCode() : 0;
        result = 31 * result + (pageSubTitle != null ? pageSubTitle.hashCode() : 0);
        result = 31 * result + (pageSymbol != null ? pageSymbol.hashCode() : 0);
        result = 31 * result + (googleMapsApiKey != null ? googleMapsApiKey.hashCode() : 0);
        result = 31 * result + (googleAnalyticsKey != null ? googleAnalyticsKey.hashCode() : 0);
        result = 31 * result + (pagerUrl != null ? pagerUrl.hashCode() : 0);
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
                '}';
    }
}


