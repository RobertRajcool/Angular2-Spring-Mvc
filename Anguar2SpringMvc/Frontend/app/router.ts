/**
 * Created by robert on 26/10/16.
 */
import {Routes,RouterModule} from '@angular/router'
import {ModuleWithProviders} from '@angular/core';
import {rootComponet} from "./appComponet";
import {userComponet} from "./componets/userComponet";
const appRoutes:Routes=[
    {
        path:'',
        component:userComponet
    },
    {
        path:'root',
        component:rootComponet
    },
    {
        path:'',
        redirectTo:'/',
        pathMatch:'full'
    }

]
export const routing:ModuleWithProviders=RouterModule.forRoot(appRoutes);
