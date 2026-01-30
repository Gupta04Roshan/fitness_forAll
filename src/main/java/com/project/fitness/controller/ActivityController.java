package com.project.fitness.controller;

import com.project.fitness.Service.ActivityService;
import com.project.fitness.Dto.ActivityRequest;
import com.project.fitness.Dto.ActivityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/activities")
public class ActivityController{

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request){
        return ResponseEntity.ok(activityService.trackActivity(request));

    }
  @GetMapping
    public ResponseEntity<List<ActivityResponse>> getallActivity(@RequestHeader(value = "X-User-ID") String userId){
        return ResponseEntity.ok(activityService.getallActivity(userId));

    }



}
