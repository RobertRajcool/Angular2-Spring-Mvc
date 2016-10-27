/**
 * Created by robert on 26/10/16.
 */
import {Component,OnInit} from '@angular/core'
import {userModel} from "../models/userModel";
import {Http, Headers} from '@angular/http'
import 'rxjs/add/operator/toPromise';

@Component({
    selector:'user-app',
    templateUrl:'../app/templates/user.html',
})
export class userComponet implements OnInit{
    private headers=new Headers({'Content-Type': 'application/json'});
    public user: userModel;
    private apiUrl='';
    userlist:userModel[]=[];
    public  statusOptions;
    ngOnInit():void {
        this.getUserlist().then(
            userlist=>this.userlist=userlist
        )

    }
    constructor(private http:Http){

    }
    save(model: userModel, isValid: boolean) {
        this.apiUrl="http://localhost:8080/customers";
        return this.http
            .post(this.apiUrl,model,{headers:this.headers})
            .toPromise()
            .then(res=>{
                console.log(res);
                this.user=null
                this.getUserlist().then(
                    userlist=>this.userlist=userlist
                )
                console.log(this.user);
            })
            .catch(this.handleError);
        // call API to save customer
    }
    update(model: userModel, isValid: boolean) {
        this.apiUrl="http://localhost:8080/customers";
        return this.http
            .put(this.apiUrl,model,{headers:this.headers})
            .toPromise()
            .then(res=>{
                console.log(res);
                this.user=null
                this.getUserlist().then(
                    userlist=>this.userlist=userlist
                )
                console.log(this.user);
            })
            .catch(this.handleError);

    }
    getUserlist():Promise<userModel[]>
    {
        this.apiUrl="http://localhost:8080/customers";
        return this.http.get(this.apiUrl).toPromise()
            .then(response=>response.json() as userModel[])
            .catch(this.handleError)
    }
    testBackend(){
        return this.http.get("http://localhost:8080/countries")
            .toPromise()
            .then(response=>{console.log(response)})
            .catch(this.handleError)
    }
    addUser(){
        this.statusOptions=true;
        this.user={
            id:0,
            username:'',
            password:'',
            email:'',
            confirmPassword:''
        }
    }
    getUserbyId(id:number){
        console.log(id);
        this.statusOptions=null;
        this.apiUrl="http://localhost:8080/customers/"+id;
        return this.http.get(this.apiUrl)
            .toPromise()
            .then(res=>{
                var result=res.json();
                this.user={
                    id:result.id,
                    username:result.username,
                    password:result.password,
                    email:result.email,
                    confirmPassword:result.confirmPassword
                }
            })
            .catch(this.handleError)

    }
    Delete(id:number){
        console.log(id);
        this.apiUrl="http://localhost:8080/customers/"+id;
        return this.http.delete(this.apiUrl)
            .toPromise()
            .then(res=>{
                console.log(res);
                this.user=null
                this.getUserlist().then(
                    userlist=>this.userlist=userlist
                )
                console.log(this.user);
            })
            .catch(this.handleError)

    }
    private handleError(error:any){
        console.log(error);
        return Promise.reject(error.message|| error);

    }
}

