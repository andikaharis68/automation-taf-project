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

public class CompanyCustomerMainDataPage extends BaseHelper {
	private TestObject checkBoxIsNewApplication 	= createTestObject("checkBoxIsNewApplication", "xpath", "//*[@id='cbNextToNAP']")
	private TestObject cbIsAffialite 				= createTestObject("cbIsAffialite", "xpath", "//*[@id='cb_Cust_IsAffiliateWithMf']") 
	private TestObject btnEditCustomer 				= createTestObject("btnEditCustomer", "xpath", "//*[@id='gvCustomerCompany_imbEdit_0']")
	private TestObject btnMainTab 					= createTestObject("btnMainTab", "xpath", "//*[@id='lbMAIN']")
	private TestObject iframeCustForm	 			= createTestObject("iframeCustForm", "xpath", "//*[@id='custForm']")
	 

	void clickMainDataTabOrEditPage(){
		if(WebUI.verifyElementPresent(btnEditCustomer, 10, FailureHandling.OPTIONAL)) {
			WebUI.click(btnEditCustomer)
			WebUI.click(btnMainTab)
		} else if(WebUI.verifyElementPresent(btnMainTab, 10, FailureHandling.OPTIONAL)) {
			WebUI.click(btnMainTab)
		}
	}
	
	void switchToIframeCustForm() {
		WebUI.switchToFrame(iframeCustForm, 2, FailureHandling.STOP_ON_FAILURE)
	}

	void clickIsNewApplication(boolean isNewApplication) {
		if(isNewApplication) {
			WebUI.delay(0.5)
			WebUI.click(checkBoxIsNewApplication)
		}
	}

	void inputIndustryNameFromLookup(String industryType) {
		//		click icon search
		def iconLookUpIndustry = createTestObject("iconLookUpIndustry", "xpath", "//*[@id='ucLookupIndustry_uclIndustry_imb']")
		WebUI.delay(0.5)
		WebUI.click(iconLookUpIndustry)

		//		set industry type from parameter
		def txtFieldFromLookupIndustry = createTestObject("txtFieldFromLooupIndustry", "xpath", " //*[@id='ucLookupIndustry_uclIndustry_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_3']")
		WebUI.delay(0.5)
		WebUI.setText(txtFieldFromLookupIndustry, industryType)

		// click search after text filled
		def btnSearchLookUp = createTestObject("btnSearchLookUp", "xpath", "//*[@id='ucLookupIndustry_uclIndustry_umd_ctl00_ucS_lbSearch']")
		WebUI.delay(0.5)
		WebUI.click(btnSearchLookUp)
		
		//click select in first found
		def selectFirstFoundIndustryType = createTestObject("selectFirstFoundIndustryType", "xpath", "//*[@id='ucLookupIndustry_uclIndustry_umd_ctl00_gvL_hpSelect_0']")
		WebUI.delay(0.5)
		WebUI.click(selectFirstFoundIndustryType)
	}

	void inputNumberOfEmployees(String numberOfEmployees) {
		def txfNumberOfEmployees = createTestObject("txfNumberOfEmployees", "xpath", "//*[@id='ucinNumOfEmp_txtInput']")
		WebUI.delay(0.5)
		WebUI.setText(txfNumberOfEmployees, numberOfEmployees)
	}

	void inputEstablishmentDate(String establishmentDate) {
		def txfEstablishmentDate = createTestObject("txfEstablishmentDate", "xpath", "//*[@id='ucDPEstablishmentDate_txtDatePicker']")
		WebUI.delay(0.5)
		WebUI.setText(txfEstablishmentDate, establishmentDate)
	}

	void clickCheckBoxIsPremium(boolean isPremium, String premiunNote) {
		if(isPremium) {
			def cbIsPremium = createTestObject("cbIsPremium", "xpath", "//*[@id='cbIsPremium']")
			WebUI.delay(0.5)
			WebUI.check(cbIsPremium)

			def txfPremiumNote = createTestObject("txfPremiumNote", "xpath", "//*[@id='txtPremiumNote']")
			WebUI.delay(0.5)
			WebUI.setText(txfPremiumNote, premiunNote)
		}
	}

	void clickCheckBoxIsAffiliate(boolean isAffiliate) {
		if(isAffiliate) {
			WebUI.delay(0.5)
			WebUI.check(cbIsAffialite)
		}
	}

	void clickCheckBoxIsVIP(boolean isVIP) {
		if(isVIP) {
			def cbIsVIP = createTestObject("cbIsVIP", "xpath", "//*[@id='cbIsVip']")
			WebUI.delay(0.5)
			WebUI.check(cbIsVIP)
		}
	}

	void inputCustomerSidNo(String sidNo) {
		def txfCustomerSidNo = createTestObject("txfCustomerSidNo", "xpath", "//*[@id='txt_Cust_SidNo']")
		WebUI.delay(0.5)
		WebUI.setText(txfCustomerSidNo, sidNo)
	}

	void inputCustomerGroupThenSelectedFirstFound(String customerGroup) {
		//		click icon search
		def iconLookUpCustomerGroup = createTestObject("iconLookUpCustomerGroup", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_imb']")
		WebUI.delay(0.5)
		WebUI.click(iconLookUpCustomerGroup)

		// set text from test data
		def txtFieldFromCustomerGroup = createTestObject("txtFieldFromCustomerGroup", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
		WebUI.delay(0.5)
		WebUI.setText(txtFieldFromCustomerGroup, customerGroup)
		
		//need hardcode the customer type for Company
		def optionCustomerType = createTestObject("optionCustomerType", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_umd_ctl00_ucS_rptFixedSearch_ucReference_1_ddlReference_1']")
		WebUI.selectOptionByLabel(optionCustomerType, "Company", false)

		// click search customer group
		def searchCustomerGroup = createTestObject("searchCustomerGroup", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_umd_ctl00_ucS_lbSearch']")
		WebUI.delay(0.5)
		WebUI.click(searchCustomerGroup)

		// click select in first found
		def selectFirstFoundCustomerGroup = createTestObject("selectFirstFoundCustomerGroup", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_umd_ctl00_gvL_hpSelect_0']")
		WebUI.delay(0.5)
		WebUI.click(selectFirstFoundCustomerGroup)
	}

	void saveContentAfterMainDataIsFilled() {
		WebUI.delay(0.5)
		def btnSaveCustMainData = createTestObject("btnSaveCustMainData", "xpath", "//*[@id='lb_Form_SaveCont_CustMainData']")
		WebUI.click(btnSaveCustMainData)
	}
}
