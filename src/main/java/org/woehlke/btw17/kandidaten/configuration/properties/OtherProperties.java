package org.woehlke.btw17.kandidaten.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
@Validated
@ConfigurationProperties
public class OtherProperties {

    @Valid
    private Server server = new Server();

    @Validated
    public static class Server {

        @Valid
        private Error error = new Error();

        @Valid
        private Compression compression = new Compression();

        @Validated
        public static class Error {

            @NotNull
            private String path;

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

        }

        @Validated
        public static class Compression {

            @NotNull
            private Boolean enabled;

            @NotNull
            private Integer minResponseSize;

            public Boolean getEnabled() {
                return enabled;
            }

            public void setEnabled(Boolean enabled) {
                this.enabled = enabled;
            }

            public Integer getMinResponseSize() {
                return minResponseSize;
            }

            public void setMinResponseSize(Integer minResponseSize) {
                this.minResponseSize = minResponseSize;
            }
        }

        public Error getError() {
            return error;
        }

        public void setError(Error error) {
            this.error = error;
        }

        public Compression getCompression() {
            return compression;
        }

        public void setCompression(Compression compression) {
            this.compression = compression;
        }
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public String toString() {
        List<String> outputLines = new ArrayList<>();
        outputLines.add(" server.error.path =                                   "+this.getServer().getError().getPath());
        outputLines.add(" server.compression.enabled =                          "+this.getServer().getCompression().getEnabled());
        outputLines.add(" server.compression.min-response-size =                "+this.getServer().getCompression().getMinResponseSize());
        StringBuffer sb = new StringBuffer();
        for(String outputLine:outputLines){
            sb.append(outputLine);
            sb.append("\n");
        }
        return sb.toString();
    }
}
