package com.wmg.acat.service;

import com.wmg.acat.model.AcatModel;
import com.wmg.acat.repository.AcatRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcatServiceImpl implements AcatService {

    private final AcatRepository acatRepository;

    public AcatServiceImpl(AcatRepository acatRepository) {
        this.acatRepository = acatRepository;
    }

    @Override
    public List<AcatModel> getAcats(String limit) {
        return acatRepository.findAll(limit);
    }
}
