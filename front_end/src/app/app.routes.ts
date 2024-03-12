import { Routes } from '@angular/router';
import { TestComponent } from './test/testcustomer/test.component';
import { TestDeviceComponent } from './test/testdevice/testdevice.component';
import { TestphonelineComponent } from './test/testphoneline/testphoneline.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './pages/home/home.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'register',
        component: RegisterComponent
    },
    {
        path: 'customers/:custId',
        component: DashboardComponent
    }
    
    // ,
    // {
    //     path: 'test',
    //     component: TestComponent
    // },
    // {
    //     path: 'testdevice',
    //     component: TestDeviceComponent
    // },
    // {
    //     path: 'testphoneline',
    //     component: TestphonelineComponent
    // }

];
