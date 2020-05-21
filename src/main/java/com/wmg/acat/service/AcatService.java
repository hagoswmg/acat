package com.wmg.acat.service;

import com.wmg.acat.model.TrackModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AcatService {
    List<TrackModel> getAcats(String limit);
}
