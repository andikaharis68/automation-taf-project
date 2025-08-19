package com.taf.helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.SelectorMethod

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeOptions
import org.openqa.selenium.WebDriver

import static org.openqa.selenium.PageLoadStrategy.NONE

import java.awt.Robot
import java.awt.event.KeyEvent

import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.PageLoadStrategy

import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class BaseHelper {
	public TestObject createTestObject(String objName, String property, String value) {
		/*
		 * property: xpath, id, text etc
		 * value : based on what property used, if u use xpath => "//*[text() = 'Login']", if u use id just write only id
		 */
		TestObject to = new TestObject(objName)
		if (property == "text") {
			value = "//*[text() = '$value']"
			to.addProperty("xpath", ConditionType.CONTAINS, value)
		}else {

			to.addProperty(property, ConditionType.CONTAINS, value)
		}

		return to
	}

	public String getXpath(TestObject to) {
		def prop = to.getProperties().find()

		if (prop == null) {
			return null
		}

		String name = prop.getName().toLowerCase()
		String value = prop.getValue()

		return (name == "xpath") ? value : "//*[contains(@${name}, '${value}')]"

		//		24 Jul 2025 : ini sengaja dikomen soalnya pake return yg atas belum pernah dicoba, kalo aman nanti ini di hapus aja ya!!
		//		switch (name) {
		//			case "xpath":
		//				return value // already a valid xpath
		//			case "id":
		//				return "//*[contains(@id, '${value}')]"
		//			case "class":
		//				return "//*[contains(@class, '${value}')]"
		//			case "text":
		//				return "//*[contains(text(), '${value}')]"
		//			case "name":
		//				return "//*[contains(@name, '${value}')]"
		//			default:
		//			// fallback to generic contains
		//				return "//*[contains(@${name}, '${value}')]"
		//		}
	}

	public List<WebElement> getListElementByTestObject(TestObject to) {
		def driver = DriverFactory.getWebDriver()

		// Extract selector method & value
		String xpath = null
		def prop = to.getProperties().find { it.getName().equalsIgnoreCase("xpath") }

		if (prop) {
			xpath = prop.getValue()
		} else {
			// If not using xpath, convert other properties into xpath
			xpath = getXpath(to)
		}

		// Return list of WebElements matching the XPath
		return driver.findElements(By.xpath(xpath))
	}

	public List<WebElement> getListElementByTestObject(String xpath) {
		def driver = DriverFactory.getWebDriver()
		return driver.findElements(By.xpath(xpath))
	}

	static void openBrowser() {
//		EdgeOptions options = new EdgeOptions()
//		options.setPageLoadStrategy(PageLoadStrategy.NONE)
//		WebDriver driver = new EdgeDriver(options)
//		DriverFactory.changeWebDriver(driver)
//		driver.get(GlobalVariable.WEB_URL)

		WebUI.openBrowser(GlobalVariable.WEB_URL)
		WebUI.maximizeWindow()
	}
			
	static void verifyLanding(TestObject to, String screenName) {
		if (WebUI.waitForElementPresent(to, 10)) {
			KeywordUtil.markPassed("Success : Landing to $screenName")
		}else {
			KeywordUtil.markFailed("Failed : Landing to $screenName")
		}
	}


	static Map<String, String> getTestDataByScenario(String sheetName, String filePath, String scenarioID) {
		FileInputStream fis = new FileInputStream(filePath)
		Workbook workbook = new XSSFWorkbook(fis)
		Sheet sheet = workbook.getSheet(sheetName)

		Map<String, String> dataMap = [:]

		int headerRow = 0
		int scenarioColumn = -1

		// Get Header Row
		Row header = sheet.getRow(headerRow)
		for (int i = 0; i < header.getLastCellNum(); i++) {
			if (header.getCell(i).getStringCellValue() == "ScenarioId") {
				scenarioColumn = i
				break
			}
		}

		if (scenarioColumn == -1) {
			KeywordUtil.markFailed("Column 'ScenarioId' not found")
			return null
		}

		// Loop through rows
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i)
			if (row.getCell(scenarioColumn)?.getStringCellValue() == scenarioID) {
				KeywordUtil.markPassed("Scenario Found: ${scenarioID}")
				for (int j = 0; j < header.getLastCellNum(); j++) {
					String key = header.getCell(j).getStringCellValue()
					String value = row.getCell(j)?.getStringCellValue()
					dataMap[key] = value
				}
				break
			}
		}

		if (dataMap.isEmpty()) {
			KeywordUtil.markFailed("No Data Found for Scenario ID: ${scenarioID}")
			return null
		}

		KeywordUtil.logInfo("Scenario Data: ${dataMap}")

		GlobalVariable.TEST_DATA = dataMap
		return dataMap
	}

	static void validateIsEquals(String actual, String expected) {
		if (actual.equalsIgnoreCase(expected)) {
			KeywordUtil.markPassed("Actual : $actual, is equals with Expected : $expected")
		}else {
			KeywordUtil.markFailed("Actual : $actual, is not equals with Expected : $expected")
		}
	}

	static void verifyPopUpSuccess(TestObject to, String actionTitle) {
		if(WebUI.waitForElementPresent(to, 5)) {
			KeywordUtil.markPassed("Success: $actionTitle Success!")
		}else {
			KeywordUtil.markFailed("Failed: $actionTitle Failed/Object lblSuccess Not Found!")
		}
	}

	static Sheet openSheetNameByFilePath(String sheetName, String filePath) {
		FileInputStream fis = new FileInputStream(filePath)
		Workbook workbook = new XSSFWorkbook(fis)
		return workbook.getSheet(sheetName)
	}

	static List<Map<String, String>> getTestDataMultipleByScenario(String sheetName, String filePath, String scenarioID) {

		Sheet openedSheet = openSheetNameByFilePath(sheetName, filePath);

		List<Map<String,String>> scenarioDataMultiple = new ArrayList<>();

		int headerRow = 0
		int scenarioColumn = -1

		// Get Header Row
		Row header = openedSheet.getRow(headerRow)
		for (int i = 0; i < header.getLastCellNum(); i++) {
			if (header.getCell(i).getStringCellValue() == "ScenarioId") {
				scenarioColumn = i
				break
			}
		}

		if (scenarioColumn == -1) {
			KeywordUtil.markFailed("Column 'ScenarioId' not found")
			return null
		}

		// Loop through rows
		for (int i = 1; i <= openedSheet.getLastRowNum(); i++) {
			Row row = openedSheet.getRow(i)
			if (row.getCell(scenarioColumn)?.getStringCellValue() == scenarioID) {
				Map<String, String> dataMap = [:]
				KeywordUtil.markPassed("Scenario Found: ${scenarioID}")
				for (int j = 0; j < header.getLastCellNum(); j++) {
					String key = header.getCell(j).getStringCellValue()
					String value = row.getCell(j)?.getStringCellValue()
					dataMap[key] = value
				}
				KeywordUtil.logInfo("Scenario Data: ${dataMap} for scenarioId : ${scenarioID}")
				scenarioDataMultiple.add(dataMap)
			}
		}

		if (scenarioDataMultiple.isEmpty()) {
			KeywordUtil.markFailed("No Data Found for Scenario ID: ${scenarioID}")
			return null
		}


		GlobalVariable.MULTIPLE_TEST_DATA = scenarioDataMultiple
		return scenarioDataMultiple
	}



	static Map<String, String> getTestDataByScenarioAndAddressType(
			String sheetName,
			String filePath,
			String scenarioID,
			String addressTypeName) {

		FileInputStream fis
		Workbook workbook
		try {
			fis = new FileInputStream(filePath)
			workbook = new XSSFWorkbook(fis)
			Sheet sheet = workbook.getSheet(sheetName)

			if (sheet == null) {
				KeywordUtil.markFailed("Sheet '${sheetName}' not found ${filePath}")
				return null
			}

			int headerRowIdx = 0
			Row header = sheet.getRow(headerRowIdx)

			int scenarioColIdx   = indexOfColumn(header, "ScenarioId")
			int addressTypeColIdx = indexOfColumn(header, "AddressTypeName")

			if (scenarioColIdx == -1)   {
				KeywordUtil.markFailed("Kolom 'ScenarioId' tidak ditemukan"); return null
			}
			if (addressTypeColIdx == -1){
				KeywordUtil.markFailed("Kolom 'AddressTypeName' tidak ditemukan"); return null
			}

			DataFormatter fmt = new DataFormatter()
			Map<String, String> dataMap = [:]

			for (int r = 1; r <= sheet.getLastRowNum(); r++) {
				Row row = sheet.getRow(r)
				if (row == null) continue

					String scenVal = fmt.formatCellValue(row.getCell(scenarioColIdx)).trim()
				String addrVal = fmt.formatCellValue(row.getCell(addressTypeColIdx)).trim()

				if (scenVal.equalsIgnoreCase(scenarioID) && addrVal.equalsIgnoreCase(addressTypeName)) {
					for (int c = 0; c < header.getLastCellNum(); c++) {
						String key = header.getCell(c)?.getStringCellValue()
						String val = fmt.formatCellValue(row.getCell(c))
						if (key != null) dataMap[key] = val
					}
					KeywordUtil.markPassed("Data ditemukan untuk ScenarioId='${scenarioID}' dan AddressTypeName='${addressTypeName}'")
					break
				}
			}

			if (dataMap.isEmpty()) {
				KeywordUtil.markFailed("Tidak ada data untuk ScenarioId='${scenarioID}' dan AddressTypeName='${addressTypeName}'")
				return null
			}

			KeywordUtil.logInfo("Scenario & AddressType Data: ${dataMap}")
			GlobalVariable.TEST_DATA = dataMap
			return dataMap
		} finally {
			try {
				workbook?.close()
			} catch (ignored) {}
			try {
				fis?.close()
			} catch (ignored) {}
		}
	}

	private static int indexOfColumn(Row header, String targetName) {
		for (int i = 0; i < header.getLastCellNum(); i++) {
			String name = header.getCell(i)?.getStringCellValue()?.trim()
			if (name != null && name.equalsIgnoreCase(targetName)) return i
		}
		return -1
	}

	static void closeBrowser() {
		WebUI.closeBrowser()
	}
	static void handleAlertIfPresent() {
		if(WebUI.waitForAlert(8)) {
			WebUI.acceptAlert()
		} else {
			KeywordUtil.logInfo("Alert not found")
		}
	}

	static void clearAndSetText(TestObject to, String text, double delay = 0.1) {
		WebUI.waitForElementVisible(to, 10)
		WebUI.click(to)
		WebUI.sendKeys(to, Keys.chord(Keys.CONTROL, "a"))
		WebUI.sendKeys(to, Keys.chord(Keys.DELETE))
		WebUI.setText(to, text)
	}

	static void safetyInput(TestObject to, String text, double delay = 0.1) {
		handlePopupAlert()
		WebUI.delay(delay)
		WebUI.clearText(to)
		WebUI.setText(to, text)
	}

	static void safetyClick(TestObject to, double delay = 1) {
		handlePopupAlert()
		TestObject loadingBar = new TestObject("loadingBar")
		loadingBar.addProperty("id", ConditionType.CONTAINS, "ucLoadingPanel_upProgress")
		WebUI.waitForElementPresent(to, 10)
		WebUI.click(to)
		WebUI.delay(delay)
		WebUI.waitForElementNotVisible(loadingBar, 10)
	}

	static void safetySelect(TestObject to, String text, double delay = 1) {
		handlePopupAlert()
		WebUI.selectOptionByLabel(to, text, false)
		WebUI.delay(delay)
	}

	static void safetyInputEdit(TestObject to, String text, double delay = 0.1) {
		handlePopupAlert()
		if(text) {
			WebUI.delay(delay)
			WebUI.clearText(to)
			WebUI.delay(delay)
			for (char c : text.toCharArray()) {
				WebUI.sendKeys(to, String.valueOf(c))
				WebUI.delay(delay)
			}
		}
	}
	
	static void handlePopupAlert(int timeoutInSeconds = 1) {
		try {
			WebUI.waitForAlert(timeoutInSeconds)
			WebUI.acceptAlert()
			KeywordUtil.logInfo("✅ popup alert ditemukan dan sudah di-accept.")
		} catch (Exception e) {
			print 'alert tidak muncul'
		}
	}
	
	static void safetySelectEdit(TestObject to, String text, double delay = 1) {
		if(text) {
			WebUI.selectOptionByLabel(to, text, false)
			WebUI.delay(delay)
		}
	}
	
	static void clickEnter(TestObject to) {
		WebUI.sendKeys(to, Keys.chord(Keys.ENTER))
	}
	static void clickTABKeyboard(TestObject to) {
		WebUI.sendKeys(to, Keys.chord(Keys.TAB))
		
	}
}