package org.woehlke.btw17.kandidaten.frontend.content;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface SessionHandler {
    FreitextSucheFormular setSession(HttpSession session, Model model);
}
