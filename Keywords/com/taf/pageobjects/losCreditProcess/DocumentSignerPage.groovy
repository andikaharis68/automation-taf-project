package com.taf.pageobjects.losCreditProcess

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

public class DocumentSignerPage extends BaseHelper{

	private TestObject lblTitle					= createTestObject("lblTitle", "id", "")
	private TestObject txfAgreementNo			= createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNoSearch")
	private TestObject txfApplicationtNo		= createTestObject("txfApplicationtNo", "id", "ucSearch_txtAppNo_ltlAppAppNoSearch")
	private TestObject btnSearch				= createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	//section company signer
	private TestObject btnLookUpOfficer2		= createTestObject("btnLookUpOfficer2", "id", "uclOfficeEmp2_uclOfficeEmp_imb")


	//section shareholder signer
	private TestObject btnLookUpShareholder		= createTestObject("btnLookUpShareholder", "id", "uclCoyCommissioner_uclCustCoyShareHolder_imb")


	//section approver signer
	private TestObject btnLookUpApprover1		= createTestObject("btnLookUpApprover1", "id", "uclCoyApprover1_uclCustCoyShareHolder_imb")

	private TestObject btnSubmit				= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	private TestObject iframeMainPage			= createTestObject("iframeMain", "id", "mainPage")


	//look up object
	private TestObject txfEmployeeName			= createTestObject("txfEmployeeName", "id", "uclOfficeEmp2_uclOfficeEmp_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject btnSearchEmployee		= createTestObject("btnSearchEmployee", "id", "uclOfficeEmp2_uclOfficeEmp_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectEmployee		= createTestObject("btnSelectEmployee", "id", "uclOfficeEmp2_uclOfficeEmp_umd_ctl00_gvL_hpSelect_0") //hanya select yg atas
	private TestObject txfCommisionerName		= createTestObject("txfCommisionerName", "id", "uclCoyCommissioner_uclCustCoyShareHolder_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject txfCommisionerPosition	= createTestObject("txfCommisionerPosition", "id", "uclCoyCommissioner_uclCustCoyShareHolder_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1")
	private TestObject btnSearchCommisioner		= createTestObject("btnSearchCommisioner", "id", "uclCoyCommissioner_uclCustCoyShareHolder_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectCommisioner		= createTestObject("btnSelectCommisioner", "id", "uclCoyCommissioner_uclCustCoyShareHolder_umd_ctl00_gvL_hpSelect_0") //hanya select yg atas
	private TestObject txfApprover1Name			= createTestObject("txfApprover1Name", "id", "uclCoyApprover1_uclCustCoyShareHolder_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject txfApprover1Position		= createTestObject("txfApprover1Position", "id", "uclCoyApprover1_uclCustCoyShareHolder_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1")
	private TestObject btnSearchApprover1		= createTestObject("btnSearchApprover1", "id", "uclCoyApprover1_uclCustCoyShareHolder_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectApprover1		= createTestObject("btnSelectApprover1", "id", "uclCoyApprover1_uclCustCoyShareHolder_umd_ctl00_gvL_hpSelect_0") //hanya select yg atas


	
	private void verifyDocSignerLandingPage() {
		WebUI.switchToFrame(iframeMainPage, 3)
		verifyLanding(lblTitle, 'Document Signer')
		WebUI.takeScreenshot()
	}
	
	private void searchTransactionByApplicationNumber(String appNo) {
		safetyInput(txfApplicationtNo, appNo)
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}


	private void entryDocument(String appNo) {
		TestObject rowExist = createTestObject("rowExist", "xpath", "//a[text() = '$appNo']")
		def exist = WebUI.verifyElementPresent(rowExist, 3, FailureHandling.OPTIONAL)

		if(rowExist) {
			TestObject btnPenEdit = createTestObject("btnPenEdit", "xpath", "${getXpath(rowExist)}/following::td[4]//input")
			WebUI.takeScreenshot()
			safetyClick(btnPenEdit)
		}else {
			KeywordUtil.markFailedAndStop("reff no not exist $appNo")
		}
	}

	private selectCompanySigner(String input) {

		safetyClick(btnLookUpOfficer2)

		//pop up
		safetyInput(txfEmployeeName, input)
		safetyClick(btnSearchEmployee)
		WebUI.takeScreenshot()
		safetyClick(btnSelectEmployee)
	}

	private selectShareholder(String input) {

		safetyClick(btnLookUpShareholder)

		//pop up
		safetyInput(txfCommisionerName, input)
		safetyClick(btnSearchCommisioner)
		WebUI.takeScreenshot()
		safetyClick(btnSelectCommisioner)
	}

	private selectOfficerApprover(String input) {

		safetyClick(btnLookUpApprover1)

		//pop up
		safetyInput(txfApprover1Name, input)
		safetyClick(btnSearchApprover1)
		WebUI.takeScreenshot()
		safetyClick(btnSelectApprover1)
	}
	
	private clickSubmitSigner() {
		WebUI.delay(2)
		WebUI.click(btnSubmit)
		WebUI.takeScreenshot()
	}
}
