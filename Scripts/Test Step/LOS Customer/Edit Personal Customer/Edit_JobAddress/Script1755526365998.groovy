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
import com.taf.pageobjects.customers.AddressPage
import com.taf.pageobjects.customers.FamilyCustomerPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

AddressPage address = new AddressPage()
FamilyCustomerPage family = new FamilyCustomerPage()

if(IsEditJobAddress == "Y") {
	
	'Step 1: click add address'
	address.clickEditAddress("Job Address")
	
	'Step 3: Select ZIP Code'
	address.searchAddress(JobZipCode)
	
	'Step 4: Input Address'
	address.inputAddress(JobAddress)
	
	'Step 5: Input RT'
	address.inputRT(JobRT)
	
	'Step 6: Input RW'
	address.inputRW(JobRW)
	
	'Step 8: Check Customer Have Fixed Line'
	address.checkCustomerHaveFixedline(JobCustomerDoesNotHaveFixedline)
	
	'Step 9: Input Phone 1'
	address.inputPhoneNumbers(JobPhone1, 1)
	
	'Step 10: Input Phone 2'
	address.inputPhoneNumbers(JobPhone2, 2)
	
	'Step 11: Input Phone 3'
	address.inputPhoneNumbers(JobPhone3, 3)
	
	'Step 12: Input Fax'
	address.inputFax(JobFax)
	
	'Step 13: Select Building Class Location'
	address.selectBuildingLocation(JobBuildingLocationClass)
	
	'Step 14: Select Building Ownership'
	address.selectBuildingOwnerShip(JobBuildingOwnership)
	
	'Step 15: Input Building price estimates'
	address.inputBuildingPriceEstimates(JobBuildingPriceEstimates)
	
	'Step 16: Input Building stay length'
	address.inputBuildingStayLength(JobBuildingStayLength)
	
	'Step 17: Input Direction description'
	address.inputDirectionDesc(JobDirectionDescription)
	
	'Step 18: Input notes'
	address.inputNotes(JobNotes)
	
	'Step 19: Input Company Name'
	address.inputCompanyName(JobCompanyName)
	
	'Step 20: Click save address'
	address.clickSaveAddress()
}

'Step 21: Click Save and continue'
address.clickSaveContinue()

'Step 22: Verify landing in family customer page'
family.verifyLandingFamilyPage()

