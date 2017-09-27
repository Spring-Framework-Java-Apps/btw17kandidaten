package org.woehlke.btw17.kandidaten.configuration.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Component
@Validated
@ConfigurationProperties(prefix="spring")
public class SpringProperties {

    @Valid
    private Datasource datasource = new Datasource();

    @Valid
    private Jpa jpa = new Jpa();

    @Validated
    public static class Datasource {

        @NotNull
        private String driverClassName;

        @NotNull
        private String platform;

        @NotNull
        private String url;

        @NotNull
        private Boolean continueOnError;

        public String getDriverClassName() {
            return driverClassName;
        }

        public void setDriverClassName(String driverClassName) {
            this.driverClassName = driverClassName;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Boolean getContinueOnError() {
            return continueOnError;
        }

        public void setContinueOnError(Boolean continueOnError) {
            this.continueOnError = continueOnError;
        }
    }

    @Validated
    public static class Jpa {

        @NotNull
        private Boolean generateDdl;

        @NotNull
        private Boolean showSql;

        @Valid
        private Hibernate hibernate = new Hibernate();

        @Valid
        private Properties properties = new Properties();

        @Validated
        public static class Hibernate {

            @NotNull
            private String ddlAuto;

            public String getDdlAuto() {
                return ddlAuto;
            }

            public void setDdlAuto(String ddlAuto) {
                this.ddlAuto = ddlAuto;
            }
        }

        @Validated
        public static class Properties {

            @Valid
            private Hibernate hibernate = new Hibernate();

            @Validated
            private static class Hibernate {

                @NotNull
                private String dialect;

                public String getDialect() {
                    return dialect;
                }

                public void setDialect(String dialect) {
                    this.dialect = dialect;
                }
            }

            public Hibernate getHibernate() {
                return hibernate;
            }

            public void setHibernate(Hibernate hibernate) {
                this.hibernate = hibernate;
            }
        }

        public Hibernate getHibernate() {
            return hibernate;
        }

        public void setHibernate(Hibernate hibernate) {
            this.hibernate = hibernate;
        }

        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }

        public Boolean getGenerateDdl() {
            return generateDdl;
        }

        public void setGenerateDdl(Boolean generateDdl) {
            this.generateDdl = generateDdl;
        }

        public Boolean getShowSql() {
            return showSql;
        }

        public void setShowSql(Boolean showSql) {
            this.showSql = showSql;
        }
    }

    public Datasource getDatasource() {
        return datasource;
    }

    public void setDatasource(Datasource datasource) {
        this.datasource = datasource;
    }

    public Jpa getJpa() {
        return jpa;
    }

    public void setJpa(Jpa jpa) {
        this.jpa = jpa;
    }
}
