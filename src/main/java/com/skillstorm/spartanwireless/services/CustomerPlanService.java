package com.skillstorm.spartanwireless.services;

public interface CustomerPlanService {

    Object createCustomerPlan(Long custId, Long phonePlanId);

    // TODO Create CustomerPlanService to remove PhonePlan logic from CustomerPlan Logic

}
