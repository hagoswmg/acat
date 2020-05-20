package com.wmg.acat.service;

import com.wmg.acat.model.AcatModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AcatService {
    List<AcatModel> getAcats(String limit);
}
