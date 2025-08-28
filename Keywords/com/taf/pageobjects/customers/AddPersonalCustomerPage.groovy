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

public class AddPersonalCustomerPage extends BaseHelper {

	private TestObject txfCustomerName		= createTestObject("txfCustomerName", "xpath", "//input[@id='txtCustName']")
	private TestObject drpIDType			= createTestObject("drpIDType", "xpath", "//*[@id='ucId_ucRefCustIdType_ddlReference']")
	private TestObject txfIDNumber			= createTestObject("txfIDNumber", "xpath", "//input[@id='ucId_txtCustIdNo']")
	private TestObject txfIDExpiredDate		= createTestObject("txfIDExpiredDate", "xpath", "//input[@id='ucIdExpiredDt_txtDatePicker']")
	private TestObject txfPOB				= createTestObject("txfPOB", "xpath", "//input[@id='txtBirthPlace']")
	private TestObject txfDOB				= createTestObject("txfDOB", "xpath", "//*[@id='ucBirthDate_txtDatePicker']")
	private TestObject txfNPWP				= createTestObject("txfNPWP", "xpath", "//*[@id='txtNpwp']")
	private TestObject txfMotherMaidenName	= createTestObject("txfMotherMaidenName", "xpath", "//*[@id='txtMotherMaidenName']")

	private TestObject btnNext				= createTestObject("btnNext", "xpath", "//*[@id='lb_Toolbar_Next']")
	private TestObject btnCancel			= createTestObject("btnCancel", "xpath", "//*[@id='lb_Toolbar_Cancel']")
	private TestObject iframeMainpage 		= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")


	private void verifyLandingAddPersonalPage() {
		verifyLanding(txfCustomerName, "Add Personal Customer")
		WebUI.takeScreenshot()
	}

	private String inputCustomerName(String name) {
		if(name) {
			if(name == "AUTO") {
				name = generateRandomName()
			}
			safetyInput(txfCustomerName, name)
		}
		return name
	}


	private void selectCustomerModel(String model) {
		if (model?.trim()) {
			TestObject radCustomerModel = createTestObject("radCustomerModel","xpath",	"//label[normalize-space(text())='${model}']/preceding-sibling::input[@type='radio']")
			if (!WebUI.verifyElementChecked(radCustomerModel, 1, FailureHandling.OPTIONAL)) {
				safetyClick(radCustomerModel)
			}
		}
	}

	private void selectIdType(String idType) {
		if(idType) {
			safetySelect(drpIDType, idType)
		}
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
		WebUI.click(txfIDExpiredDate)
		safetyInput(txfIDExpiredDate, idExpiredDate, 1.0)
		clickEnter(txfIDExpiredDate)
	}

	private void selectGender(String gender) {
		TestObject radGender = createTestObject("radGender","xpath", "//label[normalize-space(text())='${gender}']/preceding-sibling::input[@type='radio']")
		if (gender?.trim()) {
			if (!WebUI.verifyElementChecked(radGender, 1, FailureHandling.OPTIONAL)) {
				safetyClick(radGender)
				WebUI.delay(2)
			}
		}
	}

	private void inputPOB(String pob) {
		safetyInput(txfPOB, pob)
	}

	private void inputDOB(String dob) {
		safetyInput(txfDOB, dob)
		clickEnter(txfDOB)
	}

	private void inputNPWP(String npwp) {
		if(npwp) {

			String currentText = WebUI.getText(txfNPWP).trim()
			if (currentText) {
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
			WebUI.takeScreenshot()
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
}