package com.arjuncodes.springemaildemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import jakarta.mail.MessagingException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringEmailDemoApplication {
	@Autowired
	private CVApplicationService cvApplicationService;
	@Autowired
	private JobPostService jobPostService;
	@Autowired
	private EmailSenderService senderService;
	public static void main(String[] args) {
		SpringApplication.run(SpringEmailDemoApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws InterruptedException {
		ArrayList<Integer>  processedId = new ArrayList<Integer>();
		while(true) {

				List<CVApplication> cvApplicationList = cvApplicationService.getAll();
				for (int i = 0; i < cvApplicationList.size(); i++) {
					try {
					CVApplication currentCVApplication = cvApplicationList.get(i);
					if ((TimeDifferenceCalculator.calculateTimeDifference(currentCVApplication.getCreatedTime())) > 20 && currentCVApplication.getStatus().equals("accept") && !processedId.contains(currentCVApplication.getId())) {
						String toEmail = currentCVApplication.getUser().getEmail();
						String name = currentCVApplication.getUser().getFirstName() + currentCVApplication.getUser().getLastName();
						String jobName = jobPostService.getById(currentCVApplication.getJobId().getId()).getTitle();
						String jobDescription = jobPostService.getById(currentCVApplication.getJobId().getId()).getDescription();
						String requirements = jobPostService.getById(currentCVApplication.getJobId().getId()).getRequirements();
						String location = jobPostService.getById(currentCVApplication.getJobId().getId()).getLocations();
						String jobSummary = "Title: " + jobName + "\n" + "Job Description: "+ jobDescription + "\nJob requirements: " + requirements + "\nlocation: " + location;
						senderService.sendSimpleEmail(toEmail,
								"Notification about your submited Job",
								 " Hello " + name + " you've accepted to this job: " + jobName + " \n" + "Please be notice that recruitment department  of that company will contact you soon \n"  + "This is the job summary: \n " + jobSummary + "\nGood luck to you !");
						processedId.add(currentCVApplication.getId());
					}
					Thread.sleep(5000);
				}
					catch (Exception e) {
						System.out.println(e);
					}
			}
			Thread.sleep(20000);
		}


	}
}
