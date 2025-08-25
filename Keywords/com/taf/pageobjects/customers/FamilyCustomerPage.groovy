package com.taf.pageobjects.customers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class FamilyCustomerPage extends BaseHelper {
	private TestObject btnAdd				= createTestObject("btnAdd", "xpath", "//*[@id='lb_Form_Add_Family']")
	private TestObject btnSaveAndContinue	= createTestObject("btnSaveAndContinue", "xpath", "//*[@id='lb_Form_SaveCont_Family']")

	private TestObject lblSection 			= createTestObject("lblSection", "xpath", "//*[@id='dFamData']/table/tbody/tr[5]/td[1]")
	private TestObject radCustomerModel		= createTestObject("radCustomerModel", "xpath", "//*[@id='rblCustModel_0']")
	private TestObject txfFamilyName		= createTestObject("txfFamilyName", "xpath", "//input[@id='txtFamilyName']")
	private TestObject drpIDType			= createTestObject("drpIDType", "xpath", "//*[@id='ucMrIdType_ddlReference']")
	private TestObject txfIDNumber			= createTestObject("txfIDNumber", "xpath", "//*[@id='txtFamIdNo']")
	private TestObject txfIDExpiredDate		= createTestObject("txfIDExpiredDate", "xpath", "//*[@id='ucIdExpiredDt_txtDatePicker']")
	private TestObject radGender			= createTestObject("radGender", "xpath", "//*[@id='rblCustGender_0']")
	private TestObject txfPOB				= createTestObject("txfPOB", "xpath", "//input[@id='txtBirthPlace']")
	private TestObject txfDOB				= createTestObject("txfDOB", "xpath", "//*[@id='ucBirthDate_txtDatePicker']")
	private TestObject txfNPWP				= createTestObject("txfNPWP", "xpath", "//*[@id='txtNpwp']")
	private TestObject txfMotherMaidenName	= createTestObject("txfMotherMaidenName", "xpath", "//*[@id='txtMotherMaidenName']")
	private TestObject drpCustRelationship	= createTestObject("drpCustRelationship", "xpath", "//*[@id='ucMrCustRelationship_ddlReference']")

	private TestObject btnNewFamily			= createTestObject("btnNewFamily", "id", "lb_Form_NewFam")
	private TestObject btnNext				= createTestObject("btnNext", "xpath", "//*[@id='lb_Form_Next_Family']")
	private TestObject btnCancel			= createTestObject("btnCancel", "xpath", "//*[@id='lb_Toolbar_Cancel']")
	private TestObject iframeMainpage 		= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")
	private TestObject lblNewCustomer		= createTestObject("lblNewCustomer", "xpath", "//*[@id='lb_Form_NewCustomer']")

	private TestObject btnSelectFamily		= createTestObject("btnSelectFamily", "xpath", "//*[@id='lb_Form_Select_Fam']")
	private TestObject radSelectFamily		= createTestObject("radSelectFamily", "xpath", "//*[contains(@id, 'rbSelect')]")


	private void verifyLandingFamilyPage() {
		WebUI.takeScreenshot()
		verifyLanding(btnAdd, "Family Page")
	}

	private void clickAdd() {
		safetyClick(btnAdd)
		WebUI.takeScreenshot()
	}

	private void inputFamilyName(String name) {
		if(name) {
			if(name == "AUTO") {
				name = generateRandomName()
			}
			safetyInput(txfFamilyName, name)
		}
	}

	private void selectCustomerModel(String model) {
		if (model?.trim()) {
			TestObject radCustomerModel = createTestObject("radCustomerModel","xpath",	"//label[normalize-space(text())='${model}']/preceding-sibling::input[@type='radio']")
			if (!WebUI.verifyElementChecked(radCustomerModel, 1)) {
				safetyClick(radCustomerModel)
			}
		}
	}

	private void selectIdType(String idType) {
		safetySelect(drpIDType, idType)
	}

	private void inputIdNumber(String idNumber) {
		if(idNumber) {
			if(idNumber == "AUTO") {
				idNumber = generateRandomNik()
			}
			safetyInput(txfIDNumber, idNumber)
		}
	}

	private void inputIdExpiredDate(String idExpiredDate) {
		safetyClick(txfIDExpiredDate)
		safetyInput(txfIDExpiredDate, idExpiredDate)
		clickTABKeyboard(txfIDExpiredDate)
	}
	private void selectGender(String gender) {
		TestObject radGender = createTestObject("radGender","xpath","//label[normalize-space(text())='${gender}']/preceding-sibling::input[@type='radio']")
		if (gender?.trim()) {
			if (!WebUI.verifyElementChecked(radGender, 1, FailureHandling.OPTIONAL)) {
				safetyClick(radGender)
			}
		}
		
	}


	private void inputPOB(String pob) {
		safetyInput(txfPOB, pob)
		clickTABKeyboard(txfPOB)
	}

	private void inputDOB(String dob) {
		safetyInput(txfDOB, dob)
		clickTABKeyboard(txfDOB)
	}

	private void inputNPWP(String npwp) {
		if(npwp) {
			if(npwp == "AUTO") {
				npwp = generateRandomNpwp()
			}
			String currentText = WebUI.getText(txfNPWP).trim()
			if (!currentText) {
				KeywordUtil.logInfo("NPWP auto filled")
			} else {
				safetyInput(txfNPWP, npwp)
			}
		}
	}


	private void inputMotherMaidenName(String motherMaidenName) {
		if(motherMaidenName) {
			if(motherMaidenName == "AUTO") {
				motherMaidenName = generateRandomName()
			}
			safetyInput(txfMotherMaidenName, motherMaidenName)
		}
	}
	private void switchToIframeMain() {
		WebUI.switchToFrame(iframeMainpage, 1)
	}

	private void switchToDefaultContent() {
		WebUI.switchToDefaultContent()
	}
	private void clickNextButton() {
		safetyClick(btnNext)
	}

	private void selectCustomerRelationship(String relationship) {
		safetySelect(drpCustRelationship, relationship)
		WebUI.delay(2)
		WebUI.takeScreenshot()
	}
	private void clickSaveContinue() {
		safetyClick(btnSaveAndContinue)
	}
	private void clickNext() {
		safetyClick(btnNext)
	}
	private void clickSelectFamily() {
		WebUI.delay(5)
		if(WebUI.waitForElementPresent(radSelectFamily, 5)) {			
			safetyClick(radSelectFamily)
			WebUI.takeScreenshot()
			safetyClick(btnSelectFamily)
		} else {
			safetyClick(btnNewFamily)
			WebUI.takeScreenshot()
		}
		
		WebUI.delay(2)
	}
}
