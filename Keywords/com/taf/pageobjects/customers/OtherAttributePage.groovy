package com.taf.pageobjects.customers

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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable
import net.sf.jasperreports.components.iconlabel.LabelTextFieldFactory

public class OtherAttributePage extends BaseHelper {

	private TestObject btnSearchDebitorGroup			= createTestObject("btnSearchDebitorGroup", "xpath", "//*[@id='UCDebtGrp_ucBebtGroup_imb']")
	private TestObject drpBussinessScale				= createTestObject("drpBussinessScale", "xpath", "//*[@id='CDebtBizScl_ddlReference']")
	private TestObject btnSearchCounterpartCategory		= createTestObject("btnSearchCounterpartCategory", "xpath", "//*[@id='UCCounterpart_ucCounterpart_imb']")
	private TestObject btnSearchSustainableFinancial	= createTestObject("btnSearchSustainableFinancial", "xpath", "//*[@id='UCSustainableFinancial_ucSustainableFinancial_imb']")

	//overlay debitur
	private TestObject txfOvlyBICode 					= createTestObject("txfOvlyBICode", "xpath", "//*[@id='UCDebtGrp_ucBebtGroup_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
	private TestObject txfOvlyBICodeDesc				= createTestObject("txfOvlyBICodeDesc", "xpath", "//*[@id='UCDebtGrp_ucBebtGroup_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1']")
	private TestObject btnOvlySearchBICode				= createTestObject("btnOvlySearchBICode", "xpath", "//*[@id='UCDebtGrp_ucBebtGroup_umd_ctl00_ucS_lbSearch']")
	private TestObject btnOvlySelectBICode				= createTestObject("btnOvlySelectBICode", "xpath", "//*[@id='UCDebtGrp_ucBebtGroup_umd_ctl00_gvL_hpSelect_0']")

	private TestObject txfOvlyDebitorSLIK				= createTestObject("txfOvlyDebitorSLIK", "xpath", "//*[@id='rptOtherAttribute_UCRefMaster_3_ucLookupRefMaster_3_umd_3_ctl00_3_ucS_3_rptFixedSearch_3_txtSearchValue_0' or @id='rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_umd_7_ctl00_7_ucS_7_rptFixedSearch_7_txtSearchValue_0']")
	private TestObject btnOvlySearchSLIK				= createTestObject("btnOvlySearchSLIK", "xpath", "//*[@id='rptOtherAttribute_UCRefMaster_3_ucLookupRefMaster_3_umd_3_ctl00_3_ucS_3_lbSearch_3' or @id='rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_umd_7_ctl00_7_ucS_7_lbSearch_7']")
	private TestObject btnOvlySelectSLIK				= createTestObject("btnOvlySelectSLIK", "xpath", "//*[@id='rptOtherAttribute_UCRefMaster_3_ucLookupRefMaster_3_umd_3_ctl00_3_gvL_3_hpSelect_0' or @id='rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_umd_7_ctl00_7_gvL_7_hpSelect_0']")

	private TestObject txfEAccountFlag					= createTestObject("txfEAccountFlag", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_0']")
	private TestObject txfEAccountJoinDate				= createTestObject("txfEAccountJoinDate", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_1']")
	private TestObject txfCustRating					= createTestObject("txfCustRating", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_2']")
	private TestObject txfGoodBadStatus					= createTestObject("txfGoodBadStatus", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_3' or @id='rptOtherAttribute_txtAttrContent_0']")
	private TestObject chxGoPublic 						= createTestObject("chxGoPublic", "id", "rptOtherAttribute_cbxAttrValue_1")
	private TestObject txfTerorism						= createTestObject("txfTerorism", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_4']")
	private TestObject txfSimNo							= createTestObject("txfSimNo", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_5']")
	private TestObject chxIsSplitTreasure				= createTestObject("chxIsSplitTreasure", "xpath", "//*[@id='rptOtherAttribute_cbxAttrValue_6']")
	private TestObject btnSearchDebitorGroupSlik		= createTestObject("btnSearchDebitorGroupSlik", "xpath", "//*[@id='rptOtherAttribute_UCRefMaster_3_ucLookupRefMaster_3_imb_3' or @id='rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_imb_7']")
	private TestObject chxViolateBMPK					= createTestObject("chxViolateBMPK", "xpath", "//*[@id='rptOtherAttribute_cbxAttrValue_8' or @id='rptOtherAttribute_cbxAttrValue_4']")
	private TestObject chxExceedBMPK					= createTestObject("chxExceedBMPK", "xpath", "//*[@id='rptOtherAttribute_cbxAttrValue_9' or @id='rptOtherAttribute_cbxAttrValue_5']")
	private TestObject btnSearchAffiliate				= createTestObject("btnSearchAffiliate", "xpath", "//*[@id='rptOtherAttribute_UCRefMaster_9_ucLookupRefMaster_9_imb_9' or @id='rptOtherAttribute_UCRefMaster_10_ucLookupRefMaster_10_imb_10']")
	private TestObject chxIsSameAddress					= createTestObject("chxIsSameAddress", "xpath", "")
	private TestObject chxIsSameJob						= createTestObject("chxIsSameJob", "xpath", "")
	private TestObject chxIsSamePosition				= createTestObject("chxIsSamePosition", "xpath", "")
	private TestObject chxIsDifferentMaritalStatus		= createTestObject("chxIsDifferentMaritalStatus", "xpath", "")
	private TestObject chxHomeOwnerShipDoc				= createTestObject("chxHomeOwnerShipDoc", "xpath", "")
	private TestObject txfNoATM							= createTestObject("txfNoATM", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_16' or @id = 'rptOtherAttribute_txtAttrContent_13']")
	private TestObject chxCustomerDataConsent			= createTestObject("chxCustomerDataConsent", "xpath", "")
	private TestObject txfRatingDebitor					= createTestObject("txfRatingDebitor", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_18' or @id='rptOtherAttribute_txtAttrContent_6']")
	private TestObject txfRatingDate					= createTestObject("txfRatingDate", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_19' or @id='rptOtherAttribute_ucdtAttrContent_8_txtDatePicker_8']")
	private TestObject chxCDENotes						= createTestObject("chxCDENotes", "xpath", "")
	private TestObject btnSave							= createTestObject("btnSave", "xpath", "//*[@id='lb_Form_Save_OtherAttribute']")

	private TestObject txfCustomerCriteria				= createTestObject("txfCustomerCriteria", "id", "rptOtherAttribute_txtAttrContent_2")

	private TestObject iframeMainpage 					= createTestObject("iframeMainpage", "xpath", "//*[@id='mainPage']")
	private TestObject btnSaveData						= createTestObject("btnSaveData", "xpath", "//*[@id='lbl_Toolbar_Save']")
	private TestObject btnSaveAndSubmit					= createTestObject("btnSaveAndSubmit", "id", "lb_Form_SaveSubmit_OtherAttribute")
	
	private TestObject btnSearchRatingInsitute			= createTestObject("btnSearchRatingInsitute", "id", "rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_imb_7")
	private TestObject txfovlyRatingInstitute			= createTestObject("btnOvlySearchRatingInstitute", "id", "rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_umd_7_ctl00_7_ucS_7_rptFixedSearch_7_txtSearchValue_0")
	private TestObject btnOvlySearchRatingInstitute		= createTestObject("btnOvlySearchRatingInstitute", "id", "rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_umd_7_ctl00_7_ucS_7_lbSearch_7")
	private TestObject btnOvlySelectRatingInstitute		= createTestObject("btnOvlySelectRatingInstitute", "id", "rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_umd_7_ctl00_7_gvL_7_hpSelect_0")
	
	private TestObject txfOvlyAffiliate					= createTestObject("txfOvlyAffiliate", "xpath", "//*[@id='rptOtherAttribute_UCRefMaster_9_ucLookupRefMaster_9_umd_9_ctl00_9_ucS_9_rptFixedSearch_9_txtSearchValue_0' or @id='rptOtherAttribute_UCRefMaster_10_ucLookupRefMaster_10_umd_10_ctl00_10_ucS_10_rptFixedSearch_10_txtSearchValue_0']")
	private TestObject btnOvlySearchAffiliate			= createTestObject("btnOvlySearchAffiliate", "xpath", "//*[@id='rptOtherAttribute_UCRefMaster_9_ucLookupRefMaster_9_umd_9_ctl00_9_ucS_9_lbSearch_9' or @id='rptOtherAttribute_UCRefMaster_10_ucLookupRefMaster_10_umd_10_ctl00_10_ucS_10_lbSearch_10']")
	private TestObject btnOvlySelectAffiliate			= createTestObject("btnOvlySelectAffiliate", "xpath", "//*[@id='rptOtherAttribute_UCRefMaster_9_ucLookupRefMaster_9_umd_9_ctl00_9_gvL_9_hpSelect_0' or @id='rptOtherAttribute_UCRefMaster_10_ucLookupRefMaster_10_umd_10_ctl00_10_gvL_10_hpSelect_0']")
	 

	public void switchToIframeMain() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeMainpage, 1)
	}

	private void clickSaveAttributeData() {
		safetyClick(btnSave)
	}

	private void clickSaveData() {
		safetyClick(btnSaveData)
	}

	private void verifyLandingInOtherAttribute() {
		verifyLanding(btnSearchDebitorGroup, "Other Attribute")
	}

	private void selectDebitorGroup(String label) {
		if(label) {
			safetyClick(btnSearchDebitorGroup)

			safetyInput(txfOvlyBICode, '%')
			WebUI.delay(2)
			safetyClick(btnOvlySearchBICode)

			clickSelectByLabel(label)
		}
	}

	private void selectCounterpartCategory(String label) {
		if(label) {
			WebUI.delay(2)
			btnOvlySearchBICode	= createTestObject("btnOvlySearchBICode", "xpath", "//*[@id='UCCounterpart_ucCounterpart_umd_ctl00_ucS_lbSearch']")
			txfOvlyBICode = createTestObject("txfOvlyBICode", "xpath", "//*[@id='UCCounterpart_ucCounterpart_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
			safetyClick(btnSearchCounterpartCategory)
			WebUI.delay(2)

			safetyInput(txfOvlyBICode, '%')
			WebUI.delay(2)
			safetyClick(btnOvlySearchBICode)
			
			clickSelectByLabel(label)
		}
	}

	private void selectSustainableFinancial(String label) {
		if(label) {
			btnOvlySearchBICode	= createTestObject("btnOvlySearchBICode", "xpath", "//*[@id='UCSustainableFinancial_ucSustainableFinancial_umd_ctl00_ucS_lbSearch']")
			txfOvlyBICode 			= createTestObject("txfOvlyBICode", "xpath", "//*[@id='UCSustainableFinancial_ucSustainableFinancial_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
			safetyClick(btnSearchSustainableFinancial)
			safetyInput(txfOvlyBICode, '%')
			WebUI.delay(2)
			safetyClick(btnOvlySearchBICode)
			clickSelectByLabel(label)
		}
	}


	private void clickSelectByLabel(String labelText) {
		TestObject btnSelect = createTestObject("btnSelect", "xpath", "//td[normalize-space(text())='$labelText']/following-sibling::td//a[contains(@id,'hpSelect')]")
		safetyClick(btnSelect)
	}

	private void inputEAccountFlag(String flag) {
		if(flag) {
			safetyInput(txfEAccountFlag, flag)
		}
	}

	private void inputEAccountJoinDate(String date) {
		if(date) {
			safetyInput(txfEAccountJoinDate, date)
		}
	}

	private void inputCustomerRating(String rating) {
		boolean isEnabled = checkElementIsInteractable(txfCustRating)
		if(rating && isEnabled) {
			safetyInput(txfCustRating, rating)
		}
	}
	private void inputGoodBadStatus(String status) {
		boolean isEnabled = checkElementIsInteractable(txfGoodBadStatus)
		if(status && isEnabled) {
			safetyInput(txfGoodBadStatus, status)
		}
	}

	private void inputSuspectTerrorism(String terorism) {
		if(terorism) {
			safetyInput(txfTerorism, terorism)
		}
	}

	private void inputSimNo(String simNo) {
		if(simNo) {
			safetyInput(txfSimNo, simNo)
		}
	}
	private void checkIsSplitTreasure(String isSplit) {
		if(isSplit && isSplit == '1') {
			WebUI.check(chxIsSplitTreasure)
		}
	}

	private void selectDebitorGroupSlik(String group) {
		if(group) {
			safetyClick(btnSearchDebitorGroupSlik)
			safetyInput(txfOvlyDebitorSLIK, "%$group%")
			WebUI.delay(2)
			safetyClick(btnOvlySearchSLIK)
			safetyClick(btnOvlySelectSLIK) //select first of the value contains group
		}
	}

	private void checkViolateBMPK(String bmpk ) {
		if(bmpk && bmpk == "1") {
			WebUI.check(chxViolateBMPK)
		}
	}

	private void checkExceedBMPK(String bmpk) {
		if(bmpk && bmpk == "1") {
			WebUI.check(chxExceedBMPK)
		}
	}

	private void selectAffiliateWithMultifinanceSLIK(String affiliate) {
	}
	private void checkSameAddress(String sameAddress, String index) {
		if (sameAddress) {
			String labelText = sameAddress.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText, index) //11
		}
	}

	private void checkSameJob(String sameJob) {
		if (sameJob) {
			String labelText = sameJob.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText,'12')
		}
	}
	private void checkSamePosition(String samePosition) {
		if (samePosition) {
			String labelText = samePosition.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText, '13')
		}
	}
	private void checkDifferentMaritalStatus(String maritalStatus, String index) {
		KeywordUtil.logInfo(maritalStatus)
		if (maritalStatus) {
			String labelText = maritalStatus.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText, index) 
		}
	}
	private void checkHomeOwnershipDoc(String ownership, String index) {
		if (ownership) {
			String labelText = ownership.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText, index)
		}
	}

	private void checkCustomerDataConsent(String dataConsent, String index) {
		if(dataConsent) {
			String labelText = dataConsent.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText, index)
		}
	}


	private void inputRatingDebitor(String rating) {
		if(rating) {
			safetyInput(txfRatingDebitor, rating)
		}
	}
	
	private void selectRatingInstitute(String ratingInstitute) {
		if(ratingInstitute) {
			safetyClick(btnSearchRatingInsitute)
			safetyInput(txfovlyRatingInstitute, "%$ratingInstitute%")
			safetyClick(btnOvlySearchRatingInstitute)
			safetyClick(btnOvlySelectRatingInstitute) //select first of the value contains ratingInstitute
		}
	}

	private void inputRatingDate(String date) {
		if(date) {
			safetyInput(txfRatingDate, date)
			clickTABKeyboard(txfRatingDate)
		}
		WebUI.takeScreenshot()	
	}
	
	private void selectAffiliate(String affiliate) {
		if(affiliate) {
			safetyClick(btnSearchAffiliate)
			safetyInput(txfOvlyAffiliate, "%$affiliate%")
			WebUI.delay(2)
			safetyClick(btnOvlySearchAffiliate)
			safetyClick(btnOvlySelectAffiliate) //select first of the value contains affiliate
		}
		WebUI.takeScreenshot()
	}

	private void checkCDENotes(String notes, String index) {
		if (notes) {
			String labelText = notes.equalsIgnoreCase("Y") ? "Yes" : "No"
			clickYesNo(labelText, index)
		}
	}
	private void inputATMNo(String atmNo) {
		if(atmNo) {
			safetyInput(txfNoATM, atmNo)
		}
	}

	private void clickYesNo(String labelText, String index) {
		TestObject radYesNo = createTestObject("radYesNo", "xpath", "//label[normalize-space(text())='$labelText']/preceding-sibling::input[@type='radio'and contains(@id, 'rblAttrValue_$index')]")
		safetyClick(radYesNo)
	}

	private void clickSaveAndSubmit() {
		WebUI.takeScreenshot()
		safetyClick(btnSaveAndSubmit)
		WebUI.delay(5)//cek dulu sampe submit
	}
	private void checkIsGoPublic(String isGoPublic) {
		boolean isChecked = WebUI.verifyElementChecked(chxGoPublic, 2, FailureHandling.OPTIONAL)
		if(isGoPublic?.trim().equalsIgnoreCase("Y")) {
			if(!isChecked) {
				safetyClick(chxGoPublic)
			}
		}
	}
	private void inputCustomerCriteria(String criteria) {
		safetyInput(txfCustomerCriteria, criteria)
	}
}
