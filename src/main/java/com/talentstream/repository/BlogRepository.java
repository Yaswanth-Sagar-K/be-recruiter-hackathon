package com.talentstream.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.talentstream.entity.Blog;


public interface BlogRepository extends JpaRepository<Blog, UUID> {

    @Query("SELECT b FROM Blog b WHERE b.isActive = true ORDER BY b.createdAt DESC")
    List<Blog> findActiveBlogsOrdered();

    @Query("SELECT b FROM Blog b WHERE b.isActive = false ORDER BY b.createdAt DESC")
    List<Blog> findInactiveBlogsOrdered();

    @Query("SELECT b FROM Blog b ORDER BY b.createdAt DESC")
    List<Blog> findAllBlogsOrdered();

    Optional<Blog> findByUrlOrTitle(String url, String title);
}
