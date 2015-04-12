package ch.racic.sammelsurium.selenium.htmlunit.screenshot;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by rac on 11.04.15.
 */
public class RenderHtmlUnitDriver extends HtmlUnitDriver implements TakesScreenshot {

    private static final String HTML2CANVAS_JS_SOURCE = "js/html2canvas.js";
    private static final String HTML2CANVAS_CALL = "; var webDriverCallback = arguments[arguments.length -1]; html2canvas(document.body).then(function(canvas) { var img = canvas.toDataUrl('image/png').replace('data:image/png;base64,', ''); webDriverCallback(img); });";

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
        String js = "";
        try {
            js += IOUtils.toString(getClass().getClassLoader().getResourceAsStream(HTML2CANVAS_JS_SOURCE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        js += HTML2CANVAS_CALL;
        manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
        String ret = (String) executeAsyncScript(js);
        System.out.println(ret);
        return null;
    }
}
