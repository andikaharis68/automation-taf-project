import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.taf.pageobjects.losCreditProcess.NewApplicationPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

NewApplicationPage cust = new NewApplicationPage()

'Step 1: get text of application number'
ApplicationNo = cust.getAppNo()
cust.saveApplicationNo(ApplicationNo, ExcelName, GlobalVariable.SCENARIO_ID)

'Step 2: switch iframe'
cust.switchFrameForm()

'Step 3: input customer data'
cust.inputCustomerData(CustomerType, CustomerName)

'Step 4: click save and continue'
cust.clickSaveAndContinue()