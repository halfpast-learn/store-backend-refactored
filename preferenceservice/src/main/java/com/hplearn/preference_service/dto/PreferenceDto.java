package com.hplearn.preference_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreferenceDto {

    private Long preferenceId;
    private String name;
    private List<Long> tags;
}
