package com.arjuncodes.springemaildemo;


import com.arjuncodes.springemaildemo.JobPost;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface JobPostRepo  extends JpaRepository<JobPost, Integer> {
    public List<JobPost> findByUserId(String UserId);
}
