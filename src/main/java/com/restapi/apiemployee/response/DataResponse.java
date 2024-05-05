package com.restapi.apiemployee.response;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DataResponse {
    @JsonProperty
    private String message;
    @JsonProperty
    private Boolean status;
    @SuppressWarnings("rawtypes")
    @JsonProperty
    private List data;
}
