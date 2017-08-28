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
import org.woehlke.btw17.kandidaten.oodm.model.KandidatFlat;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatFlatService;
import org.woehlke.btw17.kandidaten.oodm.service.KandidatService;

import javax.persistence.EntityNotFoundException;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_DEFAULT_SORT;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/kandidat")
public class KandidatController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                value = FIRST_PAGE_NUMBER,
                size = PAGE_SIZE,
                sort = PAGE_DEFAULT_SORT
            ) Pageable pageable,
            Model model
    ) {
        Page<KandidatFlat> allKandidatenPage =  kandidatFlatService.getAll(pageable);
        model.addAttribute("kandidaten", allKandidatenPage);
        return "kandidat/all";
    }

    @RequestMapping("/{id}")
    public String getUserForId(
            @PathVariable("id") KandidatFlat kandidatFlat, Model model
    ) {
        if(kandidatFlat == null){
            throw new EntityNotFoundException();
        } else {
            model.addAttribute("googleMapsApiKey",kandidatenProperties.getGoogleMapsApiKey());
            model.addAttribute("kandidat",kandidatFlat);
            return "kandidat/id";
        }
    }

    private final KandidatFlatService kandidatFlatService;

    private final KandidatService kandidatService;

    private final KandidatenProperties kandidatenProperties;

    @Autowired
    public KandidatController(KandidatFlatService kandidatFlatService, KandidatService kandidatService, KandidatenProperties kandidatenProperties) {
        this.kandidatFlatService = kandidatFlatService;
        this.kandidatService = kandidatService;
        this.kandidatenProperties = kandidatenProperties;
    }

}
