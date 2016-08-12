package com.tfleet.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tct4 on 8/12/2016.
 */
public class TakeScreenshot {

        public static String takeScreenshot(WebDriver driver) throws IOException {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            SimpleDateFormat sd = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            String DateStr = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
            String imageName = "screenshot"+DateStr+".png";
            String imagePath="Extent-report/screenshots/"+imageName;
            FileUtils.copyFile(scrFile, new File(imagePath));

            return imageName;

        }
}
