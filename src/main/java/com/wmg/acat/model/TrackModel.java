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
    private List<Track> tracks;
}