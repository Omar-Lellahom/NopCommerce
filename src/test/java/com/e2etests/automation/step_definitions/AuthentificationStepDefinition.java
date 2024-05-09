package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_objects.AuthentificationPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AuthentificationStepDefinition {

	private SeleniumUtils seleniumUtils;
	private ConfigFileReader configFileReader;
	private Validations validations;
	private AuthentificationPage authentificationPage;

	public AuthentificationStepDefinition() {
		this.seleniumUtils = new SeleniumUtils();
		this.configFileReader = new ConfigFileReader();
		this.validations = new Validations();
		this.authentificationPage = new AuthentificationPage();
	}

	@Given("Je me connect a l application nopcommerce")
	public void jeMeConnectALApplicationNopcommerce() {
		seleniumUtils.get(configFileReader.getProperties("home.url"));
		seleniumUtils.writeText(authentificationPage.Email, configFileReader.getProperties("home.mail"));
		seleniumUtils.writeText(authentificationPage.Password, configFileReader.getProperties("home.password"));
		seleniumUtils.click(authentificationPage.btnSumit);

	}

	@Then("Je me rediriger vers le dashbord")
	public void jeMeRedirigerVersLeDashbord() {
		validations.assertEquals(authentificationPage.messageValide, configFileReader.getProperties("home.msg"));
	}

	@Given("Je me connect a l application nopcommerce avec  incorrect coordoner")
	public void jeMeConnectALApplicationNopcommerceAvecIncorrectCoordoner() {
		seleniumUtils.get(configFileReader.getProperties("home.url"));
		seleniumUtils.writeText(authentificationPage.Email, configFileReader.getProperties("home.mailNp"));
		seleniumUtils.writeText(authentificationPage.Password, configFileReader.getProperties("home.passwordNp"));
		seleniumUtils.click(authentificationPage.btnSumit);
	}

	@Then("un message d erreur s affiche")
	public void unMessageDErreurSAffiche() {

		validations.assertTrue(authentificationPage.messageErreur, configFileReader.getProperties("home.msgErreur"));
		

	}

}
