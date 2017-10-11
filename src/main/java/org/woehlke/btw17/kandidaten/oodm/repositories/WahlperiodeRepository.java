package org.woehlke.btw17.kandidaten.oodm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.woehlke.btw17.kandidaten.oodm.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.model.Wahlperiode;
import org.woehlke.btw17.kandidaten.oodm.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.model.enums.InstitutionArt;
import org.woehlke.btw17.kandidaten.oodm.model.enums.Mandatsart;

import java.util.List;

@Repository
public interface WahlperiodeRepository extends JpaRepository<Wahlperiode,Long> {

    @Query(name = "Wahlperiode.getAllIds")
    List<Long> getAllIds();

    @Query(name = "Wahlperiode.getMaxId")
    Long getMaxId();

    @Query(name = "Wahlperiode.findByBtw17Wahlperiode")
    Wahlperiode findByBtw17Wahlperiode(
            @Param("wahlperiode") Long wahlperiodeId,
            @Param("wahlkreis") Wahlkreis wahlkreis,
            @Param("bundeslandLandesListe") BundeslandEnum bundeslandLandesListe,
            @Param("mandatsArt") Mandatsart mandatsArt,
            @Param("institutionArtLang") InstitutionArt institutionArtLang,
            @Param("institutionLang") String inslang,
            @Param("funktionLang") String fktlang
    );

}
