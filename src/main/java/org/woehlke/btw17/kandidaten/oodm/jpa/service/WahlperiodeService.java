package org.woehlke.btw17.kandidaten.oodm.jpa.service;

import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.InstitutionArt;
import org.woehlke.btw17.kandidaten.oodm.jpa.model.enums.Mandatsart;

public interface WahlperiodeService  extends Btw17Service<Wahlperiode> {

    Wahlperiode findByBtw17Wahlperiode(Long wahlperiodeId, Wahlkreis wahlkreis, BundeslandEnum bundeslandLandesListe, Mandatsart mandatsArt, InstitutionArt institutionArtLang, String inslang, String fktlang);
}
