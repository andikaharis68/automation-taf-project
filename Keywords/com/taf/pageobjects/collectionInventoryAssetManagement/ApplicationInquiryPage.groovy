package com.taf.pageobjects.collectionInventoryAssetManagement

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

public class ApplicationInquiryPage extends BaseHelper {
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "", "")
	private TestObject lblAgreementNo = createTestObject("txtOffice", "", "")
	private TestObject txfAgreementNo = createTestObject("txfAgreementNo", "", "")
	private TestObject btnSearch = createTestObject("btnSearch", "", "")

	//table
	private TestObject lblAgreementNoTable = createTestObject("lblAgreementNoTable", "", "")
	private TestObject txtAgreementNoTable = createTestObject("txtAgreementNoTable", "", "")

	//detail
	private TestObject lblAmortization = createTestObject("lblAmortization", "", "")
	private TestObject btnCollection = createTestObject("btnCollection", "", "")

	//detail - inventory info
	private TestObject txtOSPrinciple = createTestObject("txtOSPrinciple", "", "")
	private TestObject txtInterestDue = createTestObject("txtInterestDue", "", "")
	private TestObject txtRepossessionFee = createTestObject("txtRepossessionFee", "", "")
	private TestObject txtInventoryAmount = createTestObject("txtInventoryAmount", "", "")
	private TestObject txtInventoryRecoveryAmount = createTestObject("txtInventoryRecoveryAmount", "", "")
	private TestObject txtInventoryDate = createTestObject("txtInventoryDate", "", "")

	//detail - inventory selling receive info
	private TestObject txtReceiveNo = createTestObject("txtReceiveNo", "", "")
	private TestObject txtAssetName = createTestObject("txtAssetName", "", "")
	private TestObject txtSellingAmount = createTestObject("txtSellingAmount", "", "")
	private TestObject txtBankAccount = createTestObject("txtBankAccount", "", "")
	private TestObject txtPostDate = createTestObject("txtPostDate", "", "")
	private TestObject txtValueDate = createTestObject("txtValueDate", "", "")

	//detail - asset info
	private TestObject txtAssetDesc = createTestObject("txtAssetDesc", "", "")
	private TestObject txtEngineNo = createTestObject("txtEngineNo", "", "")
	private TestObject txtPool = createTestObject("txtPool", "", "")
	private TestObject txtLicensePlat = createTestObject("txtLicensePlat", "", "")
	private TestObject txtChassisNo = createTestObject("txtChassisNo", "", "")
	private TestObject txtLocStatus = createTestObject("txtLocStatus", "", "")

	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Asset Inventory Inquiry Page")
	}

	public void doSearch(String agreementNo) {
		WebUI.setText(txfAgreementNo, agreementNo)
		WebUI.click(btnSearch)
	}

	public void clickAgreementNo(String agreementNo) {
		txtAgreementNoTable = createTestObject("txtAgreementNoTable", "text", "$agreementNo")
		WebUI.click(txtAgreementNoTable)
	}

	public void clickAmortization() {
		WebUI.click(lblAmortization)
	}

	public void verifyDetailInventoryInfo(String osPrinciple, interestDue, repossessionFee, inventoryAmount, inventoryRecoveryAmount, inventoryDate) {
		//ini lumayan banyak jadi nanti verify data sesuai yg diinputkan pada scenario2 sebelumnya
		//TBD : perlu nanya apa aja yg di verif, sementara ini dulu
		List<TestObject> actualList = [
			txtOSPrinciple,
			txtInterestDue,
			txtRepossessionFee,
			txtInventoryAmount,
			txtInventoryRecoveryAmount,
			txtInventoryDate
		]

		List<String> expectedList = [
			osPrinciple,
			interestDue,
			repossessionFee,
			inventoryAmount,
			inventoryRecoveryAmount,
			inventoryDate
		]

		for (int i = 0; i < actualList.size(); i++) {
			String actual = WebUI.getText(actualList[i])
			String expected = expectedList[i]
			validateIsEquals(actual, expected)
		}
	}

	public void verifyDetailSellingReceiveInfo(String receiveNo, assetName, sellingAmount, bankAccount, postDate, valueDate) {
		List<TestObject> actualList = [
			txtReceiveNo,
			txtAssetName,
			txtSellingAmount,
			txtBankAccount,
			txtPostDate,
			txtValueDate
		]

		List<String> expectedList = [
			receiveNo,
			assetName,
			sellingAmount,
			bankAccount,
			postDate,
			valueDate
		]

		for (int i = 0; i < actualList.size(); i++) {
			String actual = WebUI.getText(actualList[i])
			String expected = expectedList[i]
			validateIsEquals(actual, expected)
		}
	}

	public void verifyDetailAssetInfo(String assetDesc, engineNo, pool, licenseplat, chassisNo, locStatus) {
		List<TestObject> actualList = [
			txtAssetDesc,
			txtEngineNo,
			txtPool,
			txtLicensePlat,
			txtChassisNo,
			txtLocStatus
		]

		List<String> expectedList = [
			assetDesc,
			engineNo,
			pool,
			licenseplat,
			chassisNo,
			locStatus
		]

		for (int i = 0; i < actualList.size(); i++) {
			String actual = WebUI.getText(actualList[i])
			String expected = expectedList[i]
			validateIsEquals(actual, expected)
		}
	}
}
