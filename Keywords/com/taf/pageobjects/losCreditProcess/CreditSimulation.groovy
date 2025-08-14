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
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "", "")
	private TestObject btnAdd = createTestObject("btnAdd", "", "")
	private TestObject btnNext = createTestObject("btnNext", "", "")
	private TestObject btnGenerate = createTestObject("btnGenerate", "", "")

	//main information
	private TestObject txfCustomerName = createTestObject("txfCustomerName", "", "")
	private TestObject txfNumOfAsset = createTestObject("txfCustomerName", "", "")
	private TestObject drpMaritalStatus = createTestObject("drpMaritalStatus", "", "")
	private TestObject txtMaritalStatus
	private TestObject icoLookUpProductOffering = createTestObject("icoLookUpProductOffering", "", "")
	//main information - product offering lookup
	private TestObject txfProductOfferingCode = createTestObject("txfProductOfferingCode", "", "")
	private TestObject txfProductOfferingName = createTestObject("txfProductOfferingName", "", "")
	private TestObject btnSearch = createTestObject("btnSearch", "", "")
	private TestObject txtProductOfferingCode = createTestObject("txtProductOfferingCode", "", "")
	private TestObject txtProductOfferingName = createTestObject("txtProductOfferingName", "", "")
	private TestObject btnSelect = createTestObject("btnSelect", "", "")

	//Application Data
	private TestObject txftenor = createTestObject("txftenor", "", "")
	private TestObject drpInstallmentScheme = createTestObject("drpInstallmentScheme", "", "")
	private TestObject txtInstallmentScheme
	private TestObject drpPaymentFrequency = createTestObject("drpPaymentFrequency", "", "")
	private TestObject txtPaymentFrequency

	//Life Insurance Data
	private TestObject chkCoverLifeInsurance = createTestObject("chkCoverLifeInsurance", "", "")
	private TestObject drpLifeInscoBranchName = createTestObject("drpLifeInscoBranchName", "", "")
	private TestObject txtLifeInscoBranchName
	private TestObject chkCustomer = createTestObject("chkCustomer", "", "") // customer Insured - kalo butuh tambahkan juga yg chkSpouse
	private TestObject drpPaymentPremiumMethod = createTestObject("drpPaymentPremiumMethod", "", "")
	private TestObject txtPaymentPremiumMethod

	//Asset Data
	private TestObject icoLookUpSupplierBranchName = createTestObject("icoLookUpSupplierBranchName", "", "")
	private TestObject icoLookUpAssetName = createTestObject("icoLookUpAssetName", "", "")
	private TestObject txfAssetPrice = createTestObject("txfAssetPrice", "", "")
	private TestObject txfDownPayment = createTestObject("txfDownPayment", "", "")
	private TestObject drpAssetUsage = createTestObject("drpAssetUsage", "", "")
	private TestObject txtAssetUsage
	private TestObject btnAddAsset = createTestObject("btnAddAsset", "", "")
	private TestObject btnSaveAsset = createTestObject("btnSaveAsset", "", "")
	//Asset Data - Supplier branch name
	private TestObject txfSuppBranchName = createTestObject("txfSuppBranchName", "", "")
	private TestObject txfSuppName = createTestObject("txfSuppName", "", "")
	private TestObject txfSuppBranchAddress = createTestObject("txfSuppBranchAddress", "", "")
	private TestObject btnSearchSuppBranch = createTestObject("btnSearchSuppBranch", "", "")
	private TestObject btnSelectSuppBranch = createTestObject("btnSelectSuppBranch", "", "")
	//Asset Data - Asset name LookUp
	private TestObject txfAssetName = createTestObject("txfAssetName", "", "")
	private TestObject btnSeacrhAssetName = createTestObject("btnSeacrhAssetName", "", "")
	private TestObject btnSelectAssetName = createTestObject("btnSelectAssetName", "", "")

	//Insurance Data
	private TestObject btnPencilInsuranceData = createTestObject("btnPencilInsuranceData", "", "")

	//Insurance Data Initialization
	private TestObject drpSchemeName = createTestObject("drpSchemeName", "", "")
	private TestObject txtSchemeName
	private TestObject btnNextInsuranceDataInitialization = createTestObject("btnNextInsuranceDataInitialization", "", "")
	private TestObject btnSaveInsuranceDataInitialization = createTestObject("btnSaveInsuranceDataInitialization", "", "")

	//Insurance Rate To Customer
	private TestObject drpMainCoverageType1 = createTestObject("drpMainCoverageType1", "", "")
	private TestObject txtMainCoverageType1
	private TestObject drpMainCoverageType2 = createTestObject("drpMainCoverageType2", "", "")
	private TestObject txtMainCoverageType2
	private TestObject btnCalculateInsuranceRate = createTestObject("btnCalculateInsuranceRate", "", "")

	//Fees
	private TestObject btnCalculateFee = createTestObject("btnCalculateFee", "", "")
	private TestObject btnCalculateOnFeesSection = createTestObject("btnCalculateOnFeesSection", "", "")// sebelah kanan btncalculateFee

	//FinancialData
	private TestObject btnCalculateInstallment = createTestObject("btnCalculateInstallment", "", "")


	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Credit Simulation")
	}

	public void inputMainInformation(String customerName, String offeringCode, String offeringName, String maritalStatus, String numOfAsset) {
		txtMaritalStatus = createTestObject("txtMaritalStatus", "text", "$maritalStatus")

		WebUI.setText(txfCustomerName, customerName)

		WebUI.click(icoLookUpProductOffering)
		WebUI.setText(txfProductOfferingCode, offeringCode)//di video nyma input % - tapi better dari test data ga sih code nya apa?
		WebUI.setText(txfProductOfferingName, offeringName)
		WebUI.click(btnSearch)
		WebUI.click(btnSelect)

		WebUI.click(drpMaritalStatus)
		WebUI.click(txtMaritalStatus)

		WebUI.setText(txfNumOfAsset, numOfAsset)
	}

	public void inputApplicationData(String tenor, String installmentScheme, String paymentFrequency) {
		txtInstallmentScheme = createTestObject("txtInstallmentScheme", "text", "$installmentScheme")
		txtPaymentFrequency = createTestObject("txtPaymentFrequency", "text", "$paymentFrequency")

		WebUI.setText(txftenor, tenor)

		WebUI.click(drpInstallmentScheme)
		WebUI.click(txtInstallmentScheme)

		WebUI.click(drpPaymentFrequency)
		WebUI.click(txtPaymentFrequency)
	}

	public void inputLifeInsuranceData(String branchName, String premiumPaymentMethod) {
		txtLifeInscoBranchName = createTestObject("txtLifeInscoBranchName", "text", "$branchName")
		txtPaymentPremiumMethod = createTestObject("txtPaymentPremiumMethod", "text", "$premiumPaymentMethod")

		WebUI.click(chkCoverLifeInsurance)

		WebUI.click(drpLifeInscoBranchName)
		WebUI.click(txtLifeInscoBranchName)

		WebUI.click(chkCustomer)

		WebUI.click(drpPaymentPremiumMethod)
		WebUI.click(txtPaymentPremiumMethod)
	}

	public void clickNext() {
		WebUI.click(btnNext)
	}

	public void inputAssetData(String suppBranchName, suppName, suppBranchAddress, assetName, assetPrice, downPayment, assetUsage) {
		txtAssetUsage = createTestObject("txtAssetUsage", "text", "$assetUsage")

		//supp branch name
		WebUI.click(icoLookUpSupplierBranchName)
		WebUI.setText(txfSuppBranchName, suppBranchName)
		WebUI.setText(txfSuppName, suppName)
		WebUI.setText(txfSuppBranchAddress, suppBranchAddress)
		WebUI.click(btnSearchSuppBranch)
		WebUI.click(btnSelectSuppBranch)

		//asset name
		WebUI.click(icoLookUpAssetName)
		WebUI.setText(txfAssetName, assetName)
		WebUI.click(btnSeacrhAssetName)
		WebUI.click(btnSelectAssetName)

		WebUI.setText(txfAssetPrice, assetPrice)
		WebUI.setText(txfDownPayment, downPayment)

		WebUI.click(drpAssetUsage)
		WebUI.click(txtAssetUsage)

		WebUI.click(btnSaveAsset)

		//setelah ini btnNext di header, bebas mau ditambah disini atau nanti di test step or scenario
		WebUI.click(btnNext)
	}

	public void inputInsuranceDataInitialization(String schemeName) {
		txtSchemeName = createTestObject("txtSchemeName", "text", "$schemeName")

		WebUI.click(drpSchemeName)
		WebUI.click(txtSchemeName)
		WebUI.click(btnNextInsuranceDataInitialization)
	}

	public void inputInsuranceRateToCutomer(String coverageType1, coverageType2) {
		txtMainCoverageType1 = createTestObject("txtMainCoverageType1", "text", "$coverageType1")
		txtMainCoverageType2 = createTestObject("txtMainCoverageType2", "text", "$coverageType2")

		WebUI.click(drpMainCoverageType1)
		WebUI.click(txtMainCoverageType1)
		WebUI.click(drpMainCoverageType2)
		WebUI.click(txtMainCoverageType2)

		WebUI.click(btnCalculateInsuranceRate)
		WebUI.click(btnSaveInsuranceDataInitialization)

		//setelah ini btnNext di header, bebas mau ditambah disini atau nanti di test step or scenario
		WebUI.click(btnNext)
	}

	public void calculateFeeAndFinancialData() {
		WebUI.click(btnCalculateFee)
		WebUI.click(btnCalculateOnFeesSection) // sebelah kanan btncalculateFee
		WebUI.click(btnCalculateInstallment)

		//setelah ini btnNext di header, bebas mau ditambah disini atau nanti di test step or scenario
		WebUI.click(btnNext)

		clickGenerate()//muncul download file pdf
		//setelah ini btnNext di header, bebas mau ditambah disini atau nanti di test step or scenario
		WebUI.click(btnNext)
	}

	public void clickGenerate() {
		WebUI.click(btnGenerate)
	}
}
