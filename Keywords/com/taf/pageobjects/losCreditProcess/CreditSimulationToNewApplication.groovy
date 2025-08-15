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

public class CreditSimulationToNewApplication extends BaseHelper {
	//header
	private TestObject lblTitle = createTestObject("lblTitle", "", "")
	private TestObject btnSave = createTestObject("btnSave", "", "")
	private TestObject btnSubmit = createTestObject("btnSubmit", "", "")
	
	//main data
	private TestObject txfMobilePhone = createTestObject("txfMobilePhone", "", "")
	private TestObject txfNPWP = createTestObject("txfNPWP", "", "")
	
	//address info
	private TestObject txfJobAddress = createTestObject("txfJobAddress", "", "")
	private TestObject txfResidanceAddress = createTestObject("txfResidanceAddress", "", "")
	
	//other info
	private TestObject txfNotes = createTestObject("txfNotes", "", "")
	
	//upload document
	private TestObject btnChooseFile = createTestObject("btnChooseFile", "", "")
	private TestObject txfRemarks = createTestObject("txfRemarks", "", "")
	private TestObject btnUpload = createTestObject("btnUpload", "", "")
	
	public void verifyLandingScreen() {
		verifyLanding(lblTitle, "Credit Simulation To New Aplication")
	}
	
	public void inputMainData(String phoneNumber, npwpNo) {
		WebUI.setText(txfMobilePhone, phoneNumber)
		WebUI.setText(txfNPWP, npwpNo)
	}
	
	public void inputAddressInfo(String jobAddress, residanceAddress) {
		WebUI.setText(txfJobAddress, jobAddress)
		WebUI.setText(txfResidanceAddress, residanceAddress)
	}
	
	public void inputOtherInfo(String notes) {
		WebUI.setText(txfNotes, notes)
		
		clickSave()
	}
	
	public void uploadDocument(String remarks) {
		//harusnya ada total 3 kali upload docs
		WebUI.click(btnChooseFile)
		//mintol tambahin step choosfile nya ya mas gw belum tau
		WebUI.setText(txfRemarks, remarks)
		WebUI.click(btnUpload)
	}
	
	public void clickSave() {
		WebUI.click(btnSave)
	}
	
	public void clickSubmit() {
		WebUI.click(btnSubmit)
	}
	
	
}
