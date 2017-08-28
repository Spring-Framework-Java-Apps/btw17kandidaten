package org.woehlke.btw17.kandidaten.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.oodm.model.Bundesland;
import org.woehlke.btw17.kandidaten.oodm.service.BundeslandService;

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
        model.addAttribute("berufsgruppen", allBundeslandPage);
        return "bundesland/all";
    }

    private final BundeslandService bundeslandService;

    @Autowired
    public BundeslandController(BundeslandService bundeslandService) {
        this.bundeslandService = bundeslandService;
    }
}
