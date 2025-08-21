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

public class AssetDataPage extends BaseHelper {

	private TestObject btnSaveContinue 		= createTestObject("btnSaveContinue","id","lb_Form_SaveCont")
	private TestObject txtAssetName			= createTestObject("txtAssetName","id","gvAssetList_lblAssetJoin_0")
	private TestObject txtSupplierBranchName= createTestObject("txtSupplierBranchName", "xpath", "//*[@id='gvAssetList']/tbody/tr[2]/td[3]")
	private TestObject txtAssetPrice		= createTestObject("txtAssetPrice","id","gvAssetList_lblAssetPrice_0")
	private TestObject txtDownPayment		= createTestObject("txtDownPayment","id","gvAssetList_lblDownPayment_0")
	private TestObject txtNoMesin			= createTestObject("txtNoMesin","xpath","//*[@id='gvAssetList']/tbody/tr[2]/td[6]")
	private TestObject txtNoRangka			= createTestObject("txtNoRangka","xpath","//*[@id='gvAssetList']/tbody/tr[2]/td[7]")
	private TestObject txtOwnerName			= createTestObject("txtOwnerName","xpath","//*[@id='gvAssetList']/tbody/tr[2]/td[8]")
	private TestObject btnEditAssetRegist	= createTestObject("btnEditAssetRegist","id","gvAssetList_imbEdit_0")
	private TestObject btnEdit				= createTestObject("btnEdit","id","gvAssetList_imbEdit2_0")

	private TestObject btnSave				= createTestObject("btnSave", "id", "lb_Form_Save_Reg")
	private TestObject btnCancel			= createTestObject("btnCancel", "id", "lb_Form_Cancel_Reg")

	private TestObject txfUserName			= createTestObject("txfUserName", "id", "txtUserName")
	private TestObject drpUserRelationship	= createTestObject("drpUserRelationship", "id", "ucUserRelation_ddlReference")
	private TestObject txfOwnerName			= createTestObject("txfOwnerName", "id", "txtOwnerName")
	private TestObject drpIdType			= createTestObject("drpIdType", "id", "ucMrIdType_ddlReference")
	private TestObject txfOwnerIdNo			= createTestObject("txfOwnerIdNo", "id", "txtIdNo")
	private TestObject drpOwnerRelationship	= createTestObject("drpOwnerRelationship", "id", "ucOwnerRelation_ddlReference")
	private TestObject drpCopyAddressFrom	= createTestObject("drpCopyAddressFrom", "id", "ucCopyAddrOwner_ddlReference")
	private TestObject btnCopyAddressOwner	= createTestObject("btnCopyAddressOwner", "id", "lb_Form_Copy_OwnerAddr")
	private TestObject txfTaxDate			= createTestObject("txfTaxDate", "id", "ucTaxDate_txtDatePicker")
	private TestObject txfNotes				= createTestObject("txfNotes", "id", "txtNotes")
	private TestObject drpCopyAddressLoc	= createTestObject("drpCopyAddressLoc", "id", "ucCopyAddrAssLoc_ddlReference")
	private TestObject btnCopyAddressLoc	= createTestObject("btnCopyAddressLoc", "id", "lb_Form_Copy_Assloc")

	private TestObject btnSearchSupplierBranchName	= createTestObject("btnSearchSupplierBranchName","xpath","[contains(@id, 'uclSupplBranchSchm_imb')]")//*[@id="ucLookupSupplBranchSchm_uclSupplBranchSchm_imb"]
	private TestObject drpSalesPersonName			= createTestObject("drpSalesPersonName","id","ucSalesPerson_ddlReference")
	private TestObject txtAdminHead					= createTestObject("txtAdminHead","xpath","//*[@id='dMainSuppl']/table[2]/tbody/tr/td[2]")
	private TestObject btnSearchAssetName			= createTestObject("btnSearchAssetName","id","ucLookupAssetMaster_uclMaster_imb")
	private TestObject txfAssetPrice				= createTestObject("txfAssetPrice","id","ucAssetPrice_txtInput")
	private TestObject txfDownPayment				= createTestObject("btnDownPayment", "id", "ucDownPayment_txtInput")
	private TestObject drpAssetUsage				= createTestObject("drpAssetUsage","id","ucAssetUsage_ddlReference")
	private TestObject txfManufacturingYear			= createTestObject("txfManufacturingYear","id","txtManufacturingYear")

	private TestObject txfOvlySearchName			= createTestObject("txfOvlySearchName", "xpath", "[contains(@id, 'txtSearchValue_0')]")
	private TestObject txfOvlySearchAccName			= createTestObject("txfOvlySearchAccName", "xpath", "[contains(@id, 'txtSearchValue_1')]")
	private TestObject btnOvlySearch				= createTestObject("btnOvlySearch", "xpath", "[contains(@id, 'ucS_lbSearch')]")
	private TestObject btnOvlySelect				= createTestObject("btnOvlySelect", "xpath", "[contains(@id, 'hpSelect')]")
	
	private TestObject btnAddAdditionalBranch		= createTestObject("btnAddAdditionalBranch", "id", "lb_Form_Add_Acc")
	private TestObject btnSearchAdditionBranch		= createTestObject("btnSearchAdditionBranch", "xpath", "[contains(@id, 'uclSupplBranchSchm_0_imb_0')]")
	private TestObject btnSearchAssetAccessoryName	= createTestObject("btnSearchAssetAccessoryName", "xpath", "uclLookupAccessories_0_imb_0") 



	private void verifyLandinginAssetDataPage() {
		verifyLanding(txtAssetName, "Asset Data")
		WebUI.takeScreenshot()
	}

	private void clickSaveContinue() {
		safetyClick(btnSaveContinue)
		WebUI.takeScreenshot()
	}
	private void clickSave() {
		safetyClick(btnSave)
	}
	private void clickEditAssetRegistration() {
		safetyClick(btnEditAssetRegist)
		WebUI.takeScreenshot()
	}
	private void selectSelfUsage(String selfUsage) {
		if(selfUsage?.trim()) {
			TestObject radSelfUsage = createTestObject("radSelfUsage","xpath",	"//label[normalize-space(text())='${selfUsage}']/preceding-sibling::input[@type='radio']")
			if (!WebUI.verifyElementChecked(radSelfUsage, 2, FailureHandling.OPTIONAL)) {
				safetyClick(radSelfUsage)
			}
		}
	}

	private void inputUserName(String name) {
		safetyInput(txfUserName, name)
	}
	private void selectUserRelationship(String relationship) {
		safetySelect(drpUserRelationship, relationship)
	}
	private void inputOwnerName(String ownerName) {
		safetyInput(txfOwnerName, ownerName)
	}
	private void selectIdType(String idType) {
		safetySelect(drpIdType, idType)
	}

	private void inputOwnerIdNo(String idNo) {
		safetyInput(txfOwnerIdNo, idNo)
	}
	private void selectOwnerRelationship(String relationship ) {
		safetySelect(drpOwnerRelationship, relationship)
		WebUI.takeScreenshot()
	}

	private void selectAndCopyAddressOwner(String copyAddressFrom) {
		safetySelect(drpCopyAddressFrom, copyAddressFrom)
		safetyClick(btnCopyAddressOwner)
		WebUI.takeScreenshot()
	}

	private void inputTaxDate(String date) {
		if(date) {
			safetyInput(txfTaxDate, date)
		}
	}
	private void inputNotes(String notes) {
		if(notes) {
			safetyInput(txfNotes, notes)
		}
		WebUI.takeScreenshot()
	}

	private void selectAndCopyAddressLocation(String copyAddressFrom) {
		safetySelect(drpCopyAddressLoc, copyAddressFrom)
		safetyClick(btnCopyAddressLoc)
		WebUI.takeScreenshot()
	}
	private void searchSupplierBranchName(String supplierBranchName) {
		safetyClick(btnSearchSupplierBranchName)
		safetyInput(txfOvlySearchName, supplierBranchName)
		safetyClick(btnOvlySearch)
		safetyClick(btnOvlySelect)
	}
	private void selectSalesPersonName(String name) {
		safetySelect(drpSalesPersonName, name)
	}

	private void searchAssetName(String assetName) {
		safetyClick(btnSearchAssetName)
		safetyInput(txfOvlySearchName, assetName)
		safetyClick(btnOvlySearch)
		safetyClick(btnOvlySelect)
	}

	private void inputAssetPrice(String price) {
		safetyInput(txfAssetPrice, price)
	}

	private void inputDownPayment(String downPayment) {
		safetyInput(txfDownPayment, downPayment)
	}
	
	private void selectAssetUsage(String assetUsage) {
		safetySelect(drpAssetUsage, assetUsage)
	}
	private void inputManufacturingYear(String year) {
		safetyInput(txfManufacturingYear, year)
	}
	private void clickEditAssetData() {
		safetyClick(btnEdit)
	}
	private void searchAdditionalBranchName(String additionalBranchName) {
		safetyClick(btnSearchAdditionBranch)
		safetyInput(txfOvlySearchName, additionalBranchName)
		safetyClick(btnOvlySearch)
		safetyClick(btnOvlySelect)
	}
	
	private void searcAccName(String accName) {
		safetyClick(btnSearchAssetAccessoryName)
		safetyInput(txfOvlySearchAccName, accName)
		safetyClick(btnOvlySearch)
		safetyClick(btnOvlySelect)
	}
	private void clickAdd() {
		safetyClick(btnAddAdditionalBranch)
	}
}
