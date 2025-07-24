package com.taf.pageobjects.login

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

public class LoginScreen extends BaseHelper{
	
	private TestObject lblTitleLogin
	private TestObject btnLogin
	private TestObject txfUsername
	private TestObject txfPassword


	public LoginScreen() {
		lblTitleLogin	= getTestObject("lblTitleLogin", "login_logo", "class") //contoh kalo mau pake props class
		txfUsername		= getTestObject("txfUsername", "user-name", "id") //contoh kalo mau pake props id
		txfPassword		= getTestObject("txfPassword", "//*[contains(@id, 'password')]", "xpath") //contoh kalo mau pake props xpath
		btnLogin		= getTestObject("btnLogin", "login-button", "id")
	}

	public void clickLogin() {
		WebUI.click(btnLogin)
	}

	public void verifyLandingScreen() {
		verifyLanding(lblTitleLogin, "Login Screen")
	}

	public void inputUsername(String username) {
		WebUI.setText(txfUsername, username)
	}

	public void inputPassword(String password) {
		WebUI.setText(txfPassword, password)
	}

}
