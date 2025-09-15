package com.taf.pageobjects.amendment

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

public class AssetDocumentRecievePage extends BaseHelper{


	private TestObject drpBranchAgreement	= createTestObject("drpBranchAgreement", "xpath", "")
	private TestObject txtAgreementNo		= createTestObject("txtAgreementNo", "xpath", "")
	private TestObject btnSearch			= createTestObject("btnSearch", "xpath", "")
	private TestObject icnRecieve			= createTestObject("icnRecieve", "xpath", "")
	private TestObject txtLicensePlate		= createTestObject("txtLicensePlate", "xpath", "")
	private TestObject txtRecieveForm		= createTestObject("txtRecieveForm", "xpath", "")
	private TestObject btnSubmit			= createTestObject("btnSubmit", "xpath", "")

	public void searchAsset(String branch, String agreementNo) {

		WebUI.selectOptionByLabel(drpBranchAgreement, branch, false)
		WebUI.setText(txtAgreementNo, agreementNo)
		WebUI.click(btnSearch)
		WebUI.click(icnRecieve)
	}

	public void inputAssetData(String plate, String form) {

		WebUI.setText(txtLicensePlate, plate)
		WebUI.setText(txtRecieveForm, form)
		WebUI.click(btnSubmit)
	}
}
