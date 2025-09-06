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
import com.taf.pageobjects.losCreditProcess.CentralizedDataEntryCompletionPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CentralizedDataEntryCompletionPage cdeCompletion = new CentralizedDataEntryCompletionPage()

'Step 1: switch to iframe'
cdeCompletion.switchToIframeMain()

'Step 2: input information from deal and decision engine'
cdeCompletion.inputInfoDealAndDecision(InformationFromDealNotes)

boolean isCompany = cdeCompletion.getCustomerTypeIsCompany()

'Step 3: input customer main data'
if(!isCompany) {	
	cdeCompletion.inputCustomerMainData(PersonalCustomerModel, Gender, Religion, Education, MobilePhone1, MotherMaidenName)
} else {
	cdeCompletion.inputCustomerMainDataCompany(IndutryTypeName, NumberOfEmployee, EstablishmentDate, AffiliationWithMultifinance)
}

'Step 4: input contact result'
cdeCompletion.inputContactResult(IsCallSucceded, Reason, ContactedPersonRelationship, SurveyorCode, ContactedName, ContactResultNotes)

'Step 5: input customer job data'
if(!isCompany) {	
	cdeCompletion.inputCustomerJobData(ProfessionName, IndustryTypeName, JobPosition, JobStatus, CompanyName, EmploymentEstablishmentMonth, EmploymentEstablishmentYear, TeleSurveyPosition)
}

'Step 6: edit residence address'
if(!isCompany) {	
	cdeCompletion.clickEditResidenceAddress()
} else {
	cdeCompletion.clickEditCompanyAddress()
}

'Step 7: input residence address main'
cdeCompletion.inputResidenceAddressMain(ZipCode, ResidenceAddress, Rt, Rw, PhoneArea, Phone, PhoneExt)

'Step 8: input residence address info'
if(!isCompany) {	
	cdeCompletion.inputResidenceAddressInfo(BuildingType, BuildingOwnership, BuildingStayLength)
} else {
	cdeCompletion.inputResidenceAddressInfo("", BuildingOwnership, BuildingStayLength)
}

'Step 9: save residance address'
cdeCompletion.clickSaveAddress()

'Step 10: edit job address'
if(!isCompany) {
	
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
} else {
	'Step 13: add new address'
	cdeCompletion.clickAddAddress()
	
	cdeCompletion.copyFromCompanyAddress()
	
	cdeCompletion.clickSaveAddress()
	
	cdeCompletion.inputCompnyShareHolder()
	
	cdeCompletion.inputCompanyContactInfo(ContactInfoName, ContactInfoJobPosition)

	cdeCompletion.inputLegalDocument(DocumentNo, DateIssued)
}

'Step 16: input Income Section'
cdeCompletion.inputIncome(GrossMonthlyIncome, GrossProfit, OtherIncome, SourceOfOtherIncome, LivingCost, OtherMonthlyInstallment)

'Step 17: click calculate income'
cdeCompletion.clickCalculateIncome()

'Step 18: input attribute list'
cdeCompletion.inputAttributeList(DebitorGroup, DebitorBusinessScale, CounterpartCategory, DebitorGroupSlik, AffiliateMultifinanceSlik)
cdeCompletion.selectSustainableFinancial(SustainableFinancialBusiness)
if(!isCompany) {	
	cdeCompletion.inputEAccountFlag(EAccountFlag)
	cdeCompletion.inputEAccountJoinDate(EAccountJoinDate)
//cdeCompletion.inputCustRating(CustRating)
//cdeCompletion.inputGoodBadStatus(GoodBadStatus)
	cdeCompletion.inputTerdugaTeroris(TerdugaTerorisPPSPM)
	cdeCompletion.inputNoSIM(NoSIM)
	cdeCompletion.checkIsSplitTreasure(IsSplitTreassure)
	cdeCompletion.checkSameAddress(SameAddress, "11")
	cdeCompletion.checkSameJob(SameJob, "12")
	cdeCompletion.checkSamePosition(SamePosition, "13")
	cdeCompletion.checkDifferentMaritalStatus(DifferentMaritalStatus, "14")
	cdeCompletion.checkHomeOwnershipDoc(HomeOwnershipDocument, "15")
	cdeCompletion.inputATMNo(NoATM)
	cdeCompletion.checkCustomerDataConsent(CustomerDataConsent, "17")
	cdeCompletion.checkCDENotes(CdeNotes, "20")
}
cdeCompletion.checkViolateBMPK(ViolateBMPK)
cdeCompletion.checkExceedBMPK(ExceedBMPK)
cdeCompletion.inputRatingDebitor(RatingDebitor)

'Step 19: select way of payment'
cdeCompletion.selectWayOfPayment(WayOfPayment)

'Step 20: edit asset'
cdeCompletion.clickEditAsset()

'Step 21: input asset user, select self usage'
cdeCompletion.inputAssetUser(SelfUsage)

'Step 22: copy asset location from legal address'
if(!isCompany) {	
	cdeCompletion.copyAssetLocationFromLegalAddress()
} else {
	cdeCompletion.copyAddressAssetOwner()
//	cdeCompletion.selectOwnerIdType(OwnerIdType)
	cdeCompletion.copyAssetLocationFromLegalAddress()
}

'Step 23: input other asset info'
cdeCompletion.inputOtherAssetInfo(AssetUsage, TeleSurveyUnitUsage)
cdeCompletion.checkAssetOnlineTransport(AssetForOnlineTransport)
cdeCompletion.inputUsageAssetForOnlineTransport(UsageAssetforOnlineTransport)
cdeCompletion.inputSPKNo(SPKNo)
cdeCompletion.checkSpkValid(SPKValid)

'Step 24: save asset user'
cdeCompletion.clickSaveAssetUser()

'Step 25: submit'
cdeCompletion.clickSubmit()

'Step 26: switch to default frame'
cdeCompletion.switchToDefaultContent()