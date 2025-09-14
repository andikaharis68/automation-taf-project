package com.taf.helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.OPTIONAL
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
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.WebDriver

import static org.openqa.selenium.PageLoadStrategy.NONE

import java.awt.Robot
import java.awt.event.KeyEvent
import java.security.SecureRandom

import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.openqa.selenium.Alert
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.PageLoadStrategy

import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class BaseHelper {
	static TestObject createTestObject(String objName, String property, String value) {
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

	static Map getTestDataMultipleSheet(List<String> sheetNames, String filePath, String scenarioId) {
		Map scenarioData = [:]
		sheetNames.each { sheetName ->
			scenarioData += BaseHelper.getTestDataByScenario(sheetName, filePath, scenarioId)
		}
		return scenarioData
	}

	static String getTestDataName() {
		String testDataName
		String configName = RunConfiguration.getExecutionSourceId()
		if(configName.contains("NAP")) {
			if(configName.contains("Multi_Aset")) {
				testDataName = "LOS_New_Application_Retail_MultiAset.xlsx"
			} else if (configName.contains("Used_Car")) {
				testDataName = "LOS_New_Application_ExtensedUsedCar.xlsx"
			} else if (configName.contains("Non_Top_Up")) {
				testDataName = "LOS_New_Application_Siapdana_NonTopUp.xlsx"
			} else {
				testDataName = "LOS_New_Application_Siapdana_TopUp.xlsx"
			}
		} else {
			testDataName = "LOS_Process_Credit_Simulation_TestData.xlsx"
		}
		return testDataName
	}
	
	static String getTestDataNameCollection() {
		String testDataName
		String configName = RunConfiguration.getExecutionSourceId()
		if(configName.contains("Non_Advance")) {
			testDataName = "Collection_Expense_Non_Advance.xlsx"
		} else {
			testDataName = "Collection_Expense_Advance.xlsx"
		}
		WebUI.comment("Using test data : " + testDataName)
		return testDataName
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
		WebUI.setText(to, text)
	}

	static void safetyClick(TestObject to, double delay = 1) {
		handlePopupAlert()
		TestObject loadingBar = new TestObject("loadingBar")
		loadingBar.addProperty("id", ConditionType.CONTAINS, "ucLoadingPanel_upProgress")
		WebUI.waitForElementPresent(to, 10, FailureHandling.OPTIONAL)
		WebUI.click(to)
		WebUI.delay(delay)
		WebUI.waitForElementNotVisible(loadingBar, 10, FailureHandling.OPTIONAL)
	}
	
	static void safetyClickYudho(TestObject to, double delay = 1) {
		TestObject loadingBar = new TestObject("loadingBar")
		loadingBar.addProperty("id", ConditionType.CONTAINS, "ucLoadingPanel_upProgress")
		WebUI.waitForElementPresent(to, 10, FailureHandling.OPTIONAL)
		WebUI.click(to)
		WebUI.delay(delay)
		handleAlertIfPresent()
		if(WebUI.waitForElementVisible(to, 3,FailureHandling.OPTIONAL)) {
			WebUI.click(to)
		}
		WebUI.waitForElementNotVisible(loadingBar, 10, FailureHandling.OPTIONAL)
	}

	static void safetySelect(TestObject to, String text, double delay = 1) {
		handlePopupAlert()
		WebUI.selectOptionByLabel(to, text, false)
		WebUI.delay(delay)
	}

	static void safetyInputEdit(TestObject to, String text, double delay = 0.1) {
		if(text) {
			WebUI.delay(delay)
			WebUI.clearText(to)
			handlePopupAlert()
			WebUI.delay(delay)
			for (char c : text.toCharArray()) {
				WebUI.sendKeys(to, String.valueOf(c))
				WebUI.delay(delay)
			}
		}
	}

	static void slowlyInput(TestObject to, String text, double delay = 0.1) {
		if(text) {
			WebUI.delay(delay)
			handlePopupAlert()
			WebUI.waitForElementPresent(to, 5)
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
			WebUI.click(to)
			handlePopupAlert()
			WebUI.selectOptionByLabel(to, text, false)
			WebUI.delay(delay)
		}
	}

	static void clickEnter(TestObject to) {
		WebUI.sendKeys(to, Keys.chord(Keys.ENTER))
	}

	static void clickKeyboardEnter() {
		Robot robot = new Robot()
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
	}

	static void clickTABKeyboard(TestObject to) {
		WebUI.sendKeys(to, Keys.chord(Keys.TAB))
	}

	static void manualClearText(TestObject to, double delay = 0.5) {
		safetyClick(to)
		WebUI.sendKeys(to, Keys.chord(Keys.CONTROL, 'a'))
		WebUI.delay(delay)
		WebUI.sendKeys(to, Keys.chord(Keys.DELETE))
		WebUI.delay(delay)
	}

	static String generateRandomNpwp() {
		Random rand = new Random()
		String firstDigit = (1 + rand.nextInt(9)).toString()
		String otherDigits = (1..15).collect { rand.nextInt(10) }.join()
		return firstDigit + otherDigits
	}

	static String generateRandomNik() {
		SecureRandom rnd = new SecureRandom()
		StringBuilder nik = new StringBuilder()
		(1..16).each {
			nik.append(rnd.nextInt(10)) // random digit 0-9
		}
		return nik.toString()
	}
	
	static String generateRandomNumber(int lenght) {
		SecureRandom rnd = new SecureRandom()
		StringBuilder num = new StringBuilder()
		(1..lenght).each {
			num.append(rnd.nextInt(10)) // random digit 0-9
		}
		return num.toString()
	}

	static String generateRandomName() {
		SecureRandom rnd = new SecureRandom()
		List<String> firstNames = [
			"Andi",
			"Budi",
			"Citra",
			"Dewi",
			"Eka",
			"Fajar",
			"Gita",
			"Hadi",
			"Indra",
			"Joko"
		]
		List<String> lastNames = [
			"Santoso",
			"Wijaya",
			"Saputra",
			"Sari",
			"Putri",
			"Pratama",
			"Halim",
			"Setiawan",
			"Mahendra",
			"Utami"
		]
		String first = firstNames[rnd.nextInt(firstNames.size())]
		String last = lastNames[rnd.nextInt(lastNames.size())]
		return "$first $last"
	}

	static String generateRandomPhone(boolean isStrip = false) {
		SecureRandom rnd = new SecureRandom()
		def prefixes = [
			"812",
			"813",
			"821",
			"822",
			"823",
			"852",
			"853",
			"856",
			"857"
		]
		String prefix = prefixes[rnd.nextInt(prefixes.size())]
		String number = (1..5).collect { rnd.nextInt(10) }.join("")
		String suffix = (1..3).collect { rnd.nextInt(10) }.join("")
		if(isStrip) {
			return "${prefix}-${number}-${suffix}"
		} else {
			return prefix + number + suffix
		}
	}

	def scrollDownUntillElementVisible(TestObject to, int maxScroll=10, int step=500) {
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()

		for(int i=0; i<maxScroll; i++) {
			KeywordUtil.logInfo("index $i")
			if(WebUI.verifyElementVisible(to, FailureHandling.OPTIONAL)) {
				KeywordUtil.logInfo("Element found after scroll ${i}")
				return true
			}
			js.executeScript("window.scrollBy(0,"+ step + ")")
		}
	}

	def switchToNewTab() {
		int currentTab = WebUI.getWindowIndex()
		WebUI.switchToWindowIndex(currentTab + 1)
	}

	static void pageDown(int times) {
		Robot robot = new Robot()
		times.times {
			robot.keyPress(KeyEvent.VK_PAGE_DOWN)
		}
	}

	static List readExcelFile(String xlsLoc, String sheetName, int colNameRowIdx = 0, int dataRowIdx = 1) {
		def rows = []

		FileInputStream fis
		XSSFWorkbook workbook
		XSSFSheet worksheet

		try {
			File xlsFile = new File(xlsLoc)
			if(!xlsFile.exists()) {
				println("Target file is not found in following path: " + xlsFile.canonicalPath)
				WebUI.comment("Target file is not found in following path: " + xlsFile.canonicalPath)
			}
			fis = new FileInputStream(xlsFile)
			workbook  = new XSSFWorkbook(fis);
			worksheet = workbook.getSheet(sheetName.substring(0, Math.min(sheetName.length(), 31))) // safeguard if supplied sheet name > 31 char

			//List out all the columns
			XSSFRow columnRow = worksheet.getRow(colNameRowIdx)
			int colIndex = 0
			def columns = []
			while(columnRow.getCell(colIndex)) {
				XSSFCell columnCell = columnRow.getCell(colIndex)
				columns[colIndex] = columnCell.toString()
				colIndex++
			}

			//loop the rows
			while(worksheet.getRow(dataRowIdx)) {
				XSSFRow dataRow = worksheet.getRow(dataRowIdx)
				def data = [:]

				for(int i = 0; i < colIndex; i++) {
					XSSFCell dataCell = dataRow.getCell(i)
					String cellValue = dataCell.toString()
					if(cellValue.trim().endsWith(".0")) {
						cellValue = cellValue.trim().substring(0, cellValue.length() - 2)
					}
					data[columns[i]] = cellValue
				}
				println("Rows content: $data")
				rows.add(data)

				dataRowIdx++
			}
		}
		catch (Exception ex) {
			println("ERROR: " + ex.message)
		}
		finally {
			if(workbook) workbook.close()
			if(fis) fis.close()

			println("Excel load completed!")
		}

		//return list of rows. Each item is a map of colName: value for that row.
		return rows
	}

	static int getExcelRowNumber(String xlsLoc, String sheetName, Map criteria, int dataRowIdx = 1) {
		List xlsContent = readExcelFile(xlsLoc, sheetName)
		int rowNum = -1

		for(int i = 0; i < xlsContent.size(); i++) {
			boolean matchCriteria = true
			criteria.each { key, value ->
				println("Finding $key: $value in " + xlsContent[i] + " --> " + xlsContent[i][key])
				if(xlsContent[i][key] != value) {
					matchCriteria = false
				}
			}
			if(matchCriteria) {
				rowNum = i
				break
			}
		}
		return rowNum + dataRowIdx
	}

	static int getExcelColumnIndex(String xlsLoc, String sheetName, String columnName, int colNameRowIdx = 0) {
		int targetColIndex = -1

		FileInputStream fis
		XSSFWorkbook workbook
		XSSFSheet worksheet

		try {
			File xlsFile = new File(xlsLoc)
			if(!xlsFile.exists()) {
				println("Target file is not found in following path: " + xlsFile.canonicalPath)
				WebUI.comment("Target file is not found in following path: " + xlsFile.canonicalPath)
			}
			fis = new FileInputStream(xlsFile)
			workbook  = new XSSFWorkbook(fis);
			worksheet = workbook.getSheet(sheetName.substring(0, Math.min(sheetName.length(), 31))) // safeguard if supplied sheet name > 31 char

			//List out all the columns
			XSSFRow columnRow = worksheet.getRow(colNameRowIdx)
			int colIndex = 0
			while(columnRow.getCell(colIndex)) {
				XSSFCell columnCell = columnRow.getCell(colIndex)
				if(columnCell.toString().equalsIgnoreCase(columnName)) {
					targetColIndex = colIndex
					break
				}
				colIndex++
			}
		}
		catch (Exception ex) {
			println("ERROR: " + ex.message)
		}
		finally {
			if(workbook) workbook.close()
			if(fis) fis.close()

			println("Excel load completed!")
		}

		return targetColIndex
	}

	public static void updateExcelCellValue(String xlsLoc, String sheetName, int colNumber, int rowNumber, String val) {
		FileInputStream fis
		FileOutputStream fos
		XSSFWorkbook workbook
		XSSFSheet worksheet

		try {
			File xlsFile = new File(xlsLoc)
			if(!xlsFile.exists()) {
				println("Target file is not found in following path: " + xlsFile.canonicalPath)
				WebUI.comment("Target file is not found in following path: " + xlsFile.canonicalPath)
			}

			if (!xlsFile.canWrite()) {
				println "Excel file is currently locked or opened by another program: ${xlsFile.absolutePath}"
				WebUI.comment("File is locked or not writable (possibly opened in Excel): ${xlsFile.canonicalPath}")
				return
			}


			fis = new FileInputStream(xlsFile)
			workbook  = new XSSFWorkbook(fis)
			worksheet = workbook.getSheet(sheetName.substring(0, Math.min(sheetName.length(), 31))) // safeguard if supplied sheet name > 31 char

			//Retrieve the row and check for null
			XSSFRow sheetrow = worksheet.getRow(rowNumber);
			if(sheetrow == null){
				sheetrow = worksheet.createRow(rowNumber);
			}
			//Update the value of cell
			XSSFCell cell = sheetrow.getCell(colNumber);
			if(cell == null){
				cell = sheetrow.createCell(colNumber);
			}
			cell.setCellValue(val);

			fos = new FileOutputStream(new File(xlsLoc));
			workbook.write(fos);
			fos.close();
		}
		catch (Exception ex) {
			println("ERROR: " + ex.message)
			ex.printStackTrace()

			// Fail the test explicitly
			KeywordUtil.markFailed("Excel update failed: " + ex.message)
		}
		finally {
			if(fis) fis.close()
			if(fos) fos.close()
			KeywordUtil.markPassed("Excel Updated!!")
			println("Excel updated!")
		}
	}

	public static String saveDataToExcel(String newValue, Map rowFilter, String dataFilePath, String sheetName, String columnName) {
		KeywordUtil.logInfo("newValue: $newValue")
		int columnIndex = getExcelColumnIndex(dataFilePath, sheetName, columnName)
		int rowIndex = getExcelRowNumber(dataFilePath, sheetName, rowFilter)
		updateExcelCellValue(dataFilePath, sheetName, columnIndex, rowIndex, newValue)
	}
	def boolean checkElementIsInteractable(TestObject to) {
		String isClickable = WebUI.verifyElementClickable(to, FailureHandling.OPTIONAL)
		KeywordUtil.logInfo("isClickable: $isClickable")

		return isClickable
	}
	def String getNumberFromString(TestObject to) {
		String str = WebUI.getText(to)
		def matcher = (str =~ /\d+/)
		if(matcher.find()) {
			return matcher.group(0)
		}
		return ""
	}
	/**
	 * if option disabled return true
	 */
	def boolean checkOptionDisabled(TestObject to) {
		String strDisabled = WebUI.getAttribute(to, "disabled")
		KeywordUtil.logInfo("disabled: $strDisabled")
		boolean isDisabled = strDisabled.toBoolean()
		return isDisabled
	}

	def void selectFirstOption(TestObject dropdown, String name) {
		WebElement element = WebUI.findWebElement(dropdown)
		List<WebElement> options = element.findElements(By.tagName("option"))
		if (options != null && options.size() > 1) {
			String firstLabel = options.get(1).getText()
			safetySelect(dropdown, firstLabel)
			KeywordUtil.logInfo("Label '$name' not found. Selected first option: $firstLabel")
		} else {
			KeywordUtil.markWarning("No selectable options available in dropdown")
		}
	}

	static boolean retrySearchCustomer(String name, TestObject textField, TestObject btnSearch, TestObject btnEdit) {
		int maxAttempts = GlobalVariable.COUNTER
		int waitTime = GlobalVariable.WAIT

		for (int attempt = 1; attempt <= maxAttempts; attempt++) {
			WebUI.comment("Attempt ${attempt} of ${maxAttempts} — Searching for customer: '${name}'")
			// Input customer name
			safetyInput(textField, name)
			// Click search
			safetyClick(btnSearch)
			WebUI.delay(2)
			boolean isCustomerFound = WebUI.verifyTextPresent(name, false,OPTIONAL)

			if (isCustomerFound) {
				WebUI.comment("Customer '${name}' is visible on the page.")
				WebUI.takeScreenshot()
				// Wait for Edit button (pencil icon) to appear
				if (WebUI.waitForElementPresent(btnEdit, 3, OPTIONAL)) {
					WebUI.delay(1)
					WebUI.comment("edit button found for customer '${name}', clicking Edit.")
					safetyClick(btnEdit)
					break
				} else {
					WebUI.comment("Customer found but Edit button not yet present.")
				}
			}
			WebUI.delay(waitTime)
		}
	}

	static Map waitForStep(Map dataRow, Closure navigateTestCase, Closure checkTestCase) {
		int maxAttempts = GlobalVariable.COUNTER
		int waitTime = GlobalVariable.WAIT

		while (!dataRow['StepCheck'] && dataRow['Counter'] < maxAttempts) {
			WebUI.comment("Attempt ${dataRow['Counter'] + 1} of ${maxAttempts} — Checking current step...")

			navigateTestCase.call(dataRow)
			checkTestCase.call(dataRow)

			dataRow['Counter'] += 1
			WebUI.comment("Step Check result: ${dataRow['StepCheck']}")

			if (dataRow['StepCheck']) {
				WebUI.comment("Target step '${dataRow['StepApplication']}' reached.")
				break
			}

			WebUI.delay(waitTime)
		}

		return dataRow
	}

	static void validateStepReached(Map dataRow, Closure infoTestCase) {
		infoTestCase.call(dataRow)
		if (!dataRow['StepCheck']) {
			KeywordUtil.markFailedAndStop("Step not reached: Expected '${dataRow['StepApplication']}'")
		} else {
			KeywordUtil.logInfo("Step successfully reached: '${dataRow['StepApplication']}'")
		}
	}
	static List<String> getAllErrorFields() {
		TestObject errorSpans = createTestObject("errorSpan", "xpath", "//span[contains(text(), 'This field is required') and not(contains(@style,'display:none'))]")
		List<WebElement> errorElements = WebUI.findWebElements(errorSpans, 5)
		List<String> errorFieldIds = []

		for (WebElement errorElement : errorElements) {
			String spanId = errorElement.getAttribute("id")
			String fieldId = spanId.replace("rfv", "txt")
			errorFieldIds.add(fieldId)
			WebUI.scrollToElement(errorSpans, 0)
			KeywordUtil.markError("❗ Error detected at field: ${fieldId}")
		}
		return errorFieldIds
	}
	def void pressEsc(TestObject to) {
		WebUI.sendKeys(to, Keys.chord(Keys.ESCAPE))
	}
}