package com.geezylucas.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class BatchProcessingApplication implements CommandLineRunner {
    private final JobLauncher jobLauncher;
    private final Job importUserJob;

    public static void main(String[] args) {
        SpringApplication.run(BatchProcessingApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .toJobParameters();

        jobLauncher.run(importUserJob, jobParameters);
    }
}
