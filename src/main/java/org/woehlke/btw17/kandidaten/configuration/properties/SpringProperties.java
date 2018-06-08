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
@ConfigurationProperties(prefix="spring")
public class SpringProperties {

    @NotNull
    private String profiles;

    @Valid
    private Data data = new Data();

    @Valid
    private Datasource datasource = new Datasource();

    @Valid
    private Jpa jpa = new Jpa();

    @Valid
    private Session session = new Session();

    @Valid
    private Template template = new Template();

    @Valid
    private Thymeleaf thymeleaf = new Thymeleaf();

    @Validated
    public static class Data {

        @Valid
        private Neo4j neo4j = new Neo4j();

        @Valid
        private Redis redis = new Redis();

        @Valid
        private Jpa jpa = new Jpa();

        @Valid
        private Web web = new Web();

        @Validated
        public static class Neo4j {

            @NotNull
            private String uri;

            @NotNull
            private Boolean openInView;

            @NotNull
            private String username;

            @NotNull
            private String password;

            @Valid
            private Repositories repositories = new Repositories();

            @Validated
            public static class Repositories {

                @NotNull
                private Boolean enabled;

                public Boolean getEnabled() {
                    return enabled;
                }

                public void setEnabled(Boolean enabled) {
                    this.enabled = enabled;
                }
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public Boolean getOpenInView() {
                return openInView;
            }

            public void setOpenInView(Boolean openInView) {
                this.openInView = openInView;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public Repositories getRepositories() {
                return repositories;
            }

            public void setRepositories(Repositories repositories) {
                this.repositories = repositories;
            }
        }

        @Validated
        public static class Redis {

            @NotNull
            private String host;

            @NotNull
            private String password;

            @NotNull
            private Long port;

            public String getHost() {
                return host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public Long getPort() {
                return port;
            }

            public void setPort(Long port) {
                this.port = port;
            }
        }

        @Validated
        public static class Jpa {

            @Valid
            private Repositories repositories = new Repositories();

            @Validated
            public static class Repositories {

                @NotNull
                private Boolean enabled;

                public Boolean getEnabled() {
                    return enabled;
                }

                public void setEnabled(Boolean enabled) {
                    this.enabled = enabled;
                }
            }

            public Repositories getRepositories() {
                return repositories;
            }

            public void setRepositories(Repositories repositories) {
                this.repositories = repositories;
            }
        }

        @Validated
        public static class Web {

            @Valid
            private Pageable pageable = new Pageable();

            @Validated
            public static class Pageable {

                @NotNull
                private Integer defaultPageSize;

                @NotNull
                private Integer maxPageSize;

                @NotNull
                private String pageParameter;

                @NotNull
                private String sizeParameter;

                public Integer getDefaultPageSize() {
                    return defaultPageSize;
                }

                public void setDefaultPageSize(Integer defaultPageSize) {
                    this.defaultPageSize = defaultPageSize;
                }

                public Integer getMaxPageSize() {
                    return maxPageSize;
                }

                public void setMaxPageSize(Integer maxPageSize) {
                    this.maxPageSize = maxPageSize;
                }

                public String getPageParameter() {
                    return pageParameter;
                }

                public void setPageParameter(String pageParameter) {
                    this.pageParameter = pageParameter;
                }

                public String getSizeParameter() {
                    return sizeParameter;
                }

                public void setSizeParameter(String sizeParameter) {
                    this.sizeParameter = sizeParameter;
                }
            }

            public Pageable getPageable() {
                return pageable;
            }

            public void setPageable(Pageable pageable) {
                this.pageable = pageable;
            }
        }

        public Neo4j getNeo4j() {
            return neo4j;
        }

        public void setNeo4j(Neo4j neo4j) {
            this.neo4j = neo4j;
        }

        public Redis getRedis() {
            return redis;
        }

        public void setRedis(Redis redis) {
            this.redis = redis;
        }

        public Jpa getJpa() {
            return jpa;
        }

        public void setJpa(Jpa jpa) {
            this.jpa = jpa;
        }

        public Web getWeb() {
            return web;
        }

        public void setWeb(Web web) {
            this.web = web;
        }
    }

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

        @NotNull
        private Boolean openInView;

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
            public static class Hibernate {

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

        public Boolean getOpenInView() {
            return openInView;
        }

        public void setOpenInView(Boolean openInView) {
            this.openInView = openInView;
        }

    }

    @Validated
    public static class Session {

        @NotNull
        private String storeType;

        @Valid
        private Initializer initializer = new Initializer();

        @Validated
        public static class Initializer {

            @NotNull
            private Boolean enabled;

            public Boolean getEnabled() {
                return enabled;
            }

            public void setEnabled(Boolean enabled) {
                this.enabled = enabled;
            }
        }

        public Initializer getInitializer() {
            return initializer;
        }

        public void setInitializer(Initializer initializer) {
            this.initializer = initializer;
        }

        public String getStoreType() {
            return storeType;
        }

        public void setStoreType(String storeType) {
            this.storeType = storeType;
        }
    }

    @Validated
    public static class Template {

        @NotNull
        private Boolean cache;

        public Boolean getCache() {
            return cache;
        }

        public void setCache(Boolean cache) {
            this.cache = cache;
        }
    }

    @Validated
    public static class Thymeleaf {

        @NotNull
        private Boolean cache;

        public Boolean getCache() {
            return cache;
        }

        public void setCache(Boolean cache) {
            this.cache = cache;
        }
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
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

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Thymeleaf getThymeleaf() {
        return thymeleaf;
    }

    public void setThymeleaf(Thymeleaf thymeleaf) {
        this.thymeleaf = thymeleaf;
    }

    public String getProfiles() {
        return profiles;
    }

    public void setProfiles(String profiles) {
        this.profiles = profiles;
    }

    @Override
    public String toString() {
        List<String> outputLines = new ArrayList<>();
        outputLines.add("spring.profiles =                                     "+this.getProfiles());
        outputLines.add("spring.template.cache =                               "+this.getTemplate().getCache());
        outputLines.add("spring.thymeleaf.cache =                              "+this.getThymeleaf().getCache());
        outputLines.add("spring.jpa.open-in-view =                             "+this.getJpa().getOpenInView());
        outputLines.add("spring.jpa.hibernate.ddl-auto =                       "+this.getJpa().getHibernate().getDdlAuto());
        outputLines.add("spring.jpa.properties.hibernate.dialect =             "+this.getJpa().getProperties().getHibernate().getDialect());
        outputLines.add("spring.jpa.show-sql =                                 "+this.getJpa().getShowSql());
        outputLines.add("spring.session.store-type =                           "+this.getSession().getStoreType());
        outputLines.add("spring.session.jdbc.initializer.enabled =             "+this.getSession().getInitializer().getEnabled());
        outputLines.add("spring.datasource.driverClassName =                   "+this.getDatasource().getDriverClassName());
        outputLines.add("spring.datasource.platform =                          "+this.getDatasource().getPlatform());
        outputLines.add("spring.datasource.continue-on-error =                 "+this.getDatasource().getContinueOnError());
        outputLines.add("spring.datasource.url =                               "+this.getDatasource().getUrl());
        StringBuffer sb = new StringBuffer();
        for(String outputLine:outputLines){
            sb.append(" ");
            sb.append(outputLine);
            sb.append("\n");
        }
        return sb.toString();
    }
}
