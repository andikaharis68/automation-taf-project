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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class ApplicationDataPage extends BaseHelper {
	
	private TestObject btnSaveContinue			= createTestObject("btnSaveContinue", "id", "lb_Form_SaveCont")
	private TestObject drpCopyAddressFrom		= createTestObject("drpCopyAddressFrom", "id", "lb_Form_CopyAddr")
	private TestObject btnCopyAddress			= createTestObject("btnCopyAddress", "id", "lb_Form_CopyAddr")

	private TestObject txfAddress				= createTestObject("txfAddress", "xpath", "//*[contains(@id, 'txtOfficeAddr')]")
	private TestObject txfRT					= createTestObject("txfRT", "xpath", "//*[contains(@id,'txtRT')]")
	private TestObject txfRW					= createTestObject("txfRW", "xpath", "//*[contains(@id,'txtRW')]")
	private TestObject txfZIPCode				= createTestObject("txfZIPCode", "xpath", "//*[contains(@id,'uclZipCode_txt')]")
	private TestObject btnSearchZIPCode			= createTestObject("btnSearchZIPCode", "xpath", "//*[contains(@id, 'uclZipCode_imb')]")
	private TestObject txfSubdistrict			= createTestObject("txfSubdistrict", "xpath", "//*[contains(@id, 'txtKelurahan')]")
	private TestObject txfDistrict				= createTestObject("txfDistrict", "xpath", "//*[contains(@id,'txtKecamatan')]")
	private TestObject txfCity					= createTestObject("txfCity", "xpath", "//*[contains(@id,'uctxtCity')]")
	
	
}
