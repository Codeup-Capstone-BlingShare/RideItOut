package com.capstone.rideitout.Model;

import jakarta.annotation.Nullable;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Search {
    @Nullable
    private Date startDate;
    @Nullable
    private Date endDate;
    private String searchLocation;

    public Search(String searchLocation) {
        this.searchLocation = searchLocation;
    }
}


