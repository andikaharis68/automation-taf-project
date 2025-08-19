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
import com.taf.pageobjects.customers.CompanyCustomerMainDataPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CompanyCustomerMainDataPage companyCustomerMainDataPage = new CompanyCustomerMainDataPage()
AddressPage address = new AddressPage()

'Step 1: check box the is new application'
companyCustomerMainDataPage.clickIsNewApplication(NextToNewApplication)

'Step 2: need to switch iframe customer form'
companyCustomerMainDataPage.switchToIframeCustForm()

'Step 3: Verify landing in main data page'
companyCustomerMainDataPage.verifyLandingInMainPage()

'Step 4: checkbox the is affiliate'
companyCustomerMainDataPage.clickCheckBoxIsAffiliate(AffiliationWithMultifinance)

'Step 5: checkbox the is premium customer'
companyCustomerMainDataPage.clickCheckBoxIsPremium(IsPremium, PremiumNote)

'Step 6: checkbox the is VIP customer'
companyCustomerMainDataPage.clickCheckBoxIsVIP(IsVIP)

'Step 7: input the number of employees'
companyCustomerMainDataPage.inputNumberOfEmployees(NumberofEmployee)

'Step 8: input customer sidNo'
companyCustomerMainDataPage.inputCustomerSidNo(SIDNo)

'Step 9: input establishment date'
companyCustomerMainDataPage.inputEstablishmentDate(EstablishmentDate)

'Step 10: input industry name from lookup industry'
companyCustomerMainDataPage.inputIndustryNameFromLookup(IndustryTypeName)

'Step 11: input customer group for first found in lookup'
companyCustomerMainDataPage.inputCustomerGroupThenSelectedFirstFound(CustomerGroup)

'Step 12: save content after main data is filled'
companyCustomerMainDataPage.saveContentAfterMainDataIsFilled()

'Step 13: Verify Landing Address Page'
address.verifyLandingInAddressSection()













