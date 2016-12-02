/**
 * 
 */

'use strict';
angular.module("walkingApp").directive('confirm', ['$compile','ConfirmService', function($compile,ConfirmService)  {
    return {
        restrict: 'A',
        scope: {
            eventHandler: '&ngClick'
        },
        link: function(scope, element, attrs){
          element.unbind("click");
          element.bind("click", function(e) {
             ConfirmService.open(attrs.confirm, scope.eventHandler);
          });
        }
    }
}]);