package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.OPTIONAL
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.assertj.core.api.InstanceOfAssertFactories.INTEGER

import java.awt.Robot
import java.awt.event.KeyEvent

import org.openqa.selenium.By
import org.openqa.selenium.WebElement


import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
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
	private TestObject btnAddSupplierEmployee		= createTestObject("btnAddSupplierEmployee", "id", "lb_Form_Add_SupplBranchEmp")

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
	private TestObject btnLookUpCustomerName		= createTestObject("btnLookUpCustomerName", "xpath", "//input[@id = 'uclCust_uclCust_imb']")
	//pop up
	private TestObject txfCustomerName				= createTestObject("txfCustomerName", "id", "uclCust_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject btnSearchCustomerName		= createTestObject("btnSearchCustomerName", "xpath", "//a[@id = 'uclCust_uclCust_umd_ctl00_ucS_lbSearch']")
	private TestObject btnSelectCustomerName		= createTestObject("btnSelectCustomerName", "id", "uclCust_uclCust_umd_ctl00_gvL_hpSelect_0")//select first row


	//section tab gurantor
	private TestObject btnAddPersonalGurantor		= createTestObject("btnAddPersonalGurantor", "id", "lb_AgrmntGuarantor_AddPersonal")
	private TestObject btnAddCompanyGurantor		= createTestObject("btnAddCompanyGurantor", "id", "lb_AgrmntGuarantor_AddCompany")
	private TestObject btnLookUpGurantorName		= createTestObject("btnLookUpGurantorName", "id", "ucLookupCust_uclCust_imb")
	//pop up
	private TestObject txfGurantorName				= createTestObject("txfGurantorName", "id", "ucLookupCust_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject btnSearchGurantor			= createTestObject("btnSearchGurantor", "id", "ucLookupCust_uclCust_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectGurantor			= createTestObject("btnSelectGurantor", "id", "ucLookupCust_uclCust_umd_ctl00_gvL_hpSelect_0")
	private TestObject drpGurantorRelation			= createTestObject("drpGurantorRelation", "id", "ddlRefMasterCustRelation")
	private TestObject btnSaveGurantor				= createTestObject("btnSaveGurantor", "id", "lb_Form_Save")



	//section tab application data
	private TestObject txfTenor						= createTestObject("txfTenor", "id", "ucINTenor_txtInput")
	private TestObject drpPaymentFrequent			= createTestObject("drpPaymentFrequent", "id", "ucRefPaymentFreq_ddlReference")
	private TestObject drpMarginType				= createTestObject("drpMarginType", "id", "ucRefInterestType_ddlReference")
	private TestObject drpInstallamentScheme		= createTestObject("drpInstallamentScheme", "id", "ucRefInstScheme_ddlReference")

	//section application info
	private TestObject drpApplicationSource			= createTestObject("drpApplicationSource", "id", "ucRefAppSource_ddlReference")
	private TestObject drpWayOfPayment				= createTestObject("drpWayOfPayment", "id", "ucRefWOP_ddlReference")
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
	private TestObject txfMouNo 					= createTestObject("txfMouNo", "id", "ucLookupMOU_uclMOU_txt")
	private TestObject btnSearchMOUNo			= createTestObject("btnSearchMOUNo", "id", "ucLookupMOU_uclMOU_imb")
	private TestObject txfOvlyMOUNo				= createTestObject("txfOvlyMOUNo", "id", "ucLookupMOU_uclMOU_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject btnOvlySearchMOU			= createTestObject("btnOvlySearchMOU", "id", "ucLookupMOU_uclMOU_umd_ctl00_ucS_lbSearch")
	private TestObject btnOvlySelectMOU			= createTestObject("btnOvlySelectMOU", "id", "ucLookupMOU_uclMOU_umd_ctl00_gvL_hpSelect_0")



	//section tab asset data
	private TestObject btnAddAsset					= createTestObject("btnAddAsset", "id", "lb_Form_Add")
	private TestObject btnLookUpSupplier			= createTestObject("btnLookUpSupplier", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_imb")
	//pop up
	private TestObject txfSupplierBranchName		= createTestObject("txfSupplierBranchName", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject txfSupplierName				= createTestObject("txfSupplierName", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1")
	private TestObject txfSupplierAddress			= createTestObject("txfSupplierAddress", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_2")
	private TestObject btnSupplierSearch			= createTestObject("btnSupplierSearch", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectSupplier			= createTestObject("btnSelectSupplier", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_gvL_hpSelect_0")//select first row
	private TestObject drpSalesPerson				= createTestObject("drpSalesPerson", "id", "ucSalesPerson_ddlReference")
	//section top up agreement
	private TestObject btnLookUpTopUp				= createTestObject("btnLookUpTopUp", "id", "ucLookupTopUpAgrmnt_uclTopUpAgr_imb")
	//pop up
	private TestObject txfApplicationNoTopUP		= createTestObject("txfApplicationNoTopUP", "id", "ucLookupTopUpAgrmnt_uclTopUpAgr_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject txfAgreementNoTopUp			= createTestObject("txfAgreementNoTopUp", "id", "ucLookupTopUpAgrmnt_uclTopUpAgr_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1")
	private TestObject btnSearchTopUp				= createTestObject("btnSearchTopUp", "id", "ucLookupTopUpAgrmnt_uclTopUpAgr_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectTopUp				= createTestObject("btnSelectTopUp", "id", "ucLookupTopUpAgrmnt_uclTopUpAgr_umd_ctl00_gvL_hpSelect_0")
	//section main asset
	private TestObject btnLookUpAssetName			= createTestObject("btnLookUpAssetName", "xpath", "//input[@id = 'ucLookupAssetSchm_uclAssetSchm_imb' or @id = 'ucLookupAssetMaster_uclMaster_imb']")
	//pop up
	private TestObject txfAssetName					= createTestObject("txfAssetName", "xpath", "//input[@id = 'ucLookupAssetSchm_uclAssetSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0' or @id = 'ucLookupAssetMaster_uclMaster_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
	private TestObject btnAssetSearch				= createTestObject("btnAssetSearch", "xpath", "//a[@id = 'ucLookupAssetSchm_uclAssetSchm_umd_ctl00_ucS_lbSearch' or @id = 'ucLookupAssetMaster_uclMaster_umd_ctl00_ucS_lbSearch']")
	private TestObject btnSelectAsset				= createTestObject("btnSelectAsset", "xpath", "//a[@id = 'ucLookupAssetSchm_uclAssetSchm_umd_ctl00_gvL_hpSelect_0' or @id = 'ucLookupAssetMaster_uclMaster_umd_ctl00_gvL_hpSelect_0']")//select first row
	private TestObject txfAssetPrice				= createTestObject("txfAssetPrice", "id", "ucAssetPrice_txtInput")
	private TestObject txfDownPayment				= createTestObject("txfDownPayment", "xpath", "//input[@id = 'ucDownPaymentPrcnt_txtInput' or @id = 'ucDownPayment_txtInput']")
	private TestObject txfAssetNote					= createTestObject("txfAssetNote", "xpath", "//*[@id='txtNotesMainAss']")
	private TestObject btnGetMarketPrice			= createTestObject("btnGetMarketPrice", "id", "lb_Form_GetMktPrcAndCalcUpPrcnt")
	//section asset data09,.
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
	private TestObject btnSaveEditAsset				= createTestObject("btnSaveEditAsset", "id", "lb_Form_Save_AddEdit")

	//list of asset
	private TestObject btnPenAssetRegistration		= createTestObject("btnPenAssetRegistration", "id", "gvAssetList_imbEdit_0")//select first row
	//section asset owner
	private TestObject txfTaxDateRegis				= createTestObject("txfTaxDateRegis", "id", "ucTaxDate_txtDatePicker")
	private TestObject drpCopyAddressRegis			= createTestObject("drpCopyAddressRegis", "id", "ucCopyAddrOwner_ddlReference")
	private TestObject btnCopyAddressRegis			= createTestObject("btnCopyAddressRegis", "id", "lb_Form_Copy_OwnerAddr")
	private TestObject drpCopyAddressLocation		= createTestObject("drpCopyAddressLocation", "id", "ucCopyAddrAssLoc_ddlReference")
	private TestObject btnCopyAddressLocation		= createTestObject("btnCopyAddressLocation", "id", "lb_Form_Copy_Assloc")
	private TestObject btnSaveRegis					= createTestObject("btnSaveRegis", "xpath", "//a[@id = 'lb_Form_Save_Reg']")
	private TestObject tableDocListRegis			= createTestObject("tableDocListRegis", "id", "upAssetDoc")
	private TestObject btnAddAdditionalBranch		= createTestObject("btnAddAdditionalBranch", "id", "lb_Form_Add_Acc")
	private TestObject btnSearchAdditionBranch		= createTestObject("btnSearchAdditionBranch", "id", "gvAccessories_ucLookupSupplBranchSchm2_0_uclSupplBranchSchm_0_imb_0")
	private TestObject btnSearchAssetAccessoryName	= createTestObject("btnSearchAssetAccessoryName", "id", "uclLookupAccessories_0_imb_0")
	private TestObject txfAdditionalAssetPrice		= createTestObject("txfAdditionalAssetPrice", "id", "gvAccessories_ucInputNumber_0_txtInput_0")
	private TestObject txfAdditionalDpAmount		= createTestObject("txfAdditionalDpAmount", "id", "gvAccessories_ucInputNumber2_0_txtInput_0")
	private TestObject txfAdditionalNotes			= createTestObject("txfAdditionalNotes", "id", "gvAccessories_txtNotes_0")
	private TestObject txfOvlySearchName			= createTestObject("txfOvlySearchName", "xpath", "//*[@id='ucLookupAssetMaster_uclMaster_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0' or @id='ucLookupAssetSchm_uclAssetSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
	private TestObject txfOvlySearchAccName			= createTestObject("txfOvlySearchAccName", "id", "gvAccessories_ucLookupAccessories_0_uclLookupAccessories_0_umd_0_ctl00_0_ucS_0_rptFixedSearch_0_txtSearchValue_1")


	//section tab insurance data
	private TestObject btnCopyAllAssetInsurance		= createTestObject("btnCopyAllAssetInsurance", "id", "lb_Form_CopyToAll")
	private TestObject chkBoxInsuranceData			= createTestObject("chkBoxInsuranceData", "id", "gvEntryIns_cbCheckIns_0")//select first chk
	private TestObject btnEditInsuranceData			= createTestObject("btnEditInsuranceData", "id", "gvEntryIns_imbEdit_0")//select first row
	//section insurance data intialization
	private TestObject rdnInsuredBy					= createTestObject("rdnInsuredBy", "xpath", "//label[text() = '{data}']/preceding-sibling::input")
	private TestObject drpSchemeName				= createTestObject("drpSchemeName", "id", "ucInsInit_ucRefInsSchmName_ddlReference")
	private TestObject rdnCoverePeriod				= createTestObject("rdnCoverePeriod", "xpath", "//label[text() = '{data}']/preceding-sibling::input")
	private TestObject drpRateType					= createTestObject("drpRateType", "id", "ucInsInit_ucRefInsRateType_ddlReference")
	private TestObject txfInsuranceLength			= createTestObject("txfInsuranceLength", "id", "ucInsInit_ucINInsLength_txtInput")
	//section coverage
	private TestObject drpMainCoverageType			= createTestObject("drpMainCoverageType", "id", "ucRefMainCvgType_ddlReference")
	private TestObject btnNext						= createTestObject("btnNext", "id", "lb_Toolbar_Next")
	private TestObject btnCalculateInsurance		= createTestObject("btnCalculateInsurance", "id", "ucInsrate_lb_Form_Calculate")
	private TestObject btnSaveInsurance				= createTestObject("btnSaveInsurance", "id", "lbSave")
	private TestObject btnNextInsuranceData			= createTestObject("btnNextInsuranceData", "id", "lb_Form_Next")


	//section tab insurance life
	private TestObject chkCoverLifeInsurance		= createTestObject("chkCoverLifeInsurance", "id", "cbIsCoverLifeIns")
	private TestObject drpLifeInscoBranchName		= createTestObject("drpLifeInscoBranchName", "id", "ddlLifeInscoName")
	private TestObject drpPremiumPaymentMethod		= createTestObject("drpPremiumPaymentMethod", "id", "ddlPaymentMethod")
	private TestObject txfNotesLifeInsurance		= createTestObject("txfNotesLifeInsurance", "id", "txt_LifeInsH_NewCoverNotes")


	//section tab financial data
	private TestObject btnCalculateFee				= createTestObject("btnCalculateFee", "id", "lb_Form_CalcFee")
	private TestObject btnCalculate					= createTestObject("btnCalculate", "id", "lbCalculateFees")
	private TestObject btnCalculateInstallment		= createTestObject("btnCalculateInstallment", "id", "lbCalculateFinancialData")
	private TestObject btnCalculateCommission		= createTestObject("btnCalcultaeCommission", "id", "lb_Form_Calculate")
	private TestObject tableInstallment				= createTestObject("tableInstallment", "id", "gvAmortization")
	private TestObject txfAdminFeeAmount			= createTestObject("txfAdminFeeAmount", "id", "ucINAdminFeeAmt_txtInput")
	private TestObject txfNotaryAmount				= createTestObject("txfNotaryAmount", "id", "ucINNotaryFeeAmt_txtInput")
	private TestObject txfAdditionalAdminFee		= createTestObject("txfAdditionalAdminFee", "id", "ucINAddAdminFeeAmt_txtInput")
	private TestObject txfOtherFee					= createTestObject("txfOtherFee", "id", "ucINOtherFeeAmt_txtInput")
	private TestObject txfProvisionPercentage		= createTestObject("txfProvisionPercentage", "id", "ucINProvisionFeePrcnt_txtInput")
	private TestObject txfResidualValue				= createTestObject("txfResidualValue", "id", "ucINResidualValueAmt_txtInput")
	private TestObject drpRate						= createTestObject("drpRate", "id", "ucRefRate_ddlReference")
	private TestObject txfMargin					= createTestObject("txfMargin", "id", "ucINRate_txtInput")
	private TestObject txfGracePeriod				= createTestObject("txfGracePeriod", "id", "ucINGracePeriod_txtInput")
	private TestObject drpGracePeriod				= createTestObject("drpGracePeriod", "id", "ucRefGracePeriodType_ddlReference")
	private TestObject txfSpread					= createTestObject("txfSpread", "id", "ucINSpread_txtInput")
	private TestObject txfTDPPaidAtCompany			= createTestObject("txfTDPPaidAtCompany", "id", "ucINTDPPaidCoyAmt_txtInput")
	private TestObject drpSubsidySupplier			= createTestObject("drpSubsidySupplier", "id", "ucRefComSub_ddlReference")
	private TestObject txfSubsidyRate				= createTestObject("txfSubsidyRate", "id", "ucINDiffRateAmt_txtInput")
	private TestObject txfFiduciaAmount				= createTestObject("txfFiduciaAmount", "id", "ucINFiduciaFeeAmt_txtInput")



	//section tab commision data
	private TestObject btnCalculateCommision		= createTestObject("btnCalculateCommision", "id", "lb_Form_Calculate")
	private TestObject btnAddCommission				= createTestObject("btnAddCommission", "id", "lb_Form_Add_SupplBranchEmp")
	private TestObject btnLookUpCommission			= createTestObject("btnLookUpCommission", "id", "gvSupplEmpCommission_uclSupplBrcBasedOnApp2_0_uclSupplBrcApp_0_imb_0")
	private TestObject txfCommissionName			= createTestObject("txfCommissionName", "id", "gvSupplEmpCommission_uclSupplBrcBasedOnApp2_0_uclSupplBrcApp_0_umd_0_ctl00_0_ucS_0_rptFixedSearch_0_txtSearchValue_0")
	private TestObject btnSearchCommission			= createTestObject("btnSearchCommission", "id", "gvSupplEmpCommission_uclSupplBrcBasedOnApp2_0_uclSupplBrcApp_0_umd_0_ctl00_0_ucS_0_lbSearch_0")
	private TestObject btnSelectCommission			= createTestObject("btnSelectCommission", "id", "")
	private TestObject txfDiffOther					= createTestObject("txfDiffOther", "id", "gvSupplEmpCommission_ucinRefundFromOth2_0_txtInput_0")

	private TestObject btnSearchBranchName			= createTestObject("btnSearchBranchName", "id", "gvSupplEmpCommission_uclSupplBrcBasedOnApp2_0_uclSupplBrcApp_0_imb_0")
	private TestObject txfOverlayBranchName			= createTestObject("txfOverlayBranchName", "id", "gvSupplEmpCommission_uclSupplBrcBasedOnApp2_0_uclSupplBrcApp_0_umd_0_ctl00_0_ucS_0_rptFixedSearch_0_txtSearchValue_0")
	private TestObject btnOvlySearch				= createTestObject("btnOvlySearch", "id", "gvSupplEmpCommission_uclSupplBrcBasedOnApp2_0_uclSupplBrcApp_0_umd_0_ctl00_0_ucS_0_lbSearch_0")
	private TestObject btnOvlySelect				= createTestObject("btnOvlySelect", "id", "gvSupplEmpCommission_uclSupplBrcBasedOnApp2_0_uclSupplBrcApp_0_umd_0_ctl00_0_gvL_0_hpSelect_0")
	private TestObject drpEmployeeName				= createTestObject("drpEmployeeName", "id", "gvSupplEmpCommission_ucRefSupplBranchEmp_0_ddlReference_0")
	private TestObject txfDifOther					= createTestObject("txfDifOther", "id", "gvSupplEmpCommission_ucinRefundFromOth2_0_txtInput_0")

	//section tab other data :
	private TestObject txfReferantorName			= createTestObject("txfReferantorName", "id", "txtReferantorName")
	private TestObject txfAddressOtherData			= createTestObject("txfAddressOtherData", "id", "ucAddrReferantor_txtOfficeAddr")
	private TestObject txfRTOtherData				= createTestObject("txfRTOtherData", "id", "ucAddrReferantor_txtRT")
	private TestObject txfRWOtherData				= createTestObject("txfRWOtherData", "id", "ucAddrReferantor_txtRW")
	private TestObject btnSearchZipCodeOtherData	= createTestObject("btnSearchZipCodeOtherData", "id", "ucAddrReferantor_ucLookupZipCode_uclZipCode_imb")
	private TestObject txfOvlySearchZipCode			= createTestObject("txfOvlySearchZipCode", "id", "ucAddrReferantor_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_3")
	private TestObject btnOvlySearchZipCode			= createTestObject("btnOvlySearchZipCode", "id", "ucAddrReferantor_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_lbSearch")
	private TestObject btnOvlySelectZipCode			= createTestObject("btnOvlySelectZipCode", "id", "ucAddrReferantor_ucLookupZipCode_uclZipCode_umd_ctl00_gvL_hpSelect_0")

	//section tab other info
	private TestObject drpContractEmployee			= createTestObject("drpContractEmployee", "xpath", "//span[text() = 'Contract Employee Less Than Tenor']/following::select[1]")
	private TestObject drpRentalBusiness			= createTestObject("drpRentalBusiness", "xpath", "//span[text() = 'Rental Business Without Vehicle']/following::select[1]")
	private TestObject drpAssetForOnline			= createTestObject("drpAssetForOnline", "xpath", "//span[text() = 'Asset For Online Transport']/following::select[1]")
	private TestObject drpFraudIndication			= createTestObject("drpFraudIndication", "xpath", "//span[text() = 'Fraud Indication']/following::select[1]")
	private TestObject drpHighRiskCustomer			= createTestObject("drpHighRiskCustomer", "xpath", "//span[text() = 'High Risk Customer']/following::select[1]")
	private TestObject drpHighRiskBusiness			= createTestObject("drpHighRiskBusiness", "xpath", "//span[text() = 'High Risk Business']/following::select[1]")
	private TestObject drpHighRiskProduct			= createTestObject("drpHighRiskProduct", "xpath", "//span[text() = 'High Risk Product']/following::select[1]")
	private TestObject drpCreditApproval			= createTestObject("drpCreditApproval", "xpath", "//span[text() = 'Credit Approval Process']/following::select[1]")
	private TestObject drpOwnedVihecle				= createTestObject("drpOwnedVihecle", "xpath", "//span[text() = 'Owned Vehicle']/following::select[1]")
	private TestObject drpPrioritySeal				= createTestObject("drpPrioritySeal", "xpath", "//span[text() = 'Priority SEAL']/following::select[1]")
	private TestObject txfNPWP						= createTestObject("txfNPWP", "xpath", "//span[text() = 'NPWP a.n. STNK/BPKB']/following::input[1]")
	private TestObject txfNomorSK					= createTestObject("txfNomorSK", "xpath", "//span[text() = 'Nomor SK Kumham a.n. BPKB Badan']/following::input[1]")
	private TestObject drpSTNK						= createTestObject("drpSTNK", "xpath", "//span[text() = 'a.n STNK/BPKB Badan terdaftar di AHU']/following::select[1]")
	private TestObject drpStatusNPWP				= createTestObject("drpStatusNPWP", "xpath", "//span[text() = 'Status Kepemilikan NPWP']/following::select[1]")
	private TestObject drpCDENotes					= createTestObject("drpCDENotes", "xpath", "//span[text() = 'CDE NOTES']/following::select[1]")
	private TestObject txfOdoMeter					= createTestObject("txfOdoMeter", "xpath", "//span[text() = 'Odometer']/following::input[1]")
	private TestObject btnSaveOtherInfo				= createTestObject("btnSaveOtherInfo", "id", "lb_Form_Save")


	//section tab TnC
	private TestObject txfPromiseDateRequired		= createTestObject("", "id", "")
	private TestObject btnSaveTnC					= createTestObject("btnSaveTnC", "id", "lb_Form_Save")



	//button
	private TestObject btnSaveAndContinue			= createTestObject("btnSaveAndContinue", "id", "lb_Form_SaveCont")
	private TestObject btnSubmit					= createTestObject("btnSubmit", "id", "lbl_Toolbar_Submit")
	//jika memilih floating rate
	private TestObject drpFloatingPeriod			= createTestObject("", "id", "")
	private TestObject iframeMain					= createTestObject("iframeMain", "id", "mainPage")
	private TestObject iframeForm					= createTestObject("iframeForm", "xpath", "//iframe[@id = 'appForm']")


	//section Accessories
	private TestObject btnAddAccessories			= createTestObject("btnAddAccessories", "id", "lb_Form_Add_Acc")
	private TestObject btnLookUpSupAccessories		= createTestObject("btnLookUpSupAccessories", "id", "gvAccessories_ucLookupSupplBranchSchm2_0_uclSupplBranchSchm_0_imb_0")
	private TestObject txfSupAccessories			= createTestObject("txfSupAccessories", "id", "gvAccessories_ucLookupSupplBranchSchm2_0_uclSupplBranchSchm_0_umd_0_ctl00_0_ucS_0_rptFixedSearch_0_txtSearchValue_0")
	private TestObject btnSearchSupAccessories		= createTestObject("btnSearchSupAccessories", "id", "gvAccessories_ucLookupSupplBranchSchm2_0_uclSupplBranchSchm_0_umd_0_ctl00_0_ucS_0_lbSearch_0")
	private TestObject btnSelectSupAccessories		= createTestObject("btnSelectSupAccessories", "id", "gvAccessories_ucLookupSupplBranchSchm2_0_uclSupplBranchSchm_0_umd_0_ctl00_0_gvL_0_hpSelect_0")
	private TestObject btnLookUpAccessories			= createTestObject("btnLookUpAccessories", "id", "gvAccessories_ucLookupAccessories_0_uclLookupAccessories_0_imb_0")
	private TestObject txfNameAccessories			= createTestObject("txfNameAccessories", "id", "gvAccessories_ucLookupAccessories_0_uclLookupAccessories_0_umd_0_ctl00_0_ucS_0_rptFixedSearch_0_txtSearchValue_1")
	private TestObject btnSearchAccessories			= createTestObject("btnSearchAccessories", "id", "gvAccessories_ucLookupAccessories_0_uclLookupAccessories_0_umd_0_ctl00_0_ucS_0_lbSearch_0")
	private TestObject btnSelectAccessories			= createTestObject("btnSelectAccessories", "id", "gvAccessories_ucLookupAccessories_0_uclLookupAccessories_0_umd_0_ctl00_0_gvL_0_hpSelect_0")
	private TestObject txfAccessoriesPrice			= createTestObject("txfAccessoriesPrice", "id", "gvAccessories_ucInputNumber_0_txtInput_0")
	private TestObject txfAccessoriesDP				= createTestObject("txfAccessoriesDP", "id", "gvAccessories_ucInputNumber2_0_txtInput_0")
	private TestObject txfAccessoriesNote			= createTestObject("txfAccessoriesNote", "id", "gvAccessories_txtNotes_0")

	//copy asset
	private TestObject txfNumAsset					= createTestObject("txfNumAsset", "id", "txtNumOfCopyAsset")
	private TestObject btnCopyAsset					= createTestObject("btnCopyAsset", "id", "lb_Form_Copy_Ass")


	private void addAccessories(String supName, String accName, String price, String dp, String note) {
		WebUI.click(btnAddAccessories)
		handleAlertIfPresent()
		if(supName != "-") {
			safetyClick(btnAddAccessories)

			safetyClick(btnLookUpSupAccessories, 1)
			WebUI.setText(txfSupAccessories, supName)
			safetyClick(btnSearchSupAccessories, 1)
			safetyClick(btnSelectSupAccessories)


			safetyClick(btnLookUpAccessories, 1)
			WebUI.setText(txfNameAccessories, accName)
			safetyClick(btnSearchAccessories)
			safetyClick(btnSelectAccessories)

			manualClearText(txfAccessoriesPrice, 1)
			safetyInputEdit(txfAccessoriesPrice, price)
			manualClearText(txfAccessoriesDP, 1)
			safetyInputEdit(txfAccessoriesDP, dp)
			safetyInputEdit(txfAccessoriesNote, note)

			WebUI.takeScreenshot()
		}
	}

	private void copyAsset(String x) {
		String asset = (Integer.parseInt(x) - 1).toString()
		safetyInput(txfNumAsset, asset)

		safetyClick(btnCopyAsset, 2)
		WebUI.takeScreenshot()
	}

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
		safetyClick(btnLookUpOfferingName, 1)
		safetyInput(txfOfferingCode, productOfferingCode)
		safetyClick(btnOfferingSearch, 1)
		safetyClick(btnSelectOffering, 1)
		safetyInput(txfNumOfAsset, numOfAsset, 1)
		WebUI.takeScreenshot()

		safetyClick(btnNext)
	}

	private String getAppNo() {
		WebUI.takeScreenshot()
		return WebUI.getText(lblApplicationNumber)
	}

	private void saveApplicationNo(String appNo, String excelName, String scenarioId) {
		String excelFilePath = GlobalVariable.TEST_DATA_LOCATION + "/" + excelName
		Map criteria = ["ScenarioId":scenarioId]
		saveDataToExcel(appNo, criteria, excelFilePath, "MasterData", "ApplicationNo")
	}

	private void inputCustomerData(String type, String custName) {
		TestObject rdnType 	= createTestObject("rdnType", "xpath", "//label[text() = '$type']/preceding-sibling::input")
		scrollDown()
		safetyClick(rdnType, 1)
		safetyClick(btnLookUpCustomerName, 1)
		safetyInput(txfCustomerName, custName, 1)
		safetyClick(btnSearchCustomerName)
		safetyClick(btnSelectCustomerName, 2)
		WebUI.takeScreenshot()
	}

	private void addGurantorPersonal(String name, String relation) {
		if(name != '-') {
			safetyClick(btnAddPersonalGurantor, 1)
			WebUI.takeScreenshot()

			safetyClick(btnLookUpGurantorName,1)
			safetyInput(txfGurantorName, name)
			safetyClick(btnSearchGurantor, 1)
			safetyClick(btnSelectGurantor, 2)

			safetySelect(drpGurantorRelation, relation)
			WebUI.takeScreenshot()
			WebUI.click(btnSaveGurantor)
		}
	}

	private void addGurantorCompany(String name, String relation) {
		if(name != '-') {
			safetyClick(btnAddCompanyGurantor, 1)
			WebUI.takeScreenshot()

			safetyClick(btnLookUpGurantorName, 1)
			safetyInput(txfGurantorName, name)
			safetyClick(btnSearchGurantor, 1)
			safetyClick(btnSelectGurantor, 2)

			safetySelect(drpGurantorRelation, relation)
			WebUI.takeScreenshot()
			WebUI.click(btnSaveGurantor)
		}
	}

	private void inputApplicationData(String mouNo, String tenor, String payFreq, String margin, String installament, String FirstInstallmentType) {
		searchMOUNo(mouNo)
		safetyInput(txfTenor, tenor)
		safetySelect(drpPaymentFrequent, payFreq, 1)
		safetySelect(drpMarginType, margin, 1)
		safetySelect(drpInstallamentScheme, installament, 1)
		TestObject rdnFirstInstallmentType 		= createTestObject("rdnFirstInstallmentType", "xpath", "//label[text() = '$FirstInstallmentType']/preceding-sibling::input")
	}

	private void inputApplicationInfo(String appSource, String wayPay, String usage, String self, String fiducia) {
		safetySelect(drpApplicationSource, appSource, 1)
		safetySelect(drpWayOfPayment, wayPay, 1)
		if(WebUI.waitForElementPresent(drpPurposeOfUsage, 3, FailureHandling.OPTIONAL)) {
			safetySelect(drpPurposeOfUsage, usage, 1)
		}
		TestObject rdnSelfUsage = createTestObject("rdnSelfUsage", "xpath", "//label[text() = '$self']/preceding-sibling::input")
		TestObject rdnFiduciaCovered = createTestObject("rdnFiduciaCovered", "xpath", "//label[text() = '$fiducia']/preceding-sibling::input")

		safetyClick(rdnFiduciaCovered, 2)
		safetyClick(rdnFiduciaCovered, 2)
	}

	private void inputMailingAddress(String address) {
		safetySelect(drpCopyAddress, address, 1)
		safetyClick(btnCopyAddress, 2)
	}

	private void clickAddAsset() {
		safetyClick(btnAddAsset, 5)
		WebUI.takeScreenshot()
	}

	private void inputSupplierInfo(String name) {
		if(name != "-") {
			safetyClick(btnLookUpSupplier, 2)
			WebUI.setText(txfSupplierBranchName, name)
			safetyClick(btnSupplierSearch, 2)
			WebUI.click(btnSelectSupplier)
		}
	}

	private void selectSalesPerson(String name) {
		WebUI.delay(0.8)
		if(name != "-") {
			safetySelect(drpSalesPerson, name, 1)
		}
	}

	private void topUpAgreemnt(String label) {
		if(label != "-") {
			safetyClick(btnLookUpTopUp, 2)
			WebUI.setText(txfAgreementNoTopUp, label)
			safetyClick(btnSearchTopUp, 5)
			WebUI.takeScreenshot()
			safetyClick(btnSelectTopUp, 2)
		}
	}

	private void searchAssetMain(String assetName, String note) {
		if(assetName != "-") {
			safetyClick(btnLookUpAssetName, 1.5)
			safetyInput(txfAssetName, assetName, 1)
			safetyClick(btnAssetSearch, 1)
			WebUI.takeScreenshot()
			safetyClick(btnSelectAsset, 2)
			safetyInput(txfAssetNote, note, 1)
		}
	}

	private void inputMainAsset(String dpType, String assetPrice, String downPayment) {
		TestObject rdnDPType = createTestObject("rdnDPType", "xpath", "//label[text() = '$dpType']/preceding-sibling::input")
		safetyClick(rdnDPType, 2)
		manualClearText(txfAssetPrice)
		safetyInput(txfAssetPrice, assetPrice, 2)
		manualClearText(txfDownPayment)
		safetyInput(txfDownPayment, downPayment, 2)
	}

	private void clickGetMarketPrice() {
		if(WebUI.verifyElementPresent(btnGetMarketPrice, 3, FailureHandling.OPTIONAL)) {
			safetyClickYudho(btnGetMarketPrice, 1.5)
			WebUI.takeScreenshot()
		}
	}

	private void inputAssetData(String noMesin, String noRangka, String licenseNo, String conditoin, String usage, String year) {
		TestObject rdnAssetCondition = createTestObject("rdnAssetCondition", "xpath", "//label[text() = '$conditoin']/preceding-sibling::input")

		inputEdit(txfNoMesin, noMesin)
		inputEdit(txfNoRangka, noRangka)
		inputEdit(txfLicensePlate, licenseNo)
		WebUI.click(rdnAssetCondition)
		selectAsetUsage(usage)
		inputManufacturingYear(year)
	}

	private void inputEdit(TestObject to, String textInputted) {
		String randomStr = generateRandom5DigitString()
		if(textInputted) {
			// kalo auto bakal generate random string
			textInputted = textInputted.equalsIgnoreCase("AUTO") ? randomStr : textInputted
			safetyInputEdit(to, textInputted, 1.5)
		}
	}
	private String generateRandom5DigitString() {
		Random rnd = new Random()
		int number = (int) (Math.random() * 90000) + 10000
		return String.valueOf(number)
	}
	private void selectAsetUsage(String usage) {
		safetySelect(drpAssetUsage, usage, 1)
	}

	private void inputManufacturingYear(String year) {
		safetyInputEdit(txfManufacturingYear, year, 1.5)
	}


	private void inputAssetAttribute() {
		//bukan mandatory
	}

	private void addGrid(String serviceName, String branchName, String servicePrice) {
		if(serviceName != "-") {
			WebUI.click(btnAddGrid)
			WebUI.delay(1)

			safetySelect(drpAssetServiceName, serviceName)

			safetyClick(btnLookUpSupplierGird)
			WebUI.delay(1)
			safetyInput(txfSupplierBranchNameGrid, branchName)
			safetyClick(btnSupplierSearchGrid, 2)
			safetyClick(btnSelectSupplierGrid, 1)
			manualClearText(txfServicePrice)
			safetyInput(txfServicePrice, servicePrice)
			safetyClickYudho(btnSaveAsset, 1)
			WebUI.takeScreenshot()
		}
	}


	private void clickSaveAsset() {
		safetyClickYudho(btnSaveEditAsset, 4)
		WebUI.takeScreenshot()
	}

	private void selectAssetRegis() {
		safetyClick(btnPenAssetRegistration, 2)
		WebUI.delay(1)
		WebUI.takeScreenshot()
	}

	private void complitionDataRegistration(String usage, String address) {
		TestObject rdnSelfUsageRegis = createTestObject("rdnSelfUsageRegis", "xpath", "//label[text() = '$usage']/preceding-sibling::input")
		WebUI.click(rdnSelfUsageRegis)
		safetySelect(drpCopyAddressRegis, address, 3)
		safetyClick(btnCopyAddressRegis, 3)
		WebUI.takeScreenshot()
	}

	private void inputTaxDate(String date) {
		Robot bot = new Robot()

		TestObject mandatory = createTestObject("mandatory", "xpath", "(${getXpath(txfTaxDateRegis)}/following::span[@class = 'mandatoryStyle'])[1]")
		if(WebUI.verifyElementPresent(mandatory, 3, FailureHandling.OPTIONAL)) {
			WebUI.click(txfTaxDateRegis)
			safetyInput(txfTaxDateRegis, date, 2)
//			bot.keyPress(KeyEvent.VK_ESCAPE)
			pressEsc(txfTaxDateRegis)
		}
	}

	private void editInsuranceData(String schemeName, String rate, String covType) {
		safetyClick(btnEditInsuranceData, 0.5)
		WebUI.takeScreenshot()

		safetySelect(drpSchemeName, schemeName, 1)
		safetySelect(drpRateType, rate, 1)

		safetySelect(drpMainCoverageType, covType)
		safetyClick(btnNext, 5)
		WebUI.takeScreenshot()

		safetyClick(btnCalculateInsurance, 5)
		WebUI.takeScreenshot()

		WebUI.delay(3)
		safetyClick(btnSaveInsurance, 3)
		WebUI.takeScreenshot()
		safetyClick(btnNextInsuranceData, 1)
		WebUI.takeScreenshot()
	}

	private void editInsuranceDataMulti(String schemeName, String rate, String covType) {
		TestObject bottom = createTestObject("bottom", "xpath", "(//b[contains(text(), 'Total Main Premium')])[last()]")

		safetyClick(btnEditInsuranceData, 0.5)
		WebUI.takeScreenshot()

		safetySelect(drpSchemeName, schemeName, 1)
		safetySelect(drpRateType, rate, 1)

		safetySelect(drpMainCoverageType, covType)
		safetyClick(btnNext, 5)
		WebUI.takeScreenshot()

		safetyClick(btnCalculateInsurance, 5)
		WebUI.scrollToElement(bottom, 3)
		WebUI.takeScreenshot()

		WebUI.delay(3)
		safetyClick(btnSaveInsurance, 3)
		WebUI.takeScreenshot()
	}

	private void copyInsuranceAsset() {
		safetyClick(chkBoxInsuranceData, 1)

		safetyClick(btnCopyAllAssetInsurance, 1)

		safetyClick(btnNextInsuranceData, 1)
	}

	private void copyAssetLocation(String address) {
		WebUI.delay(5)
		safetySelect(drpCopyAddressLocation, address, 3)
		safetyClick(btnCopyAddressLocation, 3)
		WebUI.takeScreenshot()
	}

	private boolean checkTableRegis() {
		return WebUI.verifyElementPresent(tableDocListRegis, 5, FailureHandling.OPTIONAL)
	}

	private void checkMandatoryDocRegis() {

		def requiredDoc = getListElementByTestObject("//span[contains(@id, 'gvAssetDocEdit_lblIsMandatory_')]")
		def index = requiredDoc.size()

		index.times { i ->
			TestObject chkRequiredDocument = createTestObject("chkRequiredDocument", "xpath", "(//span[@id = 'gvAssetDocEdit_lblIsMandatory_$i' and text() = 'Yes']/following::input)[1]")
			if(WebUI.waitForElementPresent(chkRequiredDocument, 1, FailureHandling.OPTIONAL)) {
				safetyClick(chkRequiredDocument, 0.8)
			}
		}

		index.times { i ->
			TestObject txfDocument = createTestObject("txfDocument", "xpath", "(//span[@id = 'gvAssetDocEdit_lblIsValueNeeded_$i' and text() = 'Yes']/following::input[2])[1]")
			if(WebUI.verifyElementPresent(txfDocument, 2, FailureHandling.OPTIONAL)) {
				safetyInput(txfDocument, generateRandomNpwp(), 0.8)
			}
		}
	}

	private void clickSaveRegis() {
		WebUI.delay(1)
		WebUI.scrollToElement(btnSaveRegis, 3)
		safetyClick(btnSaveRegis)
	}

	private void inputInsuranceLife(String inscoName, String insured, String payMethod, String note) {

		def isChecked = WebUI.verifyElementChecked(chkCoverLifeInsurance, 5, FailureHandling.OPTIONAL)

		if(!isChecked) {
			WebUI.check(chkCoverLifeInsurance)
			safetySelect(drpLifeInscoBranchName, inscoName, 1)
			TestObject chkCustomerInsured = createTestObject("chkCustomerInsured", "xpath", "//label[text() = '$insured']/preceding-sibling::input")
			safetyClick(chkCustomerInsured, 1)
			safetySelect(drpPremiumPaymentMethod, payMethod, 1)
			WebUI.setText(txfNotesLifeInsurance, note)
			WebUI.takeScreenshot()
		}
	}

	private void calculateFinancialData() {
		safetyClick(btnCalculateFee, 2)
		safetyClick(btnCalculate, 2)
		safetyClick(btnCalculateInstallment, 2)
		def tableSxist = WebUI.waitForElementPresent(tableInstallment, 10, FailureHandling.OPTIONAL)
		if(tableSxist) {
			WebUI.scrollToElement(tableInstallment, 3)
			WebUI.takeScreenshot()
		}else {
			KeywordUtil.logInfo("table installment not exist")
		}
	}

	private void selectApplicationAttribute1(String contractLessThen, String rentalBusiness, String onlineTransport, String fraud, String riskCust, String riskBuss, String riskProd, String creditProses) {
		safetySelectEdit(drpContractEmployee, contractLessThen, 1)
		safetySelectEdit(drpRentalBusiness, rentalBusiness, 1)
		safetySelectEdit(drpAssetForOnline, onlineTransport, 1)
		safetySelectEdit(drpFraudIndication, fraud, 1)
		safetySelectEdit(drpHighRiskCustomer, riskCust, 1)
		safetySelectEdit(drpHighRiskBusiness, riskBuss, 1)
		safetySelectEdit(drpHighRiskProduct, riskProd, 1)
		safetySelectEdit(drpCreditApproval, creditProses, 1)
	}

	private void selectApplicationAttribute2(String ownVehicle, String seal, String npwp, String noSK, String stnk, String statusNPWP, String cde, String odo) {
		safetySelectEdit(drpOwnedVihecle, ownVehicle, 1)
		safetySelectEdit(drpPrioritySeal, seal, 1)
		safetyInput(txfNPWP, npwp, 1)
		safetyInput(txfNomorSK, noSK, 1)
		safetySelectEdit(drpSTNK, stnk, 1)
		safetySelectEdit(drpStatusNPWP, statusNPWP, 1)
		safetySelectEdit(drpCDENotes, cde, 1)
		safetyInputEdit(txfOdoMeter, odo)
	}

	private void clickSaveAttribute() {
		WebUI.takeScreenshot()
		safetyClick(btnSaveOtherInfo)
	}


	private void tncDocumentMandatory() {
		WebUI.delay(15)
		def requiredDoc = getListElementByTestObject("//span[contains(@id, 'gvTermCondition_lblIsMandatory_')]")
		def index = requiredDoc.size()
		KeywordUtil.logInfo("$index")

		index.times { i ->
			TestObject chkRequiredDocument = createTestObject("chkRequiredDocument", "xpath", "(//span[@id = 'gvTermCondition_lblIsMandatory_$i' and text() = 'Yes']/following::input)[1]")
			if(WebUI.waitForElementPresent(chkRequiredDocument, 1, FailureHandling.OPTIONAL)) {
				safetyClick(chkRequiredDocument, 0.8)
			}
			KeywordUtil.logInfo("$i")
		}

		WebUI.takeScreenshot()
	}

	private void clickSaveTnC() {
		WebUI.click(btnSaveTnC)
		WebUI.delay(8)
		WebUI.takeScreenshot()
	}

	private void clickSaveAndContinue() {
		def exist = WebUI.verifyElementPresent(btnSaveAndContinue, 3, FailureHandling.OPTIONAL)
		if(exist) {
			safetyClick(btnSaveAndContinue, 0.5)
			handleAlertIfPresent()
			WebUI.takeScreenshot()
		}
	}

	private switchFrameForm() {
		WebUI.delay(5)
		WebUI.switchToFrame(iframeForm, 3)
	}

	private clickSubmitNAP() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeMain, 3)
		WebUI.click(btnSubmit)
		WebUI.delay(15)
		WebUI.acceptAlert()
		WebUI.delay(15)
		WebUI.takeScreenshot()
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
	private void clickCalculateFee() {
		safetyClick(btnCalculateFee)
	}

	private void clickCalculateInstallment() {
		safetyClick(btnCalculateInstallment)
		handleAlertIfPresent()
	}
	private void clickCalculate() {
		safetyClick(btnCalculate)
	}
	private void clickCalculateCommission() {
		safetyClick(btnCalculateCommision)
		handleAlertIfPresent()
	}
	private void searchSupplierBranchName(String branchName) {
		if(branchName && WebUI.verifyElementPresent(btnSearchBranchName, 2, OPTIONAL)) {
			safetyClick(btnSearchBranchName)
			WebUI.delay(0.5)

			safetyInput(txfOverlayBranchName, branchName)
			WebUI.delay(0.5)
			safetyClick(btnOvlySearch)
			WebUI.takeScreenshot()

			safetyClick(btnOvlySelect)
		}
	}

	private void selectEmployeeName(String name) {
		if(name && WebUI.verifyElementPresent(drpEmployeeName, 2, OPTIONAL)) {
			WebElement element = WebUI.findWebElement(drpEmployeeName)
			List<WebElement> options = element.findElements(By.tagName("option"))
			boolean isFound = false

			for (WebElement opt : options) {
				if (opt.getText().trim().equalsIgnoreCase(name)) {
					safetySelect(drpEmployeeName, name)
					isFound = true
					break
				}
			}
			isFound ? null : selectFirstOption(drpEmployeeName, name)
		} else {
			KeywordUtil.markWarning("Option not clickable or disabled")
		}
	}
	private void inputDifOther(String difOther) {
		if(difOther && WebUI.verifyElementPresent(txfDifOther, 2, OPTIONAL)) {
			manualClearText(txfDifOther)
			safetyInput(txfDifOther, difOther)
			WebUI.delay(0.5)
		}
	}

	private void addSupplierEmployeeSection(String branchName, String employeeName, String difOther) {
		if(branchName) {
			safetyClick(btnAddSupplierEmployee)
			WebUI.takeScreenshot()
			searchSupplierBranchName(branchName)
			selectEmployeeName(employeeName)
			inputDifOther(difOther)
			handleAlertIfPresent()
			WebUI.takeScreenshot()
		}
	}
	private void inputIfDifferent(TestObject to, String expectedValue) {
		//get current value from text field
		String currentValue = WebUI.getAttribute(to, "value")
		if(currentValue == null) {
			currentValue = ""
		}
		if(currentValue.equalsIgnoreCase(expectedValue)) {
			WebUI.comment("Value already matches: $expectedValue, no input needed")
		} else {
			WebUI.comment(" Value is different. Current; $currentValue, expected: $expectedValue")
			manualClearText(to)
			safetyInput(to, expectedValue)
			WebUI.delay(2)
		}
	}
	private void inputMadeIn(String madeIn) {
		if(madeIn) {
			inputIfDifferent(txfMadeIn, madeIn)
			WebUI.delay(2)
		}
	}

	private void inputCylinder(String cylinder) {
		if(cylinder) {
			inputIfDifferent(txfCylinder, cylinder)
			WebUI.delay(2)
		}
	}

	private void inputTransmition(String transmition) {
		if(transmition) {
			inputIfDifferent(txfTransmition, transmition)
			WebUI.delay(2)
		}
	}

	private void inputColor(String color) {
		if(color) {
			inputIfDifferent(txfColor, color)
			WebUI.delay(2)
		}
	}

	private void selectRegion(String region) {
		if(region) {
			safetySelect(drpRegion, region)
			WebUI.delay(2)
		}
	}

	private void inputAssetAttributeSection(String madeIn, String cylinder, String transmition, String color, String region) {
		inputMadeIn(madeIn)
		inputCylinder(cylinder)
		inputTransmition(transmition)
		inputColor(color)
		selectRegion(region)
	}

	private boolean inputAccessoriesGridSection(String branchName, String accessoryName, String assetPrice, String dpAmount, String notes) {
		if (branchName == null || accessoryName.trim().isEmpty()) {
			KeywordUtil.logInfo("Supplier branch input string is empty or null. Skipping input.")
			return false
		}
		WebUI.scrollToElement(btnAddAdditionalBranch, 2)
		//check duplicate
		Map result = checkDuplicateAndGetRow(branchName, accessoryName)
		boolean isDuplicate = result['isDuplicate']
		int rowIndex = result['rowIndex']
		if(!isDuplicate) {
			WebUI.delay(0.5)
			btnSearchAdditionBranch		= createTestObject("btnSearchAdditionBranch", "id", "gvAccessories_ucLookupSupplBranchSchm2_${rowIndex}_uclSupplBranchSchm_${rowIndex}_imb_${rowIndex}")
			btnSearchAssetAccessoryName = createTestObject("btnSearchAssetAccessoryName", "id", "uclLookupAccessories_${rowIndex}_imb_${rowIndex}")
			txfAdditionalAssetPrice 	= createTestObject("txfAdditionalAssetPrice", "id", "gvAccessories_ucInputNumber_${rowIndex}_txtInput_${rowIndex}")
			txfAdditionalDpAmount		= createTestObject("txfAdditionalDpAmount", "id", "gvAccessories_ucInputNumber2_${rowIndex}_txtInput_${rowIndex}")
			txfAdditionalNotes			= createTestObject("txfAdditionalNotes", "id", "gvAccessories_txtNotes_${rowIndex}")

			WebUI.comment("Not found duplicate, input index $rowIndex .")
			safetyClick(btnAddAdditionalBranch)

			searchAdditionalBranchName(branchName, rowIndex)
			searchAccName(accessoryName, rowIndex)
			inputAdditionalAssetPrice(assetPrice, rowIndex)
			inputAdditionalDpAmount(dpAmount, rowIndex)
			inputAdditionalNotes(notes, rowIndex)
		} else {
			WebUI.comment("Data duplicate, Skipping input.")
		}
	}

	/**
	 * Cek apakah ada duplikat Supplier Branch + Accessories Name
	 * @return Map [isDuplicate: boolean, rowIndex: int] kalo tidak duplikat return rownya berapa untuk get button lookup searchnya
	 */
	private Map checkDuplicateAndGetRow(String supplierBranchName, String accessoriesName) {
		TestObject grid, branchInput, accessoryInput
		grid = createTestObject("grid", "xpath", "//span[starts-with(@id,'gvAccessories_lblNo')]")
		if(!WebUI.verifyElementPresent(grid, 5, OPTIONAL)) {
			KeywordUtil.logInfo("⚠️ Table is empty, rowIndex = 0")
			return [isDuplicate: false, rowIndex: 0]  // row pertama untuk input
		}
		def rows = WebUiCommonHelper.findWebElements(grid, 5)
		boolean isDuplicate = false
		int foundRow
		KeywordUtil.logInfo("index " + rows.size())

		for (int i = 1; i <= rows.size(); i++) {
			branchInput 	= createTestObject("branchInput","xpath", "(//input[contains(@name,'ucLookupSupplBranchSchm2') and @type= 'text'])[$i]")
			accessoryInput  = createTestObject("accessoryInput","xpath", "(//input[contains(@name,'uclLookupAccessories') and @type='text'])[$i]")

			String currentBranch = WebUI.getAttribute(branchInput, 'value').trim()
			String currentAccessories = WebUI.getAttribute(accessoryInput, 'value').trim()

			if (currentBranch.equalsIgnoreCase(supplierBranchName) && currentAccessories.equalsIgnoreCase(accessoriesName)) {
				isDuplicate = true
				foundRow = i
				break
			}
		}

		if (!isDuplicate) {
			foundRow = rows.size()
		}

		return [isDuplicate: isDuplicate, rowIndex: foundRow]
	}

	private void searchAdditionalBranchName(String additionalBranchName, int index) {
		txfOvlySearchName = createTestObject("txfOvlySearchName", "xpath", "//*[contains(@id, 'rptFixedSearch_${index}_txtSearchValue_0')]")
		btnOvlySearch 	  = createTestObject("btnOvlySearch", "id", "gvAccessories_ucLookupSupplBranchSchm2_${index}_uclSupplBranchSchm_${index}_umd_${index}_ctl00_${index}_ucS_${index}_lbSearch_${index}")
		btnOvlySelect     = createTestObject("btnOvlySelect", "id", "gvAccessories_ucLookupSupplBranchSchm2_${index}_uclSupplBranchSchm_${index}_umd_${index}_ctl00_${index}_gvL_${index}_hpSelect_0")

		safetyClick(btnSearchAdditionBranch)
		WebUI.delay(1)
		safetyInput(txfOvlySearchName, additionalBranchName)
		safetyClick(btnOvlySearch)
		WebUI.delay(1)
		WebUI.takeScreenshot()
		safetyClick(btnOvlySelect)
		WebUI.delay(1)
	}
	private void searchAccName(String accName, int index) {
		btnSearchAssetAccessoryName = createTestObject("btnSearchAssetAccessoryName", "id", "uclLookupAccessories_${index}_imb_${index}")
		txfOvlySearchAccName		= createTestObject("txfOvlySearchAccName", "id", "gvAccessories_ucLookupAccessories_${index}_uclLookupAccessories_${index}_umd_${index}_ctl00_${index}_ucS_${index}_rptFixedSearch_${index}_txtSearchValue_1")
		btnOvlySearch 				= createTestObject("btnOvlySearch", "id", "gvAccessories_ucLookupAccessories_${index}_uclLookupAccessories_${index}_umd_${index}_ctl00_${index}_ucS_${index}_lbSearch_${index}")
		btnOvlySelect  				= createTestObject("btnOvlySelect", "id", "gvAccessories_ucLookupAccessories_${index}_uclLookupAccessories_${index}_umd_${index}_ctl00_${index}_gvL_${index}_hpSelect_0")
		btnSearchAssetAccessoryName	= createTestObject("btnSearchAssetAccessoryName", "id", "uclLookupAccessories_${index}_imb_${index}")

		safetyClick(btnSearchAssetAccessoryName)
		safetyInput(txfOvlySearchAccName, accName)
		safetyClick(btnOvlySearch)
		WebUI.takeScreenshot()
		safetyClick(btnOvlySelect)
	}
	private void inputAdditionalAssetPrice(String assetPrice, int index) {
		if(assetPrice) {
			txfAdditionalAssetPrice	= createTestObject("txfAdditionalAssetPrice", "id", "gvAccessories_ucInputNumber_${index}_txtInput_${index}")
			manualClearText(txfAdditionalAssetPrice)
			safetyInput(txfAdditionalAssetPrice, assetPrice)
			WebUI.delay(2)
		}
	}

	private void inputAdditionalDpAmount(String dpAmount, int index) {
		if(dpAmount) {
			txfAdditionalDpAmount= createTestObject("txfAdditionalDpAmount", "id", "gvAccessories_ucInputNumber2_${index}_txtInput_${index}")
			manualClearText(txfAdditionalDpAmount)
			safetyInput(txfAdditionalDpAmount, dpAmount)
			WebUI.delay(2)
		}
	}
	private void inputAdditionalNotes(String notes, int index) {
		if(notes) {
			txfAdditionalNotes	= createTestObject("txfAdditionalNotes", "id", "gvAccessories_txtNotes_${index}")
			safetyInput(txfAdditionalNotes, notes)
			WebUI.delay(2)
		}
	}

	private void searchMOUNo(String mouNo) {
		String strMou = WebUI.getText(txfMouNo)
		if(mouNo?.trim() && !strMou.equalsIgnoreCase(mouNo)) {
			safetyClick(btnSearchMOUNo)
			safetyInput(txfOvlyMOUNo, mouNo)
			safetyClick(btnOvlySearchMOU)
			WebUI.takeScreenshot()
			WebUI.delay(2)
			safetyClick(btnOvlySelectMOU)
		}
	}

	private void inputReferantor(String name, String address, String rt, String rw, String zipCode, String phone1, String phone2, String phone3, String fax,
			String mobilePhone1, String mobilePhone2, String mobilePhone3, String email1, String email2) {
			
		WebUI.delay(2)
		inputIfPresent(txfReferantorName, name)
		inputAddress(zipCode, rt, rw, address)
		inputPhoneNumbers(phone1, 1)
		inputPhoneNumbers(phone2, 2)
		inputPhoneNumbers(phone3, 3)
		inputFax(fax)
		inputMobilePhone(mobilePhone1, 1)
		inputMobilePhone(mobilePhone2, 2)
		inputMobilePhone(mobilePhone3, 3)
		inputEmails(email1, 1)
		inputEmails(email2, 2)
		WebUI.takeScreenshot()
	}

	private void inputIfPresent(TestObject to, String textInputted) {
		if(textInputted) {
			safetyInput(to, textInputted)
			WebUI.comment("Input.. $textInputted")
			WebUI.delay(0.8)
		}
	}

	private void inputAddress(String zipCode, String rt, String rw, String address) {
		safetyClick(btnSearchZipCodeOtherData)
		handleAlertIfPresent()
		if(WebUI.verifyElementPresent(btnSearchZipCodeOtherData, 2, FailureHandling.OPTIONAL)) {
			safetyClick(btnSearchZipCodeOtherData)
		}
		WebUI.delay(0.2)

		safetyInput(txfOvlySearchZipCode, zipCode)
		safetyClick(btnOvlySearchZipCode)
		WebUI.delay(0.2)
		WebUI.takeScreenshot()

		safetyClick(btnOvlySelectZipCode)

		inputIfPresent(txfAddressOtherData, address)
		inputIfPresent(txfRTOtherData, rt)
		inputIfPresent(txfRWOtherData, rw)
	}

	private void inputPhoneNumbers(String phoneNumber, int index) {
		if(phoneNumber) {
			if(phoneNumber == "AUTO") {
				phoneNumber = generateRandomPhone(true)
			}
			TestObject countryField, areaField, numberField
			countryField	= createTestObject("countryField", "xpath", "//*[@id='ucAddrReferantor_txtPhnArea${index}']")
			areaField		= createTestObject("areaField", "xpath", "//*[@id='ucAddr_txtPhn${index}' or @id='ucAddrReferantor_txtPhn${index}']")
			numberField		= createTestObject("numberField", "xpath", "//*[@id='ucAddr_txtPhoneExt${index}'or @id='ucAddrReferantor_txtPhoneExt${index}']")

			KeywordUtil.logInfo("phone " + phoneNumber)
			String[] parts = phoneNumber.split("-")
			if (parts.size() != 3) {
				KeywordUtil.markWarning("Invalid phone format: ${phoneNumber}. Expected format is XXX-XXX-XXX")
			}

			safetyInput(countryField, parts[0])
			safetyInput(areaField, parts[1])
			safetyInput(numberField, parts[2])
		}
	}

	private void inputFax(String fax) {
		if(fax) {
			TestObject countryField, areaField
			countryField	= createTestObject("countryField", "xpath", "//*[@id='ucAddrReferantor_txtFaxArea']")
			areaField		= createTestObject("areaField", "xpath", "//*[@id='ucAddrReferantor_txtFax']") 

			String[] parts = fax.split("-")
			if (parts.size() != 3) {
				KeywordUtil.markWarning("Invalid phone format: ${fax}. Expected format is XXX-XXX")
			}
			safetyInput(countryField, parts[0])
			WebUI.delay(2)
			safetyInput(areaField, parts[1])
			WebUI.delay(2)
		}
	}
	private void inputMobilePhone(String phone, int index) {
		if(phone) {
			if(phone =="AUTO") {
				phone = generateRandomPhone()
			}
			TestObject countryField    = createTestObject("countryField", "xpath", "//*[@id='txtReferantorMobilePhn${index}']")
			safetyInput(countryField, phone)
			WebUI.delay(0.3)
		}
	}

	private void inputEmails(String email, Integer index) {
		if(email) {
			TestObject txfEmail    = createTestObject("txfEmail", "xpath", "//*[@id='txtReferantorEmail${index}']")
			safetyInput(txfEmail, email)
		}
	}
}
