package com.taf.pageobjects

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
	
	private TestObject txfAgreementNo			= createTestObject("txfAgreementNo", "id", "")
	private TestObject btnSearch				= createTestObject("btnSearch", "id", "")
	
	//section company signer
	private TestObject btnLookUpOfficer2		= createTestObject("btnLookUpOfficer2", "id", "")
	
	
	//section shareholder signer
	private TestObject btnLookUpShareholder		= createTestObject("btnLookUpShareholder", "id", "")

	
	//section approver signer
	private TestObject btnLookUpApprover1		= createTestObject("btnLookUpApprover1", "id", "")
	
	private TestObject btnSubmit				= createTestObject("btnSubmit", "id", "")
	
	
	//look up object
	private TestObject txfEmployeeName			= createTestObject("txfEmployeeName", "id", "")
	private TestObject btnSearchEmployee		= createTestObject("btnSearchEmployee", "id", "")
	private TestObject btnSelectEmployee		= createTestObject("btnSelectEmployee", "id", "")
	private TestObject txfCommisionerName		= createTestObject("txfCommisionerName", "id", "")
	private TestObject txfCommisionerPosition	= createTestObject("txfCommisionerPosition", "id", "")
	private TestObject btnSearchCommisioner		= createTestObject("btnSearchCommisioner", "id", "")
	private TestObject btnSelectCommisioner		= createTestObject("btnSelectCommisioner", "id", "")
	
	
	
	private void searchTransactionByAgreementNumber(String agreeNo) {
		safetyInput(txfAgreementNo, agreeNo)
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}
	
	
	private void editTransaction(String agreeNO) {
		TestObject rowExist = createTestObject("rowExist", "xpath", "")
		def exist = WebUI.verifyElementPresent(rowExist, 3, FailureHandling.OPTIONAL)
		
		if(rowExist) {
			TestObject btnPenEdit = createTestObject("btnPenEdit", "xpath", "")
			WebUI.takeScreenshot()
			safetyClick(btnPenEdit)
		}else {
			KeywordUtil.markFailedAndStop("reff no not exist $agreeNO")
		}
	}
	
	private selectCompany(String input) {
		
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
		safetyInput("", input)
		safetyClick(btnSearchCommisioner)
		WebUI.takeScreenshot()
		safetyClick(btnSelectCommisioner)
	}
	
	private selectOfficerApprover(String input) {
		
		safetyClick(btnLookUpApprover1)
		
		//pop up
		safetyInput("", input)
		safetyClick(btnSearchCommisioner)
		WebUI.takeScreenshot()
		safetyClick(btnSelectCommisioner)
	}
}
