package com.tfleet.utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

/**
 * Created by tct4 on 8/12/2016.
 */
public class initExtentReport {
    static ExtentReports extent;
    public static ExtentReports init()
    {
        extent = new ExtentReports("C:\\Users\\tct4\\IdeaProjects\\tfleet-automation-rupali\\Extent-report\\reports.html",false/*, NetworkMode.OFFLINE*/);

   return extent;
    }
}
