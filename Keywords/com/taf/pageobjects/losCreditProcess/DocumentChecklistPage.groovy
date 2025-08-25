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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class DocumentChecklistPage extends BaseHelper {

	private TestObject txfApplicationNo		= createTestObject("txfApplicationNo","id","ucSearch_txtAppNo_ltlAgrmntAppNo") 
	private TestObject txfAggreementNo		= createTestObject("txfAggreementNo","id","ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNo") 
	private TestObject txfPromiseDate		= createTestObject("txfPromiseDate","id","ucSearch_txtPromiseDt_ltlAgrmntPromiseDt_txtDatePicker") 
	private TestObject drpTaskClaimStatus	= createTestObject("drpTaskClaimStatus","id","ucSearch_ddlusername_ltlWfPagingTaskClaimStat_ddlReference")
	private TestObject txfCustomerName		= createTestObject("txfCustomerName","id","")
	private TestObject txfProductOffering	= createTestObject("txfProductOffering","id","")
	private TestObject txfTaskClaimBy		= createTestObject("txfTaskClaimBy","id","")
	private TestObject btnSearch			= createTestObject("btnSearch","id","ucSearch_btnSearch")
	private TestObject btnEdit				= createTestObject("btnEdit","id","gvDocChklst_imbEdit_0")
	
	private TestObject btnSubmit 			= createTestObject("btnSubmit","id","lb_Toolbar_Submit") 

	private void verifyLandingInDocChecklist() {
		verifyLanding(txfApplicationNo, "Document Checklist")
	}

	private void inputApplicationNo(String applicationNo) {
		safetyInput(txfApplicationNo, applicationNo)
	}

	private void clickSearch() {
		safetyClick(btnSearch)
	}

	private void clickEdit() {
		safetyClick(btnEdit)
	}
	
	private void clickSubmit() {
		safetyClick(btnSubmit)
	}
}
