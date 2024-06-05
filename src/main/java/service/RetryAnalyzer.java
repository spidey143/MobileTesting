package service;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int retryCounter = 0;
    int retryLimit = 1;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCounter < retryLimit){
            retryCounter++;
            return true;
        }
        return false;
    }
}
