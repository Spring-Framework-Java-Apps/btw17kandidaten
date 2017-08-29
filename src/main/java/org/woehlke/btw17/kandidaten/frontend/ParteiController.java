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
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.model.Partei;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.service.ParteiService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/partei")
public class ParteiController {


    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "partei"
            ) Pageable pageable,
            Model model
    ) {
        Page<Partei> allListeParteiPage =  parteiService.getAll(pageable);
        model.addAttribute("parteien", allListeParteiPage);
        model.addAttribute("pageTitle","Parteien");
        return "partei/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PathVariable("id") Partei partei, Model model
    ) {
        if(partei == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = partei.getPartei() + ", " + partei.getParteiLang();
            model.addAttribute("googleMapsApiKey",kandidatenProperties.getGoogleMapsApiKey());
            model.addAttribute("partei",partei);
            model.addAttribute("pageTitle",pageTitle);
            return "partei/id";
        }
    }

    private final ParteiService parteiService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public ParteiController(ParteiService parteiService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        this.parteiService = parteiService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
