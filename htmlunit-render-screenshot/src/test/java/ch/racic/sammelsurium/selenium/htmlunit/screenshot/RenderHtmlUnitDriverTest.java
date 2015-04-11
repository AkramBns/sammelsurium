package ch.racic.sammelsurium.selenium.htmlunit.screenshot;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;

import static org.junit.Assert.*;

public class RenderHtmlUnitDriverTest {

    @Test
    public void takeRenderedScreenshot() {
        RenderHtmlUnitDriver d = new RenderHtmlUnitDriver(true);
        d.navigate().to("http://www.gdgzh.ch");
        File rendered = d.getScreenshotAs(OutputType.FILE);

    }

}