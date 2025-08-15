package com.taf.customers

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
	private TestObject txfPhone1				= createTestObject("txfPhone1", "xpath", "//*[@id='ucAddr_txtPhoneExt1']")
	private TestObject txfPhone2				= createTestObject("txfPhone2", "xpath", "//*[@id='ucAddr_txtPhoneExt2']")
	private TestObject txfPhone3				= createTestObject("txfPhone3", "xpath", "//*[@id='ucAddr_txtPhoneExt3']")
	private TestObject txfFax 					= createTestObject("txfFax", "xpath", "//*[@id='ucAddr_txtFax']")

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
	private TestObject btnSave					= createTestObject("btnSave", "xpath", "//*[@id='lbl_Toolbar_Save']")
	private TestObject btnCancel				= createTestObject("btnCancel", "xpath", "//*[@id='lb_Toolbar_Cancel']")
	private TestObject iframeAddress			= createTestObject("iframeAddress", "xpath", "//*[@id='custForm']")
	private TestObject btnCopyAddress			= createTestObject("btnCopyAddress", "xpath", "")
	private TestObject btnSaveAddress			= createTestObject("btnSaveAddress", "xpath", "//*[@id='lb_Form_Save_AddCust']")



	private void verifyLandingInAddressSection() {
		verifyLanding(btnAdd, "Address Section")
	}

	private void selectAddressType(String addressType) {
		TestObject drpAddressSelected  = createTestObject("drpAddressSelected", "xpath", "//*[normalize-space(text())='$addressType']")
		WebUI.click(drpAddressType)
		WebUI.click(drpAddressSelected)
	}

	private Map getAddressDetail(String scenarioId, String addressType, String filePath, String sheetName) {
		Map dataRow = BaseHelper.getTestDataByScenarioAndAddressType(sheetName, filePath, scenarioId, addressType)
		KeywordUtil.logInfo("data " + dataRow)
	}
	private void inputRT(String rt) {
		WebUI.setText(txfRT, rt)
	}

	private void inputRW(String rw) {
		WebUI.setText(txfRW, rw)
	}
	private void searchAddress(String city) {
		WebUI.click(btnSearchZIPCode)
		WebUI.setText(txfOvlyCity, city)
		WebUI.click(btnOvlySearch)
		WebUI.click(btnOvlySelect) //select first address
	}

	private void checkCustomerHaveFixedline(String customerHaveFixedline) {
		if(customerHaveFixedline != "") {
			WebUI.click(chxCustomerHaveFixedLine)
		}
	}

	private void inputPhoneNumber1(String phoneNumber) {
		if(phoneNumber != "") {
			WebUI.setText(txfPhone1, phoneNumber)
		}
	}

	private void inputPhoneNumber2(String phoneNumber) {
		if(phoneNumber != "") {
			WebUI.setText(txfPhone2, phoneNumber)
		}
	}
	private void inputPhoneNumber3(String phoneNumber) {
		if(phoneNumber != "") {
			WebUI.setText(txfPhone3, phoneNumber)
		}
	}
	private void inputFax(String fax) {
		if(fax != "") {
			WebUI.setText(txfFax, fax)
		}
	}

	private void selectBuildingLocation(String buildingLocation) {
		TestObject drpBuildingSelected  = createTestObject("drpBuildingSelected", "xpath", "//*[normalize-space(text())='$buildingLocation']")
		WebUI.click(drpBuildingLoc)
		WebUI.click(drpBuildingSelected)
	}

	private void selectBuildingOwnerShip(String ownership) {
		TestObject drpOwnershipSelected  = createTestObject("drpOwnershipSelected", "xpath", "//*[normalize-space(text())='$ownership']")
		WebUI.click(drpBuildingOwnership)
		WebUI.click(drpOwnershipSelected)
	}
	private void clickAddAddress() {
		WebUI.click(btnAdd)
	}

	private void clickSaveContinue() {
		WebUI.click(btnSaveContinue)
	}
	private void clickSaveAddress() {
		WebUI.click(btnSave)
	}
	private void clickCancel() {
		WebUI.click(btnCancel)
	}
	private void inputBuildingPriceEstimates(String priceEstimates) {
		WebUI.setText(txfBuildingPriceEstimate, priceEstimates)
	}
	private void inputBuildingStayLength(String buildingLength) {
		WebUI.setText(txfBuildingStayLength, buildingLength)
	}
	private void inputDirectionDesc(String desc) {
		WebUI.setText(txfDirectionDesc, desc)
	}
	private void inputNotes(String notes) {
		WebUI.setText(txfNotes, notes)
	}
	private void inputCompanyName(String companyName) {
		WebUI.setText(txfCompanyName, companyName)
	}
	private void switchToIframeAddress() {
		WebUI.verifyElementPresent(iframeAddress, 5)
		WebUI.switchToFrame(iframeAddress, 1)
	}
}
