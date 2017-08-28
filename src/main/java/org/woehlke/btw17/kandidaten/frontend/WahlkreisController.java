package org.woehlke.btw17.kandidaten.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.service.WahlkreisService;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/wahlkreis")
public class WahlkreisController {


    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "wahlkreisName"
            ) Pageable pageable,
            Model model
    ) {
        Page<Wahlkreis> allWahlkreisPage =  wahlkreisService.getAll(pageable);
        model.addAttribute("wahlkreise", allWahlkreisPage);
        model.addAttribute("pageTitle","Wahlkreise");
        return "wahlkreis/all";
    }


    private final WahlkreisService wahlkreisService;

    @Autowired
    public WahlkreisController(WahlkreisService wahlkreisService) {
        this.wahlkreisService = wahlkreisService;
    }
}
