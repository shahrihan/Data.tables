package step_defs;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Homepage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class DataTablesTest {
	WebDriver driver;
	Homepage homepage = new Homepage();

	@Given("^Navigate to https://editor\\.datatables\\.net/examples/simple/simple\\.html$")
	public void navigate_to_https_editor_datatables_net_examples_simple_simple_html() throws Throwable {
		driver = Driver.getInstance();
		driver.get(ConfigurationReader.getProperty("url"));
	}

	@Given("^Wait for the webtable to be visible$")
	public void wait_for_the_webtable_to_be_visible() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(homepage.table));

	}

	@Given("^Assert that headers size is (\\d+)\\.$")
	public void assert_that_headers_size_is(int arg1) throws Throwable {
		List<WebElement> headers = homepage.table.findElements(By.tagName("th"));
		System.out.println("WebTable 1 rows count:" + headers.size());
		Assert.assertEquals(6, headers.size());

	}

	@When("^Assert headers namen position office extn start date salary$")
	public void assert_headers_namen_position_office_extn_start_date_salary() throws Throwable {
		List<WebElement> headers = homepage.table.findElements(By.tagName("th"));
		for (WebElement header : headers) {
			System.out.println(header.getText());
		}
	}

	@Then("^Find Bruno Nash in the table then verify that he is a Software Engineer and works in London$")
	public void find_Bruno_Nash_in_the_table_then_verify_that_he_is_a_Software_Engineer_and_works_in_London()
			throws Throwable {
		List<WebElement> inforBruno = homepage.brunoRow.findElements(By.tagName("td"));
		for (WebElement web : inforBruno) {
			System.out.print(web.getText() + " | ");
		}
		System.out.println();
	}

	@When("^Print all webtable content in a similar looking format$")
	public void print_all_webtable_content_in_a_similar_looking_format() throws Throwable {

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']//tbody//tr"));
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + "|");
			}
			System.out.println();

		}

	}

	@Then("^Click on NEW button$")
	public void click_on_NEW_button() throws Throwable {
		homepage.newButton.click();
	}

	@Then("^Add new Employee information$")
	public void add_new_Employee_information() throws Throwable {
		homepage.firstName.sendKeys("Nigorahon");
		homepage.lastName.sendKeys("Mamajonova");
		homepage.position.sendKeys("Software Engineer");
		homepage.office.sendKeys("Washinton DC");
		homepage.extension.sendKeys("1727");
		homepage.startdata.click();
		homepage.nextButton.click();
		homepage.nextButton.click();
		List<WebElement> rows = homepage.calendar.findElements(By.tagName("td"));
		System.out.println(rows.size() + " it is relates to calendar");
		rows.get(4).click();
		homepage.salary.sendKeys("155600");
		homepage.createButton.click();
	}

	@Then("^Search for the employee$")
	public void search_for_the_employee() throws Throwable {
		homepage.searchbox.sendKeys("Nigorahon Mamajonova");
	}

	@Then("^Verify All data displayed in the webtable matched the data you entered in step$")
	public void verify_All_data_displayed_in_the_webtable_matched_the_data_you_entered_in_step() throws Throwable {
		List<String> expResult = new ArrayList<>();
		expResult.add("Nigorahon Mamajonova");
		expResult.add("Software Engineer");
		expResult.add("Washinton DC");
		expResult.add("1727");
		expResult.add("2017-09-01");
		expResult.add("$155,600");

		List<WebElement> results = homepage.resultSearch.findElements(By.tagName("td"));
		List<String> inform = new ArrayList<>();
		for (WebElement result : results) {
			inform.add(result.getText());
			Assert.assertTrue(inform.containsAll(expResult));

		}

	}

}
