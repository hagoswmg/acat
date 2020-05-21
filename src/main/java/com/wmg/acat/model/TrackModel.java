package com.wmg.acat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackModel {
    private String gpid;
    private String artist;
    private String title;
    private String genre;
    private String explicit_rating;
    private String type;
    private String sub_type;
    private Date street_date;
    private String major_label;
    private String marketing_label;
    private String presentation_label;
    private String coverart_path;
    private List<Track> tracks;
}