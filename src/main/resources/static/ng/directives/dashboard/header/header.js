angular.module('walkingApp')
    .directive('headerDashboard', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl:  "ng/directives/dashboard/header/header.tmpl.html",
            controller: function($scope, $state, $window, $location) {
              
              
          
            }

        };
    }]);