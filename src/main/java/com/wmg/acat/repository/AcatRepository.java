package com.wmg.acat.repository;

import com.wmg.acat.model.AcatModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcatRepository {
    String SELECT_QUERY = "SELECT ac.gpid, ac.artist, ac.title, ac.genre, ac.explicit_rating, ac.type, ac.sub_type, ac.street_date, ac.major_label, ac.marketing_label, ac.presentation_label, 'placeholder for coverart path' as coverart_path, at.track_number, at.track_title, at.isrc, 'placeholder for mp3 file' as audio_file, 'placeholder for mp3 clip' as audio_clip FROM actual_configs ac, actual_tracks at";
    String WHERE_CLAUSE = "WHERE ac.gpid = at.gpid AND ac.media_code = 'EMD' AND ac.street_date > sysdate - 7 AND ac.street_date <= sysdate";
    String ORDER_BY = "ORDER BY ac.street_date, ac.gpid, at.track_number";

    List<AcatModel> findAll(String limit);
}
