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

public class GuarantorPage extends BaseHelper {

	private TestObject btnSaveContinue		= createTestObject("btnSaveContinue", "id", "lb_Form_SaveCont")
	private TestObject btnAddPersonal		= createTestObject("btnAddPersonal", "id", "lb_AgrmntGuarantor_AddPersonal")
	private TestObject btnAddCompany		= createTestObject("btnAddCompany", "id", "lb_AgrmntGuarantor_AddCompany")
	private TestObject btnSave				= createTestObject("btnSave", "id", "lb_Form_Save")
	private TestObject btnCancel			= createTestObject("btnCancel", "id", "lb_Form_Cancel")
	private TestObject btnSearchCustName	= createTestObject("btnSearchCustName", "id", "ucLookupCust_uclCust_imb")

	private TestObject txfOvlyCustName		= createTestObject("txfOvlyCustName", "xpath", "//*[@id='ucLookupCust_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
	private TestObject btnOvlySearch		= createTestObject("btnOvlySearch", "xpath", "//*[contains(@id,'lbSearch')]")
	private TestObject btnOvlySelect		= createTestObject("btnOvlySelect", "xpath", "//*[contains(@id, 'hpSelect_0')]")
	private TestObject drpCustRelationship	= createTestObject("drpCustRelationship", "id", "ddlRefMasterCustRelation")
	private TestObject iframeApp			= createTestObject("iframeApp", "id", "appForm")
	private TestObject txfGuarantorPersonal = createTestObject("txfGuarantorPersonal", "id", "gvGuarantor_lbGuarantorName_0")


	private void verifyLandingInGuarantorPage() {
		verifyLanding(btnAddPersonal, "Guarantor")
		WebUI.takeScreenshot()
	}

	private void selectCustRelationship(String relationship) {
		safetySelect(drpCustRelationship, relationship)
		WebUI.takeScreenshot()
	}
	private void inputCustomerName(String name) {
		safetyClick(btnSearchCustName)
		Mobile.delay(2)
		safetyInput(txfOvlyCustName, name)
		Mobile.delay(3)
		safetyClick(btnOvlySearch)
		WebUI.takeScreenshot()
		safetyClick(btnOvlySelect)
	}

	private void clickAddPersonal() {
		safetyClick(btnAddPersonal)
		WebUI.takeScreenshot()
	}

	private void clickAddCompany() {
		safetyClick(btnAddCompany)
		WebUI.takeScreenshot()
	}

	private void clickSave() {
		safetyClick(btnSave)
		WebUI.takeScreenshot()
	}
	private void clickSaveContinue() {
		WebUI.delay(5)
		safetyClick(btnSaveContinue)
	}

	private void addGuantorPersonal(String guarantorPersonal, String customerRelationship) {
		boolean isNameExist = checkGuarantorIsExist(guarantorPersonal)
		if(guarantorPersonal && !isNameExist) {
			clickAddPersonal()
			inputCustomerName(guarantorPersonal)
			selectCustRelationship(customerRelationship)
			clickSave()
		}
	}

	private boolean checkGuarantorIsExist(String name) {
		int maxLoop = countGuarantorExist()
		for(int i=0; i <= maxLoop; i++) {
			TestObject txfGuarantor = createTestObject("txfGuarantorPersonal", "id", "gvGuarantor_lbGuarantorName_$i")
			String labelText = WebUI.verifyElementPresent(txfGuarantor, 1, OPTIONAL) ? WebUI.getText(txfGuarantor) : ""
			if(name.trim().equalsIgnoreCase(labelText.trim())) {
				return true
			}
		}

		return false
	}
	private int countGuarantorExist() {
		TestObject txtGuarantorName = createTestObject("txtGuarantorName", "xpath", "//span[starts-with(@id,'gvGuarantor_lbGuarantorName')]")
		def elements = WebUI.findWebElements(txtGuarantorName, 5)
		int counter = elements.size()
		KeywordUtil.logInfo("max loop $counter")
		return counter
	}

	private void addGuantorCompany(String guarantorCompany, String customerRelationshipCompany) {
		boolean isNameExist = checkGuarantorIsExist(guarantorCompany)
		KeywordUtil.logInfo("exist  $isNameExist")
		if(guarantorCompany && !isNameExist) {
			clickAddCompany()
			inputCustomerName(guarantorCompany)
			selectCustRelationship(customerRelationshipCompany)
			clickSave()
		}
	}
}
