package com.e2etests.automation.step_definitions;

import java.time.Duration;
import java.util.Random;

import com.e2etests.automation.page_objects.CustomerPage;
import com.e2etests.automation.page_objects.VendorPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.RandomValue;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VendorStepDefinition {
	private VendorPage  vendorPage; 
	private RandomValue random;
	private SeleniumUtils seleniumUtils;
	private ConfigFileReader configFileReader;
	private Validations validations;
	private Wait wait;
	
	public VendorStepDefinition() {

		this.vendorPage = new VendorPage();
		this.random = new  RandomValue();
		this.seleniumUtils = new SeleniumUtils();
		this.configFileReader = new ConfigFileReader();
		this.validations = new Validations();
		this.wait = new Wait(Setup.getDriver());
	
	}
	
	
	@When("Je clique sur le boutton custmor")
	public void jeCliqueSurLeBouttonCustmor() {
		seleniumUtils.click(vendorPage.btnCustmor);
		wait.forElementToBeDisplayed(Duration.ofSeconds(20), vendorPage.btnVendor, "nan");
	    
	}
	@When("Je clique sur le boutton Vendor")
	public void jeCliqueSurLeBouttonVendor() {
		seleniumUtils.click(vendorPage.btnVendor);
	   
	}
	@When("Je saisier le nom de  dans le champs name de vendor")
	public void jeSaisierLeNomDeDansLeChampsNameDeVendor() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(20),vendorPage.SearchName, "nan");
		seleniumUtils.writeText(vendorPage.SearchName,configFileReader.getProperties("vendor.name"));

	}
	@When("Je clique sur boutton search")
	public void jeCliqueSurBouttonSearch() {
		seleniumUtils.click(vendorPage.btnsearchvendors);

	}
	@Then("le vendor s affiche  dans le tableau")
	public void leVendorSAfficheDansLeTableau() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(20),vendorPage.assertElemntTab, "nan");
		validations.assertTrue(vendorPage.assertElemntTab, configFileReader.getProperties("vendor.name"));

	}



	@When("Je clique sur le boutton editer")
	public void jeCliqueSurLeBouttonEditer() throws InterruptedException {
		Thread.sleep(3000);
		seleniumUtils.click(vendorPage.btnEdit);

	}
	@When("Je modifer les informatios de vendor")
	public void jeModiferLesInformatiosDeVendor() {
		seleniumUtils.writeText(vendorPage.nameEditer, random.getSaltStringText());
	 
	}
	@When("Je clique sur le boutton save")
	public void jeCliqueSurLeBouttonSave() {
		seleniumUtils.click(vendorPage.btnsave);
	
	}
	@Then("un message de mise ajours s affiche")
	public void unMessageDeMiseAjoursSAffiche() {
		wait.forElementToBeDisplayed(Duration.ofSeconds(20), vendorPage.assertAjout, configFileReader.getProperties("vendor.message"));

	}




}
