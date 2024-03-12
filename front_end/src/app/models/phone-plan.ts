export class PhonePlan {

    phonePlanId: number;
    phoneLines: number;
    dataLimit: number;
    cost: number;

    constructor(
        phonePlanId: number,
        phoneLines: number,
        dataLimit: number,
        cost: number
    ) {
        this.phonePlanId = phonePlanId;
        this.phoneLines = phoneLines;
        this.dataLimit = dataLimit;
        this.cost = cost;
    }
}
