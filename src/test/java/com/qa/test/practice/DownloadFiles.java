package com.qa.test.practice;

import com.microsoft.playwright.Download;
import com.qa.test.base.Base_Opencart;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class DownloadFiles extends Base_Opencart {

    @Test
    public void getDownloadFiles_Status() {
        Download download = page.waitForDownload(() ->{
                page.click("//a[normalize-space()='chromedriver_linux64.zip']");
        });
        System.out.println(download.url());
        System.out.println(download.failure());

        String path = download.path().toString();
        System.out.println(path);

        download.saveAs(Paths.get("Rishabh_chrome.zip"));
        System.out.println(download.suggestedFilename());
    }
}
