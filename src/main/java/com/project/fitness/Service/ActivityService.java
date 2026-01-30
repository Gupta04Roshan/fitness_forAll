package com.project.fitness.Service;

import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.Repository.ActivityRepository;
import com.project.fitness.Repository.UserRepository;
import com.project.fitness.Dto.ActivityRequest;
import com.project.fitness.Dto.ActivityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;

    public ActivityResponse trackActivity(ActivityRequest request) {
        User user =userRepository.findById(request.getUserId()).orElseThrow(()-> new RuntimeException("invalid user :"+request.getUserId()));
        Activity activity = Activity.builder()
                .user(user)
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrices())
                .build();
         Activity savedActivity = activityRepository.save(activity);
         return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUser().getId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setStartTime(activity.getStartTime());
        response.setAdditionalMetrices(activity.getAdditionalMetrics());
        return response;
    }

    public List<ActivityResponse> getallActivity(String userId) {
        List<Activity> activityList = activityRepository.findByUserId(userId);
        return activityList.stream()
                // .map(this::mapToResponse())
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }




}
