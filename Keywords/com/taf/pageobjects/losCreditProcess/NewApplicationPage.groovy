package com.taf.pageobjects.losCreditProcess

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class NewApplicationPage extends BaseHelper{
	//test data 	0008APP20250600807
	
	//new application
	private TestObject lblTitle
	private TestObject txfApplicationNumber
	private TestObject btnSearch
	private TestObject btnAdd
	
	//section main information
	private TestObject btnLookUpOfferingName
	//pop up
	private TestObject txfOfferingCode
	private TestObject txfOfferingName
	private TestObject btnOfferingSearch
	private TestObject btnSelectOffering
	private TestObject txfNumOfAsset
	
	//section main info
	private TestObject lblApplicationNumber
	
	
	//section tab customer
	private TestObject rdnType //sepertinya ini dibawah ikut function
	private TestObject btnLookUpCustomerName
	//pop up
	private TestObject txfCustomerName
	private TestObject btnSearchCustomerName
	private TestObject btnSelectCustomerName
	
	
	//section tab gurantor
	private TestObject btnAddPersonalGurantor
	private TestObject btnAddCompanyGurantor
	
	
	//section application data
	private TestObject txfTenor
	private TestObject drpPaymentFrequent
	private TestObject drpMarginType
	private TestObject drpInstallamentScheme
	private TestObject rdnFirstInstallmentType //sepertinya ini dibawah ikut function
	
	//section application info
	private TestObject drpApplicationSource
	private TestObject rdnFiduciaCovered
	private TestObject drpWayOfPayment
	private TestObject rdnSelfUsage //sepertinya ini dibawah ikut function
	private TestObject drpPurposeOfUsage
	
	//section mailing address
	private TestObject drpCopyAddress
	private TestObject btnCopyAddress
	private TestObject txfAddress
	private TestObject txfRt
	private TestObject txfRw
	private TestObject btnLookUpZipCode
	//pop up
	private TestObject txfZipCode
	private TestObject btnZipCodeSearch
	private TestObject btnSelectZip
	private TestObject txfPhoneCode
	private TestObject txfPhoneNo
	private TestObject txfExt
	
	//section data restrukturisasi
	private TestObject drpCharacteristicOfCredit
	private TestObject btnLookUpEconomicSector
	//pop up
	private TestObject txfEconimicSector
	private TestObject btnEconimicSearc
	private TestObject btnSelectEconomic
	
	
	//section tab asset data
	private TestObject btnAddAsset
	
	
	
	
	//button
	private TestObject btnSaveAndContinue
	//jika memilih floating rate
	private TestObject drpFloatingPeriod
	

	
}
