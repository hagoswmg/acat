package com.wmg.acat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.SqlResultSetMapping;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@SqlResultSetMapping(name = "AcatModel", classes = @ConstructorResult(targetClass = AcatModel.class,
        columns = {
                @ColumnResult(name = "gpid", type = String.class),
                @ColumnResult(name = "artist", type = String.class),
                @ColumnResult(name = "title", type = String.class),
                @ColumnResult(name = "genre", type = String.class),
                @ColumnResult(name = "explicit_rating", type = String.class),
                @ColumnResult(name = "type", type = String.class),
                @ColumnResult(name = "sub_type", type = String.class),
                @ColumnResult(name = "street_date", type = Date.class),
                @ColumnResult(name = "track_number", type = Long.class),
                @ColumnResult(name = "track_title", type = String.class),
                @ColumnResult(name = "isrc", type = String.class)}))
public class AcatModel {
    private String gpid;
    private String artist;
    private String title;
    private String genre;
    private String explicit_rating;
    private String type;
    private String sub_type;
    private Date street_date;
    private long track_number;
    private String track_title;
    private String isrc;
}
