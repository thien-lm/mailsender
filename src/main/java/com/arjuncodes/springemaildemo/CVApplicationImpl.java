package com.arjuncodes.springemaildemo;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import com.arjuncodes.springemaildemo.CVApplication;
import com.arjuncodes.springemaildemo.JobPost;
import com.arjuncodes.springemaildemo.User;
import com.arjuncodes.springemaildemo.CVApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j2
@AllArgsConstructor(onConstructor_ = @Autowired)
@Service
public class CVApplicationImpl implements CVApplicationService {
    CVApplicationRepo cvApplicationRepo;
    @Override
    public List<CVApplication> getAll() {
        return cvApplicationRepo.findAll();
    }

    @Override
    public List<CVApplication> getAllByJobId(JobPost jobPost) {
        return cvApplicationRepo.findByJobId(jobPost);
    }

    @Override
    public List<CVApplication> getAllByUserId(String userId) {
        return cvApplicationRepo.findByUserId(userId);
    }

    @Override
    public CVApplication save(CVApplication cvApplication) {
        return cvApplicationRepo.save(cvApplication);
    }

    @Override
    public void DeleteById(Integer id) {
        cvApplicationRepo.deleteById(id);
    }
}