package com.project.fitness.controller;

import com.project.fitness.model.Recommendation;
import com.project.fitness.Service.RecommendationService;
import com.project.fitness.Dto.RecommendationRequest;
import com.project.fitness.Dto.RecommendationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Recommendation")
@RequiredArgsConstructor
public class RecommendationController {
    private final RecommendationService recommendationService;

//    @PostMapping("/generate")
//    public ResponseEntity<Recommendation> generateRecommendation(@RequestBody RecommendationRequest request){
//        Recommendation recommendation= recommendationService.generateRecommendation(request);
//        return ResponseEntity.ok(recommendation);
//    }
//

    @PostMapping("/generate")
    public ResponseEntity<RecommendationResponse>generateRecommendation(@RequestBody RecommendationRequest request){
        RecommendationResponse rec= recommendationService.generateRecommendation(request);

        return ResponseEntity.ok(
                recommendationService.generateRecommendation(request)
        );



    }
//

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> generateRecommendation(@PathVariable String userId){
        List<Recommendation> recommendationList= recommendationService.getUserRecommendation(userId);
        return ResponseEntity.ok(recommendationList);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> generateActivityRecommendation(@PathVariable String activityId){
        List<Recommendation> recommendationList= recommendationService.getActivityRecommendation(activityId);
        return ResponseEntity.ok(recommendationList);
    }





}

