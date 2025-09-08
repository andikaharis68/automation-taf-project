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
import com.taf.pageobjects.customers.CustomerInformationPage
import com.taf.pageobjects.customers.FinancialDataPage
import com.taf.pageobjects.customers.OtherAttributePage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

OtherAttributePage attr = new OtherAttributePage()
CustomerInformationPage custInfo = new CustomerInformationPage()
FinancialDataPage financial = new FinancialDataPage()

'Step 1: Select Debitor grup'
attr.selectDebitorGroup(DebitorGroup)

'Step 2: Select Counterpart group'
attr.selectCounterpartCategory(CounterpartCategory)

'Step 3: Select Sustainable financial bussiness'
attr.selectSustainableFinancial(SustainableFinancialBusiness)

'Step 4: Input EAAccount Flag'
attr.inputEAccountFlag(EAccountFlag)

'Step 5: Input EAccount Join date'
attr.inputEAccountJoinDate(EAccountJoinDate)

'Step 6: Input Customer Rating'
attr.inputCustomerRating(CustRating)

'Step 7:input Good Bad Status'
attr.inputGoodBadStatus(GoodBadStatus)

'Step 8: input terduga terorism'
attr.inputSuspectTerrorism(TerdugaTerorisPPSPM)

'Step 9: Input SIM NO'
attr.inputSimNo(NoSIM)

'Step 10: check is split treasure'
attr.checkIsSplitTreasure(IsSplitTreassure)

'Step 11: check violate bmpk'
attr.checkViolateBMPK(ViolateBMPK)

financial.takeScreenShot()

'Step 12: check exceed bpmk'
attr.checkExceedBMPK(ExceedBMPK)

'Step 13: search slik debitor group'
attr.selectDebitorGroupSlik(DebitorGroupSLIK)

'Step 13: check same address'
attr.checkSameAddress(SameAddress, "11")

'Step 14: check same job'
attr.checkSameJob(SameJob)

'Step 15: check same position'
attr.checkSamePosition(SamePosition)

'Step 16: check different marital status'
attr.checkDifferentMaritalStatus(DifferentMaritalStatus, "14")

'Step 17: check home ownership document'
attr.checkHomeOwnershipDoc(HomeOwnershipDocument, "15")

'Step 18: No ATM'
attr.inputATMNo(NoATM)

'Step 19: Input customer data consent'
attr.checkCustomerDataConsent(CustomerDataConsent, "17")

'Step 20: Input rating debitor'
attr.inputRatingDebitor(RatingDebitor)

'Step 21: Input rating date'
attr.inputRatingDate(RatingDate)

'Step 22: check CDE notes'
attr.checkCDENotes(CdeNotes, "20")

'Step 23: Click Save'
attr.clickSaveAttributeData()

'Step 24: Swith to iframe main '
attr.switchToIframeMain()

'Step 25: click save data'
attr.clickSaveData()

'Step 26: Verify landing in Customer info page'
custInfo.verifyLandingInCustInfoPage()

financial.takeScreenShot()


