package com.example.demo

import org.jobrunr.jobs.lambdas.JobLambda
import org.jobrunr.scheduling.JobScheduler
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class JobRunrTest(
    private val jobScheduler: JobScheduler
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        logger.info("Start schedule job")
        jobScheduler.schedule(Instant.now().plusSeconds(10), PrintHelloJob())
        logger.info("Finish schedule job")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java.declaringClass)
    }
}

class PrintHelloJob : JobLambda {
    override fun run() {
        logger.info("hello")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java.simpleName)
    }
}
