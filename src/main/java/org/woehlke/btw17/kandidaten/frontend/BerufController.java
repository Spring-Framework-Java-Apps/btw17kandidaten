package org.woehlke.btw17.kandidaten.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.configuration.KandidatenProperties;
import org.woehlke.btw17.kandidaten.oodm.model.Beruf;
import org.woehlke.btw17.kandidaten.oodm.service.BerufService;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/beruf")
public class BerufController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "beruf"
            ) Pageable pageable,
            Model model
    ) {
        Page<Beruf> allBerufPage =  berufService.getAll(pageable);
        model.addAttribute("berufe", allBerufPage);
        model.addAttribute("pageTitle","Berufe");
        return "beruf/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PathVariable("id") Beruf beruf, Model model
    ) {
        if(beruf == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = beruf.getBeruf();
            model.addAttribute("googleMapsApiKey",kandidatenProperties.getGoogleMapsApiKey());
            model.addAttribute("beruf",beruf);
            model.addAttribute("pageTitle",pageTitle);
            return "beruf/id";
        }
    }

    private final KandidatService kandidatService;

    private final BerufService berufService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public BerufController(KandidatService kandidatService, BerufService berufService, KandidatenProperties kandidatenProperties) {
        this.kandidatService = kandidatService;
        this.berufService = berufService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
