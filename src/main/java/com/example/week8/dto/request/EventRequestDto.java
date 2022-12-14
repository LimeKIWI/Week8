package com.example.week8.dto.request;

import com.example.week8.utils.customvalidation.EventPointCheck;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class EventRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String eventDateTime;

    @NotBlank
    private String place;

    @NotBlank
    private String coordinate;

    @NotBlank
    private String content;

    @EventPointCheck
    private int point;

}
