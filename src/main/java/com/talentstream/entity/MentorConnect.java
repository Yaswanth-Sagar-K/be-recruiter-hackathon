package com.talentstream.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mentor_connect", schema = "public")
public class MentorConnect {

	@Id
	@Column(name = "meeting_id", nullable = false)
	private UUID meetingId;

	@Column(name = "mentor_name", nullable = false)
	private String mentorName;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "date", nullable = false)
	private LocalDate date;

	@Column(name = "start_time", nullable = false)
	private LocalTime startTime;

	@Column(name = "duration", nullable = false)
	private Long durationMinutes;
	
	@Column(name = "meet_link")
	private String meetLink;

	@Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private LocalDateTime createdAt;

	// Constructors
	public MentorConnect() {
	}

	public UUID getMeetingId() {
		return meetingId;
	}


	public void setMeetingId(UUID meetingId) {
		this.meetingId = meetingId;
	}


	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public Long getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(Long durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public String getMeetLink() {
		return meetLink;
	}

	public void setMeetLink(String meetLink) {
		this.meetLink = meetLink;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
