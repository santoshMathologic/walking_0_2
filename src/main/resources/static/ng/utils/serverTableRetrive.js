/**
 * 
 */
'use strict';

var serverTableRetrive = function(url,httpServices,callBackBefore,
	    callBackAfter, callBackAfterError) {
	
	this.url = url;
	this.urlValue = url;
	this.httpServices = httpServices;
	this.callBackBefore = callBackBefore;
	this.callBackAfter = callBackAfter;
	this.callBackAfterError = callBackAfterError;
	
	this.serverTableProcess = function(tableState){
		
		this.callBackBefore("CAllBACK BEFORE");
		if(angular.isFunction(this.url)){
			this.urlValue = this.url(tableState);
		} 
		
		if(this.urlValue == ''){
			this.callBackAfterError("no Fetch");
			return;
		}
		
		console.log(tableState);
		
	tableState.start = tableState.pagination.start || 0;
	tableState.number = tableState.pagination.number || 10;
	
	
	httpServices.get(url)
	.then(function(response){
		  tableState.pagination.numberOfPages = response.data.totalPages+1; // As the total pages is start from 0
		  tableState.pagination.totalItemCount = response.data.totalElements;
		  
		  var resultObj = response.data.content;
        //  tableState.pagination.numberOfPages = response.data.last;
         // tableState.pagination.totalItemCount = response.data.count;
          resultObj.tableState = tableState;
          this.callBackAfter(resultObj);
		  
		
	}.bind(this),
	function(response){
		if (this.callBackAfterError) {
            this.callBackAfterError(response);
        }
		
	}.bind(this));
	
	}.bind(this);
	

	
};

serverTableRetrive.prototype = {
		url : null,
		httpServices : null
		
	};
