package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.CONTINUE_ON_FAILURE
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.concurrent.ConcurrentHashMap.KeySetView

import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.WaitForElementPresentKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class CreditSimulationToNewApplication extends BaseHelper {
	//header
	private TestObject iframeAppForm = createTestObject("iframeAppForm", "id", "appForm")
	private TestObject iframeMain = createTestObject("iframeMain", "id", "mainPage")
	private TestObject lblTitle = createTestObject("lblTitle", "id", "pageTitle")
	private TestObject btnSave = createTestObject("btnSave", "id", "lb_ToolbarSubmit")
	private TestObject btnSubmit = createTestObject("btnSubmit", "id", "lb_ToolbarSubmitFinal")

	//main data
	private TestObject txfMobilePhone = createTestObject("txfMobilePhone", "id", "txtMblPhn1")
	private TestObject txfNPWP = createTestObject("txfNPWP", "id", "txtNpwpNo")

	//address info
	private TestObject txfJobAddress = createTestObject("txfJobAddress", "id", "txtOfficeAddr")
	private TestObject txfResidanceAddress = createTestObject("txfResidanceAddress", "id", "txtResidenceAddr")

	//other info
	private TestObject txfNotes = createTestObject("txfNotes", "id", "txtNotes")

	//input remarks
	private TestObject txtCustomerRemarks = createTestObject("txtCustomerRemarks", "id", "lblRemarksCustomer")
	private TestObject txtSpouseRemarks = createTestObject("txtSpouseRemarks", "id", "lblRemarksSpouse")
	private TestObject txtSTNKRemarks = createTestObject("txtSTNKRemarks", "id", "lblRemarksSTNK")
	
	//upload document
	private TestObject btnChooseFile = createTestObject("btnChooseFile", "id", "fileUploadDoc")
	private TestObject txfRemarks = createTestObject("txfRemarks", "id", "txtRemarks")
	private TestObject btnUpload = createTestObject("btnUpload", "id", "btnupload")

	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Credit Simulation To New Aplication")
	}

	public void inputMainData(String phoneNumber, npwpNo) {
		verifyLandingScreen()
		WebUI.takeScreenshot()
		WebUI.setText(txfMobilePhone, phoneNumber)
		WebUI.setText(txfNPWP, npwpNo)
	}

	public void inputAddressInfo(String jobAddress, residanceAddress) {
		WebUI.setText(txfJobAddress, jobAddress)
		WebUI.setText(txfResidanceAddress, residanceAddress)
	}

	public void inputOtherInfo(String notes) {
		WebUI.setText(txfNotes, notes)
	}
	
	public void switchToDefaultContent() {
		WebUI.switchToDefaultContent()
	}
	
	public void switchToMainPage() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeMain, 2)
	}
	
	public void waitSectionUploadFile(int maxWait) {
		int wait = 0
		while(wait < maxWait) {			
			if(WebUI.waitForElementPresent(iframeAppForm, 5, FailureHandling.CONTINUE_ON_FAILURE)) {
				WebUI.switchToFrame(iframeAppForm, 2)
				WebUI.scrollToElement(btnChooseFile, 1, FailureHandling.CONTINUE_ON_FAILURE)
				break;
			}
			WebUI.delay(1)
			wait++
		}
		
	}

	public void uploadDocumentCustomer(String remark) {
		File filePdf = new File(GlobalVariable.TEST_DATA_LOCATION + "Resources/Credit_Simulation.pdf")
		WebUI.waitForElementPresent(btnChooseFile, 10)
		WebUI.sendKeys(btnChooseFile, filePdf.absolutePath)
		WebUI.delay(3)
		WebUI.setText(txfRemarks, remark)
		WebUI.click(btnUpload)
		WebUI.delay(3)
	}
	
	public void uploadDocumentSpouse(String remark) {
		File filePdf = new File(GlobalVariable.TEST_DATA_LOCATION + "Resources/Credit_Simulation.pdf")
		WebUI.waitForElementPresent(btnChooseFile, 10)
		WebUI.sendKeys(btnChooseFile, filePdf.absolutePath)
		WebUI.delay(3)
		WebUI.setText(txfRemarks, remark)
		WebUI.click(btnUpload)
		WebUI.delay(3)
	}
	
	public void uploadDocumentSTNK(String remark) {
		File filePdf = new File(GlobalVariable.TEST_DATA_LOCATION + "Resources/Credit_Simulation.pdf")
		WebUI.waitForElementPresent(btnChooseFile, 10)
		WebUI.sendKeys(btnChooseFile, filePdf.absolutePath)
		WebUI.delay(3)
		WebUI.setText(txfRemarks, remark)
		WebUI.click(btnUpload)
		WebUI.delay(3)
	}

	public void clickSave() {
		WebUI.click(btnSave)
	}

	public void clickSubmit() {
		WebUI.takeScreenshot()
		WebUI.click(btnSubmit)
		WebUI.delay(1)
		WebUI.acceptAlert()
		WebUI.delay(5)
	}
	
}
