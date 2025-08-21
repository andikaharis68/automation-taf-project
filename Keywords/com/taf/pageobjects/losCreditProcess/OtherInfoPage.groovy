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

public class OtherInfoPage extends BaseHelper {
	
	private TestObject drpContactEmployee	= createTestObject("drpContactEmployee", "id", "rptAttribute_ucrefInputAttr_0_ddlReference_0") 
	private TestObject drpRentalBussiness	= createTestObject("drpRentalBussiness", "id","rptAttribute_ucrefInputAttr_1_ddlReference_1")  
	private TestObject drpAssetforOnline	= createTestObject("drpAssetforOnline", "id", "rptAttribute_ucrefInputAttr_2_ddlReference_2") 
	private TestObject drpFraudIndication	= createTestObject("drpFraudIndication", "id", "rptAttribute_ucrefInputAttr_3_ddlReference_3")
	private TestObject drpHighRiskCustomer	= createTestObject("drpHighRiskCustomer", "id", "rptAttribute_ucrefInputAttr_4_ddlReference_4")
	private TestObject drpHighRiskBusiness	= createTestObject("drpHighRiskBusiness", "id", "rptAttribute_ucrefInputAttr_5_ddlReference_5")
	private TestObject drpCreditApproval	= createTestObject("drpCreditApproval", "id", "rptAttribute_ucrefInputAttr_6_ddlReference_6")
	private TestObject drpOwnedVehicle		= createTestObject("drpOwnedVehicle", "id", "rptAttribute_ucrefInputAttr_11_ddlReference_11")
	private TestObject drpPrioritySeal		= createTestObject("drpPrioritySeal", "id", "rptAttribute_ucrefInputAttr_12_ddlReference_12") 
	private TestObject txfNPWP				= createTestObject("txfNPWP", "id", "rptAttribute_ucrefInputAttr_13_ddlReference_13")
	private TestObject txfNomorSK			= createTestObject("txfNomorSK", "id", "rptAttribute_ucrefInputAttr_14_ddlReference_14")
	private TestObject drpSTNKinAHU			= createTestObject("drpSTNKinAHU", "id", "rptAttribute_ucrefInputAttr_15_ddlReference_15")
	private TestObject drpStatusKepemilikan	= createTestObject("drpStatusKepemilikan", "id", "rptAttribute_ucrefInputAttr_16_ddlReference_16")
	private TestObject drpCDENotes			= createTestObject("drpCDENotes", "id", "rptAttribute_ucrefInputAttr_17_ddlReference_17")
	private TestObject btnSave				= createTestObject("btnSave", "id", "lb_Form_Save")
	
	private void verifyLandingInOtherInfoPage() {
		verifyLanding(drpContactEmployee, "Other Info")
	}
	
	private void selectContractEmployee(String contractEmployee) {
		safetySelect(drpContactEmployee, contractEmployee)
	}
	private void selectRentalBussiness(String rentalBussiness) {
		safetySelect(drpRentalBussiness, rentalBussiness)
	}
	private void selectAssetforOnlienTransport(String assetForOnline) {
		safetySelect(drpAssetforOnline, assetForOnline)
	}
	private void selectFraudIndication(String fraudIndication) {
		safetySelect(drpFraudIndication, fraudIndication)
	}
	private void selectHighRiskCustomer(String highRiskCust) {
		safetySelect(drpHighRiskCustomer, highRiskCust)
	}
	private void selectHighRiskBussiness(String hightRiskBussiness) {
		safetySelect(drpHighRiskBusiness, hightRiskBussiness)
	}
	
	private void selectCreditApprovalProcess(String creditApproval) {
		safetySelect(drpCreditApproval, creditApproval)
	}
	
	private void selectOwnedVehicle(String ownedVehicle) {
		safetySelect(drpOwnedVehicle, ownedVehicle)
	}
	private void selectPrioritySeal(String prioritySeal) {
		safetySelect(drpPrioritySeal, prioritySeal)
	}
	private void inputNPWP(String npwp) {
		safetyInput(txfNPWP, npwp)
	}
	
	private void inputNomorSK(String nomorSK) {
		safetyInput(txfNomorSK, nomorSK)
	}
	private void selectStnk(String stnk) {
		safetySelect(drpSTNKinAHU, stnk)
	} 
	private void selectStatusKepemilikanNPWP(String status) {
		safetySelect(drpStatusKepemilikan, status)
	}
	
	private void selectCDEnotes(String notes) {
		safetySelect(drpCDENotes, notes)
	}
	private void clickSave() {
		safetyClick(btnSave)
	}
}

