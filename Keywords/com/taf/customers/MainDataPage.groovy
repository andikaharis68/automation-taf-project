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
	private TestObject txfMobilePhone1					= createTestObject("txfMobilePhone1", "xpath", "//*[@id='txtMblPhn1']")
	private TestObject txfMobilePhone2					= createTestObject("txfMobilePhone2", "xpath", "//*[@id='txtMblPhn2']")
	private TestObject txfMobilePhone3					= createTestObject("txfMobilePhone3", "xpath", "//*[@id='txtMblPhn3']")
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
	private TestObject iframeMainData					= createTestObject("iframeMainData", "xpath", "//*[@id='custForm']")
	private TestObject lblNotif							= createTestObject("lblNotif", "xpath", "//*[@id='messageContent']")

	private void verifyLandingInMainData() {
		verifyLanding(drpSalutation, "Main Data")
	}

	private void selectSalutation(String salutation) {
		TestObject drpSalutationSelected  = createTestObject("drpSalutationSelected", "xpath", "//*[normalize-space(text())='$salutation']")
		WebUI.click(drpSalutation)
		WebUI.click(drpSalutationSelected)
	}

	private void inputPrefixName(String name) {
		if(name) {
			WebUI.setText(txfPrefixName, name)
		}
	}
	private void inputFullName(String name) {
		if(txfFullName) {
			WebUI.setText(txfFullName, name)
		}
	}

	private void selectMaritalStatus(String status) {
		WebUI.scrollToElement(drpMaritalStatus, 2)
		TestObject drpStatusSelected  = createTestObject("drpStatusSelected", "xpath", "//*[normalize-space(text())='$status']")
		WebUI.click(drpMaritalStatus)
		WebUI.click(drpStatusSelected)
	}
	private void inputSuffixName(String name) {
		if(name) {
			WebUI.setText(txfSuffixName, name)
		}
	}
	private void inputNickName(String name) {
		if(name) {
			WebUI.setText(txfNickName, name)
		}
	}

	private void checkPremiumStatus(String isPremium) {
		if(isPremium) {
			WebUI.click(chxIsPremium)
		}
	}

	private void selectNationality(String nationality) {
		TestObject drpNationalSelected  = createTestObject("drpNationalSelected", "xpath", "//*[normalize-space(text())='$nationality']")
		WebUI.scrollToElement(drpNationality, 2)
		WebUI.click(drpNationality)
		WebUI.click(drpNationalSelected)
	}
	private void selectCustomerGroup(String name, String customerGroup) {
		if(customerGroup) {
			WebUI.scrollToElement(btnSearchCustomerGroup, 2)
			WebUI.click(btnSearchCustomerGroup)
			WebUI.setText(txfOvlyCustomerName, name)
			WebUI.click(btnOvlySelect)
		}
	}

	private void inputNumberOfDependents(String numberOfDependents) {
		if(numberOfDependents) {
			WebUI.scrollToElement(txfNumOfDependent, 0)
			WebUI.setText(txfNumOfDependent, numberOfDependents)
		}
	}

	private void inputNumberOfResidence(String numberOfResidence) {
		if(numberOfResidence) {
			WebUI.scrollToElement(txfNumOfResidence, 1)
			WebUI.setText(txfNumOfResidence, numberOfResidence)
		}
	}

	private void inputFamilyCardNum(String familyCardNum) {
		if(familyCardNum) {
			WebUI.scrollToElement(txfFamilyCard, 2)
			WebUI.setText(txfFamilyCard, familyCardNum)
		}
	}

	private void selectEducation(String education) {
		TestObject drpEduSelected  = createTestObject("drpEduSelected", "xpath", "//*[normalize-space(text())='$education']")
		WebUI.scrollToElement(drpEducation, 2)
		WebUI.click(drpEducation)
		WebUI.click(drpEduSelected)
	}

	private void selectReligion(String religion) {
		TestObject drpReligionSelected  = createTestObject("drpRegSelected", "xpath", "//*[normalize-space(text())='$religion']")
		WebUI.scrollToElement(drpReligion, 2)
		WebUI.click(drpReligion)
		WebUI.click(drpReligionSelected)
	}


	private void selectCountry(String country) {
		if(country) {
			WebUI.click(btnSearchCountry)
			WebUI.setText(txfCountryName, country)
			WebUI.click(btnOvlySearchCountry)
			WebUI.click(btnSelectCountry)
		}
	}

	private void checkIsVIP(String isVIP) {
		if(isVIP) {
			WebUI.click(chxIsVIP)
		}
	}

	private void inputPremiumNote(String premiumNote) {
		if(premiumNote) {
			WebUI.setText(txfPremiumNote, premiumNote)
		}
	}

	private void inputSIDNo(String sidNo) {
		if(sidNo) {
			WebUI.setText(txfSIDNo, sidNo)
		}
	}

	private void checkAffiliationWithMultifinance(String affiliation) {
		if(affiliation) {
			WebUI.click(chxAffiliationwithMultifinance)
		}
	}
	private void checkRIP(String rip) {
		if(rip) {
			WebUI.click(chxRIP)
		}
	}

	private void inputMobilePhone1(String phone) {
		if(phone) {
			WebUI.scrollToElement(txfMobilePhone1, 1)
			WebUI.setText(txfMobilePhone1, phone)
		}
	}
	private void inputMobilePhone2(String phone) {
		if(phone) {
			WebUI.scrollToElement(txfMobilePhone2, 1)
			WebUI.setText(txfMobilePhone2, phone)
		}
	}
	private void inputMobilePhone3(String phone) {
		if(phone) {
			WebUI.scrollToElement(txfMobilePhone3, 1)
			WebUI.setText(txfMobilePhone3, phone)
		}
	}
	private void inputEmail1(String email) {
		if(email) {
			WebUI.scrollToElement(txfEmail1, 1)
			WebUI.setText(txfEmail1, email)
		}
	}

	private void inputEmail2(String email) {
		if(email) {
			WebUI.scrollToElement(txfEmail2, 1)
			WebUI.setText(txfEmail2, email)
		}
	}

	private void clickSaveAndContinue() {
		WebUI.scrollToElement(btnSaveContinue, 5)
		WebUI.click(btnSaveContinue)
	}
	private void switchToIframeMainData() {
		WebUI.verifyElementPresent(iframeMainData, 5)
		WebUI.switchToFrame(iframeMainData, 1)
	}

	private void switchToDefaultContent() {
		WebUI.switchToDefaultContent()
	}
	private void verifyNotifSuccess() {
		BaseHelper.verifyPopUpSuccess(lblNotif, "Save Success")
	}
}


