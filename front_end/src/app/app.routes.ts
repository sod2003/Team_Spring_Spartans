import { Routes } from '@angular/router';
import { TestComponent } from './test/test.component';
import { TestDeviceComponent } from './test/testdevice/testdevice.component';
import { TestphonelineComponent } from './test/testphoneline/testphoneline.component';
<<<<<<< HEAD
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },

    // {
    //     path: 'devices',
    //     component: DevicesComponent
    // },
=======
import { DevicesComponent } from './components/devices/devices.component';
import { PhonePlansComponent } from './components/phone-plans/phone-plans.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';

export const routes: Routes = [
    {
        path: 'customers/:custId',
        component: DashboardComponent
    }
    
    // ,
>>>>>>> 82d0e70 (Created PhonePlans Get All List component)
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
