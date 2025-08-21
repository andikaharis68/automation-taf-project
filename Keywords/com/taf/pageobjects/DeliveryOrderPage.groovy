package com.taf.pageobjects

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
	
	private TestObject txfApplicationNo		= createTestObject("txfApplicationNo", "id", "")
	private TestObject btnSearch			= createTestObject("btnSearch", "id", "")
	
	//section delivery information
	private TestObject txfNoMesin			= createTestObject("txfNoMesin", "id", "")
	private TestObject txfNoRangka			= createTestObject("txfNoRangka", "id", "")
	
	//section asset attribute
	private TestObject txfMadeIn			= createTestObject("txfMadeIn", "id", "")
	private TestObject txfCylinder			= createTestObject("txfCylinder", "id", "")
	private TestObject txfTransmition		= createTestObject("txfTransmition", "id", "")
	private TestObject txfColor				= createTestObject("txfColor", "id", "")
	private TestObject txfRegion			= createTestObject("txfRegion", "id", "")
	
	//section asset owner
	private TestObject txfAssetTaxDate		= createTestObject("txfAssetTaxDate", "id", "")
	
	//section main document letter
	private TestObject txfRegisLetterDate	= createTestObject("txfRegisLetterDate", "id", "")
	
	//section asset document
	private TestObject txfFaktur			= createTestObject("txfFaktur", "id", "")
	
	private TestObject btnSave				= createTestObject("btnSave", "id", "")
	
	private TestObject btnNext				= createTestObject("btnNext", "id", "")
	private TestObject btnSubmit			= createTestObject("btnSubmit", "id", "")
	
	
	private void searchTransaction(String appNo) {
		safetyInput(txfApplicationNo, appNo)
		safetyClick(btnSearch)
	}
	
	private void editTransaction(String appNo) {
		TestObject rowExist = createTestObject("rowExist", "xpath", "")
		def exist = WebUI.verifyElementPresent(rowExist, 3, FailureHandling.OPTIONAL)
		
		if(rowExist) {
			TestObject btnPenEdit = createTestObject("btnPenEdit", "xpath", "")
			WebUI.takeScreenshot()
			safetyClick(btnPenEdit)
		}else {
			KeywordUtil.markFailedAndStop("reff no not exist $appNo")
		}
	}
	
	
	private void editAsset(String index) {
		//section list ofasset
		TestObject btnEdit = createTestObject("btnEdit", "xpath", "")
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
		safetyInput(txfAssetTaxDate, taxDate)
	}
	
	private void inputDocumentLetter(String date) {
		safetyInput(txfRegisLetterDate, date)
		WebUI.takeScreenshot()
	}
	
	
	private void clickAllCheckBox(String faktur) {
		//klik semua checkbox yang mandatory nya yes
		
		safetyInput(txfFaktur, faktur)
	}
	
	private void clickSave() {
		safetyClick(btnSave)
	}
	
	private void clickNext() {
		safetyClick(btnNext)
	}
	
	private void clickSubmit() {
		safetyClick(btnSubmit)
	}
}
