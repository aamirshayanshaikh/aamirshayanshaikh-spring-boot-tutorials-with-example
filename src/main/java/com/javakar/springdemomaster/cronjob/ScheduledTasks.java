package com.javakar.springdemomaster.cronjob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;


@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    /*
     * Execute the annotated method with a fixed period in milliseconds between
     * invocations return the period in milliseconds
     */
   @Scheduled(fixedRate = 2000)
    public void scheduleTaskWithFixedRate() {
        logger.info("scheduleTaskWithFixedRate :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
    }


    /*
     * Execute the annotated method with a fixed period in milliseconds between the
     * end of the last invocation and the start of the next. return the delay in milliseconds
     */
     @Scheduled(fixedDelay = 2000)
    public void scheduleTaskWithFixedDelay() {
        logger.info("scheduleTaskWithFixedDelay :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            logger.error("Ran into an error {}", ex);
            throw new IllegalStateException(ex);
        }
    }

    /*
	 * Number of milliseconds to delay before the first execution
    */
    @Scheduled(fixedRate = 2000, initialDelay = 5000)
    public void scheduleTaskWithInitialDelay() {
        logger.info("FscheduleTaskWithInitialDelay :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }

    @Scheduled(cron = "0 * * * * ?")
    public void scheduleTaskWithCronExpression() {
        logger.info("scheduleTaskWithCronExpression :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }

}