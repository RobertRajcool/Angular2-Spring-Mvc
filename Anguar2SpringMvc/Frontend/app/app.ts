/**
 * Created by robert on 26/10/16.
 */
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {appModule} from './appModule';
const platform=platformBrowserDynamic();
platform.bootstrapModule(appModule);