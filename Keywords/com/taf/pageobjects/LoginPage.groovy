package com.taf.pageobjects
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.assertj.core.api.InstanceOfAssertFactories.OPTIONAL

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

public class LoginPage extends BaseHelper {

	private TestObject txfUsername	= createTestObject("txfUsername", "xpath", "//input[@id='txtUsername']")
	private TestObject txfPassword	= createTestObject("txfPassword", "xpath", "//input[@id='txtPassword']")
	private TestObject btnLogin		= createTestObject("btnLogin", "xpath", "//input[@id='lbLogin']")
	private TestObject txtOffice 	= createTestObject("txtOffice", "", "//th[normalize-space(text())= 'OFFICE')")
	private TestObject txtPosition	= createTestObject("txtPosition", "", "")
	private TestObject txtRole 		= createTestObject("txtRole", "", "")
	private TestObject btnSelect 	= createTestObject("btnSelect", "", "")
	private TestObject lblRoles		= createTestObject("lblRoles", "xpath", "//*[contains(text(), 'Select your roles') and not(ancestor::*[contains(@class, 'overlay') and contains(@style, 'visibility: hidden')])]")
	private TestObject btnLogout	= createTestObject("btnLogout", "id", "navLogout")
	private TestObject btnLastSelect= createTestObject("btnLastSelect", "xpath", "(//*[contains(@id, 'uModDRole_ctl00_gvRoles_lbSelectRole')])[last()]")



	public void login(String username, String password) {
		verifyLanding(btnLogin, "Login")
		WebUI.setText(txfUsername, username)
		WebUI.setText(txfPassword, password)
		WebUI.takeFullPageScreenshot()
		WebUI.click(btnLogin)
	}

	private void selectRoles(String office, String position, String role, String username) {
		if(!username.equalsIgnoreCase("NON1002") || !username.equalsIgnoreCase("JUD0037")) {
			if(!WebUI.waitForElementVisible(btnLogout, 5, FailureHandling.OPTIONAL)) {
				TestObject dynamicSelectButton
				String lower = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
				String upper = 'abcdefghijklmnopqrstuvwxyz'
	
				String xpath = """
        //tr[
            contains(translate(normalize-space(.), '${lower}', '${upper}'), '${office.toLowerCase()}')
            and contains(translate(normalize-space(.), '${lower}', '${upper}'), '${position.toLowerCase()}')
            and contains(translate(normalize-space(.), '${lower}', '${upper}'), '${role.toLowerCase()}')
        ]//a[contains(translate(normalize-space(.), '${lower}', '${upper}'), 'select')]
    """
				dynamicSelectButton = createTestObject("dynamicSelectButton", "xpath", xpath)
				WebUI.click(dynamicSelectButton)
			} else {
				KeywordUtil.logInfo("No need select roles")
			}
		}
		
	}
	private void selectRolesCreditApproval(String office, String position, String role) {
		if(!WebUI.waitForElementPresent(btnLogout, 10, FailureHandling.OPTIONAL)) {
			TestObject dynamicSelectButton
			String lower = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
			String upper = 'abcdefghijklmnopqrstuvwxyz'

			String xpath = """
        //tr[
            contains(translate(normalize-space(.), '${lower}', '${upper}'), '${office.toLowerCase()}')
            and contains(translate(normalize-space(.), '${lower}', '${upper}'), '${position.toLowerCase()}')
            and contains(translate(normalize-space(.), '${lower}', '${upper}'), '${role.toLowerCase()}')
        ]//a[contains(translate(normalize-space(.), '${lower}', '${upper}'), 'select')]
    """

			dynamicSelectButton = createTestObject("dynamicSelectButton", "xpath", xpath)
			if(!WebUI.verifyElementPresent(dynamicSelectButton, 5, FailureHandling.OPTIONAL)) {
				safetyClick(btnLastSelect)
			} else {
				WebUI.click(dynamicSelectButton)
			}
		} else {
			KeywordUtil.logInfo("No need select roles")
		}
	}
}
