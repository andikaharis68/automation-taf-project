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
import com.kms.katalon.core.mobile.keyword.builtin.VerifyElementCheckedKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class TermAndCondition extends BaseHelper {

	private TestObject btnSave					= createTestObject("btnSave","id","lb_Form_Save")
	
	private TestObject cbFcKTPPemohon1			= createTestObject("cbFcKTPPemohon1","id","gvTermCondition_cbChecked_0")
	private TestObject txfFcKTPPemohon1			= createTestObject("txfFcKTPPemohon1","id","gvTermCondition_ucDPPromiseDt_0_txtDatePicker_0")

	private TestObject cbFcKK					= createTestObject("cbFcKK","id","gvTermCondition_cbChecked_1")
	private TestObject txfDateFcKK				= createTestObject("txfDateFcKK","xpath","[contains(@id, 'txtDatePicker_1')]")

	private TestObject cbFcIjinPraktek			= createTestObject("cbFcIjinPraktek","id","gvTermCondition_cbChecked_2")
	private TestObject txfFcIjinPraktek			= createTestObject("txfFcIjinPraktek","xpath","[contains(@id, 'txtDatePicker_2')]")

	private TestObject cbFcNpwp					= createTestObject("cbFcNpwp","id","gvTermCondition_cbChecked_3")
	private TestObject txfFcNpwp				= createTestObject("txfFcNpwp","xpath","[contains(@id, 'txtDatePicker_3')]")

	private TestObject cbFcTabungan				= createTestObject("cbFcTabungan","id","gvTermCondition_cbChecked_4")
	private TestObject txfFcTabungan			= createTestObject("txfFcTabungan","xpath","[contains(@id, 'txtDatePicker_4')]")

	private TestObject cbDocKepemilikanRumah	= createTestObject("cbDocKepemilikanRumah","id","gvTermCondition_cbChecked_5")
	private TestObject txfDocKepemilikanRumah	= createTestObject("txfDocKepemilikanRumah","xpath","[contains(@id, 'txtDatePicker_5')]")

	private TestObject cbCoverTabungan			= createTestObject("cbCoverTabungan","id","gvTermCondition_cbChecked_6")
	private TestObject txfCoverTabungan			= createTestObject("txfCoverTabungan","xpath","[contains(@id, 'txtDatePicker_6')]")

	private TestObject cbKkAtasNamaStnk			= createTestObject("cbKkAtasNamaStnk","id","gvTermCondition_cbChecked_7")
	private TestObject txfKkAtasNamaStnk		= createTestObject("txfKkAtasNamaStnk","xpath","[contains(@id, 'txtDatePicker_7')]")

	private TestObject cbFcKtpPemohon2			= createTestObject("txfDateFcKTPPemohon1","id","gvTermCondition_cbChecked_8")
	private TestObject txfFcKtpPemohon2			= createTestObject("txfFcKtpPemohon2","xpath","[contains(@id, 'txtDatePicker_8')")

	private TestObject cbInvoice				= createTestObject("cbInvoice","id","gvTermCondition_cbChecked_9")
	private TestObject txfInvoice				= createTestObject("txfInvoice","xpath","[contains(@id, 'txtDatePicker_9')")
	
	private TestObject btnSubmit				= createTestObject("btnSubmit", "id", "lbl_Toolbar_Submit") 
	private TestObject iframeMainPage			= createTestObject("iframeMainPage", "id", "mainPage")

	private void verifyLandingInTnCPage() {
		verifyLanding(cbFcKTPPemohon1, "Term and Condition")
		WebUI.takeScreenshot()
	}

	private void checkObject(TestObject to, String element) {
		if(element == 'Y') {
			if (!WebUI.verifyElementChecked(to, 1, FailureHandling.OPTIONAL)) {
				WebUI.check(to)
			}
		}
	}
	
	private void checkFcKtpPemohon2(String checkFcKTP) {
		checkObject(cbFcKtpPemohon2, checkFcKTP)
	}
	private void checkFcKTPPemohon1(String checkFotoCopyKTP) {
		checkObject(cbFcKTPPemohon1, checkFotoCopyKTP)
		WebUI.delay(0.5)
		
	}

	private void checkFcKK(String fcKK) {
		checkObject(cbFcKK, fcKK)
		WebUI.delay(0.5)
	}

	private void checkFcIjinPraktek(String fcIjinPraktek) {
		checkObject(cbFcIjinPraktek, fcIjinPraktek)
		WebUI.delay(0.5)
	}

	private void checkFcNpwp(String fcNpwp ) {
		checkObject(cbFcNpwp, fcNpwp)
		WebUI.delay(0.5)
		
	}

	private void checkFcTabungan(String fcTabungan ) {
		checkObject(cbFcTabungan, fcTabungan)
		WebUI.delay(0.5)
	}
	private void checkFcDocKepemilikanRumah(String fcDocKepemilikanRumah ) {
		checkObject(cbDocKepemilikanRumah, fcDocKepemilikanRumah)
		WebUI.delay(0.5)
	}

	private void checkCoverTabungan(String coverTabungan) {
		checkObject(cbCoverTabungan, coverTabungan)
		WebUI.delay(0.5)
	}

	private void checkKartuKeluargaStnk(String KkStnk) {
		checkObject(cbKkAtasNamaStnk, KkStnk)
		WebUI.delay(0.5)
	}
	private void checkInvoice(String invoice) {
		checkObject(cbInvoice, invoice)
		WebUI.delay(0.5)
		
	}
	
	private void clickSave() {
		WebUI.takeScreenshot()
		safetyClick(btnSave)
	}

	private void switchToIframeMainPage() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeMainPage, 2)
	}
	private void clickSubmit() {
		safetyClick(btnSubmit)
	}
	
	private void clickConfirmationOk() {
		if(WebUI.waitForAlert(5)) {
			WebUI.acceptAlert()
		}
	}
}
