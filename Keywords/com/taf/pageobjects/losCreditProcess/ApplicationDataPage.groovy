package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.OPTIONAL
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.VerifyElementTextKeyword
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

public class ApplicationDataPage extends BaseHelper {

	private TestObject btnSaveContinue			= createTestObject("btnSaveContinue", "id", "lb_Form_SaveCont")
	private TestObject drpCopyAddressFrom		= createTestObject("drpCopyAddressFrom", "id", "ucRefCopyAddr_ddlReference")
	private TestObject btnCopyAddress			= createTestObject("btnCopyAddress", "id", "lb_Form_CopyAddr")

	private TestObject btnSearchMOUNo			= createTestObject("btnSearchMOUNo", "id", "ucLookupMOU_uclMOU_imb")
	private TestObject txfOvlyMOUNo				= createTestObject("txfOvlyMOUNo", "id", "ucLookupMOU_uclMOU_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject btnOvlySearchMOU			= createTestObject("btnOvlySearchMOU", "id", "ucLookupMOU_uclMOU_umd_ctl00_ucS_lbSearch")
	private TestObject btnOvlySelectMOU			= createTestObject("btnOvlySelectMOU", "id", "ucLookupMOU_uclMOU_umd_ctl00_gvL_hpSelect_0")
	private TestObject txfTenor					= createTestObject("txfTenor", "id", "ucINTenor_txtInput")
	private TestObject drpPaymentFreq			= createTestObject("drpPaymentFreq", "id", "ucRefPaymentFreq_ddlReference")
	private TestObject drpMarginType			= createTestObject("drpMarginType", "id", "ucRefInterestType_ddlReference")
	private TestObject drpInstallmentScheme		= createTestObject("drpInstallmentScheme", "id", "ucRefInstScheme_ddlReference")
	private TestObject drpSalesOfficer			= createTestObject("drpSalesOfficer", "id", "ucRefSalesOfficer_ddlReference")
	private TestObject drpAppSource				= createTestObject("drpAppSource", "id", "ucRefAppSource_ddlReference")
	private TestObject drpCharOfCredit			= createTestObject("drpCharOfCredit", "id", "ddlKodeSifatKredit")
	private TestObject drpWayOfPayment			= createTestObject("drpWayOfPayment", "id", "ucRefWOP_ddlReference")

	private TestObject txfAddress				= createTestObject("txfAddress", "xpath", "//*[contains(@id, 'txtOfficeAddr')]")
	private TestObject txfRT					= createTestObject("txfRT", "xpath", "//*[contains(@id,'txtRT')]")
	private TestObject txfRW					= createTestObject("txfRW", "xpath", "//*[contains(@id,'txtRW')]")
	private TestObject txfZIPCode				= createTestObject("txfZIPCode", "xpath", "//*[contains(@id,'uclZipCode_txt')]")
	private TestObject btnSearchZIPCode			= createTestObject("btnSearchZIPCode", "xpath", "//*[contains(@id, 'uclZipCode_imb')]")
	private TestObject txfSubdistrict			= createTestObject("txfSubdistrict", "xpath", "//*[contains(@id, 'txtKelurahan')]")
	private TestObject txfDistrict				= createTestObject("txfDistrict", "xpath", "//*[contains(@id,'txtKecamatan')]")
	private TestObject txfCity					= createTestObject("txfCity", "xpath", "//*[contains(@id,'uctxtCity')]")

	private TestObject txfOvlyZipCode			= createTestObject("txfOvlyZIPCode", "xpath", "//*[contains(@id,'txtSearchValue_3')]")
	private TestObject btnOvlySearchZipCode		= createTestObject("btnOvlySearchZipCode", "xpath", "//*[contains(@id,'ucS_lbSearch')]")
	private TestObject btnOvlySelectZipCode		= createTestObject("btnOvlySelectZipCode", "xpath", "//*[contains(@id,'hpSelect_0')]")
	private TestObject txfMouNo 				= createTestObject("txfMouNo", "id", "ucLookupMOU_uclMOU_txt") 


	private void verifyLandingInAppData() {
		WebUI.delay(2)
		verifyLanding(txfTenor, "Application Data")
		WebUI.takeScreenshot()
	}
	private void inputTenor(String tenor) {
		String strTenor = WebUI.getText(txfTenor)
		if(!tenor.equalsIgnoreCase(strTenor)) {
			clearAndSetText(txfTenor, tenor)
		}
	}

	private void selectPaymentFrequency(String frequency) {
		boolean isOptionEnabled = WebUI.verifyElementPresent(drpPaymentFreq, 1, OPTIONAL)
		if(isOptionEnabled) {
			safetySelect(drpPaymentFreq, frequency)
		}
	}
	private void selectMarginType(String marginType) {
		safetySelect(drpMarginType, marginType)
	}
	private void selectInstallmentScheme(String scheme) {
		safetySelect(drpInstallmentScheme, scheme)
	}

	private void selectSalesOfficer(String salesOfficer) {
		if(!WebUI.verifyElementText(drpSalesOfficer, salesOfficer, OPTIONAL)) {
			safetySelect(drpSalesOfficer, salesOfficer)
		}
	}
	private void selectAndCopyAddressFrom(String addressType) {
		boolean isElementEnabled = WebUI.verifyElementPresent(drpCopyAddressFrom, 2, OPTIONAL)
		if(isElementEnabled) {
			safetySelect(drpCopyAddressFrom, addressType)
		}
		WebUI.delay(3)
		WebUI.click(btnCopyAddress)
		WebUI.delay(1)
	}

	private void inputAddress(String address) {
		safetyInputEdit(txfAddress, address)
	}


	private void inputRT(String rt) {
		safetyInputEdit(txfRT, rt, 1.5)
	}

	private void searchAddress(String zipCode) {
		safetyClick(btnSearchZIPCode)
		WebUI.delay(2)
		safetyInput(txfOvlyZipCode, zipCode)

		WebUI.delay(2)
		safetyClick(btnOvlySearchZipCode)
		WebUI.takeScreenshot()

		WebUI.delay(2)
		safetyClick(btnOvlySelectZipCode) //select first address
	}

	private void inputRW(String rw) {
		safetyInputEdit(txfRW, rw, 1.5)
	}

	private void inputPhoneNumbers(String phoneNumber, int index) {
		if(phoneNumber) {
			TestObject countryField, areaField, numberField
			countryField	= createTestObject("countryField", "xpath", "//*[@id='ucAddr_txtPhnArea${index}']")
			areaField		= createTestObject("areaField", "xpath", "//*[@id='ucAddr_txtPhn${index}']")
			numberField		= createTestObject("numberField", "xpath", "//*[@id='ucAddr_txtPhoneExt${index}']")

			KeywordUtil.logInfo("phone " + phoneNumber)
			String[] parts = phoneNumber.split("-")
			if (parts.size() != 3) {
				KeywordUtil.markWarning("Invalid phone format: ${phoneNumber}. Expected format is XXX-XXX-XXX")
			}

			WebUI.setText(countryField, parts[0])
			WebUI.delay(2)
			WebUI.setText(areaField, parts[1])
			WebUI.delay(2)
			WebUI.setText(numberField, parts[2])
		}
	}

	private void selectAppSource(String appSource) {
		safetySelect(drpAppSource, appSource)
		WebUI.takeScreenshot()
	}

	private void selectCharacteristicOfCredit(String charOfCredit) {
		safetySelect(drpCharOfCredit, charOfCredit)
		WebUI.takeScreenshot()
	}

	private void clickSaveContinue() {
		safetyClick(btnSaveContinue)
	}

	private void searchMOUNo(String mouNo) {
		String strMou = WebUI.getText(txfMouNo)
		if(mouNo?.trim() && !strMou.equalsIgnoreCase(mouNo)) {
			safetyClick(btnSearchMOUNo)
			safetyInput(txfOvlyMOUNo, mouNo)
			safetyClick(btnOvlySearchMOU)
			WebUI.takeScreenshot()
			WebUI.delay(2)
			safetyClick(btnOvlySelectMOU)
		}
	}

	private void selectFirstInstallmentType(String firstInstallment) {
		TestObject radFirstInstallment = createTestObject("radFirstInstallment","xpath","//label[normalize-space(text())='${firstInstallment}']/preceding-sibling::input[@type='radio']")
		boolean isElementInteractable = checkElementIsInteractable(radFirstInstallment)
		KeywordUtil.logInfo("element interactable is " +  isElementInteractable)
		if (firstInstallment?.trim() && isElementInteractable) {
			safetyClick(radFirstInstallment)
		}
	}

	private void checkFiduciaCovered(String fiduciaCovered) {
		if(fiduciaCovered) {
			fiduciaCovered = fiduciaCovered.equalsIgnoreCase("Y") ? 'Yes' : "No"
			TestObject radFiduciaCovered = createTestObject("radFiduciaCovered","xpath","//label[normalize-space(text())='${fiduciaCovered}']/preceding-sibling::input[@type='radio']")
			safetyClick(radFiduciaCovered)
		}
	}

	private void selectWayOfPayment(String wayOfPayment) {
		boolean isOptionDisabled = checkOptionDisabled(drpWayOfPayment)
		if(wayOfPayment && !isOptionDisabled) {
			safetySelect(drpWayOfPayment, wayOfPayment)
		}
	}
	
	private void inputApplicationData(String mouNo, String tenor, String frequency, String marginType, String installmentScheme, String salesOfficerName) {
		searchMOUNo(mouNo)
		inputTenor(tenor)
		selectPaymentFrequency(frequency)
		selectMarginType(marginType)
		selectInstallmentScheme(installmentScheme)
		selectSalesOfficer(salesOfficerName)
	}
	private void inputApplicationInfoSection(String appSource, String fiduciaCovered, String wayOfPayment) {
		selectAppSource(appSource)
		checkFiduciaCovered(fiduciaCovered)
		selectWayOfPayment(wayOfPayment)
	}
	
	
}
