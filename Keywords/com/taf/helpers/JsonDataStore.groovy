package com.taf.helpers

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import internal.GlobalVariable

public class JsonDataStore {
	
	static String getFilePath() {
		return RunConfiguration.getProjectDir() + "/Data Files/Resources/JsonDataStore.json"
	}

	static Map readData() {
		File file = new File(getFilePath())
		if (!file.exists()) {
			file.parentFile.mkdirs()
			file.text = "{}"   
		}
		return new JsonSlurper().parseText(file.text) as Map
	}

	static void writeData(Map data) {
		File file = new File(getFilePath())
		file.text = JsonOutput.prettyPrint(JsonOutput.toJson(data))
	}

	static void setValue(String key, def value) {
		Map data = readData()
		data[key] = value
		writeData(data)
	}

	static def getValue(String key) {
		Map data = readData()
		return data[key]
	}
}
