package common.files;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.IEXPLORE;
import static org.openqa.selenium.remote.BrowserType.SAFARI;

import java.awt.Toolkit;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class WebDriverFactory implements Serializable {

    /**
     * Generated serial version Id.
     */
    private static final long serialVersionUID = 8337223059281231033L;

    /**
     * Logger instance for doing logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverFactory.class);

    /**
     * Constant to indicate time out for page load by web driver.
     */
    public static final int TIME_OUT_IN_SECONDS = 30;

    /**
     * Singleton instance of Selenium Web Driver.
     */
    private static WebDriver webDriver;

    /**
     * Utility class should not have default or public constructor.
     */
    private WebDriverFactory() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to create web driver based on the browser name passed.
     *
     * @return <code>org.openqa.selenium.WebDriver</code>.
     */
    public synchronized static WebDriver getWebDriverInstance() {

        if (webDriver == null) {
            try {
                webDriver = createBrowserSpecificDriver();
            } catch (final UnreachableBrowserException e) {
                webDriver = createBrowserSpecificDriver();
            } catch (final WebDriverException e) {
                webDriver = createBrowserSpecificDriver();
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
        }

        return webDriver;
    }

    /**
     * Method to get the web driver instance based on the asked browser.
     *
     * @return <code>org.openqa.selenium.WebDriver</code>.
     */
    private static WebDriver createBrowserSpecificDriver() {

        final String browserName = System.getProperty("browser", CHROME);

        WebDriver driver;
        switch (browserName) {
            case CHROME:
                driver = createChromeDriver();
                break;
            case IEXPLORE:
                driver = createInternetExplorerDriver();
                break;
            case SAFARI:
                driver = createSafariDriver();
                break;
            case FIREFOX:
            default:
                driver = createFireFoxDriver();
                break;
        }

        addCommonDriverSettings(driver);

        return driver;
    }

    /**
     * Method to create instance of Chrome web driver.
     *
     * @return <code>org.openqa.selenium.chrome.ChromeDriver</code>.
     */
    private synchronized static WebDriver createChromeDriver() {

        // For chrome we have to specify the path for external chrome driver.
        switch (Platform.getCurrent()) {
            case WINDOWS:
            case VISTA:
            case XP:
            case WIN8:
            case WIN8_1:
                System.setProperty("webdriver.chrome.driver", "target/drivers/chromedriver.exe");
                break;
            case LINUX:
                System.setProperty("webdriver.chrome.driver", "target/drivers/chromedriver-linux-64bit");
                break;
            case MAC:
                System.setProperty("webdriver.chrome.driver", "target/drivers/chromedriver-mac-64bit");
                break;
            default:
                break;
        }

        return new ChromeDriver();
    }

    /**
     * Method to create instance of Internet Explorer web driver.
     *
     * @return <code>org.openqa.selenium.ie.InternetExplorerDriver</code>.
     */
    private synchronized static WebDriver createInternetExplorerDriver() {

        // For IE we have to specify the path for external IE driver.
        switch (System.getProperty("sun.arch.data.model")) {
            case "64":
                System.setProperty("webdriver.ie.driver", "target/drivers/internetexplorerdriver-windows-64bit.exe");
                break;
            case "32":
            default:
                System.setProperty("webdriver.ie.driver", "target/drivers/internetexplorerdriver-windows-32bit.exe");
                break;
        }

        return new InternetExplorerDriver();
    }

    /**
     * Method to create instance of Safari web driver.
     *
     * @return <code>org.openqa.selenium.safari.SafariDriver</code>.
     */
    private synchronized static WebDriver createSafariDriver() {

        return new SafariDriver();
    }

    /**
     * Method to create FireFoxDriver instance by setting FirefoxProfile and
     * DesiredCapabilities.
     *
     * @return <code>org.openqa.selenium.firefox.FirefoxDriver</code>.
     */
    private synchronized static WebDriver createFireFoxDriver() {

        final DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
        desiredCapabilities.setCapability(FirefoxDriver.PROFILE, getFirefoxProfile());

        return new FirefoxDriver(desiredCapabilities);
    }

    /**
     * Method to return profile for FireFox.
     *
     * @return <code>org.openqa.selenium.firefox.FirefoxProfile</code>.
     */
    private static FirefoxProfile getFirefoxProfile() {

        final FirefoxProfile firefoxProfile = new FirefoxProfile();

        // Native events may cause tests which open many windows in parallel to
        // be unreliable especially on windows. However, native events work
        // quite well otherwise and are essential for some of the new actions of
        // the Advanced User
        // Interaction. We need native events to be enable especially for
        // testing the WYSIWYG editor.
        //firefoxProfile.setEnableNativeEvents(false);

        // Sets whether FireFox should accept SSL certificates which have
        // expired, signed by an unknown authority or are generally untrusted.
        firefoxProfile.setAcceptUntrustedCertificates(true);

        // Disable hardware acceleration in FireFox.
        firefoxProfile.setPreference("layers.acceleration.disabled", true);

        // Make sure FireFox doesn't upgrade automatically on CI agents.
        firefoxProfile.setPreference("app.update.auto", false);

        // Start page configuration to speed up FireFox
        firefoxProfile.setPreference("browser.startup.homepage", "about:blank");
        firefoxProfile.setPreference("pref.browser.homepage.disable_button.bookmark_page", false);
        firefoxProfile.setPreference("pref.browser.homepage.disable_button.restore_default", false);

        return firefoxProfile;
    }

    /**
     * Method to do add all common settings applicable for browser drivers.
     * 
     * @param driver
     *            <code>org.openqa.selenium.WebDriver</code>.
     */
    private static void addCommonDriverSettings(final WebDriver driver) {

        // Set the timeout for the pages.
        driver.manage().timeouts().implicitlyWait(TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);

        // Start position of the browser. 0, 0 will open the browser from top
        // left corner.
        driver.manage().window().setPosition(new Point(0, 0));

        // Browser window will be adjusted based on the current monitor
        // resolution.
        final java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        driver.manage().window().setSize(dim);
    }

    /**
     * Browser clean-up thread class to perform browser closing action.
     *
     * @author a120065
     */
    private static class BrowserCleanup implements Runnable {
        public void run() {
            close();
        }
    }

    /**
     * Method to close the browser.
     */
    public static void close() {
        try {
            if (webDriver != null) {
                LOGGER.info("Closing the browser...");

                webDriver.quit();
                webDriver = null;
            }
        } catch (final UnreachableBrowserException e) {
            LOGGER.error("Cannot close browser: unreachable browser", e);
        }
    }
}

