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

public class NewApplicationPage extends BaseHelper{
	//test data 	0008APP20250600807

	//new application
	private TestObject lblTitle						= createTestObject("lblTitle", "id", "pageTitle")
	private TestObject txfApplicationNumber			= createTestObject("txfApplicationNumber", "id", "ucSearch_txtAppNo_ltlAppAppNoSearch")
	private TestObject btnSearch					= createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	private TestObject btnSelectApplication			= createTestObject("btnSelectApplication", "id", "gvApp_imbEdit_0")
	private TestObject btnAdd						= createTestObject("btnAdd", "id", "lb_Toolbar_Add")

	//section main information
	private TestObject btnLookUpOfferingName		= createTestObject("btnLookUpOfferingName", "id", "ucLookupProdOffer_uclProductOffering_imb")
	//pop up
	private TestObject txfOfferingCode				= createTestObject("txfOfferingCode", "id", "ucLookupProdOffer_uclProductOffering_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject txfOfferingName				= createTestObject("txfOfferingName", "id", "ucLookupProdOffer_uclProductOffering_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1")
	private TestObject btnOfferingSearch			= createTestObject("btnOfferingSearch", "id", "ucLookupProdOffer_uclProductOffering_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectOffering			= createTestObject("btnSelectOffering", "id", "ucLookupProdOffer_uclProductOffering_umd_ctl00_gvL_hpSelect_0")//select first row
	private TestObject txfNumOfAsset				= createTestObject("txfNumOfAsset", "id", "ucINNumOfAsset_txtInput")

	//section main info
	private TestObject lblApplicationNumber			= createTestObject("lblApplicationNumber", "id", "ucCreditProcessMainInfo_lbAppNo")


	//section tab customer
	private TestObject btnLookUpCustomerName		= createTestObject("btnLookUpCustomerName", "id", "uclCust_uclCust_imb")
	//pop up
	private TestObject txfCustomerName				= createTestObject("txfCustomerName", "id", "uclCust_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject btnSearchCustomerName		= createTestObject("btnSearchCustomerName", "id", "uclCust_uclCust_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectCustomerName		= createTestObject("btnSelectCustomerName", "id", "uclCust_uclCust_umd_ctl00_gvL_hpSelect_0")//select first row


	//section tab gurantor
	private TestObject btnAddPersonalGurantor		= createTestObject("btnAddPersonalGurantor", "id", "lb_AgrmntGuarantor_AddPersonal")
	private TestObject btnAddCompanyGurantor		= createTestObject("btnAddCompanyGurantor", "id", "lb_AgrmntGuarantor_AddCompany")
	private TestObject btnLookUpGurantorName
	//pop up
	private TestObject txfGurantorName				= createTestObject("txfGurantorName", "id", "")
	private TestObject btnSearchGurantor			= createTestObject("btnSearchGurantor", "id", "")
	private TestObject btnSelectGurantor			= createTestObject("btnSelectGurantor", "id", "")
	private TestObject drpGurantorRelation			= createTestObject("drpGurantorRelation", "id", "")
	private TestObject btnSaveGurantor				= createTestObject("btnSaveGurantor", "id", "")
	


	//section tab application data
	private TestObject txfTenor						= createTestObject("txfTenor", "id", "ucINTenor_txtInput")
	private TestObject drpPaymentFrequent			= createTestObject("drpPaymentFrequent", "id", "ucRefPaymentFreq_ddlReference")
	private TestObject drpMarginType				= createTestObject("drpMarginType", "id", "ucRefInterestType_ddlReference")
	private TestObject drpInstallamentScheme		= createTestObject("drpInstallamentScheme", "id", "ucRefInstScheme_ddlReference")
	private TestObject rdnFirstInstallmentType 		= createTestObject("rdnFirstInstallmentType", "xpath", "//label[text() = '{data}']/preceding-sibling::input")//sepertinya ini dibawah ikut function

	//section application info
	private TestObject drpApplicationSource			= createTestObject("drpApplicationSource", "id", "ucRefAppSource_ddlReference")
	private TestObject rdnFiduciaCovered			= createTestObject("rdnFiduciaCovered", "xpath", "//label[text() = '{data}']/preceding-sibling::input")
	private TestObject drpWayOfPayment				= createTestObject("drpWayOfPayment", "id", "ucRefWOP_ddlReference")
	private TestObject rdnSelfUsage 				= createTestObject("rdnSelfUsage", "xpath", "//label[text() = '{data}']/preceding-sibling::input")//sepertinya ini dibawah ikut function
	private TestObject drpPurposeOfUsage			= createTestObject("drpPurposeOfUsage", "id", "ucPurposeOfUsage_ddlReference")

	//section mailing address
	private TestObject drpCopyAddress				= createTestObject("drpCopyAddress", "id", "ucRefCopyAddr_ddlReference")
	private TestObject btnCopyAddress				= createTestObject("btnCopyAddress", "id", "lb_Form_CopyAddr")
	private TestObject txfAddress					= createTestObject("txfAddress", "id", "ucAddr_txtOfficeAddr")
	private TestObject txfRt						= createTestObject("txfRt", "id", "ucAddr_txtRT")
	private TestObject txfRw						= createTestObject("txfRw", "id", "ucAddr_txtRW")
	private TestObject btnLookUpZipCode				= createTestObject("btnLookUpZipCode", "id", "ucAddr_ucLookupZipCode_uclZipCode_imb")
	//pop up
	private TestObject txfZipCode					= createTestObject("txfZipCode", "id", "ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_3")
	private TestObject btnZipCodeSearch				= createTestObject("btnZipCodeSearch", "id", "ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectZip					= createTestObject("btnSelectZip", "id", "ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_gvL_hpSelect_0")//select first row
	private TestObject txfPhoneCode					= createTestObject("txfPhoneCode", "id", "ucAddr_txtPhnArea1")
	private TestObject txfPhoneNo					= createTestObject("txfPhoneNo", "id", "ucAddr_txtPhn1")
	private TestObject txfExt						= createTestObject("txfExt", "id", "ucAddr_txtPhoneExt1")

	//section data restrukturisasi
	private TestObject drpCharacteristicOfCredit	= createTestObject("drpCharacteristicOfCredit", "id", "ddlKodeSifatKredit")
	private TestObject btnLookUpEconomicSector		= createTestObject("btnLookUpEconomicSector", "id", "UCRefMasterSekEko_ucLookupRefMaster_imb")
	//pop up
	private TestObject txfEconimicSector			= createTestObject("txfEconimicSector", "id", "UCRefMasterSekEko_ucLookupRefMaster_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject btnEconimicSearc				= createTestObject("btnEconimicSearc", "id", "UCRefMasterSekEko_ucLookupRefMaster_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectEconomic			= createTestObject("btnSelectEconomic", "id", "UCRefMasterSekEko_ucLookupRefMaster_umd_ctl00_gvL_hpSelect_0")//select first row


	//section tab asset data
	private TestObject btnAddAsset					= createTestObject("btnAddAsset", "id", "")
	private TestObject btnLookUpSupplier			= createTestObject("btnLookUpSupplier", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_imb")
	//pop up
	private TestObject txfSupplierBranchName		= createTestObject("txfSupplierBranchName", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject txfSupplierName				= createTestObject("txfSupplierName", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1")
	private TestObject txfSupplierAddress			= createTestObject("txfSupplierAddress", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_2")
	private TestObject btnSupplierSearch			= createTestObject("btnSupplierSearch", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectSupplier			= createTestObject("btnSelectSupplier", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_gvL_hpSelect_0")//select first row
	//section top up agreement
	private TestObject btnLookUpTopUp				= createTestObject("btnLookUpTopUp", "id", "")
	//pop up
	private TestObject txfApplicationNoTopUP		= createTestObject("txfApplicationNoTopUP", "id", "")
	private TestObject txfAgreementNoTopUp			= createTestObject("txfAgreementNoTopUp", "id", "")
	private TestObject btnSearchTopUp				= createTestObject("btnSearchTopUp", "id", "")
	private TestObject btnSelectTopUp				= createTestObject("btnSelectTopUp", "id", "")
	//section main asset
	private TestObject btnLookUpAssetName			= createTestObject("btnLookUpAssetName", "id", "ucLookupAssetSchm_uclAssetSchm_imb")
	//pop up
	private TestObject txfAssetName					= createTestObject("txfAssetName", "id", "ucLookupAssetSchm_uclAssetSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject btnAssetSearch				= createTestObject("btnAssetSearch", "id", "ucLookupAssetSchm_uclAssetSchm_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectAsset				= createTestObject("btnSelectAsset", "id", "ucLookupAssetSchm_uclAssetSchm_umd_ctl00_gvL_hpSelect_0")//select first row
	private TestObject txfAssetPrice				= createTestObject("txfAssetPrice", "id", "ucAssetPrice_txtInput")
	private TestObject rdnDPType 					= createTestObject("rdnDPType", "xpath", "//label[text() = '{data}']/preceding-sibling::input")//sepertinya dibawah ikut function
	private TestObject txfDownPayment				= createTestObject("txfDownPayment", "id", "ucDownPayment_txtInput")
	private TestObject btnGetMarketPrice			= createTestObject("btnGetMarketPrice", "id", "lb_Form_GetMktPrcAndCalcUpPrcnt")
	//section asset data
	private TestObject txfNoMesin					= createTestObject("txfNoMesin", "id", "txtSerialNo1")
	private TestObject txfNoRangka					= createTestObject("txfNoRangka", "id", "txtSerialNo2")
	private TestObject txfLicensePlate				= createTestObject("txfLicensePlate", "id", "txtLicensePlateNo")
	private TestObject drpAssetUsage				= createTestObject("drpAssetUsage", "id", "ucAssetUsage_ddlReference")
	private TestObject txfManufacturingYear			= createTestObject("txfManufacturingYear", "id", "txtManufacturingYear")
	//section asset attribute
	private TestObject txfMadeIn					= createTestObject("txfMadeIn", "id", "rptAttribute_txtAttrContent_0")
	private TestObject txfCylinder					= createTestObject("txfCylinder", "id", "rptAttribute_txtAttrContent_1")
	private TestObject txfTransmition				= createTestObject("txfTransmition", "id", "rptAttribute_txtAttrContent_2")
	private TestObject txfColor						= createTestObject("txfColor", "id", "rptAttribute_txtAttrContent_3")
	private TestObject drpRegion					= createTestObject("drpRegion", "id", "rptAttribute_ucrefInputAttr_4_ddlReference_4")
	//section additional grid
	private TestObject btnAddGrid					= createTestObject("btnAddGrid", "id", "lb_Form_Add_AddSvc")
	private TestObject drpAssetServiceName			= createTestObject("drpAssetServiceName", "id", "ucServiceName_ddlReference")
	private TestObject btnLookUpSupplierGird		= createTestObject("btnLookUpSupplierGird", "id", "ucSpplSvcName_uclSupplBranchSchm_imb")
	//pop up
	private TestObject txfSupplierBranchNameGrid	= createTestObject("txfSupplierBranchNameGrid", "id", "ucSpplSvcName_uclSupplBranchSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject txfSupplierNameGrid			= createTestObject("txfSupplierNameGrid", "id", "ucSpplSvcName_uclSupplBranchSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1")
	private TestObject txfSupplierAddressGrid		= createTestObject("txfSupplierAddressGrid", "id", "ucSpplSvcName_uclSupplBranchSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_2")
	private TestObject btnSupplierSearchGrid		= createTestObject("btnSupplierSearchGrid", "id", "ucSpplSvcName_uclSupplBranchSchm_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectSupplierGrid		= createTestObject("btnSelectSupplierGrid", "id", "ucSpplSvcName_uclSupplBranchSchm_umd_ctl00_gvL_hpSelect_0")
	private TestObject txfServicePrice				= createTestObject("txfServicePrice", "id", "ucSvcPrice_txtInput")
	private TestObject btnSaveAsset					= createTestObject("btnSaveAsset", "id", "lb_Form_Save_AddSvc")

	//list of asset
	private TestObject btnPenAssetRegistration		= createTestObject("btnPenAssetRegistration", "id", "gvAssetList_imbEdit_0")//select first row
	//section asset owner
	private TestObject drpCopyAddressRegis			= createTestObject("drpCopyAddressRegis", "id", "ucCopyAddrOwner_ddlReference")
	private TestObject btnCopyAddressRegis			= createTestObject("btnCopyAddressRegis", "id", "lb_Form_Copy_OwnerAddr")
	private TestObject btnSaveRegis					= createTestObject("btnSaveRegis", "id", "lb_Form_Save_Reg")


	//section tab insurance data
	private TestObject btnEditInsuranceData			= createTestObject("btnEditInsuranceData", "id", "gvEntryIns_imbEdit_0")//select first row
	//section insurance data intialization
	private TestObject rdnInsuredBy					= createTestObject("rdnInsuredBy", "xpath", "//label[text() = '{data}']/preceding-sibling::input")
	private TestObject drpSchemeName				= createTestObject("drpSchemeName", "id", "ucInsInit_ucRefInsSchmName_ddlReference")
	private TestObject rdnCoverePeriod				= createTestObject("rdnCoverePeriod", "xpath", "//label[text() = '{data}']/preceding-sibling::input")
	private TestObject drpRateType					= createTestObject("drpRateType", "id", "ucInsInit_ucRefInsRateType_ddlReference")
	private TestObject txfInsuranceLength			= createTestObject("txfInsuranceLength", "id", "ucInsInit_ucINInsLength_txtInput")
	//section coverage
	private TestObject drpMainCoverageType			= createTestObject("drpMainCoverageType", "id", "ucInsrate_rptMainCvgType_ctl01_ucRefMainCvgType_ddlReference")
	private TestObject btnNext						= createTestObject("btnNext", "id", "lb_Toolbar_Next")
	private TestObject btnCalculateInsurance		= createTestObject("btnCalculateInsurance", "id", "ucInsrate_lb_Form_Calculate")
	private TestObject btnSaveInsurance				= createTestObject("btnSaveInsurance", "id", "lbSave")
	private TestObject btnNextInsuranceData			= createTestObject("btnNextInsuranceData", "id", "lb_Form_Next")


	//section tab insurance life
	private TestObject chkCoverLifeInsurance		= createTestObject("chkCoverLifeInsurance", "id", "cbIsCoverLifeIns")
	private TestObject drpLifeInscoBranchName		= createTestObject("drpLifeInscoBranchName", "id", "ddlLifeInscoName")
	private TestObject chkCustomerInsured			= createTestObject("chkCustomerInsured", "xpath", "//label[text() = '{data}']/preceding-sibling::input")//input data
	private TestObject drpPremiumPaymentMethod		= createTestObject("drpPremiumPaymentMethod", "id", "ddlPaymentMethod")
	private TestObject txfNotesLifeInsurance		= createTestObject("txfNotesLifeInsurance", "id", "txt_LifeInsH_NewCoverNotes")


	//section tab financial data
	private TestObject btnCalculateFee				= createTestObject("btnCalculateFee", "id", "lb_Form_CalcFee")
	private TestObject btnCalculate					= createTestObject("btnCalculate", "id", "lbCalculateFees")
	private TestObject btnCalculateInstallment		= createTestObject("btnCalculateInstallment", "id", "lbCalculateFinancialData")
	private TestObject tableInstallment				= createTestObject("tableInstallment", "id", "gvAmortization")


	//section tab commision data
	private TestObject btnCalculateCommision		= createTestObject("btnCalculateCommision", "id", "lb_Form_Calculate")

	//section tab other data : kosong

	//section tab other info
	private TestObject drpContractEmployee			= createTestObject("drpContractEmployee", "id", "rptAttribute_ucrefInputAttr_0_ddlReference_0")
	private TestObject drpRentalBusiness			= createTestObject("drpRentalBusiness", "id", "rptAttribute_ucrefInputAttr_1_ddlReference_1")
	private TestObject drpAssetForOnline			= createTestObject("drpAssetForOnline", "id", "rptAttribute_ucrefInputAttr_2_ddlReference_2")
	private TestObject drpFraudIndication			= createTestObject("drpFraudIndication", "id", "rptAttribute_ucrefInputAttr_3_ddlReference_3")
	private TestObject drpHighRiskCustomer			= createTestObject("drpHighRiskCustomer", "id", "rptAttribute_ucrefInputAttr_4_ddlReference_4")
	private TestObject drpHighRiskBusiness			= createTestObject("drpHighRiskBusiness", "id", "rptAttribute_ucrefInputAttr_5_ddlReference_5")
	private TestObject drpHighRiskProduct			= createTestObject("drpHighRiskProduct", "id", "rptAttribute_ucrefInputAttr_6_ddlReference_6")
	private TestObject drpCreditApproval			= createTestObject("drpCreditApproval", "id", "rptAttribute_ucrefInputAttr_7_ddlReference_7")
	private TestObject drpOwnedVihecle				= createTestObject("drpOwnedVihecle", "id", "rptAttribute_ucrefInputAttr_12_ddlReference_12")
	private TestObject drpPrioritySeal				= createTestObject("drpPrioritySeal", "id", "rptAttribute_ucrefInputAttr_13_ddlReference_13")
	private TestObject txfNPWP						= createTestObject("txfNPWP", "id", "rptAttribute_txtAttrContent_14")
	private TestObject txfNomorSK					= createTestObject("txfNomorSK", "id", "rptAttribute_txtAttrContent_15")
	private TestObject drpSTNK						= createTestObject("drpSTNK", "id", "rptAttribute_ucrefInputAttr_16_ddlReference_16")
	private TestObject drpStatusNPWP				= createTestObject("drpStatusNPWP", "id", "rptAttribute_ucrefInputAttr_17_ddlReference_17")
	private TestObject drpCDENotes					= createTestObject("drpCDENotes", "id", "rptAttribute_ucrefInputAttr_18_ddlReference_18")
	private TestObject btnSaveOtherInfo				= createTestObject("btnSaveOtherInfo", "id", "lb_Form_Save")


	//section tab TnC
	private TestObject lblRequiredDocument			= createTestObject("", "id", "")
	private TestObject chkRequiredDocument			= createTestObject("", "id", "")
	private TestObject txfPromiseDateRequired		= createTestObject("", "id", "")
	private TestObject btnSaveTnC					= createTestObject("btnSaveTnC", "id", "lb_Form_Save")



	//button
	private TestObject btnSaveAndContinue			= createTestObject("btnSaveAndContinue", "id", "lb_Form_SaveCont")
	private TestObject btnSubmit					= createTestObject("btnSubmit", "id", "lbl_Toolbar_Submit")
	//jika memilih floating rate
	private TestObject drpFloatingPeriod			= createTestObject("", "id", "")
	private TestObject iframeMain					= createTestObject("iframeMain", "id", "mainPage")
	private TestObject iframeForm					= createTestObject("iframeForm", "xpath", "//iframe[@id = 'appForm']")
	
	
	private void verifyLandingPage() {
		WebUI.switchToFrame(iframeMain, 0)
		verifyLanding(lblTitle, "New Application")
		WebUI.takeScreenshot()
	}
	
	private void searchApp(String appNo) {
		WebUI.setText(txfApplicationNumber, appNo)
		safetyClick(btnSearch, 1)
		WebUI.click(btnSelectApplication)
	}
	
	private void clickAddNewApplicaiton() {
		safetyClick(btnAdd, 1)
		WebUI.takeScreenshot()
	}
	
	private void inputMainInformation(String productOfferingCode, String numOfAsset) {
		WebUI.click(btnLookUpOfferingName)
		WebUI.delay(1)
		WebUI.setText(txfOfferingCode, productOfferingCode)
		WebUI.click(btnOfferingSearch)
		WebUI.takeScreenshot()
		WebUI.click(btnSelectOffering)
		
		WebUI.setText(txfNumOfAsset, numOfAsset)
		WebUI.takeScreenshot()
		
		safetyClick(btnNext)	
	}
	
	private String getAppNo() {
		WebUI.takeScreenshot()
		return WebUI.getText(lblApplicationNumber)
	}
	
	private void inputCustomerData(String type, String custName) {
		TestObject rdnType 	= createTestObject("rdnType", "xpath", "//label[text() = '$type']/preceding-sibling::input")
		safetyClick(rdnType, 1)
		WebUI.click(btnLookUpCustomerName)
		WebUI.delay(1)
		WebUI.setText(txfCustomerName, custName)
		WebUI.click(btnSearchCustomerName)
		WebUI.click(btnSelectCustomerName)
		WebUI.takeScreenshot()
		
	}
	
	private void addGurantorPersonal(String name, String relation) {
		safetyClick(btnAddPersonalGurantor, 1)
		WebUI.takeScreenshot()
		
		WebUI.click(btnLookUpGurantorName)
		WebUI.delay(1)
		WebUI.setText(txfGurantorName, name)
		WebUI.click(btnSearchGurantor)
		WebUI.click(btnSelectGurantor)
		WebUI.takeScreenshot()
		
		safetySelect(drpGurantorRelation, relation)
		WebUI.takeScreenshot()
		WebUI.click(btnSaveGurantor)
		
	}
	
	private void inputApplicationData(String tenor, String payFreq, String margin, String installament) {
		WebUI.setText(txfTenor, tenor)
		safetySelect(drpPaymentFrequent, payFreq, 1)
		safetySelect(drpMarginType, margin, 1)
		safetySelect(drpInstallamentScheme, installament, 1)
	}
	
	private void inputApplicationInfo(String appSource, String wayPay, String usage) {
		safetySelect(drpApplicationSource, appSource, 1)
		safetySelect(drpWayOfPayment, wayPay, 1)
		safetySelect(drpPurposeOfUsage, usage, 1)
	}
	
	private void inputMailingAddress(String address) {
		safetySelect(drpCopyAddress, address, 1)
		WebUI.click(btnCopyAddress)
	}
	
	private void clickAddAsset() {
		WebUI.click(btnAddAsset)
		WebUI.delay(1)
		WebUI.takeScreenshot()
	}
	
	private void inputSupplierInfo(String name) {
		WebUI.click(btnLookUpSupplier)
		WebUI.delay(1)
		WebUI.setText(txfSupplierName, name)
		WebUI.click(btnSupplierSearch)
		WebUI.takeScreenshot()
		WebUI.click(btnSelectSupplier)	
	}
	
	private void topUpAgreemnt(String label) {
		WebUI.click(btnLookUpTopUp)
		WebUI.delay(1)
		WebUI.setText(txfApplicationNoTopUP, label)
		WebUI.click(btnSearchTopUp)
		WebUI.takeScreenshot()
		WebUI.click(btnSelectTopUp)
	}
	
	private void inputAssetName(String assetName) {
		WebUI.click(btnLookUpAssetName)
		WebUI.delay(1)
		WebUI.setText(txfAssetName, assetName)
		WebUI.click(btnAssetSearch)
		WebUI.takeScreenshot()
		WebUI.click(btnSelectAsset)	
	}
	
	private void inputMainAsset(String assetPrice, String downPayment) {
		safetyInput(txfAssetPrice, assetPrice)
		safetyInput(txfDownPayment, downPayment)
	}
	
	private void clickGetMarketPrice() {
		WebUI.click(btnGetMarketPrice)
		WebUI.delay(1)
		WebUI.takeScreenshot()
	}
	
	private void inputAssetData(String noMesin, String noRangka, String licenseNo, String conditoin, String usage, String year) {
		TestObject rdnAssetCondition = createTestObject("rdnAssetCondition", "xpath", "//label[text() = '$conditoin']/preceding-sibling::input")
		
		WebUI.setText(txfNoMesin, noMesin)
		WebUI.setText(txfNoRangka, noRangka)
		WebUI.setText(txfLicensePlate, licenseNo)
		WebUI.delay(1)
		WebUI.click(rdnAssetCondition)
		safetySelect(drpAssetUsage, usage, 1)
		WebUI.setText(txfManufacturingYear, year)
		
	}
	
	private void inputAssetAttribute() {
		//bukan mandatory
	}
	
	private void addGrid(String serviceName, String branchName, String servicePrice) {
		WebUI.click(btnAddGrid)
		WebUI.delay(1)
		
		safetySelect(drpAssetServiceName, serviceName)
		
		WebUI.click(btnLookUpSupplierGird)
		WebUI.delay(1)
		WebUI.setText(txfSupplierBranchNameGrid, branchName)
		WebUI.click(btnSupplierSearchGrid)
		WebUI.takeScreenshot()
		WebUI.click(btnSelectSupplierGrid)
		safetyInput(txfServicePrice, servicePrice)
		//ada button save nya harusnya
	}
	
	private void clickSaveAsset() {
		safetyClick(btnSaveAsset, 1)
		WebUI.takeScreenshot()
	}
	
	private void selectAssetRegis() {
		WebUI.click(btnPenAssetRegistration)
		WebUI.delay(1)
		WebUI.takeScreenshot()
	}
		
	private void complitionDataRegistration(String usage, String address) {
		TestObject rdnSelfUsageRegis = createTestObject("rdnSelfUsageRegis", "xpath", "//label[text() = '$usage']/preceding-sibling::input")
		WebUI.click(rdnSelfUsageRegis)
		safetySelect(drpCopyAddressRegis, address, 1)
		WebUI.click(btnCopyAddressRegis)
		WebUI.takeScreenshot()
		WebUI.click(btnSaveRegis)
	}
	
	private void editInsuranceData(String schemeName, String rate, String insLength, String covType) {
		WebUI.click(btnEditInsuranceData)
		WebUI.takeScreenshot()
		
		safetySelect(drpSchemeName, schemeName, 1)
		safetySelect(drpRateType, rate, 1)
		WebUI.setText(txfInsuranceLength, insLength)
		safetySelect(drpMainCoverageType, covType)
		WebUI.takeScreenshot()
		safetyClick(btnNext, 5)
		WebUI.takeScreenshot()
		
		safetyClick(btnCalculateInsurance, 5)
		WebUI.takeScreenshot()
		
		safetyClick(btnSaveInsurance, 3)
		WebUI.takeScreenshot()
		safetyClick(btnNextInsuranceData, 1)
		WebUI.takeScreenshot()
	}
	
	
	private void clickSaveAndContinue() {
		safetyClick(btnSaveAndContinue, 0.5)
		WebUI.takeScreenshot()
	}
	
	private switchFrameForm() {
//		WebUI.switchToDefaultContent()
		WebUI.delay(5)
		WebUI.switchToFrame(iframeForm, 3)
	}
	
	
}
