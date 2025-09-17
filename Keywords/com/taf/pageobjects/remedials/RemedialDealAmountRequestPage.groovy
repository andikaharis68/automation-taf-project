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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class RemedialDealAmountRequestPage extends BaseHelper {

	private TestObject drpHandlingOffice		= createTestObject("drpHandlingOffice", "id", "ucSearch_ddlHandlingOfficeId_ltlRefOfficeHandlingName_ddlReference")
	private TestObject txfAgreementNo			= createTestObject("txfAgreementNo", "id", "ucSearch_txtAgrmntNo_ltlAgrmntAgrmntNoSearch")
	private TestObject txfCustomerName			= createTestObject("txfCustomerName", "id", "ucSearch_txtCustName_ltlCustCustNameSearch")
	private TestObject btnSearch				= createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	private TestObject btnEditRequest			= createTestObject("btnEditRequest", "id", "gvPaging_imbRequest_0")

	private TestObject txfDealAmount			= createTestObject("txfDealAmount", "id", "ucINDealAmt_txtInput")
	private TestObject txfTenor					= createTestObject("txfTenor", "id", "ucINTenor_txtInput")
	private TestObject drpPaymentFrequency		= createTestObject("drpPaymentFrequency", "id", "ucRefPaymentFrequency_ddlReference")
	private TestObject drpInstallmentScheme		= createTestObject("drpInstallmentScheme", "id", "ucRefInstSchme_ddlReference")
	private TestObject txfEffectiveDate			= createTestObject("txfEffectiveDate", "id", "ucDateEffectiveDt_txtDatePicker")
	private TestObject txfNotes 				= createTestObject("txfNotes", "id", "txtNotes")
	private TestObject btnCalculateInstallment	= createTestObject("btnCalculateInstallment", "id", "lb_Form_CalcInst")

	private TestObject drpReasonDescription		= createTestObject("drpReasonDescription", "id", "ucAppv_ddlReason")
	private TestObject drpToBeApprovedBy		= createTestObject("drpToBeApprovedBy", "id", "ucAppv_ddlApvBy")
	private TestObject txfNotesApproval		 	= createTestObject("txfNotesApproval", "id", "ucAppv_txtNotes")
	private TestObject btnSubmit				= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	private TestObject lblApprovalRequest		= createTestObject("lblApprovalRequest", "id", "ucAppv_ucToggleApv_subSectionID")

	private TestObject txtAgreementNo			= createTestObject("txtAgreementNo", "id", "gvPaging_lblAgrmntNo_0")
	private TestObject txtBussinessDate			= createTestObject("txtBussinessDate", "id", "lblAsOf")

	private void verifyLandingPage() {
		WebUI.delay(1)
		verifyLanding(drpHandlingOffice, "Remedial Deal Amount Request")
		WebUI.takeScreenshot()
	}

	private void searchAgreement(String handlingOffice, String agreementNo, String customerName) {
		safetySelect(drpHandlingOffice, handlingOffice)
		if(agreementNo?.trim()) {
			safetyInput(txfAgreementNo, agreementNo)
		}
		if(customerName?.trim()) {
			safetyInput(txfCustomerName, customerName)
		}
		safetyClick(btnSearch)
		WebUI.takeScreenshot()
	}

	private void clickEditRequest() {
		safetyClick(btnEditRequest)
	}

	private void verifyLandingRemedialDealAmountReqDetail() {
		verifyLanding(txfDealAmount, "Remedial Deal Amount Request Detail")
		WebUI.takeScreenshot()
	}
	private void inputRemedialDealAmount(String dealAmount, String tenor, String paymentFreq, String installmentScheme,
			String effectiveDate, String notes) {

		WebUI.delay(1)
		WebUI.scrollToElement(txfDealAmount, 2)
		inputIfNotSame(txfDealAmount, dealAmount)
		inputIfNotSame(txfTenor, tenor)
		selectIfNotSame(drpPaymentFrequency, paymentFreq)
		handleAlertIfPresent()
		selectIfNotSame(drpInstallmentScheme, installmentScheme)
		inputEffectiveDate(effectiveDate)
		inputIfNotSame(txfNotes, notes)
		WebUI.delay(1)
	}

	private void inputIfNotSame(TestObject to, String textInputted) {
		String actualText = WebUI.getText(to)
		if(!actualText.equalsIgnoreCase(textInputted)) {
			manualClearText(to)
			slowlyInput(to, textInputted)
			WebUI.delay(0.5)
		}
	}

	private void inputEffectiveDate(String date) {
		String actualText = WebUI.getText(txfEffectiveDate)
		if(!actualText.equalsIgnoreCase(date)) {
			safetyInput(txfEffectiveDate, date)
			pressEsc(txfEffectiveDate)
		}
	}
	private void selectIfNotSame(TestObject to, String textInputted) {
		String actualText = WebUI.getText(to)
		if(!actualText.equalsIgnoreCase(textInputted)) {
			safetySelect(to, textInputted)
			WebUI.delay(1)
		}
	}
	private void clickCalculateInstallment() {
		safetyClick(btnCalculateInstallment)
		WebUI.takeScreenshot()
		WebUI.scrollToElement(lblApprovalRequest, 2)
	}

	private void selectApprovalByOrSelectFirstOption(String approvalBy) {
		WebElement element = WebUI.findWebElement(drpToBeApprovedBy)
		List<WebElement> options = element.findElements(By.tagName("option"))
		boolean isFound = false
		for (WebElement opt : options) {
			if (opt.getText().trim().equalsIgnoreCase(approvalBy)) {
				safetySelect(drpToBeApprovedBy, approvalBy)
				isFound = true
				WebUI.delay(1)
				break
			}
		}
		if (!isFound) {
			selectFirstOption(drpToBeApprovedBy, approvalBy)
		}
	}

	private void inputApprovalRequestDetail(String reasonDesc, String approvalBy, String notes) {
		WebUI.scrollToElement(drpReasonDescription, 2)
		selectIfNotSame(drpReasonDescription, reasonDesc)
		selectApprovalByOrSelectFirstOption(approvalBy)
		inputIfNotSame(txfNotesApproval, notes)
		WebUI.takeScreenshot()
	}

	private void clickSubmit() {
		safetyClick(btnSubmit)
		WebUI.takeScreenshot()
	}

	private String getBussinessDate() {
		WebDriver driver = DriverFactory.getWebDriver()
		String leftTab = driver.getWindowHandle()
		safetyClick(txtAgreementNo)
		WebUI.delay(1)

		Set<String> handles = driver.getWindowHandles()
		handles.remove(leftTab)
		String rightTab = handles.iterator().next()

		// 1. Pindah ke tab kanan
		driver.switchTo().window(rightTab)
		WebUI.takeScreenshot()
		WebUI.delay(1)

		String date = WebUI.getText(txtBussinessDate)

		KeywordUtil.logInfo(date)
		// 2. Tutup tab kanan
		driver.close()

		// 3. Balik ke tab kiri
		driver.switchTo().window(leftTab)
		return date
	}
	public void updateCredentialIdforApproval(String fileName, String scenarioId) {
		String filePath = GlobalVariable.TEST_DATA_LOCATION + '/' + fileName
		String username = WebUI.getText(drpToBeApprovedBy)
		Map rowFilter = [:]
		rowFilter['ScenarioId'] = scenarioId

		saveDataToExcel(username, rowFilter, filePath, "MasterData", "Username")
		WebUI.delay(1)
	}
}
