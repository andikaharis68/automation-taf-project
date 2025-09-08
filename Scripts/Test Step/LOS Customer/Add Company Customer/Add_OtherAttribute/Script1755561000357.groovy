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
import com.taf.pageobjects.MenuPage
import com.taf.pageobjects.customers.CustomerInformationPage
import com.taf.pageobjects.customers.OtherAttributePage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

OtherAttributePage attr = new OtherAttributePage()
MenuPage menu = new MenuPage()
CustomerInformationPage custInfo = new CustomerInformationPage()

menu.switchIframeMainPage()
menu.switchIframeCustForm()

'Step 1: Verify landing in other attribute'
attr.verifyLandingInOtherAttribute()

'Step 2: Select Debitor grup'
attr.selectDebitorGroup(DebitorGroup)

'Step 3: Select Counterpart group'
attr.selectCounterpartCategory(CounterpartCategory)

'Step 4: Select Sustainable financial bussiness'
attr.selectSustainableFinancial(SustainableFinancialBusiness)

'Step 5: Input good bad status'
attr.inputGoodBadStatus(GoodBadStatus)

'Step 6: Check go public'
attr.checkIsGoPublic(GoPublic)

'Step 7: Input customer criteria'
attr.inputCustomerCriteria(CustomerCriteria)

'Step 8: Select Debitor Group SLIK'
attr.selectDebitorGroupSlik(DebitorGroupSLIK)

'Step 9: Check violate BMPK'
attr.checkViolateBMPK(ViolateBMPK)

'Step 10: Check exceed BMPK'
attr.checkExceedBMPK(ExceedBMPK)

'Step 11: Input rating debitor'
attr.inputRatingDebitor(RatingDebitor)

'Step 12: Select rating institute'
attr.selectRatingInstitute(RatingInstitute)

'Step 13: Input rating date'
attr.inputRatingDate(RatingDate)

'Step 14: Select affiliate with multifinance SLIK'
attr.selectAffiliate(AffiliateWithMultifinanceSLIK)

'Step 15: Check diff marital status'
attr.checkDifferentMaritalStatus(DifferentMaritalStatus, "10")

'Step 16: Check home ownership doc'
attr.checkHomeOwnershipDoc(HomeOwnershipDocument, "11")

'Step 17: Check same address'
attr.checkSameAddress(SameAddress, "12")

'Step 18: Input no ATM'
attr.inputATMNo(NoATM)

'Step 19: Check customer data consent'
attr.checkCustomerDataConsent(CustomerDataConsent, "14")

'Step 20: Check CDE notes'
attr.checkCDENotes(CdeNotes, "15")

'Step 21: click Save and Submit'
attr.clickSaveAndSubmit()

'Step 22: Verify success message'
menu.verifySuccessMessage()

menu.switchIframeMainPage()

'Step 23: Verify landing in Customer info page'
custInfo.verifyLandingInCustInfoPage()


