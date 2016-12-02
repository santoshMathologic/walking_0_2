angular.module('walkingApp')
    .directive('registration', ['$compile', function($compile) {
        return {
            restrict: 'E',
            templateUrl:  "ng/registration/registration.tmpl.html",
            controller: function($scope, $state, $window, $location) {
              
              
          
            }

        };
    }]);