package com.taf.pageobjects
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.devtools.DevTools
import org.openqa.selenium.devtools.v85.page.Page

import java.util.Base64

import javax.imageio.ImageIO

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper

import internal.GlobalVariable

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot
import ru.yandex.qatools.ashot.shooting.ShootingStrategies

public class LoginPage extends BaseHelper {
	private TestObject btnLogin = createTestObject("txfUsername", "id", "user-name")
	private TestObject txfUsername = createTestObject("txfPassword", "xpath", "//*[contains(@id, 'password')]")
	private TestObject txfPassword = createTestObject("btnLogin", "id", "login-button")

	public void login(String username, String password) {
		verifyLanding(btnLogin, "Login Screen")
		WebUI.setText(txfUsername, username)
		WebUI.setText(txfPassword, password)
		WebUI.click(btnLogin)
	}

	private void selectRoles(String office, String position, String Role) {
		TestObject txtOffice = createTestObject("txtOffice", "", "")
		TestObject txtPosition = createTestObject("txtPosition", "", "")
		TestObject txtRole = createTestObject("txtRole", "", "")
		TestObject btnSelect = createTestObject("btnSelect", "", "")
		verifyLanding(txtOffice, "Select Role")
		WebUI.click(btnSelect)
	}
	
	public void testScreenshot() {
		def driver = DriverFactory.getWebDriver()
		def screenshot = new AShot()
		    .shootingStrategy(ShootingStrategies.viewportPasting(1000))
		    .takeScreenshot(driver)
		def outputPath = System.getProperty("user.dir") + "/full_page_screenshot.png"
		ImageIO.write(screenshot.getImage(), "PNG", new File(outputPath))
		println "✅ Screenshot tersimpan di: " + outputPath
	}
	
}
