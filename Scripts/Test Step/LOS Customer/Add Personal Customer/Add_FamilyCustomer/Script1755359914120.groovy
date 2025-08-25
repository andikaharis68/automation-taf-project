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
import com.taf.pageobjects.customers.FamilyCustomerPage
import com.taf.pageobjects.customers.JobDataPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

FamilyCustomerPage family = new FamilyCustomerPage()
JobDataPage job = new JobDataPage()

'Step 1: Add Family '
family.clickAdd()

'Step 2: Select Customer Model'
family.selectCustomerModel(CustomerModel)

'Step 3: Input family name'
family.inputFamilyName(FamilyName)

'Step 4: Select id type'
family.selectIdType(IdType)

'Step 5: Input ID no'
family.inputIdNumber(IdNumber)

'Step 6: Input ID Expired Date'
family.inputIdExpiredDate(IdExpiredDate)

'Step 7: Select Gender'
family.selectGender(Gender)

'Step 8: Input POB'
family.inputPOB(BirthPlace)

'Step 9: Input DOB'
family.inputDOB(BirthDate)

'Step 10: Input NPWP'
family.inputNPWP(Npwp)

'Step 11: Input Mother Name'
family.inputMotherMaidenName(MotherMaidenName)

'Step 12: Select Customer Relationship'
family.selectCustomerRelationship(CustomerRelationship)

'Step 13: Click next '
family.clickNext()

'Step 14: Click select family'
family.clickSelectFamily()

'Step 15: click Save and continue'
family.clickSaveContinue()

'Step 16: Verify landing in job data page'
job.verifyLandingInJobDataPage()

