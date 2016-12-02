/**
 * 
 */

'use strict';
var app = angular.module("walkingApp").service('confirmService',function($window,$modal){
	
	 var service = {};
	 
	 service.open  = function(text, onOk){
		 
		 var modalInstance = $modal.open({
		   templateUrl:"ng/customdirective/loginalert.html",
			 controller:function($scope, $modalInstance, text){
				  $scope.text = text;
				  $scope.ok = function () {
				    $modalInstance.close(true);
				  };

				  $scope.cancel = function () {
				    $modalInstance.dismiss('cancel');
				  };
				 
			 },
			 resolve:{
				  text:function(){
					  return text; 
				  }
			   }  			 
		   });
		 
		 modalInstance.result.then(function (selectedItem) {
		       onOk();
		      }, function () {
		    });
		 
	 }
	return service	
});
