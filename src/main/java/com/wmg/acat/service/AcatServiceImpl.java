package com.wmg.acat.service;

import com.wmg.acat.model.AcatModel;
import com.wmg.acat.model.Track;
import com.wmg.acat.model.TrackModel;
import com.wmg.acat.repository.AcatRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AcatServiceImpl implements AcatService {

    private final AcatRepository acatRepository;

    public AcatServiceImpl(AcatRepository acatRepository) {
        this.acatRepository = acatRepository;
    }

    @Override
    public List<TrackModel> getAcats(String limit) {
        return process(acatRepository.findAll(limit));
    }

    private List<TrackModel> process(List<AcatModel> all) {

        Map<String, List<TrackModel>> map = new HashMap<>();

        for (AcatModel am : all) {
            final List<TrackModel> found = map.get(am.getGpid());
            TrackModel trackModel = new TrackModel();
            List<Track> tracks = new ArrayList<>();
            List<TrackModel> models = new ArrayList<>();
            if (found == null || found.isEmpty()) {
                trackModel.setGpid(am.getGpid());
                trackModel.setArtist(am.getArtist());
                trackModel.setTitle(am.getTitle());
                trackModel.setGenre(am.getGenre());
                trackModel.setExplicit_rating(am.getExplicit_rating());
                trackModel.setType(am.getType());
                trackModel.setSub_type(am.getSub_type());
                trackModel.setStreet_date(am.getStreet_date());
                trackModel.setMajor_label(am.getMajor_label);
                trackModel.setMarketing_label(am.getMarketing_label);
                trackModel.setPresentation_label(am.getPresentation_label);
                trackModel.setCoverart_path(am.getCoverart_path);

                final Track track = new Track(am.getTrack_number(), am.getTrack_title(), am.getIsrc(), am.getAudio_file, am.getAudio_clip);
                tracks.add(track);
                trackModel.setTracks(tracks);

                models.add(trackModel);

                map.put(am.getGpid(), models);
            } else {
                final Track track = new Track(am.getTrack_number(), am.getTrack_title(), am.getIsrc(), am.getAudio_file, am.getAudio_clip);
                final TrackModel foundTrackModel = found.get(0);
                foundTrackModel.getTracks().add(track);
            }
        }

        final Collection<List<TrackModel>> list = map.values();

        return map.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
