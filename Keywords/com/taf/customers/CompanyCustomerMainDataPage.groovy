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
	private TestObject btnSaveCustMainData 				= createTestObject("btnSaveCustMainData", "xpath", "//*[@id='lb_Form_SaveCont_CustMainData']")
	private TestObject selectFirstFoundCustomerGroup 		= createTestObject("selectFirstFoundCustomerGroup", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_umd_ctl00_gvL_hpSelect_0']")
	private TestObject searchCustomerGroup				    = createTestObject("searchCustomerGroup", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_umd_ctl00_ucS_lbSearch']")
	private TestObject optionCustomerType 					= createTestObject("optionCustomerType", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_umd_ctl00_ucS_rptFixedSearch_ucReference_1_ddlReference_1']")
	private TestObject txtFieldFromCustomerGroup 			= createTestObject("txtFieldFromCustomerGroup", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
	private TestObject iconLookUpCustomerGroup 			= createTestObject("iconLookUpCustomerGroup", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_imb']")
	private TestObject txfCustomerSidNo 					= createTestObject("txfCustomerSidNo", "xpath", "//*[@id='txt_Cust_SidNo']")
	private TestObject cbIsVIP 							= createTestObject("cbIsVIP", "xpath", "//*[@id='cbIsVip']")
	private TestObject txfPremiumNote 						= createTestObject("txfPremiumNote", "xpath", "//*[@id='txtPremiumNote']")
	private TestObject cbIsPremium							= createTestObject("cbIsPremium", "xpath", "//*[@id='cbIsPremium']")
	private TestObject txfEstablishmentDate 				= createTestObject("txfEstablishmentDate", "xpath", "//*[@id='ucDPEstablishmentDate_txtDatePicker']")
	private TestObject txfNumberOfEmployees 				= createTestObject("txfNumberOfEmployees", "xpath", "//*[@id='ucinNumOfEmp_txtInput']")
	private TestObject selectFirstFoundIndustryType 		= createTestObject("selectFirstFoundIndustryType", "xpath", "//*[@id='ucLookupIndustry_uclIndustry_umd_ctl00_gvL_hpSelect_0']")
	private TestObject btnSearchLookUp 					= createTestObject("btnSearchLookUp", "xpath", "//*[@id='ucLookupIndustry_uclIndustry_umd_ctl00_ucS_lbSearch']")
	private TestObject txtFieldFromLookupIndustry 			= createTestObject("txtFieldFromLooupIndustry", "xpath", " //*[@id='ucLookupIndustry_uclIndustry_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_3']")
	private TestObject iconLookUpIndustry					= createTestObject("iconLookUpIndustry", "xpath", "//*[@id='ucLookupIndustry_uclIndustry_imb']")
	private TestObject checkBoxIsNewApplication     = createTestObject("checkBoxIsNewApplication", "xpath", "//*[@id='cbNextToNAP']")
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
		WebUI.delay(0.5)
		WebUI.click(iconLookUpIndustry)

		//		set industry type from parameter
		WebUI.delay(0.5)
		WebUI.setText(txtFieldFromLookupIndustry, industryType)

		// click search after text filled
		WebUI.delay(0.5)
		WebUI.click(btnSearchLookUp)

		//click select in first found
		WebUI.delay(0.5)
		WebUI.click(selectFirstFoundIndustryType)
	}

	void inputNumberOfEmployees(String numberOfEmployees) {
		WebUI.delay(0.5)
		WebUI.setText(txfNumberOfEmployees, numberOfEmployees)
	}

	void inputEstablishmentDate(String establishmentDate) {
		WebUI.delay(0.5)
		WebUI.setText(txfEstablishmentDate, establishmentDate)
	}

	void clickCheckBoxIsPremium(boolean isPremium, String premiunNote) {
		if(isPremium) {
			WebUI.delay(0.5)
			WebUI.check(cbIsPremium)

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
			WebUI.delay(0.5)
			WebUI.check(cbIsVIP)
		}
	}

	void inputCustomerSidNo(String sidNo) {
		WebUI.delay(0.5)
		WebUI.setText(txfCustomerSidNo, sidNo)
	}

	void inputCustomerGroupThenSelectedFirstFound(String customerGroup) {
		//		click icon search
		WebUI.delay(0.5)
		WebUI.click(iconLookUpCustomerGroup)

		// set text from test data
		WebUI.delay(0.5)
		WebUI.setText(txtFieldFromCustomerGroup, customerGroup)

		//need hard code the customer type for Company
		WebUI.selectOptionByLabel(optionCustomerType, "Company", false)

		// click search customer group
		WebUI.delay(0.5)
		WebUI.click(searchCustomerGroup)

		// click select in first found
		WebUI.delay(0.5)
		WebUI.click(selectFirstFoundCustomerGroup)
	}

	void saveContentAfterMainDataIsFilled() {
		WebUI.delay(0.5)
		WebUI.click(btnSaveCustMainData)
	}
}
