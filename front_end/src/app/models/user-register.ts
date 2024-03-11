export class UserRegister {
    private fullName: string;
    private email: string;
    private address: string;
    private username: string;
    private password: string;

    constructor(
        fullName: string,
        email: string,
        address: string,
        username: string,
        password: string
    ) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    setUsername(username: string) {
        this.username = username;
    }

    setPassword(password: string) {
        this.password = password;
    }
}
