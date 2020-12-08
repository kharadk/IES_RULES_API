package com.ashokit.ies.ed.service;

import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import com.ashokit.ies.ed.bindings.IndvInfo;
import com.ashokit.ies.ed.bindings.PlanInfo;

@Service
public class DetermineEligibilityService {

	public PlanInfo determineEligibility(IndvInfo indvInfo) {
		String planName = indvInfo.getPlanName();
		String clzName = "com.ashokit.ies.ed.service."+planName+"RulesExecutor";
		PlanInfo planInfo = null;
		try {
			
			
			Class<?> clz = Class.forName(clzName);
			
			Method method = clz.getDeclaredMethod("executeRules", IndvInfo.class);
			
			Object object = clz.newInstance();
			
			
			
			planInfo =  (PlanInfo) method.invoke(object, indvInfo);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return planInfo;
	}
}
