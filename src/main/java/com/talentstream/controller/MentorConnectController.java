package com.talentstream.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.talentstream.service.MentorConnectService;

@RestController
@RequestMapping("/api/mentor-connect")
public class MentorConnectController {

    private final MentorConnectService service;

    public MentorConnectController(MentorConnectService service) {
        this.service = service;
    }

    @GetMapping("/getAllMeetings")
    public ResponseEntity<?> getAllMeetings() {
        return service.getAllMeetings();
    }

    @GetMapping("/getMeetingById/{id}")
    public ResponseEntity<?> getMeetingById(@PathVariable UUID id) {
        return service.getMeetingById(id);
    }
}
