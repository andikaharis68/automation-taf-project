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
	private TestObject drpAddressType			= createTestObject("drpAddressType", "xpath", "//*[contains(@id,'Type_ddlReference')]")
	private TestObject txfAddress				= createTestObject("txfAddress", "xpath", "//*[contains(@id, 'txtOfficeAddr')]")
	private TestObject txfRT					= createTestObject("txfRT", "xpath", "//*[contains(@id,'txtRT')]")
	private TestObject txfRW					= createTestObject("txfRW", "xpath", "//*[contains(@id,'txtRW')]")
	private TestObject txfZIPCode				= createTestObject("txfZIPCode", "xpath", "//*[contains(@id,'uclZipCode_txt')]")
	private TestObject btnSearchZIPCode			= createTestObject("btnSearchZIPCode", "xpath", "//*[contains(@id, 'uclZipCode_imb')]")
	private TestObject txfSubdistrict			= createTestObject("txfSubdistrict", "xpath", "//*[contains(@id, 'txtKelurahan')]")
	private TestObject txfDistrict				= createTestObject("txfDistrict", "xpath", "//*[contains(@id,'txtKecamatan')]")
	private TestObject txfCity					= createTestObject("txfCity", "xpath", "//*[contains(@id,'uctxtCity')]")
	private TestObject chxCustomerHaveFixedLine	= createTestObject("chxCustomerHaveFixedLine", "xpath", "//*[contains(@id,'ucAddr_cbIsPhn1NoMandatory')]")

	private TestObject drpBuildingLoc			= createTestObject("drpBuildingLoc", "xpath", "//*[contains(@id,'ucAddrLocation_ddlReference')]")
	private TestObject drpBuildingOwnership		= createTestObject("drpBuildingOwnership", "xpath", "//*[contains(@id,'ucOwnershipStat_ddlReference')]")
	private TestObject txfBuildingPriceEstimate	= createTestObject("txfBuildingPriceEstimate", "xpath", "//*[contains(@id,'ucHousePrice_txtInput')]") 
	private TestObject txfBuildingStayLength	= createTestObject("txfBuildingStayLength", "xpath", "//*[contains(@id,'txtStayLength_txtInput')]") 
	private TestObject txfDirectionDesc			= createTestObject("txfDirectionDesc", "xpath", "//*[contains(@id,'txtDirectionDesc')]") 
	private TestObject txfNotes					= createTestObject("txfNotes", "xpath", "//*[contains(@id,'txtNotes')]") 
	
	private TestObject txfCompanyName			= createTestObject("txfCompanyName", "xpath", "//*[@id='txtCoyName']")

	//overlay
	private TestObject txfOvlySubdistrict		= createTestObject("txfOvlySubdistrict", "xpath", "//*[contains(@id,'rptFixedSearch_txtSearchValue_0')]")
	private TestObject txfOvlyDistrict			= createTestObject("txfOvlySubdistrict", "xpath", "//*[contains(@id,'rptFixedSearch_txtSearchValue_1')]")
	private TestObject txfOvlyCity				= createTestObject("txfOvlyCity", "xpath", "//*[contains(@id,'rptFixedSearch_txtSearchValue_2')]")
	private TestObject txfOvlyZIPCode			= createTestObject("txfOvlyZIPCode", "xpath", "//*[contains(@id,'rptFixedSearch_txtSearchValue_3')]") 
	private TestObject btnOvlySearch			= createTestObject("btnOvlySearch", "xpath", "//*[contains(@id,'ctl00_ucS_lbSearch')]")
	private TestObject btnOvlyReset				= createTestObject("btnOvlyReset", "xpath", "//*[contains(@id,'ctl00_ucS_lbReset')]")
	private TestObject btnOvlySelect			= createTestObject("btnOvlySelect", "xpath", "//*[contains(@id,'ctl00_gvL_hpSelect_0')]") 

	private TestObject btnSaveContinue			= createTestObject("btnSaveContinue", "xpath", "//*[@id='lb_Form_SaveCont_CustAddress']") 
	
	private TestObject btnSave					= createTestObject("btnSave", "xpath", "//*[contains(@id,'lb_Form_Save_AddCust')]") 
	private TestObject btnCancel				= createTestObject("btnCancel", "xpath", "//*[contains(@id,'lb_Form_Cancel_AddCust')]")
	private TestObject iframeAddress			= createTestObject("iframeAddress", "xpath", "//*[contains(@id,'custForm')]")
	private TestObject btnCopyAddress			= createTestObject("btnCopyAddress", "xpath", "//*[contains(@id,'lb_Form_CopyAddr')]")
	private TestObject btnSaveAddress			= createTestObject("btnSaveAddress", "xpath", "//*[contains(@id,'lb_Form_Save_AddCust')]")
	private TestObject drpCopyAddressFrom		= createTestObject("drpCopyAddressFrom", "xpath", "")



	private void verifyLandingInAddressSection() {
		verifyLanding(btnAdd, "Address Section")
		WebUI.takeScreenshot()
	}

	private void selectAddressType(String addressType) {
		safetySelect(drpAddressType, addressType)
	}

	private void inputAddress(String address) {
		safetyInputEdit(txfAddress, address)
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
		safetyInputEdit(txfRT, rt, 1.5)
	}

	private void searchAddress(String zipCode) {
		safetyClick(btnSearchZIPCode)
		WebUI.delay(2)
		safetyInput(txfOvlyZIPCode, zipCode)

		WebUI.delay(2)
		safetyClick(btnOvlySearch)

		WebUI.delay(2)
		safetyClick(btnOvlySelect) //select first address

		WebUI.delay(2)
		handleAlertIfPresent()
		WebUI.takeScreenshot()
		
	}

	private void inputRW(String rw) {
		safetyInputEdit(txfRW, rw, 1.5)
	}

	private void checkAddress(String zipCode) {
		int maxRetry = 3
		int attempt = 0
		boolean isZipCodeBlank = true

		while (isZipCodeBlank && attempt < maxRetry) {
			searchAddress(zipCode)   // trigger proses (hit ke DB / API)
			WebUI.delay(2)      // kasih waktu 2 detik nunggu respon update

			def zipCodeValue = WebUI.getAttribute(txfOvlyZIPCode, 'value')
			isZipCodeBlank = (zipCodeValue == null || zipCodeValue.trim().isEmpty())

			attempt++
		}

		if (isZipCodeBlank) {
			KeywordUtil.markFailedAndStop("City field masih kosong setelah ${maxRetry} percobaan.")
		}
	}
	private void checkCustomerHaveFixedline(String customerHaveFixedline) {
		if(customerHaveFixedline?.trim() == 'Y' && customerHaveFixedline) {
			WebUI.check(chxCustomerHaveFixedLine)
			WebUI.delay(2)
			WebUI.takeScreenshot()
		}
	}

	private void selectBuildingLocation(String buildingLocation) {
		if(buildingLocation) {
			safetySelect(drpBuildingLoc, buildingLocation)
		}
	}

	private void selectBuildingOwnerShip(String ownership) {
		if(ownership) {
			safetySelect(drpBuildingOwnership, ownership)
		}
	}
	private void clickAddAddress() {
		safetyClick(btnAdd)
		WebUI.takeScreenshot()
	}

	private void clickSaveContinue() {
		safetyClick(btnSaveContinue)
	}
	private void clickSaveAddress() {
		WebUI.scrollToElement(btnSave, 2)
		safetyClick(btnSave)
		WebUI.takeScreenshot()
		
	}
	private void clickCancel() {
		safetyClick(btnCancel)
	}
	private void inputBuildingPriceEstimates(String priceEstimates) {
		if(priceEstimates) {
			safetyInput(txfBuildingPriceEstimate, priceEstimates)
		}
	}
	private void inputBuildingStayLength(String buildingLength) {
		if(buildingLength) {
			safetyInput(txfBuildingStayLength, buildingLength)
		}
		WebUI.takeScreenshot()
	}
	private void inputDirectionDesc(String desc) {
		if(desc) {
			safetyInput(txfDirectionDesc, desc)
			WebUI.takeScreenshot()
		}
	}
	private void inputNotes(String notes) {
		if(notes) {
			safetyInput(txfNotes, notes)
			WebUI.takeScreenshot()
		}
	}
	private void inputCompanyName(String companyName) {
		safetyInputEdit(txfCompanyName, companyName)
		WebUI.takeScreenshot()
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

			safetyInput(countryField, parts[0])
			safetyInput(areaField, parts[1])
			safetyInput(numberField, parts[2])
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
			safetyInput(countryField, parts[0])
			WebUI.delay(2)
			safetyInput(areaField, parts[1])
			WebUI.delay(2)
		}
		WebUI.takeScreenshot()
	}

	private void clickCopyAddress() {
		safetyClick(btnCopyAddress)
	}
	
	private boolean checkAddressList(String addressType) {
		TestObject addressList = createTestObject("addressList", "xpath", "//span[text() = '$addressType']")
		return WebUI.verifyElementPresent(addressList, 5, FailureHandling.OPTIONAL)
	}
	
	private void clickEditAddress(String addressType) {
		TestObject btnEdit = createTestObject("btnEdit", "xpath", "//span[text() = '$addressType']/following::td[6]")
		WebUI.click(btnEdit)
		WebUI.delay(1)
		WebUI.takeScreenshot()
	}
}
