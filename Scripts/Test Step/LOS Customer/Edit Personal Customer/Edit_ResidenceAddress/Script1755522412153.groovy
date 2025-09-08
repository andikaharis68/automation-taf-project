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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.pageobjects.customers.AddressPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

AddressPage address = new AddressPage()

if(IsEditResidenceAddress == "Y") {
	
	'Step 0: check is address exist or not. if not it would be added new address'
	def addressExist = address.checkAddressList("Residence Address")
	if(addressExist) {
			'Step 1: click add address'
			address.clickEditAddress("Residence Address")
	}else {
		'Step 1: click add address'
		address.clickAddAddress()
		
		'Step 2: Select Address Type = Residence Address'
		address.selectAddressType("Residence Address")
	}
	
	'Step 3: Select ZIP Code'
	address.checkAddress(ResidenceZipCode)
	
	'Step 4: Input Address'
	address.inputAddress(ResidenceAddress)
	
	'Step 5: Input RT'
	address.inputRT(ResidenceRT)
	
	'Step 6: Input RW'
	address.inputRW(ResidenceRW)
	
	'Step 7: Check Customer Have Fixed Line'
	address.checkCustomerHaveFixedline(ResidenceCustomerDoesNotHaveFixedline)
	
	'Step 8: Input Phone 1'
	address.inputPhoneNumbers(ResidencePhone1, 1)
	
	'Step 10: Input Phone 2'
	address.inputPhoneNumbers(ResidencePhone2, 2)
	
	'Step 11: Input Phone 3'
	address.inputPhoneNumbers(ResidencePhone3, 3)
	
	'Step 12: Input Fax'
	address.inputFax(ResidenceFax)
	
	'Step 13: Select Building Class Location'
	address.selectBuildingLocation(ResidenceBuildingLocationClass)
	
	'Step 14: Select Building Ownership'
	address.selectBuildingOwnerShip(ResidenceBuildingOwnership)
	
	'Step 15: Input Building price estimates'
	address.inputBuildingPriceEstimates(ResidenceBuildingPriceEstimates)
	
	'Step 16: Input Building stay length'
	address.inputBuildingStayLength(ResidenceBuildingStayLength)
	
	'Step 17: Input Direction description'
	address.inputDirectionDesc(ResidenceDirectionDescription)
	
	'Step 18: Input notes'
	address.inputNotes(ResidenceNotes)
	
	'Step 19: Input Company Name'
	address.inputCompanyName(ResidenceCompanyName)
	
	'Step 20: Click Save'
	address.clickSaveAddress()
}