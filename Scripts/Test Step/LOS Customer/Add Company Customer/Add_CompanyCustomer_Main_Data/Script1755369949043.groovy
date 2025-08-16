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
import com.taf.customers.CustomerInformationPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

AddCompanyCustomerPage addCompanyCustomerPage = new AddCompanyCustomerPage()
CustomerInformationPage custInfoPage = new CustomerInformationPage()

KeywordUtil.logInfo("scenarioData : ${CustomerModel}, ${CompanyName}, ${CompanyType}")


'Before running click company customer page'
custInfoPage.addCompanyCustomer()




'Step 1: Click button Customer Model'
addCompanyCustomerPage.selectCustomerModel(CustomerModel)


'Step 2: Input Customer Name'
addCompanyCustomerPage.inputCustomerName(CompanyName)

'Step 3: Input Company Type'
addCompanyCustomerPage.selectCompanyType(CompanyType)

'Step 4: Input Company Type'
addCompanyCustomerPage.inputCustomerNPWP(NPWP)

'Step 5: Input Customer NITKU'
addCompanyCustomerPage.inputCustomerNitku(NITKU)

'Step 6: Click next button'
addCompanyCustomerPage.clickNextButton()


