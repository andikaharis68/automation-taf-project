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

public class AddressPage extends BaseHelper {


	private TestObject btnAdd					= createTestObject("btnAdd", "xpath", "//*[@id='lb_Form_Add_Addr']")
	private TestObject drpAddressType			= createTestObject("drpAddressType", "xpath", "//*[@id='ucAddrType_ddlReference']")
	private TestObject txfAddress				= createTestObject("txfAddress", "xpath", "//*[@id='ucAddr_txtOfficeAddr']")
	private TestObject txfRT					= createTestObject("txfRT", "xpath", "//*[@id='ucAddr_txtRT']")
	private TestObject txfRW					= createTestObject("txfRW", "xpath", "//*[@id='ucAddr_txtRW']")
	private TestObject txfZIPCode				= createTestObject("txfZIPCode", "xpath", "//*[@id='ucAddr_ucLookupZipCode_uclZipCode_txt']")
	private TestObject btnSearchZIPCode			= createTestObject("btnSearchZIPCode", "xpath", "//*[@id='ucAddr_ucLookupZipCode_uclZipCode_imb']") 
	private TestObject txfSubdistrict			= createTestObject("txfSubdistrict", "xpath", "//*[@id='ucAddr_txtKelurahan']")
	private TestObject txfDistrict				= createTestObject("txfDistrict", "xpath", "//*[@id='ucAddr_txtKecamatan']")
	private TestObject txfCity					= createTestObject("txfCity", "xpath", "//*[@id='ucAddr_txtCity']")
	private TestObject chxCustomerHaveFixedLine	= createTestObject("chxCustomerHaveFixedLine", "xpath", "//*[@id='ucAddr_cbIsPhn1NoMandatory']")

	private TestObject drpBuildingLoc			= createTestObject("drpBuildingLoc", "xpath", "//*[@id='ucCustAddrInfo_ucAddrLocation_ddlReference']")
	private TestObject drpBuildingOwnership		= createTestObject("drpBuildingOwnership", "xpath", "//*[@id='ucCustAddrInfo_ucOwnershipStat_ddlReference']")
	private TestObject txfBuildingPriceEstimate	= createTestObject("txfBuildingPriceEstimate", "xpath", "//*[@id='ucCustAddrInfo_ucHousePrice_txtInput']")
	private TestObject txfBuildingStayLength	= createTestObject("txfBuildingStayLength", "xpath", "//*[@id='ucCustAddrInfo_txtStayLength_txtInput']")
	private TestObject txfDirectionDesc			= createTestObject("txfDirectionDesc", "xpath", "//*[@id='ucCustAddrInfo_txtDirectionDesc']")
	private TestObject txfNotes					= createTestObject("txfNotes", "xpath", "//*[@id='ucCustAddrInfo_txtNotes']")
	private TestObject txfCompanyName			= createTestObject("txfCompanyName", "xpath", "//*[@id='txtCoyName']")

	//overlay
	private TestObject txfOvlySubdistrict		= createTestObject("txfOvlySubdistrict", "xpath", "//*[@id='ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
	private TestObject txfOvlyDistrict			= createTestObject("txfOvlySubdistrict", "xpath", "//*[@id='ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1']")
	private TestObject txfOvlyCity				= createTestObject("txfOvlyCity", "xpath", "//*[@id='ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_2']")
	private TestObject txfOvlyZIPCode			= createTestObject("txfOvlyZIPCode", "xpath", "//*[@id='ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_3']")
	private TestObject btnOvlySearch			= createTestObject("btnOvlySearch", "xpath", "//*[@id='ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_lbSearch']")
	private TestObject btnOvlyReset				= createTestObject("btnOvlyReset", "xpath", "//*[@id='ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_lbReset']")
	private TestObject btnOvlySelect			= createTestObject("btnOvlySelect", "xpath", "//*[@id='ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_gvL_hpSelect_0']")

	private TestObject btnSaveContinue			= createTestObject("btnSaveContinue", "xpath", "//*[@id='lb_Form_SaveCont_CustAddress']")
	private TestObject btnSave					= createTestObject("btnSave", "xpath", "//*[@id='lb_Form_Save_AddCust']")
	private TestObject btnCancel				= createTestObject("btnCancel", "xpath", "//*[@id='lb_Form_Cancel_AddCust']")
	private TestObject iframeAddress			= createTestObject("iframeAddress", "xpath", "//*[@id='custForm']")
	private TestObject btnCopyAddress			= createTestObject("btnCopyAddress", "xpath", "//*[@id='lb_Form_CopyAddr']")
	private TestObject btnSaveAddress			= createTestObject("btnSaveAddress", "xpath", "//*[@id='lb_Form_Save_AddCust']")
	private TestObject drpCopyAddressFrom		= createTestObject("drpCopyAddressFrom", "xpath", "")



	private void verifyLandingInAddressSection() {
		WebUI.delay(2)
		verifyLanding(btnAdd, "Address Section")
	}

	private void selectAddressType(String addressType) {
		WebUI.selectOptionByLabel(drpAddressType, addressType, false)
	}

	private void inputAddress(String address) {
		WebUI.setText(txfAddress, address)
		WebUI.delay(3)
	}

	private Map getAddressDetail(String scenarioId, String addressType, String filePath, String sheetName) {
		def testDataMultiple = BaseHelper.getTestDataMultipleByScenario(sheetName, filePath, scenarioId)
		def testData = testDataMultiple?.find { it.AddressTypeName == addressType }
		if (!testData) {
			KeywordUtil.markFailed("AddressType '${addressType}' not found")
		}
		KeywordUtil.logInfo("testData: $testData")
		return testData
	}

	private void inputRT(String rt) {
		WebUI.setText(txfRT, rt)
		WebUI.delay(3)
	}

	private void inputRW(String rw) {
		WebUI.setText(txfRW, rw)
		WebUI.delay(3)
	}
	private void searchAddress(String city) {
		WebUI.delay(2)
		KeywordUtil.logInfo("1")
		WebUI.click(btnSearchZIPCode)
		KeywordUtil.logInfo("2")
		WebUI.delay(5)
		WebUI.sendKeys(txfOvlyZIPCode, city)
		KeywordUtil.logInfo("3")
		WebUI.delay(3)
		WebUI.click(btnOvlySearch)
		KeywordUtil.logInfo("4")
		WebUI.delay(10)
		WebUI.click(btnOvlySelect) //select first address
		KeywordUtil.logInfo("5")
		WebUI.delay(10)
		handleAlertIfPresent()
	}

	private void checkCustomerHaveFixedline(String customerHaveFixedline) {
		if(customerHaveFixedline?.trim() == 'Y') {
			WebUI.check(chxCustomerHaveFixedLine)
			WebUI.delay(2)
		}
	}

	private void selectBuildingLocation(String buildingLocation) {
		if(buildingLocation) {
			WebUI.selectOptionByLabel(drpBuildingLoc, buildingLocation, false)
		}
	}

	private void selectBuildingOwnerShip(String ownership) {
		if(ownership) {
			WebUI.selectOptionByLabel(drpBuildingOwnership, ownership, false)
		}
	}
	private void clickAddAddress() {
		WebUI.click(btnAdd)
		WebUI.delay(2)
		WebUI.takeScreenshot()
	}

	private void clickSaveContinue() {
		WebUI.scrollToElement(btnSaveContinue, 2)
		WebUI.click(btnSaveContinue)
	}
	private void clickSaveAddress() {
		WebUI.scrollToElement(btnSave, 2)
		WebUI.click(btnSave)
	}
	private void clickCancel() {
		WebUI.click(btnCancel)
	}
	private void inputBuildingPriceEstimates(String priceEstimates) {
		if(priceEstimates) {
			WebUI.setText(txfBuildingPriceEstimate, priceEstimates)
		}
	}
	private void inputBuildingStayLength(String buildingLength) {
		if(buildingLength) {
			WebUI.setText(txfBuildingStayLength, buildingLength)
		}
	}
	private void inputDirectionDesc(String desc) {
		if(desc) {
			WebUI.setText(txfDirectionDesc, desc)
		}
	}
	private void inputNotes(String notes) {
		if(notes) {
			WebUI.setText(txfNotes, notes)
		}
	}
	private void inputCompanyName(String companyName) {
		WebUI.setText(txfCompanyName, companyName)
	}
	private void switchToIframeAddress() {
		WebUI.delay(10)
		WebUI.verifyElementPresent(iframeAddress, 5)
		WebUI.switchToFrame(iframeAddress, 1)
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
			WebUI.delay(2)
			
		}
	}
	private void inputFax(String fax) {
		if(fax) {
			TestObject countryField, areaField
			countryField	= createTestObject("countryField", "xpath", "//*[@id='ucAddr_txtFaxArea']")
			areaField		= createTestObject("areaField", "xpath", "//*[@id='ucAddr_txtFax']")

			String[] parts = fax.split("-")
			if (parts.size() != 3) {
				KeywordUtil.markWarning("Invalid phone format: ${fax}. Expected format is XXX-XXX")
			}
			WebUI.setText(countryField, parts[0])
			WebUI.delay(2)
			WebUI.setText(areaField, parts[1])
			WebUI.delay(2)
		}
	}

	private void clickCopyAddress() {
		WebUI.click(btnCopyAddress)
	}
	private void handleAlertIfPresent() {
		if(WebUI.waitForAlert(5)) {
			WebUI.acceptAlert()
		} else {
			KeywordUtil.logInfo("Alert not found")
		}
	}
}
