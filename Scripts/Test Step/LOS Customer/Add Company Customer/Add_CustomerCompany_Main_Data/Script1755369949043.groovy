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
import com.taf.customers.AddCompanyCustomerPage
import com.taf.customers.CompanyCustomerMainDataPage
import com.taf.customers.CustomerInformationPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def addCompanyCustomerPage = new AddCompanyCustomerPage()
def customerInfoPage = new CustomerInformationPage()
def companyCustomerMainDataPage = new CompanyCustomerMainDataPage()

KeywordUtil.logInfo("scenarioData : ${CustomerModel}, ${CompanyName}, ${CompanyType}")


'Step 1 : click button customer'
customerInfoPage.addCompanyCustomer();

'Step 2 : select customer model'
addCompanyCustomerPage.selectCustomerModel(CustomerModel)

'Step 3 : input customer name with company name'
addCompanyCustomerPage.inputCustomerName(CompanyName)

'Step 4: input customer type'
addCompanyCustomerPage.selectCompanyType(CompanyType)

'Step 5: input customer NPWP'
addCompanyCustomerPage.inputCustomerNPWP(NPWP)

'Step 6: input customer NITKU'
addCompanyCustomerPage.inputCustomerNitku(NITKU)

'Step 7: click next'
addCompanyCustomerPage.clickNextButton()

'Step 8: click main data tab'
companyCustomerMainDataPage.clickMainDataTabOrEditPage()

'Step 9: check box the is new application'
companyCustomerMainDataPage.clickIsNewApplication(NextToNewApplication == "1")

'Step 10: need to switch iframe customer form'
companyCustomerMainDataPage.switchToIframeCustForm()

'Step 11: checkbox the is affiliate'
companyCustomerMainDataPage.clickCheckBoxIsAffiliate(AffiliationWithMultifinance == "1")

'Step 11: checkbox the is premium customer'
companyCustomerMainDataPage.clickCheckBoxIsPremium(IsPremium == "1", PremiumNote)

'Step 12: checkbox the is VIP customer'
companyCustomerMainDataPage.clickCheckBoxIsVIP(IsVIP == "1")

'Step 13: checkbox the is VIP customer'
companyCustomerMainDataPage.inputNumberOfEmployees(NumberofEmployee)

'Step 14: input customer sidNo'
companyCustomerMainDataPage.inputCustomerSidNo(SIDNo)

'Step 15: input establishment date'
companyCustomerMainDataPage.inputEstablishmentDate(EstablishmentDate)

'Step 16: input industry name from lookup industry'
companyCustomerMainDataPage.inputIndustryNameFromLookup(IndustryTypeName)

'Step 16: input customer group for first found in lookup'
companyCustomerMainDataPage.inputCustomerGroupThenSelectedFirstFound(CustomerGroup)

'Step 17: save content after main data is filled'
companyCustomerMainDataPage.saveContentAfterMainDataIsFilled()












