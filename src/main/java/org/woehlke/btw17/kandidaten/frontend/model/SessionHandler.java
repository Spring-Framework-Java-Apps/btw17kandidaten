package org.woehlke.btw17.kandidaten.frontend.model;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface SessionHandler {

    FreitextSucheFormular fetchOrCreateFreitextSucheFormular(HttpSession session, Model model);

    SearchForKandidat fetchOrCreateSucheFormular(HttpSession session, Model model);
}
