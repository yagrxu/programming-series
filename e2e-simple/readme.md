From junior Developer to the Full stack expert

# Class 1 - create a demo application to know e2e

As I have very limited knowledge about angular and also mybatis, so it is fair to say that I am a beginner for both angular and mybatis.

I challenged myself to write a basic e2e app locally using angular and mybatis to show that you should be able to work on new things in short period.

This is actually also the interview practice that the candidate should spend 45 minutes on coding demo application to show his knowledge on spring + mybatis and also angular.

## Java backend springboot app in 35 minutes

For writing the java application, you first need to know how to [start with springboot](https://start.spring.io/) (To be honest, springboot should be the easiest framework in the world).

Then you should know how to expose an API using SpringMVC @RestController

Afterwards, configure MySQL connection in Springboot properties file "spring.datasource.*" sector

Finally prepare a model and mapper for getting data from mySQL database.

## Typescript angular web app in 25 minutes

Then you can use  ```ng new``` command for generate a new angular web application.
As the demo is super simple, you do not need to create another component for navigation.

Instead, directly add the content below in component html
``` html
<span>hello</span>
<div>
  <li *ngFor="let person of persons">
    {{person.firstName}}.{{person.lastName}}
  </li>
</div>
```

Also define the how to get content code in the app.component.ts
``` typescript
  constructor(private http: HttpClient) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Access-Control-Allow-Origin': 'localhost'
      })
    };
    const that: any = this;
    this.http.get(environment.apiUrl, httpOptions).subscribe((res) => {
      that.persons = res;
      console.log(that.persons);
    });
  }
```

Finally, if you start those 2 apps locally and connected to the remote database, you can see the person first name and last names are loaded in the web application properly.

# Class 2 prepare dockerfile for java and angular application

## 2.1 prepare Dockerfile
Prepare docker [using maven plugins](https://spring.io/guides/gs/spring-boot-docker/) for Java application

add the following for angular application ref from [web page "dockerizing-an-angular-app"](https://mherman.org/blog/dockerizing-an-angular-app/)
``` dockerfile
# base image
FROM node:12.2.0

# install chrome for protractor tests
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
RUN apt-get update && apt-get install -yq google-chrome-stable

# set working directory
WORKDIR /app

# add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# install and cache app dependencies
COPY package.json /app/package.json
RUN npm install
RUN npm install -g @angular/cli@7.3.9

# add app
COPY . /app

# expose port 4200
EXPOSE 4200

# start app
CMD ng serve --host 0.0.0.0 --proxy-config proxy.conf.json

```


## 2.2 Introduce profile concept in both demo
For UI, we can change the API of backend forwarding in the following way:

create environment.local.ts and add the following
``` typescript
export const environment = {
  production: true,
  apiUrl: 'http://localhost:8080/api/'
};
```
``` console
ng serve --configuration=local
```

## 2.3 make the docker push
You need to push the docker images into container registry
docker login --username=<master.email> registry-intl.eu-central-1.aliyuncs.com
docker tag <image.id> registry-intl.eu-central-1.aliyuncs.com/yagr-demo/demo-ui:<version>

# Class 3 prepare k8s yaml files
Each micro service requires minimum 2 replicas and a server load balancer.

