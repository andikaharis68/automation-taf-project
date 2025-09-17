package com.taf.pageobjects.remedials

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable
import java.awt.Robot
import java.awt.Rectangle
import java.awt.Toolkit
import java.awt.event.KeyEvent

import javax.imageio.ImageIO

public class PaymentReceiveAfterWoPage extends BaseHelper {

	private TestObject drpWop                = createTestObject("drpWop", "id", "ddlWOP")
	private TestObject txfAccountName        = createTestObject("txfAccountName", "id", "ddlBankAccount")
	private TestObject txfValueDate            = createTestObject("txfValueDate", "id", "ucDatePicker_txtDatePicker")
	private TestObject btnNext                = createTestObject("btnNext", "id", "lb_Toolbar_Next")

	private TestObject drpOfficeName        = createTestObject("drpOfficeName", "id", "ucSearch_ddlRefOfficeId_ltlRefOfficeOfficeNameSearch_ddlReference")
	private TestObject txfCustomerName        = createTestObject("txfCustomerName", "id", "ucSearch_txtCustName_ltlCustCustNameSearch")
	private TestObject txfOverdueDaysGreater= createTestObject("txfOverdueDaysGreater", "id", "ucSearch_txtOverdueDays_ltlCollAgrmntOverdueDaysGteSearch_txtInput")
	private TestObject txfWORequestNo         = createTestObject("txfWORequestNo", "id", "ucSearch_txtCustName_ltlWriteOffTrxWoNoSearch")
	private TestObject txfWODateGreater        = createTestObject("txfWODateGreater", "id", "ucSearch_txtExeDt_ltlWriteOffTrxWODateLteSearch_txtDatePicker")
	private TestObject txfDealAmountGreater    = createTestObject("txfDealAmountGreater", "id", "ucSearch_txtDealAmt_ltlCollAgrmntDealAmtLteSearch_txtInput")
	private TestObject txfAgreementNo        = createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNoSearch")
	private TestObject txfOverdueDaysLess    = createTestObject("txfOverdueDaysLess", "id", "ucSearch_txtOverdueDays_ltlCollAgrmntOverdueDaysLteSearch_txtInput")
	private TestObject txfWoDateLess        = createTestObject("txfWoDateLess", "id", "ucSearch_txtExeDt_ltlWriteOffTrxWODateGteSearch_txtDatePicker")
	private TestObject txfDealAmountLess    = createTestObject("txfDealAmountLess", "id", "ucSearch_txtDealAmt_ltlCollAgrmntDealAmtGteSearch_txtInput")
	private TestObject btnSearchPaymentInfo    = createTestObject("btnSearchPaymentInfo", "id", "ucSearch_btnSearch")
	private TestObject txtAgreementNo        = createTestObject("txtAgreementNo", "id", "gvPaging_lblAgrmntNo_0")
	private TestObject btnEditPencil        = createTestObject("btnEditPencil", "id", "gvPaging_imbRequest_0")

	private TestObject txfReceiveFrom        = createTestObject("txfReceiveFrom", "id", "txtRcvFrom_single")
	private TestObject txfNotes                = createTestObject("txfNotes", "id", "txtNotes_single")
	private TestObject txfReferenceNo        = createTestObject("txfReferenceNo", "id", "txtReferenceNo_single")
	private TestObject txfReceiveAmount        = createTestObject("txfReceiveAmount", "id", "ucReceiveAmt_single_txtInput")
	private TestObject btnCalculate            = createTestObject("btnCalculate", "id", "lb_PayRcvHdrTrx_Calculate")
	private TestObject btnSubmit            = createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	private TestObject btnAmorAfterWo        = createTestObject("btnAmorAfterWo", "xpath", "//div[@id='upAgrmntCard']//*[contains(text(),'Amortization After WO')]")
	private TestObject btnExpandMainInfo     = createTestObject("btnExpandMainInfo", "id", "minMainInfo")
	private TestObject btnExpandAgreementInfo= createTestObject("btnExpandAgreementInfo", "id", "minAddEdit")



	private void verifyLandingPage() {
		verifyLanding(drpWop, "Payment Receive After WO New")
		WebUI.takeScreenshot()
	}

	private void searchCashierTrxInfo(String wop, String accName, String valueDate) {
		safetySelect(drpWop, wop)
		safetySelect(txfAccountName, accName)
		inputDateIfExist(txfValueDate, valueDate)
		WebUI.takeScreenshot()
		safetyClick(btnNext)
	}
	private void inputIfExist(TestObject to, String textInputted) {
		if(textInputted) {
			WebUI.comment("input .. $textInputted")
			manualClearText(to)
			safetyInput(to, textInputted)
			WebUI.delay(0.3)
		}
	}
	private void inputDateIfExist(TestObject to, String date) {
		if(date) {
			WebUI.comment("input .. $date")
			safetyInput(to, date)
			WebUI.delay(0.2)
			pressEsc(to)
		}
	}

	private void inputPaymentInfo(String officeName, String customerName, String overduedaysGreater, String woRequestNo,
			String woDateGreater, String dealAmountGreater, String agreementNo, String overduedaysless,
			String woDateLess, String dealAmountLess) {

		safetySelect(drpOfficeName, officeName)
		inputIfExist(txfCustomerName, customerName)
		inputIfExist(txfOverdueDaysGreater, overduedaysGreater)
		inputIfExist(txfWORequestNo, woRequestNo)
		inputDateIfExist(txfWODateGreater, woDateGreater)
		inputIfExist(txfDealAmountGreater, dealAmountGreater)
		inputIfExist(txfAgreementNo, agreementNo)
		inputIfExist(txfOverdueDaysLess, overduedaysless)
		inputDateIfExist(txfWoDateLess, woDateLess)
		inputIfExist(txfDealAmountLess, woDateLess)

		safetyClick(btnSearchPaymentInfo)
		WebUI.takeScreenshot()
	}

	private void switchToAgreementTab() {
		safetyClick(txtAgreementNo)
		waitForLoadingBarNotExist()
		scrollDown()
		WebUI.delay(1)
		openAgreementTab(false)
	}

	private void openAgreementTabAndRefresh() {
		safetyClick(txtAgreementNo)
		waitForLoadingBarNotExist()
		scrollDown()
		WebUI.delay(1)
		openAgreementTab(true)
	}

	private void clickEdit() {
		WebUI.takeScreenshot()
		safetyClick(btnEditPencil)
	}
	private void clickCalculate() {
		safetyClick(btnCalculate)
		WebUI.takeScreenshot()
		scrollDown()
		WebUI.takeScreenshot()
	}

	private void clickSubmit() {
		safetyClick(btnSubmit)
		WebUI.takeScreenshot()
		WebUI.delay(3)
	}

	private void inputPaymentDetailInfo(String receiveFrom, String notesPayment, String refNo, String receiveAmount) {
		WebUI.takeScreenshot()
		inputIfExist(txfReceiveFrom, receiveFrom)
		inputIfExist(txfNotes, notesPayment)
		inputIfExist(txfReferenceNo, refNo)
		inputIfExist(txfReceiveAmount, receiveAmount)
	}

	private void openAgreementTab(boolean refreshPage) {
		WebDriver driver = DriverFactory.getWebDriver()
		String leftTab = driver.getWindowHandle()

		// Switch to new tab
		String rightTab = getRightTab(leftTab)
		driver.switchTo().window(rightTab)

		if (refreshPage) {
			WebUI.delay(1)
			WebUI.refresh()
			scrollDown()
			WebUI.delay(2)
		}

		WebUI.click(btnAmorAfterWo)
		WebUI.delay(1)
		scrollDown()
		WebUI.takeScreenshot()
		// Switch back
		driver.switchTo().window(leftTab)
	}

	// Helper to get the other tab
	private String getRightTab(String currentTab) {
		WebDriver driver = DriverFactory.getWebDriver()
		Set<String> handles = driver.getWindowHandles()
		handles.remove(currentTab)
		return handles.iterator().next()
	}
}
