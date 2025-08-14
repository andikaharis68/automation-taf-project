package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object WEB_URL
     
    /**
     * <p>Profile default : true : to close, false : dont close browser</p>
     */
    public static Object IS_CLOSE_BROWSER
     
    /**
     * <p></p>
     */
    public static Object TEST_DATA_LOCATION
     
    /**
     * <p>Profile default : This Var is for using same excel files with diff Test Cases</p>
     */
    public static Object TEST_DATA
     
    /**
     * <p></p>
     */
    public static Object TEST_CASE_NAME
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters(), selectedVariables)
    
            WEB_URL = selectedVariables['WEB_URL']
            IS_CLOSE_BROWSER = selectedVariables['IS_CLOSE_BROWSER']
            TEST_DATA_LOCATION = selectedVariables['TEST_DATA_LOCATION']
            TEST_DATA = selectedVariables['TEST_DATA']
            TEST_CASE_NAME = selectedVariables['TEST_CASE_NAME']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
