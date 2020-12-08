package com.ashokit.ies.ed.service;

import com.ashokit.ies.ed.bindings.IndvInfo;
import com.ashokit.ies.ed.bindings.PlanInfo;

public interface IRuleService {

	public PlanInfo executeRules(IndvInfo indvInfo);

}