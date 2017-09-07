package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class Homepage {
	private WebDriver driver;

	public Homepage() {
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="thead>tr")
	public WebElement table;
	@FindBy(xpath ="//*[@id=\"row_43\"]")
	public WebElement brunoRow;
	@FindBy(css=" a.dt-button.buttons-create > span")
	public WebElement newButton;
	
	@FindBy(id="DTE_Field_first_name")
	public WebElement firstName;
	
	@FindBy(id="DTE_Field_last_name")
	public WebElement lastName;
	
	@FindBy(id="DTE_Field_position")
	public WebElement position;
	
	@FindBy(id="DTE_Field_office")
	public WebElement office;
	
	@FindBy(id="DTE_Field_extn")
	public WebElement extension;
	
	@FindBy(id="DTE_Field_start_date")
	public WebElement startdata;
	
	@FindBy(id="DTE_Field_salary")
	public WebElement salary;
	
	@FindBy(css=".btn")
	public WebElement createButton;
	@FindBy(css="div.editor-datetime-iconRight > button")
	public WebElement nextButton;
	@FindBy(css=".editor-datetime-table")
	public WebElement calendar;
	@FindBy(css=" input[type='search']")
	public WebElement searchbox;
	@FindBy(css="#row_58")
	public WebElement resultSearch;
	
	
	
	}
