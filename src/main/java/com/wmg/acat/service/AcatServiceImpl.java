package com.wmg.acat.service;

import com.wmg.acat.model.AcatModel;
import com.wmg.acat.model.ReportModel;
import com.wmg.acat.model.Track;
import com.wmg.acat.repository.AcatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AcatServiceImpl implements AcatService {

    private final AcatRepository acatRepository;

    public AcatServiceImpl(AcatRepository acatRepository) {
        this.acatRepository = acatRepository;
    }

    @Override
    public List<ReportModel> getAcats(String limit) {
        return process(acatRepository.findAll(limit));
    }

    /**
     * Processes query result (a list) to customer presentable format
     * @param queryResultList - result set from database query
     * @return - a list of report items
     */
    private List<ReportModel> process(List<AcatModel> queryResultList) {

        // map with key=GPID, and value is report entry for the given GPID
        Map<String, List<ReportModel>> map = new HashMap<>();

        for (AcatModel am : queryResultList) {
            final Track track = new Track(am.getTrack_number(), am.getTrack_title(), am.getIsrc(), am.getAudio_file(), am.getAudio_clip());

            ReportModel reportModel = new ReportModel();
            List<Track> tracks = new ArrayList<>();
            List<ReportModel> models = new ArrayList<>();

            // A GPID may have multiple tracks. So if GPID is in the collection, update only the tracks.
            final List<ReportModel> found = map.get(am.getGpid());
            if (found == null || found.isEmpty()) {
                reportModel.setGpid(am.getGpid());
                reportModel.setArtist(am.getArtist());
                reportModel.setTitle(am.getTitle());
                reportModel.setGenre(am.getGenre());
                reportModel.setExplicit_rating(am.getExplicit_rating());
                reportModel.setType(am.getType());
                reportModel.setSub_type(am.getSub_type());
                reportModel.setStreet_date(am.getStreet_date());
                reportModel.setMajor_label(am.getMajor_label());
                reportModel.setMarketing_label(am.getMarketing_label());
                reportModel.setPresentation_label(am.getPresentation_label());
                reportModel.setCoverart_path(am.getCoverart_path());

                tracks.add(track);
                reportModel.setTracks(tracks);

                models.add(reportModel);

                map.put(am.getGpid(), models);
            } else {
                final ReportModel foundReportModel = found.get(0);
                foundReportModel.getTracks().add(track);
            }
        }

        return map.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
