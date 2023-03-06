package pages.magento;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StorePage extends BasePage {

 private String level1MenuDropdown = "//span[text()='%s']//ancestor::a";

 private String level2MenuDropdown = "//li[contains(@class,'nav-2')]//span[text()='%s']//ancestor::a";

 private String level3MenuDropdown = "//li[contains(@class,'nav-2')]//span[text()='%s']//ancestor::a";


 @FindBy(xpath = "//div[@class='filter-options-title' and text()='Color']/..")
 private WebElementFacade colorFilterButton;

 @FindBy(xpath = "//div[@class='filter-options-title' and text()='Price']/..")
 private WebElementFacade priceFilterButton;


 private String colorChoiceButton = "//div[@class='filter-options-title' and text()='Color']/following-sibling::div//div[@option-label='%s']";

 private String selectedColor = "//div[contains(@class,'product details')]//div[@aria-label='%s']";

 @FindBy(xpath = "(//div[@class='filter-options-title' and text()='Price']//following-sibling::div//a)[1]")
 private WebElementFacade firstPriceRange;

 @FindBy(xpath = "//ol[@class='products list items product-items']")
 private List<WebElementFacade> itemsList;

 private String fixedPriceRange = "//div[@class='filter-options-title' and text()='Price']//following-sibling::div//a[contains(@href,'%s')]";

 @FindBy(xpath = "//div[@data-role='priceBox']//span[contains(@id,'product-price')]")
 private WebElementFacade priceValuePDP;

 @FindBy(xpath = "//select[@data-role='sorter']")
 private WebElementFacade sorterSelectButton;

 private String sorterOption = "(//select[@data-role='sorter']//option[contains(text(),'%s')])[1]";

 public WebElementFacade getLevel1MenuDropdown(String menu1) {
  return find(By.xpath(String.format(level1MenuDropdown, menu1)));
 }

 public WebElementFacade getLevel2MenuDropdown(String menu2) {
  return find(By.xpath(String.format(level2MenuDropdown, menu2)));
 }

 public WebElementFacade getLevel3MenuDropdown(String menu3) {
  return find(By.xpath(String.format(level3MenuDropdown, menu3)));
 }

 public WebElementFacade getColorFilterButton() {
  return colorFilterButton;
 }

 public WebElementFacade getColorChoiceButton(String colorChoice) {
  return find(By.xpath(String.format(colorChoiceButton, colorChoice)));
 }

 public List<WebElementFacade> getSelectedColor(String color) {
  return find(By.xpath(String.format(selectedColor, color)));
 }

 public WebElementFacade getFirstPriceRange() {
  return firstPriceRange;
 }

 public WebElementFacade getFixedPriceRange(String fixedPrice) {
  return find(By.xpath(String.format(fixedPriceRange, fixedPrice)));
 }

 public List<WebElementFacade> getItemsList() {
  return itemsList;
 }

 public WebElementFacade getPriceFilterButton() {
  return priceFilterButton;
 }

 public WebElementFacade getPriceValuePDP() {
  return priceValuePDP;
 }

 public WebElementFacade getSorterSelectButton() {
  return sorterSelectButton;
 }

 public WebElementFacade getSorterOption(String option) {
  return find(By.xpath(String.format(sorterOption, option)));
 }

}
