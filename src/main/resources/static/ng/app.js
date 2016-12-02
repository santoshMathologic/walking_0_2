'use strict';


var api={
		 protocol: 'http',
		 server: 'localhost',
		 port: 6060,
		 baseUrl: '/api/v1',
		 loginUrl: '/login',
		 registrationUrl:'/registration'
}

var apiUrl = api.protocol + '://' + api.server + ':' + api.port + api.baseUrl;
var apiLoginUrl = api.protocol + '://' + api.server + ':' + api.port +api.baseUrl+api.loginUrl;
var apiRegistrationUrl = api.protocol + '://' + api.server + ':' + api.port + api.registrationUrl;

var app = angular
  .module('walkingApp', [
    'oc.lazyLoad',
    'ui.router',
    'ui.bootstrap',
    'angular-loading-bar',
    'ngSanitize',
    'smart-table',
    'toaster',
    'ngAnimate',
    'ngCookies',
    'base64'
    
  ])
  .config(['$stateProvider','$urlRouterProvider','$ocLazyLoadProvider','$httpProvider',
           function ($stateProvider,$urlRouterProvider,$ocLazyLoadProvider,$httpProvider) {
	
	
	
    
    $ocLazyLoadProvider.config({
      debug:false,
      events:true,
    });

   // $urlRouterProvider.otherwise('/home/dashboard');
    $urlRouterProvider.otherwise('/login');
    $stateProvider
      .state('home', {
        url:'/home',
        templateUrl:'ng/directives/home/home.directive.html',
        resolve: {
            loadMyDirectives:function($ocLazyLoad){
                return $ocLazyLoad.load(
                {
                    name:'walkingApp',
                    files:[
                           'ng/directives/home/home.js',
                          
                   
                    ]
                }),
                $ocLazyLoad.load(
                {
                   name:'toggle-switch',
                   files:["bower_components/angular-toggle-switch/angular-toggle-switch.min.js",
                          "bower_components/angular-toggle-switch/angular-toggle-switch.css"
                      ]
                }),
                $ocLazyLoad.load(
                {
                  name:'ngAnimate',
                  files:['bower_components/angular-animate/angular-animate.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngCookies',
                  files:['bower_components/angular-cookies/angular-cookies.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngResource',
                  files:['bower_components/angular-resource/angular-resource.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngSanitize',
                  files:['bower_components/angular-sanitize/angular-sanitize.js']
                })
                $ocLazyLoad.load(
                {
                  name:'ngTouch',
                  files:['bower_components/angular-touch/angular-touch.js']
                })
            }
        }
    })
      .state('home.dashboard',{
        url:'/dashboard',
        controller: 'MainCtrl',
        templateUrl:'ng/directives/dashboard/dashboard.directive.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'walkingApp',
              files:[
              'ng/directives/dashboard/dashboard.js',
              'ng/directives/dashboard/header/header.js',
              'ng/directives/dashboard/sidebar/sidebar.js',
              'ng/controllers/main.js',
              'ng/utils/customConverter.js',
              
              ]
            })
          }
        }
      })
       .state('home.dashboard.blank',{
        templateUrl:'ng/directives/dashboard/blank/blank.directive.html',
        controller: 'blankCtrl',
        url:'/blank',
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkingApp',
                files:[
                       "ng/directives/dashboard/blank/blank.js",
                       "ng/controllers/blank.js",
                       'ng/directives/dashboard/stats/stats.js'
                ]
              })
            }
          }
    }) .state('home.dashboard.company',{
        templateUrl:'ng/directives/dashboard/company/company.directive.html',
        controller: 'companyCtrl',
        url:'/company',
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkingApp',
                files:[
                       "ng/directives/dashboard/company/company.js",
                       "ng/controllers/company.js",
                       "ng/utils/serverTableRetrive.js"

                       
                ]
              })
            }
          }
    }).state('home.dashboard.walking',{
        templateUrl:'ng/directives/dashboard/walking/walking.directive.html',
        controller: 'walkingCtrl',
        url:'/walking',
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkingApp',
                files:[
                       "ng/directives/dashboard/walking/walking.js",
                       "ng/controllers/walking.js",
                       "ng/utils/serverTableRetrive.js"

                       
                ]
              })
            }
          }
    })
      .state('login',{
        templateUrl:'ng/login/login.html',
        url:'/login',
        controller:"loginCtrl",
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkingApp',
                files:[
                       "ng/login/login.js",
                       'ng/factory/AuthenticationFactory.js',
                       'ng/factory/UserAuthFactory.js',
                       'ng/factory/TokenInterceptor.js',
                       'ng/customdirective/confirm.js'
                 ]
              })
            }
          }
    }).state('registration',{
        templateUrl:'ng/registration/registration.directive.html',
        url:'/registration',
        controller:"registrationCtrl",
        resolve: {
            loadMyFiles:function($ocLazyLoad) {
              return $ocLazyLoad.load({
                name:'walkingApp',
                files:[
                       "ng/registration/registration.js",
                       "ng/controllers/registration.js"
                       
                 ]
              })
            }
          }
    });
   
  }]);

app.filter('toArray', function() { return function(obj) {
    if (!(obj instanceof Object)) return obj;
    var result = [];
	for(var i =0; i<Object.keys(obj).length ;i++){
		for(var item in obj){
			if(obj[item] == i){
				result.push(item);
			}
		}
	}
	return result;
}});