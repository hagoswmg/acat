package com.wmg.acat.service;

import com.wmg.acat.model.ReportModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AcatService {
    List<ReportModel> getAcats(String limit);
}
