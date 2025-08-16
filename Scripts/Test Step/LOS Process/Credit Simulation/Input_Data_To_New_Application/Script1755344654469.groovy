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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CreditSimulationToNewApplication credsim = new CreditSimulationToNewApplication()

'Step 1 : input main data'
credsim.inputMainData(PhoneNumber, NpwpNumber)

'Step 2 : input address info'
credsim.inputAddressInfo(JobAddress, ResidenceAddress)

'Step 3 : input other info'
credsim.inputOtherInfo(Notes)

'Step 4 : upload document customer'
credsim.uploadDocumentCustomer()

'Step 5 : upload document spouse'
credsim.uploadDocumentSpouse()

'Step 6 : upload document stnk'
credsim.uploadDocumentSTNK()

'Step 7 : click button save'
credsim.clickSave()

'Step 8 : input button submit'
credsim.clickSubmit()