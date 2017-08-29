package org.woehlke.btw17.kandidaten.oodm.service.impl;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.oodm.service.UrlService;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class UrlServiceImpl implements UrlService {

    private static final Logger log = LoggerFactory.getLogger(UrlServiceImpl.class);

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public UrlServiceImpl(KandidatenProperties kandidatenProperties) {
        this.kandidatenProperties = kandidatenProperties;
    }

    @Override
    public URL getFotoUrl(String fotoFileName) {
        List<String> urlPrefixes = kandidatenProperties.getUrlPrefixForKandidatFoto();
        for (String urlPrefix:urlPrefixes){
            String urlSource = urlPrefix + fotoFileName;
            String msg = "getFotoUrl " + urlSource + " ";
            log.debug(msg);
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpResponse = null;
            if (urlSource != null) {
                final long connTimeToLive = kandidatenProperties.getConnTimeToLive();
                final long maxIdleTime = kandidatenProperties.getMaxIdleTime();
                final TimeUnit connTimeToLiveTimeUnit = TimeUnit.SECONDS;
                httpclient = HttpClients.custom().setConnectionTimeToLive(connTimeToLive, connTimeToLiveTimeUnit).disableCookieManagement().evictIdleConnections(maxIdleTime, connTimeToLiveTimeUnit).build();
                HttpGet httpGetRequest = new HttpGet(urlSource);
                HttpClientContext context = HttpClientContext.create();
                //HttpHost httpTargetHost = context.getTargetHost();
                try {
                    httpResponse = httpclient.execute(httpGetRequest, context);
                    int statusCode = httpResponse.getStatusLine().getStatusCode();
                    if(statusCode == 200){
                        waitForApi();
                        return new URL(urlSource);
                    }
                    if(statusCode > 200 && statusCode < 300){
                        log.warn(msg+" HTTP-CODE: "+statusCode+" for: "+urlSource);
                        waitForApi();
                        return new URL(urlSource);
                    }
                } catch (IOException ioe) {
                    log.warn(msg + ioe.getMessage());
                } finally {
                    if(httpclient != null) {
                        try {
                            httpclient.close();
                        } catch (IOException ioe2) {
                            ioe2.printStackTrace();
                            log.warn(msg + ioe2.getMessage());
                        }
                    }
                }
            }
        }
        return null;
    }

    private void waitForApi(){
        int millisToWaitBetweenTwoApiCalls = kandidatenProperties.getMillisToWaitBetweenTwoApiCalls();
        long seed = (new Date()).getTime();
        Random random = new Random(seed);
        int msToWait = random.nextInt(millisToWaitBetweenTwoApiCalls);
        millisToWaitBetweenTwoApiCalls += msToWait;
        log.debug("### waiting now for (ms): "+millisToWaitBetweenTwoApiCalls);
        try {
            Thread.sleep(millisToWaitBetweenTwoApiCalls);
        } catch (InterruptedException e) {
        }
    }
}
