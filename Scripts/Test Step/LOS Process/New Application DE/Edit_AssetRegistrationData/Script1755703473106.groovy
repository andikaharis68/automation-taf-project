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
import com.taf.pageobjects.losCreditProcess.AssetDataPage
import com.taf.pageobjects.losCreditProcess.InsuranceDataPage

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

AssetDataPage asset = new AssetDataPage()
MenuPage menu = new MenuPage()
InsuranceDataPage insurance = new InsuranceDataPage()

'Step 1: Click Edit Asset Registartion'
asset.clickEditAssetRegistration()

'Step 2: Input Username'
asset.inputUserName(Username)

'Step 3: Input Customer Relationship'
asset.selectUserRelationship(UserRelationship)

'Step 4: Input Owner name'
asset.inputOwnerName(OwnerName)

'Step 5: Select Owner Id type'
asset.selectIdType(OwnerIdType)

'Step 6: Input owner Id no'
asset.inputOwnerIdNo(OwnerIdNo)

'Step 8: Select owner relationship'
asset.selectOwnerRelationship(OwnerRelationship)

'Step 7: Copy Address Asset Owner'
asset.selectAndCopyAddressOwner(AssetOwnerCopyFrom)

'Step 8: Input Notes'
asset.inputNotes(Notes)

'Step 9: Copy Address Asset Location'
asset.selectAndCopyAddressLocation(AssetLocationCopyAddress)

'Step 10: Clik Save'
asset.clickSave()

'Step 11: Verify Notif Success'
menu.verifySuccessMessage()

'Step 12: Click Edit asset data'
asset.clickEditAssetData()

'Step 13: Search Branch Name'
asset.searchSupplierBranchName(SupplierBranchName)

'Step 14: Input Sales Person name'
asset.selectSalesPersonName(SalesPersonName)

'Step 15: Search Asset Name'
asset.searchAssetName(AssetName)

'Step 16: Input Asset Price'
asset.inputAssetPrice(AssetPrice)

'Step 17: Input down payment'
asset.inputDownPayment(DownPayment)

'Step 18: Select Asset usage'
asset.selectAssetUsage(AssetUsage)

'Step 19: Input Manufacturing year'
asset.inputManufacturingYear(ManufacturingYear)

'Step 20: Click Add additional branch'
asset.clickAdd()

'Step 21: Search Additional branch'
asset.searchAdditionalBranchName(AdditionalSvcSupplierBranchName)

'Step 22: Search accessory name'
asset.searcAccName(AdditionalSvcName)

'Step 23: Click Save'
asset.clickSave()

'Step 24: verify notif success'
menu.verifySuccessMessage()

'Step 25: Click save and continue'
asset.clickSaveContinue()

'Step 26: Verify landing insurance data'
insurance.verifyLandingInInsuranceData()





