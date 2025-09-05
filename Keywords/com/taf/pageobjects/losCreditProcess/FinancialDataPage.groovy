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
	private TestObject btnCalculate				= createTestObject("btnCalculate", "xpath", "//*[@id='lbCalculateFees']") 
	private TestObject btnCalculateInstallment	= createTestObject("btnCalculateInstallment", "id", "lbCalculateFinancialData")
	
	private TestObject txfAdminFeeAmount		= createTestObject("txfAdminFeeAmount", "id", "ucINAdminFeeAmt_txtInput")
	private TestObject txfNotaryAmount			= createTestObject("txfNotaryAmount", "id", "ucINNotaryFeeAmt_txtInput")
	private TestObject txfAdditionalAdminFee	= createTestObject("txfAdditionalAdminFee", "id", "ucINAddAdminFeeAmt_txtInput")
	private TestObject txfOtherFee				= createTestObject("txfOtherFee", "id", "ucINOtherFeeAmt_txtInput") 
	private TestObject txfProvisionPercentage	= createTestObject("txfProvisionPercentage", "id", "ucINProvisionFeePrcnt_txtInput")
	private TestObject txfResidualValue			= createTestObject("txfResidualValue", "id", "ucINResidualValueAmt_txtInput")
	private TestObject drpRate					= createTestObject("drpRate", "id", "ucRefRate_ddlReference")
	private TestObject txfMargin				= createTestObject("txfMargin", "id", "ucINRate_txtInput") 
	private TestObject txfGracePeriod			= createTestObject("txfGracePeriod", "id", "ucINGracePeriod_txtInput") 
	private TestObject drpGracePeriod			= createTestObject("drpGracePeriod", "id", "ucRefGracePeriodType_ddlReference") 
	private TestObject txfSpread				= createTestObject("txfSpread", "id", "ucINSpread_txtInput") 
	private TestObject txfTDPPaidAtCompany		= createTestObject("txfTDPPaidAtCompany", "id", "ucINTDPPaidCoyAmt_txtInput") 
	private TestObject drpSubsidySupplier		= createTestObject("drpSubsidySupplier", "id", "ucRefComSub_ddlReference")
	private TestObject txfSubsidyRate			= createTestObject("txfSubsidyRate", "id", "ucINDiffRateAmt_txtInput") 
	private TestObject txfFiduciaAmount			= createTestObject("txfFiduciaAmount", "id", "ucINFiduciaFeeAmt_txtInput")
	
	
	private void verifyLandingInFinancialData() {
		verifyLanding(lblSection, "Financial Data")
		WebUI.takeScreenshot()
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
	private void inputAdminFeeAmount(String amount) {
		if(amount) {
			manualClearText(txfAdminFeeAmount)
			safetyInput(txfAdminFeeAmount, amount)
			WebUI.delay(1)
		}
	}
	
	private void inputAdminNotaryAmount(String amount) {
		if(amount) {
			manualClearText(txfNotaryAmount)
			safetyInput(txfNotaryAmount, amount)
			WebUI.delay(1)
		}
	}
	
	private void inputAdditionalAdminFee(String amount) {
		if(amount) {
			manualClearText(txfAdditionalAdminFee)
			safetyInput(txfAdditionalAdminFee, amount)
			WebUI.delay(1)
		}
	}
	private void inputOtherFee(String amount) {
		if(amount) {
			manualClearText(txfOtherFee)
			safetyInput(txfOtherFee, amount)
			WebUI.delay(1)
		}
	}
	private void inputProvisionAmount(String amount) {
		if(amount) {
			manualClearText(txfProvisionPercentage)
			safetyInput(txfProvisionPercentage, amount)
			WebUI.delay(1)
		}
	}
	
	private void inputFee(String adminAmount, String notaryAmount, String additionalFee, String otherFee) {
		inputAdminFeeAmount(adminAmount)
		inputAdminNotaryAmount(notaryAmount)
		inputAdditionalAdminFee(additionalFee)
		inputOtherFee(otherFee)
	}
	
	private void selectProvisionType(String type) {
		if(type) {
			TestObject radType = createTestObject("radType","xpath","//label[normalize-space(text())='${type}']/preceding-sibling::input[@type='radio']")
			safetyClick(radType)
			WebUI.delay(1)
		}
		
	}
	
	private void inputProvisionFee(String type, String provisionAmount) {
		selectProvisionType(type)
		inputProvisionAmount(provisionAmount)
	}
	private void selectFiduciaOption(String option) {
		if(option) {
			TestObject radType = createTestObject("radType","xpath","//label[normalize-space(text())='${option}']/preceding-sibling::input[@type='radio']")
			safetyClick(radType)
			WebUI.delay(1)
		}
		
	}
	
	
	private void inputFiduciaFeeAmount(String amount) {
		if(amount) {
			manualClearText(txfFiduciaAmount)
			safetyInput(txfFiduciaAmount, amount)
			WebUI.delay(1)
		}
	}
	
	private void inputFiduciary(String option, String amount) {
		selectFiduciaOption(option)
		inputFiduciaFeeAmount(amount)
	}
	
	private void inputResidualValue(String residualValue) {
		if(residualValue) {
			manualClearText(txfResidualValue)
			safetyInput(txfResidualValue, residualValue)
			WebUI.delay(1)
		}
	}
	private void selectRate(String rate) {
		if(rate) {
			safetySelect(drpRate, rate)
			WebUI.delay(1)
		}
	}
	private void inputMargin(String margin) {
		if(margin) {
			manualClearText(txfMargin)
			safetyInput(txfMargin, margin)
			WebUI.delay(1)
		}
	}
	
	private void inputGracePeriod(String period) {
		if(period) {
			manualClearText(txfGracePeriod)
			safetyInput(txfGracePeriod, period)
			WebUI.delay(1)
		}
	}
	private void selectGracePeriod(String period) {
		if(period) {
			safetySelect(drpGracePeriod, period)
			WebUI.delay(1)
		}
	}
	private void inputSpread(String spread) {
		if(spread) {
			manualClearText(txfSpread)
			safetyInput(txfSpread, spread)
			WebUI.delay(1)
		}
	}
	private void inputPaidAtCompany(String amount) {
		if(amount) {
			manualClearText(txfTDPPaidAtCompany)
			safetyInput(txfTDPPaidAtCompany, amount)
			WebUI.delay(1)
		}
	}
	private void selectSubsidySupplier(String subsidy) {
		if(subsidy) {
			safetySelect(drpSubsidySupplier, subsidy)
			WebUI.delay(1)
		}
	}
	
	private void inputSubsidyRate(String rate) {
		if(rate) {
			manualClearText(txfSubsidyRate)
			safetyInput(txfSubsidyRate, rate)
			WebUI.delay(1)
		}
	}
	
	private void inputFinancialData(String residualValue, String rate, String margin, String graceAmount, String gracePeriod, String spread,
		String paid, String subsidySupplier, String subsidyRate) {
		
		inputResidualValue(residualValue)
		selectRate(rate)
		inputMargin(margin)
		inputGracePeriod(graceAmount)
		selectGracePeriod(gracePeriod)
		inputSpread(spread)
		inputPaidAtCompany(paid)
		selectSubsidySupplier(subsidySupplier)
		inputSubsidyRate(subsidyRate)
	}
	
	
}
 