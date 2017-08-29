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
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;
import org.woehlke.btw17.kandidaten.oodm.service.ListeParteiService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/listepartei")
public class ListeParteiController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "listePartei"
            ) Pageable pageable,
            Model model
    ) {
        Page<ListePartei> allListeParteiPage =  listeParteiService.getAll(pageable);
        model.addAttribute("listeparteien", allListeParteiPage);
        model.addAttribute("pageTitle","ListePartei");
        return "listepartei/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PathVariable("id") ListePartei listePartei, Model model
    ) {
        if(listePartei == null){
            throw new EntityNotFoundException();
        } else {
            String pageTitle = listePartei.getListePartei() + ", " + listePartei.getListeParteiLang();
            model.addAttribute("googleMapsApiKey",kandidatenProperties.getGoogleMapsApiKey());
            model.addAttribute("listePartei",listePartei);
            model.addAttribute("pageTitle",pageTitle);
            return "listepartei/id";
        }
    }

    private final ListeParteiService listeParteiService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public ListeParteiController(ListeParteiService listeParteiService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        this.listeParteiService = listeParteiService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }
}
