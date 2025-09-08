package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.OPTIONAL
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.VerifyElementCheckedKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class TermAndCondition extends BaseHelper {

	private TestObject btnSave			= createTestObject("btnSave","id","lb_Form_Save")
	private TestObject lblSection		= createTestObject("lblSection", "id", "ucTermCond_subSectionID")
	private TestObject btnSubmit		= createTestObject("btnSubmit", "id", "lbl_Toolbar_Submit")
	private TestObject iframeMainPage	= createTestObject("iframeMainPage", "id", "mainPage")

	private void verifyLandingInTnCPage() {
		verifyLanding(lblSection, "Term and Condition")
		WebUI.takeScreenshot()
	}

	private void fillDataForKTPPemohon(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "FOTOKOPI KTP PEMOHON"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}

	private void fillDataForFCKTPSpouse(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "FOTOKOPI KTP SUAMI/ISTRI"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}
	private void fillDataForForFCKK(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "FOTOKOPI KARTU KELUARGA"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}

	private void fillDataForFCIjinPraktek(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "FOTOKOPI IJIN PRAKTEK"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}

	private void fillDataForFCNpwp(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "FOTOKOPI NPWP"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}

	private void fillDataForFCTabungan(String checkFc, String promiseDate, String expiredDate, String notes ) {
		String label = "FOTOKOPI TABUNGAN/REKENING KORAN"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}

	private void fillDataFCDocSuratMenikah(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "DOKUMEN SURAT MENIKAH"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}

	private void fillDataCoverBukuTabungan(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "Cover Buku Tabungan"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}

	private void fillDataForKkStnk(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "KK Atas Nama STNK"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}
	private void fillDataForFcSlipGaji(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "FOTOKOPI SLIP GAJI"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}
	private void fillDataForInvoice(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "INVOICE"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}

	private void fillDataForFCKTPKomisaris(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "FOTOKOPI KTP KOMISARIS"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}
	private void fillDataForFCKTPDirektur(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "FOTOKOPI KTP DIREKTUR ATAU YANG DIBERI KUASA"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}
	private void fillDataForFCSiup(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "FOTOKOPI SIUP"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}
	private void fillDataForFcFinanceReport(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "FOTOKOPI LAPORAN KEUANGAN"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}
	private void fillDataForFcTDP(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "FOTOKOPI TDP/TDR"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}
	private void fillDataForFcAktePendirian(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "FC AKTE PENDIRIAN PERUSAHAAN DAN PERUBAHANNYA"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}
	private void fillDataForFcRekeningListrik(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "FOTOKOPI REKENING LISTRIK"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}
	private void fillDataForFcDocKeuanganLain(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "DOK KEUANGAN LAIN (BON KEUANGAN / NOTA PENJUALAN)"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}

	private void fillDataForFcSPK(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "SURAT PERJANJIAN KERJA JK USAHA RENTAL/KONTRAKTOR"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}
	private void fillDataForDocKepemilikanRumah(String checkFc, String promiseDate, String expiredDate, String notes) {
		String label = "DOKUMEN KEPEMILIKAN RUMAH (PBB / AKTA JUAL BELI)"
		fillDocumentData(label, checkFc, promiseDate, expiredDate, notes)
	}
	private void clickSave() {
		WebUI.takeScreenshot()
		safetyClick(btnSave)
	}

	private void switchToIframeMainPage() {
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(iframeMainPage, 2)
	}
	private void clickSubmit() {
		safetyClick(btnSubmit)
	}

	private void clickConfirmationOk() {
		if(WebUI.waitForAlert(5)) {
			WebUI.acceptAlert()
		} else {
			KeywordUtil.markFailed("Pop up not found ")
		}
	}

	private void setInputIfPresent(String docLabel, String partialId, String value, String fieldName) {
		if (!value) return
			TestObject inputField = createTestObject("input_${fieldName}", "xpath", "//tr[td/span[text()='${docLabel}']]//input[contains(@id,'${partialId}')]")
		boolean isElementDisabled =  WebUI.verifyElementPresent(inputField, 3, OPTIONAL) ? checkOptionDisabled(inputField) : false
		if (WebUI.verifyElementPresent(inputField, 3, OPTIONAL) && !isElementDisabled) {
			safetyInput(inputField, value)
			WebUI.comment("${fieldName} for '${docLabel}' set to ${value}")
			clickTABKeyboard(inputField)
			WebUI.delay(2)
		}
	}

	private void clickCheckboxByDocName(String docLabel, String checkValue) {
		TestObject checkbox = createTestObject("checkbox", "xpath", "//tr[td/span[text()='${docLabel}']]//input[@type='checkbox']")
		if (WebUI.verifyElementPresent(checkbox, 5, FailureHandling.OPTIONAL) && checkValue?.equalsIgnoreCase("Y")) {
			WebUI.waitForElementVisible(checkbox, 3) //elementnya harus visible dulu bisa verifyelementchecked
			boolean alreadyChecked = WebUI.verifyElementChecked(checkbox, 2, FailureHandling.OPTIONAL)
			if (!alreadyChecked) {
				safetyClick(checkbox)
				WebUI.comment("Checkbox for '${docLabel}' is now checked.")
				WebUI.delay(2)
			} else {
				WebUI.comment("Checkbox for '${docLabel}' was already checked.")
			}
		}
	}

	private void fillDocumentData(String docLabel, String checkValue, String promiseDate, String expiredDate, String notes) {
		clickCheckboxByDocName(docLabel, checkValue)
		setInputIfPresent(docLabel, 'ucDPPromiseDt', promiseDate, 'Promise Date')
		setInputIfPresent(docLabel, 'ucDPExpiredDt', expiredDate, 'Expired Date')
		setInputIfPresent(docLabel, 'txtNote', notes, 'Notes')
	}

	def void clickDuplicateCheckboxesOnlySecond() {
		def driver = DriverFactory.getWebDriver()
		List<WebElement> docNames = driver.findElements(By.xpath("//span[starts-with(@id,'gvTermCondition_lblDocName_')]"))
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[starts-with(@id,'gvTermCondition_cbChecked_')]"))
		Map<String, List<Integer>> nameToIndexes = [:]

		for (int i = 0; i < docNames.size(); i++) {
			String docName = docNames[i].getText().trim()

			if (!nameToIndexes.containsKey(docName)) {
				nameToIndexes[docName] = []
			}
			nameToIndexes[docName] << i
		}
		// Cek duplikat
		nameToIndexes.each { docName, indexes ->
			if (indexes.size() > 1) {
				println "⚠️ Document '${docName}' duplicate pada index: ${indexes}"
				indexes.drop(1).each { idx ->
					WebElement cb = checkboxes[idx]
					if (!cb.isSelected()) {
						cb.click()
						println "✅ Checkbox untuk '${docName}' di baris ${idx} dicentang"
					}
				}
			}
		}
	}
}