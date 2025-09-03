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
import com.taf.pageobjects.losCreditProcess.CentralizeDataEntry

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

CentralizeDataEntry cde = new CentralizeDataEntry()

'Step 1: switch iframe'
cde.switchToMainPage()

'Step 2: search by customer name'
cde.searchCustomerName(CustomerName)

int counter = 0
Boolean isFound = false
while(!isFound && (GlobalVariable.COUNTER > counter)) {
	
	'Step 2: search by customer name'
	cde.searchCustomerName(CustomerName)
	
	isFound = cde.checkIsSearchResultFound()
	if (!isFound) {
		cde.delay()
	}
	counter++
}

if(!isFound) {
	KeywordUtil.markFailedAndStop("Customer Name Not Found, it could be not on step CDE Completion")
}else {
	'Step 3: select from prospect list'
	cde.selectProspect()
}




