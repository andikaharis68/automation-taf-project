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
import com.taf.pageobjects.customers.EmergencyContactPage
import com.taf.pageobjects.customers.JobDataPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

JobDataPage job = new JobDataPage()
EmergencyContactPage contact = new EmergencyContactPage()

if(IsEditJobData == "Y") {
	
	'Step 1: Input Profession name'
	job.selectProfessionName(ProfessionName)
	
	'Step 2: Input Profession No'
	job.inputProfessionNo(ProfessionalNo)
	
	'Step 3: Select Job Position'
	job.selectJobPosition(JobPosition)
	
	'Step 4: Select Job Status'
	job.selectJobStatus(JobStatus)
	
	'Step 5: Input Company Name'
	job.inputCompanyName(JobCompanyName)
	
	'Step 6: Check is Internal Employee'
	job.chxInternalEmployee(InternalEmployee)
	
	'Step 7: Select Industry Type Name'
	job.selectIndustryTypeName(IndustryTypeName)
	
	'Step 8 : Select Company Scale'
	job.selectCompanyScale(CompanyScale)
	
	'Step 9: Select InvestmentType'
	job.selectInvestmentType(InvestmentType)
	
	'Step 10: Input Number of employee'
	job.inputNumberOfEmployee(NumberofEmployee)
	
	'Step 11: Select Employement Establish Date'
	job.selectEmploymentEstablishDate(EmploymentEstablishmentDateMonth, EmploymentEstablishmentDateYear)
	
	'Step 12: Check is Well Known company'
	job.checkIsWellKnowCompany(IsWellKnownCompany)
	
	'Step 13: Input Previous Company'
	job.inputPrevCompanyName(PreviousCompanyName)
	
	'Step 14: Select Previous Employement date'
	job.selectPrevCompanyDate(PreviousEmployementDateMonth, PreviousEmployementDateYear)
	
	'Step 15: Select Other Company Establish date'
	job.selectOtherCompanyEstablishDate(OtherEmploymentEstablishmentDateMonth, OtherEmploymentEstablishmentDateYear)
	
	'Step 16: Input Other Bussiness Name'
	job.inputOtherBussinessName(OtherBusinessName)

	'Step 17: Input Other Bussiness Type'
	job.inputOtherBussinessType(OtherBussinessType)

	'Step 18: Select Other industry type'
	job.selectOtherIndustryType(OtherIndustryType)

	'Step 18: Input Other job position'
	job.inputOtherJobPosition(OtherJobPosition)
}

'Step 19: Click Save and Continue'
job.clickSaveContinue()

'Step 20 : Verify Landing in emergency contact'
contact.verifyLandingEmergencyContactPage()
