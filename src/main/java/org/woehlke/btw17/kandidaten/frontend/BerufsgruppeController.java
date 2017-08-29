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
import org.woehlke.btw17.kandidaten.oodm.service.BerufsgruppeService;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/berufsgruppe")
public class BerufsgruppeController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "berufsgruppe"
            ) Pageable pageable,
            Model model
    ) {
        Page<Berufsgruppe> allBerufsgruppePage =  berufsgruppeService.getAll(pageable);
        model.addAttribute("berufsgruppen", allBerufsgruppePage);
        model.addAttribute("pageTitle","Berufsgruppen");
        return "berufsgruppe/all";
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
            return "berufsgruppe/id";
        }
    }

    private final BerufsgruppeService berufsgruppeService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;



    @Autowired
    public BerufsgruppeController(BerufsgruppeService berufsgruppeService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        this.berufsgruppeService = berufsgruppeService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
