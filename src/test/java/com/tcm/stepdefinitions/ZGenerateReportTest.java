package com.tcm.stepdefinitions;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.ReportBuilder;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.exception.VelocityException;
import org.junit.Test;

public class ZGenerateReportTest {
	
	@Test
	public  void generateReports() {
		File reportOutputDirectory = new File("target");
		List<String> list = new ArrayList<String>();
		list.add("./target/cucumber.json");
		//list.add("cucumber-report2.json");

		String pluginUrlPath = "";
		String buildNumber = "1";
		String buildProject = "cucumber-jvm";
		boolean skippedFails = true;
		boolean pendingFails = true;
		boolean undefinedFails = true;
		boolean missingFails = true;
		boolean flashCharts = true;
		boolean runWithJenkins = false;
		boolean artifactsEnabled = false;
		String artifactConfig = "";
		boolean highCharts = false;
		boolean parallelTesting = false;

		ReportBuilder reportBuilder = null;
		try {
			reportBuilder = new ReportBuilder(list, reportOutputDirectory,
					pluginUrlPath, buildNumber, buildProject, skippedFails,
					pendingFails, undefinedFails, missingFails, flashCharts,
					runWithJenkins, artifactsEnabled, artifactConfig,
					highCharts, parallelTesting);
			reportBuilder.setReportDirectory(new File("target\\ExecutionReports"));
			

		} catch (VelocityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block4
			e.printStackTrace();
		}
		try {
			reportBuilder.generateReports();
			//FileUtils.copyFile(new File("./src/main/resources/logo.png"), new File("./target/ExecutionReports/blue/images/logo.png"),true);
		} catch (VelocityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
