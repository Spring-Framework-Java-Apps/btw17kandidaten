package org.woehlke.btw17.kandidaten.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.oodm.model.Wohnort;
import org.woehlke.btw17.kandidaten.oodm.service.WohnortService;

import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.FIRST_PAGE_NUMBER;
import static org.woehlke.btw17.kandidaten.oodm.service.KandidatService.PAGE_SIZE;

@Controller
@RequestMapping("/wohnort")
public class WohnortController {

    @RequestMapping("/all")
    public String getAll(
            @PageableDefault(
                    value = FIRST_PAGE_NUMBER,
                    size = PAGE_SIZE,
                    sort = "wohnort"
            ) Pageable pageable,
            Model model
    ) {
        Page<Wohnort> allWohnortPage =  wohnortService.getAll(pageable);
        model.addAttribute("wohnorte", allWohnortPage);
        model.addAttribute("pageTitle","Wohnorte");
        return "wohnort/all";
    }

    private final WohnortService wohnortService;

    @Autowired
    public WohnortController(WohnortService wohnortService) {
        this.wohnortService = wohnortService;
    }
}
