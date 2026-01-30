package com.project.fitness.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecommendationResponse {
    private String id;
    private String userId;
    private String activityId;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;

}
