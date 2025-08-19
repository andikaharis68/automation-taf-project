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
import com.taf.pageobjects.customers.MainDataPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

MainDataPage mainData = new MainDataPage()
AddressPage address = new AddressPage()

'Step 0: Switch Iframe'
mainData.switchToIframeMainPage()
mainData.switchToIframeCustForm()

'Step 1: verify landing'
mainData.verifyLandingInMainData()

'Step 1: Select Salutation'
mainData.selectSalutation(Salutation)

'Step 2: Input Prefix Name'
mainData.inputPrefixName(PrefixName)

'Step 3 Input Full Name'
mainData.inputFullName(FullName)

'Step 4: Input Suffix Name'
mainData.inputSuffixName(CustomerSuffixName)

'Step 5: Input Nick Name'
mainData.inputNickName(NickName)

'Step 6: Check Is Premium'
mainData.checkPremiumStatus(IsPremium)

'Step 7: Select Marital Status'
mainData.selectMaritalStatus(MaritalStatus)

'Step 8: Select Customer Group'
mainData.selectCustomerGroup(FullName, CustomerGroup)

'Step 9: Input Number Of Dependents'
mainData.inputNumberOfDependents(NumofDependents)

'Step 10: Input Number Of Residence'
mainData.inputNumberOfResidence(NumofResidence)

'Step 11: Input Family Card Number'
mainData.inputFamilyCardNum(FamilyCardNum)

'Step 12: Select Nationality'
mainData.selectNationality(Nationality)

'Step 13: Select Country'
mainData.selectCountry(Country)

'Step 14: Select Education'
mainData.selectEducation(Education)

'Step 15: Select Religion'
mainData.selectReligion(Religion)

'Step 16: Check isVIP'
mainData.checkIsVIP(IsVIP)

'Step 17: Input Premium Note'
mainData.inputPremiumNote(PremiumNote)

'Step 18: Input SID No'
mainData.inputSIDNo(SIDNo)

'Step 19: Check Affiliation with multifinance'
mainData.checkAffiliationWithMultifinance(AffiliationWithMultifinance)

'Step 20: Check RIP'
mainData.checkRIP(RIP)

'Step 21: Input Mobile Phone1'
mainData.inputMobilePhone(1, MobilePhoneNo1)

'Step 22: Input Mobile Phone2'
mainData.inputMobilePhone(2, MobilePhoneNo2)

'Step 22: Input Mobile Phone3'
mainData.inputMobilePhone(3, MobilePhoneNo3)

'Step 23: Input Email1'
mainData.inputEmail(1, Email1)

'Step 24: Input Email2'
mainData.inputEmail(2, Email2)

'Step 25: Click Save and Continue'
mainData.clickSaveAndContinue()

'Step 26: Verify landing in Address section'
address.verifyLandingInAddressSection()