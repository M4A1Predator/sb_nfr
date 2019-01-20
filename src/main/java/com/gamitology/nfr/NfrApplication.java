package com.gamitology.nfr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class NfrApplication implements ApplicationRunner {

	private static final Logger logger = LogManager.getLogger(NfrApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NfrApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
//		logger.debug("Debugging log");
//		logger.info("Info log");
//		logger.warn("Hey, This is a warning!");
//		logger.error("Oops! We have an Error. OK");
//		logger.fatal("Damn! Fatal error. Please fix me.");

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String dateIso = sdf.format(date);
		logger.info("App Started at : " + dateIso);
	}
}

