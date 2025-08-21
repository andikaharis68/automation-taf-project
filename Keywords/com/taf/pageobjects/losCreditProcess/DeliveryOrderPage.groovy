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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class DeliveryOrderPage extends BaseHelper{

	private TestObject lblTitle				= createTestObject("lblTitle", "id", "pageTitle")
	private TestObject txfApplicationNo		= createTestObject("txfApplicationNo", "id", "ucSearch_txtAppNo_ltlAppAppNoSearch")
	private TestObject btnSearch			= createTestObject("btnSearch", "id", "ucSearch_btnSearch")

	//section delivery information
	private TestObject txfNoMesin			= createTestObject("txfNoMesin", "id", "txtSerialNo1")
	private TestObject txfNoRangka			= createTestObject("txfNoRangka", "id", "txtSerialNo2")

	//section asset attribute
	private TestObject txfMadeIn			= createTestObject("txfMadeIn", "id", "rptAssetAttr_txtAttrName_0")
	private TestObject txfCylinder			= createTestObject("txfCylinder", "id", "rptAssetAttr_txtAttrName_1")
	private TestObject txfTransmition		= createTestObject("txfTransmition", "id", "rptAssetAttr_txtAttrName_2")
	private TestObject txfColor				= createTestObject("txfColor", "id", "rptAssetAttr_txtAttrName_3")
	private TestObject txfRegion			= createTestObject("txfRegion", "id", "rptAssetAttr_txtAttrName_4")

	//section asset owner
	private TestObject txfAssetTaxDate		= createTestObject("txfAssetTaxDate", "id", "ucDPAssetTaxDt_txtDatePicker")

	//section main document letter
	private TestObject txfRegisLetterDate	= createTestObject("txfRegisLetterDate", "id", "ucDPSpMainDocDt_txtDatePicker")

	//section asset document
	private TestObject txfFaktur			= createTestObject("txfFaktur", "id", "gvAssetDoc_txtDocNo_1")

	private TestObject btnSave				= createTestObject("btnSave", "id", "lb_Toolbar_Save")

	private TestObject btnNext				= createTestObject("btnNext", "id", "lb_Toolbar_Next")
	private TestObject btnSubmit			= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	private TestObject iframeMain			= createTestObject("iframeMain", "id", "mainPage")


	private void verifyLandingPage() {
		WebUI.switchToFrame(iframeMain, 3)
		verifyLanding(lblTitle, "delivery order")
		WebUI.takeScreenshot()
	}
	
	private void searchTransaction(String appNo) {
		safetyInput(txfApplicationNo, appNo)
		WebUI.click(btnSearch)
	}

	private void editTransaction(String appNo) {
		TestObject rowExist = createTestObject("rowExist", "xpath", "//a[text() = '$appNo']")
		def exist = WebUI.verifyElementPresent(rowExist, 3, FailureHandling.OPTIONAL)

		if(rowExist) {
			TestObject btnPenEdit = createTestObject("btnPenEdit", "xpath", "${getXpath(rowExist)}/following::td[5]//input")
			WebUI.takeScreenshot()
			WebUI.click(btnPenEdit)
		}else {
			KeywordUtil.markFailedAndStop("reff no not exist $appNo")
		}
	}


	private void editAsset(String index) {
		WebUI.takeScreenshot()
		TestObject btnEdit = createTestObject("btnEdit", "xpath", "//input[@id = 'gvAssetList_ibDelOrd_$index']")
		WebUI.delay(2)
		WebUI.click(btnEdit)
	}

	private void inputDeliveryInformation(String noMesin, String noRangka) {
		safetyInput(txfNoMesin, noMesin)
		safetyInput(txfNoRangka, noRangka)
	}

	private void inputAssetAttribute(String made, String cilinder, String transmition, String color, String region) {
		safetyInput(txfMadeIn, made)
		safetyInput(txfCylinder, cilinder)
		safetyInput(txfTransmition, transmition)
		safetyInput(txfColor, color)
		safetyInputEdit(txfRegion, region)
		WebUI.takeScreenshot()
	}

	private void inputAssetOwner(String taxDate) {
		WebUI.scrollToElement(txfRegisLetterDate, 3)
		safetyInput(txfAssetTaxDate, taxDate)
		clickTABKeyboard(txfAssetTaxDate)
	}

	private void inputDocumentLetter(String date) {
		WebUI.delay(2)
		safetyInput(txfRegisLetterDate, date)
		clickTABKeyboard(txfRegisLetterDate)
	}


	private void clickAllCheckBox(String faktur) {
		def countMandatory = getListElementByTestObject("//span[contains(@id, 'gvAssetDoc_lblIsMandatory_')]") //mencari total mandatory
		def looping = countMandatory.size()
		looping.times { i -> 
			TestObject chkMandatory = createTestObject("chkMandatory", "xpath", "//span[@id = 'gvAssetDoc_lblIsMandatory_$i' and text() = 'Yes']/following::input[1]")
			def isMandatory = WebUI.verifyElementPresent(chkMandatory, 1, FailureHandling.OPTIONAL)
			if(isMandatory) {
				WebUI.click(chkMandatory)
				WebUI.delay(2)
			}
		}
		
		WebUI.setText(txfFaktur, faktur)
		WebUI.takeScreenshot()
	}

	private void clickSave() {
		WebUI.click(btnSave)
		WebUI.delay(3)
	}

	private void clickNext() {
		safetyClick(btnNext)
	}

	private void clickSubmit() {
		safetyClick(btnSubmit)
	}
}
