'use strict';



var app = angular
  .module('walkingApp', [
    'oc.lazyLoad',
    'ui.router',
    'ui.bootstrap',
    'angular-loading-bar',
    'ngSanitize',
    
  ])
  .config(['$stateProvider','$urlRouterProvider','$ocLazyLoadProvider','$httpProvider',
           function ($stateProvider,$urlRouterProvider,$ocLazyLoadProvider,$httpProvider) {
	
	
	
    
    $ocLazyLoadProvider.config({
      debug:false,
      events:true,
    });

    $urlRouterProvider.otherwise('/dashboard/userPlans');

    $stateProvider
      .state('dashboard', {
        url:'/dashboard',
        templateUrl: 'ng/dashboard/main.html',
        resolve: {
            loadMyDirectives:function($ocLazyLoad){
                return $ocLazyLoad.load(
                {
                    name:'walkingApp',
                    files:[
                   
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
      .state('dashboard.home',{
        url:'/home',
        controller: 'MainCtrl',
        templateUrl:'ng/dashboard/home.html',
        resolve: {
          loadMyFiles:function($ocLazyLoad) {
            return $ocLazyLoad.load({
              name:'walkingApp',
              files:[
              'ng/controllers/main.js',
             
              ]
            })
          }
        }
      })
       .state('dashboard.blank',{
        templateUrl:'ng/pages/blank.html',
        url:'/blank'
    })
      .state('login',{
        templateUrl:'ng/login/login.html',
        url:'/login'
    });
   $httpProvider.interceptors.push('TokenInterceptor');
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