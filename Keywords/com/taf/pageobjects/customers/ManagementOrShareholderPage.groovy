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

public class ManagementOrShareholderPage extends BaseHelper {

	private TestObject btnAddPersonal		= createTestObject("btnAddPersonal", "xpath", "//*[@id='lb_Form_AddPersonal_Management']")
	private TestObject btnAddCompany		= createTestObject("btnAddCompany", "xpath", "//*[@id='lb_Form_AddCompany_Management']")
	private TestObject btnContinue			= createTestObject("btnContinue", "xpath", "//*[@id='lb_Form_Continue_Management']")
	private TestObject btnSearchNamePersonal= createTestObject("btnSearchFullName", "xpath", "//*[@id='ucCustMainDataPersonal_ucLookupCust_uclCust_imb']")
	private TestObject btnSearchNameCompany	= createTestObject("btnSearchNameCompany", "xpath", "//*[@id='ucCustMainDataCoy_ucLookupCust_uclCust_imb']")

	private TestObject drpIdType			= createTestObject("drpIdType", "xpath", "//*[@id='ucCustMainDataPersonal_UCRefPersonalIdType_ddlReference']")
	private TestObject txfIdNo				= createTestObject("txfIdNo", "xpath", "//*[@id='ucCustMainDataPersonal_txt_CustPersonal_IdNo']")
	private TestObject txfIdExpiredDate		= createTestObject("txfIdExpiredDate", "xpath", "//*[@id='ucCustMainDataPersonal_ucDatePickerIDExpiredDate_txtDatePicker']")
	private TestObject txfPOB				= createTestObject("txfPOB", "xpath", "//*[@id='ucCustMainDataPersonal_txt_CustPersonal_BirthPlace']")
	private TestObject txfDOB				= createTestObject("txfDOB", "xpath", "//*[@id='ucCustMainDataPersonal_ucDPBirthDate_txtDatePicker']")
	private TestObject txfNPWPPersonal		= createTestObject("txfNPWPPersonal", "xpath", "//*[@id='ucCustMainDataPersonal_txt_Cust_Npwp']")
	private TestObject txfNPWPCompany		= createTestObject("txfNPWPPersonal", "xpath", "//*[@id='ucCustMainDataCoy_txt_Cust_Npwp']]")
	private TestObject drpJobPosition		= createTestObject("drpJobPosition", "xpath", "//*[@id='UCRefPersonalJobPosition_ddlReference']")
	private TestObject txfSharePercentage	= createTestObject("txfSharePercentage", "xpath", "//*[@id='ucINSharePercentagePersonal_txtInput']")
	private TestObject btnNextPersonal		= createTestObject("btnNextPersonal", "xpath", "//*[@id='lb_Form_Next_AddPersonalManShareListing']")
	private TestObject btnNextCompany		= createTestObject("btnNextCompany", "xpath", "//*[@id='lb_Form_Next_AddCoyManShareListing']")

	private TestObject btnCancelPersonal	= createTestObject("btnCancelPersonal", "xpath", "//*[@id='lb_Form_Cancel_AddPersonalManShareListing']")
	private TestObject btnCancelConmpany	= createTestObject("btnCancelCompany", "xpath", "//*[@id='lb_Form_Cancel_AddCoyManShareListing']")

	//overlay
	private TestObject txfOvlyCustomerName	= createTestObject("txfOvlyCustomerName", "xpath", "//*[@id='ucCustMainDataPersonal_ucLookupCust_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
	private TestObject btnOvlySearch		= createTestObject("btnOvlySearch", "xpath", "//*[@id='ucCustMainDataPersonal_ucLookupCust_uclCust_umd_ctl00_ucS_lbSearch']")
	private TestObject btnOvlySelect		= createTestObject("btnOvlySelect", "xpath", "//*[@id='ucCustMainDataPersonal_ucLookupCust_uclCust_umd_ctl00_gvL_hpSelect_0']")

	private TestObject drpCompanyType		= createTestObject("drpCompanyType", "xpath", "//*[@id='ucCustMainDataCoy_UCRefCoyType_ddlReference']")
	private TestObject txfNITku				= createTestObject("txfNITku", "xpath", "//*[@id='ucCustMainDataCoy_txt_CustCoy_Nitku']")
	private TestObject cbIsActive			= createTestObject("cbIsActive", "xpath", "//*[@id='cbIsActive']")
	private TestObject cbIsOwner			= createTestObject("cbIsOwner", "xpath", "//*[@id='cbIsOwner']")
	private TestObject btnSavePersonal		= createTestObject("btnSavePersonal", "xpath", "//*[@id='lb_Form_Save_AddPersonalManShareListing']")
	private TestObject btnSaveCompany		= createTestObject("btnSaveCompany", "xpath", "//*[@id='lb_Form_Next_AddCoyManShareListing']")
	

	private void verifyLandinginManagementPage() {
		verifyLanding(btnAddCompany, "Management or shareholder")
		WebUI.takeScreenshot()
	}
	private void clickAddPersonal() {
		safetyClick(btnAddPersonal)
	}

	private void clickAddCompany() {
		safetyClick(btnAddCompany)
	}

	private void clickNextCompany() {
		safetyClick(btnNextCompany)
	}
	private void clickCancelCompany() {
		safetyClick(btnCancelConmpany)
	}

	private void searchCustomerName(String name) {
		safetyClick(btnSearchNameCompany)
		safetyInput(txfOvlyCustomerName, name)
		safetyClick(btnOvlySearch) //select first
		WebUI.takeScreenshot()
		safetyClick(btnOvlySelect)
	}

	private void selectIdType(String idType) {
		safetySelect(drpIdType, idType, false)
		WebUI.delay(2)
	}
	private void inputIdNumber(String idNumber) {
		safetyInput(txfIdNo, idNumber)
		WebUI.delay(2)
	}

	private void inputIdExpiredDate(String idExpiredDate) {
		WebUI.delay(5)
		safetyInput(txfIdExpiredDate, idExpiredDate)
		WebUI.delay(5)
		hideDatePicker(txfIdExpiredDate)
	}

	private void hideDatePicker(TestObject to) {
		WebUI.sendKeys(to, '\uE004') // Unicode dari Keys.TAB
	}

	private void inputPOB(String pob) {
		safetyInput(txfPOB, pob)
		WebUI.delay(2)
	}

	private void inputDOB(String dob) {
		WebUI.sendKeys(txfDOB, dob)
		hideDatePicker(txfDOB)
		WebUI.delay(2)
	}
	private void inputNPWP(String npwp) {
		String currentText = WebUI.getText(txfNPWPCompany).trim()
		if (!currentText) {
			KeywordUtil.logInfo("NPWP auto filled")
		} else {
			safetyInput(txfNPWPCompany, npwp)
		}
	}

	private void selectGender(String gender) {
		TestObject radGender = createTestObject("radGender","xpath","//label[normalize-space(text())='${gender}']/preceding-sibling::input[@type='radio']")
		if (gender?.trim()) {
			if (!WebUI.verifyElementChecked(radGender, 1, FailureHandling.OPTIONAL)) {
				safetyClick(radGender)
				WebUI.delay(2)
			}
		}
	}

	private void selectJobPosition(String jobPosition) {
		if(jobPosition) {
			safetySelect(drpJobPosition, jobPosition)
			WebUI.delay(2)
		}
	}

	private void inputSharePercentage(String percentage) {
		safetyInput(txfSharePercentage, percentage)
	}
	private void selectCustomerModel(String model) {
		if (model?.trim()) {
			TestObject radCustomerModel = createTestObject("radCustomerModel","xpath",	"//label[normalize-space(text())='${model}']/preceding-sibling::input[@type='radio']")
			if (!WebUI.verifyElementChecked(radCustomerModel, 1, FailureHandling.OPTIONAL)) {
				safetyClick(radCustomerModel)
				WebUI.delay(2)
			}
		}
	}

	private void selectCompanyType(String companyType) {
		safetySelect(drpCompanyType, companyType, false)
	}
	private void inputNITku(String nitku) {
		safetyInput(txfNITku, nitku)
	}
	private void checkIsActive(String isActive) {
		if(isActive?.trim() == 'Y') {
			WebUI.check(cbIsActive)
			WebUI.delay(2)
		}
	}

	private void checkIsOwner(String isOwner) {
		if(isOwner?.trim() == 'Y') {
			WebUI.check(cbIsOwner)
			WebUI.delay(2)
		}
	}
	
	private Map getManagementData(String scenarioId, String type, String filePath, String sheetName) {
		def testDataMultiple = BaseHelper.getTestDataMultipleByScenario(sheetName, filePath, scenarioId)
		def testData = testDataMultiple?.find { it.AddressTypeName == type }
		if (!testData) {
			KeywordUtil.markFailed("AddressType '${type}' not found")
		}
		KeywordUtil.logInfo("testData: $testData")
		return testData
	}
	
	private void clickSaveCompany() {
		safetyClick(btnSaveCompany)
	}
	
	private void clickSavePersonal() {
		safetyClick(btnSavePersonal)
	}
	
	private void clickContinue() {
		safetyClick(btnContinue)
	}
}

