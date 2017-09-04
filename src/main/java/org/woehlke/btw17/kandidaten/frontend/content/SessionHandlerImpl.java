package org.woehlke.btw17.kandidaten.frontend.content;


import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Component
public class SessionHandlerImpl implements SessionHandler {

    public FreitextSucheFormular setSession(
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
}
