export class Customer {
    custId: number;
    name: string;
    address: string;
    email: string;

    constructor(custId: number,
                name: string,
                address: string,
                email: string) {
        this.custId = custId;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    getCustId() {
        return this.custId;
    }
}
