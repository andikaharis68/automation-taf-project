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

public class FinancialDataPage extends BaseHelper {
	
	private TestObject lblSection				= createTestObject("lblSection","id", "ucToggleGridFinDataRegFixed_subSectionID")
	private TestObject btnSaveContinue			= createTestObject("btnSaveContinue", "id", "lb_Form_SaveCont")
	private TestObject btnCalculateFee			= createTestObject("btnCalculateFee", "id", "lb_Form_CalcFee")
	private TestObject btnCalculate				= createTestObject("btnCalculate", "id", "lbCalculateFees")
	private TestObject btnCalculateInstallment	= createTestObject("btnCalculateInstallment", "id", "lbCalculateFinancialData")
	
	
	private void verifyLandingInFinancialData() {
		verifyLanding(lblSection, "Financial Data")
	}
	
	private void clickSaveContinue() {
		safetyClick(btnSaveContinue)
	}
	private void clickCalculateFee() {
		safetyClick(btnCalculateFee)
	}
	
	private void clickCalculateInstallment() {
		safetyClick(btnCalculateInstallment)
	}
	private void clickCalculate() {
		safetyClick(btnCalculate)
	}
}
