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
		
		//console.log(tableState);
		
		var pagination = tableState.pagination;
		var page = (pagination.start/pagination.number) || 0; 
		var size = pagination.number || 10;  
	
	var sort = (tableState.sort.predicate)?tableState.sort.predicate:"";
	var sortDir = (tableState.sort.reverse)?"asc":"desc";
	
	var searchParamValues = "";
	var searchParamsList = [];
	var searchParamsListObj= {
			
	}
	if(tableState.search.predicateObject){	
		for(var searchItem in tableState.search.predicateObject){
				searchParamValues = tableState.search.predicateObject[searchItem];
				searchParamsListObj[searchItem]= searchParamValues;
				searchParamsList.push(searchParamsListObj);
			
		}
	}
	
	

	  
	var query = {
			sort : (sort)?sort:"",
			sortDir : sortDir,
			limit : size,
			page : page,
			searchcriteria  : searchParamsList
	}
	
	
	
	
	
	
	
	httpServices.get(url,{params:query})
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
