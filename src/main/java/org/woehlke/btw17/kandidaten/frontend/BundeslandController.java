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
import org.woehlke.btw17.kandidaten.oodm.model.Berufsgruppe;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.service.BundeslandService;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/bundesland")
public class BundeslandController {


    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "bundesland"
            ) Pageable pageable,
            Model model
    ) {
        Page<Bundesland> allBundeslandPage =  bundeslandService.getAll(pageable);
        model.addAttribute("bundeslaender", allBundeslandPage);
        model.addAttribute("pageTitle","Bundesländer");
        return "bundesland/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PathVariable("id") Berufsgruppe berufsgruppe, Model model
    ) {
        if(berufsgruppe == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = berufsgruppe.getBerufsgruppe();
            model.addAttribute("googleMapsApiKey",kandidatenProperties.getGoogleMapsApiKey());
            model.addAttribute("berufsgruppe",berufsgruppe);
            model.addAttribute("pageTitle",pageTitle);
            return "bundesland/id";
        }
    }

    private final BundeslandService bundeslandService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public BundeslandController(BundeslandService bundeslandService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        this.bundeslandService = bundeslandService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
