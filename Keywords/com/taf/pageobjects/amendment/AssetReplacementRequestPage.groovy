package com.taf.pageobjects.amendment

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.devtools.v135.security.model.SafetyTipInfo

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
	private TestObject btnLookUp		= createTestObject("btnLookUp", "xpath", "//input[@id = 'gvAssetReplace_ucLookupMaster_0_uclMaster_0_imb_0']")
	private TestObject txtAssetName		= createTestObject("txtAssetName", "xpath", "//input[@id ='gvAssetReplace_ucLookupMaster_0_uclMaster_0_umd_0_ctl00_0_ucS_0_rptFixedSearch_0_txtSearchValue_0']")
	private TestObject btnSearch		= createTestObject("btnSearch", "xpath", "//a[@id ='gvAssetReplace_ucLookupMaster_0_uclMaster_0_umd_0_ctl00_0_ucS_0_lbSearch_0']")


	//asset
	private TestObject txtAssetPrice	= createTestObject("txtAssetPrice", "xpath", "//input[@id ='gvAssetReplace_ucAssetPrice_0_txtInput_0']")
	private TestObject btnPenAsset		= createTestObject("btnPenAsset", "xpath", "//input[@id ='gvAssetReplace_imbRegist_0']")

	//asset data
	private TestObject txtNoMesin		= createTestObject("txtNoMesin", "xpath", "//span[text() = 'No. Mesin']/following::input[1]")
	private TestObject txtNoRangka		= createTestObject("txtNoRangka", "xpath", "//span[text() = 'No. Rangka']/following::input[1]")
	private TestObject txtLicensePlat	= createTestObject("txtLicensePlat", "xpath", "//td[contains(text(), 'License Plate No')]/following::input[1]")
	private TestObject drpAssetUsage	= createTestObject("drpAssetUsage", "xpath", "//select[@id = 'ucAssetUsage_ddlReference']")
	private TestObject txtManufacYear	= createTestObject("txtManufacYear", "xpath", "//input[@id = 'txtManufacturingYear']")

	//asset attribute
	private TestObject txtMadeIn		= createTestObject("txtMadeIn", "xpath", "//span[text() = 'MADE IN']/following::input[1]")
	private TestObject txtCilinder		= createTestObject("txtCilinder", "xpath", "//span[text() = 'CYLINDER']/following::input[1]")
	private TestObject txtTransmittion	= createTestObject("txtTransmittion", "xpath", "//span[text() = 'TRANSMITION']/following::input[1]")
	private TestObject txtColor			= createTestObject("txtColor", "xpath", "//span[text() = 'COLOR']/following::input[1]")
	private TestObject drpRegion		= createTestObject("drpRegion", "xpath", "//span[text() = 'REGION']/following::select[1]")

	//asset owner
	private TestObject txtOwnerName		= createTestObject("txtOwnerName", "xpath", "//input[@id = 'txtOwnerName']")
	private TestObject drpIdType		= createTestObject("drpIdType", "xpath", "//select[@id = 'ucMrIdType_ddlReference']")
	private TestObject txtOwnerId		= createTestObject("txtOwnerId", "xpath", "//input[@id = 'txtIdNo']")
	private TestObject drpOwnerRelation	= createTestObject("drpOwnerRelation", "xpath", "//select[@id = 'ucOwnerRelation_ddlReference']")
	private TestObject drpAddressList	= createTestObject("drpAddressList", "xpath", "//select[@id = 'ucCopyAddrOwner_ddlReference']")
	private TestObject btnCopyAddress	= createTestObject("btnCopyAddress", "id", "lb_Form_Copy_OwnerAddr")
	private TestObject txtRT			= createTestObject("txtRT", "xpath", "//input[@id = 'ucOwnerAddr_txtRT']")
	private TestObject txtRW			= createTestObject("txtRW", "xpath", "//input[@id = 'ucOwnerAddr_txtRW']")
	
	//pop up
	private TestObject btnZipCode		= createTestObject("txtZipCode", "xpath", "//input[@id = 'ucOwnerAddr_ucLookupZipCode_uclZipCode_imb']")
	private TestObject txtZipCode		= createTestObject("txtZipCode", "xpath", "//input[@id = 'ucOwnerAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_3']")
	private TestObject btnSearchZip		= createTestObject("btnSearchZip", "id", "ucOwnerAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectZip		= createTestObject("btnSelectZip", "id", "ucOwnerAddr_ucLookupZipCode_uclZipCode_umd_ctl00_gvL_hpSelect_0")
	
	private TestObject txtDistrict		= createTestObject("txtDistrict", "xpath", "//input[@id = 'ucOwnerAddr_txtKelurahan']")
	private TestObject txtSubDistrict	= createTestObject("txtSubDistrict", "xpath", "//input[@id = 'ucOwnerAddr_txtKecamatan']")
	private TestObject txtCity			= createTestObject("txtCity", "xpath", "//input[@id = 'ucOwnerAddr_txtCity']")

	//insurance owner
	private TestObject txtInscoBranchName	= createTestObject("txtInscoBranchName", "xpath", "//input[@id = 'txtInscoBranchName']")
	private TestObject txtPolicyName	= createTestObject("txtPolicyName", "xpath", "//input[@id = 'txtPolicyName']")
	private TestObject txtShortDate		= createTestObject("txtShortDate", "xpath", "//input[@id = 'ucDPCustCoverStartDt_txtDatePicker']")
	private TestObject txtPolicyNumber	= createTestObject("txtPolicyNumber", "xpath", "//input[@id = 'txtPolicyNo']")
	private TestObject txtSumInsured	= createTestObject("txtSumInsured", "xpath", "//input[@id = 'ucSumIns_txtInput']")
	private TestObject txtEndDate		= createTestObject("txtEndDate", "xpath", "//input[@id = 'ucDPCustCoverEndDt_txtDatePicker']")
	private TestObject btnSave			= createTestObject("btnSave", "id", "lb_Toolbar_Save")

	//asset list
	private TestObject chkAssetList		= createTestObject("chkAssetList", "xpath", "//input[@id = 'gvAssetList_cbSelect_0']")
	private TestObject btnNext			= createTestObject("btnNext", "id", "lb_Toolbar_Next")

	//approval request
	private TestObject sectionApprovalRequest	= createTestObject("sectionApprovalRequest", "xpath", "")
	private TestObject drpReasonDescription		= createTestObject("drpReasonDescription", "xpath", "//select[@id = 'ucApproval_ddlReason']")
	private TestObject drpApprover		= createTestObject("drpApprover", "xpath", "//select[@id = 'ucApproval_ddlApvBy']")
	private TestObject txtNotes			= createTestObject("txtNotes", "xpath", "//textarea[@id = 'ucApproval_txtNotes']")
	private TestObject btnSubmit		= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")

	//all notification
	private TestObject lblNotification	= createTestObject("lblNotification", "xpath", "")


	public void searchAssetName(String assName) {

		safetyClick(btnLookUp, 1)
		//pop up
		safetyInput(txtAssetName, assName, 1)
		safetyClick(btnSearch, 10)

		//select based on first item
		TestObject btnSelect		= createTestObject("btnSelect", "xpath", "//a[@id 'gvAssetReplace_ucLookupMaster_0_uclMaster_0_umd_0_ctl00_0_gvL_0_hpSelect_0']")
		safetyClick(btnSelect, 2)
		WebUI.takeScreenshot()
	}

	public void inputAssetPrice(String assPrice) {

		manualClearText(txtAssetPrice)
		safetyInput(txtAssetPrice, assPrice, 1)
		safetyClick(btnPenAsset, 5)
	}

	public void inputAssetData(String noMesin, String noRangka, String licensePlat, String condition, String usage, String year) {

		safetyInput(txtNoMesin, noMesin, 2)
		safetyInput(txtNoRangka, noRangka, 2)
		safetyInput(txtLicensePlat, licensePlat, 2)

		//select radio button based on condition
		TestObject rdnAssetCondition= createTestObject("btnAssetCondition", "xpath", "//label[text() = '$condition']/preceding-sibling::input")
		WebUI.click(rdnAssetCondition)

		safetySelect(drpAssetUsage, usage, 2)
		safetyInput(txtManufacYear, year, 2)
	}

	public void inputAssetAttribute(String madeIn, String cilinder, String transmition, String color, String region) {

		safetyInput(txtMadeIn, madeIn, 1)
		safetyInput(txtCilinder, cilinder, 1)
		safetyInput(txtTransmittion, transmition, 1)
		safetyInput(txtCilinder, color, 1)
		safetySelect(drpRegion, region, 1)
		
		WebUI.takeScreenshot()
	}

	public void inputAssetOwner(String name, String idType, String idNo, String relation, String addresList, String RT, String RW, String zipCode, String district, String subDistrict, String city) {

		safetyInput(txtOwnerName, name, 1)
		safetySelect(drpIdType, idType, 1)
		safetyInput(txtOwnerId, idNo, 1)
		safetySelect(drpOwnerRelation, relation, 1)
		
		safetySelect(drpAddressList, addresList, 1)
		safetyClick(btnCopyAddress, 5)
		
		safetyInputEdit(txtRT, RT, 1)
		safetyInputEdit(txtRW, RW, 1)
		
		if(txtZipCode) {
			safetyClick(btnZipCode, 1)
			safetyInput(txtZipCode, zipCode, 1)
			safetyClick(btnSearchZip, 1)
			safetyClick(btnSelectZip, 1)
		}
		
		
		safetyInputEdit(txtDistrict, district, 1)
		safetyInputEdit(txtSubDistrict, subDistrict, 1)
		safetyInputEdit(txtCity, city, 1)
	}

	public void inputIssuranceOwner(String branchName, String policyName, String date, String policyNumber, String sumIns, String endDate) {

		safetyInput(txtInscoBranchName, branchName, 1)
		safetyInput(txtPolicyName, policyName, 1)
		safetyInput(txtShortDate, date, 1)
		clickTABKeyboard(txtShortDate)
		
		safetyInput(txtPolicyNumber, policyNumber, 1)
		safetyInput(txtSumInsured, sumIns, 1)
		safetyInput(txtEndDate, endDate, 1)
		clickTABKeyboard(txtEndDate)
		WebUI.takeScreenshot()
		safetyClick(btnSave, 5)
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
