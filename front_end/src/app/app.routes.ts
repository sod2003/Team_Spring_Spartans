import { Routes } from '@angular/router';
import { TestComponent } from './test/test.component';
import { TestDeviceComponent } from './test/testdevice/testdevice.component';
import { TestphonelineComponent } from './test/testphoneline/testphoneline.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    
    {
        path: 'test',
        component: TestComponent
    },
    {
        path: 'testdevice',
        component: TestDeviceComponent
    },
    {
        path: 'testphoneline',
        component: TestphonelineComponent
    }

];
