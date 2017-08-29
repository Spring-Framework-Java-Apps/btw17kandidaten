package org.woehlke.btw17.kandidaten.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@Validated
@ConfigurationProperties(prefix="btw17.kandidaten")
public class KandidatenProperties {

    @NotNull
    private Integer pageSize;

    @NotNull
    private String loginUsername;

    @NotNull
    private String loginPassword;

    @NotNull
    private List<String> webSecurityConfigPublicPaths;

    @NotNull
    private List<String> urlPrefixForKandidatFoto;

    @NotNull
    private String googleMapsApiKey;

    @NotNull
    private String googleAnalyticsKey;

    @NotNull
    private Long connTimeToLive;

    @NotNull
    private Long maxIdleTime;

    @NotNull
    private Integer millisToWaitBetweenTwoApiCalls;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public List<String> getWebSecurityConfigPublicPaths() {
        return webSecurityConfigPublicPaths;
    }

    public void setWebSecurityConfigPublicPaths(List<String> webSecurityConfigPublicPaths) {
        this.webSecurityConfigPublicPaths = webSecurityConfigPublicPaths;
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

    public Long getConnTimeToLive() {
        return connTimeToLive;
    }

    public void setConnTimeToLive(Long connTimeToLive) {
        this.connTimeToLive = connTimeToLive;
    }

    public Long getMaxIdleTime() {
        return maxIdleTime;
    }

    public void setMaxIdleTime(Long maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }

    public Integer getMillisToWaitBetweenTwoApiCalls() {
        return millisToWaitBetweenTwoApiCalls;
    }

    public void setMillisToWaitBetweenTwoApiCalls(Integer millisToWaitBetweenTwoApiCalls) {
        this.millisToWaitBetweenTwoApiCalls = millisToWaitBetweenTwoApiCalls;
    }

    public List<String> getUrlPrefixForKandidatFoto() {
        return urlPrefixForKandidatFoto;
    }

    public void setUrlPrefixForKandidatFoto(List<String> urlPrefixForKandidatFoto) {
        this.urlPrefixForKandidatFoto = urlPrefixForKandidatFoto;
    }

    public String[] getWebSecurityConfigPublicPathsAsArray() {
        int size = webSecurityConfigPublicPaths.size();
        String[] myArray = new String[size];
        for(int i=0; i<size; i++){
            myArray[i] = webSecurityConfigPublicPaths.get(i);
        }
        return myArray;
    }
}
