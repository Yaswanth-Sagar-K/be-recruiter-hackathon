package com.talentstream.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.talentstream.entity.MentorConnect;

@Repository
public interface MentorConnectRepository extends JpaRepository<MentorConnect, UUID> {
    
	@Query("SELECT m FROM MentorConnect m ORDER BY m.createdAt DESC")
	List<MentorConnect> findAllMeetingsOrdered();
}
 