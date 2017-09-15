package org.woehlke.btw17.kandidaten.frontend.content;


import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Component
public class SessionHandlerImpl implements SessionHandler {

    @Override
    public FreitextSucheFormular fetchOrCreateFreitextSucheFormular(
                            HttpSession session,
                            Model model){
        FreitextSucheFormular suchformularFreitext = (FreitextSucheFormular) session.getAttribute("suchformularFreitext");
        if (suchformularFreitext == null) {
            suchformularFreitext = new FreitextSucheFormular();
            session.setAttribute("suchformularFreitext", suchformularFreitext);
        }
        model.addAttribute("suchformularFreitext", suchformularFreitext);
        return suchformularFreitext;
    }

    @Override
    public SearchForKandidat fetchOrCreateSucheFormular(HttpSession session, Model model) {
        SearchForKandidat suchformular = (SearchForKandidat) session.getAttribute("suchformular");
        if (suchformular == null) {
            suchformular = new SearchForKandidat();
            session.setAttribute("suchformular", suchformular);
        }
        model.addAttribute("suchformular", suchformular);
        return suchformular;
    }
}
