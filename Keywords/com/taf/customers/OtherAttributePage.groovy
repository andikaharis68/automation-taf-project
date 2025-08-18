package com.taf.customers

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
	
	private TestObject txfOvlyDebitorSLIK				= createTestObject("txfOvlyDebitorSLIK", "xpath", "//*[@id='rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_umd_7_ctl00_7_ucS_7_rptFixedSearch_7_txtSearchValue_0']")
	private TestObject btnOvlySelectSLIK				= createTestObject("btnOvlySelectSLIK", "xpath", "//*[@id='rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_umd_7_ctl00_7_gvL_7_hpSelect_0']")
	private TestObject txfOvlyAffiliate					= createTestObject("txfOvlyAffiliate", "xpath", "//*[@id='rptOtherAttribute_UCRefMaster_10_ucLookupRefMaster_10_umd_10_ctl00_10_ucS_10_rptFixedSearch_10_txtSearchValue_0']")
	

	private TestObject txfEAccountFlag					= createTestObject("txfEAccountFlag", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_0']")
	private TestObject txfEAccountJoinDate				= createTestObject("txfEAccountJoinDate", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_1']")
	private TestObject txfCustRating					= createTestObject("txfCustRating", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_2']")
	private TestObject txfGoodBadStatus					= createTestObject("txfGoodBadStatus", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_3']")
	private TestObject txfTerorism						= createTestObject("txfTerorism", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_4']")
	private TestObject txfSimNo							= createTestObject("txfSimNo", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_5']")
	private TestObject chxIsSplitTreasure				= createTestObject("chxIsSplitTreasure", "xpath", "//*[@id='rptOtherAttribute_cbxAttrValue_6']")
	private TestObject btnSearchDebitorGroupSlik		= createTestObject("btnSearchDebitorGroupSlik", "xpath", "//*[@id='rptOtherAttribute_UCRefMaster_7_ucLookupRefMaster_7_imb_7']")
	private TestObject chxViolateBMPK					= createTestObject("chxViolateBMPK", "xpath", "//*[@id='rptOtherAttribute_cbxAttrValue_8']")
	private TestObject chxExceedBMPK					= createTestObject("chxExceedBMPK", "xpath", "//*[@id='rptOtherAttribute_cbxAttrValue_9']")
	private TestObject btnSearchAffiliate				= createTestObject("btnSearchAffiliate", "xpath", "//*[@id='rptOtherAttribute_UCRefMaster_10_ucLookupRefMaster_10_imb_10']")
	private TestObject chxIsSameAddress					= createTestObject("chxIsSameAddress", "xpath", "")
	private TestObject chxIsSameJob						= createTestObject("chxIsSameJob", "xpath", "")
	private TestObject chxIsSamePosition				= createTestObject("chxIsSamePosition", "xpath", "")
	private TestObject chxIsDifferentMaritalStatus		= createTestObject("chxIsDifferentMaritalStatus", "xpath", "")
	private TestObject chxHomeOwnerShipDoc				= createTestObject("chxHomeOwnerShipDoc", "xpath", "")
	private TestObject txfNoATM							= createTestObject("txfNoATM", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_16']")
	private TestObject chxCustomerDataConsent			= createTestObject("chxCustomerDataConsent", "xpath", "")
	private TestObject txfRatingDebitor					= createTestObject("txfRatingDebitor", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_18']")
	private TestObject txfRatingDate					= createTestObject("txfRatingDate", "xpath", "//*[@id='rptOtherAttribute_txtAttrContent_19']")
	private TestObject chxCDENotes						= createTestObject("chxCDENotes", "xpath", "")
	private TestObject btnSave							= createTestObject("btnSave", "xpath", "//*[@id='lb_Form_Save_OtherAttribute']")
	
	private void clickSave() {
		WebUI.click(btnSave)
	}
	
	private void verifyLandingInOtherAttribute() {
		verifyLanding(btnSearchDebitorGroup, "Other Attribute")
	}
	
	private void selectDebitorGroup(String label) {
		WebUI.click(btnSearchDebitorGroup)
		WebUI.setText(txfOvlyBICode, '%')
		WebUI.click(btnOvlySearchBICode)
		clickSelectByLabel(label)
	}
	
	private void selectCounterpartCategory(String label) {
		btnOvlySearchBICode	= createTestObject("btnOvlySearchBICode", "xpath", "//*[@id='UCCounterpart_ucCounterpart_umd_ctl00_ucS_lbSearch']") 
		txfOvlyBICode = createTestObject("txfOvlyBICode", "xpath", "//*[@id='UCCounterpart_ucCounterpart_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
		WebUI.click(btnSearchCounterpartCategory)
		WebUI.setText(txfOvlyBICode, '%')
		WebUI.click(btnOvlySearchBICode)
		clickSelectByLabel(label)
	}
	
	private void selectSustainableFinancial(String label) {
		 btnOvlySearchBICode	= createTestObject("btnOvlySearchBICode", "xpath", "//*[@id='UCSustainableFinancial_ucSustainableFinancial_umd_ctl00_ucS_lbSearch']")
		 txfOvlyBICode 			= createTestObject("txfOvlyBICode", "xpath", "//*[@id='UCSustainableFinancial_ucSustainableFinancial_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
		WebUI.click(btnSearchSustainableFinancial)
		WebUI.setText(txfOvlyBICode, '%')
		WebUI.click(btnOvlySearchBICode)
		clickSelectByLabel(label)
	}
	
	
	private void clickSelectByLabel(String labelText) {
		TestObject btnSelect = createTestObject("btnSelect", "xpath", "//td[normalize-space(text())='$labelText']/following-sibling::td//a[contains(@id,'hpSelect')]")
		WebUI.click(btnSelect)
	}
	
	private void inputEAccountFlag(String flag) {
		if(flag) {
			WebUI.setText(txfEAccountFlag, flag)
		}
	}
	
	private void inputEAccountJoinDate(String date) {
		if(date) {
			WebUI.setText(txfEAccountJoinDate, date)
		}
	}
	
	private void inputCustomerRating(String rating) {
		if(rating) {
			WebUI.setText(txfCustRating, rating)
		}
	}
	private void inputGoodBadStatus(String status) {
		if(status) {
			WebUI.setText(txfGoodBadStatus, status)
		}
	}
	
	private void inputSuspectTerrorism(String terorism) {
		if(terorism) {
			WebUI.setText(txfTerorism, terorism)
		}
	}
	
	private void inputSimNo(String simNo) {
		if(simNo) {
			WebUI.setText(txfSimNo, simNo)
		}
	}
	private void checkIsSplitTreasure(String isSplit) {
		if(isSplit && isSplit == '1') {
			WebUI.check(chxIsSplitTreasure)
		}
	}
	
	private void selectDebitorGroupSlik(String group) {
		if(group) {
			WebUI.click(btnSearchDebitorGroupSlik)
			WebUI.setText(txfOvlyDebitorSLIK, "%")
			WebUI.click(btnOvlySelectSLIK) //select first 
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
	private void checkSameAddress(String sameAddress) {
		if (sameAddress) {
			String labelText = sameAddress == "Y" ? "Yes" : "No"
			clickYesNo(labelText)
		}
	}
	
	private void checkSameJob(String sameJob) {
		if (sameJob) {
			String labelText = sameJob == "Y" ? "Yes" : "No"
			clickYesNo(labelText)
		}
	}
	private void checkSamePosition(String samePosition) {
		if (samePosition) {
			String labelText = samePosition == "Y" ? "Yes" : "No"
			clickYesNo(labelText)
		}
	}
	private void checkDifferentMaritalStatus(String maritalStatus) {
		if (maritalStatus) {
			String labelText = maritalStatus == "Y" ? "Yes" : "No"
			clickYesNo(labelText)
		}
	}
	private void checkHomeOwnershipDoc(String ownership) {
		if (ownership) {
			String labelText = ownership == "Y" ? "Yes" : "No"
			clickYesNo(labelText)
		}
	}
	
	private void checkCustomerDataConsent(String dataConsent) {
		if(dataConsent) {
			String labelText = dataConsent == "Y" ? "Yes" : "No"
			clickYesNo(labelText)
		}
	}
	
	
	private void inputRatingDebitor(String rating) {
		if(rating) {
			WebUI.setText(txfRatingDebitor, rating)
		}
	}
	
	private void inputRatingDate(String date) {
		if(date) {
			WebUI.setText(txfRatingDate, date)
		}
	}
	
	private void checkCDENotes(String notes) {
		if (notes) {
			String labelText = notes == "Y" ? "Yes" : "No"
			clickYesNo(labelText)
		}
	}
	private void inputATMNo(String atmNo) {
		if(atmNo) {
			WebUI.setText(txfNoATM, atmNo)
		}
	}	
	
	private void clickYesNo(String labelText) {
		TestObject radYesNo = createTestObject("radYesNo", "xpath", "//label[normalize-space(text())='" + labelText + "']/preceding-sibling::input[@type='radio']")
		WebUI.click(radYesNo)
	}
}
