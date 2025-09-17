package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.OPTIONAL
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By
import org.openqa.selenium.By.ByTagName
import org.openqa.selenium.Keys
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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class AssetDataPage extends BaseHelper {

	private TestObject btnSaveContinue 		= createTestObject("btnSaveContinue","id","lb_Form_SaveCont")
	private TestObject txtAssetName			= createTestObject("txtAssetName","xpath","//*[@id='gvAssetList_lblAssetJoin_0']")
	private TestObject txtSupplierBranchName= createTestObject("txtSupplierBranchName", "xpath", "//*[@id='gvAssetList']/tbody/tr[2]/td[3]")
	private TestObject txtAssetPrice		= createTestObject("txtAssetPrice","id","gvAssetList_lblAssetPrice_0")
	private TestObject txtDownPayment		= createTestObject("txtDownPayment","id","gvAssetList_lblDownPayment_0")
	private TestObject txtNoMesin			= createTestObject("txtNoMesin","xpath","//*[@id='gvAssetList']/tbody/tr[2]/td[6]")
	private TestObject txtNoRangka			= createTestObject("txtNoRangka","xpath","//*[@id='gvAssetList']/tbody/tr[2]/td[7]")
	private TestObject txtOwnerName			= createTestObject("txtOwnerName","xpath","//*[@id='gvAssetList']/tbody/tr[2]/td[8]")
	private TestObject btnEditAssetRegist	= createTestObject("btnEditAssetRegist","id","gvAssetList_imbEdit_0")
	private TestObject btnEdit				= createTestObject("btnEdit","id","gvAssetList_imbEdit2_0")

	private TestObject btnSave				= createTestObject("btnSave", "id", "lb_Form_Save_Reg")
	private TestObject btnSaveEdit			= createTestObject("btnSaveEdit", "id", "lb_Form_Save_Edit")
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

	private TestObject btnSearchSupplierBranchName	= createTestObject("btnSearchSupplierBranchName","xpath","//*[contains(@id, 'uclSupplBranchSchm_imb')]")
	private TestObject drpSalesPersonName			= createTestObject("drpSalesPersonName","id","ucSalesPerson_ddlReference")
	private TestObject txtAdminHead					= createTestObject("txtAdminHead","xpath","//*[@id='dMainSuppl']/table[2]/tbody/tr/td[2]")
	private TestObject btnSearchAssetName			= createTestObject("btnSearchAssetName","xpath"," //*[@id='ucLookupAssetMaster_uclMaster_imb' or @id='ucLookupAssetSchm_uclAssetSchm_imb']")
	private TestObject txfAssetName 				= createTestObject("txfAssetName", "xpath", "//*[@id='ucLookupAssetMaster_uclMaster_txt' or @id='ucLookupAssetSchm_uclAssetSchm_txt']")

	private TestObject txfAssetPrice				= createTestObject("txfAssetPrice","id","ucAssetPrice_txtInput")
	private TestObject txfDownPayment				= createTestObject("txfDownPayment", "xpath", "//input[@id='ucDownPayment_txtInput' or @id='ucDownPaymentPrcnt_txtInput']")
	private TestObject drpAssetUsage				= createTestObject("drpAssetUsage","id","ucAssetUsage_ddlReference")
	private TestObject txfManufacturingYear			= createTestObject("txfManufacturingYear","id","txtManufacturingYear")

	private TestObject txfOvlySearchName			= createTestObject("txfOvlySearchName", "xpath", "//*[@id='ucLookupAssetMaster_uclMaster_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0' or @id='ucLookupAssetSchm_uclAssetSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
	private TestObject txfOvlySearchAccName			= createTestObject("txfOvlySearchAccName", "id", "gvAccessories_ucLookupAccessories_0_uclLookupAccessories_0_umd_0_ctl00_0_ucS_0_rptFixedSearch_0_txtSearchValue_1")
	private TestObject btnOvlySearch				= createTestObject("btnOvlySearch", "xpath", "//*[@id='ucLookupAssetMaster_uclMaster_umd_ctl00_ucS_lbSearch' or @id='ucLookupAssetSchm_uclAssetSchm_umd_ctl00_ucS_lbSearch']")
	private TestObject btnOvlySelect				= createTestObject("btnOvlySelect", "xpath", "//*[@id='ucLookupAssetMaster_uclMaster_umd_ctl00_gvL_hpSelect_0' or @id='ucLookupAssetSchm_uclAssetSchm_umd_ctl00_gvL_hpSelect_0']")
	private TestObject btnCloseOverlay				= createTestObject("btnCloseOverlay", "xpath", "//*[@id='ucLookupAssetSchm_uclAssetSchm_umd_dv']/a")

	private TestObject btnAddAdditionalBranch		= createTestObject("btnAddAdditionalBranch", "id", "lb_Form_Add_Acc")
	private TestObject btnSearchAdditionBranch		= createTestObject("btnSearchAdditionBranch", "id", "gvAccessories_ucLookupSupplBranchSchm2_0_uclSupplBranchSchm_0_imb_0")
	private TestObject btnSearchAssetAccessoryName	= createTestObject("btnSearchAssetAccessoryName", "id", "uclLookupAccessories_0_imb_0")

	private TestObject txfCity						= createTestObject("txfCity", "id", "ucAssLocAddr_txtCity")
	private TestObject txfNoMesin					= createTestObject("txfNoMesin", "id", "txtSerialNo1")
	private TestObject txfNoRangka					= createTestObject("txfNoRangka", "id", "txtSerialNo2")
	private TestObject txfLicensePlatNo				= createTestObject("txfLicensePlatNo", "id", "txtLicensePlateNo")
	private TestObject txfMadeIn					= createTestObject("txfMadeIn", "id", "rptAttribute_txtAttrContent_0")
	private TestObject txfCylinder					= createTestObject("txfCylinder", "id", "rptAttribute_txtAttrContent_1")
	private TestObject txfTransmition				= createTestObject("txfTransmition", "id", "rptAttribute_txtAttrContent_2")
	private TestObject txfColor						= createTestObject("txfColor", "id", "rptAttribute_txtAttrContent_3")
	private TestObject drpRegion					= createTestObject("drpRegion", "id", "rptAttribute_ucrefInputAttr_4_ddlReference_4")

	private TestObject txfAdditionalAssetPrice		= createTestObject("txfAdditionalAssetPrice", "id", "gvAccessories_ucInputNumber_0_txtInput_0")
	private TestObject txfAdditionalDpAmount		= createTestObject("txfAdditionalDpAmount", "id", "gvAccessories_ucInputNumber2_0_txtInput_0")
	private TestObject txfAdditionalNotes			= createTestObject("txfAdditionalNotes", "id", "gvAccessories_txtNotes_0")
	private TestObject txfOwnerNotes				= createTestObject("txfOwnerNotes", "id", "txtNotes")
	private TestObject txfMainAssetNotes			= createTestObject("txfMainAssetNotes", "id", "txtNotesMainAss")
	private TestObject lblSubSection				= createTestObject("lblSubSection", "id", "ucToggleAssetDoc_subSectionID")
	private TestObject btnTrash 					= createTestObject("btnTrash", "id", "gvAccessories_imbDelete_0")



	private void verifyLandinginAssetDataPage() {
		WebUI.delay(2)
		verifyLanding(txtAssetName, "Asset Data")
		WebUI.takeScreenshot()
	}

	private void clickSaveContinue() {
		safetyClick(btnSaveContinue)
		WebUI.delay(5)
	}
	private void clickSave() {
		WebUI.delay(2)
		safetyClick(btnSave)
		WebUI.takeScreenshot()
		WebUI.delay(3)
	}
	private void clickEditAssetRegistration() {
		WebUI.click(btnEditAssetRegist)
		WebUI.delay(1)
		WebUI.takeScreenshot()
	}
	private void selectSelfUsage(String selfUsage) {
		if(selfUsage?.trim()) {
			TestObject radSelfUsage = createTestObject("radSelfUsage","xpath",	"//label[normalize-space(text())='$selfUsage']/preceding-sibling::input[@type='radio']")
			safetyClick(radSelfUsage)
		}
	}

	private void inputUserName(String name) {
		boolean isOptionDisabled = checkOptionDisabled(txfUserName)
		if( !isOptionDisabled && !name.equalsIgnoreCase(WebUI.getText(txfUserName))) {
			clearAndSetText(txfUserName, name)
		}
	}
	private void selectUserRelationship(String relationship) {
		if(!relationship?.trim().equalsIgnoreCase(relationship)) {
			safetySelect(drpUserRelationship, relationship)
		}
	}
	private void inputOwnerName(String ownerName) {
		String strElement = WebUI.getText(txfOwnerName)
		if(!ownerName.equalsIgnoreCase(strElement)) {
			safetyInput(txfOwnerName, ownerName)
		}
	}
	private void selectIdType(String idType) {
		boolean isOptionDisabled = checkOptionDisabled(drpIdType)
		if(!isOptionDisabled) {
			safetySelect(drpIdType, idType)
		} else {
			KeywordUtil.logInfo("Option ID type disable")
		}
	}

	private void inputOwnerIdNo(String idNo) {
		String elementText = WebUI.getText(txfOwnerIdNo)
		if(!idNo.equalsIgnoreCase(elementText)) {
			safetyInput(txfOwnerIdNo, idNo)
		}
	}
	private void selectOwnerRelationship(String relationship ) {
		safetySelect(drpOwnerRelationship, relationship)
	}

	private void selectAndCopyAddressOwner(String copyAddressFrom) {
		boolean isElementEnabled = WebUI.verifyElementPresent(drpCopyAddressFrom, 2, OPTIONAL)
		if(isElementEnabled) {
			//kalo gak nemu option yg dipilih maka pilih option yang pertama
			WebElement element = WebUI.findWebElement(drpCopyAddressFrom)
			List<WebElement> options = element.findElements(By.tagName("option"))
			boolean isFound = false
			for (WebElement opt : options) {
				if (opt.getText().trim().equalsIgnoreCase(copyAddressFrom)) {
					safetySelect(drpCopyAddressFrom, copyAddressFrom)
					isFound = true
					WebUI.click(btnCopyAddressOwner)
					WebUI.delay(1)
					break
				}
			}
			if (!isFound) {
				selectFirstOption(drpCopyAddressFrom, copyAddressFrom)
			}
		} else {
			//kalo gak nemu optionnya langsung klik copy
			safetyClick(btnCopyAddressOwner)
			KeywordUtil.markWarning("Option not clickable or disabled")
		}
		WebUI.takeScreenshot()
	}

	private void inputTaxDate(String date) {
		if(date) {
			WebUI.click(txfTaxDate)
			safetyInput(txfTaxDate, date)
			clickTABKeyboard(txfTaxDate)
		}
	}
	private void inputNotes(String notes) {
		if(notes) {
			safetyInput(txfNotes, notes)
		}
	}

	private void selectAndCopyAddressLocation(String copyAddressFrom) {
		boolean isElementEnabled = WebUI.verifyElementPresent(drpCopyAddressLoc, 2, OPTIONAL)
		if(isElementEnabled) {
			WebElement element = WebUI.findWebElement(drpCopyAddressLoc)
			List<WebElement> options = element.findElements(By.tagName("option"))
			boolean isFound = false
			for (WebElement opt : options) {
				if (opt.getText().trim().equalsIgnoreCase(copyAddressFrom)) {
					safetySelect(drpCopyAddressLoc, copyAddressFrom)
					isFound = true
					WebUI.click(btnCopyAddressLoc)
					WebUI.delay(1)
					break
				}
			}
			if (!isFound) {
				selectFirstOption(drpCopyAddressLoc, copyAddressFrom)
			}
		} else {
			safetyClick(btnCopyAddressLoc)
			KeywordUtil.markWarning("Option not clickable or disabled")
		}
		WebUI.scrollToElement(txfCity, 2)
		WebUI.takeScreenshot()
	}
	private void searchSupplierBranchName(String supplierBranchName) {
		TestObject txfOvlyBranchName = createTestObject("txfOvlyBranchName", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0")
		TestObject btnOvlySearch	 = createTestObject("btnOvlySearch", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_ucS_lbSearch")
		TestObject btnSelect		 = createTestObject("btnSelect", "id", "ucLookupSupplBranchSchm_uclSupplBranchSchm_umd_ctl00_gvL_hpSelect_0")
		boolean isDisabled = checkOptionDisabled(btnSearchSupplierBranchName)
		if(!isDisabled) {
			safetyClick(btnSearchSupplierBranchName)
			safetyInput(txfOvlyBranchName, supplierBranchName)
			safetyClick(btnOvlySearch)
			WebUI.takeScreenshot()
			safetyClick(btnSelect)
		}
		WebUI.delay(2)
	}
	private void selectSalesPersonName(String name) {
		boolean isDisabled = checkOptionDisabled(drpSalesPersonName)
		if (!isDisabled) {
			WebElement element = WebUI.findWebElement(drpSalesPersonName)
			List<WebElement> options = element.findElements(By.tagName("option"))
			boolean isFound = false
			for (WebElement opt : options) {
				if (opt.getText().trim().equalsIgnoreCase(name)) {
					safetySelect(drpSalesPersonName, name)
					isFound = true
					break
				}
			}
			if (!isFound) {
				selectFirstOption(drpSalesPersonName, name)
			}
		} else {
			KeywordUtil.markWarning("Option not clickable or disabled")
		}
	}
	private void searchAssetName(String assetName) {
		boolean isDisabled = checkOptionDisabled(btnSearchAssetName)
		String elementText = WebUI.getText(txfAssetName)
		if(!assetName.equalsIgnoreCase(elementText) && !isDisabled) {
			safetyClick(btnSearchAssetName)
			safetyInput(txfOvlySearchName, assetName)
			safetyClick(btnOvlySearch)
			WebUI.takeScreenshot()
			if(WebUI.verifyElementPresent(btnOvlySelect, 2, OPTIONAL)) {
				safetyClick(btnOvlySelect)
			} else {
				safetyClick(btnCloseOverlay)
				KeywordUtil.markWarning("Asset name $assetName not found")
			}
		}
	}

	private void inputAssetPrice(String price) {
		String elementText = WebUI.getText(txfAssetPrice)
		if(!price.equalsIgnoreCase(elementText)) {
			clearAndSetText(txfAssetPrice, price)
			WebUI.delay(1)
		}
	}

	private void inputDownPayment(String downPayment) {
		boolean isDisableElement = checkOptionDisabled(txfDownPayment)
		String elementText = WebUI.getText(txfDownPayment)
		if(!isDisableElement && !downPayment.equalsIgnoreCase(elementText)) {
			manualClearText(txfDownPayment)
			safetyInput(txfDownPayment, downPayment)
			clickTABKeyboard(txfDownPayment)
		}
	}

	private void selectAssetUsage(String assetUsage) {
		safetySelect(drpAssetUsage, assetUsage)
		WebUI.delay(1)
	}
	private void inputManufacturingYear(String year) {
		WebUI.delay(1)
		inputIfDifferent(txfManufacturingYear, year)
		WebUI.takeScreenshot()
	}
	private void clickEditAssetData() {
		safetyClick(btnEdit)
		WebUI.takeScreenshot()
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
	private void clickAddAdditionalBranch() {
		safetyClick(btnAddAdditionalBranch)
		WebUI.delay(3)
	}

	private void clickSaveEdit() {
		WebUI.click(btnSaveEdit)
		handleAlertIfPresent()
		if(WebUI.verifyElementPresent(btnSaveEdit, 3, FailureHandling.OPTIONAL)) {
			safetyClick(btnSaveEdit)
		}
		WebUI.takeScreenshot()
	}
	private void checkErrorAfterClickSave() {
		List<String> errors = getAllErrorFields()

		if (errors.isEmpty()) {
			KeywordUtil.logInfo("No required field errors.")
		} else {
			KeywordUtil.markError("❗Required fields missing: " + errors.join(', '))
		}
	}

	private void selectDPType(String dpType) {
		if(dpType) {
			TestObject radDpType = createTestObject("radDpType","xpath","//label[normalize-space(text())='${dpType}']/preceding-sibling::input[@type='radio']")
			safetyClick(radDpType)
			handleAlertIfPresent()
			WebUI.delay(3)
		}
	}
	private void inputNoMesin(String noMesin) {
		String randomStr = generateRandom5DigitString()
		if(noMesin) {
			noMesin = noMesin.equalsIgnoreCase("AUTO") ? randomStr : noMesin
			inputIfDifferent(txfNoMesin, noMesin)
		}
	}

	private String generateRandom5DigitString() {
		Random rnd = new Random()
		int number = (int) (Math.random() * 90000) + 10000
		return String.valueOf(number)
	}

	private void inputNoRangka(String noRangka) {
		if(noRangka) {
			String randomStr = generateRandom5DigitString()
			noRangka = noRangka.equalsIgnoreCase("AUTO") ? randomStr : noRangka
			inputIfDifferent(txfNoRangka, noRangka)
		}
	}

	private void inputLicensePlatNo(String platNo) {
		if(platNo) {
			String randomStr = generateRandom5DigitString()
			platNo = platNo.equalsIgnoreCase("AUTO") ? randomStr : platNo
			inputIfDifferent(txfLicensePlatNo, platNo)
		}
	}

	private void selectAssetCondition(String condition) {
		if(condition) {
			TestObject radCondition = createTestObject("radCondition","xpath","//label[normalize-space(text())='${condition}']/preceding-sibling::input[@type='radio']")
			safetyClick(radCondition)
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



	private void inputAssetUserSection(String selfUsage,String userName, String userRelationship) {
		selectSelfUsage(selfUsage)
		inputUserName(userName)
		selectUserRelationship(userRelationship)
		WebUI.takeScreenshot()
	}

	private void inputAssetOwnerNotes(String notes) {
		if(notes) {
			safetyInput(txfOwnerNotes, notes)
		}
	}
	private void inputAssetOwnerSection(String name, String idType, String idNo, String ownerRelationship, String copyAddressFrom, String taxDate, String notes) {
		boolean isDisable = checkOptionDisabled(txfOwnerName)
		if(!isDisable) {
			inputOwnerName(name)
			selectIdType(idType)
			inputOwnerIdNo(idNo)
			selectOwnerRelationship(ownerRelationship)
			selectAndCopyAddressOwner(copyAddressFrom)
		}

		inputTaxDate(taxDate)
		inputAssetOwnerNotes(notes)
	}

	private void inputSupplierInfoSection(String name, String salesPersonName) {
		WebUI.delay(2)
		searchSupplierBranchName(name)
		selectSalesPersonName(salesPersonName)
		WebUI.delay(3)
	}
	private void inputMainAssetNotes(String notes) {
		String elementText = WebUI.getText(txfMainAssetNotes)
		if(!notes?.equalsIgnoreCase(elementText)) {
			safetyInput(txfMainAssetNotes, notes)
		}
	}
	private void inputMainAssetSection(String assetName, String assetPrice, String dpType, String downPayment, String notes) {
		WebUI.delay(3)
		searchAssetName(assetName)
		inputAssetPrice(assetPrice)
		selectDPType(dpType)
		inputDownPayment(downPayment)
		inputMainAssetNotes(notes)
	}
	private void inputAssetDataSection(String noMesin, String noRangka, String platNo, String condition, String assetUsage, String year) {
		inputNoMesin(noMesin)
		inputNoRangka(noRangka)
		inputLicensePlatNo(platNo)
		selectAssetCondition(condition)
		selectAssetUsage(assetUsage)
		inputManufacturingYear(year)
	}
	private void inputAssetAttributeSection(String madeIn, String cylinder, String transmition, String color, String region) {
		inputMadeIn(madeIn)
		inputCylinder(cylinder)
		inputTransmition(transmition)
		inputColor(color)
		selectRegion(region)
	}

	private void inputDocumentNo(String documentNo, int index) {
		TestObject txfDoc = createTestObject("txfDoc", "id", "gvAssetDocEdit_txtDocNo_$index")
		if(documentNo) {
			String strValue = WebUI.getAttribute(txfDoc, "value")
			if(!strValue) {
				manualClearText(txfDoc)
			}
			safetyInput(txfDoc, documentNo)
		}
	}

	private void checkAllAssetDocument() {
		for(int i=0 ; i< 8; i++) {
			TestObject chxDoc = createTestObject("chxDoc", "id", "gvAssetDocEdit_cbChecked_$i")
			String strChecked = WebUI.getAttribute(chxDoc, "checked")
			boolean isChecked = strChecked.toBoolean()
			if(!isChecked) {
				safetyClick(chxDoc)
				WebUI.delay(0.5)
			}
		}
	}
	private void inputBPKPNo(String documentNo) {
		inputDocumentNo(documentNo, 0)
	}
	private void inputFakturNo(String documentNo) {
		inputDocumentNo(documentNo, 1)
	}

	private void inputAssetDocument(String bpkpNo, String fakturNo) {
		boolean assetDocPresent = WebUI.waitForElementPresent(lblSubSection, 4, FailureHandling.OPTIONAL)
		if(assetDocPresent && bpkpNo) {
			checkAllAssetDocument()
			inputBPKPNo(bpkpNo)
			inputFakturNo(fakturNo)
		}
	}
}