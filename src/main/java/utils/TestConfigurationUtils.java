package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestConfigurationUtils {
    private static Properties config;

    public static ChromeOptions getChromeOptions() {
        try {
            config = new Properties();
            FileInputStream configFile = new FileInputStream("src/test/java/testConfiguration/TestConfig.properties");
            config.load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String maximizeWindow = config.getProperty("maximizeWindow");
        String headlessMode = config.getProperty("headlessMode");
        String incognitoMode = config.getProperty("incognitoMode");
        ChromeOptions options = new ChromeOptions();
        if (incognitoMode.equalsIgnoreCase("true")) {
            options.addArguments("--incognito");
        }
        if (headlessMode.equalsIgnoreCase("true")) {
            options.addArguments("--headless");
        }
        if (maximizeWindow.equalsIgnoreCase("true")) {
            options.addArguments("start-maximized");
        }
        return options;
    }
}
