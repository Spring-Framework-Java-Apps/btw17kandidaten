package org.woehlke.btw17.kandidaten.frontend.controller.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.woehlke.btw17.kandidaten.frontend.content.FreitextSucheFormular;
import org.woehlke.btw17.kandidaten.frontend.content.SearchForKandidat;
import org.woehlke.btw17.kandidaten.frontend.content.SessionHandler;

import javax.servlet.http.HttpSession;

public class AbstractController {

    @ModelAttribute("suchformularFreitext")
    public FreitextSucheFormular addSuchformularFreitext(HttpSession session, Model model) {
        log.debug("addSuchformularFreitext");
        FreitextSucheFormular suchformularFreitext = sessionHandler.fetchOrCreateFreitextSucheFormular(session,model);
        return suchformularFreitext;
    }

    @ModelAttribute("suchformular")
    public SearchForKandidat addSuchformular(HttpSession session, Model model) {
        log.debug("suchformular");
        SearchForKandidat suchformular = sessionHandler.fetchOrCreateSucheFormular(session,model);
        return suchformular;
    }

    private static final Logger log = LoggerFactory.getLogger(AbstractController.class);

    protected final SessionHandler sessionHandler;

    protected AbstractController(SessionHandler sessionHandler) {
        this.sessionHandler = sessionHandler;
    }
}
