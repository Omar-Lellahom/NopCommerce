package com.e2etests.automation.step_definitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.e2etests.automation.page_objects.CustomerPage;
import com.e2etests.automation.utils.ConfigFileReader;
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

	public CustomerStepDefinition() {

		this.customerPage = new CustomerPage();
		this.seleniumUtils = new SeleniumUtils();
		this.configFileReader = new ConfigFileReader();
		this.validations = new Validations();
		this.wait =  new Wait(Setup.getDriver());
		
	}

	@Given("Je m acceder a l espace customer")
	public void jeMAccederALEspaceCustomer() throws InterruptedException {
		seleniumUtils.click(customerPage.navCustomers);
		//Thread.sleep(2000);
		//wait.waitUntilClickable(Setup.getDriver(), customerPage.btncustomers)
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
		//((JavascriptExecutor) Setup.getDriver()).executeScript("window.scrollBy(0,700)", "");
	//	seleniumUtils.multiselectByvalue(customerPage.selectRole, configFileReader.getProperties("customer.roleGest"));
		
	//	seleniumUtils.click(customerPage.selectRole);
		//seleniumUtils.multiselectByvalue(customerPage.selectGest,null);
	
	}

	@Given("Je clique sur le buton save")
	public void jeCliqueSurLeButonSave() {
    seleniumUtils.click(customerPage.btnsave);
	}

	@Then("un message  d ajout s affiche")
	public void unMessageDAjoutSAffiche() {
		
		validations.assertTrue(customerPage.assertMessageAjout, configFileReader.getProperties("customer.ajoutMessageAssert"));

	}

	@When("Je clique sur le boutton searsh")
	public void jeCliqueSurLeBouttonSearsh() {

	}

	@Then("le costomer s affiche dans le tableu")
	public void leCostomerSAfficheDansLeTableu() {

	}

	@When("Je saisie un email non existant")
	public void jeSaisieUnEmailNonExistant() {

	}

	@Then("un tableau s affiche vide")
	public void unTableauSAfficheVide() {

	}

	@When("Je clique sur le boutton edit")
	public void jeCliqueSurLeBouttonEdit() {

	}

	@When("Je modifer les informations souhaiter")
	public void jeModiferLesInformationsSouhaiter() {

	}

	@When("Je clique sur le boutton save")
	public void jeCliqueSurLeBouttonSave() {

	}

	@Then("un message de mise a jour sera afiicher")
	public void unMessageDeMiseAJourSeraAfiicher() {

	}

	@When("Je clique sur le boutton delete")
	public void jeCliqueSurLeBouttonDelete() {

	}

	@When("Je clique sur alert delete")
	public void jeCliqueSurAlertDelete() {

	}

	@Then("un message delete customer s affiche")
	public void unMessageDeleteCustomerSAffiche() {

	}

}
