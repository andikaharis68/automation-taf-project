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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper
import java.time.LocalDate
import java.time.format.DateTimeFormatter

import internal.GlobalVariable

public class OnlineDisbursementInquiryPage extends BaseHelper {

	private TestObject txfBatchNo			= createTestObject("txfBatchNo","id", "txtBatchNo")
	private TestObject txfAgreementNo		= createTestObject("txfAgreementNo","id", "txtAgrmntNo")
	private TestObject drpAccountNo			= createTestObject("drpAccountNo","id", "ucBankAccNo_ddlReference")
	private TestObject drpApTypeName		= createTestObject("drpApTypeName","id", "ucApTypeName_ddlReference")
	private TestObject drpBankName			= createTestObject("drpBankName","id", "ucBankName_ddlReference")
	private TestObject drpStatus			= createTestObject("drpStatus","id", "ucStatus_ddlReference")
	private TestObject btnSearch			= createTestObject("btnSearch","id", "btnSearch")

	private TestObject txtBatchNo			= createTestObject("txtBatchNo", "id", "gvGrid_lbBatchNo_0")
	private TestObject txtVoucherNo			= createTestObject("txtVoucherNo", "id", "lbPayVoucherNo")
	private TestObject txtStatus			= createTestObject("txtStatus", "id", "gvGrid_lblStatus_0")
	private TestObject txfGenerateDateMore	= createTestObject("txfGenerateDateMore", "id", "ucDateGte_txtDatePicker")
	private TestObject txfGenerateLess		= createTestObject("txfGenerateLess", "id", "ucDateLte_txtDatePicker")


	private TestObject txtPaymentVoucherStatus = createTestObject("txtPaymentVoucherStatus", "id", "lblStat")

	private void verifyLandingInInquiryPage() {
		WebUI.delay(1)
		verifyLanding(txfBatchNo, "Online Disbursement Inquiry")
		WebUI.takeScreenshot()
	}


	private boolean retryInquiryStatus() {
		int maxAttempts = GlobalVariable.COUNTER
		int waitTime = GlobalVariable.WAIT

		TestObject btnSearch = createTestObject("btnSearch", "xpath", "//input[@value='Search']")

		for (int attempt = 1; attempt <= maxAttempts; attempt++) {
			String currentStatus = WebUI.getText(txtStatus).trim()
			WebUI.comment("Attempt ${attempt} of ${maxAttempts} — Current status: '${currentStatus}'")

			if (currentStatus.equalsIgnoreCase("success")) {
				WebUI.comment("Status is SUCCESS on attempt ${attempt}.")
				return true
			} else if (currentStatus.equalsIgnoreCase("fail")) {
				WebUI.comment("Status is FAIL. Clicking Search button to retry...")
				WebUI.click(btnSearch)
				WebUI.delay(waitTime)
			} else {
				WebUI.comment("ℹ️ Status is '${currentStatus}'. Waiting ${waitTime} seconds before retry...")
				WebUI.delay(waitTime)
			}
		}

		KeywordUtil.markWarning("Status never became SUCCESS or FAIL after ${maxAttempts} attempts.")
		return false
	}

	private Map getGenerateDateToday() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
		String today = LocalDate.now().format(formatter)
		String nextday = LocalDate.now().plusDays(29).format(formatter)

		WebUI.comment("Hari ini: " + today)
		WebUI.comment("29 hari dari sekarang: " + nextday)

		return ["today" : today, "NextDay" :nextday]
	}

	private void searchByAgreementNo(String agreementNo) {
		safetyInput(txfAgreementNo, agreementNo)
		WebUI.delay(1)
		Map generateDate = getGenerateDateToday()

		safetyInput(txfGenerateDateMore, generateDate['today'])
		clickTABKeyboard(txfGenerateDateMore)
		WebUI.delay(1)


		safetyInput(txfGenerateLess, generateDate['NextDay'])
		clickTABKeyboard(txfGenerateDateMore)
		WebUI.delay(1)

		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}
	private void clickBatchNoAndNavigateToNewTab() {
		safetyClick(txtBatchNo)
		WebUI.delay(2)
		switchToNewTab()
		WebUI.takeScreenshot()
	}
	private void clickVoucherNo() {
		safetyClick(txtVoucherNo)
		switchToNewTab()
		WebUI.takeScreenshot()
	}
	private String getStatus() {
		String strStatus = WebUI.getText(txtStatus)
	}
	private void verifyStatus(String status) {
		WebUI.verifyElementText(txtPaymentVoucherStatus, status)
	}
}
