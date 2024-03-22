package pageObjects.swaglabs;

import components.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.net.MalformedURLException;

public class poCheckout extends Constants {

    private int timeout = 10;
    public poCheckout(WebDriver driver) throws MalformedURLException {
        super();
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, this.timeout), this);
        helpers = new SeleniumHelpers(this.driver);
    }

    /** Products locators **/
    @FindBy(css = ".title")
    public WebElement headerProd;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement btnAddBike;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement btnAddBPack;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    public WebElement btnAddRShirt;

    @FindBy(css = ".shopping_cart_link")
    public WebElement iconCart;

    /** product details **/
    @FindBy(css = "#item_4_title_link > .inventory_item_name")
    public WebElement selItemBPack;

    @FindBy(css = ".inventory_details_name")
    public WebElement itemName;

    @FindBy(css = ".inventory_details_price")
    public WebElement itemPrice;

    @FindBy(css = ".inventory_details_img")
    public WebElement itemImg;

    @FindBy(css = "#back-to-products")
    public WebElement btnBack;

    /** Shopping Cart locators **/
    @FindBy(css = ".title")
    public WebElement titleCart;
    @FindBy(css = "#item_3_title_link > .inventory_item_name")
    public WebElement itemTitle00;
    @FindBy(id = "remove-test.allthethings()-t-shirt-(red)")
    public WebElement btnRemove00;
    @FindBy(css = "#item_4_title_link > .inventory_item_name")
    public WebElement itemTitle01;
    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement btnRemove01;
    @FindBy(css = "#item_0_title_link > .inventory_item_name")
    public WebElement itemTitle02;
    @FindBy(id = "remove-sauce-labs-bike-light")
    public WebElement btnRemove02;
    @FindBy(css = "#continue-shopping")
    public WebElement btnContShop;
    @FindBy(css = "#checkout")
    public WebElement btnCheckout;

    /** Customer Information locators **/
    @FindBy(css = ".title")
    public WebElement titleInformation;
    @FindBy(css = "#first-name")
    public WebElement inputFirstname;
    @FindBy(css = "#last-name")
    public WebElement inputLastname;
    @FindBy(css = "#postal-code")
    public WebElement inputZipCode;
    @FindBy(css = "#continue")
    public WebElement btnContinue;

    /** Overview Information locators **/
    @FindBy(css = ".title")
    public WebElement titleOverview;
    @FindBy(css = ".summary_info_label:nth-child(1)")
    public WebElement lblPayment;
    @FindBy(css = ".summary_info_label:nth-child(3)")
    public WebElement lblShipping;
    @FindBy(css = ".summary_info_label:nth-child(5)")
    public WebElement lblPrice;
    @FindBy(css = ".summary_tax_label")
    public WebElement lblTaxAmount;
    @FindBy(css = ".summary_tax_label")
    public WebElement totalAmount;
    @FindBy(css = "#finish")
    public WebElement btnFinish;

    /** Success Checkout locators **/
    @FindBy(css = ".complete-header")
    public WebElement h1Success;
    @FindBy(css = ".complete-text")
    public WebElement txtSuccess;
    @FindBy(css = ".complete-header")
    public WebElement btnBackProducts;

}
