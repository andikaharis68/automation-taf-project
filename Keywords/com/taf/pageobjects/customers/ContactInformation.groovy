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
	private TestObject txfMobilePhone2		= createTestObject("txfMobilePhone2", "id", "ucContactInfo_txt_CustEmergencyCntct_MobilePhn2")
	private TestObject txfMobilePhone3		= createTestObject("txfMobilePhone3", "id", "ucContactInfo_txt_CustEmergencyCntct_MobilePhn3")
	
	private TestObject txfPhoneArea1		= createTestObject("txfPhoneArea1", "id", "ucContactInfo_txt_CustEmergencyCntct_PhnArea1")
	private TestObject txfPhone1 			= createTestObject("txfPhone1", "id", "ucContactInfo_txt_CustEmergencyCntct_Phn1")
	private TestObject txfPhoneExt1 		= createTestObject("txfPhoneExt1", "id", "ucContactInfo_txt_CustEmergencyCntct_PhnExt1")
	
	private TestObject txfPhoneArea2		= createTestObject("txfPhoneArea2", "id", "ucContactInfo_txt_CustEmergencyCntct_PhnArea2")
	private TestObject txfPhone2 			= createTestObject("txfPhone2", "id", "ucContactInfo_txt_CustEmergencyCntct_Phn2")
	private TestObject txfPhoneExt2 		= createTestObject("txfPhoneExt2", "id", "ucContactInfo_txt_CustEmergencyCntct_PhnExt2")
	
	private TestObject txfPhoneArea3		= createTestObject("txfPhoneArea3", "id", "ucContactInfo_txt_CustEmergencyCntct_PhnArea3")
	private TestObject txfPhone3 			= createTestObject("txfPhone3", "id", "ucContactInfo_txt_CustEmergencyCntct_Phn3")
	private TestObject txfPhoneExt3 		= createTestObject("txfPhoneExt3", "id", "ucContactInfo_txt_CustEmergencyCntct_PhnExt3")
	
	private TestObject txfFaxArea			= createTestObject("txfFaxArea", "id", "ucContactInfo_txt_CustEmergencyCntct_FaxArea")
	private TestObject txfFax				= createTestObject("txfFax", "xpath", "//*[@id = 'ucContactInfo_txt_CustEmergencyCntct_Fax']")
	
	private TestObject txfEmail1			= createTestObject("txfEmail1", "id", "ucContactInfo_ucEMail1_txtEmail")
	private TestObject txfEmail2			= createTestObject("txfEmail2", "id", "ucContactInfo_ucEMail2_txtEmail")

	//iframe
	private TestObject iframeMainpage 		= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")
	private TestObject iframeCustForm		= createTestObject("iframeCustForm", "xpath", "//*[@id='custForm']")

	public void switchToIframeCustForm() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeCustForm, 1)
	}

	public void verifyLandingScreen() {
		verifyLanding(drpJobPosition, "Add Company - Contact Information")
	}

	public void inputContactData(String name, String jobPosition) {
		if(name && jobPosition) {			
			if(name == "AUTO") {
				name = generateRandomName()
			}
			safetyInputEdit(txfName, name)
			safetySelectEdit(drpJobPosition, jobPosition)
		} 
	}

	public void inputContactInformation(String mobilePhone1, String mobilePhone2, String mobilePhone3, String phone1, String phone2, String phone3, String fax, String email1, String email2) {
		if(mobilePhone1) {
			if(mobilePhone1 == "AUTO") {
				mobilePhone1 = generateRandomPhone()
			}
			safetyInputEdit(txfMobilePhone1, mobilePhone1)
		}
		
		if(mobilePhone2) {
			if(mobilePhone2 == "AUTO") {
				mobilePhone2 = generateRandomPhone()
			}
			safetyInputEdit(txfMobilePhone2, mobilePhone2)
		}
		
		if(mobilePhone3) {
			if(mobilePhone3 == "AUTO") {
				mobilePhone3 = generateRandomPhone()
			}
			safetyInputEdit(txfMobilePhone3, mobilePhone3)
		}
		
		if(phone1) {
			if(phone1 == "AUTO") {
				phone1 = generateRandomPhone(true)
			}
			String[] splittedPhone = phone1.split("-")
			safetyInputEdit(txfPhoneArea1, splittedPhone[0])
			safetyInputEdit(txfPhone1, splittedPhone[1])
			safetyInputEdit(txfPhoneExt1, splittedPhone[2])
		}
		
		if(phone2) {
			if(phone2 == "AUTO") {
				phone2 = generateRandomPhone(true)
			}
			String[] splittedPhone = phone2.split("-")
			safetyInputEdit(txfPhoneArea2, splittedPhone[0])
			safetyInputEdit(txfPhone2, splittedPhone[1])
			safetyInputEdit(txfPhoneExt2, splittedPhone[2])
		}
		
		if(phone3) {
			if(phone3 == "AUTO") {
				phone3 = generateRandomPhone(true)
			}
			String[] splittedPhone = phone3.split("-")
			safetyInputEdit(txfPhoneArea3, splittedPhone[0])
			safetyInputEdit(txfPhone3, splittedPhone[1])
			safetyInputEdit(txfPhoneExt3, splittedPhone[2])
		}
		
		if(fax) {
			String[] splittedFax = fax.split("-")
			safetyInputEdit(txfFaxArea, splittedFax[0])
			WebUI.delay(1)
			safetyInputEdit(txfFax, splittedFax[1])
		}
		
		safetyInputEdit(txfEmail1, email1)
		safetyInputEdit(txfEmail2, email2)
	}

	public void clickSaveAndContinue() {
		WebUI.takeScreenshot()
		safetyClick(btnSaveAndContinue)
	}

	public void verifySaveSuccess() {
		verifyPopUpSuccess(lblSuccess, "Add Company - Contact Information")
	}
}
