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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class CreditSimulation extends BaseHelper {
	//iFrame 
	private TestObject iframeMainpage 						= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")
	
	//header
	private TestObject lblTitle								= createTestObject("lblTitle", "", "")
	private TestObject btnAdd								= createTestObject("btnAdd", "id", "lb_Toolbar_Add")
	private TestObject btnNext								= createTestObject("btnNext", "", "")
	private TestObject btnGenerate							= createTestObject("btnGenerate", "", "")

	//main information
	private TestObject txfCustomerName						= createTestObject("txfCustomerName", "id", "txtCustName")
	private TestObject txtCustomerType						= createTestObject("txtCustomerType", "xpath", "//*[text() = 'Personal']")
	private TestObject txfNumOfAsset						= createTestObject("txfNumOfAsset", "id", "ucINNumOfAsset_txtInput")
	private TestObject drpMaritalStatus						= createTestObject("drpMaritalStatus", "id", "ucMrMaritalStat_ddlReference")
	private TestObject txtMaritalStatus
	private TestObject icoLookUpProductOffering				= createTestObject("icoLookUpProductOffering", "id", "ucLookupProdOffer_uclProductOffering_imb")
	//main information - product offering lookup
	private TestObject txfProductOfferingCode				= createTestObject("txfProductOfferingCode", "id", "ucLookupProdOffer_uclProductOffering_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject btnSearch							= createTestObject("btnSearch", "id", "ucLookupProdOffer_uclProductOffering_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelect							= createTestObject("btnSelect", "id", "ucLookupProdOffer_uclProductOffering_umd_ctl00_gvL_hpSelect_0")

	//Application Data
	private TestObject txftenor								= createTestObject("txftenor", "id", "ucINTenor_txtInput")
	private TestObject drpInstallmentScheme					= createTestObject("drpInstallmentScheme", "id", "ucRefInstScheme_ddlReference")
	private TestObject drpPaymentFrequency					= createTestObject("drpPaymentFrequency", "id", "ucRefPaymentFreq_ddlReference")

	//Life Insurance Data
	private TestObject chkCoverLifeInsurance				= createTestObject("chkCoverLifeInsurance", "id", "cbIsCoverLifeIns")
	private TestObject drpLifeInscoBranchName				= createTestObject("drpLifeInscoBranchName", "id", "ddlLifeInscoName")
	private TestObject chkCustomer							= createTestObject("chkCustomer", "id", "cblCustomerInsured_0") // customer Insured - kalo butuh tambahkan juga yg chkSpouse
	private TestObject drpPaymentPremiumMethod				= createTestObject("drpPaymentPremiumMethod", "id", "ddlPaymentMethod")

	//Asset Data
	private TestObject icoLookUpSupplierBranchName			= createTestObject("icoLookUpSupplierBranchName", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_imb")
	private TestObject icoLookUpAssetName					= createTestObject("icoLookUpAssetName", "id", "ucLookupAssetMaster_uclMaster_imb")
	private TestObject txfAssetPrice						= createTestObject("txfAssetPrice", "id", "ucAssetPrice_txtInput")
	private TestObject txfDownPayment						= createTestObject("txfDownPayment", "id", "ucDownPaymentPrcnt_txtInput")
	private TestObject drpAssetUsage 						= createTestObject("drpAssetUsage", "id", "ucAssetUsage_ddlReference")
	private TestObject btnAddAsset							= createTestObject("btnAddAsset", "id", "lb_Form_Add")
	private TestObject btnSaveAsset							= createTestObject("btnSaveAsset", "id", "lb_Form_Save_AddEdit")
	private TestObject txtDpType
	//Asset Data - Supplier branch name
	private TestObject txfSuppBranchName					= createTestObject("txfSuppBranchName", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject btnSearchSuppBranch					= createTestObject("btnSearchSuppBranch", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectSuppBranch					= createTestObject("btnSelectSuppBranch", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_gvL_hpSelect_0")
	//Asset Data - Asset name LookUp
	private TestObject txfAssetName							= createTestObject("txfAssetName", "id", "ucLookupAssetMaster_uclMaster_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject btnSeacrhAssetName					= createTestObject("btnSeacrhAssetName", "id", "ucLookupAssetMaster_uclMaster_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectAssetName					= createTestObject("btnSelectAssetName", "id", "ucLookupAssetMaster_uclMaster_umd_ctl00_gvL_hpSelect_0")

	//Insurance Data
	private TestObject btnPencilInsuranceData				= createTestObject("btnPencilInsuranceData", "id", "gvEntryIns_imbEdit_0")

	//Insurance Data Initialization
	private TestObject drpSchemeName						= createTestObject("drpSchemeName", "id", "ucRefInsScheme_ddlReference")
	private TestObject btnNextInsuranceDataInitialization	= createTestObject("btnNextInsuranceDataInitialization", "id", "lbNextInsDataInit")
	private TestObject btnSaveInsuranceDataInitialization	= createTestObject("btnSaveInsuranceDataInitialization", "id", "lbToolbarSaveInstDataInit")

	//Insurance Rate To Customer
	private TestObject drpMainCoverageType1					= createTestObject("drpMainCoverageType1", "id", "ucInsrateSimulation_rptMainCvgType_ctl01_ucRefMainCvgType_ddlReference")
	private TestObject drpMainCoverageType2					= createTestObject("drpMainCoverageType2", "id", "ucInsrateSimulation_rptMainCvgType_ctl02_ucRefMainCvgType_ddlReference")
	private TestObject btnCalculateInsuranceRate			= createTestObject("btnCalculateInsuranceRate", "id", "ucInsrateSimulation_lb_Form_Calculate")

	//Fees
	private TestObject btnCalculateFee						= createTestObject("btnCalculateFee", "id", "lb_Form_CalcFee")
	private TestObject btnCalculateOnFeesSection			= createTestObject("btnCalculateOnFeesSection", "id", "lbCalculateFees")// sebelah kanan btncalculateFee

	//FinancialData
	private TestObject btnCalculateInstallment				= createTestObject("btnCalculateInstallment", "id", "lbCalculateFinancialData")


	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Credit Simulation")
	}

	public void inputMainInformation(String customerName, String customerType, String offeringCode, String maritalStatus, String numOfAsset) {
		verifyLandingScreen()
		txtCustomerType	= createTestObject("txtCustomerType", "xpath", "//*[text() = '$customerType']")
		WebUI.setText(txfCustomerName, customerName)
		WebUI.click(txtCustomerType)

		WebUI.click(icoLookUpProductOffering)
		WebUI.setText(txfProductOfferingCode, offeringCode)
		WebUI.click(btnSearch)
		WebUI.click(btnSelect)
		
		WebUI.selectOptionByLabel(drpMaritalStatus, maritalStatus, false)
		WebUI.setText(txfNumOfAsset, numOfAsset)
	}

	public void inputApplicationData(String tenor, String installmentScheme, String paymentFrequency) {
		WebUI.setText(txftenor, tenor)
		WebUI.selectOptionByLabel(drpInstallmentScheme, installmentScheme, false)
		WebUI.selectOptionByLabel(drpPaymentFrequency, paymentFrequency, false)
	}

	public void inputLifeInsuranceData(String branchName, String premiumPaymentMethod) {
		WebUI.click(chkCoverLifeInsurance)
		WebUI.selectOptionByLabel(drpLifeInscoBranchName, branchName, false)
		WebUI.click(chkCustomer)
		WebUI.selectOptionByLabel(drpPaymentPremiumMethod, premiumPaymentMethod, false)
	}

	public void clickNext() {
		WebUI.click(btnNext)
	}

	public void inputAssetData(String suppBranchName, assetName, assetPrice, dpType, downPayment, assetUsage) {
		txtDpType	= createTestObject("txtCustomerType", "xpath", "//*[text() = '$dpType']")
		//supp branch name
		WebUI.click(icoLookUpSupplierBranchName)
		WebUI.setText(txfSuppBranchName, suppBranchName)
		WebUI.click(btnSearchSuppBranch)
		WebUI.click(btnSelectSuppBranch)

		//asset name
		WebUI.click(icoLookUpAssetName)
		WebUI.setText(txfAssetName, assetName)
		WebUI.click(btnSeacrhAssetName)
		WebUI.click(btnSelectAssetName)

		WebUI.setText(txfAssetPrice, assetPrice)
		
		WebUI.click(txtDpType)
		WebUI.setText(txfDownPayment, downPayment)
		WebUI.selectOptionByLabel(drpAssetUsage, assetUsage, false)

		WebUI.click(btnSaveAsset)
	}

	public void inputInsuranceDataInitialization(String schemeName) {
		WebUI.click(btnPencilInsuranceData)
		WebUI.selectOptionByLabel(drpSchemeName, schemeName, false)
		WebUI.click(btnNextInsuranceDataInitialization)
	}

	public void inputInsuranceRateToCustomer(String coverageType1, coverageType2) {
		WebUI.selectOptionByLabel(drpMainCoverageType1, coverageType1, false)
		WebUI.selectOptionByLabel(drpMainCoverageType2, coverageType2, false)

		WebUI.click(btnCalculateInsuranceRate)
		WebUI.click(btnSaveInsuranceDataInitialization)
	}

	public void calculateFeeAndFinancialData() {
		WebUI.click(btnCalculateFee)
		WebUI.click(btnCalculateOnFeesSection) // sebelah kanan btncalculateFee
		WebUI.click(btnCalculateInstallment)
	}

	public void clickGenerate() {
		WebUI.click(btnGenerate)
	}
	
	public void clickAdd() {
		WebUI.click(btnAdd)
	}
	
	public void switchToIframeMain() {
		WebUI.switchToFrame(iframeMainpage, 1)
	}

	public void switchToDefaultContent() {
		WebUI.switchToDefaultContent()
	}
}
