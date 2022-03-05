package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // WEB-ELEMENTS ====================================================================================================

    @FindBy(xpath = "//h1[text() = 'Все необходимые инструменты для разработчиков и команд']")
    public WebElement pageTitle;

    @FindBy(xpath = "//h3[contains(@class, 'product-card__title')]/../following-sibling::p/a")
    public List<WebElement> mainBlockLinks;


    // SCENARIOS =======================================================================================================

    public HomePage checkPageTitle() {
        Assert.assertEquals(pageTitle.getText(), "Все необходимые инструменты для разработчиков и команд");
        return this;
    }


    public HomePage checkMainBlockLinksCount() {
        Assert.assertEquals(mainBlockLinks.size(), 4);
        return this;
    }
}
