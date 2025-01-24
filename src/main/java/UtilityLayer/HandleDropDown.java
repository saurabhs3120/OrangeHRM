package UtilityLayer;

import java.util.List;

import org.openqa.selenium.WebElement;

import BaseLayer.BaseClass;

public class HandleDropDown extends BaseClass{

	
	public static void selectDropDownValue(List<WebElement> list, String value)
	{
		
		for(WebElement wb: list)
		{
			String actualValue = wb.getText();
			
			if(actualValue.contains(value))
			{
				WebElementUtils.click(wb);
				break;
			}
		}
	}
	
}
