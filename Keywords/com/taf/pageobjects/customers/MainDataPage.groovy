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

public class MainDataPage extends BaseHelper {

	//Personal Customer Description section
	private TestObject txtCustomerNo					= createTestObject("txtCustomerNo", "xpath", "//*[@id='lblCustNo']")
	private TestObject txtCustomerName					= createTestObject("txtCustomerName", "xpath", "//*[@id='lblCustName']")
	private TestObject txtGender						= createTestObject("txtGender", "xpath", "//*[@id='dCustPersonalMainInfo']/table/tbody/tr[3]/td[2]")
	private TestObject chxNextToApplication				= createTestObject("chxNextToApplication", "xpath", "//*[@id='cbNextToNAP']")
	private TestObject txtNPWP							= createTestObject("txtNPWP", "xpath", "//*[@id='lblNpwp']")
	private TestObject txtIDNo							= createTestObject("txtIDNo", "xpath", "//*[@id='lblIdNo']")
	private TestObject txtBirthPlace					= createTestObject("txtBirthPlace", "xpath", "//*[@id='lblBirthPlace']")
	private TestObject txtBirthDate						= createTestObject("txtBirthDate", "xpath", "//*[@id='lblBirthDt']")

	//customer main data section
	private TestObject drpSalutation					= createTestObject("drpSalutation", "xpath", "//*[@id='ucMrSalutation_ddlReference']") //
	private TestObject txfPrefixName					= createTestObject("txfPrefixName", "xpath", "//*[@id='txtPrefixName']")
	private TestObject txfFullName						= createTestObject("txfFullName", "xpath", "//*[@id='txtFullName']")
	private TestObject txfSuffixName					= createTestObject("txfSuffixName", "xpath", "//*[@id='txtSuffixName']")
	private TestObject txfNickName						= createTestObject("txfNickName", "xpath", "//*[@id='txtNickName']")
	private TestObject chxIsPremium						= createTestObject("chxIsPremium", "xpath", "//*[@id='cbIsPremium']")
	private TestObject drpMaritalStatus					= createTestObject("drpMaritalStatus", "xpath", "//*[@id='ucMrMaritalStat_ddlReference']")
	private TestObject txfCustomerGroup					= createTestObject("txfCustomerGroup", "xpath", "//*[@id='ucCustGroup_uclCust_txt']")
	private TestObject btnSearchCustomerGroup			= createTestObject("btnSearchCustomerGroup", "xpath", "//*[@id='ucCustGroup_uclCust_imb']")
	private TestObject txfNumOfDependent				= createTestObject("txfNumOfDependent", "xpath", "//*[@id='ucNoDependents_txtInput']")
	private TestObject txfNumOfResidence				= createTestObject("txfNumOfResidence", "xpath", "//*[@id='ucNoResidence_txtInput']")
	private TestObject txfFamilyCard					= createTestObject("txfFamilyCard", "xpath", "//*[@id='txtFamilyCardNo']")
	private TestObject drpNationality					= createTestObject("drpNationality", "xpath", "//*[@id='ucMrNationality_ddlReference']")
	private TestObject txfCountry						= createTestObject("txfCountry", "xpath", "//*[@id='ucCountry_uclCountry_txt']")
	private TestObject btnSearchCountry					= createTestObject("btnSearchCountry", "xpath", "//*[@id='ucCountry_uclCountry_imb']")
	private TestObject drpEducation						= createTestObject("drpEducation", "xpath", "//*[@id='ucMrEducation_ddlReference']")
	private TestObject drpReligion						= createTestObject("drpReligion", "xpath", "//*[@id='ucMrReligion_ddlReference']")
	private TestObject chxIsVIP							= createTestObject("chxIsVIP", "xpath", "//*[@id='cbIsVip']")
	private TestObject txfPremiumNote					= createTestObject("txfPremiumNote", "xpath", "//*[@id='txtPremiumNote']")
	private TestObject txfSIDNo							= createTestObject("txfSIDNo", "xpath", "//*[@id='txtSidNo']")
	private TestObject chxAffiliationwithMultifinance	= createTestObject("chxAffiliationwithMultifinance", "xpath", "//*[@id='cbIsAffiliateMF']")
	private TestObject chxRIP							= createTestObject("chxRIP", "xpath", "//*[@id='cbIsRIP']")

	//contact information section
	private TestObject txfEmail1						= createTestObject("txfEmail1", "xpath", "//*[@id='txtEmail1']")
	private TestObject txfEmail2						= createTestObject("txfEmail2", "xpath", "//*[@id='txtEmail2']")

	private TestObject btnSaveContinue					= createTestObject("btnSaveContinue", "xpath", "//*[@id='lb_Form_SaveCont_MainData']")
	private TestObject btnSave							= createTestObject("btnSave", "xpath", "//*[@id='lbl_Toolbar_Save']]")
	private TestObject btnCancel						= createTestObject("btnCancel", "xpath", "//*[@id='lb_Toolbar_Cancel']")

	//overlay
	private TestObject txfOvlyCustomerName				= createTestObject("txfOvlyCustomerName", "xpath", "//*[@id='ucCustGroup_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
	private TestObject drpOvlyCustomerType				= createTestObject("drpOvlyCustomerType", "xpath", "//*[@id='ucCustGroup_uclCust_umd_ctl00_ucS_rptFixedSearch_ucReference_1_ddlReference_1']")
	private TestObject txfOvlyAddress					= createTestObject("txfOvlyAddress", "xpath", "//*[@id='ucCustGroup_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_2']")
	private TestObject btnOvlySearchCustGroup			= createTestObject("btnOvlySearchCustGroup", "xpath", "//*[@id='ucCustGroup_uclCust_umd_ctl00_ucS_lbSearch']") //
	private TestObject btnOvlyResetCustGroup			= createTestObject("btnOvlyResetCustGroup", "xpath", "//*[@id='ucCustGroup_uclCust_umd_ctl00_ucS_lbReset']")
	private TestObject btnOvlySelect					= createTestObject("btnOvlySelect", "xpath", "//*[@id='ucCustGroup_uclCust_umd_ctl00_gvL_hpSelect_0']")

	private TestObject txfCountryCode					= createTestObject("txfCountryCode", "xpath", "//*[@id='ucCountry_uclCountry_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
	private TestObject txfCountryName					= createTestObject("txfCountryName", "xpath", "//*[@id='ucCountry_uclCountry_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1']")
	private TestObject btnOvlySearchCountry				= createTestObject("btnOvlySearchCountry", "xpath", "//*[@id='ucCountry_uclCountry_umd_ctl00_ucS_lbSearch']")
	private TestObject btnOvlyResetCountry				= createTestObject("btnOvlyResetCountry", "xpath", "//*[@id='ucCountry_uclCountry_umd_ctl00_ucS_lbReset']")
	private TestObject btnSelectCountry					= createTestObject("btnSelectCountry", "xpath", "//*[@id='ucCountry_uclCountry_umd_ctl00_gvL_hpSelect_0']")
	private TestObject iframeCustForm					= createTestObject("iframeCustForm", "xpath", "//*[@id='custForm']")

	private TestObject lblNewCustomer					= createTestObject("lblNewCustomer", "xpath", "//*[@id='lb_Form_NewCustomer']")
	private TestObject btnEdit							= createTestObject("btnEdit", "xpath", "//*[@id='gvCustomerPersonal_imbEdit_0']")

	private void verifyLandingInMainData() {
		verifyLanding(drpSalutation, "Main Data")
		WebUI.takeScreenshot()
	}

	private void selectSalutation(String salutation) {
		safetySelect(drpSalutation, salutation)
	}

	private void inputPrefixName(String name) {
		if(name) {
			safetyInput(txfPrefixName, name)
		}
	}
	private void inputFullName(String name) {
		if(txfFullName) {
			safetyInput(txfFullName, name)
		}
	}

	private void selectMaritalStatus(String status) {
		WebUI.scrollToElement(drpMaritalStatus, 2)
		safetySelect(drpMaritalStatus, status)
	}
	private void inputSuffixName(String name) {
		if(name) {
			safetyInput(txfSuffixName, name)
			WebUI.delay(2)
		}
	}
	private void inputNickName(String name) {
		if(name) {
			safetyInput(txfNickName, name)
			WebUI.delay(2)
		}
	}

	private void checkPremiumStatus(String isPremium) {
		if(isPremium?.trim() == 'Y') {
			WebUI.check(chxIsPremium)
			WebUI.delay(2)
		}
	}

	private void selectNationality(String nationality) {
		WebUI.scrollToElement(drpNationality, 2)
		safetySelect(drpNationality, nationality)
	}
	private void selectCustomerGroup(String name, String customerGroup) {
		if(customerGroup) {
			WebUI.scrollToElement(btnSearchCustomerGroup, 2)
			safetyClick(btnSearchCustomerGroup)
			WebUI.delay(2)
			safetyInput(txfOvlyCustomerName, name)
			safetyClick(btnOvlySelect)
			WebUI.delay(2)
		}
	}

	private void inputNumberOfDependents(String numberOfDependents) {
		if(numberOfDependents) {
			WebUI.scrollToElement(txfNumOfDependent, 1)
			safetyInput(txfNumOfDependent, numberOfDependents)
			WebUI.delay(2)
		}
	}

	private void inputNumberOfResidence(String numberOfResidence) {
		if(numberOfResidence) {
			WebUI.scrollToElement(txfNumOfResidence, 1)
			safetyInput(txfNumOfResidence, numberOfResidence)
			WebUI.delay(2)
		}
	}

	private void inputFamilyCardNum(String familyCardNum) {
		if(familyCardNum) {
			WebUI.scrollToElement(txfFamilyCard, 2)
			safetyInput(txfFamilyCard, familyCardNum)
			WebUI.delay(2)
		}
	}

	private void selectEducation(String education) {
		WebUI.scrollToElement(drpEducation, 2)
		safetySelect(drpEducation, education)
	}

	private void selectReligion(String religion) {
		WebUI.scrollToElement(drpReligion, 2)
		safetySelect(drpReligion, religion)
	}


	private void selectCountry(String country) {
		if(country) {
			safetyClick(btnSearchCountry)
			
			safetyInput(txfCountryName, country)
			
			safetyClick(btnOvlySearchCountry)
			
			safetyClick(btnSelectCountry)
		}
	}

	private void checkIsVIP(String isVIP) {
		if(isVIP?.trim() == 'Y') {
			safetyClick(chxIsVIP)
		}
	}

	private void inputPremiumNote(String premiumNote) {
		if(premiumNote) {
			safetyInput(txfPremiumNote, premiumNote)
		}
	}

	private void inputSIDNo(String sidNo) {
		if(sidNo) {
			safetyInput(txfSIDNo, sidNo)
		}
	}

	private void checkAffiliationWithMultifinance(String affiliation) {
		if(affiliation?.trim() == 'Y') {
			safetyClick(chxAffiliationwithMultifinance)
		}
	}
	private void checkRIP(String rip) {
		if(rip?.trim() == 'Y') {
			safetyClick(chxRIP)
			WebUI.takeScreenshot()
		}
	}

	private TestObject getMobilePhoneField(int index) {
		TestObject dynamicObject = createTestObject("dynamicObject", "xpath", "//*[@id='txtMblPhn${index}']")
		return dynamicObject
	}

	private TestObject getEmailField(int index) {
		TestObject dynamicObject = createTestObject("dynamicObject", "xpath", "//*[@id='txtEmail${index}']")
		return dynamicObject
	}
	private void inputMobilePhone(int index, String phone) {
		if (phone?.trim()) {
			TestObject phoneField = getMobilePhoneField(index)
			WebUI.scrollToElement(phoneField, 1)
			safetyInput(phoneField, phone)
		}
	}

	private void inputEmail(int index, String email) {
		if(email?.trim()) {
			TestObject emailField = getEmailField(index)
			WebUI.scrollToElement(emailField, 1)
			safetyInput(emailField, email)
			WebUI.takeScreenshot()
		}
	}
	private void clickSaveAndContinue() {
		WebUI.scrollToElement(btnSaveContinue, 5)
		safetyClick(btnSaveContinue)
		WebUI.takeScreenshot()
	}
	private void switchToIframeCustForm() {
		WebUI.verifyElementPresent(iframeCustForm, 5)
		WebUI.switchToFrame(iframeCustForm, 1)
	}

	private void switchToDefaultContent() {
		WebUI.switchToDefaultContent()
	}
	private void verifyNotifSuccess() {
		TestObject lblNotif = createTestObject("lblNotif", "xpath", "//*[text()='Save Success']")
		BaseHelper.verifyPopUpSuccess(lblNotif, "Save Success")
		Mobile.delay(5)
	}
	private void clickBtnEditOrNewApp() {
		Mobile.delay(5)
		if(WebUI.verifyElementPresent(lblNewCustomer, 2, FailureHandling.OPTIONAL)) {
			switchToIframeMainPage()
			safetyClick(lblNewCustomer)
		} else if(WebUI.verifyElementPresent(btnEdit, 2, FailureHandling.OPTIONAL)) {
			switchToIframeMainPage()
			safetyClick(btnEdit)
		} else {
			KeywordUtil.logInfo("skipped")
		}
	}

	private void switchToIframeMainPage() {
		switchToDefaultContent()
		TestObject iframeMainPage = createTestObject("iframeMainPage", "xpath", "//*[@id='mainPage']")
		WebUI.verifyElementPresent(iframeMainPage, 5)
		WebUI.switchToFrame(iframeMainPage, 1)
	}
}


