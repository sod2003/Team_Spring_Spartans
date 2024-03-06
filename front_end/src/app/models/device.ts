
export class Device {

    deviceId: number | 0;
    name: string;
    brand: string;
    price: number;

    constructor(deviceId: number,
                name: string,
                brand: string,
                price: number) {

        this.deviceId = deviceId;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    setDeviceId(deviceId: number) {
        this.deviceId = deviceId;
    }

}
