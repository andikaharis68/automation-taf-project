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
import com.taf.pageobjects.customers.LegalDocument

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

LegalDocument legalDoc = new LegalDocument()

'Step 1: Handler iFrame, switch to default then switch to main frame'
legalDoc.switchToIframeMain()

'Step 2: Verify landing in Legal Document Page'
legalDoc.verifyLandingScreen()

'Step 3: Input legal documents, included click add on each adding documents'
legalDoc.inputLegalDocument(LegalDocType, DocumentNo, DateIssued, ExpiredDate, Notes, NotaryName, NotaryLocation)

'Step 4: Save and continue'
legalDoc.clickSaveAndContinue()

'Step 5: Verify save success'
legalDoc.verifySaveSuccess()