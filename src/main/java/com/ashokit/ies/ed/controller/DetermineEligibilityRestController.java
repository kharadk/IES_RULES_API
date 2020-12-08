package com.ashokit.ies.ed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.ies.ed.bindings.IndvInfo;
import com.ashokit.ies.ed.bindings.PlanInfo;
import com.ashokit.ies.ed.service.DetermineEligibilityService;

@RestController
public class DetermineEligibilityRestController {

	@Autowired
	private DetermineEligibilityService eligService;

	@PostMapping(value = "/determineElig", produces = { "application/xml", "application/json" }, consumes = {
			"application/xml", "application/json" })
	public PlanInfo checkPlanEligibility(@RequestBody IndvInfo indvInfo) {

		PlanInfo planInfo = eligService.determineEligibility(indvInfo);
		return planInfo;
	}
}