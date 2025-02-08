package com.example.healthyapp;

public class TestResult {
    private String testName;
    private String result;
    private String date;

    public TestResult(String testName, String result, String date) {
        this.testName = testName;
        this.result = result;
        this.date = date;
    }

    public String getTestName() {
        return testName;
    }

    public String getResult() {
        return result;
    }

    public String getDate() {
        return date;
    }
}
