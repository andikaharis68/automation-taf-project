package com.taf.pageobjects.customers

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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.taf.helpers.BaseHelper
import internal.GlobalVariable

public class JobDataPage extends BaseHelper {

	private TestObject btnSaveAndContinue			= createTestObject("btnSaveAndContinue", "xpath", "//*[@id='lb_Form_SaveCont_Job']")

	private TestObject txfProfessionName			= createTestObject("txfProfessionName", "xpath", "//*[@id='ucProfession_uclProf_txt']")
	private TestObject btnSearchProfessionName		= createTestObject("btnSearchProfessionName", "xpath", "//*[@id='ucProfession_uclProf_imb']")
	private TestObject txfProfessionNo				= createTestObject("txfProfessionNo", "xpath", "//*[@id='txtProfNo']")
	private TestObject drpJobPosition				= createTestObject("drpJobPosition", "xpath", "//*[@id='ucMrJobPosition_ddlReference']")
	private TestObject drpJobStatus					= createTestObject("drpJobStatus", "xpath", "//*[@id='ucMrJobStat_ddlReference']")
	private TestObject txfCompanyName				= createTestObject("txfCompanyName", "xpath", "//*[@id='txtCoyName']")
	private TestObject chxIsInternalEmployee		= createTestObject("chxIsInternalEmployee", "xpath", "//*[@id='cbIsMfEmp']")
	private TestObject txfIndustryType				= createTestObject("txfIndustryType", "xpath", "//*[@id='ucIndustry_uclIndustry_txt']")
	private TestObject btnSearchIndustryType		= createTestObject("btnSearchIndustryType", "xpath", "//*[@id='ucIndustry_uclIndustry_imb']")
	private TestObject drpCompanyScale				= createTestObject("drpCompanyScale", "xpath", "//*[@id='ucMrCoyScale_ddlReference']")
	private TestObject radInvestmentType			= createTestObject("drpInvestmentType", "xpath", "//*[@id='rblInvestmentType_0']")
	private TestObject txfNumberOfEmployee			= createTestObject("txfNumberOfEmployee", "xpath", "//*[@id='txtNoOfEmp']")
	private TestObject txfEmploymentEstablishDate	= createTestObject("txfEmploymentEstablishDate", "xpath", "//*[@id='ucEstablishmentDt_txtYear']")
	private TestObject drpEmploymentEstablishDate	= createTestObject("drpEmploymentEstablishDate", "xpath", "//*[@id='ucEstablishmentDt_ddlMonth']")
	private TestObject chxIsWellCompany				= createTestObject("chxIsWellCompany", "xpath", "//*[@id='cbIsWellKnownCoy']")
	private TestObject txfPrevCompanyName			= createTestObject("txfPrevCompanyName", "xpath", "//*[@id='txtPrevCoyName']")
	private TestObject txfPrevEmploymentDate		= createTestObject("txfPrevEmploymentDate", "xpath", "//*[@id='ucPrevEstablishmentDt_txtYear']")
	private TestObject drpPrevEmploymentDate		= createTestObject("drpPrevEmploymentDate", "xpath", "//*[@id='ucPrevEstablishmentDt_ddlMonth']")
	private TestObject txfOtherBussinessName		= createTestObject("txfOtherBussinessName", "xpath", "//*[@id='txtOthBizName']")
	private TestObject txfOtherBussinessType		= createTestObject("txfOtherBussinessType", "xpath", "//*[@id='txtOthBizType']")
	private TestObject txfOtherBussinessIndustryType= createTestObject("txfOtherBussinessIndustryType", "xpath", "//*[@id='ucOthBizIndustry_uclIndustry_txt']")
	private TestObject btnSearchOtherIndustryType	= createTestObject("btnSearchOtherIndustryType", "xpath", "//*[@id='ucOthBizIndustry_uclIndustry_imb']")
	private TestObject txfOtherJobPosition			= createTestObject("txfOtherJobPosition", "xpath", "//*[@id='txtOthBizJobPosition']")
	private TestObject txfOtherEstablishDate		= createTestObject("txfOtherEstablishDate", "xpath", "//*[@id='ucOthBizEstablishmentDt_txtYear']")
	private TestObject drpOtherEstablishDate		= createTestObject("drpOtherEstablishDate", "xpath", "//*[@id='ucOthBizEstablishmentDt_ddlMonth']")

	private TestObject txfOvlyProfessionName 		= createTestObject("txfOvlyProfessionName", "xpath", "//*[@id='ucProfession_uclProf_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_0']")
	private TestObject txfOvlyCategory				= createTestObject("txfOvlyCategory", "xpath", "//*[@id='ucProfession_uclProf_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_1']")
	private TestObject btnOvlySearchProfesi			= createTestObject("btnOvlySearchProfesi", "xpath", "//*[@id='ucProfession_uclProf_umd_ctl00_ucS_lbSearch']")
	private TestObject btnOvlySelectProfesi			= createTestObject("btnOvlySelectProfesi", "xpath", "//*[@id='ucProfession_uclProf_umd_ctl00_gvL']/tbody/tr[2]/td[3]")
	private TestObject txfOvlyIndustryType			= createTestObject("txfOvlyIndustryType", "xpath", "//*[@id='ucIndustry_uclIndustry_umd_ctl00_ucS_rptFixedSearch_txtSearchValue_3']")
	private TestObject btnOvlySearchIndustry		= createTestObject("btnOvlySearchIndustry", "xpath", "//*[@id='ucIndustry_uclIndustry_umd_ctl00_ucS_lbSearch']")
	private TestObject btnOvlySelectIndustry		= createTestObject("btnOvlySelectIndustry", "xpath", "//*[@id='ucIndustry_uclIndustry_umd_ctl00_gvL_hpSelect_0']")



	private void verifyLandingInJobDataPage() {
		verifyLanding(txfProfessionName, "Job Data")
		WebUI.delay(2)
	}
	private void clickSaveContinue() {
		WebUI.click(btnSaveAndContinue)
		WebUI.takeScreenshot()
	}

	private void selectProfessionName(String professionName) {
		if(professionName) {
			WebUI.click(btnSearchProfessionName)
			WebUI.delay(2)
			WebUI.setText(txfOvlyProfessionName, professionName)
			WebUI.click(btnOvlySearchProfesi)
			WebUI.click(btnOvlySelectProfesi)
			WebUI.delay(2)
		}
	}
	private void inputProfessionNo(String professionNo) {
		safetyInputEdit(txfProfessionNo, professionNo)
//		WebUI.setText(txfProfessionNo, professionNo)
//		WebUI.delay(2)
	}
	private void selectJobPosition(String jobPosition) {
		safetySelectEdit(drpJobPosition, jobPosition)
//		WebUI.selectOptionByLabel(drpJobPosition, jobPosition, false)
//		WebUI.delay(2)
	}
	private void selectJobStatus(String jobStatus) {
		safetySelectEdit(drpJobStatus, jobStatus)
//		if(jobStatus) {
//			WebUI.selectOptionByLabel(drpJobStatus, jobStatus, false)
//			WebUI.delay(2)
//		}
	}
	private void inputCompanyName(String companyName) {
		safetyInputEdit(txfCompanyName, companyName)
//		if(!companyName) {
//			WebUI.setText(txfCompanyName, companyName)
//			WebUI.delay(2)
//		}
	}

	private void chxInternalEmployee(String isInternalEmployee) {
		if(isInternalEmployee?.trim() == "Y" && isInternalEmployee) {
			WebUI.click(chxIsInternalEmployee)
			WebUI.delay(2)
		}
	}

	private void selectIndustryTypeName(String industryType) {
		if(industryType) {
			WebUI.click(btnSearchIndustryType)
			WebUI.delay(2)
			
			WebUI.setText(txfOvlyIndustryType, industryType)
			WebUI.delay(2)
			
			WebUI.click(btnOvlySearchIndustry)
			WebUI.delay(2)
			
			WebUI.click(btnOvlySelectIndustry)
			WebUI.delay(2)
			
		}
	}
	private void selectCompanyScale(String companyScale) {
		safetySelectEdit(drpCompanyScale, companyScale)
//		if(companyScale) {
//			WebUI.selectOptionByLabel(drpCompanyScale, companyScale, false)
//			WebUI.delay(2)
//		}
	}
	private void inputNumberOfEmployee(String numberOfEmployee) {
		safetyInputEdit(txfNumberOfEmployee, numberOfEmployee)
//		if(numberOfEmployee) {
//			WebUI.setText(txfNumberOfEmployee, numberOfEmployee)
//			WebUI.delay(2)
//		}
	}

	private void selectEmploymentEstablishDate(String month, String year) {
		safetySelectEdit(drpEmploymentEstablishDate, month)
		WebUI.delay(2)
		safetyInputEdit(txfEmploymentEstablishDate, year, 0.5)
		
//		if(month && year) {
//			//month
//			WebUI.selectOptionByLabel(drpEmploymentEstablishDate, month, false)
//			WebUI.delay(2)
//			//year
//			WebUI.setText(txfEmploymentEstablishDate, year)
//			WebUI.delay(2)
//		}
	}

	private void checkIsWellKnowCompany(String isWellCompany) {
		if(isWellCompany == '1') {
			WebUI.click(chxIsWellCompany)
			WebUI.delay(2)
		}else if(isWellCompany) {
			safetyClick(chxIsWellCompany)
		}
	}

	private void inputPrevCompanyName(String prevCompanyName) {
		safetyInputEdit(txfPrevCompanyName, prevCompanyName)
//		if(prevCompanyName) {
//			WebUI.setText(txfPrevCompanyName, prevCompanyName)
//			WebUI.delay(2)
//		}
	}
	
	private void selectPrevCompanyDate(String month, String year) {
		WebUI.delay(2)
		safetySelectEdit(drpPrevEmploymentDate, month)
		WebUI.delay(2)
		safetyInputEdit(txfPrevEmploymentDate, year, 0.5)
		
//		if(month && year) {
//			//month
//			WebUI.selectOptionByLabel(drpPrevEmploymentDate, month, false)
//			WebUI.delay(2)
//			//year
//			WebUI.setText(txfPrevEmploymentDate, year)
//			WebUI.delay(2)
//		}
	}

	private void inputOtherBussinessName(String bussinessName) {
		safetyInputEdit(txfOtherBussinessName, bussinessName)
//		if(bussinessName) {
//			WebUI.setText(txfOtherBussinessName, bussinessName)
//			WebUI.delay(2)
//		}
	}
	private void inputOtherBussinessType(String bussinessType) {
		safetyInputEdit(txfOtherBussinessType, bussinessType)
//		if(bussinessType) {
//			WebUI.setText(txfOtherBussinessType, bussinessType)
//			WebUI.delay(2)
//		}
	}
	private void inputOtherJobPosition(String jobPosition) {
		safetyInputEdit(txfOtherJobPosition, jobPosition)
//		if(jobPosition) {
//			WebUI.setText(txfOtherJobPosition, jobPosition)
//			WebUI.delay(2)
//		}
	}

	private void selectOtherCompanyEstablishDate(String month, String year) {
		WebUI.delay(2)
		safetySelectEdit(drpOtherEstablishDate, month)
		WebUI.delay(2)
		safetyInputEdit(txfOtherEstablishDate, year, 0.5)
		
//		if(month && year) {
//			//month
//			WebUI.selectOptionByLabel(drpOtherEstablishDate, drpOtherEstablishDate, false)
//			WebUI.delay(2)
//			//year
//			WebUI.setText(txfOtherEstablishDate, year)
//			WebUI.delay(2)
//		}
	}
	private void selectInvestmentType(String investmentType) {
		if(investmentType) {
			TestObject chxSelected = createTestObject("chxSelected", "xpath", "//label[normalize-space(text())='$investmentType']/preceding-sibling::input[@type='radio']")
			WebUI.click(chxSelected)
			WebUI.delay(2)
		}
	}
}
