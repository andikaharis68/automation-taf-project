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
import com.taf.pageobjects.remedials.CollectionUnblockRequest

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CollectionUnblockRequest request = new CollectionUnblockRequest()

'Step 1: Verify Landing page'
request.verifyLandingPage()

'Step 2: Search name'
request.searchCustomer(OfficeName,OverdueDaysGreaterThan , LastActionDateGreaterThan, CustomerName, TypeOfProblem, CollectorName, AgreementNo, OverdueDaysLessThan, LastActionDateLessThan
, Attention, EWSMonitoringStatus)

'Step 3: Update agreement no to  sheet master data and remedial amount request '
request.updateAgreementNoToExcelData(TestDataName, GlobalVariable.SCENARIO_ID)

'Step 4: Click edit pencil unblock'
request.clickEditUnblock()

'Step 5: Input notes'
request.inputNotes(NotesUnblock)

'Step 6: Click Submit'
request.clickSubmit()

'Step 7: Verify Landing page'
request.verifyLandingPage()

