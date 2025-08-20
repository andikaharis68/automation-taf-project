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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class EmergencyContactPage extends BaseHelper {

	private TestObject btnSave				= createTestObject("btnSave", "xpath", "//*[@id='lb_Form_Save_Emergency']")
	private TestObject btnSaveAndContinue	= createTestObject("btnSaveAndContinue", "xpath", "//*[@id='lb_Form_SaveCont_Emergency']")

	private TestObject btnAdd				= createTestObject("btnAdd", "xpath", "//*[@id='lb_Form_Add_Emergency']")
	private TestObject btnCancel			= createTestObject("btnCancel", "xpath", "//*[@id='lb_Form_Save_Emergency']")
	private TestObject txfName				= createTestObject("txfName", "xpath", "//*[@id='txtEmergencyName']")
	private TestObject drpCustRelationship	= createTestObject("drpCustRelationship", "xpath", "//*[@id='ucMrCustRelationshipEmergency_ddlReference']")
	private TestObject txfEmail1			= createTestObject("txfEmail1", "xpath", "//*[@id='ucEmergencyContactInfo_ucEMail1_txtEmail']")
	private TestObject txfEmail2			= createTestObject("txfEmail2", "xpath", "//*[@id='ucEmergencyContactInfo_ucEMail2_txtEmail']")

	private TestObject txfAddress			= createTestObject("txfAddress", "xpath", "//*[@id='ucEmergencyAddr_txtOfficeAddr']")
	private TestObject txfRT				= createTestObject("txfRT", "xpath", "//*[@id='ucEmergencyAddr_txtRT']")
	private TestObject txfRW				= createTestObject("txfRW", "xpath", "//*[@id='ucEmergencyAddr_txtRW']")
	private TestObject btnSearchZIPCode		= createTestObject("btnSearchZIPCode", "xpath", "//*[@id='ucEmergencyAddr_ucLookupZipCode_uclZipCode_imb']")
	private TestObject txfZIPCode			= createTestObject("txfZIPCode", "xpath", "//*[@id='ucEmergencyAddr_ucLookupZipCode_uclZipCode_txt']")
	private TestObject txfSubdistrict		= createTestObject("txfSubdistrict", "xpath", "//*[@id='ucEmergencyAddr_txtKelurahan']")
	private TestObject txfDistrict			= createTestObject("txfDistrict", "xpath", "//*[@id='ucEmergencyAddr_txtKecamatan']")
	private TestObject txfCity				= createTestObject("txfCity", "xpath", "//*[@id='ucEmergencyAddr_txtCity']")

	private TestObject txfOvlyCity			= createTestObject("txfOvlyCity", "xpath", "//*[@id='ucEmergencyAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_2']")
	private TestObject txfOvlyZipCode		= createTestObject("txfOvlyZipCode", "xpath", "//*[@id='ucEmergencyAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_3']")
	 
	private TestObject btnOvlySearch		= createTestObject("btnOvlySearch", "xpath", "//*[@id='ucEmergencyAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_lbSearch']")
	private TestObject btnOvlyReset			= createTestObject("btnOvlyReset", "xpath", "//*[@id='ucEmergencyAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_lbReset']")
	private TestObject btnOvlySelect		= createTestObject("btnOvlySelect", "xpath", "//*[@id='ucEmergencyAddr_ucLookupZipCode_uclZipCode_umd_ctl00_gvL_hpSelect_0']")


	private void verifyLandingEmergencyContactPage() {
		handleAlertIfPresent()
		verifyLanding(btnAdd, "Emergency Contact")
		WebUI.delay(2)
		WebUI.takeScreenshot()
	}

	private void inputName(String name) {
		if(name) {
			safetyInput(txfName, name)
		}
	}

	private void clickAddContact() {
		safetyClick(btnAdd)
	}

	private void clickSaveAndContinue() {
		safetyClick(btnSaveAndContinue)
	}

	private void clickSaveContact() {
		safetyClick(btnSave)
	}

	private void selectCustomerRelationship(String relationship) {
		if(relationship) {
			safetySelect(drpCustRelationship, relationship)
		}
	}

	private void inputEmails(String email, Integer index) {
		if(email) {
			TestObject txfEmail	= createTestObject("txfEmail", "xpath", "//*[@id='ucEmergencyContactInfo_ucEMail${index}_txtEmail']")
			safetyInput(txfEmail, email)
		}
		WebUI.takeScreenshot()
	}

	private void inputAddress(String address) {
		if(address) {
			safetyInput(txfAddress, address)
		}
	}

	private void inputRT(String RT) {
		if(RT) {
			safetyInput(txfRT, RT)
		}
	}
	private void inputRW(String RW) {
		if(RW) {
			safetyInput(txfRW, RW)
			
		}
	}

	private void searchAddress(String zipCode) {
		safetyClick(btnSearchZIPCode)
		safetyInput(txfOvlyZipCode, zipCode)		
		safetyClick(btnOvlySearch)
		safetyClick(btnOvlySelect)
		WebUI.takeScreenshot()
	}
	
	private void checkAddress(String zipCode) {
		int maxRetry = 3
		int attempt = 0
		boolean isZipCodeBlank = true
		
		while (isZipCodeBlank && attempt < maxRetry) {
			searchAddress(zipCode)   // trigger proses (hit ke DB / API)
			WebUI.delay(2)      // kasih waktu 2 detik nunggu respon update
		
			def zipCodeValue = WebUI.getAttribute(txfOvlyZipCode, 'value')
			isZipCodeBlank = (zipCodeValue == null || zipCodeValue.trim().isEmpty())
		
			attempt++
		}
		
		if (isZipCodeBlank) {
			KeywordUtil.markFailedAndStop("City field masih kosong setelah ${maxRetry} percobaan.")
		}
	}

	private void inputPhoneNumbers(String phoneNumber, int index) {
		if(phoneNumber) {
			TestObject countryField, areaField, numberField
			countryField	= createTestObject("countryField", "xpath", "//*[@id='ucEmergencyAddr_txtPhnArea${index}']")
			areaField		= createTestObject("areaField", "xpath", "//*[@id='ucEmergencyAddr_txtPhn${index}']")
			numberField		= createTestObject("numberField", "xpath", "//*[@id='ucEmergencyAddr_txtPhoneExt${index}']")

			KeywordUtil.logInfo("phone " + phoneNumber)
			String[] parts = phoneNumber.split("-")
			if (parts.size() != 3) {
				KeywordUtil.markWarning("Invalid phone format: ${phoneNumber}. Expected format is XXX-XXX-XXX")
			}

			safetyInput(countryField, parts[0])
			safetyInput(areaField, parts[1])
			safetyInput(numberField, parts[2])
			
		}
	}

	private void inputFax(String fax) {
		if(fax) {
			TestObject countryField, areaField
			countryField	= createTestObject("countryField", "xpath", "//*[@id='ucEmergencyAddr_txtFaxArea']")
			areaField		= createTestObject("areaField", "xpath", "//*[@id='ucEmergencyAddr_txtFax']")

			String[] parts = fax.split("-")
			if (parts.size() != 3) {
				KeywordUtil.markWarning("Invalid phone format: ${fax}. Expected format is XXX-XXX")
			}
			safetyInput(countryField, parts[0])
			safetyInput(areaField, parts[1])
		}
		WebUI.takeScreenshot()
	}

	private void inputMobilePhone(String phone, int index) {
		if(phone) {
			TestObject countryField	= createTestObject("countryField", "xpath", "//*[@id='ucEmergencyContactInfo_txt_CustEmergencyCntct_MobilePhn${index}']")
			safetyInput(countryField, phone)
			WebUI.delay(2)
		}
	}
	
}
