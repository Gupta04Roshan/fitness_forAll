package com.project.fitness.Service;

import com.project.fitness.Dto.RecommendationRequest;
import com.project.fitness.Dto.RecommendationResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.Repository.ActivityRepository;
import com.project.fitness.Repository.RecommendationRepository;
import com.project.fitness.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;


    public RecommendationResponse generateRecommendation(@RequestBody RecommendationRequest request) {

        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found:" + request.getUserId()));

        Activity activity = activityRepository.findById(request.getActivityId()).orElseThrow(() -> new RuntimeException("Activity not found:" + request.getActivityId()));

        Recommendation rec = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();

        //return recommendationRepository.save(recommendation);
        return new RecommendationResponse(
                rec.getId(),
                user.getId(),
                activity.getId(),
                rec.getImprovements(),
                rec.getSuggestions(),
                rec.getSafety()
        );


    }
    public List<Recommendation> getUserRecommendation(String userId){
        return recommendationRepository.findByUserId(userId);
    }

    public List<Recommendation> getActivityRecommendation(String activityId) {
        return recommendationRepository.findByActivityId(activityId);
    }
}
