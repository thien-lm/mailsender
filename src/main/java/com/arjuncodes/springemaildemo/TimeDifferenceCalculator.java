package com.arjuncodes.springemaildemo;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

public class TimeDifferenceCalculator {

    public static long calculateTimeDifference(Timestamp createdTime) {
        Instant now = Instant.now(); // Current time in GMT
        Instant createdInstant = createdTime.toInstant(); // Convert Timestamp to Instant
        Duration duration = Duration.between(createdInstant, now); // Calculate the duration between the two instants
        return duration.toSeconds(); // Return the difference in minutes (you can change this to seconds, hours, etc.)
    }
}
