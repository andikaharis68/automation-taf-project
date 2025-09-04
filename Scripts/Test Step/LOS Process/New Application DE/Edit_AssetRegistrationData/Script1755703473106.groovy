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

'Step 2: input Asset user section'
asset.inputAssetUserSection(SelfUsage, UserName, UserRelationship)

'Step 3: Input Asset owner section'
asset.inputAssetOwnerSection(OwnerName, OwnerIdType, OwnerIdNo, OwnerRelationship, AssetOwnerCopyFrom, TaxDate, AssetOwnerNotes)

'Step 4: Copy Address Asset Location'
asset.selectAndCopyAddressLocation(AssetLocationCopyAddress)

'Step 4.1: Input asset document'
asset.inputAssetDocument(BpkpDocNo, FakturDocNo)

'Step 5: Clik Save'
asset.clickSave()

'Step 6: Click Edit asset data'
asset.clickEditAssetData()

'Step 7: Input Supplier info '
asset.inputSupplierInfoSection(SupplierBranchName, SalesPersonName)

'Step 8 : input main asset section'
asset.inputMainAssetSection(AssetName, AssetPrice, DpType, DownPayment, MainAssetNotes)

'Step 9: Input Asset Data Section'
asset.inputAssetDataSection(NoMesin, NoRangka,LicensePlateNo ,AssetCondition , AssetUsage, ManufacturingYear)

'Step 10: Input asset attribute'
asset.inputAssetAttributeSection(MadeIn, Cylinder, Transmition, Color, Region)

'Step 11: Input Accessory Grid'
asset.inputAccessoriesGridSection(AdditionalSvcSupplierBranchName, AdditionalSvcName, AdditionalSvcPrice, AdditionalDpAmount, AdditionalSvcNotes)

'Step 12: Click Save Edit'
asset.clickSaveEdit()

'Step 13: Click save and continue'
asset.clickSaveContinue()

'Step 14: Verify landing insurance data'
insurance.verifyLandingInInsuranceData()
