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

'Step 1: Check and iput FC Ktp Pemohon'
tnc.checkFcKTPPemohon1(CheckFcKtpPemohon)

'Step 2: Check and input FC KK'
tnc.checkFcKK(CheckFcKartuKeluarga)

'Step 3: Check and input FC Ijin praktek'
tnc.checkFcIjinPraktek(CheckFcIjinPraktek)

'Step 4: Check and input FC Npwp'
tnc.checkFcNpwp(CheckFcNpwp)

'Step 5: Check and input Fc Tabungan' 
tnc.checkFcTabungan(CheckFcTabungan)

'Step 6: Chek and Input Fc Document kepemilikan rumah'
tnc.checkFcDocKepemilikanRumah(CheckDocKepemilikanRumah)

'Step 7: Check and iput FC Ktp Pemohon'
tnc.checkFcKtpPemohon2(CheckFcKtpPemohon)

'Step 8: click save'
tnc.clickSave()

'Step 9: Switch to iframe main page'
tnc.switchToIframeMainPage()

'Step 10: click submit'
tnc.clickSubmit()

'Step 11: Click confirmation ok'
tnc.clickConfirmationOk()

