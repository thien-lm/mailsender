package com.arjuncodes.springemaildemo;

import com.arjuncodes.springemaildemo.CVApplication;
import com.arjuncodes.springemaildemo.JobPost;
import com.arjuncodes.springemaildemo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CVApplicationRepo extends JpaRepository<CVApplication, Integer> {
    public List<CVApplication> findByJobId(JobPost jobPost);
    public List<CVApplication> findByUserId(String user);
}
