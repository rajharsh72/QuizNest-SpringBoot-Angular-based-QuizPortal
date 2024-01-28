import { HTTP_INTERCEPTORS, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { UserLoginService } from "./user-login.service";

const TOKEN_HEADER = "Authorization";

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor(
        private _loginService:UserLoginService
    ){}
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
        let authRequest = req;
        //add jwtToken to the HttpHeader
        const token = this._loginService.getToken();
        if(token!=null){
            authRequest = authRequest.clone({setHeaders:{TOKEN_HEADER:`Bearer ${token}`}});
        }

        return next.handle(authRequest);
    }

}

export const authInterceptorProviders=[
    {
    provide : HTTP_INTERCEPTORS,
    useClass : AuthInterceptor,
    multi: true,
    },
];