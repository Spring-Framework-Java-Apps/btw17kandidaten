package org.woehlke.btw17.kandidaten.oodm.service;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.woehlke.btw17.kandidaten.KandidatenApplication;
import org.woehlke.btw17.kandidaten.configuration.spring.DataSourceConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.HttpSessionConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebMvcConfig;
import org.woehlke.btw17.kandidaten.configuration.spring.WebSecurityConfig;
import org.woehlke.btw17.kandidaten.oodm.model.Geburtsort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {
                KandidatenApplication.class,
                DataSourceConfig.class,
                HttpSessionConfig.class,
                WebMvcConfig.class,
                WebSecurityConfig.class
        },
        webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GeburtsortServiceTest {

    private static final Logger log = LoggerFactory.getLogger(GeburtsortServiceTest.class);

    @Autowired
    private GeburtsortService geburtsortService;

    @Commit
    @Test
    public void test000serviceIsPresentTest(){
        log.info("serviceIsPresentTest");
        assertThat(geburtsortService).isNotNull();
    }

    @Commit
    @Test
    public void test001getAll() throws Exception {

    }


    @Commit
    @Test
    public  void  test002findByGeburtsortTest() throws Exception {
        int page = FIRST_PAGE_NUMBER;
        int size = PAGE_SIZE;
        Pageable pageable = new PageRequest(page,size);
        Page<Geburtsort> geburtsorte = geburtsortService.getAll(pageable);
        int resultSize = geburtsorte.getNumber();
        log.debug("found: # "+resultSize);
        Assert.assertTrue("Page<Geburtsort> geburtsorte : "+resultSize,resultSize>0);
        boolean goOn = true;
        while(goOn) {
            for (Geburtsort geburtsort : geburtsorte.getContent()) {
                Geburtsort found = geburtsortService.findByGeburtsort(geburtsort.getGeburtsort());
                Assert.assertEquals(geburtsort.getId(), found.getId());
                log.debug("found: " + found.toString());
            }
            if (geburtsorte.hasNext()) {
                pageable = geburtsorte.nextPageable();
                geburtsorte = geburtsortService.getAll(pageable);
            } else {
                goOn = false;
            }
        }
    }

    @Commit
    @Test
    public void test003count() throws Exception {

    }

}
