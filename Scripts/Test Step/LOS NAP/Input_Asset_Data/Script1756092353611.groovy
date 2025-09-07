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
import com.taf.pageobjects.losCreditProcess.NewApplicationPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

NewApplicationPage asset = new NewApplicationPage()

'Step 1: click add asset'
asset.clickAddAsset()

'Step 2: select supplier branch name'
asset.inputSupplierInfo(SupplierBranchName)

'Step 3: select top up agreement'
asset.topUpAgreemnt(TopUpAgreementNo)

'Step 4: input asset price'
asset.inputMainAsset(DPType, AssetPrice, DownPayment)

'Step 5: input asset data'
asset.selectAsetUsage(AssetUsage)

'Step 6: calculate market price'
asset.clickGetMarketPrice()

'Step 7: add additional service grid'
asset.addGrid(AssetServiceName, SupplierBranchNameGrid, ServicePrice)

'Step 8: save asset'
asset.clickSaveAsset()