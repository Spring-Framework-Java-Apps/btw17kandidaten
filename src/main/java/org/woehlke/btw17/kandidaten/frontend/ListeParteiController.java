package org.woehlke.btw17.kandidaten.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.woehlke.btw17.kandidaten.oodm.model.ListePartei;
import org.woehlke.btw17.kandidaten.oodm.service.ListeParteiService;

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
        return "listepartei/all";
    }

    private final ListeParteiService listeParteiService;

    @Autowired
    public ListeParteiController(ListeParteiService listeParteiService) {
        this.listeParteiService = listeParteiService;
    }
}
