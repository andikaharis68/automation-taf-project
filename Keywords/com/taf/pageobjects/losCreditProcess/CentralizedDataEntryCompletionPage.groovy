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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class CentralizedDataEntryCompletionPage extends BaseHelper {
	//iframe
	private TestObject iframeMainpage 			= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")

	//header
	private TestObject btnDataDukcapil 			= createTestObject("btnDataDukcapil", "id", "lb_Toolbar_Dukcapil")
	private TestObject btnSubmit 				= createTestObject("btnSubmit", "id", "lb_Toolbar_Submit")
	private TestObject btnSave 					= createTestObject("btnSave", "id", "lb_Toolbar_Save")

	//search
	private TestObject txfCustomerName 			= createTestObject("txfCustomerName", "id", "ucSearch_txtCustName_ltlCustCustName")
	private TestObject btnSearch 				= createTestObject("btnSearch", "id", "ucSearch_btnSearch")
	
	//table
	private TestObject btnPencil 				= createTestObject("btnPencil", "id", "gvProspectList_imbAction_0")
	private TestObject txtFirstProspectNo 		= createTestObject("txtFirstProspectNo", "id", "gvProspectList_lbProspectNo_0")

	//info from deal and decision
	private TestObject txfNotesInfo 			= createTestObject("txfNotesInfo", "id", "txtNoteFromSupplBranchEmp")

	//customer main data
	private TestObject lblCustomertype 			= createTestObject("lblCustomertype", "id", "lbl_Customer_CustomerType")
	private TestObject drpGender 				= createTestObject("drpGender", "id", "ucMrGender_ddlReference")
	private TestObject drpReligion 				= createTestObject("drpReligion", "id", "ucMrReligion_ddlReference")
	private TestObject drpEducation 			= createTestObject("drpEducation", "id", "ucMrEducation_ddlReference")
	private TestObject txfMobilePhone 			= createTestObject("txfMobilePhone", "id", "txtMobilePhnNo1")
	private TestObject txfMotherName 			= createTestObject("txfMotherName", "id", "txtMotherMaidenName")

	//Company main data
	private TestObject btnIconIndustryType		= createTestObject("btnIconIndustryType", "id", "ucLookupIndustry_uclIndustry_imb")
	private TestObject ovlIndustryTypeName		= createTestObject("ovlIndustryTypeName", "id", "ucLookupIndustry_uclIndustry_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_3")
	private TestObject ovlSearchIndustryType	= createTestObject("ovlSearchIndustryType", "id", "ucLookupIndustry_uclIndustry_umd_ctl00_ucS_lbSearch")
	private TestObject ovlSelectIndustryType	= createTestObject("ovlSelectIndustryType", "id", "ucLookupIndustry_uclIndustry_umd_ctl00_gvL_hpSelect_0")
	private TestObject txfNumbOfEmployee		= createTestObject("txfNumbOfEmployee", "id", "ucINNumOfEmp_txtInput")
	private TestObject txfEstablisDate			= createTestObject("txfEstablisDate", "id", "ucDPEstablishmentDate_txtDatePicker")
	private TestObject radAffiliation			= createTestObject("radAffiliation", "id", "cb_Cust_IsAffiliateWithMf")
	
	
	//contact result
	private TestObject txtCallSucceded 			= createTestObject("txtCallSucceded", "id", "txtMotherMaidenName")
	private TestObject drpReason 				= createTestObject("drpReason", "id", "ucFailedReason_ddlReference")
	private TestObject drpCPRelationdhip 		= createTestObject("drpCPRelationdhip", "xpath", "//*[@id = 'ucRefCntctedPersonRelation_ddlReference' or @id = 'ucRefContactPersonRelation_ddlReference']")
	
	private TestObject drpSurveyorCode 			= createTestObject("drpSurveyorCode", "id", "ucRefSurveyorCode_ddlReference")
	private TestObject txfContactedName 		= createTestObject("txfContactedName", "id", "txtContactedPerson")
	private TestObject txfNotesContactResult 	= createTestObject("txfNotesContactResult", "id", "txtCntctResultNotes")

	//customer job data
	private TestObject drpJobPosition 			= createTestObject("drpJobPosition", "id", "ucMrJobPosition_ddlReference")
	private TestObject drpJobStatus				= createTestObject("drpJobStatus", "id", "ucMrJobStat_ddlReference")
	private TestObject txfCompanyName			= createTestObject("txfCompanyName", "id", "txtCoyName")
	private TestObject drpMonthEmploymentDate 	= createTestObject("drpMonthEmploymentDate", "id", "ucEstablishmentDt_ddlMonth")
	private TestObject txfYearEmploymentDate	= createTestObject("txfYearEmploymentDate", "id", "ucEstablishmentDt_txtYear")
	private TestObject drpSurveyProfession 		= createTestObject("drpSurveyProfession", "id", "ucTeleSurveyProfession_ddlReference")

	//customer job data - lookup profession name
	private TestObject icoLookUpProfessionName 	= createTestObject("icoLookUpProfessionName", "id", "uclProfession_uclProf_imb")
	private TestObject txfProfessionName 		= createTestObject("txfProfessionName", "id", "uclProfession_uclProf_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject btnSearchProfessionName 	= createTestObject("btnSearchProfessionName", "id", "uclProfession_uclProf_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectProfessionName 	= createTestObject("btnSelectProfessionName", "id", "uclProfession_uclProf_umd_ctl00_gvL_hpSelect_0")

	//customer job data - lookup industry type name
	private TestObject icoLookUpIndustry 		= createTestObject("icoLookUpIndustry", "id", "uclIndustry_uclIndustry_imb")
	private TestObject txfIndustryTypeName 		= createTestObject("txfIndustryTypeName", "id", "uclIndustry_uclIndustry_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_3")
	private TestObject btnSearchIndustry 		= createTestObject("btnSearchIndustry", "id", "uclIndustry_uclIndustry_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectIndustry 		= createTestObject("btnSelectIndustry", "id", "uclIndustry_uclIndustry_umd_ctl00_gvL_hpSelect_0")

	//customer address listing
	private TestObject btnPencilResidenceAddress= createTestObject("btnPencilResidenceAddress", "xpath", "(//*[text() = 'Residence Address']//following::*[contains(@id,'gvAddr_imbEdit')])[1]")
	private TestObject btnPencilCompanyAddress	= createTestObject("btnPencilCompanyAddress", "xpath", "(//*[text() = 'Company Address']//following::*[contains(@id,'gvCustAddress_imbEdit')])[1]")
	private TestObject btnPencilJobAddress 		= createTestObject("btnPencilJobAddress", "xpath", "(//*[text() = 'Job Address']//following::*[contains(@id,'gvAddr_imbEdit')])[1]")
	private TestObject btnAddAddress 			= createTestObject("btnAddAddress", "id", "lb_Form_Add")
	private TestObject btnDeleteLegalAddress 	= createTestObject("btnDeleteLegalAddress", "xpath", "(//*[text() = 'Legal Address']//following::*[contains(@id,'gvCustAddress_imbDelete')])[1]")
	
	//Legal Doocument
	private TestObject btnAddLegalDocument		= createTestObject("btnAddLegalDocument", "id", "lb_Form_Add_LegalDocument")
	private TestObject drpDocType				= createTestObject("drpDocType", "id", "ucMrLegalDocType_ddlReference")
	private TestObject txfDocNo					= createTestObject("txtDocNo", "id", "txtDocNo")
	private TestObject txfDateIssued			= createTestObject("txtDocNo", "id", "ucDPDocDt_txtDatePicker")
	private TestObject btnSaveLegalDoc			= createTestObject("btnSaveLegalDoc", "id", "lb_Form_Save_LegalDoc")

	//customer address listing - residence address main, job address & legal address
	private TestObject btnSaveAddress			= createTestObject("btnSaveResidenceAddress", "xpath", "//*[@id = 'lb_Form_Save' or @id = 'lb_Form_Save_CustAddr']")
	private TestObject txfRT					= createTestObject("txfRT", "xpath", "//*[@id = 'ucAddr_txtRT' or @id = 'ucAddress_txtRT']")
	private TestObject txfRW					= createTestObject("txfRW", "xpath", "//*[@id = 'ucAddr_txtRW' or @id = 'ucAddress_txtRW']")
	private TestObject txfResidenceAddress		= createTestObject("txfResidenceAddress", "xpath", "//*[@id = 'ucAddr_txtOfficeAddr' or @id = 'ucAddress_txtOfficeAddr']")
	private TestObject txfPhoneAreaResidence	= createTestObject("txfPhoneAreaResidence", "xpath", "//*[@id = 'ucAddr_txtPhnArea1' or @id = 'ucAddress_txtPhnArea1']")
	private TestObject txfPhoneResidence		= createTestObject("txfPhoneResidence", "xpath", "//*[@id = 'ucAddr_txtPhn1' or @id = 'ucAddress_txtPhn1']")
	private TestObject txfPhoneExtResidence		= createTestObject("txfPhoneExtResidence", "xpath", "//*[@id = 'ucAddr_txtPhoneExt1' or @id = 'ucAddress_txtPhoneExt1']")

	private TestObject drpCopyAddress			= createTestObject("drpCopyAddress", "id", "ucCopyAddr_ddlReference")
	private TestObject btnCopy					= createTestObject("btnCopy", "xpath", "//*[@id = 'lb_Form_Copy_Addr' or @id = 'lb_Form_CopyAddr']")
	private TestObject drpAddressType			= createTestObject("drpAddressType", "xpath", "//*[@id = 'ucAddrType_ddlReference' or @id = 'ucRefAddressType_ddlReference']")
	
	//company shareholder
	private TestObject btnAddShareholderCompany	= createTestObject("btnAddShareholder", "id", "lb_Form_AddCompany_Management")
	private TestObject btnSearchShareholder		= createTestObject("btnSearchShareholder", "id", "ucCustMainDataCoy_ucLookupCust_uclCust_imb")
	private TestObject txfPopupInputName		= createTestObject("txfPopupInputName", "id", "ucCustMainDataCoy_ucLookupCust_uclCust_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject btnPopupSearch			= createTestObject("btnPopupSearch", "id", "ucCustMainDataCoy_ucLookupCust_uclCust_umd_ctl00_ucS_lbSearch")
	private TestObject btnPopupSelect			= createTestObject("btnPopupSelect", "id", "ucCustMainDataCoy_ucLookupCust_uclCust_umd_ctl00_gvL_hpSelect_0")
	private TestObject txfSharePercent			= createTestObject("txfSharePercent", "id", "ucINSharePercentageCoy_txtInput")
	private TestObject btnSaveShareholder		= createTestObject("btnSaveShareholder", "id", "lb_Form_Save_AddCoyManShareListing")
	private TestObject btnDeleteShareHolder		= createTestObject("btnDeleteShareHolder", "id", "gvManagement_imbDelete_0")
	
	//company contact info
	private TestObject txfContactInfoName		= createTestObject("txfContactInfoName", "id", "txt_CustEmergencyContact_Name")
	private TestObject drpContactInfoJobPosition= createTestObject("drpContactInfoJobPosition", "id", "ucRefPersonalJobPositionEmergency_ddlReference")

	//customer address listing - residence address main - zipcode lookup
	private TestObject icoLookUpZipCode			= createTestObject("icoLookUpZipCode", "xpath", "//*[@id='ucAddr_ucLookupZipCode_uclZipCode_imb' or @id = 'ucAddress_ucLookupZipCode_uclZipCode_imb']")
	private TestObject txfKelurahan				= createTestObject("txfKelurahan", "id", "ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
	private TestObject txfKecamatan				= createTestObject("txfKecamatan", "id", "ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1")
	private TestObject txfCity					= createTestObject("txfCity", "id", "ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_2")
	private TestObject txfZipCode				= createTestObject("txfZipCode", "xpath", "//*[@id = 'ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_3' or @id = 'ucAddress_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_3']")
	private TestObject btnSearchZipCode			= createTestObject("btnSearchZipCode", "xpath", "//*[@id = 'ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_lbSearch' or @id = 'ucAddress_ucLookupZipCode_uclZipCode_umd_ctl00_ucS_lbSearch']")
	private TestObject btnSelectZipCode			= createTestObject("btnSelectZipCode", "xpath", "//*[@id = 'ucAddr_ucLookupZipCode_uclZipCode_umd_ctl00_gvL_hpSelect_0' or @id = 'ucAddress_ucLookupZipCode_uclZipCode_umd_ctl00_gvL_hpSelect_0']")

	//customer address listing - residence address info
	private TestObject drpBuildingType			= createTestObject("drpBuildingType", "id", "ucAddrInfoCust_ucMrBuildingType_ddlReference")
	private TestObject drpBuildingOwner			= createTestObject("drpBuildingOwner", "xpath", "//*[@id = 'ucAddrInfoCust_ucOwnershipStat_ddlReference' or @id = 'ucAddressInfo_ucOwnershipStat_ddlReference']")
	private TestObject txfBuildingStay			= createTestObject("txfBuildingStay", "xpath", "//*[@id = 'ucAddrInfoCust_txtStayLength_txtInput' or @id = 'ucAddressInfo_txtStayLength_txtInput']")

	//income
	private TestObject txfGrossMonthlyIncome	= createTestObject("txfGrossMonthlyIncome", "id", "txt_CustFinData_GrossMonthlyIncomeAmt_txtInput")
	private TestObject txfGrossProfit			= createTestObject("txfGrossProfit", "id", "txt_CustFinData_GrossProfitAmt_txtInput")
	private TestObject txfOtherIncome			= createTestObject("txfOtherIncome", "id", "txt_CustFinData_OthIncomeAmt_txtInput")
	private TestObject txfSourceOfOtherIncome	= createTestObject("txfSourceOfOtherIncome", "id", "txt_CustFinData_SourceOfOthIncome")
	private TestObject txfLivingCost			= createTestObject("txfLivingCost", "id", "txt_CustFinData_LivingCostAmt_txtInput")
	private TestObject txfOtherMonthlyInstallment = createTestObject("txfOtherMonthlyInstallment", "id", "txt_CustFinData_OthMonthlyInstAmt_txtInput")
	private TestObject btnCalculateIncome		= createTestObject("btnCalculateIncome", "id", "btnCalculate")
	
	//attribute list
	private TestObject drpDebitorBusinessScale	= createTestObject("drpDebitorBusinessScale", "id", "ucAddrInfoCust_txtStayLength_txtInput")
	private TestObject txfAccountFlag			= createTestObject("txfAccountFlag", "id", "rptOtherAttribute_txtAttrContent_0")
	private TestObject txfAccountDate			= createTestObject("txfAccountDate", "id", "rptOtherAttribute_txtAttrContent_1")
	private TestObject txfCustRating			= createTestObject("txfCustRating", "id", "rptOtherAttribute_txtAttrContent_2")
	private TestObject txfGoodBadStatus			= createTestObject("txfGoodBadStatus", "id", "rptOtherAttribute_txtAttrContent_3")
	private TestObject txfTerdugaTeroris		= createTestObject("txfTerdugaTeroris", "id", "rptOtherAttribute_txtAttrContent_4")
	private TestObject txfNoSim					= createTestObject("txfNoSim", "id", "rptOtherAttribute_txtAttrContent_5")
	private TestObject chxIsSplitTreasure		= createTestObject("chxIsSplitTreasure", "xpath", "(//*[text() = 'IS SPLIT TREASURE']//following::*[contains(@id , 'rptOtherAttribute_cbxAttrValue')])[1]")
	private TestObject chxViolateBMPK			= createTestObject("chxViolateBMPK", "xpath", "(//*[text() = 'VIOLATE BMPK']//following::*[contains(@id , 'rptOtherAttribute_cbxAttrValue')])[1]")
	private TestObject chxExceedBMPK			= createTestObject("chxExceedBMPK", "xpath", "(//*[text() = 'EXCEED BMPK']//following::*[contains(@id , 'rptOtherAttribute_cbxAttrValue')])[1]")
	private TestObject txfNoATM					= createTestObject("txfNoATM", "id", "rptOtherAttribute_txtAttrContent_16")
	private TestObject txfRatingDebitor			= createTestObject("txfRatingDebitor", "xpath", "(//*[text() = 'RATING DEBITOR']//following::*[contains(@id,'rptOtherAttribute_txtAttrContent')])[1]")

	//attribute list - debitor group lookup
	private TestObject icoDebitorBusinessGroup	= createTestObject("icoDebitorBusinessGroup", "id", "UCDebtGrp_ucBebtGroup_imb")
	private TestObject txfDescDebitor			= createTestObject("txfDescDebitor", "id", "UCDebtGrp_ucBebtGroup_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1")
	private TestObject btnSearchDebitor			= createTestObject("btnSearchDebitor", "id", "UCDebtGrp_ucBebtGroup_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectDebitor			= createTestObject("btnSelectDebitor", "id", "UCDebtGrp_ucBebtGroup_umd_ctl00_gvL_hpSelect_0")

	//attribute list - counterpart category lookup
	private TestObject icoCounterpartCategory	= createTestObject("icoCounterpartCategory", "id", "UCCounterpart_ucCounterpart_imb")
	private TestObject txfDescCounterpart		= createTestObject("txfDescCounterpart", "id", "UCCounterpart_ucCounterpart_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1")
	private TestObject btnSearchCounterpart		= createTestObject("btnSearchCounterpart", "id", "UCCounterpart_ucCounterpart_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectCounterpart		= createTestObject("btnSelectCounterpart", "id", "UCCounterpart_ucCounterpart_umd_ctl00_gvL_hpSelect_0")
	
	//attribute list - Sustainable Financial Lookup
	private TestObject icoSustainable			= createTestObject("icoSustainable", "id", "UCSustainableFinancial_ucSustainableFinancial_imb")
	private TestObject txfDescSustainable		= createTestObject("txfDescSustainable", "id", "UCSustainableFinancial_ucSustainableFinancial_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1")
	private TestObject btnSearchSustainable		= createTestObject("btnSearchSustainable", "id", "UCSustainableFinancial_ucSustainableFinancial_umd_ctl00_ucS_lbSearch")
	private TestObject btnSelectSustainable		= createTestObject("btnSelectSustainable", "id", "UCSustainableFinancial_ucSustainableFinancial_umd_ctl00_gvL_hpSelect_0")

	//attribute list - debitor group slik lookup
	private TestObject icoDebitorGroupSlik		= createTestObject("icoDebitorGroupSlik", "xpath", "(//*[contains(text(),'DEBITOR GROUP SLIK')]//following::input[@type = 'image'])[1]")
	private TestObject txfDebitorGroupSlik		= createTestObject("txfDebitorGroupSlik", "xpath", "//*[@id = 'rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_umd_7_ctl00_7_ucS_7_rptFixedSearch_7_txtSearchValue_0' or @id = 'rptOtherAttribute_UCRefMaster_3_ucLookupRefMaster_3_umd_3_ctl00_3_ucS_3_rptFixedSearch_3_txtSearchValue_0']")
	private TestObject btnSearchDebitorGroupSlik= createTestObject("btnSearchDebitorGroupSlik", "xpath", "//*[@id = 'rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_umd_7_ctl00_7_ucS_7_lbSearch_7' or @id = 'rptOtherAttribute_UCRefMaster_3_ucLookupRefMaster_3_umd_3_ctl00_3_ucS_3_lbSearch_3']")
	private TestObject btnSelectDebitorGroupSlik= createTestObject("btnSelectDebitorGroupSlik", "xpath", "//*[@id = 'rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_umd_7_ctl00_7_gvL_7_hpSelect_0' or @id = 'rptOtherAttribute_UCRefMaster_3_ucLookupRefMaster_3_umd_3_ctl00_3_gvL_3_hpSelect_0']")

	//attribute list - affiliate with multifinance slik
	private TestObject icoAffiliateSlik			= createTestObject("icoAffiliateSlik", "xpath", "(//*[contains(text(),'AFFILIATE WITH MULTIFINANCE SLIK')]//following::input[@type = 'image'])[1]")
	private TestObject txfAffiliateSlik			= createTestObject("txfAffiliateSlik", "xpath", "//*[@id = 'rptOtherAttribute_UCRefMaster_10_ucLookupRefMaster_10_umd_10_ctl00_10_ucS_10_rptFixedSearch_10_txtSearchValue_0' or @id= 'rptOtherAttribute_UCRefMaster_9_ucLookupRefMaster_9_umd_9_ctl00_9_ucS_9_rptFixedSearch_9_txtSearchValue_0']")
	private TestObject btnSearchAffiliateSlik	= createTestObject("btnSearchAffiliateSlik", "xpath", "//*[@id = 'rptOtherAttribute_UCRefMaster_10_ucLookupRefMaster_10_umd_10_ctl00_10_ucS_10_lbSearch_10' or @id= 'rptOtherAttribute_UCRefMaster_9_ucLookupRefMaster_9_umd_9_ctl00_9_ucS_9_lbSearch_9']")
	private TestObject btnSelectAffiliateSlik	= createTestObject("btnSelectAffiliateSlik", "xpath", "//*[@id = 'rptOtherAttribute_UCRefMaster_10_ucLookupRefMaster_10_umd_10_ctl00_10_gvL_10_hpSelect_0' or @id= 'rptOtherAttribute_UCRefMaster_9_ucLookupRefMaster_9_umd_9_ctl00_9_gvL_9_hpSelect_0']")

	//application info
	private TestObject drpWayOfPayment			= createTestObject("drpWayOfPayment", "xpath", "//*[@id = 'ucRefWOP_ddlReference' or @id = 'ucRefWop_ddlReference']")

	//list of asset
	private TestObject btnPencilAsset 			= createTestObject("btnPencilAsset", "id", "gvAsset_imbEdit_0")

	//asset user
	private TestObject txtSelfUsage
	private TestObject btnSaveAssetUser			= createTestObject("btnSaveAssetUser", "xpath", "//*[@id = 'lbSaveAsset' or @id = 'lb_Form_Save_AssetList']")

	//asset location
	private TestObject drpCopyAddressAsset		= createTestObject("drpCopyAddressAsset", "id", "ucCopyAddrAssLoc_ddlReference")
	private TestObject btnCopyAddressAsset		= createTestObject("btnCopyAddressAsset", "id", "lb_Form_Copy_Assloc")
	private TestObject drpCopyAddressOwner		= createTestObject("drpCopyAddressOwner", "id", "ucCopyAddrOwner_ddlReference")
	private TestObject btnCopyAddressOwner		= createTestObject("btnCopyAddressOwner", "id", "lb_Form_Copy_OwnerAddr")
	private TestObject drpOwnerIdType			= createTestObject("drpOwnerIdType", "id", "ucMrIdType_ddlReference")

	//other asset info
	private TestObject txfAssetUsage			= createTestObject("txfAssetUsage", "id", "ucRefAssetUsage_ddlReference")
	private TestObject txfSurveyUnitUsage		= createTestObject("txfSurveyUnitUsage", "id", "ucTeleSurveyUnitUsage_ddlReference")
	private TestObject radYesOnline				= createTestObject("radYesOnline", "id", "rblAssetOnlTransport_0")
	private TestObject radNoOnline				= createTestObject("radNoOnline", "id", "rblAssetOnlTransport_1")
	private TestObject radYesValid				= createTestObject("radYesValid", "id", "rblSpkValid_0")
	private TestObject radNoValid				= createTestObject("radNoValid", "id", "rblSpkValid_1")
	private TestObject txfUsageAssetOnline		= createTestObject("txfUsageAssetOnline", "id", "txtUsageAssetOnl")
	private TestObject txfSpkNo					= createTestObject("txfSpkNo", "id", "txtSpkNo")
	
	//popup success
	private TestObject lblSuccess				= createTestObject("txfSurveyUnitUsage", "text", "Submit Success")

	public void switchToIframeMain() {
		WebUI.switchToFrame(iframeMainpage, 1)
	}

	public void switchToDefaultContent() {
		WebUI.switchToDefaultContent()
	}

	public void searchCentralizedDataCompletion(String customerName) {
		WebUI.waitForElementPresent(txfCustomerName, 5)
		WebUI.takeScreenshot()
		safetyInput(txfCustomerName, customerName)
		safetyClick(btnSearch)
	}
	
	public Boolean checkIsSearchResultFound() {
		if (WebUI.waitForElementPresent(btnPencil, 5, FailureHandling.OPTIONAL)) {
			return true
		}else {
			return false
		}
	}
	
	public void delay() {
		WebUI.delay(GlobalVariable.WAIT)
//		WebUI.refresh()
		KeywordUtil.logInfo("Already Delay ${GlobalVariable.WAIT} seconds, and ready to search again!")
	}
	
	public void clickActionPencil() {
		WebUI.takeScreenshot()
		safetyClick(btnPencil)
	}
	
	public void clickResultByFirstProspectNo() {
		safetyClick(txtFirstProspectNo)
	}

	public void inputInfoDealAndDecision(String notes) {
		WebUI.takeScreenshot()
		safetyInput(txfNotesInfo, notes)
	}
	
	public boolean getCustomerTypeIsCompany() {
		if(WebUI.waitForElementPresent(lblCustomertype, 5)) {
			return true
		} else {
			return false
		}
	}

	public void inputCustomerMainData(String customerModel, String gender, String religion, String education, String mobilePhone, String motherName) {
		TestObject lblCustomerModel = createTestObject("lblCustomerModel", "xpath", "//*[contains(@id, 'rblCustModel')]//*[text() = '${customerModel}']")
		safetyClick(lblCustomerModel)
		safetySelect(drpGender, gender)
		safetySelect(drpReligion, religion)
		safetySelect(drpEducation, education)
		safetyInput(txfMobilePhone, mobilePhone)
		safetyClick(txfMotherName)
		safetyInput(txfMotherName, motherName)
	}
	
	public void inputCustomerMainDataCompany(String indutryTypeName, String numberOfEmployee, String establishmentDate, String affiliationWithMultifinance) {
		safetyClick(btnIconIndustryType)
		safetyInput(ovlIndustryTypeName, indutryTypeName)
		safetyClick(ovlSearchIndustryType)
		safetyClick(ovlSelectIndustryType)
		safetyInput(txfNumbOfEmployee, numberOfEmployee)
		safetyInput(txfEstablisDate, establishmentDate)
		if(affiliationWithMultifinance == "Y") {			
			safetyClick(radAffiliation)
		}
	}


	public void inputContactResult(String isCallSucceded, String reason, String cpRelationship, String surveyorCode, String contactedName, String notes) {
		txtCallSucceded = createTestObject("txtCallSucceded", "xpath", "//*[@id = 'rblIsCallSucceded']//label[text() = '$isCallSucceded']")//Yes or No
		safetyClick(txtCallSucceded)
		WebUI.delay(5)
		safetySelect(drpReason, reason)
		safetySelect(drpCPRelationdhip, cpRelationship)
		safetySelect(drpSurveyorCode, surveyorCode)

		safetyInput(txfContactedName, contactedName)
		safetyInput(txfNotesContactResult, notes)
	}

	public void inputCustomerJobData(String professionName, String industryTypeName, String jobPosition, String jobStatus, String companyName, String employmentMonth, String employmentYear, String surveyProfession) {
		//pofession name
		safetyClick(icoLookUpProfessionName)
		safetyInput(txfProfessionName, professionName)
		safetyClick(btnSearchProfessionName)
		safetyClick(btnSelectProfessionName)
		//industry type name
		safetyClick(icoLookUpIndustry)
		safetyInput(txfIndustryTypeName, industryTypeName)
		safetyClick(btnSearchIndustry)
		safetyClick(btnSelectIndustry)

		safetySelect(drpJobPosition, jobPosition)
		safetySelect(drpJobStatus, jobStatus)
		safetyInput(txfCompanyName, companyName)
		//employment establishment date
		safetySelect(drpMonthEmploymentDate, employmentMonth)
		WebUI.delay(1)
		safetyClick(txfYearEmploymentDate)
		safetyInput(txfYearEmploymentDate, employmentYear, 1)

		safetySelect(drpSurveyProfession, surveyProfession)
		WebUI.takeScreenshot()
	}

	public void clickEditResidenceAddress() {
		safetyClick(btnPencilResidenceAddress)
	}
	
	public void clickEditCompanyAddress() {
		safetyClick(btnPencilCompanyAddress)
	}

	public void inputResidenceAddressMain(String zipCode, String residenceAddress, String rt, String rw, String phoneArea, String phone, String phoneExt) {
		WebUI.takeScreenshot()
		//lookup zipcode
		safetyClick(icoLookUpZipCode)
		safetyInput(txfZipCode, zipCode)
		safetyClick(btnSearchZipCode)
		safetyClick(btnSelectZipCode)

		safetyInput(txfResidenceAddress, residenceAddress)

		//rt rw
		safetyInput(txfRT, rt)
		safetyInput(txfRW, rw)

		//phone 1
		safetyInput(txfPhoneAreaResidence, phoneArea)
		safetyInput(txfPhoneResidence, phone)
		safetyInput(txfPhoneExtResidence, phoneExt)
	}

	public void inputResidenceAddressInfo(String buildingType = '', String buildingOwner, String buildingStayLength) {
		if(buildingType) {			
			safetySelect(drpBuildingType, buildingType)
		}
		safetySelect(drpBuildingOwner, buildingOwner)
		manualClearText(txfBuildingStay)
		safetyInput(txfBuildingStay, buildingStayLength)
		WebUI.takeScreenshot()
	}

	public void clickSaveAddress() {
		safetyClick(btnSaveAddress)
		WebUI.takeScreenshot()
	}
	
	public void inputCompnyShareHolder() {
		if(WebUI.waitForElementPresent(btnDeleteShareHolder, 2)) {
			safetyClick(btnDeleteShareHolder)
		}
		safetyClick(btnAddShareholderCompany)
		safetyClick(btnSearchShareholder)
		safetyInput(txfPopupInputName, "%")
		safetyClick(btnPopupSearch)
		safetyClick(btnPopupSelect)
		manualClearText(txfSharePercent)
		safetyInput(txfSharePercent, "100")
		WebUI.takeScreenshot()
		safetyClick(btnSaveShareholder)
	}
	
	public void inputCompanyContactInfo(String name, String jobPosition) {
		safetyInput(txfContactInfoName, name)
		safetySelect(drpContactInfoJobPosition, jobPosition)
	}
	
	public void inputLegalDocument(String docNo, String dateIssue) {
		List<String> docTypes = ["AKTA PENDIRIAN", "LAST AKTA"]
		docTypes.forEach { docType -> 			
			safetyClick(btnAddLegalDocument)
			safetySelect(drpDocType, docType)
			safetyInput(txfDocNo, docNo)
			safetyInput(txfDateIssued, dateIssue)
			WebUI.takeScreenshot()
			safetyClick(btnSaveLegalDoc)
		}
	}
	
	public void clickEditJobAddress() {
		safetyClick(btnPencilJobAddress)
	}

	public void copyJobAddressFromResidenceAddress() {
		safetySelect(drpCopyAddress, "Residence Address")
		safetyClick(btnCopy)
		WebUI.takeScreenshot()
	}

	public void clickAddAddress() {
		if(WebUI.waitForElementPresent(btnDeleteLegalAddress, 3)) {
			safetyClick(btnDeleteLegalAddress)
		}
		safetyClick(btnAddAddress)
	}

	public void copyAndAddLegalAddressFromResidenceAddress() {
		safetySelect(drpCopyAddress, "Residence Address")
		safetyClick(btnCopy)
		safetySelect(drpAddressType, "Legal Address")
		WebUI.takeScreenshot()
	}
	
	public void copyFromCompanyAddress() {
		safetySelect(drpAddressType, "Legal Address")
		safetyClick(btnCopy)
		WebUI.takeScreenshot()
	}
	
	public void inputIncome(String grossMonthly, String grossProfit, String otherIncome, String sourceOfOtherIncome, String livingCost, String otherMonthly) {
		manualClearText(txfGrossMonthlyIncome)
		safetyInput(txfGrossMonthlyIncome, grossMonthly)
		
		manualClearText(txfGrossProfit)
		safetyInput(txfGrossProfit, grossProfit)
		
		manualClearText(txfOtherIncome)
		safetyInput(txfOtherIncome, otherIncome)
		
		safetyInput(txfSourceOfOtherIncome, sourceOfOtherIncome)
		
		manualClearText(txfLivingCost)
		safetyInput(txfLivingCost, livingCost)
		
		manualClearText(txfOtherMonthlyInstallment)
		safetyInput(txfOtherMonthlyInstallment, otherMonthly)
	}
	
	public void clickCalculateIncome() {
		safetyClick(btnCalculateIncome)
		WebUI.takeScreenshot()
	}

	public void inputAttributeList(String debitorGroup, String debitorScale, String counterpartCategory, String debitorGroupSlik, String affiliateMultifinanceSlik) {
		//debitor group
		safetyClick(icoDebitorBusinessGroup)
		safetyInput(txfDescDebitor, debitorGroup)
		safetyClick(btnSearchDebitor)
		safetyClick(btnSelectDebitor)
		//safetySelect(drpDebitorBusinessScale, debitorScale) ini di comment karena, auto input setelah calculate pada section income

		//counterpart category
		safetyClick(icoCounterpartCategory)
		safetyInput(txfDescCounterpart, counterpartCategory)
		safetyClick(btnSearchCounterpart)
		safetyClick(btnSelectCounterpart)

		//debitor group slik
		safetyClick(icoDebitorGroupSlik)
		safetyInput(txfDebitorGroupSlik, debitorGroupSlik)
		safetyClick(btnSearchDebitorGroupSlik)
		safetyClick(btnSelectDebitorGroupSlik)

		//debitor group slik
		safetyClick(icoAffiliateSlik)
		safetyInput(txfAffiliateSlik, affiliateMultifinanceSlik)
		safetyClick(btnSearchAffiliateSlik)
		safetyClick(btnSelectAffiliateSlik)
		WebUI.takeScreenshot()
	}
	
	public void selectSustainableFinancial(String sustainable) {
		safetyClick(icoSustainable)
		safetyInput(txfDescSustainable, sustainable)
		safetyClick(btnSearchSustainable)
		safetyClick(btnSelectSustainable)
		WebUI.takeScreenshot()
	}
	
	public void inputEAccountFlag(String flag) {
		safetyClick(txfAccountFlag)
		safetyInput(txfAccountFlag, flag)
	}
	
	public void inputEAccountJoinDate(String joinDate) {
		safetyClick(txfAccountDate)
		safetyInput(txfAccountDate, joinDate)
	}
	
	public void inputCustRating(String rating) {
		Boolean isInteractable = checkElementIsInteractable(txfCustRating)
		if (isInteractable) {
			safetyClick(txfCustRating)
			safetyInput(txfCustRating, rating)
		}
	}
	
	public void inputGoodBadStatus(String status) {
		Boolean isInteractable = checkElementIsInteractable(txfCustRating)
		if (isInteractable) {
			safetyClick(txfGoodBadStatus)
			safetyInput(txfGoodBadStatus, status)			
		}
	}
	
	public void inputTerdugaTeroris(String dugaan) {
		safetyClick(txfTerdugaTeroris)
		safetyInput(txfTerdugaTeroris, dugaan)
	}
	
	public void inputNoSIM(String noSim) {
		safetyClick(txfNoSim)
		safetyInput(txfNoSim, noSim)
	}
	
	public void checkIsSplitTreasure(String isSplit) {
		if(isSplit && isSplit == 'Y') {
			WebUI.check(chxIsSplitTreasure)
		}
	}
	
	public void checkViolateBMPK(String bmpk ) {
		if(bmpk && bmpk == "Y") {
			WebUI.check(chxViolateBMPK)
		}
	}

	public void checkExceedBMPK(String bmpk) {
		if(bmpk && bmpk == "Y") {
			WebUI.check(chxExceedBMPK)
		}
	}
	
	public void checkSameAddress(String sameAddress, String index) {
		if (sameAddress) {
			String labelText = sameAddress.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText, index) //11
		}
	}

	public void checkSameJob(String sameJob, String index) {
		if (sameJob) {
			String labelText = sameJob.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText, index)
		}
	}
	public void checkSamePosition(String samePosition, String index) {
		if (samePosition) {
			String labelText = samePosition.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText, index)
		}
	}
	public void checkDifferentMaritalStatus(String maritalStatus, String index) {
		KeywordUtil.logInfo(maritalStatus)
		if (maritalStatus) {
			String labelText = maritalStatus.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText, index)
		}
	}
	public void checkHomeOwnershipDoc(String ownership, String index) {
		if (ownership) {
			String labelText = ownership.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText, index)
		}
	}

	public void checkCustomerDataConsent(String dataConsent, String index) {
		if(dataConsent) {
			String labelText = dataConsent.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText, index)
		}
	}
	
	public void checkCDENotes(String notes, String index) {
		if (notes) {
			String labelText = notes.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText, index)
		}
	}
	public void inputATMNo(String atmNo) {
		if(atmNo) {
			safetyInput(txfNoATM, atmNo)
		}
	}
	
	public void inputRatingDebitor(String rating) {
		if(rating) {
			safetyInput(txfRatingDebitor, rating)
		}
	}
	
	public void clickYesNo(String labelText, String index) {
		TestObject radYesNo = createTestObject("radYesNo", "xpath", "//label[normalize-space(text())='$labelText']/preceding-sibling::input[@type='radio'and contains(@id, 'rblAttrValue_$index')]")
		safetyClick(radYesNo)
	}

	public void selectWayOfPayment(String wayOfPayment) {
		safetySelect(drpWayOfPayment, wayOfPayment)
		WebUI.takeScreenshot()
	}

	public void clickEditAsset() {
		safetyClick(btnPencilAsset)
	}

	public void inputAssetUser(String selfUsage) {
		txtSelfUsage = createTestObject("txtSelfUsage", "xpath", "//*[@id = 'rblAssetUser']//label[text() = '$selfUsage']")

		safetyClick(txtSelfUsage)
		WebUI.takeScreenshot()
	}

	public void copyAddressAssetOwner() {
		safetySelect(drpCopyAddressAsset, "Legal Address")
		safetyClick(btnCopyAddressOwner)
	}

	public void copyAssetLocationFromLegalAddress() {
		safetySelect(drpCopyAddressAsset, "Legal Address")
		safetyClick(btnCopyAddressAsset)
		WebUI.takeScreenshot()
	}
	
	public void selectOwnerIdType(String idType) {
		safetySelect(drpOwnerIdType, idType)
	}

	public void inputOtherAssetInfo(String assetUsage, String teleSurveyUnitUsage) {
		safetySelect(txfAssetUsage, assetUsage)
		safetySelect(txfSurveyUnitUsage, teleSurveyUnitUsage)
		WebUI.takeScreenshot()
	}
	
	public void checkAssetOnlineTransport(String onlineTransport) {
		if(onlineTransport && onlineTransport == "Y") {
			safetyClick(radYesOnline)
		}else {
			safetyClick(radNoOnline)
		}
	}
	
	public void inputUsageAssetForOnlineTransport(String usageTransport) {
		safetyInput(txfUsageAssetOnline, usageTransport)
	}
	
	public void inputSPKNo(String spkNo) {
		safetyInput(txfSpkNo, spkNo)
	}
	
	public void checkSpkValid(String valid) {
		if(valid && valid == "Y") {
			safetyClick(radYesValid)
		}else {
			safetyClick(radNoValid)
		}
	}

	public void clickSaveAssetUser() {
		safetyClick(btnSaveAssetUser)
		WebUI.takeScreenshot()
	}

	public void clickSubmit() {
		safetyClick(btnSubmit)
		WebUI.takeScreenshot()
	}

	public void verifySubmitSuccess() {
		verifyPopUpSuccess(lblSuccess, "Submit CDE Completion")
	}
}
