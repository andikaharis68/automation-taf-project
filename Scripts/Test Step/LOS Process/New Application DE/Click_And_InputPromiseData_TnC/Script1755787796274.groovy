import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.pageobjects.losCreditProcess.TermAndCondition

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

TermAndCondition tnc = new TermAndCondition()

'Step 1: fill data based on customer type'
if(CustomerType == "Personal") {
	
	'Step 1: fill data FC Ktp Pemohon'
	tnc.fillDataForKTPPemohon(CheckFcKtpPemohon, PromiseDateKtpPemohon, ExpiredDateKtpPemohon, NotesKtpPemohon)
	
	'Step 2: fill data FC Ktp Spouse'
	tnc.fillDataForFCKTPSpouse(CheckFcKtpSpouse, PromiseDateFcKtpSpouse, ExpiredDatecKtpSpouse, NotesFcKtpSpouse)
	
	'Step 3: fill data Fc KK'
	tnc.fillDataForForFCKK(CheckFcKartuKeluarga, PromiseDateKK, ExpiredDateKK, 	NotesKtpKK)
	
	'Step 4: fill data FC Ijin praktek'
	tnc.fillDataForFCIjinPraktek(CheckFcIjinPraktek, PromiseDateIjinPraktek, ExpiredDateIjinPraktek, NotesIjinPraktek)
	
	'Step 5: fill data Fc Npwp'
	tnc.fillDataForFCNpwp(CheckFcNpwp, PromiseDateNpwp, ExpiredDateNpwp, NotesNpwp)
	
	'Step 6: fill data Fc tabungan'
	tnc.fillDataForFCTabungan(CheckFcTabungan, PromiseDateTabungan, ExpiredDateTabungan, NotesTabungan)
	
	'Step 7: fill data document surat menikah'
	tnc.fillDataFCDocSuratMenikah(CheckDocMenikah, PromiseDateDocMenikah, ExpiredDateDocMenikah, NotesDocMenikah)
	
	'Step 8: fill data document rumah'
	tnc.fillDataForDocKepemilikanRumah(CheckDocKepemilikanRumah, PromiseDateDocKepemilikanRumah, ExpiredDateDocKepemilikanRumah, NotesDocKepemilikanRumah)
	
	'Step 9: fill data cover buku tabungan'
	tnc.fillDataCoverBukuTabungan(CheckCoverBukuTabungan, PromiseDateCoverBukuTabungan, ExpireDateCoverBukuTabungan, NotesCoverBukuTabungan)
	
	'Step 10: fill data KK ataas nama STNK'
	tnc.fillDataForKkStnk(CheckKkAtasNamaStnk, PromiseDateKkAtasNamaStnk, ExpiredDateKkAtasNamaStnk, NotesKkAtasNamaStnk)
	
	'Step 11: fill data invoice'
	tnc.fillDataForInvoice(CheckInvoice, PromiseDateInvoice, ExpiredDateInvoice, NotesInvoice)
	
} else {
	'Step 1: fill data Fc ktp komisaris'
	tnc.fillDataForFCKTPKomisaris(CheckFcKtpKomisaris, PromiseDateFcKtpKomisaris, ExpiredDateFcKtpKomisaris, NotesKtpKomisaris)
	
	'Step 2: fill data fc ktp direktur'
	tnc.fillDataForFCKTPDirektur(CheckFcKtpDirektur, PromiseDateFcKtpDirektur, ExpiredDateKtpDirektur, NotesKtpDirektur)
	
	'Step 3: fill data FC Ijin praktek'
	tnc.fillDataForFCIjinPraktek(CheckFcIjinPraktek, PromiseDateIjinPraktek, ExpiredDateIjinPraktek, NotesIjinPraktek)
	
	'Step 4: fill data Fc Npwp'
	tnc.fillDataForFCNpwp(CheckFcNpwp, PromiseDateNpwp, ExpiredDateNpwp, NotesNpwp)
	
	'Step 5: fill data fc siup'
	tnc.fillDataForFCSiup(CheckFcSIUP, PromiseDateFcSIUP, ExpiredDateFcSIUP, NotesSIUP)
	
	'Step 6: fill data Fc tabungan'
	tnc.fillDataForFCTabungan(CheckFcTabungan, PromiseDateTabungan, ExpiredDateTabungan, NotesTabungan)
	
	'Step 7: fill data finance report'
	tnc.fillDataForFcFinanceReport(CheckFcLaporanKeuangan, PromiseDateLaporanKeuangan, ExpiredDateLaporanKeuangan, NotesLaporanKeuangan)
	
	'Step 8: fill data fc tdp'
	tnc.fillDataForFcTDP(CheckFcTDP, PromiseDateFcTDP, ExpiredDateFcTDP, NotesFcTDP)
	
	'Step 9: fill data akte pendirian'
	tnc.fillDataForFcAktePendirian(CheckFcAktePendirian, PromiseDateFcAktePendirian, ExpiredDateFcAktePendirian, NotesAktePendirian)
	
	'Step 10: fill data rekening listrik'
	tnc.fillDataForFcRekeningListrik(CheckFcRekeningListrik, PromiseDateFcRekeningListrik,ExpiredDateFcRekeningListrik, NotesFcRekeningListrik)
	
	'Step 11: fill data Fc document keuangan lain'
	tnc.fillDataForFcDocKeuanganLain(CheckFcDocumentKeuanganLain, PromiseDateFcDocumentKeuanganLain, ExpiredDateFcDocumentKeuanganLain, NotesFcDocumentKeuanganLain)
	
	'Step 12: fill data fc SPK '
	tnc.fillDataForFcSPK(CheckFcSPK, PromiseDateFcSPK, ExpiredDateFcSPK, NotesFcSPK)
	
	'Step 13: fill data document kepemilikan rumah'
	tnc.fillDataForDocKepemilikanRumah(CheckDocKepemilikanRumah, PromiseDateDocKepemilikanRumah, ExpiredDateDocKepemilikanRumah, NotesDocKepemilikanRumah)
	
	'Step 14: fill data invoice'
	tnc.fillDataForInvoice(CheckInvoice, PromiseDateInvoice, ExpiredDateInvoice, NotesInvoice)
	
}


'Step 2: click save'
tnc.clickSave()

'Step 3: Switch to iframe main page'
tnc.switchToIframeMainPage()

'Step 4: click submit'
tnc.clickSubmit()

'Step 11: Click confirmation ok'
tnc.clickConfirmationOk()

