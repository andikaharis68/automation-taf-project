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
import com.taf.pageobjects.losCreditProcess.CentralizedDataEntryCompletion

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CentralizedDataEntryCompletion cdeCompletion = new CentralizedDataEntryCompletion()

'Step 1: switch to iframe'
cdeCompletion.switchToIframeMain()

'Step 2: input information from deal and decision engine'
cdeCompletion.inputInfoDealAndDecision(InformationFromDealNotes)

'Step 3: input customer main data'
cdeCompletion.inputCustomerMainData(Gender, Religion, Education, MobilePhone1, MotherMaidenName)

'Step 4: input contact result'
cdeCompletion.inputContactResult(IsCallSucceded, Reason, ContactedPersonRelationship, SurveyorCode, ContactedName, ContactResultNotes)

'Step 5: input customer job data'
cdeCompletion.inputCustomerJobData(ProfessionName, IndustryTypeName, JobPosition, JobStatus, CompanyName, EmploymentEstablishmentMonth, EmploymentEstablishmentYear, TeleSurveyPosition)

'Step 6: edit residence address'
cdeCompletion.clickEditResidenceAddress()

'Step 7: input residence address main'
cdeCompletion.inputResidenceAddressMain(Kelurahan, Kecamatan, City, ZIPCODE, ResidenceAddress, RT, RW, PhoneArea, Phone, PhoneExt)

'Step 8: input residence address info'
cdeCompletion.inputResidenceAddressInfo(BuildingType, BuildingOwnership, BuildingStayLength)

'Step 9: save residance address'
cdeCompletion.clickSaveAddress()

'Step 10: edit job address'
cdeCompletion.clickEditJobAddress()

'Step 11: copy address from residence address to job address'
cdeCompletion.copyJobAddressFromResidenceAddress()

'Step 12: save job addess'
cdeCompletion.clickSaveAddress()

'Step 13: add new address'
cdeCompletion.clickAddAddress()

'Step 14: copy and add legal address'
cdeCompletion.copyAndAddLegalAddressFromResidenceAddress()

'Step 15: save legal address'
cdeCompletion.clickSaveAddress()

'Step 16: input attribute list'
cdeCompletion.inputAttributeList(DebitorGroup, DebitorBusinessScale, CounterpartCategory, DebitorGroupSlik, AffiliateMultifinanceSlik)

'Step 17: select way of payment'
cdeCompletion.selectWayOfPayment(WayOfPayment)

'Step 18: edit asset'
cdeCompletion.clickEditAsset()

'Step 19: input asset user, select self usage'
cdeCompletion.inputAssetUser(SelfUsage)

'Step 20: copy asset location from legal address'
cdeCompletion.copyAssetLocationFromLegalAddress()

'Step 21: input other asset info'
cdeCompletion.inputOtherAssetInfo(AssetUsage, TeleSurveyUnitUsage)

'Step 22: save asset user'
cdeCompletion.clickSaveAssetUser()

'Step 23: submit'
cdeCompletion.clickSubmit()

'Step 24: verify submit success'
cdeCompletion.verifySubmitSuccess()

'Step 25: switch to default frame'
cdeCompletion.switchToDefaultContent()







