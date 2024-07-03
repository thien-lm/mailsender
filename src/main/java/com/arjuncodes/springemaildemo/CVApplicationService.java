package com.arjuncodes.springemaildemo;

import com.arjuncodes.springemaildemo.CVApplication;
import com.arjuncodes.springemaildemo.JobPost;
import com.arjuncodes.springemaildemo.User;

import java.util.List;

public interface CVApplicationService {
    List<CVApplication> getAll();
    List<CVApplication> getAllByJobId(JobPost jobPost);
    List<CVApplication> getAllByUserId(String userId);
    CVApplication save(CVApplication cvApplication);
    void DeleteById(Integer id);
}
