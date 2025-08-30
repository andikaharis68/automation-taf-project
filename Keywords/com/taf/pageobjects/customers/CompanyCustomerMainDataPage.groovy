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

public class CompanyCustomerMainDataPage extends BaseHelper {
	
	private TestObject btnSaveCustMainData 					= createTestObject("btnSaveCustMainData", "xpath", "//*[@id='lb_Form_SaveCont_CustMainData']")
	
	private TestObject btnOvlySelectCustGroup 				= createTestObject("btnOvlySelectCustGroup", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_umd_ctl00_gvL_hpSelect_0']")
	private TestObject btnOvlySearchCustGroup				= createTestObject("btnOvlySearchCustGroup", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_umd_ctl00_ucS_lbSearch']") //
	private TestObject drpOvlyCustomerType 					= createTestObject("drpOvlyCustomerType", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_umd_ctl00_ucS_rptFixedSearch_ucReference_1_ddlReference_1']")
	private TestObject txfOvlyCustomerGroup 				= createTestObject("txfOvlyCustomerGroup", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")

	private TestObject iconLookUpCustomerGroup 				= createTestObject("iconLookUpCustomerGroup", "xpath", "//*[@id='ucLookupCustGroupId_uclCust_imb']")
	private TestObject txfCustomerSidNo 					= createTestObject("txfCustomerSidNo", "xpath", "//*[@id='txt_Cust_SidNo']")
	private TestObject cbIsVIP 								= createTestObject("cbIsVIP", "xpath", "//*[@id='cbIsVip']")
	private TestObject txfPremiumNote 						= createTestObject("txfPremiumNote", "xpath", "//*[@id='txtPremiumNote']")
	private TestObject cbIsPremium							= createTestObject("cbIsPremium", "xpath", "//*[@id='cbIsPremium']")
	private TestObject txfEstablishmentDate 				= createTestObject("txfEstablishmentDate", "xpath", "//*[@id='ucDPEstablishmentDate_txtDatePicker']")
	private TestObject txfNumberOfEmployees 				= createTestObject("txfNumberOfEmployees", "xpath", "//*[@id='ucinNumOfEmp_txtInput']")
	private TestObject selectFirstFoundIndustryType 		= createTestObject("selectFirstFoundIndustryType", "xpath", "//*[@id='ucLookupIndustry_uclIndustry_umd_ctl00_gvL_hpSelect_0']")
	private TestObject btnSearchLookUp 						= createTestObject("btnSearchLookUp", "xpath", "//*[@id='ucLookupIndustry_uclIndustry_umd_ctl00_ucS_lbSearch']")
	private TestObject txtFieldFromLookupIndustry 			= createTestObject("txtFieldFromLooupIndustry", "xpath", " //*[@id='ucLookupIndustry_uclIndustry_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_3']")
	private TestObject iconLookUpIndustry					= createTestObject("iconLookUpIndustry", "xpath", "//*[@id='ucLookupIndustry_uclIndustry_imb']")
	private TestObject checkBoxIsNewApplication     		= createTestObject("checkBoxIsNewApplication", "xpath", "//*[@id='cbNextToNAP']")
	private TestObject cbIsAffialite 						= createTestObject("cbIsAffialite", "xpath", "//*[@id='cb_Cust_IsAffiliateWithMf']")
	private TestObject btnEditCustomer 						= createTestObject("btnEditCustomer", "xpath", "//*[@id='gvCustomerCompany_imbEdit_0']")
	private TestObject btnMainTab 							= createTestObject("btnMainTab", "xpath", "//*[@id='lbMAIN']")
	private TestObject iframeCustForm	 					= createTestObject("iframeCustForm", "xpath", "//*[@id='custForm']")
	private TestObject iframeMainPage	 					= createTestObject("iframeMainPage", "xpath", "//*[@id='mainPage']")
	
    private TestObject txtCustomerNo                        = createTestObject("txtCustomerNo", "id", "lblCustCoyNo")
	
	private void verifyLandingInMainPage() {
		verifyLanding(iconLookUpCustomerGroup, "Company Customer Main Data")
	}

	private void switchToDefaultContent() {
		WebUI.switchToDefaultContent()
	}
	
	private void switchToMainPage() {
		WebUI.switchToFrame(iframeMainPage, 2)
	}
	
	private void switchToIframeCustForm() {
		WebUI.switchToFrame(iframeCustForm, 2, FailureHandling.STOP_ON_FAILURE)
	}

	private void clickIsNewApplication(String isNewApplication) {
		if(isNewApplication) {			
			if(isNewApplication?.trim() == 'Y') {
				safetyClick(checkBoxIsNewApplication)
			}
		}
	}

	private void inputIndustryNameFromLookup(String industryType) {
		if(industryType) {
			safetyClick(iconLookUpIndustry)
	
			//		set industry type from parameter
			safetyInput(txtFieldFromLookupIndustry, industryType)
	
			// click search after text filled
			safetyClick(btnSearchLookUp)
	
			//click select in first found
			safetyClick(selectFirstFoundIndustryType)
		}
	}

	private void inputNumberOfEmployees(String numberOfEmployees) {
		if(numberOfEmployees) {
			manualClearText(txfNumberOfEmployees)
			safetyInput(txfNumberOfEmployees, numberOfEmployees)
		}
	}

	private void inputEstablishmentDate(String establishmentDate) {
		if(establishmentDate) {
			safetyInput(txfEstablishmentDate, establishmentDate)
		}
	}

	private void clickCheckBoxIsPremium(String isPremium, String premiumNote) {
		if(isPremium) {			
			if(isPremium?.trim() == 'Y') {
				WebUI.check(cbIsPremium)
				safetyInput(txfPremiumNote, premiumNote)
			}
		}
	}

	private void clickCheckBoxIsAffiliate(String isAffiliate) {
		if(isAffiliate) {			
			if(isAffiliate?.trim() == 'Y') {
				WebUI.check(cbIsAffialite)
			}
		}
	}

	private void clickCheckBoxIsVIP(String isVIP) {
		if(isVIP) {			
			if(isVIP.trim() == 'Y') {
				WebUI.check(cbIsVIP)
			}
		}
	}

	void inputCustomerSidNo(String sidNo) {
		if(sidNo) {
			safetyInput(txfCustomerSidNo, sidNo)
		}
	}

	private void inputCustomerGroupThenSelectedFirstFound(String customerGroup) {
		if(customerGroup) {
			//		click icon search
			safetyClick(iconLookUpCustomerGroup)
	
			// set text from test data
			safetyInput(txfOvlyCustomerGroup, customerGroup)
	
			//need hard code the customer type for Company
			safetySelect(drpOvlyCustomerType, "Company")
	
			// click search customer group
			safetyClick(btnOvlySearchCustGroup)
	
			// click select in first found
			safetyClick(btnOvlySelectCustGroup)
		}
		WebUI.takeScreenshot()
	}

	private void saveContentAfterMainDataIsFilled() {
		safetyClick(btnSaveCustMainData)
	}
	
	private String getApplicationNo() {
		String appNo = WebUI.getText(txtCustomerNo)
		return appNo
	}
}
