package com.wmg.acat.controller;

import com.wmg.acat.service.AcatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin(maxAge = 3600)
public class AcatController {

    private AcatService acatService;

    public AcatController(AcatService acatService) {
        this.acatService = acatService;
    }

    @GetMapping("/acat")
    public ResponseEntity<?> getAcat(@RequestParam(defaultValue = "true") String limit) {

        return ResponseEntity.ok(acatService.getAcats(limit));
    }
}
