package com.steave.listeners;

import com.steave.constants.FrameWorkConstants;
import com.steave.utils.ExcelDataUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor{

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context){

        Map<String,String>[] listOfTests = ExcelDataUtils.getExcelData( FrameWorkConstants.getExceldatapath(), FrameWorkConstants.getRunManager() );

        List<IMethodInstance> result = new ArrayList<>();

        for (IMethodInstance method : methods) {
            for (Map<String, String> listOfTest : listOfTests) {
                if (method.getMethod().getMethodName().equalsIgnoreCase( listOfTest.get( "testname" ) ) && listOfTest.get( "execute" ).equalsIgnoreCase( "yes" ) ) {
                    method.getMethod().setInvocationCount( Integer.parseInt( listOfTest.get( "count" ) ) );
                    method.getMethod().setPriority( Integer.parseInt( listOfTest.get( "priority" ) ) );
                    result.add( method );
                }
            }
        }
        return result;
    }
}
