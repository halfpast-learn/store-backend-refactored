package com.hplearn.tagservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {

    private Long id;
    private String name;
    private List<Long> itemIds;
}
