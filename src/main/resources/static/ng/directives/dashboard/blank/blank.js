angular.module('walkingApp')
    .directive('blank', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl:  "ng/directives/dashboard/blank/blank.tmpl.html",
            controller: function($scope, $state, $window, $location) {
              
              
          
            }

        };
    }]);