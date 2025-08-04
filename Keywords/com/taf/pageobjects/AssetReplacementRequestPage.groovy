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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class AssetReplacementRequestPage extends BaseHelper{
	
	//look up
	private TestObject btnLookUp		= createTestObject("btnLookUp", "xpath", "")
	private TestObject txtAssetName		= createTestObject("txtAssetName", "xpath", "")
	private TestObject btnSearch		= createTestObject("btnSearch", "xpath", "")
	
	
	//asset
	private TestObject txtAssetPrice	= createTestObject("txtAssetPrice", "xpath", "")
	private TestObject btnPenAsset		= createTestObject("btnPenAsset", "xpath", "")
	
	//asset data
	private TestObject txtNoMesin		= createTestObject("txtNoMesin", "xpath", "")
	private TestObject txtNoRangka		= createTestObject("txtNoRangka", "xpath", "")
	private TestObject txtLicensePlat	= createTestObject("txtLicensePlat", "xpath", "")
	private TestObject drpAssetUsage	= createTestObject("drpAssetUsage", "xpath", "")
	private TestObject txtManufacYear	= createTestObject("txtManufacYear", "xpath", "")
	
	//asset attribute
	private TestObject txtMadeIn		= createTestObject("txtMadeIn", "xpath", "")
	private TestObject txtCilinder		= createTestObject("txtCilinder", "xpath", "")
	private TestObject txtTransmittion	= createTestObject("txtTransmittion", "xpath", "")
	private TestObject txtColor			= createTestObject("txtColor", "xpath", "")
	private TestObject drpRegion		= createTestObject("drpRegion", "xpath", "")
	
	//asset owner
	private TestObject txtOwnerName		= createTestObject("txtOwnerName", "xpath", "")
	private TestObject drpIdType		= createTestObject("drpIdType", "xpath", "")
	private TestObject txtOwnerId		= createTestObject("txtOwnerId", "xpath", "")
	private TestObject drpOwnerRelation	= createTestObject("drpOwnerRelation", "xpath", "")
	private TestObject btnCopyAddress	= createTestObject("btnCopyAddress", "xpath", "")
	private TestObject txtRT			= createTestObject("txtRT", "xpath", "")
	private TestObject txtRW			= createTestObject("txtRW", "xpath", "")
	private TestObject txtZipCode		= createTestObject("txtZipCode", "xpath", "")
	private TestObject txtDistrict		= createTestObject("txtDistrict", "xpath", "")
	private TestObject txtSubDistrict	= createTestObject("txtSubDistrict", "xpath", "")
	private TestObject txtCity			= createTestObject("txtCity", "xpath", "")
	
	//insurance owner
	private TestObject txtInscoBranchName	= createTestObject("txtInscoBranchName", "xpath", "")
	private TestObject txtPolicyName	= createTestObject("txtPolicyName", "xpath", "")
	private TestObject txtShortDate		= createTestObject("txtShortDate", "xpath", "")
	private TestObject txtPolicyNumber	= createTestObject("txtPolicyNumber", "xpath", "")
	private TestObject txtSumInsured	= createTestObject("txtSumInsured", "xpath", "")
	private TestObject txtEndDate		= createTestObject("txtEndDate", "xpath", "")
	private TestObject btnSave			= createTestObject("btnSave", "xpath", "")
	
	//asset list
	private TestObject chkAssetList		= createTestObject("chkAssetList", "xpath", "")
	private TestObject btnNext			= createTestObject("btnNext", "xpath", "")
	
	//approval request
	private TestObject sectionApprovalRequest	= createTestObject("sectionApprovalRequest", "xpath", "")
	private TestObject drpReasonDescription		= createTestObject("drpReasonDescription", "xpath", "")
	private TestObject drpApprover		= createTestObject("drpApprover", "xpath", "")
	private TestObject txtNotes			= createTestObject("txtNotes", "xpath", "")
	private TestObject btnSubmit		= createTestObject("btnSubmit", "xpath", "")
	
	//all notification
	private TestObject lblNotification	= createTestObject("lblNotification", "xpath", "")
	
	
	public void searchAssetName(String assName) {
		
		WebUI.click(btnLookUp)
		//pop up
		WebUI.setText(txtAssetName, assName)
		WebUI.click(btnSearch)
		
		//select based on asset name
		TestObject btnSelect		= createTestObject("btnSelect", "xpath", "")
		WebUI.click(btnSelect)
		
	}
	
	public void asset(String assPrice) {
		
		WebUI.setText(txtAssetPrice, assPrice)
		WebUI.click(btnPenAsset)
		
	}
	
	public void inputAssetData(String noMesin, String noRangka, String licensePlat, String condition, String usage, String year) {
		
		WebUI.setText(txtNoMesin, noMesin)
		WebUI.setText(txtNoRangka, noRangka)
		WebUI.setText(txtLicensePlat, licensePlat)
		
		//select radio button based on condition
		TestObject rdnAssetCondition= createTestObject("btnAssetCondition", "xpath", "")
		WebUI.click(rdnAssetCondition)
		
		WebUI.selectOptionByLabel(drpAssetUsage, usage, false)
		WebUI.setText(txtManufacYear, year)
		
	}
	
	public void inputAssetAttribute(String madeIn, String cilinder, String transmition, String color, String region) {
		
		WebUI.setText(txtMadeIn, madeIn)
		WebUI.setText(txtCilinder, cilinder)
		WebUI.setText(txtTransmittion, transmition)
		WebUI.setText(txtCilinder, color)
		WebUI.selectOptionByLabel(drpRegion, region, false)
		
	}
	
	public void inputAssetOwner(String name, String idType, String idNo, String relation, String RT, String RW, String zipCode, String district, String subDistrict, String city) {
		
		WebUI.setText(txtOwnerName, name)
		WebUI.selectOptionByLabel(drpIdType, idType, false)
		WebUI.setText(txtOwnerId, idNo)
		WebUI.selectOptionByLabel(drpOwnerRelation, relation, false)
		
		WebUI.click(btnCopyAddress)
	
		WebUI.setText(txtRT, RT)
		WebUI.setText(txtRW, RW)
		WebUI.setText(txtZipCode, zipCode)
		WebUI.setText(txtDistrict, district)
		WebUI.setText(txtSubDistrict, subDistrict)
		WebUI.setText(txtCity, city)
	}
	
	public void inputIssuranceOwner(String branchName, String policyName, String date, String policyNumber, String sumIns, String endDate) {
		
		WebUI.setText(txtInscoBranchName, branchName)
		WebUI.setText(txtPolicyName, policyName)
		WebUI.setText(txtShortDate, date)
		WebUI.setText(txtPolicyNumber, policyNumber)
		WebUI.setText(txtSumInsured, sumIns)
		WebUI.setText(txtEndDate, endDate)
		WebUI.click(btnSave)
		
		WebUI.verifyElementVisible(lblNotification)
	}
	
	public void assetList() {
		
		WebUI.check(chkAssetList)
		WebUI.click(btnNext)
		
	}
	
	public void approval(String reason, String approver, String note) {
		
		WebUI.click(sectionApprovalRequest)
		WebUI.selectOptionByLabel(drpReasonDescription, reason, false)
		WebUI.selectOptionByLabel(drpApprover, approver, false)
		WebUI.setText(txtNotes, note)
		WebUI.click(btnSubmit)
		
		WebUI.verifyElementVisible(lblNotification)
		
	}
}
