package com.talentstream.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.talentstream.entity.MentorConnect;
import com.talentstream.repository.MentorConnectRepository;

@Service
public class MentorConnectService {

    private final MentorConnectRepository repository;

    public MentorConnectService(MentorConnectRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> getAllMeetings() {
        try {
            List<MentorConnect> meetings = repository.findAllMeetingsOrdered();
            if (meetings.isEmpty()) {
                return ResponseEntity.status(404).body("No meetings found");
            }
            return ResponseEntity.ok(meetings);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .body("Error fetching meetings: " + e.getMessage());
        }
    }

    public ResponseEntity<?> getMeetingById(UUID meetingId) {
        try {
            MentorConnect meeting = repository.findById(meetingId).orElse(null);
            if (meeting == null) {
                return ResponseEntity.status(404)
                                     .body("Meeting not found with ID: " + meetingId);
            }
            return ResponseEntity.ok(meeting);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                                 .body("Error fetching meeting: " + e.getMessage());
        }
    }
}
