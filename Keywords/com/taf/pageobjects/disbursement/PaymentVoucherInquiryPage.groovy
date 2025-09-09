package com.taf.pageobjects.disbursement

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

public class PaymentVoucherInquiryPage extends BaseHelper {
	//search
	private TestObject drpAPTypeName = createTestObject("drpAPTypeName", "id", "ucSearch_ddlRefAccPayableTypeId_ltlRefAccPayableTypeAccPayableTypeNameSearch_ddlReference")
	private TestObject txfVoucherNo = createTestObject("txfVoucherNo", "id", "ucSearch_txtPayVoucherNo_ltlPayVoucherHPayVoucherNoSearch")
	private TestObject btnSearch = createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	private TestObject btnVoucherNo = createTestObject("btnVoucherNo", "id", "gvGrid_lbPayVoucherNo_0")
	private TestObject txtStatus = createTestObject("txtStatus", "id", "gvGrid_lblStatus_0")


	private void verifyLandingInquiryPage() {
		verifyLanding(drpAPTypeName, "Pay Voucher Inquiry")
		WebUI.takeScreenshot()
		WebUI.delay(2)
	}
	public void inputSearchApplication(String apTypeName, String voucherNo) {
		safetySelect(drpAPTypeName, apTypeName)
		WebUI.delay(1)
		safetyInput(txfVoucherNo, voucherNo)
		WebUI.delay(2)
	}

	public void clickButtonSearch() {
		WebUI.click(btnSearch)
		WebUI.takeScreenshot()
		WebUI.delay(2)
	}

	public void verifyStatusPaid() {
		WebUI.waitForElementPresent(txtStatus, 5)
		WebUI.verifyElementText(txtStatus, "PAID", FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(2)
	}
	private void clickVoucherNoAndNavigateToNewTab() {
		safetyClick(btnVoucherNo)
		WebUI.delay(2)
		switchToNewTab()
		WebUI.delay(2)
		WebUI.takeScreenshot()
	}
}
