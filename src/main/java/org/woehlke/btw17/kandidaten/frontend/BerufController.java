package org.woehlke.btw17.kandidaten.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.oodm.model.Beruf;
import org.woehlke.btw17.kandidaten.oodm.service.BerufService;

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

    private final BerufService berufService;

    @Autowired
    public BerufController(BerufService berufService) {
        this.berufService = berufService;
    }
}
