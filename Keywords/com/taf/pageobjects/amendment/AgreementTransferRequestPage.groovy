package com.taf.pageobjects.amendment

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class AgreementTransferRequestPage extends BaseHelper{

	private TestObject btnNext					= createTestObject("btnNext", "id", "lb_Toolbar_Next") 
	private TestObject sectionAgreementTransfer	= createTestObject("sectionAgreementTransfer", "xpath", "//span[text() = 'AGREEMENT TRANSFER REQUEST']/preceding-sibling::a")
	private TestObject btnSearchAgreementNo		= createTestObject("icnSearch", "id", "uclCust_uclCust_imb")

	//pop up section
	private TestObject txtCustomerName			= createTestObject("txtCustomerName", "xpath", "//input[@id = 'uclCust_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
	private TestObject btnSearch				= createTestObject("btnSearch", "id", "uclCust_uclCust_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelect 				= createTestObject("btnSelect", "id", "uclCust_uclCust_umd_ctl00_gvL_hpSelect_0")//select first row


	private TestObject btnRequestSurvey1		= createTestObject("btnRequestSurvey1", "xpath", "//input[@id = 'lb_Form_ReqSurvey_Cust']")
	private TestObject btnRequestSurvey2		= createTestObject("btnRequestSurvey2", "xpath", "")

	//select all checkBox yes
	private TestObject btnSave					= createTestObject("btnSave", "id", "lb_Toolbar_Save")
	private TestObject lblNotification			= createTestObject("lblNotification", "xpath", "UCNotification_notificationContainer")

	//section approval request
	private TestObject sectionApprovalRequest	= createTestObject("sectionApprovalRequest", "xpath", "//span[text() = 'APPROVAL REQUEST']/preceding-sibling::a")
	private TestObject drpReasonDescription		= createTestObject("drpReasonDescription", "xpath", "//select[@id = 'ucApprovalReq_ddlReason']")
	private TestObject drpApprover				= createTestObject("drpApprover", "xpath", "//select[@id = 'ucApprovalReq_ddlApvBy']")
	private TestObject txfNotes					= createTestObject("txfNotes", "xpath", "//textarea[@id = 'ucApprovalReq_txtNotes']")
	private TestObject btnSubmit				= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")


	private void verifyLandingPage() {
		verifyLanding(btnNext, "Agreement Transfer Request")
		WebUI.takeScreenshot()
	}
	public void clickButtonNext() {
		safetyClick(btnNext, 2)
		WebUI.takeScreenshot()
	}

	private void searchAgreementNo(String customerName) {
		TestObject txfOvlyCustName, btnOvlySearch, btnOvlySelect
		txfOvlyCustName = createTestObject("txfOvlyCustName", "id", "uclCust_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
		btnOvlySearch	= createTestObject("btnOvlySearch", "id", "uclCust_uclCust_umd_ctl00_ucS_lbSearch")
		btnOvlySelect	= createTestObject("btnOvlySelect", "id", "uclCust_uclCust_umd_ctl00_gvL_hpSelect_0")

		safetyClick(btnSearchAgreementNo)
		safetyInput(txfOvlyCustName, "%")
		WebUI.takeScreenshot()
		if(WebUI.verifyElementPresent(btnOvlySelect, 2)) {
			safetyClick(btnOvlySelect)
			WebUI.takeScreenshot()
		} else {
			KeywordUtil.markFailed("$customerName Not found, please check again!.")
		}
	}

	public void clickAllMandatoryCheckboxes() {
		List<WebElement>  checkboxes = getListElementByTestObject("//input[@type='checkbox' and contains(@id, 'cbChecked')]")
		if (checkboxes.isEmpty()) {
			WebUI.comment("No checkboxes found.")
			return
		}

		WebUI.comment("Found ${checkboxes.size()} checkboxes.")

		for (WebElement checkbox : checkboxes) {
			if (!checkbox.isSelected()) {
				checkbox.click()
				WebUI.comment("Clicked checkbox with id: ${checkbox.getAttribute('id')}.")
				WebUI.delay(0.5)
			} else {
				WebUI.comment("Checkbox with id: ${checkbox.getAttribute('id')} is already selected, skipping.")
			}
		}
		WebUI.takeScreenshot()
		
	}
	private void clickSaveAggreement() {
		safetyClick(btnSave)
		WebUI.delay(2)
		WebUI.takeScreenshot()
	}

	public void inputApprovalRequest(String note, String reason, String approver) {
		clickExpandSection("APPROVAL REQUEST")
		WebUI.delay(0.5)
		
		safetySelect(drpReasonDescription, reason)
		WebUI.delay(0.5)
		
		safetySelect(drpApprover, approver)
		WebUI.delay(0.5)

		safetyInput(txfNotes, note)	
		WebUI.delay(0.5)
		
		safetyClick(btnSubmit)
		WebUI.delay(0.5)
		
		WebUI.takeScreenshot()
	}

	private void clickExpandSection(String sectionName) {
		TestObject expandButton = createTestObject("expandButton", "id", "//a[contains(normalize-space(text()), '[+]') and contains(text(), '" + sectionName + "')]")

		if (WebUI.verifyElementPresent(expandButton, 2, FailureHandling.OPTIONAL)) {
			WebUI.scrollToElement(expandButton, 2)
			WebUI.click(expandButton)
			WebUI.comment("Expand section '${sectionName}' clicked.")
		} else {
			WebUI.comment("Expand section '${sectionName}' not found.")
		}
	}
}
