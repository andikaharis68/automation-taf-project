package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class CustomerDataPage extends BaseHelper {

	private TestObject txtNpwp				= createTestObject("txtNpwp", "xpath", "//*[contains(@id, 'txtNpwp') or contains(@id, 'txtCoyNpwp')]")
	private TestObject btnSaveContinue		= createTestObject("btnSaveContinue", "xpath", "//*[@id='lb_Form_SaveCont']")
	private TestObject btnSaveApplication	= createTestObject("btnSaveApplication", "id", "lbl_Toolbar_Save")
	private TestObject btnSubmit			= createTestObject("btnSubmit", "id", "lbl_Toolbar_Submit")
	private TestObject btnCancelApp			= createTestObject("btnCancelApp", "id", "lb_Toolbar_Cancel")
	private TestObject iframeAppForm		= createTestObject("iframeAppForm", "xpath", "//*[@id='appForm']")
	private TestObject tabCustomer			= createTestObject("tabCustomer", "xpath", "//*[@id='lbCUS']")

	//main data
	private TestObject txtApplicationNo		= createTestObject("txtApplicationNo", "id", "ucCreditProcessMainInfo_lbAppNo")

	private void clickSaveContinue() {
		WebUI.delay(5)
		WebUI.takeScreenshot()
		safetyClick(btnSaveContinue)
	}

	def scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)")
	}

	private void switchToIframeApp() {
		WebUI.takeScreenshot()
		WebUI.switchToFrame(iframeAppForm, 2)
	}
	private void clickTabCustomer() {
		safetyClick(tabCustomer)
	}

	public void updateAppNoToMasterData(String fileName, String scenarioId) {
		String filePath = GlobalVariable.TEST_DATA_LOCATION + '/' + fileName
		String appNo = WebUI.getText(txtApplicationNo)
		Map rowFilter = [:]
		rowFilter['ScenarioId'] = scenarioId

		saveDataToExcel(appNo, rowFilter, filePath, "MasterData", "ApplicationNo")
	}
	private String getCustomerTypeChecked() {
		WebUI.scrollToElement(txtNpwp, 2)
		TestObject radios = createTestObject("radios", "xpath", "//input[@name='rblCustType']")
		List<WebElement> radioList = WebUI.findWebElements(radios, 5)

		for (WebElement radio : radioList) {
			if (radio.isSelected()) {
				String id = radio.getAttribute("id")
				TestObject labelObj = new TestObject("labelForRadio")
				labelObj.addProperty("xpath", ConditionType.EQUALS, "//label[@for='$id']")
				String labelText = WebUI.getText(labelObj)
				KeywordUtil.logInfo(labelText)
				return labelText
			}
		}
		return "Not found checked"
	}
}
