package org.woehlke.btw17.kandidaten.oodm.db.service;

import org.woehlke.btw17.kandidaten.oodm.db.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.db.model.Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.InstitutionArt;
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.Mandatsart;

public interface WahlperiodeService  extends Btw17Service<Wahlperiode> {

    Wahlperiode findByBtw17Wahlperiode(Long wahlperiodeId, Wahlkreis wahlkreis, BundeslandEnum bundeslandLandesListe, Mandatsart mandatsArt, InstitutionArt institutionArtLang, String inslang, String fktlang);
}
