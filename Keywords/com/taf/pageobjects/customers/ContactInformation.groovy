package com.taf.pageobjects.customers

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

public class ContactInformation extends BaseHelper{
	private TestObject btnSaveAndContinue 	= createTestObject("btnSaveAndContinue", "id", "lb_Form_SaveCont_EmergencyContact")
	private TestObject lblSuccess			= createTestObject("lblSuccess", "xpath", "//*[contains(text(), 'Save Success')]")

	//contact data
	private TestObject txfName 				= createTestObject("txfName", "id", "txt_CustEmergencyContact_Name")
	private TestObject drpJobPosition 		= createTestObject("drpJobPosition", "id", "UCRefPersonalJobPositionEmergency_ddlReference")

	//contact information
	private TestObject txfMobilePhone1		= createTestObject("txfMobilePhone1", "id", "ucContactInfo_txt_CustEmergencyCntct_MobilePhn1")
	private TestObject txfPhoneArea1		= createTestObject("txfPhoneArea1", "id", "ucContactInfo_txt_CustEmergencyCntct_PhnArea1")
	private TestObject txfPhone1 			= createTestObject("txfPhone1", "id", "ucContactInfo_txt_CustEmergencyCntct_Phn1")
	private TestObject txfPhoneExt1 		= createTestObject("txfPhoneExt1", "id", "ucContactInfo_txt_CustEmergencyCntct_PhnExt1")
	private TestObject txfEmail1			= createTestObject("txfEmail1", "id", "ucContactInfo_ucEMail1_txtEmail")

	//iframe
	private TestObject iframeMainpage 		= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")
	private TestObject iframeCustForm		= createTestObject("iframeCustForm", "xpath", "//*[@id='custForm']")

	public void switchToIframeCustForm() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeCustForm, 1)
	}

	public void verifyLandingScreen() {
		verifyLanding(drpJobPosition, "Add Company - Contact Information")
		WebUI.takeScreenshot()
	}

	public void inputContactData(String name, String jobPosition) {
		safetyInputEdit(txfName, name)
		safetySelectEdit(drpJobPosition, jobPosition)
	}

	public void inputContactInformation(String mobilePhone1, String phone1, String email1) {
		safetyInputEdit(txfMobilePhone1, mobilePhone1)

		String[] splittedPhone = phone1.split("-")
		safetyInputEdit(txfPhoneArea1, splittedPhone[0])
		safetyInputEdit(txfPhone1, splittedPhone[1])
		safetyInputEdit(txfPhoneExt1, splittedPhone[2])

		safetyInputEdit(txfEmail1, email1)
	}

	public void clickSaveAndContinue() {
		WebUI.takeScreenshot()
		safetyClick(btnSaveAndContinue)
	}

	public void verifySaveSuccess() {
		verifyPopUpSuccess(lblSuccess, "Add Company - Contact Information")
	}
}
