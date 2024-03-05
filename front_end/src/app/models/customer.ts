export class Customer {
    custId: string;
    name: string;
    address: string;
    email: string;

    constructor(custId: string,
                name: string,
                address: string,
                email: string) {
        this.custId = custId;
        this.name = name;
        this.address = address;
        this.email = email;
    }
}
