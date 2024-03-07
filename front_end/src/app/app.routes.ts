import { Routes } from '@angular/router';
import { TestComponent } from './test/test.component';
import { TestDeviceComponent } from './test/testdevice/testdevice.component';
import { TestphonelineComponent } from './test/testphoneline/testphoneline.component';

export const routes: Routes = [
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
