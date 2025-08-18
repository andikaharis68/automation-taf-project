package com.taf.pageobjects.customers

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

public class CustomerInformationPage extends BaseHelper {

	private TestObject txfCustomerNo			= createTestObject("txfCustomerNo", "xpath", "//input[@id='ucSearch_txtCustNo_ltlCustCustNo']")
	private TestObject drpCustomerType			= createTestObject("drpCustomerType", "xpath", "//select[@id='ucSearch_ddlCustType_ltlCustCustType_ddlReference']")
	private TestObject txfAddress				= createTestObject("txfAddress", "xpath", "//input[@id='ucSearch_txtAddrTypeName_ltlCustAddrAddr']")
	private TestObject txfCustomerName			= createTestObject("txfCustomerName", "xpath", "//input[@id='ucSearch_txtCustName_ltlCustCustName']")
	private TestObject drpCustomerRating		= createTestObject("drpCustomerRating", "xpath", "//select[@id='ucSearch_ddlCustRating_ltlCustCustRating_ddlReference']")
	private TestObject btnSearch				= createTestObject("btnSearch", "xpath", "//input[@id='ucSearch_btnSearch']")
	private TestObject btnReset					= createTestObject("btnReset", "xpath", "//a[@id='ucSearch_lbReset']")

	private TestObject btnAddPersonalCustomer	= createTestObject("btnAddPersonalCustomer", "xpath", "//a[@id='lb_Toolbar_AddPersonal']")
	private TestObject btnAddCompanyCustomer	= createTestObject("btnAddCompanyCustomer", "xpath", "//a[@id='lb_Toolbar_AddCompany']")

	private TestObject iframeMainpage 			= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")


	private void verifyLandingInCustInfoPage() {
		verifyLanding(txfCustomerNo, "Customer Information")
	}

	private void inputCustomerName(String name) {
		WebUI.setText(txfCustomerName, name)
	}

	private void selectCustomerType(String customerType) {
		WebUI.selectOptionByLabel(drpCustomerType, customerType, false)
	}

	private void inputAddress(String address) {
		WebUI.setText(txfAddress, address)
	}

	private void inputCustomerNo(String customerNo) {
		WebUI.setText(txfCustomerNo, customerNo)
	}
	private void selectCustomerRating(String customerRating) {
		WebUI.selectOptionByLabel(drpCustomerRating, customerRating, false)
	}
	private void clickSearch() {
		WebUI.click(btnSearch)
	}

	private void clickReset() {
		WebUI.click(btnReset)
	}
	private void addPersonalCustomer() {
		WebUI.click(btnAddPersonalCustomer)
	}
	private void addCompanyCustomer() {
		WebUI.click(btnAddCompanyCustomer)
	}
	private void switchToIframeMain() {
		WebUI.switchToFrame(iframeMainpage, 1)
	}

	private void switchToDefaultContent() {
		WebUI.switchToDefaultContent()
	}
}
