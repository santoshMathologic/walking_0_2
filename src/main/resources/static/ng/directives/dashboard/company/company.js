angular.module('walkingApp')
    .directive('company', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl:  "ng/directives/dashboard/company/company.tmpl.html",
            controller: function($scope, $state, $window, $location) {
              
              
          
            }

        };
    }]);