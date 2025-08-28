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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.pageobjects.MenuPage
import com.taf.pageobjects.customers.AddressPage as AddressPage
import com.taf.pageobjects.customers.CompanyCustomerMainDataPage as CompanyCustomerMainDataPage
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CompanyCustomerMainDataPage companyCustomerMainDataPage = new CompanyCustomerMainDataPage()

AddressPage address = new AddressPage()
MenuPage menu = new MenuPage()

'Step 1: check box the is new application'
companyCustomerMainDataPage.clickIsNewApplication(NextToNewApplication)

'Step 2: Get Application No'
ApplicationNo = companyCustomerMainDataPage.getApplicationNo()

'Step 3: need to switch iframe customer form'
companyCustomerMainDataPage.switchToIframeCustForm()

'Step 4: Verify landing in main data page'
companyCustomerMainDataPage.verifyLandingInMainPage()

'Step 5: checkbox the is affiliate'
companyCustomerMainDataPage.clickCheckBoxIsAffiliate(AffiliationWithMultifinance)

'Step 6: checkbox the is premium customer'
companyCustomerMainDataPage.clickCheckBoxIsPremium(IsPremium, PremiumNote)

'Step 7: checkbox the is VIP customer'
companyCustomerMainDataPage.clickCheckBoxIsVIP(IsVIP)

'Step 8: input the number of employees'
companyCustomerMainDataPage.inputNumberOfEmployees(NumberofEmployee)

'Step 9: input customer sidNo'
companyCustomerMainDataPage.inputCustomerSidNo(SIDNo)

'Step 10: input establishment date'
companyCustomerMainDataPage.inputEstablishmentDate(EstablishmentDate)

'Step 11: input industry name from lookup industry'
companyCustomerMainDataPage.inputIndustryNameFromLookup(IndustryTypeName)

'Step 12: input customer group for first found in lookup'
companyCustomerMainDataPage.inputCustomerGroupThenSelectedFirstFound(CustomerGroup)

'Step 13: save content after main data is filled'
companyCustomerMainDataPage.saveContentAfterMainDataIsFilled()

'Step 14: Verify success message'
menu.verifySuccessMessage()

