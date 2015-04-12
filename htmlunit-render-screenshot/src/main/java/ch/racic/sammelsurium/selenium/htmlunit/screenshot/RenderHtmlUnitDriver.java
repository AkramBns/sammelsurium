package ch.racic.sammelsurium.selenium.htmlunit.screenshot;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by rac on 11.04.15.
 */
public class RenderHtmlUnitDriver extends HtmlUnitDriver implements TakesScreenshot {

    public RenderHtmlUnitDriver(BrowserVersion version) {
        super(version);
    }

    public RenderHtmlUnitDriver() {
    }

    public RenderHtmlUnitDriver(boolean enableJavascript) {
        super(enableJavascript);
    }

    public RenderHtmlUnitDriver(Capabilities capabilities) {
        super(capabilities);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        // inject html2canvas and retrieve screenshot data

        return null;
    }
}
