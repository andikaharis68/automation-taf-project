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
import com.taf.helpers.BaseHelper
import com.taf.pageobjects.customers.AddressPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

AddressPage address = new AddressPage()

'Step 1: click add address'
address.clickAddAddress()

'Step 2: Select Address Type = Legal Address'
AddressType = "Company Address"
address.selectAddressType(AddressType)

'Step 3: Get Address Detail from excel'
Map AddressData = address.getAddressDetail(ScenarioId, AddressType, GlobalVariable.TEST_DATA_LOCATION + "/" + "LOS_CompanyCustomer_TestData.xlsx", "Address")

'Step 4: Input Address'
address.inputAddress(AddressData.Address)

'Step 5: Input RT'
address.inputRT(AddressData.RT)

'Step 6: Input RW'
address.inputRW(AddressData.RW)

'Step 7: Select ZIP Code'
address.searchAddress(AddressData.ZIPCODE)

'Step 8: Check Customer Have Fixed Line'
address.checkCustomerHaveFixedline(AddressData.CustomerDoesNotHaveFixedline)

'Step 9: Input Phone 1'
address.inputPhoneNumbers(AddressData.Phone1, 1)

'Step 10: Input Phone 2'
address.inputPhoneNumbers(AddressData.Phone2, 2)

'Step 11: Input Phone 3'
address.inputPhoneNumbers(AddressData.Phone3, 3)

'Step 12: Input Fax'
address.inputFax(AddressData.Fax)

'Step 13: Select Building Class Location'
address.selectBuildingLocation(AddressData.BuildingLocationClass)

'Step 14: Select Building Ownership'
address.selectBuildingOwnerShip(AddressData.BuildingOwnership)

'Step 15: Input Building price estimates'
address.inputBuildingPriceEstimates(AddressData.BuildingPriceEstimates)

'Step 16: Input Building stay length'
address.inputBuildingStayLength(AddressData.BuildingStayLength)

'Step 17: Input Direction description'
address.inputDirectionDesc(AddressData.DirectionDescription)

'Step 18: Input notes'
address.inputNotes(AddressData.Notes)

'Step 19: Click Save'
address.clickSaveAddress()

'Step 20: Click Save and continue'
address.clickSaveContinue()




