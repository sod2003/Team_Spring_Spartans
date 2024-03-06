import { Customer } from "./customer";
import { Device } from "./device";

export class Phoneline {
    phoneNumber: string;
    device: Device;

    constructor(phoneNumber: string,
                device: Device) {
        this.phoneNumber = phoneNumber;
        this.device = device;
    }
}
