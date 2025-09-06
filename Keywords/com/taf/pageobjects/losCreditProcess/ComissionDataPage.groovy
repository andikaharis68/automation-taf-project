package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.OPTIONAL
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.By.ByTagName

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

public class ComissionDataPage extends BaseHelper {

	private TestObject lblSection			= createTestObject("lblSection","xpath","//*[@id='dCommission']/table/tbody/tr[1]/td[1]")
	private TestObject btnCalculate			= createTestObject("btnCalculate", "id", "lb_Form_Calculate")
	private TestObject btnSaveContinue		= createTestObject("btnSaveContinue", "id", "lb_Form_SaveCont")
	private TestObject btnAdd				= createTestObject("btnAdd", "id", "lb_Form_Add_SupplBranchEmp")
	private TestObject btnSearchBranchName	= createTestObject("btnSearchBranchName", "id", "gvSupplEmpCommission_uclSupplBrcBasedOnApp2_0_uclSupplBrcApp_0_imb_0")
	private TestObject txfOverlayBranchName = createTestObject("txfOverlayBranchName", "id", "gvSupplEmpCommission_uclSupplBrcBasedOnApp2_0_uclSupplBrcApp_0_umd_0_ctl00_0_ucS_0_rptFixedSearch_0_txtSearchValue_0")
	private TestObject btnOvlySearch		= createTestObject("btnOvlySearch", "id", "gvSupplEmpCommission_uclSupplBrcBasedOnApp2_0_uclSupplBrcApp_0_umd_0_ctl00_0_ucS_0_lbSearch_0")
	private TestObject btnOvlySelect		= createTestObject("btnOvlySelect", "id", "gvSupplEmpCommission_uclSupplBrcBasedOnApp2_0_uclSupplBrcApp_0_umd_0_ctl00_0_gvL_0_hpSelect_0")
	private TestObject drpEmployeeName		= createTestObject("drpEmployeeName", "id", "gvSupplEmpCommission_ucRefSupplBranchEmp_0_ddlReference_0")
	private TestObject txfDifOther			= createTestObject("txfDifOther", "id", "gvSupplEmpCommission_ucinRefundFromOth2_0_txtInput_0")

	private void verifyLandingInComissionData() {
		WebUI.delay(2)
		verifyLanding(btnCalculate, "Comission Data")
		WebUI.takeScreenshot()
	}
	private void clickCalculate() {
		safetyClick(btnCalculate)
		handleAlertIfPresent()
		WebUI.takeScreenshot()
	}

	private void clickSaveContinue() {
		safetyClick(btnSaveContinue)
	}

	private void searchSupplierBranchName(String branchName) {
		if(branchName && WebUI.verifyElementPresent(btnSearchBranchName, 2, OPTIONAL)) {
			safetyClick(btnSearchBranchName)
			WebUI.delay(0.5)

			safetyInput(txfOverlayBranchName, branchName)
			WebUI.delay(0.5)
			safetyClick(btnOvlySearch)
			WebUI.takeScreenshot()

			safetyClick(btnOvlySelect)
		}
	}

	private void selectEmployeeName(String name) {
		if(name && WebUI.verifyElementPresent(drpEmployeeName, 2, OPTIONAL)) {
			WebElement element = WebUI.findWebElement(drpEmployeeName)
			List<WebElement> options = element.findElements(By.tagName("option"))
			boolean isFound = false

			for (WebElement opt : options) {
				if (opt.getText().trim().equalsIgnoreCase(name)) {
					safetySelect(drpEmployeeName, name)
					isFound = true
					break
				}
			}
			isFound ? null : selectFirstOption(drpEmployeeName, name)
		
		} else {
			KeywordUtil.markWarning("Option not clickable or disabled")
		}
	}
	private void inputDifOther(String difOther) {
		if(difOther && WebUI.verifyElementPresent(txfDifOther, 2, OPTIONAL)) {
			manualClearText(txfDifOther)
			safetyInput(txfDifOther, difOther)
		}
	}

	private void addSupplierEmployeeSection(String branchName, String employeeName, String difOther) {
		if(branchName) {
			safetyClick(btnAdd)
			WebUI.takeScreenshot()
			searchSupplierBranchName(branchName)
			selectEmployeeName(employeeName)
			inputDifOther(difOther)
			WebUI.takeScreenshot()
		}
	}
}
