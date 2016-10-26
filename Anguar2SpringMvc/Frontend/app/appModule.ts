/**
 * Created by robert on 26/10/16.
 */
/**
 * Created by robert on 7/10/16.
 */
import {NgModule} from '@angular/core';
import {routing} from './router'
import {BrowserModule} from '@angular/platform-browser';
import {HttpModule} from '@angular/http'
import {rootComponet} from "./appComponet";
import {userComponet} from "./componets/userComponet";
import {FormsModule} from "@angular/forms";
import {EqualValidator} from "./directives/uservalidators";
@NgModule({
    imports:[BrowserModule,HttpModule,routing,FormsModule],
    declarations:[rootComponet,userComponet,EqualValidator],
    bootstrap:[rootComponet]

})

export class appModule{

}