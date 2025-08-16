package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
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

	public void uploadDocumentCustomer() {
		String[] actualText = WebUI.getText(txtCustomerRemarks).split(":")
		String remarks = actualText[1].trim()
		
		File filePdf = new File(GlobalVariable.TEST_DATA_LOCATION + "Resources/Credit_Simulation.pdf")
		WebUI.waitForElementPresent(btnChooseFile, 10)
		WebUI.sendKeys(btnChooseFile, filePdf.absolutePath)
		
		WebUI.setText(txfRemarks, remarks)
		WebUI.click(btnUpload)
	}
	
	public void uploadDocumentSpouse() {
		String[] actualText = WebUI.getText(txtSpouseRemarks).split(":")
		String remarks = actualText[1].trim()
		
		File filePdf = new File(GlobalVariable.TEST_DATA_LOCATION + "Resources/Credit_Simulation.pdf")
		WebUI.waitForElementPresent(btnChooseFile, 10)
		WebUI.sendKeys(btnChooseFile, filePdf.absolutePath)
		
		WebUI.setText(txfRemarks, remarks)
		WebUI.click(btnUpload)
	}
	
	public void uploadDocumentSTNK() {
		String[] actualText = WebUI.getText(txtSTNKRemarks).split(":")
		String remarks = actualText[1].trim()
		
		File filePdf = new File(GlobalVariable.TEST_DATA_LOCATION + "Resources/Credit_Simulation.pdf")
		WebUI.waitForElementPresent(btnChooseFile, 10)
		WebUI.sendKeys(btnChooseFile, filePdf.absolutePath)
		
		WebUI.setText(txfRemarks, remarks)
		WebUI.click(btnUpload)
	}

	public void clickSave() {
		WebUI.click(btnSave)
	}

	public void clickSubmit() {
		WebUI.click(btnSubmit)
	}
	
}
