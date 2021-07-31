package com.steave.cucumberRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.Runtime;

public class TestRunnerSample{
    public String[] tagsToExecute = {"@SmokeUtilizationData, @SmokeSummaryData, @SmokeCompliance"};
    public String html = "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html";
    public String gluePackage = "mypack.cukes.stepDefinitions";
    public String[] argv = null;

    public void defaultRun() {
        List<String> arguments = new ArrayList<String>();
        arguments.add("src/main/java/mypack/cukes/features");
        String[] tags = tagsToExecute;
        for (String tag : tags) {
            arguments.add("--tags");
            arguments.add(tag);
        }
        arguments.add("--plugin");
        arguments.add(html);
        arguments.add("--glue");
        arguments.add(gluePackage);
        argv = arguments.toArray(new String[arguments.size()]);
        try {
            executeTests(argv);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }


    public byte executeTests(final String[] argv) throws InterruptedException, IOException {
        RuntimeOptions runtimeOptions = new RuntimeOptions(new ArrayList(Arrays.asList(argv)));
        MultiLoader resourceLoader = new MultiLoader(this.getClass().getClassLoader());
        ResourceLoaderClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, this.getClass().getClassLoader());
        Runtime runtime = new Runtime(resourceLoader, classFinder, this.getClass().getClassLoader(), runtimeOptions);
        runtime.run();
        System.out.println(runtime.exitStatus());
        return runtime.exitStatus();
    }

    public static void main(String[] args) {
        System.out.println("Testing MyRunnerTest");
        TestRunnerSample myRun = new TestRunnerSample();
        myRun.defaultRun();
    }
}
