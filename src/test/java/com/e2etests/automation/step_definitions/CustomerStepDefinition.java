package com.e2etests.automation.step_definitions;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.e2etests.automation.page_objects.CustomerPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.RandomValue;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerStepDefinition {
	private CustomerPage customerPage;
	private SeleniumUtils seleniumUtils;
	private ConfigFileReader configFileReader;
	private Validations validations;
	private Wait wait;
	private RandomValue random;

	public CustomerStepDefinition() {

		this.customerPage = new CustomerPage();
		this.seleniumUtils = new SeleniumUtils();
		this.configFileReader = new ConfigFileReader();
		this.validations = new Validations();
		this.wait = new Wait(Setup.getDriver());
		this.random = new RandomValue();

	}

	@Given("Je m acceder a l espace customer")
	public void jeMAccederALEspaceCustomer() throws InterruptedException {
		seleniumUtils.click(customerPage.navCustomers);
		// Thread.sleep(2000);
		// wait.waitUntilClickable(Setup.getDriver(), customerPage.btncustomers)
		seleniumUtils.waitForElementToBeClickable(customerPage.btncustomers);
		seleniumUtils.click(customerPage.btncustomers);
	}

	@Given("Je clique sur le botton add new")
	public void jeCliqueSurLeBottonAddNew() {

		seleniumUtils.click(customerPage.btnAddnew);

	}

	@Given("Je saisie l email")
	public void jeSaisieLEmail() {
		seleniumUtils.writeText(customerPage.Email, configFileReader.getProperties("customer.email"));
	}

	@Given("Je saisie le password")
	public void jeSaisieLePassword() {
		seleniumUtils.writeText(customerPage.Password, configFileReader.getProperties("customer.password"));
	}

	@Given("Je select le role")
	public void jeSelectLeRole() {
		// ((JavascriptExecutor)
		// Setup.getDriver()).executeScript("window.scrollBy(0,700)", "");
		// seleniumUtils.multiselectByvalue(customerPage.selectRole,
		// configFileReader.getProperties("customer.roleGest"));

		// seleniumUtils.click(customerPage.selectRole);
		// seleniumUtils.multiselectByvalue(customerPage.selectGest,null);

	}

	@Given("Je clique sur le buton save")
	public void jeCliqueSurLeButonSave() {
		seleniumUtils.click(customerPage.btnsave);
	}

	@Then("un message  d ajout s affiche")
	public void unMessageDAjoutSAffiche() {

		validations.assertTrue(customerPage.assertMessageAjout,configFileReader.getProperties("customer.ajoutMessageAssert"));

	}

	@When("Je saisie l email a chercher")
	public void jesaisielemailachercher() {
		seleniumUtils.writeText(customerPage.email, configFileReader.getProperties("customer.email"));

	}

	@When("Je clique sur le boutton searsh")
	public void jeCliqueSurLeBouttonSearsh() {
		seleniumUtils.click(customerPage.btnsearch);
		((JavascriptExecutor) Setup.getDriver()).executeScript("window.scrollBy(0,700)", "");
	}

	@Then("le costomer s affiche dans le tableu")
	public void leCostomerSAfficheDansLeTableu() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(20), customerPage.elementTableau, "NAN");
		validations.assertEquals(customerPage.elementTableau, configFileReader.getProperties("customer.email"));

	}

	@When("Je saisie un email non existant")
	public void jeSaisieUnEmailNonExistant() {
		seleniumUtils.writeText(customerPage.email, random.getSaltString());

	}

	@Then("un tableau s affiche vide")
	public void unTableauSAfficheVide() throws InterruptedException {
		wait.forElementToBeDisplayed(Duration.ofSeconds(20), customerPage.tableauVide, "NAN");
		validations.assertTrue(customerPage.tableauVide, configFileReader.getProperties("customer.msg"));
	}

	@When("Je clique sur le boutton edit")
	public void jeCliqueSurLeBouttonEdit() {
		seleniumUtils.click(customerPage.editbtn);

	}

	@When("Je modifer les informations souhaiter")
	public void jeModiferLesInformationsSouhaiter() {
		seleniumUtils.writeText(customerPage.Email, random.getSaltString());

	}


	@Then("un message de mise a jour sera afiicher")
	public void unMessageDeMiseAJourSeraAfiicher() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(20), customerPage.assertMessageUpadte, "nan");
        validations.assertTrue(customerPage.assertMessageUpadte, configFileReader.getProperties("dachbord.updateCust"));
	}

	@When("Je clique sur le boutton delete")
	public void jeCliqueSurLeBouttonDelete() {
		seleniumUtils.click(customerPage.btnDelete);

	}

	@When("Je clique sur alert delete")
	public void jeCliqueSurAlertDelete() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(20), customerPage.btntDeletePop,"nan");
    seleniumUtils.click(customerPage.btntDeletePop);
	}

	@Then("un message delete customer s affiche")
	public void unMessageDeleteCustomerSAffiche() {
     validations.assertTrue(customerPage.assertMessageDelete,configFileReader.getProperties("dachbord.deletCust"));
	}

}
